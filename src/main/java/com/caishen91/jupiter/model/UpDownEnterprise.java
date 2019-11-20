package com.caishen91.jupiter.model;


import com.caishen91.jupiter.enums.CommonStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UpDownEnterprise {

	
	private int id;
	
	private int type;
	
	private String name;
	
	private Date createTime;
	
	private int status;
	
	private List<UpDownEnterpriseTag> tags = new ArrayList();

	public List<UpDownEnterpriseTag> getTags() {
		return tags;
	}

	public void setTags(List<UpDownEnterpriseTag> tags) {
		this.tags = tags;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public boolean isAvailable() {
		return status == CommonStatus.available.getStatus();
	}
	
	public static enum UpDownEnterpriseType {
		
		up(1, "上游企业"),
		down(2, "下游企业");
		
		private int type;
		
		private String desc;

		public int getType() {
			return type;
		}

		public void setType(int type) {
			this.type = type;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}
		
		private UpDownEnterpriseType(int type, String desc) {
			this.type = type;
			this.desc = desc;
		}
		
		public static UpDownEnterpriseType getUpDownEnterpriseTypeByType(int type) {
			for(UpDownEnterpriseType t : UpDownEnterpriseType.values()) {
				if (t.getType() == type) {
					return t;
				}
			}
			return null;
		}
	}
}
