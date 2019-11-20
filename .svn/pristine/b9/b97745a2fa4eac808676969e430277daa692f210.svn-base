
package com.caishen91.jupiter.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.caishen91.jupiter.authorize.properties.SecurityConstants;
import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.util.CookieUtil;
import com.caishen91.jupiter.util.HtmlUtil;
import com.caishen91.jupiter.util.RequestUtil;

@Component("globalFilter")
public class GlobalFilter extends OncePerRequestFilter {

	private static Logger logger = LoggerFactory.getLogger(GlobalFilter.class);
	 
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");

		String path = req.getContextPath();
		String port = req.getServerPort()==80?"":":"+request.getServerPort();
		String basePath = request.getScheme()+"://"+request.getServerName()+port+path+"/";
		req.setAttribute("basePath", basePath);

		String servletPath = req.getServletPath();

		HttpServletRequest r = (HttpServletRequest)request;

		String referer = r.getHeader("Referer");
		if (referer == null) {
			referer = "";
		}

		String domain = HtmlUtil.getDomain(req);
		CookieUtil.getInstance().genGlobal((HttpServletRequest)request, (HttpServletResponse)response);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if (Config.DEBT_DOMAIN.equals(domain)) {//后台管理
			if ("/".equals(servletPath)  || "/index.jsp".equals(servletPath)) {
				if (authentication == null) {
					RequestUtil.redirect302(req, resp, Config.DEBT_DOMAIN_LOGIN);
					return;
				} else {
					RequestUtil.redirect302(req, resp, Config.DEBT_DOMAIN_LOGIN_SUCCESS_URL);
					return;
				}
			} else {
				if(authentication != null) {
					if(!servletPath.startsWith(Config.DEBT_DOMAIN_REQUEST_START_CODE)) {
						RequestUtil.redirect302(req, resp, Config.DEBT_DOMAIN_LOGIN_SUCCESS_URL);
						return;
					}
				} else {
					if(!servletPath.equals(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM) && !servletPath.startsWith(Config.DEBT_DOMAIN_REQUEST_START_CODE)) {
						RequestUtil.redirect302(req, resp, Config.DEBT_DOMAIN_LOGIN);
						return;
					}
				}
			}
		} else if (Config.WAP_DOMAIN.equals(domain)) { // 移动
			if ("/".equals(servletPath) || "/index.jsp".equals(servletPath)) {
				req.getRequestDispatcher(Config.WAP_DOMAIN_INDEX_URL).forward(request, response);
				return;
			}
		} else if (Config.BM_DOMAIN.equals(domain)) { // 商户端
			if ("/".equals(servletPath) || "/index.jsp".equals(servletPath)) {
				if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
					RequestUtil.redirect302(req, resp, Config.DEBT_DOMAIN_LOGIN);
					return;
				} else {
					RequestUtil.redirect302(req, resp, Config.BM_DOMAIN_LOGIN_SUCCESS_URL);
					return;
				}
			} else {
				if(authentication != null) {
					if(servletPath.equals("/favicon.ico")) {
						return;
					}
					if(!servletPath.startsWith(Config.BM_DOMAIN_REQUEST_START_CODE)) {
						RequestUtil.redirect302(req, resp, Config.BM_DOMAIN_LOGIN_SUCCESS_URL);
						return;
					}
				} else {
					if(!servletPath.equals(SecurityConstants.BLOG_LOGIN_PROCESSING_URL_FORM) && !servletPath.startsWith(Config.BM_DOMAIN_REQUEST_START_CODE)) {
						RequestUtil.redirect302(req, resp, Config.BM_DOMAIN_LOGIN);
						return;
					}
				}
			}
		}
		chain.doFilter(req, resp);
	}
}
