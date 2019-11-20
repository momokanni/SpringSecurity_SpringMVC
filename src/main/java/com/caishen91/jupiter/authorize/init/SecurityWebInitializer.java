package com.caishen91.jupiter.authorize.init;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityWebInitializer extends AbstractSecurityWebApplicationInitializer {

	/**
	 * 	修改权限临时Map
	 */
	private static Map<String, Object> authMap = new ConcurrentHashMap<String, Object>();
	
	/**
	 * 	修改账户状态
	 */
	private static Map<String, Object> statusMap = new ConcurrentHashMap<String, Object>();

	public static boolean bmContainsKey(String value) {
		String type = "bm";
		boolean exists = false;
		if(authMap.containsKey(type)) {
			if(authMap.containsValue(value)) {
				exists = true;
			}
		}
		return exists;
	}
	
	public static boolean debtContainsKey(String value) {
		String type = "debt";
		boolean exists = false;
		if(authMap.containsKey(type)) {
			if(authMap.containsValue(value)) {
				exists = true;
			}
		}
		return exists;
	}
	
	public static void debtRemove(String value) {
		String type = "debt";
		if(authMap.containsKey(type)) {
			if(authMap.containsValue(value)) {
				authMap.remove(type, value);
			}
		}
	}
	
	public static void bmRemove(String value) {
		String type = "debt";
		if(authMap.containsKey(type)) {
			if(authMap.containsValue(value)) {
				authMap.remove(type, value);
			}
		}
	}
	
	public static boolean containsValue(String value) {
		return authMap.containsValue(value);
	}
	
	/**
	 * 	插入已修改权限管理员ID
	 * @param type 'debt' or 'bm'
	 * @param id
	 */
	public static void setAuthMap(String type, String id) {
		SecurityWebInitializer.authMap.put(type, id);
	}
	
	public static void setBMAuthMap(String id) {
		setAuthMap("bm",id);
	}
	
	public static void setDebtAuthMap(String type, String id) {
		setAuthMap("debt",id);
	}
	
	/**
	 * 	插入已修改状态管理员ID
	 * @param type
	 * @param id
	 */
	public static void setStatusMap(String type, String id) {
		SecurityWebInitializer.statusMap.put(type, id);
	}
	
	public static void setBMStatusMap(String id) {
		setStatusMap("bm",id);
	}
	
	public static void setDebtStatusMap(String id) {
		setStatusMap("debt",id);
	}
	
	public static boolean bmStatusContainsKey(String value) {
		String type = "bm";
		boolean exists = false;
		if(statusMap.containsKey(type)) {
			if(statusMap.containsValue(value)) {
				exists = true;
			}
		}
		return exists;
	}
	
	public static boolean debtStatusContainsKey(String value) {
		String type = "debt";
		boolean exists = false;
		if(statusMap.containsKey(type)) {
			if(statusMap.containsValue(value)) {
				exists = true;
			}
		}
		return exists;
	}
	
	public static void debtStatusRemove(String value) {
		String type = "debt";
		if(statusMap.containsKey(type)) {
			if(statusMap.containsValue(value)) {
				statusMap.remove(type, value);
			}
		}
	}
	
	public static void bmStatusRemove(String value) {
		String type = "debt";
		if(statusMap.containsKey(type)) {
			if(statusMap.containsValue(value)) {
				statusMap.remove(type, value);
			}
		}
	}
	
	public static boolean statusContainsValue(String value) {
		return statusMap.containsValue(value);
	}
}
