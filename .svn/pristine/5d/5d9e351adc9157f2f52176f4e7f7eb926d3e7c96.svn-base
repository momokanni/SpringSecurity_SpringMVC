package com.caishen91.jupiter.enums;

public enum TermUnit {

	day(1, "日"),
	month(2, "月"),
	year(3, "年");
	
	private int unit;
	
	private String desc;

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	private TermUnit(int unit, String desc) {
		this.unit = unit;
		this.desc = desc;
	}
	
	public static TermUnit getTermUnitByUnit(int unit) {
		for(TermUnit tu : values()) {
			if (tu.getUnit() == unit) {
				return tu;
			}
		}
		
		return null;
	}
}
