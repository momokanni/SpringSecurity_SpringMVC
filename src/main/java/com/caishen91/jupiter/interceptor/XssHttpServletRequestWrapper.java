package com.caishen91.jupiter.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.caishen91.jupiter.constsant.SesssionConsts;
import org.apache.commons.lang3.StringEscapeUtils;


public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {
	 public XssHttpServletRequestWrapper(HttpServletRequest request) {  
	        super(request);  
	    }  
	  
	    @Override  
	    public String getHeader(String name) {  
	        return StringEscapeUtils.escapeHtml4(super.getHeader(name));  
	    }  
	  
//	    @Override  
//	    public String getQueryString() {  
//	        String s =  StringEscapeUtils.escapeHtml4(super.getQueryString());  
//	        if(s != null){
//        		s = s.replaceAll(SesssionConsts.FILTER_REGEXP, "");
//        	}
//	        return s ;
//	    }  
	  
	    @Override  
	    public String getParameter(String name) {  
	        String s= StringEscapeUtils.escapeHtml4(super.getParameter(name));
	        if(s != null){
        		s = s.replaceAll(SesssionConsts.FILTER_REGEXP, "");
        	}
	        return s;
	    }  
	  
	    @Override  
	    public String[] getParameterValues(String name) {  
	        String[] values = super.getParameterValues(name);  
	        if(values != null) {  
	            int length = values.length;  
	            String[] escapseValues = new String[length];  
	            for(int i = 0; i < length; i++){  
	            	String escapeHtml4 = StringEscapeUtils.escapeHtml4(values[i]);
	            	if(escapeHtml4 != null){
	            		escapeHtml4 = escapeHtml4.replaceAll(SesssionConsts.FILTER_REGEXP, "");
	            	}
	                escapseValues[i] = escapeHtml4; 
	            }  
	            return escapseValues;  
	        }  
	        return super.getParameterValues(name);  
	    }  
	    
}
