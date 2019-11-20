package com.caishen91.jupiter.model;

import java.io.Serializable;
import java.util.Date;

public class MobileCheckToken implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int SOURCE_FROM_MOBILE = 1; //来源移动端
	public static final int SOURCE_FROM_APP = 2; //来源移动端
	public static final int SOURCE_FROM_PC = 0; //来源PC
	
	public static final int MODE_MOBILE = 0;
	public static final int MODE_EMAIL = 1;
	public static final int MODE_REALNAME = 2;

	private int id;
	
	private String mobile;
	
	private int userId;
	
	private Date sendTime;
	
	private Date checkTime;
	
	private Date availableTime;
	
	private String ip;
	
	private String cookie;
	
	private String token;
	
	private int tokenType;
	
	private int source;
	
	private int mode; //0 -手机， 1- 邮箱 2 -实名
	
	private String idCardNo;
	
	public String getIdCardNo() {
		return idCardNo;
	}
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
	public boolean isExpired() {
		return availableTime.getTime() < System.currentTimeMillis() || checkTime != null;
	}
	public int getTokenType() {
		return tokenType;
	}

	public void setTokenType(int tokenType) {
		this.tokenType = tokenType;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public Date getAvailableTime() {
		return availableTime;
	}

	public void setAvailableTime(Date availableTime) {
		this.availableTime = availableTime;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getCookie() {
		return cookie;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}
	public int getSource() {
		return source;
	}
	public void setSource(int source) {
		this.source = source;
	}
	public int getMode() {
		return mode;
	}
	public void setMode(int mode) {
		this.mode = mode;
	}
	
}
