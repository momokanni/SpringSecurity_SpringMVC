package com.caishen91.jupiter.authorize.enums;

public enum LockStatus {
	
	/**
     * 	未锁定
     */
    UNLOCKED(0,true),
    /**
     *	已锁定
     */
    LOCKED(1,false)
    ;
    private int code;

    private boolean status;

    LockStatus(int code, boolean status) {
        this.code = code;
        this.status = status;
    }

    public static boolean getValue(int code){
        for (LockStatus lockStatus : values()){
            if (lockStatus.getCode() == code){
                return lockStatus.isStatus();
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
