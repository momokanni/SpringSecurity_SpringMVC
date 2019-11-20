package com.caishen91.jupiter.service.impl;

import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.controller.core.SmsController;
import com.caishen91.jupiter.dao.*;
import com.caishen91.jupiter.enums.*;
import com.caishen91.jupiter.model.*;
import com.caishen91.jupiter.service.ISendSmsService;
import com.caishen91.jupiter.service.ISmsService;
import com.caishen91.jupiter.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class SmsServiceImpl extends BaseService implements ISmsService {
	
	public static final int SMS_CHECK_TYPE_REG = 0; //注册用短信验证码
	public static final int SMS_CHECK_TYPE_MOD = 1; //修改用短信验证码
	
	static Set<Integer> validSmsCheckTypes = new HashSet<Integer>();
	static {
		validSmsCheckTypes.add(SMS_CHECK_TYPE_REG);
		validSmsCheckTypes.add(SMS_CHECK_TYPE_MOD);
	}
	
	private static Logger logger = LoggerFactory.getLogger(SmsServiceImpl.class);

	@Autowired
	private ISendSmsService sendSmsService;
	

	@Override
	public OperationResult smsCodeChecker(String ip, String cookie, int rt) {
		SmsMapper smsMapper = writableSQLSession.getMapper(SmsMapper.class);
		MobileAvailableMapper mobileAvailableMapper = writableSQLSession.getMapper(MobileAvailableMapper.class);
		OperationResult or = new OperationResult();
		or.setStatus(true);
		
//		if (!cookie.startsWith(ip)) {
//			System.out.println("[短信请求攻击]:" + ip + "," + cookie ); 
//			or.setStatus(false);
//			or.setMessage("超过一天最多可以发送短信验证码条数");
//			return or;
//		}
		
		int ipCount = smsMapper.getTodaySmsCheckCodeCountByIp(ip, new Date());
		if (ipCount > Config.SMS_CODE_PREDAY) {
			or.setStatus(false);
			or.setMessage("超过一天最多可以发送短信验证码条数");
			return or;
		}
		RegSmsCheck rsc = smsMapper.getLastSmsCheckCodeByIpCookie(ip, cookie);
		if (rsc != null) {
			if (System.currentTimeMillis() - rsc.getLastSendTime().getTime() < 60 * 1000L) {
				or.setStatus(false);
				or.setMessage("每台机器每分钟只能发送一条短信验证码");
				return or;
			}
		}
		if (rt == SmsRequestType.available.getId() || rt == SmsRequestType.unavailable.getId()) {
			int apCount = mobileAvailableMapper.getTodayMobileAvailableCountByIp(ip, new Date());
			if (apCount > Config.MOBILE_IP_AVAILABLE_PREDAY) {
				or.setStatus(false);
				or.setMessage("超过每天能够查询手机是否已注册次数");
				return or;
			}
			
			int mpCount = mobileAvailableMapper.getTodayMobileAvailableCountByMachine(ip, cookie, new Date());
			if (mpCount > Config.MOBILE_MACHINE_AVAILABLE_PREDAY) {
				or.setStatus(false);
				or.setMessage("超过每天能够查询手机是否已注册次数");
				return or;
			}
		}
		
		return or;
	}
	
	public RegSmsCheck getLastSmsCheckCode(String ip, String cookie, String mobile, int ref) {
		SmsMapper smsMapper = writableSQLSession.getMapper(SmsMapper.class);
		
		return smsMapper.getLastSmsCheckCode(ip, cookie, mobile, ref);
	}
	
	/**
	 * 验证是否通道可用
	 */
	public RegSmsCheck getLastSmsCheckCodePass(String ip, String cookie, String mobile, int ref){
		SmsMapper smsMapper = writableSQLSession.getMapper(SmsMapper.class);
		
		return smsMapper.getLastSmsCheckCodePass(ip, cookie, mobile, ref);
	}
	/**
	 * 
	* @描述：修改校验短信渠道
	* @开发时间： 2014-9-25 下午4:42:34
	 */
	public void updateSmsCheckCodeChannel(RegSmsCheck check){
		SmsMapper smsMapper = writableSQLSession.getMapper(SmsMapper.class);		
		 smsMapper.updateSmsCheckCodeChannel(check);
	}
	
	public boolean addRegSmsCheck(RegSmsCheck rsc) {
		SmsMapper smsMapper = writableSQLSession.getMapper(SmsMapper.class);
		try {
			smsMapper.addRegSmsCheck(rsc);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public boolean resendRegSmsCheck(RegSmsCheck rsc) {
		SmsMapper smsMapper = writableSQLSession.getMapper(SmsMapper.class);
		return smsMapper.resendRegSmsCheck(rsc) == 1;
	}
	
	public OperationResult smsCodeCheck(String ip, String global, String mobile, String code , int ref) {
		SmsMapper smsMapper = writableSQLSession.getMapper(SmsMapper.class);
		OperationResult or = new OperationResult();
		or.setStatus(true);
		String timeKey = System.currentTimeMillis() + "";
		logger.info("[" + timeKey + "]验证码校验，" + "ip:" + ip + ",global:" + global + ",mobile:" + mobile + ",code:" + code +  ",ref:" + ref);
		
		if (!ValidateUtil.isMobileNo(mobile)) {
			logger.warn("[" + timeKey + "]验证码校验，手机号码格式错误：" + mobile);
			or.setMessage("手机号码格式错误");
			or.setStatus(false);
			return or;
		}
		
		if (StringUtil.isEmpty(global)) {
			logger.warn("[" + timeKey + "]验证码校验，缺少全局cookie");
			or.setMessage("没有登录");
			or.setStatus(false);
			return or;
		}
		
		if (StringUtil.isEmpty(code)) {
			logger.warn("[" + timeKey + "]验证码校验，验证码为空");
			or.setMessage("验证码为空");
			or.setStatus(false);
			return or;
		}
		
		if (ref > 0) {
//			RegSmsCheck rsc = SmsDao.getInstance().getSmsCheckCodeById(ref);
//			if (rsc == null || rsc.getCheck_time() == null) {
//				logger.warn("[" + timeKey + "]验证码校验，找不到引用的校验数据," + ref);
//				or.setMessage("找不到对应的校验数据");
//				or.setStatus(false);
//				return or;
//			}
//			if (!rsc.getIp().equals(ip) || !rsc.getCookie().equals(global)) {
//				logger.warn("[" + timeKey + "]验证码校验，ip或cookie校验失败，" + ip + "," + global + "," + ref );
//				or.setMessage("ip或cookie校验失败");
//				or.setStatus(false);
//				return or;
//			}
//			if (rsc.getCheck_time() == null) {
//				logger.warn("[" + timeKey + "]验证码校验，所引用的校验还没有完成，" + ref );
//				or.setMessage("引用的校验还没有完成");
//				or.setStatus(false);
//				return or;
//			}
		}
		Map m = new HashMap();
		m.put("ip", ip);
		m.put("cookie", global);
		m.put("mobile", mobile);
		RegSmsCheck rsc =  smsMapper.getLastSmsCheckCode(ip, global, mobile, ref);// SmsDao.getInstance().getLastSmsCheckCode(m);
		if (rsc == null) {
			logger.warn("[" + timeKey + "]验证码校验，验证码未生成," + ip + "," + global + "," + mobile);
			or.setMessage("验证码未生成");
			or.setStatus(false);
			or.setCode(SmsController.SMS_CODE_EXPIRED);
			return or;
		}
		if (rsc.isExpire()) {
			logger.warn("[" + timeKey + "]验证码校验，验证码过期," + ip + "," + global + "," + mobile);
			or.setMessage("验证码过期");
			or.setStatus(false);
			or.setCode(SmsController.SMS_CODE_EXPIRED);
			return or;
		}
		if (rsc.getRef() > 0 && rsc.getRef() != ref) {
			logger.warn("[" + timeKey + "]验证码校验，引用校验不通过，" + rsc.getRef() + "，" + ref);
			or.setMessage("验证码验证失败");
			or.setStatus(false);
			or.setCode(SmsController.SMS_CODE_CHECK_ERR);
			return or;
		}
		
		if (!rsc.getCode().equals(code)) {
			logger.warn("[" + timeKey + "]验证码校验，验证码验证失败," + code + "," + rsc.getCode());
			or.setMessage("验证码验证失败");
			or.setStatus(false);
			or.setCode(SmsController.SMS_CODE_CHECK_ERR);
			return or;
		}
		rsc.setCheckTime(new Date());
		smsMapper.checkRegSmsCheck(rsc);
		try {
			or.setOther(IDEncryptor.getInstance().encrypt(rsc.getId()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return or;
	}
 
	public boolean addMobileAvailableCheck(MobileAvailable ma) {
		MobileAvailableMapper mobileAvailableMapper = writableSQLSession.getMapper(MobileAvailableMapper.class);
		try {
			mobileAvailableMapper.addMobileAvailable(ma);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean addMobileCheckToken(MobileCheckToken mct) {
		MobileCheckTokenMapper mobileCheckTokenMapper = writableSQLSession.getMapper(MobileCheckTokenMapper.class);
		try {
			mobileCheckTokenMapper.addMobileCheckToken(mct);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public MobileCheckToken getMobileCheckToken(String token) {
		MobileCheckTokenMapper mobileCheckTokenMapper = writableSQLSession.getMapper(MobileCheckTokenMapper.class);
		return mobileCheckTokenMapper.getMobileCheckTokenByToken(token);
	}
	
	/**
	 * 添加短信添加短信渠道
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean addSms(String mobile, String content, int smsType,String channel) {
		SmsMapper smsMapper = writableSQLSession.getMapper(SmsMapper.class);
		final SmsTrace st = new SmsTrace();
		st.setMobile(mobile);
		st.setContent(content);
		st.setSmsType(smsType);
		st.setChannel(channel);//添加短信渠道
		st.setCreateTime(new Date());
		
		try {
			smsMapper.addSmsTrace(st);
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		if (st.isSendQuickly()) {
			new Thread(new Runnable(){
				@Override
				public void run() {
					sendSmsService.sendSms(st);
				}
				
			}).start();
			
		}
		return true;
	}
	
	
	public SmsTrace getSmsTraceById(int id) {
		SmsMapper smsMapper = writableSQLSession.getMapper(SmsMapper.class);
		return smsMapper.getSmsTraceById(id);
	}

	@Override
	public void addAlarm(SmsContentType sct, Map params) {
		//报警短信一律使用通知通道
		
		String content = sct.genSms(params);
		for(String mobile : Config.SMS_ALARM_MOBILE) {
			addSms(mobile, content, SmsTrace.SMS_TYPE_WAIT, SmsChannel.clyzm.getChannel());
		}
	}

	public static void main(String[] args) {
		ISmsService smsService = (ISmsService)BeanFactoryUtil.getContext().getBean("smsService");
		Map m = new HashMap();
		m.put("id", 2);
		System.out.println("2");
	}

	@Override
	public void autoSendSms() {
		SmsMapper smsMapper = writableSQLSession.getMapper(SmsMapper.class);
		Date d = DateUtil.truncateTime(new Date());
		List<SmsTrace> smsList = smsMapper.getUnsendSms(d);
		if(smsList == null || smsList.size() < 1){
			logger.info("短信发送队列为空");
			return;
		}
		logger.info("本次队列发送短信数：" + smsList.size());
		for(int i= 0; i<smsList.size(); i++){
			sendSmsService.sendSms(smsList.get(i));
		}
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean applySms(ApplyBaseInfo abi, AuditType at, SysUser auditSysUser) {
		return false;
	}
}
