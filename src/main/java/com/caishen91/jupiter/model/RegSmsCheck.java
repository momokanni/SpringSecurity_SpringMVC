package com.caishen91.jupiter.model;

import java.util.Date;

public class RegSmsCheck {

	private int id;
	
	private String mobile;
	
	private String code;
	
	private String ip;
	
	private String cookie;
	
	private Date sendTime;
	
	private Date checkTime;
	
	private Date lastSendTime;
	
	private int ref;
	
	private String channel;//短信通道
	
	public String getChannel() {
		return channel;
	}


	public void setChannel(String channel) {
		this.channel = channel;
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


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
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


	public Date getLastSendTime() {
		return lastSendTime;
	}


	public void setLastSendTime(Date lastSendTime) {
		this.lastSendTime = lastSendTime;
	}


	public int getRef() {
		return ref;
	}


	public void setRef(int ref) {
		this.ref = ref;
	}
	
	public boolean isExpire() {
		return (System.currentTimeMillis() - sendTime.getTime() >= 5 * 60 * 1000L) || checkTime != null;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
