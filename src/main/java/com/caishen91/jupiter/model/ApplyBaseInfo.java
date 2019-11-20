package com.caishen91.jupiter.model;


import com.caishen91.jupiter.enums.ApplyStatus;

import java.math.BigDecimal;
import java.util.Date;

public class ApplyBaseInfo {


	private int id;
	
	private int argument;
	
	private String name;
	
	private BigDecimal amount;
	
	private int termCount;
	
	private int termUnit;
	
	private BigDecimal rate;
	
	private BigDecimal platRate;
	
	private BigDecimal returnRate;
	
	private BigDecimal totalRate;
	
	private Date planUseDate;
	
	private Date planRepayDate;
	
	private Date createTime;
	
	private int status;
	
	private int businessType;
	
	private int upEnterpriseId;
	
	private int downEnterpriseId;
	
	private int userId;
	
	private String applyUserOtherInfo;
	
	private String remark;
	
	private String upEnterpriseRemark;
	
	private String downEnterpriseRemark;
	
	private BigDecimal totalFee;
	
	private BigDecimal returnFee;
	
	private BigDecimal platFee;
	
	private String orderNo;
	
	private String fileNo;
	
	private Date loanDate;
	
	private boolean display;
	
	private int allocateStatus; //业务分配状态
	
	private int interviewUserId; //指派的面谈人id
	
	private String applyUserMobile;
	
	private String applyUserIdCardNo;
	
	private int businessCheckId;
	
	private boolean financeDisplay;
	
	private boolean firstAuditDisplay;
	
	private boolean secondAuditDisplay;
	
	private boolean finalAuditDisplay;
	
	private boolean businessCheckDisplay;
	
	private boolean businessAuditDisplay;
	
	private boolean loanAuditDisplay;
	
	private boolean allocateDisplay;
	
	private boolean bossDisplay;
	
	private boolean leaderDisplay;
	
	private boolean calendarDisplay;
	
	private int fhAuditId;
	
	private String handelUserIds;
	
	private int defaultUpEnterpriseInfoId; //业务员添加的上游企业id,指向apply_updown_info 的id
	
	private int defaultDownEnterpriseId; //业务员添加的下游企业id,指向apply_updown_info 的id
	
	private boolean additionalApply; //是否是追加借款
	
	private int mainBaseId; //主借款id
	
	private String creditAccompanior; //征信陪同人
	
	private String upAccompanior; //上家陪同人
	
	private String downAccompanior; //下家陪同人
	
	private boolean loaned;
	
	private boolean reloanApply; //是否展期
	
	private int reloanRepayplanId;
	
	private int hasSelfUseAmount; //自用资金　0 不确定　1 有　2 无
	
	private BigDecimal selfUseAmount; //自用金额
	
	private Date selfUseDate;
	
	private int selfUseTerm;
	
	private BigDecimal selfUseRate;
	
	private BigDecimal selfUseFee; //自用费用
	
	private int backReason; //撤件原因
	
	private String backRemark; //撤件补充说明
	
	private Date backTime; //撤件时间
	
	private int loanStatus;//融资状态
	
	private int productId;
	
	private boolean hasUpEnterprise;
	
	private BigDecimal repayAmount;
	
	private Date repayDate;
	
	private Date repayTime;
	
	private String repayRemark;
	
	private String propertyCertNo;
	
	public String getPropertyCertNo() {
		return propertyCertNo;
	}

	public void setPropertyCertNo(String propertyCertNo) {
		this.propertyCertNo = propertyCertNo;
	}

	public String getRepayRemark() {
		return repayRemark;
	}

	public void setRepayRemark(String repayRemark) {
		this.repayRemark = repayRemark;
	}

	public BigDecimal getRepayAmount() {
		return repayAmount;
	}

	public void setRepayAmount(BigDecimal repayAmount) {
		this.repayAmount = repayAmount;
	}

	public Date getRepayDate() {
		return repayDate;
	}

	public void setRepayDate(Date repayDate) {
		this.repayDate = repayDate;
	}

	public Date getRepayTime() {
		return repayTime;
	}

	public void setRepayTime(Date repayTime) {
		this.repayTime = repayTime;
	}

	public boolean isHasUpEnterprise() {
		return hasUpEnterprise;
	}

	public void setHasUpEnterprise(boolean hasUpEnterprise) {
		this.hasUpEnterprise = hasUpEnterprise;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(int loanStatus) {
		this.loanStatus = loanStatus;
	}

	public Date getBackTime() {
		return backTime;
	}

	public void setBackTime(Date backTime) {
		this.backTime = backTime;
	}

	public int getBackReason() {
		return backReason;
	}

	public void setBackReason(int backReason) {
		this.backReason = backReason;
	}

	public String getBackRemark() {
		return backRemark;
	}

	public void setBackRemark(String backRemark) {
		this.backRemark = backRemark;
	}

	public BigDecimal getSelfUseRate() {
		return selfUseRate;
	}

	public void setSelfUseRate(BigDecimal selfUseRate) {
		this.selfUseRate = selfUseRate;
	}

	public BigDecimal getSelfUseFee() {
		return selfUseFee;
	}

	public void setSelfUseFee(BigDecimal selfUseFee) {
		this.selfUseFee = selfUseFee;
	}

	public BigDecimal getSelfUseAmount() {
		return selfUseAmount;
	}

	public void setSelfUseAmount(BigDecimal selfUseAmount) {
		this.selfUseAmount = selfUseAmount;
	}

	public Date getSelfUseDate() {
		return selfUseDate;
	}

	public void setSelfUseDate(Date selfUseDate) {
		this.selfUseDate = selfUseDate;
	}

	public int getSelfUseTerm() {
		return selfUseTerm;
	}

	public void setSelfUseTerm(int selfUseTerm) {
		this.selfUseTerm = selfUseTerm;
	}

	public int getHasSelfUseAmount() {
		return hasSelfUseAmount;
	}

	public void setHasSelfUseAmount(int hasSelfUseAmount) {
		this.hasSelfUseAmount = hasSelfUseAmount;
	}

	public int getReloanRepayplanId() {
		return reloanRepayplanId;
	}

	public void setReloanRepayplanId(int reloanRepayplanId) {
		this.reloanRepayplanId = reloanRepayplanId;
	}

	public boolean isReloanApply() {
		return reloanApply;
	}

	public void setReloanApply(boolean reloanApply) {
		this.reloanApply = reloanApply;
	}

	public boolean isLoaned() {
		return loaned;
	}

	public void setLoaned(boolean loaned) {
		this.loaned = loaned;
	}

	public String getUpAccompanior() {
		return upAccompanior;
	}

	public void setUpAccompanior(String upAccompanior) {
		this.upAccompanior = upAccompanior;
	}

	public String getDownAccompanior() {
		return downAccompanior;
	}

	public void setDownAccompanior(String downAccompanior) {
		this.downAccompanior = downAccompanior;
	}

	public String getCreditAccompanior() {
		return creditAccompanior;
	}

	public void setCreditAccompanior(String creditAccompanior) {
		this.creditAccompanior = creditAccompanior;
	}

	public boolean isAdditionalApply() {
		return additionalApply;
	}

	public void setAdditionalApply(boolean additionalApply) {
		this.additionalApply = additionalApply;
	}

	public int getMainBaseId() {
		return mainBaseId;
	}

	public void setMainBaseId(int mainBaseId) {
		this.mainBaseId = mainBaseId;
	}

	public int getDefaultUpEnterpriseInfoId() {
		return defaultUpEnterpriseInfoId;
	}

	public void setDefaultUpEnterpriseInfoId(int defaultUpEnterpriseInfoId) {
		this.defaultUpEnterpriseInfoId = defaultUpEnterpriseInfoId;
	}

	public int getDefaultDownEnterpriseId() {
		return defaultDownEnterpriseId;
	}

	public void setDefaultDownEnterpriseId(int defaultDownEnterpriseId) {
		this.defaultDownEnterpriseId = defaultDownEnterpriseId;
	}

	public String getHandelUserIds() {
		return handelUserIds;
	}

	public void setHandelUserIds(String handelUserIds) {
		this.handelUserIds = handelUserIds;
	}

	public int getFhAuditId() {
		return fhAuditId;
	}

	public void setFhAuditId(int fhAuditId) {
		this.fhAuditId = fhAuditId;
	}

	public boolean isLoanSuccess() {
		return status == ApplyStatus.loanSuccess.getStatus();
	}
	public boolean isFinanceDisplay() {
		return financeDisplay;
	}

	public void setFinanceDisplay(boolean financeDisplay) {
		this.financeDisplay = financeDisplay;
	}

	public boolean isFirstAuditDisplay() {
		return firstAuditDisplay;
	}

	public void setFirstAuditDisplay(boolean firstAuditDisplay) {
		this.firstAuditDisplay = firstAuditDisplay;
	}

	public boolean isSecondAuditDisplay() {
		return secondAuditDisplay;
	}

	public void setSecondAuditDisplay(boolean secondAuditDisplay) {
		this.secondAuditDisplay = secondAuditDisplay;
	}

	public boolean isFinalAuditDisplay() {
		return finalAuditDisplay;
	}

	public void setFinalAuditDisplay(boolean finalAuditDisplay) {
		this.finalAuditDisplay = finalAuditDisplay;
	}

	public boolean isBusinessCheckDisplay() {
		return businessCheckDisplay;
	}

	public void setBusinessCheckDisplay(boolean businessCheckDisplay) {
		this.businessCheckDisplay = businessCheckDisplay;
	}

	public boolean isBusinessAuditDisplay() {
		return businessAuditDisplay;
	}

	public void setBusinessAuditDisplay(boolean businessAuditDisplay) {
		this.businessAuditDisplay = businessAuditDisplay;
	}

	public boolean isLoanAuditDisplay() {
		return loanAuditDisplay;
	}

	public void setLoanAuditDisplay(boolean loanAuditDisplay) {
		this.loanAuditDisplay = loanAuditDisplay;
	}

	public boolean isAllocateDisplay() {
		return allocateDisplay;
	}

	public void setAllocateDisplay(boolean allocateDisplay) {
		this.allocateDisplay = allocateDisplay;
	}

	public boolean isBossDisplay() {
		return bossDisplay;
	}

	public void setBossDisplay(boolean bossDisplay) {
		this.bossDisplay = bossDisplay;
	}

	public boolean isLeaderDisplay() {
		return leaderDisplay;
	}

	public void setLeaderDisplay(boolean leaderDisplay) {
		this.leaderDisplay = leaderDisplay;
	}

	public boolean isCalendarDisplay() {
		return calendarDisplay;
	}

	public void setCalendarDisplay(boolean calendarDisplay) {
		this.calendarDisplay = calendarDisplay;
	}

	public int getBusinessCheckId() {
		return businessCheckId;
	}

	public void setBusinessCheckId(int businessCheckId) {
		this.businessCheckId = businessCheckId;
	}

	public String getApplyUserMobile() {
		return applyUserMobile;
	}

	public void setApplyUserMobile(String applyUserMobile) {
		this.applyUserMobile = applyUserMobile;
	}

	public String getApplyUserIdCardNo() {
		return applyUserIdCardNo;
	}

	public void setApplyUserIdCardNo(String applyUserIdCardNo) {
		this.applyUserIdCardNo = applyUserIdCardNo;
	}

	public int getInterviewUserId() {
		return interviewUserId;
	}

	public void setInterviewUserId(int interviewUserId) {
		this.interviewUserId = interviewUserId;
	}

	public int getAllocateStatus() {
		return allocateStatus;
	}

	public void setAllocateStatus(int allocateStatus) {
		this.allocateStatus = allocateStatus;
	}

	public boolean isDisplay() {
		return display;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}

	public Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getFileNo() {
		return fileNo;
	}

	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}

	public BigDecimal getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(BigDecimal totalFee) {
		this.totalFee = totalFee;
	}

	public BigDecimal getReturnFee() {
		return returnFee;
	}

	public void setReturnFee(BigDecimal returnFee) {
		this.returnFee = returnFee;
	}

	public BigDecimal getPlatFee() {
		return platFee;
	}

	public void setPlatFee(BigDecimal platFee) {
		this.platFee = platFee;
	}

	public String getUpEnterpriseRemark() {
		return upEnterpriseRemark;
	}

	public void setUpEnterpriseRemark(String upEnterpriseRemark) {
		this.upEnterpriseRemark = upEnterpriseRemark;
	}

	public String getDownEnterpriseRemark() {
		return downEnterpriseRemark;
	}

	public void setDownEnterpriseRemark(String downEnterpriseRemark) {
		this.downEnterpriseRemark = downEnterpriseRemark;
	}

	public String getApplyUserOtherInfo() {
		return applyUserOtherInfo;
	}

	public void setApplyUserOtherInfo(String applyUserOtherInfo) {
		this.applyUserOtherInfo = applyUserOtherInfo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUpEnterpriseId() {
		return upEnterpriseId;
	}

	public void setUpEnterpriseId(int upEnterpriseId) {
		this.upEnterpriseId = upEnterpriseId;
	}

	public int getDownEnterpriseId() {
		return downEnterpriseId;
	}

	public void setDownEnterpriseId(int downEnterpriseId) {
		this.downEnterpriseId = downEnterpriseId;
	}

	public BigDecimal getTotalRate() {
		return totalRate;
	}

	public void setTotalRate(BigDecimal totalRate) {
		this.totalRate = totalRate;
	}

	public int getTermUnit() {
		return termUnit;
	}

	public void setTermUnit(int termUnit) {
		this.termUnit = termUnit;
	}

	public int getBusinessType() {
		return businessType;
	}

	public void setBusinessType(int businessType) {
		this.businessType = businessType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean needArgument() {
		return argument == ApplyArgument.need.getArgument();
	}
	
	public boolean wontArgument() {
		return argument == ApplyArgument.wont.getArgument();
	}

	public boolean isAdditionWaitLoan() {
		return status == ApplyStatus.additionWaitLoan.getStatus();
	}
	
	public int getArgument() {
		return argument;
	}

	public void setArgument(int argument) {
		this.argument = argument;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public int getTermCount() {
		return termCount;
	}

	public void setTermCount(int termCount) {
		this.termCount = termCount;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public BigDecimal getPlatRate() {
		return platRate;
	}

	public void setPlatRate(BigDecimal platRate) {
		this.platRate = platRate;
	}

	public BigDecimal getReturnRate() {
		return returnRate;
	}

	public void setReturnRate(BigDecimal returnRate) {
		this.returnRate = returnRate;
	}

	public Date getPlanUseDate() {
		return planUseDate;
	}

	public void setPlanUseDate(Date planUseDate) {
		this.planUseDate = planUseDate;
	}

	public Date getPlanRepayDate() {
		return planRepayDate;
	}

	public void setPlanRepayDate(Date planRepayDate) {
		this.planRepayDate = planRepayDate;
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
	
	public boolean isAppling() {
		return status == ApplyStatus.appling.getStatus();
	}
	
	public boolean isAdditionReject() {
		return status == ApplyStatus.additionFirstAuditFailed.getStatus() ||
				status == ApplyStatus.additionSecondAuditFailed.getStatus() ||
				status == ApplyStatus.additionFinalAuditFailed.getStatus();
	}
	
	public static enum ApplyArgument {
		unkonw(0, "不确定"),
		need(1, "需要"),
		wont(2, "不需要");
		
		private int argument;
		
		private String desc;

		public int getArgument() {
			return argument;
		}

		public void setArgument(int argument) {
			this.argument = argument;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}
		
		private ApplyArgument(int argument, String desc) {
			this.argument = argument;
			this.desc = desc;
		}
	}
	
	public boolean isHasSelfUseAmountFlag() {
		return hasSelfUseAmount == ApplyHasSelfUseAmount.has.getType();
	}
	
	public boolean isHasntSelfUseAmountFlag() {
		return hasSelfUseAmount == ApplyHasSelfUseAmount.none.getType();
	}
	
	public boolean isUnkonwSelfUseAmountFlag() {
		return hasSelfUseAmount == ApplyHasSelfUseAmount.unknow.getType();
	}
	
	public static enum ApplyHasSelfUseAmount {
		
		unknow(0, "不确定"),
		has(1, "有"),
		none(2, "无");
		
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



		private ApplyHasSelfUseAmount(int type, String desc) {
			this.type = type;
			this.desc = desc;
		}
	}
	
}
