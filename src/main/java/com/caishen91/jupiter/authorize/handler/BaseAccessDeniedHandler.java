package com.caishen91.jupiter.authorize.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.caishen91.jupiter.authorize.enums.ResultEnums;
import com.caishen91.jupiter.authorize.util.ResultUtil;
import com.caishen91.jupiter.util.HtmlUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component(value = "baseAccessDeniedHandler")
public class BaseAccessDeniedHandler implements AccessDeniedHandler {
	
	private static Logger log = LoggerFactory.getLogger(BaseAuthenticationEntryPoint.class);

	@Autowired
	private ObjectMapper objMapper;
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {

		// 设置403状态码
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        
		if(HtmlUtil.isAjaxRequest(request)) {
			response.getWriter().write(objMapper.writeValueAsString(ResultUtil.error(ResultEnums.UNAUTHORIZED_ACCESS.getCode(), ResultEnums.UNAUTHORIZED_ACCESS.getMsg())));
		} else {
			String param = HtmlUtil.getRequestParam(request);
			String uri = request.getRequestURI();
			log.error("exception message: {}, request uri:{}, param: {}" , accessDeniedException.getMessage() , uri , param);
			String deniedPath = HtmlUtil.getLoginPath(HtmlUtil.getDomain(request));
			if(deniedPath != null) {
				response.sendRedirect(deniedPath);
			}
		}
	}

}
