package com.caishen91.jupiter.authorize.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.caishen91.jupiter.authorize.exception.BaseAuthenticationException;
import com.caishen91.jupiter.authorize.util.ResultUtil;
import com.caishen91.jupiter.util.HtmlUtil;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component(value = "baseAuthenticationEntryPoint")
public class BaseAuthenticationEntryPoint implements AuthenticationEntryPoint {

	private static Logger log = LoggerFactory.getLogger(BaseAuthenticationEntryPoint.class);
	
	@Autowired
	private ObjectMapper objMapper;
	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		if(HtmlUtil.isAjaxRequest(request)) {
			BaseAuthenticationException baseAuthenticationException = (BaseAuthenticationException) authException;
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.getWriter().write(objMapper.writeValueAsString(ResultUtil.error(baseAuthenticationException.getCode(), baseAuthenticationException.getMessage())));
		} else {
			String param = HtmlUtil.getRequestParam(request);
			String uri = request.getRequestURI();
			log.error("exception message: {}, request uri:{}, param: {}" , authException.getMessage() , uri , param);
			String deniedPath = HtmlUtil.getLoginPath(HtmlUtil.getDomain(request));
			if(deniedPath != null) {
				response.getWriter().write("<script>window.parent.location.href='';</script>");
				response.sendRedirect("/logout");
			}
		}
	}
}
