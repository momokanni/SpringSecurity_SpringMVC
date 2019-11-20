package com.caishen91.jupiter.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.model.BlogManager;
import com.caishen91.jupiter.service.IBlogManagerService;

public class BMLoginUtil {

	private static final String BM_COOKIE_SALT = Config.FRONT_PREFIX;
	
	private static final long LOGIN_TIME_REF = 1420041600000L;//2015-01-01 的时间戳
	/**
	 * 	从cookie中获取已登录的用户信息
	 * @param req
	 * @param resp
	 * @return
	 */
	public static BlogManager getLoginBlogManager(HttpServletRequest req, HttpServletResponse resp) {
		BlogManager bm = getLoginBMSimple(req, resp);
		if (bm == null) {
			return null;
		}
        IBlogManagerService bmService = (IBlogManagerService)BeanFactoryUtil.getBean(IBlogManagerService.class);
        BlogManager blogManager = bmService.getUserById(bm.getId(),bm.getBlogId());
		return blogManager;
	}
	
	/**
	 * 	将登录信息写入cookie
	 * @param request
	 * @param response
	 * @param su
	 */
	public static void handleSysLogin(HttpServletRequest request, HttpServletResponse response, BlogManager bm) {
		String global = CookieUtil.getInstance().getGlobal(request);
		int timeDiff = (int)((System.currentTimeMillis() - LOGIN_TIME_REF) / 1000);
		String timeDiffStr = IDEncryptor.getInstance().encryptWithoutException(timeDiff);
		String bmIdStr = IDEncryptor.getInstance().encryptWithoutException(bm.getId());
		String blogIdStr = IDEncryptor.getInstance().encryptWithoutException(bm.getBlogId());
		
		String sysLoginKey = genBMLoginKey(global, timeDiff, bm.getId(), bm.getBlogId());
		// 公众号管理员ID
		CookieUtil.getInstance().genBlogManagerIdCookie(request, response,bmIdStr);
		// 时间戳
		CookieUtil.getInstance().genBlogManagerLoginTimeCookie(request, response,timeDiffStr);
		// 登录成功后生成的key存入cookie
		CookieUtil.getInstance().genBlogManagerLoginKeyCookie(request, response,sysLoginKey);
		// 公众号ID存入cookie
		CookieUtil.getInstance().genBlogIDCookie(request, response, blogIdStr);
	}

	/**
	 * 	从cookie获取已登录值
	 * @param request
	 * @param resp
	 * @return
	 */
	private static BlogManager getLoginBMSimple(HttpServletRequest request, HttpServletResponse resp) {

		Cookie globalCookie = CookieUtil.getInstance().getCookie(request, CookieUtil.BLOG_COOKIE_GLOBAL);
		if (globalCookie == null) {
			return null;
		}
		// 管理员ID
		Cookie bmIdIdCookie = CookieUtil.getInstance().getCookie(request, CookieUtil.BLOG_COOKIE_MANAGER_ID);
		if (bmIdIdCookie == null) {
			return null;
		}
		// 公众号ID
		Cookie blogIdCookie = CookieUtil.getInstance().getCookie(request, CookieUtil.BM_COOKIE_BLOG_ID);
		if (blogIdCookie == null) {
			return null;
		}
		
		// 超时cookie
		Cookie timeCookie = CookieUtil.getInstance().getCookie(request, CookieUtil.BM_COOKIE_LOGIN_TIME);
		if (timeCookie == null) {
			return null;
		}
		
		// 类sign or token
		Cookie keyCookie = CookieUtil.getInstance().getCookie(request, CookieUtil.BLOG_MANAGER_COOKIE_LOGIN_CHECK_KEY);
		if (keyCookie == null) {
			return null;
		}
		String global = globalCookie.getValue();
		String bmIdStr = bmIdIdCookie.getValue();
		String blogIdStr = blogIdCookie.getValue();
		
		int bmId = 0;
		int blogId = 0;
		try {
			bmId = IDEncryptor.getInstance().decryptWithoutException(bmIdStr);
			blogId = IDEncryptor.getInstance().decryptWithoutException(blogIdStr);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if (bmId == 0 || blogId == 0) {
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
		
		String cKey = genBMLoginKey(global, timeDiff, bmId,blogId);
		if (!cKey.equals(keyCookie.getValue())) {
			return null;
		}
		
		BlogManager bm = new BlogManager();
		bm.setId(bmId);
		bm.setBlogId(blogId);
		return bm;
	}
	
	/**
	 * 	拼装Key
	 * @param global
	 * @param timeDiff
	 * @param sysUserId
	 * @param roleId
	 * @return
	 */
	private static String genBMLoginKey(String global, long timeDiff, int sysUserId, int blogId) {
		String toEnc = global + "," + timeDiff + "," + sysUserId  + "," + blogId + "," + BM_COOKIE_SALT;
		return StringUtil.MD5Encode(toEnc);
	}
	
}
