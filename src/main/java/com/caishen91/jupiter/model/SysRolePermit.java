package com.caishen91.jupiter.model;

import java.util.Date;

public class SysRolePermit {

	private int id;
	 
	private int roleId;
	
	private int refId;
	
	private Date createTime;
	
	private Date updateTime;
	
	private boolean permit=false;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getRefId() {
		return refId;
	}

	public void setRefId(int refId) {
		this.refId = refId;
	}

	public boolean isPermit() {
		return permit;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public void setPermit(boolean permit) {
		this.permit = permit;
	}

}
