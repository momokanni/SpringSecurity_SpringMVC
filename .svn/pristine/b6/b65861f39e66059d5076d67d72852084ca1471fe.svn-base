package com.caishen91.jupiter.enums;

public enum RepayType {

	xxhb(1, "先息后本"),
	ychbfx(2, "一次还本付息"),
	debx(3, "等额本息");
	
	private int type;
	
	private String name;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	private RepayType(int type, String name) {
		this.type = type;
		this.name = name;
	}
	
	public static RepayType getRepayTypeByType(int type) {
		
		for(RepayType rt : values()) {
			if (rt.getType() == type) {
				return rt;
			}
		}
		
		return null;
	}
}
