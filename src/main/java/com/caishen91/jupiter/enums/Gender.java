package com.caishen91.jupiter.enums;

public enum Gender {

	male(1, "男"),
	female(2, "女");
	
	private int gender;
	
	private String desc;

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	private Gender(int gender, String desc) {
		this.gender = gender;
		this.desc = desc;
	}
}
