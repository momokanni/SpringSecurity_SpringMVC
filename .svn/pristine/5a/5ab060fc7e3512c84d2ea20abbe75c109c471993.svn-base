package com.caishen91.jupiter.interceptor;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.controller.core.SmsController;
import com.caishen91.jupiter.service.ISmsService;
import com.caishen91.jupiter.util.CookieUtil;
import com.caishen91.jupiter.util.IPUtil;
import com.caishen91.jupiter.util.OperationResult;
import com.caishen91.jupiter.util.StringUtil;
import com.caishen91.jupiter.util.ValidateUtil;

/**
 * 登录的拦截器
 * @author lenovo
 *
 */
public class SmsCheckInterceptor implements HandlerInterceptor {
	private static final long serialVersionUID = -217752065327400122L;

	
	
	@Autowired
	private ISmsService smsService;
	
	private static Logger logger = LoggerFactory.getLogger(SmsCheckInterceptor.class);


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String ip = IPUtil.getInstance().getRealIp(request);
		Cookie global = CookieUtil.getInstance().getCookie(request, CookieUtil.USER_COOKIE_GLOBAL);
		String mobileName = request.getParameter("yzmMobile");
		if (StringUtil.isEmpty(mobileName)) {
			mobileName = "mobile";
		}
		String mobile = request.getParameter(mobileName);
		String scode = request.getParameter("scode");
		mobile = mobile.trim();
		Map retMap = new HashMap();
		retMap.put(Config.RET, Config.RET_OK);

		boolean b = true;

		//新网注册 pc端需要拿到登录用户自己的手机号
		

		if (!ValidateUtil.isMobileNo(mobile)) {
			logger.warn("校验手机验证码，手机号码格式错误：" + mobile);
			retMap.put(Config.RET, Config.RET_ERROR);
			retMap.put(Config.ERR_MSG, "手机号码格式错误");
			retMap.put(Config.ERR_CODE, SmsController.SMS_CODE_ERR_MOBILE);
			b = false;
		}
		if (!b) {
			sendJsonMessage(response,retMap);
			return false;
		}
		if (global == null) {
			logger.warn("校验手机验证码，没有找到全局cookie");
			retMap.put(Config.RET, Config.RET_ERROR);
			retMap.put(Config.ERR_MSG, "验证码校验失败");
			retMap.put(Config.ERR_CODE, SmsController.SMS_CODE_CHECK_ERR);
			b = false;
		}
		if (!b) {
			sendJsonMessage(response,retMap);
			return false;
		}

		if (StringUtil.isEmpty(scode)) {
			logger.warn("校验手机验证码，验证码为空");
			retMap.put(Config.RET, Config.RET_ERROR);
			retMap.put(Config.ERR_MSG, "验证码不能为空");
			retMap.put(Config.ERR_CODE, SmsController.SMS_CODE_CHECK_ERR);
			b = false;
		}
		if (!b) {
			sendJsonMessage(response,retMap);
			return false;
		}

		OperationResult or = smsService.smsCodeCheck(ip, global.getValue(), mobile, scode, 0);
		if (or.isSuccess()) {
			return true;
		} else{
			logger.warn("校验手机验证码，验证码校验失败");
			retMap.put(Config.RET, Config.RET_ERROR);
			retMap.put(Config.ERR_MSG, "验证码校验失败");
			retMap.put(Config.ERR_CODE, SmsController.SMS_CODE_CHECK_ERR);
			sendJsonMessage(response,retMap);
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}

	/**
	 * 将某个对象转换成json格式并发送到客户端
	 * @param response
	 * @param obj
	 * @throws Exception
	 */
	public static void sendJsonMessage(HttpServletResponse response, Object obj) throws Exception {
		response.setContentType("application/json; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print(JSONObject.toJSONString(obj, SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteDateUseDateFormat));
		writer.close();
		response.flushBuffer();
	}
}
