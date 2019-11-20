package com.caishen91.jupiter.authorize.exception;

import org.springframework.security.core.AuthenticationException;

import com.caishen91.jupiter.authorize.enums.ResultEnums;

/**
 * 	未登录状态下访问受保护资源
 * @author Administrator
 *
 */
public class BaseAuthenticationException extends AuthenticationException {

	private static final long serialVersionUID = 1L;

	private int code;
	
	public BaseAuthenticationException(ResultEnums resultEnums) {
		super(resultEnums.getMsg());
		this.code = resultEnums.getCode();
	}
	
	public BaseAuthenticationException(String msg) {
		super(msg);
		this.code = ResultEnums.AUTHENTICATION_EXCEPTOIN.getCode();
	}

	public BaseAuthenticationException(int code,String msg) {
		super(msg);
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
