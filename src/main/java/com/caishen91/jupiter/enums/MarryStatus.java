package com.caishen91.jupiter.enums;

public enum MarryStatus {

	unknow(0, "请选择"),
	married(1, "已婚"),
	unMarried(2, "未婚"),
	divorced(3, "离异");
	
	
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
	
	private MarryStatus(int status, String desc) {
		this.status = status;
		this.desc = desc;
	}
	
	public static MarryStatus getMarryStatusByStatus(int status) {
		for(MarryStatus ms : MarryStatus.values()) {
			if (ms.getStatus() == status) {
				return ms;
			}
		}
		return null;
	}
}
