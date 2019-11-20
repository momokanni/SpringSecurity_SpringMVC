package com.caishen91.jupiter.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.caishen91.jupiter.authorize.enums.EnabledStatus;
import com.caishen91.jupiter.authorize.properties.SecurityConstants;
import com.caishen91.jupiter.authorize.util.PasswordEncoderUtil;
import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.controller.manager.PlatDockController;
import com.caishen91.jupiter.dao.AccountMapper;
import com.caishen91.jupiter.dao.SysMapper;
import com.caishen91.jupiter.dao.SysPermitMapper;
import com.caishen91.jupiter.dao.SysUserPermitMapper;
import com.caishen91.jupiter.model.SysUser;
import com.caishen91.jupiter.model.SysUserPermit;
import com.caishen91.jupiter.service.IGrapesService;
import com.caishen91.jupiter.util.OperationResult;
import com.caishen91.jupiter.util.StringUtil;
import com.caishen91.jupiter.util.ValidateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import java.util.regex.Pattern;

@Service
public class GrapesServiceImpl extends BaseService implements IGrapesService {
	
	private static Logger logger = LoggerFactory.getLogger(GrapesServiceImpl.class);
	
    @Override
    @Transactional(rollbackFor = Exception.class)
    public OperationResult addSysUser(Map<String,Object> parse) {
        SysMapper sysMapper=writableSQLSession.getMapper(SysMapper.class);
        SysUserPermitMapper sysUserPermitMapper = writableSQLSession.getMapper(SysUserPermitMapper.class);
        SysPermitMapper sysPermitMapper = writableSQLSession.getMapper(SysPermitMapper.class);
        AccountMapper accountMapper = writableSQLSession.getMapper(AccountMapper.class);

        OperationResult result = new OperationResult();
        result.setStatus(false);

        OperationResult operationResult = null;
        try {
            operationResult = checkParam(parse, sysMapper);
        } catch (Exception e) {
            e.printStackTrace();
            result.setMessage("数据格式错误");
            return result;
        }
        if (!operationResult.isSuccess()) {
            return operationResult;
        }

        String loginName = SecurityConstants.SYSTEM_ADMINISTRATOR_PREFIX + (String) parse.get("loginName");
        SysUser isysUser=accountMapper.getAccountByloginName(loginName);
        if(isysUser!=null){
        	operationResult.setStatus(false);
        	operationResult.setMessage("该登陆账号已被注册");
        	return operationResult;
        }
        String name = (String) parse.get("name");
        String mobile = (String) parse.get("mobile");
        Integer roleId = (Integer) parse.get("roleId");

        SysUser sysUser = new SysUser(name,loginName,mobile,roleId,PasswordEncoderUtil.encode(Config.DEFAULT_PASSWORD));
        
        String authorizes = sysPermitMapper.getAuthByRoleId(roleId);
        sysUser.setAuthorities(authorizes.toString());
        sysUser.setCreateTime(new Date());
        sysUser.setRegisterTime(new Date());

        accountMapper.addAccount(sysUser);
        
        JSONArray menu = (JSONArray) parse.get("menu");
        logger.info(menu.toJSONString());
        List<SysUserPermit> sysUserPermits = new ArrayList<SysUserPermit>();
        for (Object o : menu) {
            Integer id = (Integer)o;
            SysUserPermit permit = new SysUserPermit();
            permit.setPermit(true);
            permit.setRefId(id);
            permit.setRoleId(roleId);
            permit.setUserId(sysUser.getId());
            sysUserPermits.add(permit);
        }
        
        try {
        	sysUserPermitMapper.revocationSysUserAuthAll(sysUser.getId());
            sysUserPermitMapper.insertBatch(sysUserPermits);
		} catch (Exception e) {
			logger.error("insert batch sysUserPermit :{}",e.getMessage());
		}

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("sysUserId",sysUser.getId());
        
        List<Map<String,Object>> list = sysUserPermitMapper.getSysUserPermitAllByUserIdAndRoleId(sysUser.getId(),roleId);
        resultMap.put("userPermit",list);
        
        result.setStatus(true);
        result.setOther(resultMap);

        return result;
    }

    private OperationResult checkParam(Map<String, Object> map, SysMapper sysMapper) {
    	AccountMapper accountMapper = writableSQLSession.getMapper(AccountMapper.class);
    	
        OperationResult or = new OperationResult();
        or.setStatus(false);

        if (null == map) {
            or.setMessage("请求参数不能为空");
            return or;
        }

        String loginName = (String) map.get("loginName");
        String name = (String) map.get("name");
        String mobile = (String) map.get("mobile");

        if (StringUtil.isEmpty(loginName)) {
            or.setMessage("登录名不能为空");
            return or;
        }

        if (StringUtil.isEmpty(name)) {
            or.setMessage("用户姓名不能为空");
            return or;
        }

        if (!Pattern.compile("^[\u0391-\uFFE5a-zA-Z]{0,20}+$").matcher(name).matches()) {
            or.setMessage("用户姓名格式不正确");
            return or;
        }

        if (StringUtil.isEmpty(mobile)) {
            or.setMessage("手机号不能为空");
            return or;
        }

        if (!ValidateUtil.isMobileNo(mobile)) {
            or.setMessage("手机号格式不正确");
            return or;
        }

        Integer roleId = (Integer) map.get("roleId");
        if (null == roleId || 0 == roleId) {
            or.setMessage("roleId不能为空");
            return or;
        }

        SysUser msysUser=accountMapper.getAccountBymobile(mobile);
        if (null != msysUser) {
            or.setMessage("手机号已注册");
            return or;
        }

        or.setStatus(true);
        return or;
    }

    @Override
    public OperationResult modifySysUser(JSONObject parse) {
        SysUserPermitMapper sysUserPermitMapper = writableSQLSession.getMapper(SysUserPermitMapper.class);
        SysPermitMapper sysPermitMapper = writableSQLSession.getMapper(SysPermitMapper.class);
        AccountMapper accountMapper = writableSQLSession.getMapper(AccountMapper.class);

        OperationResult result = new OperationResult();
        result.setStatus(false);

        String loginName = (String) parse.get("loginName");
        Integer sysUserId = (Integer) parse.get("sysUserId");
        String name = (String) parse.get("name");
        String mobile = (String) parse.get("mobile");
        Integer roleId = (Integer) parse.get("roleId");
        
        SysUser sysUser = accountMapper.getAccountById(sysUserId);
        if (null == sysUser){
        	result.setStatus(false);
        	result.setMessage("用户不存在");
        	return result;
        }
        
        sysUser.setLoginName(SecurityConstants.SYSTEM_ADMINISTRATOR_PREFIX + loginName);
    	sysUser.setMobile(mobile);
        sysUser.setName(name);
        sysUser.setUpdateTime(new Date());
        sysUser.setRoleId(roleId);
        
        String authorizes = sysPermitMapper.getAuthByRoleId(roleId);
        sysUser.setAuthorities(authorizes.toString());
        
        accountMapper.updateAccount(sysUser);
        
        JSONArray menu = (JSONArray) parse.get("menu");
        List<SysUserPermit> permits = new ArrayList<SysUserPermit>();
        for (Object o : menu) {
            Integer id = (Integer)o;
            SysUserPermit permit = new SysUserPermit();
            permit.setPermit(true);
            permit.setRefId(id);
            permit.setRoleId(roleId);
            permit.setUserId(sysUser.getId());
            permits.add(permit);
        }
        
        sysUserPermitMapper.revocationSysUserAuthAll(sysUser.getId());
        sysUserPermitMapper.insertBatch(permits);

        List<Map<String,Object>> list = sysUserPermitMapper.getSysUserPermitAllByUserIdAndRoleId(sysUser.getId(),roleId);
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("sysUserId",sysUser.getId());
        resultMap.put("userPermit",list);

        result.setStatus(true);
        result.setOther(resultMap);

        return result;

    }
}
