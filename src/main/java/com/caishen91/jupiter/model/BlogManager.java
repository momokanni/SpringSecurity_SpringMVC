package com.caishen91.jupiter.model;


public class BlogManager extends BaseEntity {

	private static final long serialVersionUID = -5782089007007157885L;
	
	// 昵称
	private String nickName;
	
	// 手机号
	private String mobile;
	
	// 管理员名称
	private String name;
	
	// 密码
	private String password;

	private String cardNo;
	
	// 是否为管理员(0.否，1.是)
	private int isManager;
	
	// 状态（0.无效，1.有效）
	private int status;
	
	// 公众号ID
	private int blogId;
	/**
	 * 权限列表
	 */
	private String authorities;
	

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIsManager() {
		return isManager;
	}

	public void setIsManager(int isManager) {
		this.isManager = isManager;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}




	public static enum BlogManagerStatus{
		EFFECTIVE(1, "有效"),
		INVALID(0, "无效"),
		;

		private int status;

		private String desc;

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		BlogManagerStatus(int status, String desc) {
			this.status = status;
			this.desc = desc;
		}

		public static BlogManagerStatus getSysuserStatus(int status) {
			for (BlogManagerStatus blogManagerStatus : values()) {
				if (blogManagerStatus.getStatus() == status) {
					return blogManagerStatus;
				}
			}
			return null;
		}
	}
}
