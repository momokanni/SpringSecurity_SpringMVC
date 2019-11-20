package com.caishen91.jupiter.interceptor;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;


public class XssFilter implements Filter {
	
	public static Set<String> managerUrl = new HashSet<String>();

	public static Set<String> managerAllUrl = new HashSet<String>();
	
	@Override  
    public void init(FilterConfig filterConfig) throws ServletException { 
		String exclude = filterConfig.getInitParameter("exclude");
		if (StringUtils.isNotEmpty(exclude)) {
			String[] urls = exclude.split("[\r\n]+");
			if (urls != null) {
				for (String url : urls) {
					url = url.trim();
					if (StringUtils.isNotEmpty(url)) {
						managerUrl.add(url);
					}
				}
			}
		}

		String excludeAllUrl = filterConfig.getInitParameter("excludeAllUrl");
		if (StringUtils.isNotEmpty(excludeAllUrl)) {
			String[] urls = excludeAllUrl.split("[\r\n]+");
			if (urls != null) {
				for (String url : urls) {
					url = url.trim();
					if (StringUtils.isNotEmpty(url)) {
						managerAllUrl.add(url);
					}
				}
			}
		}
    }  
  
    @Override  
    public void doFilter(ServletRequest request, ServletResponse response,  
            FilterChain chain) throws IOException, ServletException {  
    	String servletPath = getFirstServletPath(((HttpServletRequest)request).getServletPath());
    	if(!managerUrl.contains(servletPath) && !managerAllUrl.contains(((HttpServletRequest)request).getServletPath())){
    		request = new XssHttpServletRequestWrapper((HttpServletRequest) request);
    	}
        chain.doFilter(request, response);  
    }  
    
    /**
     * 获取第一段url路径
     * @param servletPath
     * @return
     */
    public String getFirstServletPath(String servletPath){
    	if(servletPath.length() == 1){
    		return servletPath;
    	}
    	int indexOf = servletPath.indexOf("/", 1);
    	if(indexOf > 0){
        	String firstServletPath = servletPath.substring(0, indexOf);
        	return firstServletPath;
    	}
    	return servletPath;
    }
  
    @Override  
    public void destroy() {  
    }  
	
}
