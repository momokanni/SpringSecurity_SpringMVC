package com.caishen91.jupiter.util;

import java.util.Map;

/*
 * 记录操作结果，可以把操作失败的原因记录在message返回给调用方
 */
public class OperationResult {

	private boolean status;
	
	private String message;
	
	private Object other;
	
	private int code;
	
	private String html;
	
	private String exception;
	
	private int statusCode = 0;
	
	private boolean expt = false;
	
	private boolean handleWithUmp = true;
	
	private Map resData;
	
	public Map getResData() {
		return resData;
	}


	public void setResData(Map resData) {
		this.resData = resData;
	}


	public boolean isHandleWithUmp() {
		return handleWithUmp;
	}


	public void setHandleWithUmp(boolean handleWithUmp) {
		this.handleWithUmp = handleWithUmp;
	}


	public boolean isExpt() {
		return expt;
	}


	public void setExpt(boolean expt) {
		this.expt = expt;
	}


	public int getStatusCode() {
		return statusCode;
	}


	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}


	public String getHtml() {
		return html;
	}


	public void setHtml(String html) {
		this.html = html;
	}


	public String getException() {
		return exception;
	}


	public void setException(String exception) {
		this.exception = exception;
	}

	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public boolean isSuccess() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Object getOther() {
		return other;
	}


	public void setOther(Object other) {
		this.other = other;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
