package com.caishen91.jupiter.model;

import com.caishen91.jupiter.enums.MarryStatus;

import java.util.Date;

public class ApplyUserInfoTmp {

	private int id;
	
	private int baseInfoId;
	
	private String name;
	
	private Date createTime;
	
	private String mobile;
	
	private int status;
	
	private String idCardNo;
	
	private int type;
	
	private int marryStatus;
	
	private int relationship;
	
	private int applyUserId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBaseInfoId() {
		return baseInfoId;
	}

	public void setBaseInfoId(int baseInfoId) {
		this.baseInfoId = baseInfoId;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getMarryStatus() {
		return marryStatus;
	}

	public void setMarryStatus(int marryStatus) {
		this.marryStatus = marryStatus;
	}

	public int getRelationship() {
		return relationship;
	}

	public void setRelationship(int relationship) {
		this.relationship = relationship;
	}

	public int getApplyUserId() {
		return applyUserId;
	}

	public void setApplyUserId(int applyUserId) {
		this.applyUserId = applyUserId;
	}
	
	
	public boolean isApplier() {
		return type == ApplyUserInfo.ApplyUserType.applier.getType();
	}
	
	public boolean isCoApplier() {
		return type == ApplyUserInfo.ApplyUserType.coApplier.getType();
	}
	
	public boolean isContact() {
		return type == ApplyUserInfo.ApplyUserType.contact.getType();
	}
	
	public boolean isCouple() {
		return type == ApplyUserInfo.ApplyUserType.couple.getType();
	}
	
	public boolean isMarried() {
		return marryStatus == MarryStatus.married.getStatus();
	}
	
	public boolean isDivorced() {
		return marryStatus == MarryStatus.divorced.getStatus();
	}
	
	
	public boolean isUnMarried() {
		return marryStatus == MarryStatus.unMarried.getStatus();
	}
	
}
