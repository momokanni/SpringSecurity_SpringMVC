package com.caishen91.jupiter.util;

import com.caishen91.jupiter.config.Config;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	
	public static final String USER_COOKIE_GLOBAL = "_g";
	public static final String BLOG_COOKIE_GLOBAL = "_bm";
	public static final String USER_COOKIE_EXTRACK = "_ex";
	
	public static final String BM_COOKIE_SYSUSER_ID = "_bmpid"; //sysUserId加密
	public static final String BM_COOKIE_LOGIN_TIME = "_bmptk"; //b端用户登录时间cookie,值为 当前时间和2015-01-01的时间差在加密
	public static final String BM_COOKIE_LOGIN_CHECK_KEY = "_bmpck"; //b端用户登录后产生的校验key
	public static final String BM_COOKIE_SYSUSER_ROLE_ID = "_bmprid"; //企业用户对应的小油菜用户角色ID
	
	
	public static final String USER_COOKIE_USER_ID = "_spid"; //userID加密 (原，为图片验证所加)
	public static final String USER_COOKIE_LOGIN_TIME = "_sptk"; //用户登录后时间cookie，值为 当前时间和2015-01-01的时间差在加密
	public static final String USER_COOKIE_LOGIN_CHECK_KEY = "_spck"; //用户登录后产生的校验key
	public static final String USER_COOKIE_LOGIN_NICKNAME = "_spnk"; //用户登录后的昵称,URLEncoder(utf8)replace
	
	public static final String BLOG_COOKIE_MANAGER_ID = "_blogmid"; // 公众号管理员ID(blogManagerId)加密
	public static final String BLOG_MANAGER_COOKIE_LOGIN_CHECK_KEY = "_blogpck"; //b端公众号管理员登录后产生的校验key
	public static final String BM_COOKIE_BLOG_ID = "_blogid"; // 公众号ID
	
	private static CookieUtil instance = new CookieUtil();
	private CookieUtil(){
		
	}
	
	public static CookieUtil getInstance(){
		return instance;
	}
	
	public void clearUserCookie(HttpServletRequest req, HttpServletResponse resp){
		clearCookie(req,resp,  USER_COOKIE_USER_ID);
	}
	
	public void clearLoginCkCookie(HttpServletRequest req, HttpServletResponse resp){
		clearCookie(req,resp,  USER_COOKIE_LOGIN_CHECK_KEY);
	}
	
	public Cookie produceCookie(HttpServletRequest req, HttpServletResponse resp, String name, String value, int expireTime, String domain){
		return produceCookie(req,resp,name,value,expireTime,domain,false);
	}
	
	public Cookie produceCookie(HttpServletRequest req, HttpServletResponse resp, String name, String value, int expireTime, String domain, boolean clear) {
		Cookie cookie = getCookie(req, name);
		if (cookie == null) {
			cookie = new Cookie(name, value);
			cookie.setMaxAge(expireTime);
			cookie.setPath("/");
			cookie.setDomain(domain);
			resp.addCookie(cookie);
		} else {
			if(clear){
				clearCookie(req,resp,name);
				cookie = new Cookie(name, value);
			}
			cookie.setValue(value);
			cookie.setMaxAge(expireTime);
			cookie.setPath("/");
			cookie.setDomain(domain);
			resp.addCookie(cookie);
		}
		return cookie;
	}
	
	private String getDomain(HttpServletRequest request){
		String host = request.getHeader("host");
		if(StringUtil.isEmpty(host))
			return null;
		return host.replaceAll(":.*?$","").toLowerCase();
	}
	
	/**
	 * 植入cookie
	 * @param req
	 * @param resp
	 */
	public Cookie genGlobal(HttpServletRequest req, HttpServletResponse resp){
		String domain = getDomain(req);
		String ip = IPUtil.getInstance().getRealIp(req);
		Cookie global = null;
		if (Config.DEBT_DOMAIN.equals(domain)) {//后台管理
			global = getCookie(req, USER_COOKIE_GLOBAL);
			if (global == null) {
				String globalId = genGlobal(ip);
				req.setAttribute("globalId", globalId);
				global = produceCookie(req, resp, USER_COOKIE_GLOBAL, globalId, 60 * 24 * 60 * 60 , Config.DOMAIN);
			}
		} else if (Config.BM_DOMAIN.equals(domain)) { // 商户端
			global = getCookie(req, BLOG_COOKIE_GLOBAL);
			if (global == null) {
				String globalId = genGlobal(ip);
				req.setAttribute("globalId", globalId);
				global = produceCookie(req, resp, BLOG_COOKIE_GLOBAL, globalId, 60 * 24 * 60 * 60 , Config.DOMAIN);
			}
		}
		
		
		return global;
	}
	
	public Cookie genBmSysUserIdCookie(HttpServletRequest req, HttpServletResponse resp, String value){
		Cookie pic= produceCookie(req, resp, BM_COOKIE_SYSUSER_ID, value, 6 * 60 * 60 , Config.DOMAIN,true);
		return pic;
	}
	
	public void clearSysUserIdCookie(HttpServletRequest req, HttpServletResponse resp){
		clearCookie(req,resp,  BM_COOKIE_SYSUSER_ID);
	}

	public void clearBlogCookie(HttpServletRequest req, HttpServletResponse resp){
		clearCookie(req,resp,  BLOG_COOKIE_MANAGER_ID);
	}
	
	public Cookie genBmLoginTimeCookie(HttpServletRequest req, HttpServletResponse resp, String value){
		Cookie pic= produceCookie(req, resp, BM_COOKIE_LOGIN_TIME, value, 6 * 60 * 60 , Config.DOMAIN,true);
		return pic;
	}
	
	public Cookie genBmLoginKeyCookie(HttpServletRequest req, HttpServletResponse resp, String value){
		Cookie pic= produceCookie(req, resp, BM_COOKIE_LOGIN_CHECK_KEY, value, 6 * 60 * 60 , Config.DOMAIN,true);
		return pic;
	}
	
	public Cookie genBmSysUserRoleIdCookie(HttpServletRequest req, HttpServletResponse resp, String value){
		Cookie pic= produceCookie(req, resp, BM_COOKIE_SYSUSER_ROLE_ID, value, 6 * 60 * 60 , Config.DOMAIN,true);
		return pic;
	}
	
	public Cookie genBlogManagerIdCookie(HttpServletRequest req, HttpServletResponse resp, String value){
		Cookie pic= produceCookie(req, resp, BLOG_COOKIE_MANAGER_ID, value, 6 * 60 * 60 , Config.DOMAIN,true);
		return pic;
	}
	
	public Cookie genBlogManagerLoginTimeCookie(HttpServletRequest req, HttpServletResponse resp, String value){
		Cookie pic= produceCookie(req, resp, BM_COOKIE_LOGIN_TIME, value, 6 * 60 * 60 , Config.DOMAIN,true);
		return pic;
	}
	
	public Cookie genBlogManagerLoginKeyCookie(HttpServletRequest req, HttpServletResponse resp, String value){
		Cookie pic= produceCookie(req, resp, BLOG_MANAGER_COOKIE_LOGIN_CHECK_KEY, value, 6 * 60 * 60 , Config.DOMAIN,true);
		return pic;
	}
	
	public Cookie genBlogIDCookie(HttpServletRequest req, HttpServletResponse resp, String value){
		Cookie pic= produceCookie(req, resp, BM_COOKIE_BLOG_ID, value, 6 * 60 * 60 , Config.DOMAIN,true);
		return pic;
	}
	
	public String getGlobal(HttpServletRequest req){
		String domain = getDomain(req);
		Cookie global = null;
		if (Config.DEBT_DOMAIN.equals(domain)) {//后台管理
			global = getCookie(req,USER_COOKIE_GLOBAL);
		} else if (Config.BM_DOMAIN.equals(domain)) { // 商户端
			global = getCookie(req,BLOG_COOKIE_GLOBAL);
		}
		return global == null ? "" : global.getValue();
	}
	
	public String genGlobal(String ip) {
		return ip + "-" + System.currentTimeMillis();
	}
	public boolean clearCookie(HttpServletRequest req, HttpServletResponse resp, String key) {
		
		Cookie cookie = new Cookie(key, null);
		cookie.setDomain(Config.DOMAIN);
		cookie.setPath("/");
		cookie.setMaxAge(0);
		resp.addCookie(cookie);
		return true;
	}
	/**
	 * 获取cookie
	 * @param req
	 * @param cookieName
	 * @return
	 */
	public Cookie getCookie(HttpServletRequest req, String cookieName){
		Cookie[] cookies = req.getCookies();
		if(cookies == null)
			return null;
		Cookie tcookie = null;
		for(Cookie ck : cookies){
			String ckName = ck.getName();
			if(cookieName.equals(ckName)){
				tcookie = ck;
				break;
			}
		}
		return tcookie;
	}
	
	
	/**
	 * 获取global
	 * @param req
	 * @return
	 */
	public String getGlobalNew(HttpServletRequest req){
		String domain = getDomain(req);
		Cookie global = null;
		if (Config.DEBT_DOMAIN.equals(domain)) {//后台管理
			global = getCookie(req,USER_COOKIE_GLOBAL);
		} else if (Config.BM_DOMAIN.equals(domain)) { // 商户端
			global = getCookie(req,BLOG_COOKIE_GLOBAL);
		}
		String cookieValue = "";
		if(global == null){
			cookieValue = (String)req.getAttribute("globalId");
		}else{
			cookieValue = global.getValue();
		}
		return cookieValue == null ? "" : cookieValue;
	}
	
	public Cookie genUserIdCookie(HttpServletRequest req, HttpServletResponse resp, String value){
		Cookie pic= produceCookie(req, resp, USER_COOKIE_USER_ID, value, 6 * 60 * 60 , Config.DOMAIN,true);
		return pic;
	}
	
	public Cookie genNickNameCookie(HttpServletRequest req, HttpServletResponse resp, String value){
		Cookie pic= produceCookie(req, resp, USER_COOKIE_LOGIN_NICKNAME, value, 6 * 60 * 60 , Config.DOMAIN,true);
		return pic;
	}
	
	public Cookie genLoginTimeCookie(HttpServletRequest req, HttpServletResponse resp, String value){
		Cookie pic= produceCookie(req, resp, USER_COOKIE_LOGIN_TIME, value, 6 * 60 * 60 , Config.DOMAIN,true);
		return pic;
	}
	
	public Cookie genLoginKeyCookie(HttpServletRequest req, HttpServletResponse resp, String value){
		Cookie pic= produceCookie(req, resp, USER_COOKIE_LOGIN_CHECK_KEY, value, 6 * 60 * 60 , Config.DOMAIN,true);
		return pic;
	}
}
