package com.caishen91.jupiter.util;

import com.caishen91.jupiter.enums.ApplyStatus;

import java.util.HashSet;
import java.util.Set;

public class ApplyOpStatusUtil {

	public static final Set<Integer> applyUserUpdateStatus = new HashSet();  //进件申请更新借款人时所允许的进件状态
	
	public static final Set<Integer> warrantStatus = new HashSet(); //权证处理所允许的进件状态
	
	public static final Set<Integer> interviewStatus = new HashSet(); //面谈处理所允许的进件状态
	
	public static final Set<Integer> reloanStatus = new HashSet();
	
	public static final Set<Integer> warrantBackStatus = new HashSet(); //权证撤单所允许状态
	
	static {
		applyUserUpdateStatus.add(ApplyStatus.appling.getStatus());
		applyUserUpdateStatus.add(ApplyStatus.firstAuditFailed.getStatus());
		applyUserUpdateStatus.add(ApplyStatus.secondAuditFailed.getStatus());
		applyUserUpdateStatus.add(ApplyStatus.finalAuditFailed.getStatus());
		
		
		warrantStatus.add(ApplyStatus.handling.getStatus());
		warrantStatus.add(ApplyStatus.businessCheckFailed.getStatus());
		warrantStatus.add(ApplyStatus.loanFailed.getStatus());
		warrantStatus.add(ApplyStatus.handlingInterviewed.getStatus());
		
		
		interviewStatus.add(ApplyStatus.handling.getStatus());
		interviewStatus.add(ApplyStatus.handledInterview.getStatus());
		
		reloanStatus.add(ApplyStatus.loanSuccess.getStatus());
		reloanStatus.add(ApplyStatus.reloanReject.getStatus());
		reloanStatus.add(ApplyStatus.reloanPassed.getStatus());
		reloanStatus.add(ApplyStatus.reloanFinanceAuditReject.getStatus());
		
		warrantBackStatus.add(ApplyStatus.handling.getStatus());
		warrantBackStatus.add(ApplyStatus.handlingInterviewed.getStatus());
		warrantBackStatus.add(ApplyStatus.loanFailed.getStatus());
	}
}
