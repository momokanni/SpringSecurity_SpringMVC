package com.caishen91.jupiter.enums;

public enum AuditType {

	firstAudit(1, "初审", ApplyStatus.waitSecondAudit.getStatus() , ApplyStatus.firstAuditFailed.getStatus()),
	secondAudit(2, "二审", ApplyStatus.waitFinalAudit.getStatus() , ApplyStatus.secondAuditFailed.getStatus()),
	finalAudit(3, "终审", ApplyStatus.handling.getStatus() , ApplyStatus.finalAuditFailed.getStatus()),
	interview(4, "面谈", ApplyStatus.handling.getStatus(), ApplyStatus.interviewFailed.getStatus()),
	sumitBusiness(5, "提交业务复核", ApplyStatus.waitBusinessCheck.getStatus(), ApplyStatus.appling.getStatus()),
	businessCheck(6, "业务复核", ApplyStatus.waitBusinessAudit.getStatus(), ApplyStatus.businessCheckFailed.getStatus()),
	businessAudit(7, "业务审批", ApplyStatus.waitLoan.getStatus(), ApplyStatus.businessAuditFailed.getStatus()),
	loan(8, "放款审批", ApplyStatus.loanSuccess.getStatus(), ApplyStatus.loanFailed.getStatus()),
	repay(9, "还款审批", ApplyStatus.repaySuccess.getStatus(),ApplyStatus.loanSuccess.getStatus()),
	additionFirstAudit(20, "追加借款初审", ApplyStatus.additionWaitSecondAudit.getStatus(), ApplyStatus.additionFirstAuditFailed.getStatus()),
	additionSecondAudit(21, "追加借款复审", ApplyStatus.additionWaitFinalAudit.getStatus(), ApplyStatus.additionSecondAuditFailed.getStatus()),
	additionFinalAudit(22, "追加借款终审", ApplyStatus.additionWaitLoan.getStatus(), ApplyStatus.additionFinalAuditFailed.getStatus()),
	reloanAudit(23, "展期审批", ApplyStatus.reloanFinanceAudit.getStatus(), ApplyStatus.reloanReject.getStatus()),
	reloanFinanceAudit(24, "展期财务审批", ApplyStatus.reloanPassed.getStatus(), ApplyStatus.reloanFinanceAuditReject.getStatus()),
	
	otherAudit(99, "审核", 0,0);
	
	
	private int type;
	
	private String desc;
	
	private int successStatus;
	
	private int failedStatus;
	
	public int getSuccessStatus() {
		return successStatus;
	}

	public void setSuccessStatus(int successStatus) {
		this.successStatus = successStatus;
	}

	public int getFailedStatus() {
		return failedStatus;
	}

	public void setFailedStatus(int failedStatus) {
		this.failedStatus = failedStatus;
	}

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
	
	private AuditType(int type, String desc, int successStatus, int failedStatus) {
		this.type = type;
		this.desc = desc;
		this.successStatus = successStatus;
		this.failedStatus = failedStatus;
	}
	
	public static AuditType getAuditTypeByType(int type) {
		for(AuditType at : values()) {
			if (at.getType() == type) {
				return at;
			}
		}
		return null;
	}
	
	public static AuditType getAuditTypeByApplyStatus(int status) {
		ApplyStatus as = ApplyStatus.getApplyStatusByStatus(status);
		if (as == null) {
			return null;
		}
		switch (as) {
		case waitFirstAudit:
			return firstAudit;
		case waitSecondAudit:
			return secondAudit;
		case waitFinalAudit:
			return finalAudit;
		case waitBusinessCheck:
		case businessCheckFailed:
		case businessAuditFailed:
		case loanFailed:
			return businessCheck;
		case waitBusinessAudit:
			return businessAudit;
		case waitLoan:
			return loan;
		case additionWaitFirstAudit :
			return additionFirstAudit;
		case additionWaitSecondAudit:
			return additionSecondAudit;
		case additionWaitFinalAudit:
			return additionFinalAudit;
		case loanSuccess:
		case reloanReject:
		case reloanPassed:
			return repay;
		case reloanWaitAudit:
			return reloanAudit;
		case reloanFinanceAudit :
			return reloanFinanceAudit;
		}
		
		return otherAudit;
	}
}
