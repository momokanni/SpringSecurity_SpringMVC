package com.caishen91.jupiter.authorize.access;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

import com.caishen91.jupiter.authorize.enums.BlogEnabledStatus;
import com.caishen91.jupiter.authorize.enums.EnabledStatus;
import com.caishen91.jupiter.authorize.enums.ResultEnums;
import com.caishen91.jupiter.authorize.exception.BaseAuthenticationException;
import com.caishen91.jupiter.authorize.init.SecurityWebInitializer;
import com.caishen91.jupiter.authorize.model.AdminDetailsModel;
import com.caishen91.jupiter.authorize.model.BlogManagerDetailsModel;
import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.model.BlogManager;
import com.caishen91.jupiter.model.SysUser;
import com.caishen91.jupiter.service.IBlogManagerService;
import com.caishen91.jupiter.service.ISysUserService;
import com.caishen91.jupiter.util.HtmlUtil;
import com.caishen91.jupiter.util.IDEncryptor;

@Component
public class BaseAccessDecisionManager implements AccessDecisionManager {
	
	@Autowired
	private IBlogManagerService blogManagerService;
	
	@Autowired
	private ISysUserService sysUserService;

	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
		
		UsernamePasswordAuthenticationToken token = null;
		if(authentication instanceof UsernamePasswordAuthenticationToken) {
			token = (UsernamePasswordAuthenticationToken) authentication;
		}
		
		if (CollectionUtils.isEmpty(configAttributes)) {
			throw new BaseAuthenticationException(ResultEnums.UNAUTHORIZED_ACCESS.getCode(), ResultEnums.UNAUTHORIZED_ACCESS.getMsg());
		} else {
			FilterInvocation fi = (FilterInvocation) object;
			String domain = HtmlUtil.getDomain(fi.getHttpRequest());
			List<GrantedAuthority> grantedAuthoritys = (List<GrantedAuthority>) authentication.getAuthorities();
			if (Config.DEBT_DOMAIN.equals(domain)) {//后台管理
				if(authentication instanceof UsernamePasswordAuthenticationToken) {
					AdminDetailsModel adm =  (AdminDetailsModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
					if(SecurityWebInitializer.debtContainsKey(adm.getId())) {
						int id = IDEncryptor.getInstance().decryptWithoutException(adm.getId());
						SysUser administrator = sysUserService.getUserById(id);
						grantedAuthoritys = AuthorityUtils.commaSeparatedStringToAuthorityList(administrator.getAuthorities());
						UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(adm, adm.getPassword(), grantedAuthoritys);
						result.setDetails(token.getDetails());
						SecurityWebInitializer.debtRemove(adm.getId());
					}
					// 判断账号状态
					if(SecurityWebInitializer.debtStatusContainsKey(adm.getId())) {
						 int admimnId = IDEncryptor.getInstance().decryptWithoutException(adm.getId());
						 SysUser sysUser = sysUserService.getUserById(admimnId);
						 if(!EnabledStatus.getValue(sysUser.getStatus())) {
							 grantedAuthoritys = new ArrayList<GrantedAuthority>();
						 }
					}
				}
			} else if(Config.BM_DOMAIN.equals(domain)) {
				if(authentication instanceof UsernamePasswordAuthenticationToken) {
					BlogManagerDetailsModel bmd = (BlogManagerDetailsModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
					if(SecurityWebInitializer.bmContainsKey(bmd.getId())) {
						int bmId = IDEncryptor.getInstance().decryptWithoutException(bmd.getId());
						BlogManager bm = blogManagerService.getBMById(bmId);
						grantedAuthoritys = AuthorityUtils.commaSeparatedStringToAuthorityList(bm.getAuthorities());
						UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(bmd, bmd.getPassword(), grantedAuthoritys);
						result.setDetails(token.getDetails());
						SecurityWebInitializer.bmRemove(bmd.getId());
					}
					
					// 判断账号状态
					if(SecurityWebInitializer.bmStatusContainsKey(bmd.getId())) {
						 int bmId = IDEncryptor.getInstance().decryptWithoutException(bmd.getId());
						 BlogManager bm = blogManagerService.getBMById(bmId);
						 if(!BlogEnabledStatus.getValue(bm.getStatus())) {
							 grantedAuthoritys = new ArrayList<GrantedAuthority>();
						 }
					}
				}
			}
			
			Iterator<ConfigAttribute> iterator = configAttributes.iterator();
			while (iterator.hasNext()) {
				ConfigAttribute conAttribute = iterator.next();
				String authCode = conAttribute.getAttribute();
				
				// 用户Authentication所携带的权限
				Collection<? extends GrantedAuthority> authorities = grantedAuthoritys;
				if(authorities != null && authorities.size() > 0) {
					for (GrantedAuthority grantedAuthority : authorities) {
						if (StringUtils.equals(grantedAuthority.getAuthority(), "ROLE_" + authCode)) {
							return;
						}
					}
				}
			}
		}
		
		SecurityContextHolder.clearContext();
		throw new BaseAuthenticationException(ResultEnums.UNAUTHORIZED_ACCESS.getCode(), ResultEnums.UNAUTHORIZED_ACCESS.getMsg());
		
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		
		return FilterInvocation.class.isAssignableFrom(clazz);
	}

}
