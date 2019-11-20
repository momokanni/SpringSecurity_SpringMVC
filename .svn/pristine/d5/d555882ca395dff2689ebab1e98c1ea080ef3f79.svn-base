package com.caishen91.jupiter.model;

import java.util.Date;

public class SmsTrace {
	
	public final static int STATUS_WAIT = 0; //未发送
	public final static int STATUS_SUCC = 1; //发送成功
	public final static int STATUS_FAILED = 2; //发送失败
	
	public final static int SMS_TYPE_QUICK = 0; //立即发送
	public final static int SMS_TYPE_WAIT = 1; //队列发送

	private int id;
	
	private String mobile;
	
	private String content;
	
	private Date createTime;
	
	private int status;
	
	private String seq;
	
	private String ret;
	
	private Date sendTime;
	
	private Date lastTryTime;
	
	private int tryTimes;
	
	private String channel;
	
	private int smsType;
	
	private String template;//模板
   
	public String getTemplate() {
		return template;
	}


	public void setTemplate(String template) {
		this.template = template;
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


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getSeq() {
		return seq;
	}


	public void setSeq(String seq) {
		this.seq = seq;
	}


	public String getRet() {
		return ret;
	}


	public void setRet(String ret) {
		this.ret = ret;
	}


	public Date getSendTime() {
		return sendTime;
	}


	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}


	public Date getLastTryTime() {
		return lastTryTime;
	}


	public void setLastTryTime(Date lastTryTime) {
		this.lastTryTime = lastTryTime;
	}


	public int getTryTimes() {
		return tryTimes;
	}


	public void setTryTimes(int tryTimes) {
		this.tryTimes = tryTimes;
	}


	public String getChannel() {
		return channel;
	}


	public void setChannel(String channel) {
		this.channel = channel;
	}


	public int getSmsType() {
		return smsType;
	}


	public void setSmsType(int smsType) {
		this.smsType = smsType;
	}

	public boolean isSendQuickly() {
		return smsType == SMS_TYPE_QUICK;
	}
	
	//发送号码是否时联通号码
	public boolean isUnicom() {
		boolean b = mobile.startsWith("130") || 
					mobile.startsWith("131") ||
					mobile.startsWith("132") ||
					mobile.startsWith("145") ||
					mobile.startsWith("155") ||
					mobile.startsWith("156") ||
					mobile.startsWith("176") ||
					mobile.startsWith("185") ||
					mobile.startsWith("186");
	return b;
	}
	
	//发送号码是否是电信号码
	public boolean isTelecom() {
		boolean b = mobile.startsWith("133") || 
					mobile.startsWith("153") ||
					mobile.startsWith("177") ||
					mobile.startsWith("180") ||
					mobile.startsWith("181") ||
					mobile.startsWith("189");
		return b;
	}
	
	//发送号码是否时移动号码
	public boolean isChinaMobile() {
		boolean b = mobile.startsWith("134") || 
					mobile.startsWith("135") ||
					mobile.startsWith("136") ||
					mobile.startsWith("137") ||
					mobile.startsWith("138") ||
					mobile.startsWith("139") ||
					mobile.startsWith("147") ||
					mobile.startsWith("150") ||
					mobile.startsWith("151") ||
					mobile.startsWith("152") ||
					mobile.startsWith("157") ||
					mobile.startsWith("158") ||
					mobile.startsWith("159") ||
					mobile.startsWith("178") ||
					mobile.startsWith("182") ||
					mobile.startsWith("183") ||
					mobile.startsWith("184") ||
					mobile.startsWith("187") ||
					mobile.startsWith("188");
		return b;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
