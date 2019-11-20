package com.caishen91.jupiter.authorize.session;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;

import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.util.HtmlUtil;

public class AbstractSessionStrategy {
	
	/**
	 * 重定向策略
	 */
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	/**
	 * 跳转前是否创建新的session
	 */
	private boolean createNewSession = true;
	
	public AbstractSessionStrategy() {

	}
	
	
	protected void onSessionInvalid(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if(createNewSession) {
			request.getSession();
		}
		
		String domain = HtmlUtil.getDomain(request);
		//后台管理
		if (Config.DEBT_DOMAIN.equals(domain)) {
			redirectStrategy.sendRedirect(request, response, Config.DEBT_DOMAIN_LOGIN);
		} else if (Config.BM_DOMAIN.equals(domain)) {
			redirectStrategy.sendRedirect(request, response, Config.BM_DOMAIN_LOGIN);
		}
	}

	protected boolean isConcurrency() {
		
		return false;
	}
}
