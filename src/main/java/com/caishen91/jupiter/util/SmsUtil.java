package com.caishen91.jupiter.util;


import com.caishen91.jupiter.config.Config;

public class SmsUtil {
	public static final StringBuilder code = new StringBuilder("abcdefghijklmnopqrstuvwxyz0123456789");
	
	public static final StringBuilder code2 = new StringBuilder("0123456789");
	public static String genSeq() {
		return "" + System.currentTimeMillis() + (int)(Math.random() * 10000);
	}
	
	public static String genCode() {
		String ret = "";
		for(int i = 0; i < 4; i++) {
			int j = (int)(Math.random() * 10);
			char c = code2.charAt(j);
			ret += c;
		}
		if (Config.DEBUG) {
			return "6666";
		} else {
			return ret;
		}
//		return ret;
	}
	
	public synchronized static String genToken() {
		String s = System.currentTimeMillis() + genCode();
		s = StringUtil.md5(s, 32);
		try {
			Thread.sleep(10L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return s;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(genCode());
	}

	
	
	
	
	
	
}
