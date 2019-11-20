package com.caishen91.jupiter.controller.core;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.enums.SmsChannel;
import com.caishen91.jupiter.enums.SmsContentType;
import com.caishen91.jupiter.enums.SmsRequestType;
import com.caishen91.jupiter.model.MobileAvailable;
import com.caishen91.jupiter.model.RegSmsCheck;
import com.caishen91.jupiter.model.SmsTrace;
import com.caishen91.jupiter.model.User;
import com.caishen91.jupiter.service.ISmsService;
import com.caishen91.jupiter.service.ISysUserService;
import com.caishen91.jupiter.service.IUserService;
import com.caishen91.jupiter.util.CookieUtil;
import com.caishen91.jupiter.util.IDEncryptor;
import com.caishen91.jupiter.util.IPUtil;
import com.caishen91.jupiter.util.LoginUtil;
import com.caishen91.jupiter.util.OperationResult;
import com.caishen91.jupiter.util.SmsUtil;
import com.caishen91.jupiter.util.StringUtil;
import com.caishen91.jupiter.util.ValidateUtil;

@Controller
@RequestMapping("/sms")
public class SmsController {
	private static final long serialVersionUID = -8665514731237884172L;
	
	protected final Logger logger = Logger.getLogger("smscode");

	@Autowired
	private ISmsService smsService;

	@Autowired
	private ISysUserService sysUserService;
	
	@Autowired
	private IUserService userService;

	public static final int SMS_CODE_ERR_MOBILE = 0; //手机号码格式错误
	public static final int SMS_CODE_TO_MANY_TIMES = 1; //请求过于平凡
	public static final int SMS_CODE_GEN_ERR = 2; //验证码生成失败
	public static final int SMS_CODE_EXPIRED = 3; //验证码过期
	public static final int SMS_CODE_CHECK_ERR = 4; //验证码校验失败
	public static final int SMS_CODE_UNAVAILABLE_MOBILE = 5; //手机号不存在
	public static final int SMS_CODE_AVAILABLE_MOBILE = 6; //手机号已被注册
	public static final int SMS_CODE_EMPTY_IMGCODE = 7; //图形验证码为空
	public static final int SMS_CODE_ERR_IMGCODE = 8; //图形验证码不正确
	public static final int SMS_CODE_EXCEPTION = 9; //图形验证码异常
	public static final int SMS_CODE_UnMatch_User_MOBILE = 10; //输入手机号与当前用户不匹配
	public static final int SMS_CODE_SAME_User_MOBILE = 11; //更换手机号时,新旧手机号相同
	
	
	// public String smsVerfyCode() {
	// 	return SUCCESS;
	// }
	
	// public String changePwdVerfyCode(){
	// 	return SUCCESS;
	// }


	@ResponseBody
	@RequestMapping("/smsCheckFailure")
	public Map<String,Object> smsCheckFailure(HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> retMap = new HashMap<String,Object>(); {
			retMap.put(Config.RET, Config.RET_OK);
		}
		Map smsResult = (Map)request.getAttribute("smsResult");
		retMap = smsResult;
		return  retMap;
	}
	@ResponseBody
	@RequestMapping("/getSmsCode")
	public Map<String,Object> getSmsCode(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Map<String,Object> retMap = new HashMap<String,Object>(); {
			retMap.put(Config.RET, Config.RET_OK);
		}
		String ip = IPUtil.getInstance().getRealIp(request);
		String mobile = request.getParameter("mobile");
		String ct = request.getParameter("ct");
		String fft = request.getParameter("fft");//是否展示密保
		String entt = request.getParameter("entt");//企业用户注册标示
		
		String referer = request.getHeader("Referer");
		if (referer == null) {
			referer = "";
		}
		
		Cookie global = CookieUtil.getInstance().getCookie(request, CookieUtil.USER_COOKIE_GLOBAL);
		if (global == null) {
			global = CookieUtil.getInstance().genGlobal(request, response);
		}
		
		String ref = request.getParameter("c"); //引用的校验步骤，例如，先校验原手机，后校验新手机
		if (ref == null) {
			ref = "";
		}
		if (!ref.matches("^\\d+$")) {
			ref = "0";
		} else {
			try {
				int r = IDEncryptor.getInstance().decrypt(ref);
				ref = r + "";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String rt = request.getParameter("rt");
		
		String tu = request.getParameter("tu");
		
		String st = request.getParameter("st");//语音播报
		
		boolean isVo = "vo".equals(st);
		
		String timeKey = StringUtil.getTimeKey();
		
		logger.info("短信校验码发送接口调用[" + timeKey + "]手机号码:" +  mobile + ",ip:" + ip + ",cookie:" + global.getValue() + ",rt:" + rt + ",ct:" + ct + ",tu:" + tu);
		
		if (!ValidateUtil.isMobileNo(mobile)) {
			logger.warn("[" + timeKey + "]手机号码格式错误：" + mobile);
			retMap.put(Config.RET, 0);
			retMap.put(Config.ERR_CODE, SMS_CODE_ERR_MOBILE);
			retMap.put(Config.ERR_MSG, "手机号码格式错误");
			return retMap;
		}
		
		String rand = (String) request.getSession().getAttribute("smsRand");
		if (rand == null) {
			rand = "";
		}
		rand = rand.toLowerCase();
		
		if ("1".equals(tu)) {//需要图形验证码教养
			String smsvf = request.getParameter("smsvf");
			if (StringUtil.isEmpty(smsvf)) {
				logger.warn("[" + timeKey + "]校验手机验证码，图形验证码为空:" + mobile + "," + rand + "," + smsvf);
				retMap.put(Config.RET, Config.RET_ERROR);
				retMap.put(Config.ERR_MSG, "图形验证码为空");
				retMap.put(Config.ERR_CODE, SmsController.SMS_CODE_EMPTY_IMGCODE);
				return retMap;
			}
			
			
			if (StringUtil.isEmpty(rand)) {
				logger.warn("[" + timeKey + "]校验手机验证码，没有找到对应的图形验证码:" + mobile + "," + rand + "," + smsvf);
				retMap.put(Config.RET, Config.RET_ERROR);
				retMap.put(Config.ERR_MSG, "图形验证码错误");
				retMap.put(Config.ERR_CODE, SmsController.SMS_CODE_ERR_IMGCODE);
				return retMap;
			}
			
			
			if (!rand.equalsIgnoreCase(smsvf.toLowerCase())) { 
				logger.warn("[" + timeKey + "]校验手机验证码，图形验证码错误:" + mobile + "," + rand + "," + smsvf);
				retMap.put(Config.RET, Config.RET_ERROR);
				retMap.put(Config.ERR_MSG, "图形验证码错误");
				retMap.put(Config.ERR_CODE, SmsController.SMS_CODE_ERR_IMGCODE);
				return retMap;
			}
			Date smsRandPutTime = (Date)request.getSession().getAttribute("smsRandPutTime");
//			System.out.println(smsRandPutTime.getTime() + 10 * 1000L);
//			System.out.println(System.currentTimeMillis());
			long l = System.currentTimeMillis();
			if (smsRandPutTime != null) {
				if (l > smsRandPutTime.getTime() + 2* 60 * 1000L) {
					logger.warn("[" + timeKey + "]校验手机验证码，图形验证码超时:" + mobile + "," + rand + "," + smsvf + "," + l + "," + smsRandPutTime.getTime());
					retMap.put(Config.RET, Config.RET_ERROR);
					retMap.put(Config.ERR_MSG, "图形验证码错误");
					retMap.put(Config.ERR_CODE, SmsController.SMS_CODE_ERR_IMGCODE);
					return retMap;
				}
			}
		}
		
		
		if (!ValidateUtil.isNumber(ct)) {
			ct = "0";
		}
		
		if (!ValidateUtil.isNumber(rt)) {
			rt = "0";
		}
		int irt = Integer.valueOf(request.getParameter("rt"));
		int ict = Integer.valueOf(ct);
		
		try{
			OperationResult or = smsService.smsCodeChecker(ip, global.getValue(), irt);
			if (!or.isSuccess()) {
				logger.warn("[短信请求频繁" + timeKey + "]" + or.getMessage() + "," + ip + "," + global.getValue());
				retMap.put(Config.RET, 0);
				retMap.put(Config.ERR_CODE, SMS_CODE_TO_MANY_TIMES);
				retMap.put(Config.ERR_MSG, "发送失败，您的请求过于频繁");
				return retMap;
			}
			MobileAvailable ma = new MobileAvailable();
			ma.setCheckTime(new Date());
			ma.setIp(ip);
			ma.setCookie(global.getValue());
			ma.setMobile(mobile);
			smsService.addMobileAvailableCheck(ma);
			if (irt == SmsRequestType.available.getId()) {
				User user = userService.getUserByMobile(mobile);
				if ( user == null ) {
					logger.warn("[" + timeKey + "]" + or.getMessage() + "," + ip + "," + global.getValue());
					retMap.put(Config.RET, 0);
					retMap.put(Config.ERR_CODE, SMS_CODE_UNAVAILABLE_MOBILE);
					retMap.put(Config.ERR_MSG, "发送失败，手机号码未注册");
					return retMap;
				}
				
			} else if (irt == SmsRequestType.unavailable.getId()) {
				User user = userService.getUserByMobile(mobile);
				if ( user != null) {
					logger.warn("[" + timeKey + "]" + or.getMessage() + "," + ip + "," + global.getValue());
					retMap.put(Config.RET, 0);
					retMap.put(Config.ERR_CODE, SMS_CODE_AVAILABLE_MOBILE);
					retMap.put(Config.ERR_MSG, "发送失败，手机号码已注册");
					return retMap;
				}
			}else if (irt == SmsRequestType.userMobileUnMatch.getId()) {
				User user = LoginUtil.getLoginUser(request, response);
				if (user == null) {
					logger.warn("[" + timeKey + "]" + or.getMessage() + "," + ip + "," + global.getValue());
					retMap.put(Config.RET, 0);
					retMap.put(Config.ERR_CODE,SMS_CODE_UnMatch_User_MOBILE );
					retMap.put(Config.ERR_MSG, "发送失败，当前用户未登录");
					return retMap;
				}
				if (!mobile.trim().equals(user.getMobile())) {
					logger.warn("[" + timeKey + "]" + or.getMessage() + "," + ip + "," + global.getValue());
					retMap.put(Config.RET, 0);
					retMap.put(Config.ERR_CODE,SMS_CODE_UnMatch_User_MOBILE );
					retMap.put(Config.ERR_MSG, "发送失败，手机号码与当前用户不匹配");
					return retMap;
				}
			}else if (irt == SmsRequestType.changeMobileSame.getId()) {
				User user = LoginUtil.getLoginUser(request, response);
				if (user == null) {
					logger.warn("[" + timeKey + "]" + or.getMessage() + "," + ip + "," + global.getValue());
					retMap.put(Config.RET, 0);
					retMap.put(Config.ERR_CODE,SMS_CODE_UnMatch_User_MOBILE );
					retMap.put(Config.ERR_MSG, "发送失败，当前用户未登录");
					return retMap;
				}
				if (mobile.trim().equals(user.getMobile())) {
					logger.warn("[" + timeKey + "]" + or.getMessage() + "," + ip + "," + global.getValue());
					retMap.put(Config.RET, 0);
					retMap.put(Config.ERR_CODE,SMS_CODE_SAME_User_MOBILE );
					retMap.put(Config.ERR_MSG, "发送失败，新手机号不能与旧手机号相同");
					return retMap;
				}
			}
			String channel = null;
			
			RegSmsCheck rsc = smsService.getLastSmsCheckCode(ip, global.getValue(), mobile, Integer.valueOf(ref));
			String code = null;
			if (rsc == null || rsc.isExpire()) {
				channel = SmsChannel.clyzm.getChannel();
				code = SmsUtil.genCode();
				rsc = new RegSmsCheck();
				rsc.setIp(ip);
				rsc.setChannel(channel);//修改校验短信渠道
				rsc.setCode(code);
				rsc.setMobile(mobile);
				rsc.setLastSendTime(new Date());
				rsc.setSendTime(new Date());
				rsc.setCookie(global.getValue());
				rsc.setRef(Integer.valueOf(ref));
				boolean b = smsService.addRegSmsCheck(rsc);
				if (!b) {
					logger.warn("[" + timeKey + "]" + or.getMessage() + "," + ip + "," + global.getValue());
					retMap.put(Config.RET, 0);
					retMap.put(Config.ERR_CODE, SMS_CODE_GEN_ERR);
					retMap.put(Config.ERR_MSG, "验证码生成失败");
					return retMap;
				}
			} else {
				channel = SmsChannel.clyzm.getChannel();
				
				rsc.setLastSendTime(new Date());
				rsc.setChannel(channel);//修改校验短信渠道
				smsService.resendRegSmsCheck(rsc);
				code = rsc.getCode();
			}
			Map m = new HashMap();
			m.put("code", code);
			
			m.put("channel", channel);
			String content = SmsContentType.getContentByType(ict).genSms(m);//短信内容
			if (isVo) {
				content = code;
			}
			smsService.addSms(mobile, content, SmsTrace.SMS_TYPE_QUICK,channel);
			
			
			
			
		}catch(Exception e){
			e.printStackTrace();
			logger.warn("[" + timeKey + "]" + ip + "," + global.getValue() + "：" + e.getMessage());
			retMap.put(Config.RET, 0);
			retMap.put(Config.ERR_CODE, SMS_CODE_EXCEPTION);
			retMap.put(Config.ERR_MSG, "验证码发送失败");
		}
		retMap.put("vo", isVo);
		//******清掉验证码session
		request.getSession().setAttribute("smsRand",null);
		return retMap;
	}


}
