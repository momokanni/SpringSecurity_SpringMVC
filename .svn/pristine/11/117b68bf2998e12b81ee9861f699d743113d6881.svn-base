package com.caishen91.jupiter.enums;

public enum AllocateStatus {

	wont(0, "无需分配", ""),
	waitAllocate(1, "待分配", ""),
	allocated(2, "已分配", "接收分配"),
	turnApply(3, "申请转单", "申请转单"),
	turnAuditPassed(4, "转单", "接收转单"),
	turnAuditReject(5, "申请驳回", "驳回申请"),
	turnResume(7, "重新启用", ""),
	turnClose(8, "转单关闭", ""),
	allocateBack(9, "已撤回", "分配撤回"),
	finish(10, "已完成", "分配完成"),
	allocatePartBack(11, "部分撤回", "分配撤回"),
	allocateTrans(12, "已转出", "分配转出"),
	allocatePartTrans(13, "部分转出", "分配转出"),
	commit(6, "已提交", "");
	
	
	private int status;
	
	private String desc;
	
	private String displayName;
	
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

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
	
	private AllocateStatus(int status, String desc, String displayName) {
		this.status = status;
		this.desc = desc;
		this.displayName = displayName;
	}
	
	public static AllocateStatus getAllocateStatusByStatus(int status) {
		
		for(AllocateStatus as : AllocateStatus.values() ) {
			if (as.getStatus() == status) {
				return as;
			}
		}
		
		return null;
	}
}
