package com.caishen91.jupiter.authorize.enums;

public enum BlogEnabledStatus {

	/**
     * 	未启用
     */
    NOT_ENABLED(0,false),
	/**
     * 	已启用
     */
    ENABLED(1,true),
    ;

    private int code;

    private boolean status;

    BlogEnabledStatus(int code, boolean status) {
        this.code = code;
        this.status = status;
    }

    public static boolean getValue(int code){
        for (BlogEnabledStatus status : values()){
            if (status.getCode() == code){
                return status.isStatus();
            }
        }
        return false;
    }

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
    
    
}
