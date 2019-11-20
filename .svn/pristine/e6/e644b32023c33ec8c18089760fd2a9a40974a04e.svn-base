package com.caishen91.jupiter.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class GlobalProperties {
	private static Logger logger = LoggerFactory.getLogger(GlobalProperties.class);
    private static Properties props;
    static{
    	String filename = "tts.properties";
        InputStream is=GlobalProperties.class.getResourceAsStream("/" + filename);
        props = new Properties();
        try {
            props.load(is);
        }
        catch (Exception e) {
            logger.error("Cann't access the " + filename,e);
        } 
    }
    
    public static String getProperty(String name){
    	String val = props.getProperty(name.trim());
    	if(val == null){
    		return null;
    	}else{
    		//去除前后端空格
    		return val.trim();
    	}
    }
    
    public static String getProperty(String name, String defaultValue) {
		String value = getProperty(name);
		if(value == null){
			value = defaultValue;
		}
		return value.trim();
	}
    
    //获得整数属性值
	public static int getIntProperty(String name,int defaultVal){
		int val = defaultVal;
		String valStr = getProperty(name);
		if(valStr != null){
			val = Integer.parseInt(valStr);
		}
		return val;
	}
	
	//获得整数属性值
	public static BigDecimal getBigDecimalProperty(String name,BigDecimal defaultVal){
		BigDecimal val = defaultVal;
		String valStr = getProperty(name);
		if(valStr != null){
			val = new BigDecimal(valStr);
		}
		return val;
	}
		
		
	//获得double属性值
	public static double getDoubleProperty(String name,double defaultVal){
		double val = defaultVal;
		String valStr = getProperty(name);
		if(valStr != null){
			val = Double.parseDouble(valStr);
		}
		return val;
	}
	
	
	public static boolean getBooleanItem(String name, boolean defaultValue) {
		boolean b = defaultValue;
		String valStr = getProperty(name);
		if(valStr != null){
			b = Boolean.parseBoolean(valStr);
		}
		return b;
	}
	
	public static List<Integer> getIntListItem(String item){
		List<Integer> list = new ArrayList<Integer>();
		String value = getProperty(item, "");
		if(value.trim().isEmpty()){
			return list;
		}
		
		String sepChar = ",";
		if(value.indexOf(";")!=-1){
			sepChar = ";";
		}
		String[] sa = value.split(sepChar);
		for (int i = 0; i < sa.length; i++) {
			String s = sa[i].trim();
			if (s.isEmpty()) continue;
			list.add(Integer.valueOf(s));
		}
		return list;
	}
	
	public static List<String> getListItem(String item){
		List<String> list = new ArrayList<String>();
		String value = getProperty(item, "");
		if(value.trim().isEmpty()){
			return list;
		}
		
		String sepChar = ",";
		if(value.indexOf(";")!=-1){
			sepChar = ";";
		}
		String[] sa = value.split(sepChar);
		for (int i = 0; i < sa.length; i++) {
			list.add(sa[i].trim());
		}
		return list;
	}
    
    public static void setProperty(String name ,String value){
        props.setProperty(name, value);
    }
}
