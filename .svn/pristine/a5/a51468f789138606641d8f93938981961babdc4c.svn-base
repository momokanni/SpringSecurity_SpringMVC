package com.caishen91.jupiter.authorize.exception;

import org.springframework.security.access.AccessDeniedException;

import com.caishen91.jupiter.authorize.enums.ResultEnums;

/**
 * 	登陆了但是由于权限不足导致的异常
 * @author Administrator
 *
 */
public class BaseAccessDeniedException extends AccessDeniedException {

	private static final long serialVersionUID = 1L;

	private int code;
	
	public BaseAccessDeniedException(ResultEnums resultEnums) {
		super(resultEnums.getMsg());
		this.code = resultEnums.getCode();
	}

	public BaseAccessDeniedException(int code,String msg) {
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
