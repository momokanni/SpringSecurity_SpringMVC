package com.caishen91.jupiter.vo;

public class BlogInfoVO {

	// 公众号ID
	private int blogId;
	// 公众号管理员账号ID
	private int blogManagerId;
	// 公众号名称
	private String blogName; 
	// 公众号管理员姓名
	private String blogManagerName;
	// 公众号管理员手机号
	private String mobile;
	// 公众号账号类型
	private int blogType;
	// 公众号认证情况
	private int authStatus;
	// 公众号粉丝数
	private int fansCount;
	// 公众号对应的操作员账号数量
	private int subAccount;
	// 公众号状态
	private int blogStatus;
	
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	
	public int getBlogManagerId() {
		return blogManagerId;
	}
	public void setBlogManagerId(int blogManagerId) {
		this.blogManagerId = blogManagerId;
	}
	
	public String getBlogName() {
		return blogName;
	}
	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}
	
	public String getBlogManagerName() {
		return blogManagerName;
	}
	public void setBlogManagerName(String blogManagerName) {
		this.blogManagerName = blogManagerName;
	}
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public int getBlogType() {
		return blogType;
	}
	public void setBlogType(int blogType) {
		this.blogType = blogType;
	}
	
	public int getAuthStatus() {
		return authStatus;
	}
	public void setAuthStatus(int authStatus) {
		this.authStatus = authStatus;
	}
	
	public int getFansCount() {
		return fansCount;
	}
	public void setFansCount(int fansCount) {
		this.fansCount = fansCount;
	}
	
	public int getSubAccount() {
		return subAccount;
	}
	public void setSubAccount(int subAccount) {
		this.subAccount = subAccount;
	}
	
	public int getBlogStatus() {
		return blogStatus;
	}
	public void setBlogStatus(int blogStatus) {
		this.blogStatus = blogStatus;
	}
	
}
