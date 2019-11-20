package com.caishen91.jupiter.enums;

public enum RepayPlanHandleType {

	loan(1, "放款"),
	repay(2, "还款");
	
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
	
	private RepayPlanHandleType(int type, String name) {
		this.type = type;
		this.name = name;
	}
	
	public static RepayPlanHandleType getRepayPlanHandleTypeByType(int type) {
		
		for(RepayPlanHandleType rt : values()) {
			if (rt.getType() == type) {
				return rt;
			}
		}
		
		return null;
	}
}
