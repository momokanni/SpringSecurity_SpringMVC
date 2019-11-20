package com.caishen91.jupiter.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtil {
	public final static int MAX_MOBILE_LENGTH = 11;
	public final static int MAX_EMAIL_LENGTH = 50;
	public final static int MAX_PHONE_LENGTH = 20;
	
	public static boolean isMobileNo(String mobiles) {
		if (mobiles == null) return false;
		Pattern p = Pattern
					.compile("^1\\d{10}$");
		Matcher m = p.matcher(mobiles);
		return m.matches() ;
	}
	
	
	
	public static boolean isBankCard(String bankCard) {
		return true;
//		if (bankCard == null) return false;
//		Pattern p = Pattern.compile("^[0-9]{5,24}$");
//		Matcher m = p.matcher(bankCard);
//		return m.matches() ;
	}
	
	public static boolean isTelephone(String telephone) {
		if (telephone== null) return false;
		Pattern p = Pattern
					.compile("0\\d{2,3}-\\d{5,9}|0\\d{2,3}-\\d{5,9}");
		Matcher m = p.matcher(telephone);
		return m.matches() ;
	}
	
	
	public static boolean isPinYin(String src) {
		if (src == null) return false;
		return src.matches("^[a-zA-Z]+$");
	}
	
	public static boolean isLoginName(String username) {
		Pattern p = Pattern
					.compile("^[a-zA-Z][\\da-zA-Z_]*$");
		Matcher m = p.matcher(username);
		return m.matches() ;
	}

	public static boolean isEmail(String email) {
//		String str = "^([a-zA-Z0-9-_\\.])+@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$";
		String str = "^[-|_|\\.|A-Z|a-z|0-9]+@([_|A-Z|a-z|0-9]+\\.)+[A-Z|a-z|0-9]{2,3}$";
		Pattern p = Pattern.compile(str);
		Matcher m = p.matcher(email);
		return m.matches() ;
	}

	
	public static boolean isFloat(String f) {
		if (f == null) return false;
		return f.matches("^\\d+$") || f.matches("^\\d+\\.\\d+$");
	}
	public static boolean isNumber(String number) {
		if (number == null) return false;
		return number.matches("^\\d+$");
	}
	
	public static boolean isDate(String date) {
		if (date == null) return false;
		return date.matches("^\\d+-\\d+-\\d+$");
	}
	public static boolean isPhoneNo(String phone) {
		Pattern p = Pattern.compile("^[[0-9]-()]*$");
		Matcher m = p.matcher(phone);
		return m.matches() && phone.length() <= MAX_PHONE_LENGTH;
	}
	
	public static boolean isIDCard(String IDCard) {
		String isIdCard = CheckIdCard.IDCardValidate(IDCard);
		if (isIdCard.equalsIgnoreCase("YES"))
			return true;
		
		return false;
	}

	public static boolean isValidateKey(String src) {
		if (StringUtil.isEmpty(src)) {
			return false;
		}
		
		return src.matches("^[a-z0-9]+$");
	}

	public static void main(String args[]) {
		String m = "zetawangyi@yeah.123.coma";
		System.out.println(isEmail(m));
		
		
	}
	
	//是否是正整数
	public static boolean isPosNumber(String number) {
		if (number == null) return false;
		return number.matches("^[0-9]*[1-9][0-9]*$");
	}
}
