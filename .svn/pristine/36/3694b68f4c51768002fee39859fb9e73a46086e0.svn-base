package com.caishen91.jupiter.enums;

public enum CommonStatus {

	unAvailable(0, "无效"),
	available(1, "有效"),
	DELETE(2,"已删除");
	
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
	
	private CommonStatus(int status, String desc) {
		this.status = status;
		this.desc = desc;
	}
	
	public static CommonStatus getCommonStatus(int status) {
        for (CommonStatus commonStatus : values()) {
            if (commonStatus.getStatus() == status) {
                return commonStatus;
            }
        }
        return null;
    }
	
}
