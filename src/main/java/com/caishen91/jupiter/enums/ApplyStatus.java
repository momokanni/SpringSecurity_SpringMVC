package com.caishen91.jupiter.enums;

public enum ApplyStatus {

	appling(1, "待提审", "//img.91caishen.com/source/images/system/bq_dts.png", false),
	waitFirstAudit(2, "待初审", "//img.91caishen.com/source/images/system/bq_dcs.png", false),
	firstAuditFailed(3, "初审驳回",  "//img.91caishen.com/source/images/system/bq_csbh.png", false),
	waitSecondAudit(4, "待复审", "//img.91caishen.com/source/images/system/bq_dfs.png", false),
	secondAuditFailed(5, "复审驳回", "//img.91caishen.com/source/images/system/bq_fsbh.png", false),
	waitFinalAudit(6, "待终审",  "//img.91caishen.com/source/images/system/bq_dzs.png", false),
	finalAuditFailed(7, "终审驳回", "//img.91caishen.com/source/images/system/bq_zsbh.png", false),
	waitInterview(8, "待面谈", "//img.91caishen.com/source/images/system/bq_mt.png", false),
	handling(9, "权证风控待受理", "//img.91caishen.com/source/images/system/bq_ywbl.png", false), 
	interviewFailed(10, "面谈退件", "//img.91caishen.com/source/images/system/bq_mttj.png", false),
	waitBusinessCheck(11, "待复核", "//img.91caishen.com/source/images/system/bq_dfh.png", false),
	businessCheckFailed(12, "业务复核失败",  "//img.91caishen.com/source/images/system/bq_fhbh.png", false),
	waitBusinessAudit(13, "待放款会审","//img.91caishen.com/source/images/system/bq_dfkhs.png", false),
	businessAuditFailed(14, "放款会审驳回",  "//img.91caishen.com/source/images/system/bq_spbh.png", false), //tu
	waitLoan(15, "待放款终审", "//img.91caishen.com/source/images/system/bq_dfkzs.png", false),
	loanFailed(16, "放款失败",  "//img.91caishen.com/source/images/system/bq_fkbh.png", false),
	loanSuccess(17, "已放款",  "//img.91caishen.com/source/images/system/bq_fkwc.png", false),
	handlingInterviewed(18, "权证受理中",  "//img.91caishen.com/source/images/system/bq_ywbl.png", false), 
	handledInterview(19, "风控待审批", "//img.91caishen.com/source/images/system/bq_fkdsp.png", false),
	repaySuccess(20, "已还款",  "", false),
	additionWaitFirstAudit(50, "追加借款待初审", "//img.91caishen.com/source/images/system/bq_dcs.png", true),
	additionFirstAuditFailed(51, "追加借款待初审驳回", "//img.91caishen.com/source/images/system/bq_csbh.png", true),
	additionWaitSecondAudit(52, "追加借款待复审", "//img.91caishen.com/source/images/system/bq_dfs.png", true),
	additionSecondAuditFailed(53, "追加借款复审驳回", "//img.91caishen.com/source/images/system/bq_fsbh.png", true),
	additionWaitFinalAudit(54, "追加借款待终审",  "//img.91caishen.com/source/images/system/bq_dzs.png",true),
	additionFinalAuditFailed(55, "追加借款终审驳回", "//img.91caishen.com/source/images/system/bq_zsbh.png",true),
	additionWaitLoan(56, "追加借款待放款终审", "//img.91caishen.com/source/images/system/bq_dfkzs.png",true),
	
	reloanWaitAudit(57, "展期待复核", "//img.91caishen.com/source/images/system/bq_zqdfh.png", false),
	reloanPassed(58, "展期成功", "//img.91caishen.com/source/images/system/bq_zqcg.png", false),
	reloanReject(59, "展期复核驳回", "//img.91caishen.com/source/images/system/bq_zqbh.png", false),
	
	qzReject(60, "权证撤件", "//img.91caishen.com/source/images/system/bq_qzcd.png", false),
	buReject(61, "业务撤件", "//img.91caishen.com/source/images/system/bq_ywcz.png", false),
	
	reloanFinanceAudit(62, "展期待财务审批", "//img.91caishen.com/source/images/system/bq_dcwsp.png", false),
	reloanFinanceAuditReject(63, "展期财务审批驳回", "//img.91caishen.com/source/images/system/bq_cwbh.png", false),
	
	deleted(99, "已取消", "", false);
	
	private int status;
	
	private String desc;
	
	private String messageImg;
	
	private boolean addition;
	
	public boolean isAddition() {
		return addition;
	}

	public void setAddition(boolean addition) {
		this.addition = addition;
	}

	public String getMessageImg() {
		return messageImg;
	}

	public void setMessageImg(String messageImg) {
		this.messageImg = messageImg;
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
	
	private ApplyStatus(int status, String desc, String messageImg, boolean addition) {
		this.status = status;
		this.desc = desc;
		this.messageImg = messageImg;
		this.addition = addition;
	}
	
	public static ApplyStatus getApplyStatusByStatus(int status) {
		for(ApplyStatus as : values()) {
			if (as.getStatus() == status) {
				return as;
			}
		}
		return null;
	}
}
