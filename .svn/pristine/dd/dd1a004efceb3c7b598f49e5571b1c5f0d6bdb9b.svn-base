package com.caishen91.jupiter.authorize.session;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

public class ExpiredSessionStrategy extends AbstractSessionStrategy implements SessionInformationExpiredStrategy {

	public ExpiredSessionStrategy() {
		super();
	}

	/**
	 * 	并发登录session超时的处理策略
	 * 	参数：SessionInformationExpiredEvent  能获取session超时事件
	 */
	@Override
	public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
		onSessionInvalid(event.getRequest(),event.getResponse());
	}
	
	
	@Override
	protected boolean isConcurrency() {

		return true;
	}

}
