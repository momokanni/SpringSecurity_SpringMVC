package com.caishen91.jupiter.model;

public class BlogLabel extends BaseEntity{

	private static final long serialVersionUID = 7972770717088614815L;

	// 标签名称
	private String name;
	// 标签描述
	private String description;
	// 标签状态
	private int status;
	// 公众号ID
	private int blogId;

	private String idStr;

	private String statusStr;

	public String getIdStr() {
		return idStr;
	}

	public void setIdStr(String idStr) {
		this.idStr = idStr;
	}

	public String getStatusStr() {
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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


	public static enum LableStatus{
		yx(1, "有效"),
		wx(0, "无效"),
		;

		private int id;

		private String desc;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		LableStatus(int id, String desc) {
			this.id = id;
			this.desc = desc;
		}

		public static LableStatus getLableStatus(int id) {
			for (LableStatus lableStatus : values()) {
				if (lableStatus.getId() == id) {
					return lableStatus;
				}
			}
			return null;
		}
	}
	
}
