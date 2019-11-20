package com.caishen91.jupiter.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinYinUtil {

	public static String toUpperCaseHanyuPinyin(String language) {
		
		char[] cs = language.trim().toCharArray();
		StringBuilder builder = new StringBuilder();
		HanyuPinyinOutputFormat pinyinOutputFormat = new HanyuPinyinOutputFormat();
		pinyinOutputFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
		pinyinOutputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		pinyinOutputFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
		try {
			for (int i = 0; i < cs.length; i++){
				if (String.valueOf(cs[i]).matches("[\u4e00-\u9fa5]+")){
					builder.append(PinyinHelper.toHanyuPinyinStringArray(cs[i], pinyinOutputFormat)[0]);
			    } else {
			    	builder.append(cs[i]);
			    }
			}
		} catch (BadHanyuPinyinOutputFormatCombination e) {
		    System.out.println("字符不能转成汉语拼音");
		}
		
		return builder.toString();
	}

	public static String toLowerCaseHanyuPinyin(String language) {

		char[] cs = language.trim().toCharArray();
		StringBuilder builder = new StringBuilder();
		HanyuPinyinOutputFormat pinyinOutputFormat = new HanyuPinyinOutputFormat();
		pinyinOutputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		pinyinOutputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		pinyinOutputFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
		try {
			for (int i = 0; i < cs.length; i++){
				if (String.valueOf(cs[i]).matches("[\u4e00-\u9fa5]+")){
					builder.append(PinyinHelper.toHanyuPinyinStringArray(cs[i], pinyinOutputFormat)[0]);
				} else {
					builder.append(cs[i]);
				}
			}
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			System.out.println("字符不能转成汉语拼音");
		}

		return builder.toString();
	}

	public static String toHanyuPinyinLogogram(String language) {
		
		char[] cs = language.trim().toCharArray();
		StringBuilder builder = new StringBuilder();
		HanyuPinyinOutputFormat pinyinOutputFormat = new HanyuPinyinOutputFormat();
		pinyinOutputFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
		pinyinOutputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		pinyinOutputFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
		
		try {
			for (int i = 0; i < cs.length; i++){
				if (String.valueOf(cs[i]).matches("[\u4e00-\u9fa5]+")){
					String str = PinyinHelper.toHanyuPinyinStringArray(cs[i], pinyinOutputFormat)[0];
					builder.append(str.substring(0,1));
			    } else {
			    	builder.append(cs[i]);
			    }
			}
		} catch (BadHanyuPinyinOutputFormatCombination e) {
		    System.out.println("字符不能转成汉语拼音");
		}
		
		return builder.toString();
	}

	public static void main(String[] args) {
		System.out.println(toLowerCaseHanyuPinyin("大锤"));
	}
}
