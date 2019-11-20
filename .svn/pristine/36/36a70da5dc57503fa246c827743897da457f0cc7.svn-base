/*
 * Hundsun Inc.
 * Copyright (c) 2006-2016 All Rights Reserved.
 *
 * Author     :zhangx
 * Version    :1.0
 * Create Date:2016-12-6
 *
 */
package com.caishen91.jupiter.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.CollationKey;
import java.text.Collator;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONArray;

/**
 * 
 * @author zhangx
 * @version $Id: Md5Encrypt.java 2016-12-6 下午4:14:05 zhangx $
 * 
 * <pre>说明： 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 */
public class Md5Encrypt {
	/**
	 * Used building output as Hex
	 */
	private static final char[] DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	/**
	 * 对字符串进行MD5加密
	 * 
	 * @param text
	 *            明文
	 * 
	 * @return 密文
	 */
	public static String md5(String text) {
		MessageDigest msgDigest = null;

		try {
			msgDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException("System doesn't support MD5 algorithm.");
		}

		try {
			msgDigest.update(text.getBytes("utf-8"));

		} catch (UnsupportedEncodingException e) {

			throw new IllegalStateException("System doesn't support your  EncodingException.");

		}

		byte[] bytes = msgDigest.digest();

		String md5Str = new String(encodeHex(bytes));

		return md5Str;
	}

	public static char[] encodeHex(byte[] data) {

		int l = data.length;

		char[] out = new char[l << 1];

		// two characters form the hex value.
		for (int i = 0, j = 0; i < l; i++) {
			out[j++] = DIGITS[(0xF0 & data[i]) >>> 4];
			out[j++] = DIGITS[0x0F & data[i]];
		}

		return out;
	}

	public static String getMd5(String userAccount, Long num) {
		return Md5Encrypt.md5(userAccount + num);
	}

	public static boolean checkMd5(String userAccount, Long num, String md5) {
		boolean flag = false;
		if (StringUtils.equals(Md5Encrypt.md5(userAccount + num), md5)) {
			flag = true;
		}
		return flag;
	}

	/**
	 * @Method: sort
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param map
	 * @param @return
	 * @return StringBuilder
	 * @throws
	 */
	public static String sortSource(Map<String, Object> map) {

		if (null == map) {
			return "";
		}
		String sorted = sortMap(map);

		if (null != sorted && !"".equals(sorted) && '&' == sorted.charAt(0)) {
			sorted = sorted.substring(1, sorted.length());
		}
		return sorted;
	}

	@SuppressWarnings("unchecked")
	private static String sortMap(Map<String, Object> map) {
		StringBuilder msg = new StringBuilder();
		if (map.containsKey("cert_sign")) {
			map.remove("cert_sign");
		}
		TreeMap<String, Object> treeMap = new TreeMap<String, Object>(new CustomTreeMapComparator<String>());
		treeMap.putAll(map);
		Object[] keys = treeMap.keySet().toArray();
		if (null != keys && keys.length > 0) {
			for (int i = 0; i < keys.length; i++) {
				if (null != treeMap.get(keys[i])) {
					Object value = treeMap.get(keys[i]);
					if (value instanceof JSONArray) {
						JSONArray jsonArray = (JSONArray) value;
						for (Object jsonObj : jsonArray) {
							msg.append(sortMap((Map<String, Object>) jsonObj));
						}
					} else  {
						msg.append("&").append(keys[i]).append("=").append(value==null?"":String.valueOf(value));
					}
				}
			}
		}
		return msg.toString();
	}

	public static class CustomTreeMapComparator<T> implements Comparator<T> {
		Collator collator = Collator.getInstance();

		public int compare(T t1, T t2) {
			CollationKey key1 = collator.getCollationKey(t1.toString());
			CollationKey key2 = collator.getCollationKey(t2.toString());

			return key1.compareTo(key2);
		}
	}

}
