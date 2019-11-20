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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caishen91.jupiter.authorize.enums.EnabledStatus;
import com.caishen91.jupiter.authorize.init.SecurityWebInitializer;
import com.caishen91.jupiter.authorize.properties.SecurityConstants;
import com.caishen91.jupiter.authorize.util.PasswordEncoderUtil;
import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.model.SysRole;
import com.caishen91.jupiter.model.SysUser;
import com.caishen91.jupiter.service.IAccountService;
import com.caishen91.jupiter.service.ISysPermitService;
import com.caishen91.jupiter.service.impl.ISysUserPermitService;
import com.caishen91.jupiter.util.Action;
import com.caishen91.jupiter.util.ActionFactory;
import com.caishen91.jupiter.util.CommonUtil;
import com.caishen91.jupiter.util.IDEncryptor;
import com.caishen91.jupiter.util.StringUtil;

/**
 * @Auther: gk
 * @Date: 4/17/19 16 20
 * Description:
 */
@Controller
@RequestMapping("/manager/account")
public class ManagerAccountController {

    @Autowired
    private IAccountService accountService;
    
    @Autowired
    private ISysPermitService sysPermitService;
    
    @Autowired
    private ISysUserPermitService sysUserPermitService;



    @GetMapping("/accountList")
    public String noticeList(HttpServletResponse response){
    	response.setHeader("X-Frame-Options", "SAMEORIGIN");
        return "../managers/account/accountList";
    }


    @GetMapping("/queryAccountList")
    @ResponseBody
    public Map<String,Object> queryNoticeList(HttpServletRequest request, HttpServletResponse response){
        Map<String,Object> retMap = new HashMap<String,Object>(); {
            retMap.put(Config.RET, Config.RET_OK);
        }
        int page = 1;
        try {
            page = Integer.valueOf(request.getParameter("pageNo"));
        } catch(Exception e) {
            e.printStackTrace();
        }
        int pageCount = 10;

        Map queryMap = new HashMap();

        String name = request.getParameter("name");
        if (StringUtil.isNotEmpty(name)) {
            queryMap.put("name", name);
        }

        String mobile = request.getParameter("mobile");
        if (StringUtil.isNotEmpty(mobile)) {
            queryMap.put("mobile", mobile);
        }

        queryMap.put("offset", (page -1) * pageCount);
        queryMap.put("pageSize", pageCount);

        String[] statuses = request.getParameterValues("status");
        if (statuses != null && statuses.length > 0) {
            List<Integer> sts = new ArrayList();
            for(String s : statuses) {
                sts.add(Integer.valueOf(s));
            }
            queryMap.put("statuses", sts);
        }

        int total = accountService.getTotalSysUserCountByParams(queryMap);

        List<SysUser> sysUsers = accountService.getSysUserByParams(queryMap);

        List<Map> resultMap = new ArrayList();

        for(int i = 0; i < sysUsers.size(); i++) {
            SysUser sysUser = sysUsers.get(i);


            String encId = IDEncryptor.getInstance().encryptWithoutException(sysUser.getId());
            String roleName=accountService.getSysUserRoleNameByRoleId(sysUser.getRoleId());
            Map m = new HashMap();

            m.put("id", encId);

            m.put("name", sysUser.getName());

            m.put("loginName",sysUser.getLoginName());

            m.put("mobile", sysUser.getMobile());

            m.put("roleName", roleName);

            if (sysUser.isAvailable()) {
                m.put("status", "有效");
            } else {
                m.put("status", "无效");
            }

            List<Action> actions = new ArrayList<Action>();
            m.put("opList", actions);

            if (sysUser.isAvailable()) {
                Action disableAction = ActionFactory.build("禁用",
                        "",
                        ActionFactory.TARGET_SELF,
                        ActionFactory.OPTYPE_SCRIPT ,
                        "/manager/account/setAccountStatus?id=" + encId + "&status=" + EnabledStatus.NOT_ENABLED.getCode(),
                        ActionFactory.REQ_TYPE_CONFIRM ,
                        "");

                actions.add(disableAction);
            } else {
                Action enableAction = ActionFactory.build("启用",
                        "",
                        ActionFactory.TARGET_SELF,
                        ActionFactory.OPTYPE_SCRIPT ,
                        "/manager/account/setAccountStatus?id=" + encId + "&status=" + EnabledStatus.ENABLED.getCode(),
                        ActionFactory.REQ_TYPE_CONFIRM ,
                        "");

                actions.add(enableAction);
            }



            Action detailAction = ActionFactory.build("编辑",
                    "/manager/account/editAccount?id=" + encId,
                    ActionFactory.TARGET_SELF,
                    ActionFactory.OPTYPE_LINK ,
                    "",
                    "" ,
                    "");
            actions.add(detailAction);

            resultMap.add(m);
        }

        Map data = new HashMap();
        data.put("totalRows", total);
        data.put("nav", "");
        data.put("content", resultMap);
        retMap.put("data", data);

        return retMap;

    }


    @RequestMapping("/setAccountStatus")
    @ResponseBody
    public Map<String,Object> setAccountStatus(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> retMap = new HashMap<String, Object>();
        {
            retMap.put(Config.RET, Config.RET_OK);
        }

        String idStr = request.getParameter("id");

        int id = IDEncryptor.getInstance().decryptWithoutException(idStr);

        SysUser sysUser = accountService.getAccountById(id);
        if(sysUser == null){
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "没有该账号");
            return  retMap;
        }
        String statusStr = request.getParameter("status");
        int status = Integer.valueOf(statusStr);
        sysUser.setStatus(status);

        boolean b = false;

        try {
            b = accountService.setAccountStatus(sysUser);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(!b){
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "操作失败");
        }
        SecurityWebInitializer.setDebtStatusMap(idStr);
        return retMap;
    }


    @RequestMapping("/editAccount")
    public String addNotice(HttpServletRequest request, HttpServletResponse response){
    	response.setHeader("X-Frame-Options", "SAMEORIGIN");
        List<SysRole> ssr=accountService.getSysRole();
        request.setAttribute("ssr",ssr);
        String idStr = request.getParameter("id");
        if(StringUtil.isNotEmpty(idStr)){
            int id = IDEncryptor.getInstance().decryptWithoutException(idStr);
            SysUser sysUser = accountService.getAccountById(id);
            request.setAttribute("sysUser",sysUser);
        }
        return "../managers/account/editAccount";
    }



    @RequestMapping("/addAccount")
    @ResponseBody
    public Map<String,Object> addAccount(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> retMap = new HashMap<String, Object>();
        {
            retMap.put(Config.RET, Config.RET_OK);
        }

        SysUser sysUser = new SysUser();
        sysUser.setCreateTime(new Date());
        String name = request.getParameter("name");
        if (StringUtil.isEmpty(name)) {
            retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "姓名不能为空");
            return retMap;
        }
        sysUser.setName(name);

        String mobile = request.getParameter("mobile");
        if(StringUtil.isEmpty(mobile)) {
        	retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "手机号不能为空");
            return retMap;
        }
        if(!CommonUtil.isMobile(mobile)) {
        	retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "请正确填写手机号");
            return retMap;
        }
        SysUser msysUser=accountService.getAccountBymobile(mobile);
        if(msysUser!=null) {
            retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "该手机号已被使用");
            return retMap;
        }else if (StringUtil.isEmpty(mobile)) {
            retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "手机号不能为空");
            return retMap;
        }
        sysUser.setMobile(mobile);

        String loginName = SecurityConstants.SYSTEM_ADMINISTRATOR_PREFIX + request.getParameter("loginName");
        SysUser isysUser=accountService.getAccountByloginName(loginName);
        if(isysUser!=null){
            retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "该登陆账号已被注册");
            return retMap;
        }else if (StringUtil.isEmpty(loginName)) {
            retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "登陆账号不能为空");
            return retMap;
        }

        sysUser.setLoginName(loginName);

        String roleIdStr = request.getParameter("roleId");
        if (StringUtil.isEmpty(roleIdStr)) {
            retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "角色不能为空");
            return retMap;
        }
        int roleId = Integer.valueOf(roleIdStr);
        sysUser.setRoleId(roleId);

        sysUser.setStatus(EnabledStatus.ENABLED.getCode());
        sysUser.setPasswd(PasswordEncoderUtil.encode(Config.DEFAULT_PASSWORD));
        sysUser.setEnabled(0);
        sysUser.setLockStatus(0);
        
        String authorizes = sysPermitService.getAuthByRoleId(roleId);
        sysUser.setAuthorities(authorizes.toString());
        boolean b = false;

        try {
            b =accountService.addAccount(sysUser);
        }catch (Exception e){
            e.printStackTrace();
        }
        
        // 插入sysUserPermit
        sysUserPermitService.update(sysUser);

        if(!b){
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "操作失败");
        }

        return retMap;
    }



    @RequestMapping("/updateAccount")
    @ResponseBody
    public Map<String,Object> updateAccount(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> retMap = new HashMap<String, Object>();
        {
            retMap.put(Config.RET, Config.RET_OK);
        }

        String idStr = request.getParameter("id");
        int id = IDEncryptor.getInstance().decryptWithoutException(idStr);
        SysUser sysUser = accountService.getAccountById(id);

        String name = request.getParameter("name");
        if (StringUtil.isEmpty(name)) {
            retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "姓名不能为空");
            return retMap;
        }
        sysUser.setName(name);

        String mobile = request.getParameter("mobile");

        if (StringUtil.isEmpty(mobile)) {
            retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "手机号不能为空");
            return retMap;
        }
        sysUser.setMobile(mobile);

        String loginName = request.getParameter("loginName");

        if (StringUtil.isEmpty(loginName)) {
            retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "登陆账号不能为空");
            return retMap;
        }

        sysUser.setLoginName(loginName);
        sysUser.setUpdateTime(new Date());

        String roleIdStr = request.getParameter("roleId");
        if (StringUtil.isEmpty(roleIdStr)) {
            retMap.put(Config.RET, 0);
            retMap.put(Config.ERR_MSG, "角色不能为空");
            return retMap;
        }
        int roleId = Integer.valueOf(roleIdStr);
        sysUser.setRoleId(roleId);
        
        String authorizes = sysPermitService.getAuthByRoleId(roleId);
        sysUser.setAuthorities(authorizes.toString());

        boolean b = false;

        try {
            b = accountService.updateAccount(sysUser);

        }catch (Exception e){
            e.printStackTrace();
        }

        // 修改sysUserPermit
        sysUserPermitService.update(sysUser);

        if(!b){
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "操作失败");
        }

        return retMap;
    }


}
