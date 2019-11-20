package com.caishen91.jupiter.enums;

public enum ShareStatus {

	NOT_SHARED(0, "未分享"),
	SHARED(1, "已分享"),
	;
	
	private int status;
	
	private String desc;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	private ShareStatus(int status, String desc) {
		this.status = status;
		this.desc = desc;
	}
	
	public static ShareStatus getShareStatus(int status) {
        for (ShareStatus share : values()) {
            if (share.getStatus() == status) {
                return share;
            }
        }
        return null;
    }
	
}
