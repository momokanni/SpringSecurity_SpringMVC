package com.caishen91.jupiter.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.model.SysUser;
import com.caishen91.jupiter.model.User;
import com.caishen91.jupiter.service.ISysUserService;

/**
 * 标相关的工具类
 * 
 * @since v1.0
 * @history
 * @see
 */
public class LoginUtil {
	private static Logger logger = LoggerFactory.getLogger(LoginUtil.class);
	private static final int COOKIEAGE = 60 * 60 * 24 * 7;
	
	private static final String USR_COOKIE_SALT = Config.FRONT_PREFIX;
	
	private static final long LOGIN_TIME_REF = 1420041600000L;//2015-01-01 的时间戳

	public static void handleLogout(HttpServletRequest request, HttpServletResponse response){
		CookieUtil.getInstance().clearUserCookie(request,response);
		CookieUtil.getInstance().clearLoginCkCookie(request, response);
		logger.info("用户退出,清除session 和cookie");
	}
	
	public static SysUser getSysLoginUserSimple(HttpServletRequest request, HttpServletResponse response) {
		Cookie globalCookie = CookieUtil.getInstance().getCookie(request, CookieUtil.USER_COOKIE_GLOBAL);
		if (globalCookie == null) {
			return null;
		}
		
		Cookie sysUserIdCookie = CookieUtil.getInstance().getCookie(request, CookieUtil.BM_COOKIE_SYSUSER_ID);
		if (sysUserIdCookie == null) {
			return null;
		}
		
		Cookie timeCookie = CookieUtil.getInstance().getCookie(request, CookieUtil.BM_COOKIE_LOGIN_TIME);
		if (timeCookie == null) {
			return null;
		}
		
		Cookie keyCookie = CookieUtil.getInstance().getCookie(request, CookieUtil.BM_COOKIE_LOGIN_CHECK_KEY);
		if (keyCookie == null) {
			return null;
		}
		String global = globalCookie.getValue();
		String sysUserIdStr = sysUserIdCookie.getValue();
		int sysUserId = 0;
		try {
			sysUserId = IDEncryptor.getInstance().decrypt(sysUserIdStr);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if (sysUserId == 0) {
			return null;
		}
		String timeStr = timeCookie.getValue();
		int timeDiff = 0;
		try {
			timeDiff = IDEncryptor.getInstance().decrypt(timeStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (timeDiff == 0) {
			return null;
		}
		
		Cookie sysRoleIdCookie = CookieUtil.getInstance().getCookie(request, CookieUtil.BM_COOKIE_SYSUSER_ROLE_ID);
		if (sysRoleIdCookie == null) {
			return null;
		}
		int sysUserRoleId = IDEncryptor.getInstance().decryptWithoutException(sysRoleIdCookie.getValue());
		
		String cKey = genSysLoginKey(global, timeDiff, sysUserId,sysUserRoleId);
		if (!cKey.equals(keyCookie.getValue())) {
			return null;
		}
		
		SysUser su = new SysUser();
		su.setId(sysUserId);
		su.setRoleId(sysUserRoleId);
		return su;
	}
	public static SysUser getSysLoginUser(HttpServletRequest request, HttpServletResponse response) {
		SysUser su = getSysLoginUserSimple(request, response);
		if (su == null) {
			return null;
		}
        ISysUserService sysUserService = (ISysUserService)BeanFactoryUtil.getBean(ISysUserService.class);
		SysUser nsu = sysUserService.getUserById(su.getId());
		return nsu;
	}
	
	public static void handleSysLogin(HttpServletRequest request, HttpServletResponse response, SysUser su) {
		String global = CookieUtil.getInstance().getGlobal(request);
		int timeDiff = (int)((System.currentTimeMillis() - LOGIN_TIME_REF) / 1000);
		String timeDiffStr = IDEncryptor.getInstance().encryptWithoutException(timeDiff);
		String sysUidStr = IDEncryptor.getInstance().encryptWithoutException(su.getId());
		
		String sysLoginKey = genSysLoginKey(global, timeDiff, su.getId(), su.getRoleId());
		
		CookieUtil.getInstance().genBmSysUserIdCookie(request, response,sysUidStr);
		CookieUtil.getInstance().genBmLoginTimeCookie(request, response,timeDiffStr);
		CookieUtil.getInstance().genBmLoginKeyCookie(request, response,sysLoginKey);
		String sysMainRoleStr = IDEncryptor.getInstance().encryptWithoutException(su.getRoleId());
		CookieUtil.getInstance().genBmSysUserRoleIdCookie(request, response, sysMainRoleStr);
	}
	
	public static void handleSysLogout(HttpServletRequest request, HttpServletResponse response) {
		CookieUtil.getInstance().clearSysUserIdCookie(request,response);
	}

	public static void handleBlogLogout(HttpServletRequest request, HttpServletResponse response) {
		CookieUtil.getInstance().clearBlogCookie(request,response);
	}
	
	private static String genLoginKey(String global, long timeDiff, int userId) {
		String toEnc = global + "," + timeDiff + "," + userId  + "," + USR_COOKIE_SALT;
		return StringUtil.MD5Encode(toEnc);
	}
	
	/**
	 * 这个方法里面的User只有userId和nickName字段有值
	 * @param request
	 * @param response
	 * @return
	 */
	public static User getLoginUser(HttpServletRequest request, HttpServletResponse response) {
		Cookie globalCookie = CookieUtil.getInstance().getCookie(request, CookieUtil.USER_COOKIE_GLOBAL);
		if (globalCookie == null) {
			return null;
		}
		
		Cookie userIdCookie = CookieUtil.getInstance().getCookie(request, CookieUtil.USER_COOKIE_USER_ID);
		if (userIdCookie == null) {
			return null;
		}
		
		Cookie timeCookie = CookieUtil.getInstance().getCookie(request, CookieUtil.USER_COOKIE_LOGIN_TIME);
		if (timeCookie == null) {
			return null;
		}
		
//		Cookie nickNameCookie = CookieUtil.getInstance().getCookie(request, CookieUtil.USER_COOKIE_LOGIN_NICKNAME);
//		if (nickNameCookie == null) {
//			return null;
//		}
		
		Cookie keyCookie = CookieUtil.getInstance().getCookie(request, CookieUtil.USER_COOKIE_LOGIN_CHECK_KEY);
		if (keyCookie == null) {
			return null;
		}
		String global = globalCookie.getValue();
		String userIdStr = userIdCookie.getValue();
		int userId = 0;
		try {
			userId = IDEncryptor.getInstance().decrypt(userIdStr);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if (userId == 0) {
			return null;
		}
		String timeStr = timeCookie.getValue();
		int timeDiff = 0;
		try {
			timeDiff = IDEncryptor.getInstance().decrypt(timeStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (timeDiff == 0) {
			return null;
		}
		
		String cKey = genLoginKey(global, timeDiff, userId);
		if (!cKey.equals(keyCookie.getValue())) {
			return null;
		}
		
		User user = new User();
		user.setId(userId);
		
		
		return user;
	}
	
	public static void handleLogin(HttpServletRequest request, HttpServletResponse response, User user) {
		String global = CookieUtil.getInstance().getGlobal(request);
		//对于app特殊处理
		if(StringUtil.isEmpty(global)){
			global = (String)request.getAttribute("globalId");
		}
		
		int timeDiff = (int)((System.currentTimeMillis() - LOGIN_TIME_REF) / 1000);
		String timeDiffStr = IDEncryptor.getInstance().encryptWithoutException(timeDiff);
		
		String uidStr = IDEncryptor.getInstance().encryptWithoutException(user.getId());
		
		String key = genLoginKey(global, timeDiff, user.getId());
		CookieUtil.getInstance().genUserIdCookie(request, response,uidStr);
		CookieUtil.getInstance().genLoginTimeCookie(request, response, timeDiffStr);
		CookieUtil.getInstance().genLoginKeyCookie(request, response, key);
	}
	
	private static String genSysLoginKey(String global, long timeDiff, int sysUserId, int roleId) {
		String toEnc = global + "," + timeDiff + "," + sysUserId  + "," + USR_COOKIE_SALT;
		return StringUtil.MD5Encode(toEnc);
	}
	
	public static String getDomain(HttpServletRequest request){
		String host = request.getHeader("host");
		if(StringUtil.isEmpty(host))
			return null;
		return host.replaceAll(":.*?$","").toLowerCase();
	}


}
