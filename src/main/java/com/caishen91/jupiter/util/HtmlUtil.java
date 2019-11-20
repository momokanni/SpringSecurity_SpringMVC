package com.caishen91.jupiter.util;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import com.caishen91.jupiter.config.Config;

public class HtmlUtil {

	private static Set<String> newLineTag = new HashSet<String> ();
	private static Set<String> unVisibleTag = new HashSet<String> ();
	private static Set<String> htmlLineTag = new HashSet<String>();
	static {
		newLineTag.add("TR");
		newLineTag.add("P");
		newLineTag.add("DIV");
		newLineTag.add("BR");
		
		htmlLineTag.addAll(newLineTag);
		htmlLineTag.add("LI");
		
		unVisibleTag.add("STYLE");
	}
	
	public static boolean isNewLineTag(String tagName) {
		return newLineTag.contains(tagName);
	}
	
	public static boolean isHtmlLineTag(String tagName){
		return htmlLineTag.contains(tagName);
	}
	
	/**
	 * 	获取域名
	 * @param request
	 * @return
	 */
	public static String getDomain(HttpServletRequest request){
		String host = request.getHeader("host");
		if(StringUtil.isEmpty(host))
			return null;
		return host.replaceAll(":.*?$","").toLowerCase();
	}
	
	/**
	 * 	判断请求是否为ajax
	 * @param request
	 * @return
	 */
	public static boolean isAjaxRequest(HttpServletRequest request) {
        String ajaxFlag = request.getHeader("X-Requested-With");
        return ajaxFlag != null && "XMLHttpRequest".equals(ajaxFlag);
    }
	
	/**
	 * 	获取请求参数
	 * @param request
	 * @return
	 */
	public static String getRequestParam(HttpServletRequest request) {
		StringBuilder sb = new StringBuilder();
		Enumeration<String> enus = request.getParameterNames();
		while (enus.hasMoreElements()) {
			String key = enus.nextElement();
			String value = request.getParameter(key);
			sb.append(key).append("->").append(value).append(",");
		}
		return sb.toString();
	}
	
	/**
	 * 	根据request获取登录路径
	 * @param domain
	 * @return
	 */
	public static String getLoginPath(String domain) {
		if(Config.BM_DOMAIN.equals(domain)) {
			return Config.BM_DOMAIN_LOGIN;
		} else if(Config.DEBT_DOMAIN.equals(domain)) {
			return Config.DEBT_DOMAIN_LOGIN;
		}
		return null;
	}
	
	/**
     * 	得到网页中图片的地址
     * @param sets html字符串
     */
    public static Set<String> getImgStr(String htmlStr) {
        Set<String> pics = new HashSet<String>();
        String img = "";
        Pattern p_image;
        Matcher m_image;
        String regEx_img = "<img.*src\\s*=\\s*(.*?)[^>]*?>";
        p_image = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);
        m_image = p_image.matcher(htmlStr);
        while (m_image.find()) {
            // 得到<img />数据
            img = m_image.group();
            // 匹配<img>中的src数据
            Matcher m = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img);
            while (m.find()) {
                pics.add(m.group(1));
            }
        }
        return pics;
    }
}
