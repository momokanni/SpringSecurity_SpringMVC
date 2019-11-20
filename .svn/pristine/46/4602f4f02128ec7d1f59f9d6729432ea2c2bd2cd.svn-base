package com.caishen91.jupiter.controller.manager;


import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.caishen91.jupiter.authorize.model.AdminDetailsModel;
import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.model.SysPermit;
import com.caishen91.jupiter.model.SysUser;
import com.caishen91.jupiter.model.SysUserPermit;
import com.caishen91.jupiter.service.ISysPermitService;
import com.caishen91.jupiter.service.ISysRolePermitService;
import com.caishen91.jupiter.service.ISysUserService;
import com.caishen91.jupiter.service.impl.ISysUserPermitService;
import com.caishen91.jupiter.util.CollectionUtil;
import com.caishen91.jupiter.util.IDEncryptor;
import com.caishen91.jupiter.util.LoginUtil;
import com.caishen91.jupiter.util.StringUtil;

@Controller
@RequestMapping("/manager")
public class SysPermitController {
	
	private static final long serialVersionUID = 2334613357626895301L;

	@Autowired
	private ISysUserService sysUserService;

	@Autowired
	private ISysUserPermitService sysUserPermitService;

	@Autowired
	private ISysPermitService sysPermitService;
	
	@Autowired
	private ISysRolePermitService sysRolePermitService;


	/*@RequestMapping("/")
	@ResponseBody*/
	public Map<String,Object> updateUserPermit(HttpServletRequest request, HttpServletResponse response) {

		Map<String,Object> retMap = new HashMap<String,Object>(); {
			retMap.put(Config.RET, Config.RET_OK);
		}
		String userIdStr = request.getParameter("userId");
		int userId = IDEncryptor.getInstance().decryptWithoutException(userIdStr);
		
		SysUser sysUser = sysUserService.getUserById(userId);
		
		if (sysUser == null) {
			retMap.put(Config.RET, 0);
			retMap.put(Config.ERR_MSG, "找不到用户信息");
			return retMap;
		}
		
		List<SysUserPermit> sups = new ArrayList();
		List<SysPermit> allPermits = sysUserService.getSysPermitByRole(sysUser.getRoleId());
		
		Set<Integer> hasPermits = new HashSet();
		Enumeration<String> enus = request.getParameterNames();
		while (enus.hasMoreElements()) {
			String key = enus.nextElement();
			String value = request.getParameter(key);
			Matcher m = Pattern.compile("pr_(\\d+)").matcher(key);
			if (m.find()) {
				hasPermits.add(Integer.valueOf(m.group(1)));
			}
		}
		
		for(SysPermit sp : allPermits) {
			SysUserPermit sup = new SysUserPermit();
			sup.setRefId(sp.getId());
			sup.setRoleId(sysUser.getRoleId());
			sup.setUserId(sysUser.getId());
			
			if (hasPermits.contains(sp.getId())) {
				sup.setPermit(true);
			} else {
				sup.setPermit(false);
			}
			sups.add(sup);
		}
		
		boolean b = false;
		try {
			b = sysUserService.updateUserPermit(sysUser, sups);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (!b) {
			retMap.put(Config.RET, 0);
			retMap.put(Config.ERR_MSG, "操作失败");
			return retMap;
		}
		return retMap;
	}

	public Map<String, Object> getPrivilegesByUserId(HttpServletRequest request,HttpServletResponse response) {
		Map<String,Object> retMap = new HashMap<String,Object>(); {
			retMap.put(Config.RET, Config.RET_OK);
		}
		String userIdStr = request.getParameter("userId");
		int userId = IDEncryptor.getInstance().decryptWithoutException(userIdStr);
		
		SysUser sysUser = sysUserService.getUserById(userId);
		
		if (sysUser == null) {
			retMap.put(Config.RET, 0);
			retMap.put(Config.ERR_MSG, "找不到用户信息");
			return retMap;
		}
		
		Map userInfo = new HashMap();
		userInfo.put("name", sysUser.getName());
		
		List<SysPermit> allPermits = sysUserService.getSysPermitByRole(sysUser.getRoleId());
		Map<Integer, List<SysPermit>> parentChildPermitMap = new HashMap();
		for(SysPermit sup : allPermits) {
			CollectionUtil.putElement(parentChildPermitMap, sup.getParentId(), sup);
		}
		
		List<SysUserPermit> userPermits = sysUserService.getSysUserPermitByUserIdRoleId(sysUser.getId(), sysUser.getRoleId());
		Map<Integer, SysUserPermit> userPermitMap = new HashMap();
		for(SysUserPermit sup : userPermits) {
			userPermitMap.put(sup.getRefId(), sup);
		}
		
		List<SysPermit> topPermits = new ArrayList();
		
		for(SysPermit sp : allPermits) {
			if (sp.getParentId() == 0) {
				topPermits.add(sp);
			}
		}
		
		List<Map> permits = new ArrayList();
		userInfo.put("permits", permits);
		
		for(SysPermit sp : topPermits) {
			Map top = new HashMap();
			permits.add(top);
			
			top.put("id", sp.getId());
			top.put("action", StringUtil.isEmpty(sp.getAction()) ? "" : sp.getAction());
			top.put("name", sp.getModleName());
			top.put("roleKey", sp.isRoleKey());
			boolean p = sp.isDefaultPermit();
			SysUserPermit sup = userPermitMap.get(sp.getId());
			if (sup != null) {
				p = sup.isPermit();
			}
			top.put("permit", p);
			List<Map> childs = new ArrayList();
			top.put("childs", childs);
			
			List<SysPermit> secondPermits = parentChildPermitMap.get(sp.getId());
			if (secondPermits != null && secondPermits.size() > 0) {
				for(SysPermit sp2 : secondPermits) {
					Map second = new HashMap();
					childs.add(second);
					
					second.put("id", sp2.getId());
					second.put("action", StringUtil.isEmpty(sp2.getAction()) ? "" : sp2.getAction());
					second.put("name", sp2.getModleName());
					second.put("roleKey", sp2.isRoleKey());
					boolean p2 = sp2.isDefaultPermit();
					SysUserPermit sup2 = userPermitMap.get(sp2.getId());
					if (sup2 != null) {
						p2 = sup2.isPermit();
					}
					second.put("permit", p2);
					List<Map> childs2 = new ArrayList();
					second.put("childs", childs2);
					
					List<SysPermit> thirdPermits = parentChildPermitMap.get(sp2.getId());
					if (thirdPermits != null && thirdPermits.size() > 0) {
						for(SysPermit sp3 : thirdPermits) {
							Map third = new HashMap();
							childs2.add(third);
							
							third.put("id", sp3.getId());
							third.put("action", StringUtil.isEmpty(sp3.getAction()) ? "" : sp3.getAction());
							third.put("name", sp3.getModleName());
							third.put("roleKey", sp3.isRoleKey());
							boolean p3 = sp3.isDefaultPermit();
							SysUserPermit sup3 = userPermitMap.get(sp3.getId());
							if (sup3 != null) {
								p3 = sup3.isPermit();
							}
							third.put("permit", p3);
						}
					}
					
				}
			}
		}
		retMap.put("userInfo", userInfo);

		return retMap;
	}

	@RequestMapping("/newHome")
	public String newHome(HttpServletRequest request,HttpServletResponse response) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		AdminDetailsModel admin = (AdminDetailsModel) authentication.getPrincipal();
		int adminId = IDEncryptor.getInstance().decryptWithoutException(admin.getId());
		if(adminId == 0) {
            return "../managers/error";
		}
		int roleId = IDEncryptor.getInstance().decryptWithoutException(admin.getRoleId());
		if(roleId == 0) {
            return "../managers/error";
		}
		/**
		 * 	1.  根据登录用户的角色ID和用户ID 查询角色权限关联表（sysRolePermit） -> 获得权限ID
		 * 	2.  根据权限ID集合获取权限集合
		 */
		
		List<Integer> sysRolePermitsList = sysRolePermitService.getSysRolePermitByUserIdAndRoleId(roleId);
		List<SysPermit> sysPermitList= null;
		if(sysRolePermitsList == null || sysRolePermitsList.size() == 0) {
			sysPermitList=new ArrayList<SysPermit>();
		} else {
			sysPermitList = sysPermitService.getSysPermitByIds(sysRolePermitsList);
			if(sysPermitList==null || sysPermitList.size() == 0){
				sysPermitList=new ArrayList<SysPermit>();
			}
		}
		
		
		List<SysPermit> parentPermit=new ArrayList<SysPermit>();//可用的一级目录
		Map<Integer,List<SysPermit>> menuMap=new HashMap<Integer,List<SysPermit>>();//key父及菜单i的  value-对应子集菜单集合 可用菜单map
		for(SysPermit p:sysPermitList){
			// int refId=p.getId();
			/*
			 * SysUserPermit up=sysUserPermitMap.get(refId); if(up!=null){
			 * if(!up.isPermit()){ continue; } }else{ if(!p.isDefaultPermit()){ continue; }
			 * }
			 */
			
			if(p.isTop()){					
				parentPermit.add(p);
			}else{
				List<SysPermit> menu=menuMap.get(p.getParentId());
				if(menu==null){
					menu=new ArrayList<SysPermit>();
					menu.add(p);
					menuMap.put(p.getParentId(), menu);
				}else{
					menuMap.get(p.getParentId()).add(p);
				} 
			}
		} 
		
		request.setAttribute("topMenus", parentPermit);
		request.setAttribute("menuMap", menuMap);
		response.setHeader("X-Frame-Options", "SAMEORIGIN");
		
		return "../managers/home2/home";
	
	}

	public String home(HttpServletRequest request,HttpServletResponse response) {
		SysUser su = LoginUtil.getSysLoginUser(request, response);
		
		int roleId=su.getRoleId();	
		int uId=su.getId();
		//按用户id及用户角色获取菜单项信息
		List<SysUserPermit> sysUserPermitList=sysUserService.getSysUserPermitByUserIdRoleId(uId,roleId);
		if(sysUserPermitList==null){
			sysUserPermitList=new ArrayList<SysUserPermit>();
		}
		Map<Integer,SysUserPermit> sysUserPermitMap=new HashMap<Integer,SysUserPermit>();//存储可用菜单集合
		for(SysUserPermit up:sysUserPermitList){
			sysUserPermitMap.put(up.getRefId(), up); 
		}
		
		List<SysPermit> parentPermit=new ArrayList<SysPermit>();//可用的一级目录
		Map<Integer,List<SysPermit>> menuMap=new HashMap<Integer,List<SysPermit>>();//key父及菜单i的  value-对应子集菜单集合 可用菜单map
	
		List<SysPermit> sysPermitList=sysUserService.getSysPermitByRole(su.getRoleId());
		if(sysPermitList==null){
			sysPermitList=new ArrayList<SysPermit>();
		}
		for(SysPermit p:sysPermitList){
			int refId=p.getId();
			SysUserPermit up=sysUserPermitMap.get(refId);
			if(up!=null){
				if(!up.isPermit()){
					continue;
				}
			}else{
				if(!p.isDefaultPermit()){
					continue;
				}
			}
			
			if(p.isTop()){					
				parentPermit.add(p);
			}else{
				List<SysPermit> menu=menuMap.get(p.getParentId());
				if(menu==null){
					menu=new ArrayList<SysPermit>();
					menu.add(p);
					menuMap.put(p.getParentId(), menu);
				}else{
					menuMap.get(p.getParentId()).add(p);
				} 
			}
		} 
		
		request.setAttribute("topMenus", parentPermit);
		request.setAttribute("menuMap", menuMap);
		
		return "";
	}
}
