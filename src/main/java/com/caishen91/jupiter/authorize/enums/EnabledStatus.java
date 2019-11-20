package com.caishen91.jupiter.authorize.enums;

public enum EnabledStatus {

	/**
     * 	已启用
     */
    ENABLED(0,true),
    /**
     * 	未启用
     */
    NOT_ENABLED(1,false),
    ;

    private int code;

    private boolean status;

    EnabledStatus(int code, boolean status) {
        this.code = code;
        this.status = status;
    }

    public static boolean getValue(int code){
        for (EnabledStatus status : values()){
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
