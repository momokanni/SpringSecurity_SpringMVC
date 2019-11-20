package com.caishen91.jupiter.authorize.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.util.HtmlUtil;

@Component(value = "baseLogoutSuccessHandler")
public class BaseLogoutSuccessHandler implements LogoutSuccessHandler {
	
	private static Logger log = LoggerFactory.getLogger(ExceptionHandle.class);
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		log.info("logout success");
		String domain = HtmlUtil.getDomain(request);
		//后台管理
		if (Config.DEBT_DOMAIN.equals(domain)) {
			response.getWriter().write("<script>window.location.reload();</script>");
			response.sendRedirect(Config.DEBT_LOGINOUT_SUCCESS_URL);
		} else if (Config.BM_DOMAIN.equals(domain)) {
			response.sendRedirect(Config.BM_LOGINOUT_SUCCESS_URL);
		}
	}

}
