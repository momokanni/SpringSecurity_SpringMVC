package com.caishen91.jupiter.enums;

public enum StatusChange {
	
	appling(0, 1, "进件", "进件录入"),
	applyCommit(1, 2,"进件", "提交申请"),
	firstAuditReject(2, 3, "初审", "驳回"),
	applyReCommitAfterFirstAuditReject(3,2, "进件", "提交申请"),
	firstAuditPassed(2, 4, "初审", "通过"),
	secondAuditReject(4, 5, "复审", "驳回"),
	applyReCommitAfterSecondAuditReject(5,2, "进件", "提交申请"),
	secondAuditPassed(4, 6, "复审", "通过"),
	finalAuditReject(6, 7, "终审", "驳回"),
	applyReCommitAfterFinalAuditReject(7, 2, "进件", "提交申请"),
	finalAuditPassed(6, 9, "终审", "通过"),
	riskReject(9, 10, "面谈", "退件"),
	warrantCommit(9, 19, "权证", "提交"),
	riskRejectAfterWarrantCommit(19, 10, "面谈", "退件"),
	riskPassed(9, 18, "面谈", "通过"),
	warrantCommitAfterRiskPassed(18, 11, "权证", "提交"),
	riskPassedAfterWarrantCommit(19, 11, "面谈", "通过"),
	businessCheckReject(11, 12, "业务复核", "驳回"),
	warrantCommitAfterBusinessCheckReject(12,11, "权证", "提交"),
	businessCheckPassed(11, 13, "业务复核", "通过"),
	businessAuditPassed(13,13,"放款会审", "通过"),
	businessAuditReject(13,14, "放款会审", "驳回"),
	businessCheckPassedAfterAuditReject(14, 13, "业务复核", "通过"),
	businessAuditAllPassed(13,15, "放款会审", "通过"),
	loanReject(15, 16, "放款终审", "驳回"),
	warrantCommitAfterLoanReject(16,11, "权证", "提交"),
	loanSuccess(15,17, "放款终审", "通过"),
	loanSuccessPart(15,15,"放款终审", "通过"),
	repaySuccess(17,17, "还款审核", "通过"),
	repaySuccess2(17,20, "还款审核", "通过"),
	repaySuccess3(59,59, "还款审核", "通过"),
	repaySuccess4(59,20, "还款审核", "通过"),
	
	additionCommit(0,50, "追加借款", "提交申请"),
	additionFirstAuditPasswd(50, 52, "追款初审", "通过"),
	additionFirstAuditReject(50, 51, "追款初审", "驳回"),
	additionSecondAuditPasswd(52, 54, "追款复审", "通过"),
	additionSecondAuditReject(52, 53, "追款复审", "驳回"),
	additionFinalAuditPassed(54, 56, "追款终审", "通过"),
	additionFinalAuditReject(54, 55, "追款终审", "驳回"),
	
	reloanApply(17,57, "展期", "提交申请"),
	reloanReject(57, 59, "展期业务审批","驳回"),
	reloanApply2(59,57, "展期", "提交申请"),
	reloanApply3(63,57, "展期", "提交申请"),
	reloanPasswd(57,58, "展期审批", "通过"),
	reloanBusinessPasswd(57, 62, "展期业务审批", "通过"),
	reloanFinanceReject(62, 63, "展期财务审批", "驳回"),
	reloanPasswd2(62,58, "展期审批", "通过"),
	
	buReject(-1,61, "撤件", "业务撤件"),
	qzReject(-1,60, "撤件", "权证撤件"),
	;

	private int oldStatus;
	
	private int newStatus;
	
	private String opTitle;
	
	private String op;

	public int getOldStatus() {
		return oldStatus;
	}

	public void setOldStatus(int oldStatus) {
		this.oldStatus = oldStatus;
	}

	public int getNewStatus() {
		return newStatus;
	}

	public void setNewStatus(int newStatus) {
		this.newStatus = newStatus;
	}

	public String getOpTitle() {
		return opTitle;
	}

	public void setOpTitle(String opTitle) {
		this.opTitle = opTitle;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}
	
	private StatusChange(int oldStatus, int newStatus, String opTitle, String op) {
		this.oldStatus = oldStatus;
		this.newStatus = newStatus;
		this.opTitle = opTitle;
		this.op = op;
	}
	
	public static StatusChange getStatusChangeByStatus(int oldStatus, int newStatus) {
		if (newStatus == ApplyStatus.buReject.getStatus()) {
			return buReject;
		} else if (newStatus == ApplyStatus.qzReject.getStatus()) {
			return qzReject;
		}
		for(StatusChange sc : StatusChange.values()) {
			if (sc.getOldStatus() == oldStatus && sc.getNewStatus() == newStatus) {
				return sc;
			}
		}
		return null;
	}
}
