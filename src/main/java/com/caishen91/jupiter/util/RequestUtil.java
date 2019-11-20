package com.caishen91.jupiter.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RequestUtil {
	
	public static void redirect301(HttpServletRequest request, HttpServletResponse response, String url) {
		response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
		response.setHeader( "Location", url);
		response.setHeader( "Connection", "close" );
	}
	
	public static void redirect302(HttpServletRequest request, HttpServletResponse response, String url) {
		response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
		response.setHeader( "Location", url);
		response.setHeader( "Connection", "close" );
	}
	
	public static void redirect403(HttpServletRequest request, HttpServletResponse response, String url) {
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		response.setHeader( "Location", url);
		response.setHeader( "Connection", "close" );
	}
	
	public static int getPort(HttpServletRequest request) {
		int ret = 80;
		String host = request.getHeader("host");
		if (host.contains(":")) {
			Matcher m = Pattern.compile(".*?:(\\d+)").matcher(host);
			if (m.find()) {
				ret = Integer.valueOf(m.group(1));
			}
		}
		return ret;
	}
	
	public static boolean isSpider(HttpServletRequest request) {
		String agent = getAgent(request);
		
		if (agent == null) {
			return false;
		}
		
		if (agent.toLowerCase().contains("baiduspider")) {
			return true;
		}
		
		return false;
	}
	
	
	public static String getAgent(HttpServletRequest request) {
		return request.getHeader("User-Agent");
	}
	public static String getDomain(HttpServletRequest request) {
		String host = request.getHeader("host");
		if(StringUtil.isEmpty(host))
			return null;
		return host.replaceAll(":.*?$","").toLowerCase();
	}
	
	public static String getUri(HttpServletRequest request){
		String url="";
		url=(String) request.getAttribute("uri");
		return url;
	}
}