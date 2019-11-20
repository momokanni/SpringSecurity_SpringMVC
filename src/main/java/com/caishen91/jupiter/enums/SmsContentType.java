package com.caishen91.jupiter.enums;

import com.caishen91.jupiter.config.Config;

import java.util.Map;


public enum SmsContentType {
	
	activa(0,"激活短信") {
		@Override
		public String genSms(Map params) {
			String tmpl = "您正在激活%s账户，验证码：%s（向您要验证码的都是诈骗，切勿泄露）";
			return Config.SMS_SIGN +  String.format(tmpl, "", params.get("code"));
			
		}
	},
	findPwd(1,"忘记密码") {
		@Override
		public String genSms(Map params) {
			String tmpl = "您正在找回密码，验证码：%s（向您要验证码的都是诈骗，切勿泄露）";
			return Config.SMS_SIGN +  String.format(tmpl, params.get("code"));
			
		}
	},
	
	login(2,"短信登录") {
		@Override
		public String genSms(Map params) {
			String tmpl = "您正在登录系统，验证码：%s（向您要验证码的都是诈骗，切勿泄露）";
			return Config.SMS_SIGN +  String.format(tmpl, params.get("code"));
			
		}
	},
	
	;
	
	
	private int type;
	
	private String name;
	
	private SmsContentType(int type, String name){
		this.setType(type);
		this.setName(name);
	}

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

	public String genSms(Map params) {
		return "";
	}
	
	public static SmsContentType getContentByType(int type) {
		for(SmsContentType sct : values()) {
			if (sct.getType() == type) {
				return sct;
			}
		}
		return null;
	}
	
}
