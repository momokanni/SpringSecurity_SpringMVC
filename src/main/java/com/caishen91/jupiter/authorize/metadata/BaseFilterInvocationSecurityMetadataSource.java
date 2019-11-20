package com.caishen91.jupiter.authorize.metadata;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import com.caishen91.jupiter.authorize.model.AdminDetailsModel;
import com.caishen91.jupiter.authorize.properties.SecurityConstants;
import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.model.BlogPermit;
import com.caishen91.jupiter.model.SysPermit;
import com.caishen91.jupiter.service.IBlogPermitService;
import com.caishen91.jupiter.service.ISysPermitService;
import com.caishen91.jupiter.service.ISysRolePermitService;
import com.caishen91.jupiter.util.HtmlUtil;

/**
 * 	主要作用：当访问一个url时返回这个url所需要的访问权限
 * @author Administrator
 *
 */
@Component(value="baseFilterInvocationSecurityMetadataSource")
public class BaseFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

	@Autowired
	private ISysRolePermitService rolePermitService;
	
	@Autowired
	private ISysPermitService permitService;
	
	@Autowired
	private IBlogPermitService blogPermitService;
	
	private static Set<String> urls = new HashSet<String>();
	
	static {
		urls.add(Config.BM_DOMAIN_LOGIN);
		urls.add(Config.DEBT_DOMAIN_LOGIN);
		urls.add(SecurityConstants.BLOG_LOGIN_PROCESSING_URL_FORM);
		urls.add(SecurityConstants.XYC_GET_SHARE_ARTICLE);
		urls.add(SecurityConstants.JH_SYN_NRPT_ROLE);
		urls.add(SecurityConstants.JH_ADD_SYS_USER);
		urls.add(SecurityConstants.JH_MODIFY_SYS_USER);
		urls.add(SecurityConstants.JH_QUICK_LOGIN);
		urls.add(SecurityConstants.JH_SET_SYS_USER_STATUS);
		urls.add("/favicon.ico");
	}
	
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		FilterInvocation fi = (FilterInvocation) object;
		String url = extractPath(fi.getRequestUrl());
		String domain = HtmlUtil.getDomain(fi.getHttpRequest());
		if (Config.DEBT_DOMAIN.equals(domain)) {//后台管理
			if (!"/".equals(url)  && !"/index.jsp".equals(url)) {
				// AdminDetailsModel adm =  (AdminDetailsModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				SysPermit sysPermit = permitService.getSysPermitByUrl(url);
				if(sysPermit != null) {
					Collection<ConfigAttribute> metadataSource = null;
					if(null != obj && obj.toString().equals("anonymousUser")) {
						metadataSource = rolePermitService.getMetadataSourceByRefId(sysPermit.getId());
					} else {
						AdminDetailsModel adm =  (AdminDetailsModel) obj;
						metadataSource = rolePermitService.getMetadataSourceByRefIdAndSysUserId(adm.getId(),sysPermit.getId());
					}
					
					if(metadataSource.size() > 0) {
						return metadataSource;
					}
				}
			}
		} else if(Config.BM_DOMAIN.equals(domain)) {
			if (!"/".equals(url)  && !"/index.jsp".equals(url)) {
				/**
				 * 	1. 根据url查出访问该路径所需权限
				 * 	2. 创建管理员时添加权限
				 */
				BlogPermit blogPermit = blogPermitService.getBlogPermitByUrl(url);
				if(blogPermit != null) {
					return SecurityConfig.createList(blogPermit.getAuthorize());
				}
			}
		}
		
		
		if(urls.contains(url)) {
			return null;
		}
		return SecurityConfig.createList("USER");
	}

	private String extractPath(String requestUrl) {
		int index = requestUrl.indexOf("?");
		if(index == -1) {
			return requestUrl;
		}
		return requestUrl.substring(0,index);
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

}
