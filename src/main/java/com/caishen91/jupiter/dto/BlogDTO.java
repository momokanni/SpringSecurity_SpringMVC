package com.caishen91.jupiter.dto;

import com.caishen91.jupiter.model.BaseEntity;

/**
 * 	公众号 && 管理员
 * @author Administrator
 *
 */
public class BlogDTO extends BaseEntity {

	private static final long serialVersionUID = -2935459043682364175L;

	// 账号类型（0.个人号，1.公司号）
	private String blogType;
	// 公众号名称
	private String blogName;
	// 管理员名称
	private String managerName;
	// 管理员昵称
	private String managerNickName;
	// 管理员手机号
	private String mobile;
	// 企业类型
	private String enterpriseType;
	// 企业名称
	private String enterpriseName;
	// 初始密码
	private String password = "888888";
	// 公众号状态
	private String blogStatus;
	// 公众号认证状态
	private String authStatus;
	// 公众号粉丝数
	private int fansCount;
	// 是否为管理员
	private int isManager = 1;
	// 管理员状态
	private int managerStatus;
	
	public String getBlogType() {
		return blogType;
	}
	public void setBlogType(String blogType) {
		this.blogType = blogType;
	}
	public String getBlogName() {
		return blogName;
	}
	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerNickName() {
		return managerNickName;
	}
	public void setManagerNickName(String managerNickName) {
		this.managerNickName = managerNickName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEnterpriseType() {
		return enterpriseType;
	}
	public void setEnterpriseType(String enterpriseType) {
		this.enterpriseType = enterpriseType;
	}
	public String getEnterpriseName() {
		return enterpriseName;
	}
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBlogStatus() {
		return blogStatus;
	}
	public void setBlogStatus(String blogStatus) {
		this.blogStatus = blogStatus;
	}
	public String getAuthStatus() {
		return authStatus;
	}
	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}
	public int getFansCount() {
		return fansCount;
	}
	public void setFansCount(int fansCount) {
		this.fansCount = fansCount;
	}
	public int getIsManager() {
		return isManager;
	}
	public void setIsManager(int isManager) {
		this.isManager = isManager;
	}
	public int getManagerStatus() {
		return managerStatus;
	}
	public void setManagerStatus(int managerStatus) {
		this.managerStatus = managerStatus;
	}
}
