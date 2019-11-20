package com.caishen91.jupiter.service;

import com.caishen91.jupiter.enums.AuditType;
import com.caishen91.jupiter.enums.SmsContentType;
import com.caishen91.jupiter.model.*;
import com.caishen91.jupiter.util.OperationResult;

import java.util.Map;

/**
 *   提供邮件，手机等验证记录的服务
 *
 */
public interface ISmsService
{

	public OperationResult smsCodeChecker(String ip, String cookie, int rt);
	
	public RegSmsCheck getLastSmsCheckCode(String ip, String cookie, String mobile, int ref);
	
	/**
	 * 
	* @描述：验证短信通道是否正常
	* @开发时间： 2014-9-25 下午4:03:18
	 */
	public RegSmsCheck getLastSmsCheckCodePass(String ip, String cookie, String mobile, int ref);
	/**
	 * 
	* @描述：修改短信渠道
	* @开发时间： 2014-9-25 下午4:41:47
	 */
	public void updateSmsCheckCodeChannel(RegSmsCheck check);
	
	public boolean addRegSmsCheck(RegSmsCheck rsc);
	
	public boolean resendRegSmsCheck(RegSmsCheck rsc);
	
	public OperationResult smsCodeCheck(String ip, String global, String mobile, String code, int ref);

	public boolean addMobileAvailableCheck(MobileAvailable ma);

	public boolean addMobileCheckToken(MobileCheckToken mct);

	public MobileCheckToken getMobileCheckToken(String token);

	/**
	 *
	* @描述：添加短信渠道及短信模板
	* @开发时间： 2014-9-25 下午5:31:05
	 */
	public boolean addSms(String mobile, String content, int smsType, String channel);


	public SmsTrace getSmsTraceById(int id);

	public void addAlarm(SmsContentType sct, Map params);
	
	public void autoSendSms();
	
	public boolean applySms(ApplyBaseInfo abi, AuditType at, SysUser auditSysUser);
	
}
