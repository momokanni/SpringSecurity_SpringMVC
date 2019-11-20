package com.caishen91.jupiter.enums;


import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.util.StringUtil;

import javax.servlet.http.HttpServletRequest;

public enum PlatSource {

	pc(0, "pc端","3w", "", 2 ), 
	wap(1, "wap端","wap", Config.WAP_DOMAIN, 4 ),
	wx(2, "微信", "weixin", Config.WX_DOMAIN , 8);

	private int source;

	private String desc;

	private String ex ;
	
	private String domain;
	
	private int platValue;
	
	public int getPlatValue() {
		return platValue;
	}

	public void setPlatValue(int platValue) {
		this.platValue = platValue;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getEx() {
		return ex;
	}

	public void setEx(String ex) {
		this.ex = ex;
	}


	private PlatSource(int source, String desc , String ex, String domain, int platValue ) {
		this.source = source;
		this.desc = desc;
		this.ex = ex ;
		this.domain = domain;
		this.platValue = platValue;
	}
	
	public static PlatSource getPlatSourceBySource(int source){
		for(PlatSource ps : PlatSource.values()){
			if(ps.getSource() == source){
				return ps;
			}
		}
		return null;
	}

	
	public  static PlatSource getSource(HttpServletRequest request) {
		String host = request.getHeader("host");
		String domain = host;
		if (StringUtil.isNotEmpty(host)) {
			domain = host.replaceAll(":.*?$","").toLowerCase();
		}
		
		if (Config.WAP_DOMAIN.equals(domain)) {
			return wap;
		} else {
			return pc;
		}
	}
	
	
	
	/**
	 * 按status获取desc
	 * @param status
	 * @return
	 */
	
	public static String getDescStr(int status) {
		for (PlatSource s : PlatSource.values()) {
			if (s.getSource() == status) {
				return s.getDesc();
			}
		}
		return "";
	}
	
	public static String getDomailBySource ( int source ){
		for ( PlatSource ps : PlatSource.values() ){
			if ( source == ps.getSource() ){
				return ps.getDomain() ;
			}
		}
		return PlatSource.pc.getDomain() ;
	}
}
