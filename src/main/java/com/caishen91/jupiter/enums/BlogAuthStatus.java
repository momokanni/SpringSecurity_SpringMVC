package com.caishen91.jupiter.enums;

/**
 * 	公众号认证状态
 * @author Administrator
 *
 */
public enum BlogAuthStatus {

	UNCERTIFIED(0,"未认证"),
	CERTIFIED(1,"已认证")
	;
	
	private int authCode;
	
	private String msg;
	
	private BlogAuthStatus(int authCode, String msg) {
		this.authCode = authCode;
		this.msg = msg;
	}

	public int getAuthCode() {
		return authCode;
	}

	public void setAuthCode(int authCode) {
		this.authCode = authCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public static BlogAuthStatus getBlogAuthStatus(int authCode) {
        for (BlogAuthStatus blogAuthStatus : values()) {
            if (blogAuthStatus.getAuthCode() == authCode) {
                return blogAuthStatus;
            }
        }
        return null;
    }
	
	public static boolean getValue(int code){
        for (BlogAuthStatus status : values()){
            if (status.getAuthCode() == code){
            	if(status.getMsg().equals(BlogAuthStatus.UNCERTIFIED.getMsg())) {
            		return false;
            	}
            }
        }
        return true;
    }
}
