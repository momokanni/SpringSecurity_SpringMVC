package com.caishen91.jupiter.controller.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.enums.GrapesEnum;
import com.caishen91.jupiter.enums.SysRole;
import com.caishen91.jupiter.model.SysUser;
import com.caishen91.jupiter.service.IGrapesService;
import com.caishen91.jupiter.service.ISysPermitService;
import com.caishen91.jupiter.service.ISysRoleService;
import com.caishen91.jupiter.service.ISysUserService;
import com.caishen91.jupiter.util.DesUtil;
import com.caishen91.jupiter.util.IDEncryptor;
import com.caishen91.jupiter.util.OperationResult;
import com.caishen91.jupiter.util.StringUtil;

@Controller
@RequestMapping("/manager/grapes/api/vi")
public class PlatDockController {
	
	private static Logger logger = LoggerFactory.getLogger(PlatDockController.class);
	
	@Autowired
	private ISysPermitService sysPermitService;
	
	@Autowired
	private IGrapesService grapesService;
	
	@Autowired
	private ISysUserService sysUserService;
	
	@Autowired
	private ISysRoleService sysRoleService;
	
	/**
	 * 	同步角色权限
	 * @param request
	 * @return
	 */
	@GetMapping("/syncSystemInfo")
	@ResponseBody
	public Map<String, Object> syncSystemInfo(HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("retcode", GrapesEnum.FAIL.getCode());
		resultMap.put("retmsg", GrapesEnum.FAIL.getMessage());
		
		List<Map<String,Object>> permitList = sysPermitService.getSysPermits();

		if (null != permitList && permitList.size() > 0) {
			Map<String, Object> dataMap = new HashMap<>();
			
			List<Map<String,Object>> roles = sysRoleService.getAllRoles();
			dataMap.put("roles", roles);
			
			dataMap.put("permit", permitList);

			String dataStr = JSON.toJSONString(dataMap);
			try {
				dataStr = DesUtil.encrypt(dataStr, Config.GRAPES_KEY);
			} catch (Exception e) {
				logger.error(e.getMessage());
				resultMap.put("retcode", GrapesEnum.SYS_ANOMALY.getCode());
				resultMap.put("retmsg", GrapesEnum.SYS_ANOMALY.getMessage());
				return resultMap;
			}

			resultMap.put("retcode", GrapesEnum.SUCCESS.getCode());
			resultMap.put("retmsg", GrapesEnum.SUCCESS.getMessage());
			resultMap.put("retdata", dataStr);
			logger.info("syn role data : {}",dataStr);
		} else {
			resultMap.put("retmsg", "无数据");
		}
		return resultMap;
	}
	
	/**
	 * 	创建管理员
	 * @param request
	 * @return
	 */
	@PostMapping("/addSysUser")
    @ResponseBody
    public Map<String,Object> addSysUser(HttpServletRequest request){
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("retcode",GrapesEnum.FAIL.getCode());
        resultMap.put("retmsg",GrapesEnum.FAIL.getMessage());

        String data = request.getParameter("data");
        
        if (StringUtil.isEmpty(data)){
            return resultMap;
        }

        try {
            String decrypt = DesUtil.decrypt(data, Config.GRAPES_KEY);

            JSONObject parse = (JSONObject) JSONObject.parse(decrypt);
            OperationResult op = grapesService.addSysUser(parse);
            logger.info("add sys_user account status: {}, msg:{}",op.isSuccess(),op.getMessage());
            if (!op.isSuccess()){
            	resultMap.put("retmsg",op.getMessage());
                return resultMap;
            }
            Map<String,Object> other = (Map<String,Object>) op.getOther();
            String retdata = DesUtil.encrypt(JSONObject.toJSONString(other),Config.GRAPES_KEY);
            resultMap.put("retdata",retdata);

        } catch (Exception e) {
            logger.error(e.getMessage());
            return resultMap;
        }

        resultMap.put("retcode",GrapesEnum.SUCCESS.getCode());
        resultMap.put("retmsg",GrapesEnum.SUCCESS.getMessage());
        return resultMap;
    }
	
	/**
	 * 	修改管理员信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/modifySysUser")
    @ResponseBody
    public Map<String,Object> modifySysUser(HttpServletRequest request){
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("retcode",GrapesEnum.FAIL.getCode());
        resultMap.put("retmsg",GrapesEnum.FAIL.getMessage());

        String data = request.getParameter("data");
        if (StringUtil.isEmpty(data)){
            return resultMap;
        }

        try {
            String decrypt = DesUtil.decrypt(data, Config.GRAPES_KEY);
            JSONObject parse = (JSONObject) JSONObject.parse(decrypt);
            OperationResult op = grapesService.modifySysUser(parse);
            if (!op.isSuccess()){
                return resultMap;
            }
            Map<String,Object> other = (Map<String,Object>) op.getOther();
            String retdata = DesUtil.encrypt(JSONObject.toJSONString(other),Config.GRAPES_KEY);
            resultMap.put("retdata",retdata);
        } catch (Exception e) {
            e.printStackTrace();
            return resultMap;
        }

        resultMap.put("retcode",GrapesEnum.SUCCESS.getCode());
        resultMap.put("retmsg",GrapesEnum.SUCCESS.getMessage());
        return resultMap;
    }
	
	/**
	 * 	快速登录
	 * @param request
	 * @return
	 */
	@RequestMapping("/quickLogin")
    public String grapesQuickLogin(HttpServletRequest request,HttpServletResponse response){

		Object sysUserId = request.getParameter("sysUserId");
		Object loginName = request.getParameter("loginName");
		logger.info("quick login param {},{}",sysUserId,loginName);
		SysUser sysUser = null;
		if(loginName != null) {
			if(loginName.toString().equals(SysRole.admin.name())) {
				sysUser = sysUserService.getSysUserByRoleId(SysRole.admin.getRole());
			}
		}
		
		if (sysUser == null && sysUserId != null) {
			try {
				int id = IDEncryptor.getInstance().decrypt(sysUserId.toString());
				sysUser = sysUserService.getUserById(id);
			}catch (Exception e){
				logger.error(e.getMessage());
			}
		}
		request.setAttribute("username", sysUser.getLoginName());
		request.setAttribute("password", Config.DEFAULT_PASSWORD);
		request.setAttribute("loginSuccess", "false");
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!authentication.getPrincipal().toString().equals("anonymousUser")) {
			request.setAttribute("loginSuccess", "true");
		}
		
		response.setHeader("X-Frame-Options", "SAMEORIGIN");
		return "../managers/quickLogin";
    }
	
	/**
	 * 	修改管理员账户状态
	 * @param request
	 * @return
	 */
	@RequestMapping("/setSysUserStatus")
    @ResponseBody
    public Map<String,Object> setSysUserStatus(HttpServletRequest request){
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("retcode",GrapesEnum.FAIL.getCode());
        resultMap.put("retmsg",GrapesEnum.FAIL.getMessage());
        
        Object data = request.getParameter("data");
        if(data == null) {
        	return resultMap;
        }
        
        String decrypt = null;
        SysUser sysUser = null;
		try {
			decrypt = DesUtil.decrypt(data.toString(), Config.GRAPES_KEY);
			JSONObject parse = (JSONObject) JSONObject.parse(decrypt);
	        String sysUserId = String.valueOf(parse.get("userId"));
	        if (StringUtil.isEmpty(sysUserId)) {
	        	resultMap.put("retmsg","用户ID不能为空");
	        	return resultMap;
			}
	        String status = String.valueOf(parse.get("status"));
	        if(StringUtil.isEmpty(status)) {
	        	resultMap.put("retmsg","状态编码不能为空");
	        	return resultMap;
	        }
			
			sysUser = sysUserService.getUserById(Integer.valueOf(sysUserId));
			if (sysUser == null) {
				resultMap.put("retmsg","管理员不存在");
				return resultMap;
			}
			boolean b = sysUserService.setUserStatus(sysUser);
			if (b){
				resultMap.put("retcode",GrapesEnum.SUCCESS.getCode());
		        resultMap.put("retmsg",GrapesEnum.SUCCESS.getMessage());
		        resultMap.put("sysUserId", sysUser.getId());
	        }
			
		} catch (Exception e) {
			return resultMap;
		}
        return resultMap;
    }
	
}
