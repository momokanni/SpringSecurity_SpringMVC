package com.caishen91.jupiter.dao;

import java.util.Map;

public class BlogPermitProvider {

	public String getPermitById(Map<String,Object> params) {
		String str = params.get("authStr").toString();
		StringBuilder sb = new StringBuilder();
		sb.append("select id,authorize from blog_permit where id in ");
		sb.append("(");
		sb.append(str);
		sb.append(");");
		return sb.toString();
	}
	
	public String getMenuTreeByIds(Map<String,Object> params) {
		String str = params.get("authStr").toString();
		StringBuilder sb = new StringBuilder();
		sb.append("select id,name,parentId,url,elementId from blog_permit where id in ");
		sb.append("(");
		sb.append(str);
		sb.append(") and type = 0; ");
		return sb.toString();
	}
	
	public String getBmAuthByIds(Map<String,Object> params) {
		String str = params.get("authStr").toString();
		StringBuilder sb = new StringBuilder();
		sb.append("select id,name as 'title',parentId from blog_permit where id in ");
		sb.append("(");
		sb.append(str);
		sb.append(")");
		return sb.toString();
	}
}
