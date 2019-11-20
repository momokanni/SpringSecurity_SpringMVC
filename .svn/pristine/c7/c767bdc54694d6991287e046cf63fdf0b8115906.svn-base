package com.caishen91.jupiter.controller.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.enums.SysDepartment;
import com.caishen91.jupiter.enums.SysRoleStatus;
import com.caishen91.jupiter.model.SysPermit;
import com.caishen91.jupiter.model.SysRole;
import com.caishen91.jupiter.model.SysRolePermit;
import com.caishen91.jupiter.service.ISysPermitService;
import com.caishen91.jupiter.service.ISysRolePermitService;
import com.caishen91.jupiter.service.ISysRoleService;
import com.caishen91.jupiter.util.Action;
import com.caishen91.jupiter.util.ActionFactory;
import com.caishen91.jupiter.util.CommonUtil;
import com.caishen91.jupiter.util.IDEncryptor;
import com.caishen91.jupiter.util.StringUtil;

@Controller
@RequestMapping("/manager/sysrole")
public class ManagerSysRoleController {

    @Autowired
    private ISysRoleService sysRoleService;
    
    @Autowired
    private ISysRolePermitService sysRolePermitService;

    @Autowired
    private ISysPermitService sysPermitService;
    

    @Autowired
    private HttpServletRequest request;


    @GetMapping("/toSysRoleManager")
    public String toSysRoleManager(HttpServletResponse response) {
    	response.setHeader("X-Frame-Options", "SAMEORIGIN");
        List<Map<String,String>> listsysDepartmentMap = new ArrayList<>();
        for (SysDepartment sysDepartment : SysDepartment.values()) {
            Map<String, String> sysDepartmentMap = new HashMap<>();
            sysDepartmentMap.put("type", sysDepartment.getType());
            sysDepartmentMap.put("desc", sysDepartment.getDesc());
            listsysDepartmentMap.add(sysDepartmentMap);
        }

        request.setAttribute("department", JSON.toJSONString(listsysDepartmentMap));
        return "../managers/manager/sysRoleManager";
    }

    @GetMapping("/querySysRoleList")
    @ResponseBody
    public Map<String,Object> querySysRoleList(
        @RequestParam(defaultValue = "0", required = false) String  pageNo,
        @RequestParam(defaultValue = "10", required = false) String perPageNo) {

        // 【列表查询】page参数组装
        Map<String, Object> paramMap = CommonUtil.pageParam(pageNo, perPageNo);

        int count = sysRoleService.queryDepartmentCount(paramMap);
        List<SysRole> sysRoles = null;
        if (count > 0) {
            sysRoles = sysRoleService.queryDepartmentList(paramMap);
        }

        Map<String, Object> retMap = new HashMap<>();
        retMap.put(Config.RET, Config.RET_OK);

        if (null != sysRoles && sysRoles.size() > 0) {
            List<Map<String, Object>> listResultMap = new ArrayList<>();
            for (SysRole sysRole : sysRoles) {
                Map<String, Object> resultMap = new HashMap<>();

                String sysRoleIdStr = IDEncryptor.getInstance().encryptWithoutException(sysRole.getId());
                resultMap.put("roleName", sysRole.getRoleName());

                List<Action> actions = new ArrayList<Action>();
                Action allotAuthAction = ActionFactory.build(ActionFactory.ALLOT_AUTH, "", "",
                        ActionFactory.OPTYPE_SCRIPT, "/manager/sysrole/getSysPermit?id=" + sysRoleIdStr, ActionFactory.REQ_TYPE_DIV, "sysRolePermit");
                actions.add(allotAuthAction);
                
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
    
    @PostMapping("/addSysRole")
    @ResponseBody
    public Map<String,Object> addSysRole(SysRole role) {
    	Map<String, Object> retMap = new HashMap<>();
    	if (role == null || StringUtil.isEmpty(role.getRoleName())) {
    		retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "角色名称不能为空");
            return retMap;
		}
        SysRole sysRole = sysRoleService.getSysRoleByRoleName(role);
        if (null != sysRole) {
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "该角色已存在");
            return retMap;
        }
        Date date = new Date();
        sysRole = new SysRole();
        sysRole.setRoleName(role.getRoleName());
        sysRole.setCreateTime(date);
        sysRole.setUpdateTime(date);
        sysRole.setStatus(SysRoleStatus.start.getStauts());
        try {
            sysRoleService.addSysRole(sysRole);
        } catch (Exception e) {
            e.printStackTrace();
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "保存失败");
        }
        retMap.put(Config.RET, Config.RET_OK);
        return retMap;
    }

    @GetMapping("/getSysRoleDetailById")
    @ResponseBody
    public Map<String,Object> getSysRoleDetailById(@RequestParam(value = "id", required = true) String sysRoleIdStr) {
        Map<String,Object> retMap = new HashMap<>();
        retMap.put(Config.RET, Config.RET_OK);

        int sysRoleId = IDEncryptor.getInstance().decryptWithoutException(sysRoleIdStr);
        SysRole sysRole = sysRoleService.getSysRoleById(sysRoleId);
        if (null != sysRole) {
            Map<String, Object> data = new HashMap<>();
            data.put("sysRoleId", IDEncryptor.getInstance().encryptWithoutException(sysRole.getId()));
            data.put("roleName", sysRole.getRoleName());
            data.put("department", SysDepartment.getSysDepartment(sysRole.getDepartment()).getDesc());
            retMap.put(Config.RET_DATA, data);
        } else {
            retMap.put(Config.RET, Config.RET_ERROR);
        }

        return retMap;
    }

    @RequestMapping("/updateSysRole")
    @ResponseBody
    public Map<String, Object> updateSysRole(@RequestParam(value = "id") String sysRoleIdStr,
                                             String roleName) {
        Map<String, Object> retMap = new HashMap<>();
        retMap.put(Config.RET, Config.RET_ERROR);

        if (StringUtil.isEmpty(roleName)) {
            retMap.put(Config.ERR_MSG, "岗位名称不能为空");
        } else {
            retMap.put(Config.RET, Config.RET_OK);
        }
        if (0 == (Integer)retMap.get(Config.RET)) {
            return retMap;
        }
        int sysRoleId = IDEncryptor.getInstance().decryptWithoutException(sysRoleIdStr);
        SysRole sysRole = sysRoleService.getSysRoleById(sysRoleId);
        SysRole sysRoleAgain = sysRoleService.getSysRoleByRoleNameAndDepartment(roleName, sysRole.getDepartment());
        if (null == sysRole) {
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "该岗位不存在");
            return retMap;
        } else if (null != sysRoleAgain) {
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "该岗位已存在");
            return retMap;
        }
        String oldRoleName = sysRole.getRoleName();
        sysRole.setRoleName(roleName);
        sysRole.setUpdateTime(new Date());

        try {
            sysRoleService.updateSysRole(sysRole, oldRoleName);
        } catch (Exception e) {
            e.printStackTrace();
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "保存失败");
        }

        return retMap;
    }

    @GetMapping("getSysRoleByDepartment")
    @ResponseBody
    public Map<String,Object> getSysRoleByDepartment(String department) {
        Map<String, Object> retMap = new HashMap<>();
        retMap.put(Config.RET, Config.RET_OK);

        List<SysRole> listSysRole = sysRoleService.getSysRoleByDepartment(department);
        if (null != listSysRole && listSysRole.size() > 0) {
            List<Map<String,String>> resultMapList = new ArrayList<>();
            for (SysRole sysRole : listSysRole) {
                Map<String, String> resultMap = new HashMap<>();
                resultMap.put("sysRoleId", IDEncryptor.getInstance().encryptWithoutException(sysRole.getId()));
                resultMap.put("roleName", sysRole.getRoleName());
                resultMapList.add(resultMap);
            }
            retMap.put(Config.RET_DATA, resultMapList);
        } else {
            retMap.put(Config.RET, Config.RET_ERROR);
        }

        return retMap;
    }
    
    /**
     *	 获取权限菜单
     * @param roleIdStr
     * @return
     */
    @GetMapping("/getSysPermit")
    @ResponseBody
    public Map<String, Object> getSysPermit(@RequestParam(value = "id") String roleIdStr) {
        Map<String, Object> retMap = new HashMap<>();
        retMap.put(Config.RET, Config.RET_ERROR);

        int roleId = IDEncryptor.getInstance().decryptWithoutException(roleIdStr);
        // 查询角色
        SysRole sysRole = sysRoleService.getSysRoleById(roleId);
        if (null == sysRole) {
            retMap.put(Config.ERR_MSG, "角色不存在");
            return retMap;
        }
        // 通过roleID获取该角色已拥有的菜单
        List<SysRolePermit> sysRolePermits = sysRolePermitService.getSysRolePermitByRoleId(roleId);
        // 获取所有的父级菜单
        List<SysPermit> parentSysPermits = sysPermitService.getParentSysPermit();
        Map<String, Object> data = new HashMap<>();
        if (null != parentSysPermits && parentSysPermits.size() > 0) {
            Map<Integer, List<Map<String, Object>>> resultMap = new HashMap<>();
            for (SysPermit parentSysPermit : parentSysPermits) {
            	// 通过父级菜单ID获取子菜单
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
            // 存放的是全部菜单
            data.put("resultMap", resultMap);
            
            if (null != sysRolePermits && sysRolePermits.size() > 0) {
                Map<Integer, SysRolePermit> sysRolePermitMap = new HashMap<>();
                for (SysRolePermit sysRolePermit : sysRolePermits) {
                    if (sysRolePermit.isPermit()) {
                    	sysRolePermitMap.put(sysRolePermit.getRefId(), sysRolePermit);
                    }
                }
                data.put("sysRolePermitMap", sysRolePermitMap);
            }
        } else {
            parentSysPermits = new ArrayList<>();
        }
        data.put("parentSysPermits", parentSysPermits);
        data.put("roleName", sysRole.getRoleName());
        data.put("id", IDEncryptor.getInstance().encryptWithoutException(sysRole.getId()));
        retMap.put(Config.RET, Config.RET_OK);
        retMap.put(Config.RET_DATA, data);
        return retMap;
    }
    
    /**
     * 	角色授权菜单
     * @param sysUserIdStr
     * @return
     */
    @PostMapping("addRoleAuth")
    @ResponseBody
    public Map<String,Object> allotAuth(@RequestParam("sysRoleId") String sysRoleId) {
        Map<String, Object> retMap = new HashMap<>();
        retMap.put(Config.RET, Config.RET_OK);

        String[] sysPermitIds = request.getParameterValues("sysPermitId");
        int roleId = IDEncryptor.getInstance().decryptWithoutException(sysRoleId);

        SysRole sysRole = sysRoleService.getSysRoleById(roleId);
        if (null == sysRole) {
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "该角色不存在");
            return  retMap;
        }

        try {
        	sysRolePermitService.updateSysRoleAuth(roleId, sysPermitIds);
        } catch (Exception e) {
            e.printStackTrace();
            retMap.put(Config.RET, Config.RET_OK);
            retMap.put(Config.ERR_MSG, "操作失败");
            return retMap;
        }

        return retMap;
    }
}