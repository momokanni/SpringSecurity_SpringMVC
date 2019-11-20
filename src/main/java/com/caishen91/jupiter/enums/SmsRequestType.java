package com.caishen91.jupiter.enums;

public enum SmsRequestType {
	
	nm(0,"普通请求,拿到号码发送短信"),
	available(1,"需要验证手机是否存在,不存在不发短信"),
	unavailable(2,"需要验证手机是否存在,存在则不发短信"),
	userMobileUnMatch(3,"需要验证手机是否与当前用户匹配，存在则发短信"),
	changeMobileSame(4,"更换手机号时新旧手机号相同,不发送短信");
	private int id;
	
	private String name;
	
	private SmsRequestType(int id, String name){
		this.setId(id);
		this.setName(name);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
