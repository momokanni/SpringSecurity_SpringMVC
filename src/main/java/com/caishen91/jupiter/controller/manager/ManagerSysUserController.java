package com.caishen91.jupiter.controller.manager;

import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.enums.SysDepartment;
import com.caishen91.jupiter.model.SysPermit;
import com.caishen91.jupiter.model.SysRole;
import com.caishen91.jupiter.model.SysUser;
import com.caishen91.jupiter.model.SysUserPermit;
import com.caishen91.jupiter.service.ISysPermitService;
import com.caishen91.jupiter.service.ISysRoleService;
import com.caishen91.jupiter.service.ISysUserService;
import com.caishen91.jupiter.service.impl.ISysUserPermitService;
import com.caishen91.jupiter.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequestMapping("/manager/sysuser")
@Controller
public class ManagerSysUserController {

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ISysRoleService sysRoleService;

    @Autowired
    private ISysUserPermitService sysUserPermitService;

    @Autowired
    private ISysPermitService sysPermitService;

    @Autowired
    private HttpServletRequest request;

    @ModelAttribute
    private void init() {
        SysUser sysUser = LoginUtil.getSysLoginUser(request, null);
        sysUserService.setSysUserId(sysUser.getId());
        sysUserPermitService.setSysUserId(sysUser.getId());
    }

    @RequestMapping("/toSysUserManager")
    public String toAccountManager(HttpServletResponse response) {
        SysUser sysUser = LoginUtil.getSysLoginUser(request, response);
        if (null == sysUser) {
            return "/manager/login";
        }
        return "/manager/manager/sysUserManager";
    }

    @RequestMapping("/querySysUserListByParam")
    @ResponseBody
    public Map<String, Object> querySysUserListByParam(
            @RequestParam(defaultValue = "0", required = false) String pageNo,
            @RequestParam(defaultValue = "10", required = false) String perPageNo,
            String loginName) {

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("loginName", loginName);

        try {
            int pageNoInt = Integer.parseInt(pageNo);
            int perPageNoInt = Integer.parseInt(perPageNo);
            int offset = (pageNoInt - 1) * perPageNoInt;
            paramMap.put("offset", offset);
            paramMap.put("pageSize", perPageNoInt);
        } catch (Exception e) {
            e.printStackTrace();
            paramMap.put("offset", 0);
            paramMap.put("pageSize", 10);
        }

        int count = sysUserService.getTotalDeptUsersByParam(paramMap);
        List<SysUser> sysUsers = null;
        if (count > 0) {
            sysUsers = sysUserService.getDeptUsersByParam(paramMap);
        }

        Map<String, Object> retMap = new HashMap<>();
        retMap.put(Config.RET, Config.RET_OK);

        if (null != sysUsers && sysUsers.size() > 0) {
            List<Map<String, Object>> listResultMap = new ArrayList<>();
            for (SysUser sysUser : sysUsers) {
                Map<String, Object> resultMap = new HashMap<>();

                String sysUserIdStr = IDEncryptor.getInstance().encryptWithoutException(sysUser.getId());
                resultMap.put("loginName", sysUser.getLoginName());
                resultMap.put("mobile", sysUser.getMobile());
                resultMap.put("email", sysUser.getEmail());
                resultMap.put("registerTime", DateUtil.formatDate(sysUser.getRegisterTime(), "yyyy-MM-dd HH:mm:ss"));
                resultMap.put("status", SysUser.SysuserStatus.getSysuserStatus(sysUser.getStatus()).getDesc());
                SysRole sysRole = sysRoleService.getSysRoleById(sysUser.getRoleId());
                if (null != sysRole) {
                    resultMap.put("companyName", SysDepartment.getSysDepartment(sysRole.getDepartment()).getDesc());
                    resultMap.put("roleName", sysRole.getRoleName());
                }

                List<Action> actions = new ArrayList<Action>();

                Action detailAction = ActionFactory.build(ActionFactory.CATEGORY_LOOK, "", "",
                        ActionFactory.OPTYPE_SCRIPT, "/manager/sysuser/getSysUserDetailById?id=" + sysUserIdStr, ActionFactory.REQ_TYPE_DIV, "seeSysUser");
                actions.add(detailAction);

                Action allotAuthAction = ActionFactory.build(ActionFactory.ALLOT_AUTH, "", "",
                        ActionFactory.OPTYPE_SCRIPT, "/manager/sysuser/getSysPermit?id=" + sysUserIdStr, ActionFactory.REQ_TYPE_DIV, "sysUserPermit");
                actions.add(allotAuthAction);

                if (SysUser.SysuserStatus.normal.getStatus() == sysUser.getStatus()) {
                    Action forbiddenAction = ActionFactory.build(ActionFactory.SYSUSER_OFFLINE, "", ActionFactory.TARGET_SELF,
                            ActionFactory.OPTYPE_SCRIPT, "/manager/sysuser/updateSysUserStatus?id=" + sysUserIdStr + "&status=" + SysUser.SysuserStatus.forbidden.getStatus(),
                            ActionFactory.REQ_TYPE_CONFIRM, "");
                    actions.add(forbiddenAction);
                } else if (SysUser.SysuserStatus.forbidden.getStatus() == sysUser.getStatus()) {
                    Action startUsingAction = ActionFactory.build(ActionFactory.SYSUSER_ONLINE, "", ActionFactory.TARGET_SELF,
                            ActionFactory.OPTYPE_SCRIPT, "/manager/sysuser/updateSysUserStatus?id=" + sysUserIdStr + "&status=" + SysUser.SysuserStatus.normal.getStatus(),
                            ActionFactory.REQ_TYPE_CONFIRM, "");
                    actions.add(startUsingAction);
                }

                resultMap.put("opList", actions);
                listResultMap.add(resultMap);
            }

            Map<String, Object> data = new HashMap<>();
            data.put("totalRows", count);
            data.put("nav", "");
            data.put("content", listResultMap);
            retMap.put("data", data);
        } else {
            retMap.put(Config.RET, Config.RET_ERROR);
        }

        return retMap;
    }

    @RequestMapping("/updateSysUserStatus")
    @ResponseBody
    public Map<String, Object> updateSysUserStatus(@RequestParam(value = "id", required = true) String sysUserIdStr,
                                                   @RequestParam(value = "status", required = true) String status) {
        Map<String, Object> retMap = new HashMap<>();
        retMap.put(Config.RET, Config.RET_OK);

        int sysUserId = IDEncryptor.getInstance().decryptWithoutException(sysUserIdStr);
        SysUser sysUser = sysUserService.getUserById(sysUserId);
        if (null == sysUser) {
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "该账户不存在");
            return  retMap;
        } else if (String.valueOf(sysUser.getStatus()).equals(status)) {
            retMap.put(Config.RET, Config.RET_OK);
            return retMap;
        }

        try {
            sysUserService.updateSysUserStatus(sysUserId, status);
        } catch (Exception e) {
            e.printStackTrace();
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "修改失败");
        }

        return retMap;
    }

    @RequestMapping("/getSysUserDetailById")
    @ResponseBody
    public Map<String, Object> getSysUserDetailById(@RequestParam(value = "id") String sysUserIdStr) {
        Map<String, Object> retMap = new HashMap<>();
        retMap.put(Config.RET, Config.RET_OK);

        int sysUserId = IDEncryptor.getInstance().decryptWithoutException(sysUserIdStr);
        SysUser sysUser = sysUserService.getUserById(sysUserId);

        if (null != sysUser) {
            Map<Object, Object> dataMap = new HashMap<>();
            dataMap.put("id", IDEncryptor.getInstance().encryptWithoutException(sysUser.getId()));
            dataMap.put("name", sysUser.getName());
            dataMap.put("sex", sysUser.getSex());
            dataMap.put("mobile", sysUser.getMobile());
            dataMap.put("email", sysUser.getEmail());
            dataMap.put("loginName", sysUser.getLoginName());
            dataMap.put("password", "......");
            SysRole sysRole = sysRoleService.getSysRoleById(sysUser.getRoleId());
            if (null != sysRole) {
                dataMap.put("department", SysDepartment.getSysDepartment(sysRole.getDepartment()).getDesc());
                dataMap.put("roleName", sysRole.getRoleName());
            }
            SysRole reportSysRole = sysRoleService.getSysRoleById(sysUser.getReportRoleId());
            if (null != reportSysRole) {
                dataMap.put("department", SysDepartment.getSysDepartment(reportSysRole.getDepartment()).getDesc());
                dataMap.put("roleName", reportSysRole.getRoleName());
            }

            dataMap.put("man", SysUser.SysUserSex.man.getSex());
            dataMap.put("manDesc", SysUser.SysUserSex.man.getDesc());
            dataMap.put("woman", SysUser.SysUserSex.woman.getSex());
            dataMap.put("womanDesc", SysUser.SysUserSex.woman.getDesc());

            retMap.put(Config.RET_DATA, dataMap);
        } else {
            retMap.put(Config.RET, Config.RET_ERROR);
        }

        return retMap;
    }

    @RequestMapping("/getDepartmentData")
    @ResponseBody
    public Map<String, Object> getDepartmentData() {
        Map<String, Object> retMap = new HashMap<>();
        retMap.put(Config.RET, Config.RET_OK);

        Map<String, Object> data = new HashMap<>();
        data.put("man", SysUser.SysUserSex.man.getSex());
        data.put("manDesc", SysUser.SysUserSex.man.getDesc());
        data.put("woman", SysUser.SysUserSex.woman.getSex());
        data.put("womanDesc", SysUser.SysUserSex.woman.getDesc());

        List<Map<String, String>> departmentMapList = new ArrayList<>();
        for (SysDepartment department : SysDepartment.values()) {
            Map<String, String> departmentMap = new HashMap<>();
            departmentMap.put("departmentType", department.getType());
            departmentMap.put("departmentDesc", department.getDesc());
            departmentMapList.add(departmentMap);
        }

        data.put("department", departmentMapList);
        retMap.put(Config.RET_DATA, data);

        return retMap;
    }

    @RequestMapping("/getLoginNameByName")
    @ResponseBody
    public Map<String, Object> getLoginNameByName(String name) {
        Map<String, Object> retMap = new HashMap<>();
        retMap.put(Config.RET, Config.RET_OK);

        if (StringUtil.isEmpty(name)) {
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "姓名不能为空");
            return retMap;
        }

        String loginName = null;
        char[] chars = name.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char ca : chars) {
            String charStr = String.valueOf(ca);
            if (charStr.matches("[\u4e00-\u9fa5]+")) {
                builder.append(PinYinUtil.toLowerCaseHanyuPinyin(charStr));
            } else {
                builder.append(charStr);
            }
        }
        loginName = builder.toString();

        SysUser sysUser = sysUserService.getuserByLoginName(loginName);
        if (null != sysUser) {
            String random = String.valueOf(System.currentTimeMillis());
            random = random.substring(random.length() - 8, random.length() - 3);
            loginName += random;
        }
        retMap.put(Config.RET_DATA, loginName);

        return retMap;
    }

    @RequestMapping("/resetSysUserPwd")
    @ResponseBody
    public Map<String, Object> resetSysUserPwd(@RequestParam("id") String sysUserIdStr, String newPwd) {
        Map<String, Object> retMap = new HashMap<>();
        retMap.put(Config.RET, Config.RET_ERROR);

        if (StringUtil.isEmpty(newPwd)) {
            retMap.put(Config.ERR_MSG, "请输入密码");
        } else if (!verifyPwd(newPwd)) {
            retMap.put(Config.ERR_MSG, "密码格式不正确");
        } else {
            retMap.put(Config.RET, Config.RET_OK);
        }

        if (0 == (Integer) retMap.get(Config.RET)) {
            return retMap;
        }

        int sysUserId = IDEncryptor.getInstance().decryptWithoutException(sysUserIdStr);
        SysUser sysUser = sysUserService.getUserById(sysUserId);
        if (null == sysUser) {
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "该账户不存在");
            return  retMap;
        }

        try {
            sysUserService.resetSysUserPwd(sysUserId, StringUtil.MD5Encode(newPwd));
        } catch (Exception e) {
            e.printStackTrace();
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "密码重置失败");
            return retMap;
        }

        return retMap;
    }

    @RequestMapping("/addSysUser")
    @ResponseBody
    public Map<String,Object> addSysUser() {
        Map<String, Object> retMap = new HashMap<>();
        retMap.put(Config.RET, Config.RET_ERROR);

        parseSysUser(retMap, request);
        if (0 == (Integer) retMap.get(Config.RET)) {
            return retMap;
        }

        SysUser sysUser = ((SysUser) retMap.get(Config.RET_DATA));
        retMap.remove(Config.RET_DATA);
        try {
            sysUserService.addNewSysUser(sysUser);
        } catch (Exception e) {
            e.printStackTrace();
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "新增账户失败");
            return retMap;
        }

        return retMap;
    }

    @RequestMapping("/getSysPermit")
    @ResponseBody
    public Map<String, Object> getSysPermit(@RequestParam(value = "id") String sysUserIdStr) {
        Map<String, Object> retMap = new HashMap<>();
        retMap.put(Config.RET, Config.RET_ERROR);

        int sysUserId = IDEncryptor.getInstance().decryptWithoutException(sysUserIdStr);
        SysUser sysUser = sysUserService.getUserById(sysUserId);
        if (null == sysUser) {
            retMap.put(Config.ERR_MSG, "用户不存在");
            return retMap;
        }

        List<SysUserPermit> sysUserPermits = sysUserPermitService.getSysUserPermitBySysUserId(sysUserId);
        List<SysPermit> parentSysPermits = sysPermitService.getParentSysPermit();
        Map<String, Object> data = new HashMap<>();
        if (null != parentSysPermits && parentSysPermits.size() > 0) {
            Map<Integer, List<Map<String, Object>>> resultMap = new HashMap<>();
            for (SysPermit parentSysPermit : parentSysPermits) {
                List<SysPermit> sysPermits = sysPermitService.getSysPermitByParentId(parentSysPermit.getId());
                if (null != sysPermits && sysPermits.size() > 0) {
                    List<Map<String, Object>> sysPermitMapList = new ArrayList<>();
                    for (SysPermit sysPermit : sysPermits) {
                        Map<String, Object> sysPermitMap = new HashMap<>();
                        sysPermitMap.put("id", sysPermit.getId());
                        sysPermitMap.put("modleName", sysPermit.getModleName());
                        sysPermitMapList.add(sysPermitMap);
                    }
                    resultMap.put(parentSysPermit.getId(), sysPermitMapList);
                }
            }
            data.put("resultMap", resultMap);
            if (null != sysUserPermits && sysUserPermits.size() > 0) {
                Map<Integer, SysUserPermit> sysUserPermitMap = new HashMap<>();
                for (SysUserPermit sysUserPermit : sysUserPermits) {
                    if (sysUserPermit.isPermit()) {
                        sysUserPermitMap.put(sysUserPermit.getRefId(), sysUserPermit);
                    }
                }
                data.put("sysUserPermitMap", sysUserPermitMap);
            }
        } else {
            parentSysPermits = new ArrayList<>();
        }
        data.put("parentSysPermits", parentSysPermits);
        data.put("id", IDEncryptor.getInstance().encryptWithoutException(sysUser.getId()));
        SysRole sysRole = sysRoleService.getSysRoleById(sysUser.getRoleId());
        if (null != sysRole) {
            data.put("name", sysUser.getLoginName());
            String departmentName = SysDepartment.getSysDepartment(sysRole.getDepartment()).getDesc();
            data.put("roleName", departmentName + sysRole.getRoleName());
        }


        retMap.put(Config.RET, Config.RET_OK);
        retMap.put(Config.RET_DATA, data);
        return retMap;
    }

    @RequestMapping("allotAuth")
    @ResponseBody
    public Map<String,Object> allotAuth(@RequestParam("sysUserId") String sysUserIdStr) {
        Map<String, Object> retMap = new HashMap<>();
        retMap.put(Config.RET, Config.RET_OK);

        String[] sysPermitIds = request.getParameterValues("sysPermitId");
        int sysUserId = IDEncryptor.getInstance().decryptWithoutException(sysUserIdStr);

        SysUser sysUser = sysUserService.getUserById(sysUserId);
        if (null == sysUser) {
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "该账户不存在");
            return  retMap;
        }

        try {
            sysUserPermitService.updateSysUserAuth(sysUserId, sysPermitIds);
        } catch (Exception e) {
            e.printStackTrace();
            retMap.put(Config.RET, Config.RET_OK);
            retMap.put(Config.ERR_MSG, "操作失败");
            return retMap;
        }

        return retMap;
    }

    @RequestMapping("/toUpdatePassword")
    public String toUpdatePassword(HttpServletRequest request, HttpServletResponse response) {
        SysUser sysUser = LoginUtil.getSysLoginUser(request, response);

        if (null == sysUser) {
            return "/mamnager/login";
        }
        request.setAttribute("sysUser", sysUser);

        return "/manager/manager/updatePassword";
    }

    @RequestMapping("/updatePassword")
    @ResponseBody
    public Map<String, Object> updatePassword(@RequestParam(value = "id") String sysUserIdStr,
                                              @RequestParam(value = "oldPwd", required = false) String oldPwd,
                                              @RequestParam(value = "newPwd", required = false) String newPwd) {

        Map<String, Object> retMap = new HashMap<>();
        retMap.put(Config.RET, Config.RET_ERROR);

        if (StringUtil.isEmpty(oldPwd)) {
            retMap.put(Config.ERR_MSG, "原密码不能为空");
        } else if (StringUtil.isEmpty(newPwd)) {
            retMap.put(Config.ERR_MSG, "新密码不能为空");
        } else if (!verifyPwd(newPwd)) {
            retMap.put(Config.ERR_MSG, "新密码格式错误");
        } else {
            retMap.put(Config.RET, Config.RET_OK);
        }

        if (0 == (Integer) retMap.get(Config.RET)) {
            return retMap;
        }

        int sysUserId = 0;
        if (ValidateUtil.isNumber(sysUserIdStr)) {
            sysUserId = IDEncryptor.getInstance().decryptWithoutException(sysUserIdStr);
        }
        String oldPassword = StringUtil.MD5Encode(oldPwd);
        SysUser sysUser = sysUserService.getUserByIdAndPwd(sysUserId, oldPassword);
        if (null == sysUser) {
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "原密码不正确");
            return retMap;
        }

        sysUser.setPasswd(StringUtil.MD5Encode(newPwd));
        try {
            sysUserService.chgPasswd(sysUser);
        } catch (Exception e) {
            e.printStackTrace();
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "密码修改失败");
            return retMap;
        }

        return retMap;
    }

    private Map<String, Object> parseSysUser(Map<String, Object> retMap, HttpServletRequest request) {

        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String mobile = request.getParameter("mobile");
        String email = request.getParameter("email");
        String department = request.getParameter("department");
        String roleId = request.getParameter("roleId");
        String reportDepartment = request.getParameter("reportDepartment");
        String reportRoleId = request.getParameter("reportRoleId");
        String loginName = request.getParameter("loginName");
        String password = request.getParameter("password");
        if (StringUtil.isEmpty(name)) {
            retMap.put(Config.ERR_MSG, "姓名不能为空");
        } else if (StringUtil.isEmpty(sex)) {
            retMap.put(Config.ERR_MSG, "性别不能为空");
        } else if (StringUtil.isEmpty(mobile)) {
            retMap.put(Config.ERR_MSG, "手机号不能为空");
        } else if (!ValidateUtil.isMobileNo(mobile)) {
            retMap.put(Config.ERR_MSG, "手机号格式不正确");
        } else if (StringUtil.isEmpty(email)) {
            retMap.put(Config.ERR_MSG, "邮箱不能为空");
        } else if (!ValidateUtil.isEmail(email)) {
            retMap.put(Config.ERR_MSG, "邮箱格式不正确");
        } else if (StringUtil.isEmpty(department)) {
            retMap.put(Config.ERR_MSG, "请选择部门");
        } else if (StringUtil.isEmpty(roleId)) {
            retMap.put(Config.ERR_MSG, "请选择岗位");
        } else if (StringUtil.isEmpty(reportDepartment)) {
            retMap.put(Config.ERR_MSG, "请选择汇报部门");
        } else if (StringUtil.isEmpty(reportRoleId)) {
            retMap.put(Config.ERR_MSG, "请选择汇报岗位");
        } else if (StringUtil.isEmpty(password)) {
            retMap.put(Config.ERR_MSG, "请输入密码");
        } else if (!verifyPwd(password)) {
            retMap.put(Config.ERR_MSG, "密码格式不正确");
        } else {
            retMap.put(Config.RET, Config.RET_OK);
        }

        SysUser sysUser = new SysUser();
        sysUser.setLoginName(loginName);
        sysUser.setName(name);
        sysUser.setSex(Integer.parseInt(sex));
        sysUser.setMobile(mobile);
        sysUser.setEmail(email);
        sysUser.setRoleId(IDEncryptor.getInstance().decryptWithoutException(roleId));
        sysUser.setReportRoleId(IDEncryptor.getInstance().decryptWithoutException(reportRoleId));
        sysUser.setPasswd(StringUtil.MD5Encode(password));
        sysUser.setStatus(SysUser.SysuserStatus.normal.getStatus());
        sysUser.setRegisterTime(new Date());
        sysUser.setPasswdChanged(true);
        retMap.put(Config.RET_DATA, sysUser);

        return retMap;
    }

    private boolean verifyPwd(String password) {
        password = password.trim();
        if(password.length() < 6 || password.length() > 12) {
            return false;
        }

        Pattern p1= Pattern.compile("[a-z]+");
        Pattern p2= Pattern.compile("[A-Z]+");
        Pattern p3= Pattern.compile("[0-9]+");

        Matcher m1 = p1.matcher(password);
        Matcher m2 = p2.matcher(password);
        Matcher m3 = p3.matcher(password);

        if(!m1.find() || !m2.find() || !m3.find()) {
            return false;
        }

        return true;
    }
}