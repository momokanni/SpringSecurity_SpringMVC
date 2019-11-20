package com.caishen91.jupiter.authorize.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.caishen91.jupiter.authorize.enums.ResultEnums;
import com.caishen91.jupiter.authorize.util.ResultUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component(value = "ownAuthenctiationFailureHandler")
public class OwnAuthenctiationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	private static Logger log = LoggerFactory.getLogger(OwnAuthenctiationFailureHandler.class);
	
	@Autowired
	private ObjectMapper objMapper;
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		log.info("authentication failed：{}", exception.getLocalizedMessage());
		
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(objMapper.writeValueAsString(ResultUtil.error(ResultEnums.LOGIN_FAILURE.getCode(), exception.getLocalizedMessage())));
	}
}
