package com.caishen91.jupiter.model;


import com.caishen91.jupiter.enums.CommonStatus;
import com.caishen91.jupiter.enums.MarryStatus;

import java.util.Date;

public class ApplyUserInfo {

	
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
	
	public int getRelationship() {
		return relationship;
	}

	public void setRelationship(int relationship) {
		this.relationship = relationship;
	}

	public int getMarryStatus() {
		return marryStatus;
	}

	public void setMarryStatus(int marryStatus) {
		this.marryStatus = marryStatus;
	}

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
	
	public boolean isApplier() {
		return type == ApplyUserType.applier.getType();
	}
	
	public boolean isCoApplier() {
		return type == ApplyUserType.coApplier.getType();
	}
	
	public boolean isContact() {
		return type == ApplyUserType.contact.getType();
	}
	
	public boolean isCouple() {
		return type == ApplyUserType.couple.getType();
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
	
	public static enum ApplyUserType {
		
		applier(1, "借款人"),
		coApplier(2, "共同借款人"),
		contact(3, "紧急联系人"),
		couple(4, "配偶");
		
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
		
		private ApplyUserType(int type, String desc) {
			this.type = type;
			this.desc = desc;
		}
		
	}
	
	public void mergeTmpInfo(ApplyUserInfoTmp auit) {
		this.name = auit.getName();
		this.idCardNo = auit.getIdCardNo();
		this.mobile = auit.getMobile();
		this.marryStatus = auit.getMarryStatus();
		this.relationship = auit.getRelationship();
	}
	
	public ApplyUserInfo() {
		
	}
	
	public ApplyUserInfo(ApplyUserInfoTmp auit) {
		this.createTime = new Date();
		this.status = CommonStatus.available.getStatus();
		this.name = auit.getName();
		this.idCardNo = auit.getIdCardNo();
		this.mobile = auit.getMobile();
		this.marryStatus = auit.getMarryStatus();
		this.relationship = auit.getRelationship();
		this.type = auit.getType();
		this.baseInfoId = auit.getBaseInfoId();
	}
}
