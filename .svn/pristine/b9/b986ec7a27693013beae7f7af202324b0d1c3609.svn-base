package com.caishen91.jupiter.util;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import java.util.ArrayList;
import java.util.List;

public class HtmlClient {
	
	private int readTimeOut = 7000;
	
	private int connectionTimeOut = 7000;
	
	
	private HttpClient hc = new HttpClient(new MultiThreadedHttpConnectionManager());
	{
		hc.getHttpConnectionManager().getParams().setConnectionTimeout(connectionTimeOut);
		hc.getHttpConnectionManager().getParams().setSoTimeout(readTimeOut);
	}	
	public HttpClient getHc() {
		return hc;
	}
	public HtmlClient() {
	}
	
	public HtmlClient(int connectionTimeOut, int readTimeOut) {
		this.connectionTimeOut = connectionTimeOut;
		this.readTimeOut = readTimeOut;
		
		hc.getHttpConnectionManager().getParams().setConnectionTimeout(connectionTimeOut);
		hc.getHttpConnectionManager().getParams().setSoTimeout(readTimeOut);
	}
	public HtmlClient(String proxyAddress, int port) {
		hc.getHostConfiguration().setProxy(proxyAddress, port);		
		List<Header> headers = new ArrayList<Header>();
		hc.getHostConfiguration().getParams().setParameter("http.default-headers", headers);
	}
	
	public OperationResult getHtmlEx(String url, String charset) {
		OperationResult or = new OperationResult();
		or.setStatus(true);
		GetMethod get = null;
		if (StringUtil.isEmpty(charset)) {
			charset = "utf8";
		}
		String h = "";
		String exception = "";
		int code = 200;
		try {
			get = new GetMethod(url);			
			get.getParams().setContentCharset(charset);
			get.setRequestHeader("Accept-Language","zh-cn");
		    get.setRequestHeader("Connection"," Keep-Alive");
		    get.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(0,false));
			get.getParams().setParameter(HttpMethodParams.SO_TIMEOUT,readTimeOut);  
			int status = hc.executeMethod(get);
			if (status != 200) {
				h = "";
				code = status;
				or.setStatus(false);
			} else {
				byte[] bs = get.getResponseBody();
				h = new String(bs, charset);	
			}
		} catch(Exception e){
			h = "";
			exception = e.getClass().getName();
			or.setStatus(false);
		} finally {
			if (get != null) {
				get.releaseConnection();
			}
		}
		or.setHtml(h);
		or.setCode(code);
		or.setException(exception);
		return or;
	}
	

	public byte[] getByte(String url, String charset) {
		GetMethod get = null;
		if (StringUtil.isEmpty(charset)) {
			charset = "utf8";
		}		
		try {
			get = new GetMethod(url);		
			hc.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
			get.getParams().setContentCharset(charset);
			get.setRequestHeader("Accept-Language","zh-cn");
		    get.setRequestHeader("Connection"," Keep-Alive");
		    get.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3,false));
			get.getParams().setParameter(HttpMethodParams.SO_TIMEOUT,readTimeOut);  
			int status = hc.executeMethod(get);
			if (status != 200) return null;
			byte[] bs = get.getResponseBody();
			return bs;
		}catch (java.io.IOException e) {
			e.printStackTrace();
			return null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		} finally {
			if (get != null) {
				get.releaseConnection();
			}
		}
	}
	
	public String getHtml(String url, String charset) {
		String page = "";
		GetMethod get = null;
		if (StringUtil.isEmpty(charset)) {
			charset = "utf8";
		}		
		try {
			get = new GetMethod(url);		
			hc.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
			get.getParams().setContentCharset(charset);
			get.setRequestHeader("Accept-Language","zh-cn");
		    get.setRequestHeader("Connection"," Keep-Alive");
		    get.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3,false));
			get.getParams().setParameter(HttpMethodParams.SO_TIMEOUT,readTimeOut);  
			int status = hc.executeMethod(get);
			if (status != 200) return "";
			byte[] bs = get.getResponseBody();
			page = new String(bs, charset);
			return page;
		}catch (java.io.IOException e) {
			e.printStackTrace();
			return "";
		}catch(Exception e){
			e.printStackTrace();
			return "";
		} finally {
			if (get != null) {
				get.releaseConnection();
			}
		}
		
	}

	public String postHtml(String url, String body, String charset) {
		String page = "";
		PostMethod post = null;
		if (StringUtil.isEmpty(charset)) {
			charset = "utf8";
		}
		try {
			post = new PostMethod(url);
			hc.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
			post.setRequestHeader("Accept-Language","zh-cn");
			post.setRequestHeader("Connection"," Keep-Alive");
			

			post.getParams().setContentCharset(charset);
			post.getParams().setParameter(HttpMethodParams.SO_TIMEOUT,readTimeOut); 
			post.setRequestEntity(new StringRequestEntity(body,"application/x-www-form-urlencoded", null));

			hc.executeMethod(post);
			byte[] bs = post.getResponseBody();
			page = new String(bs, charset);
			return page;
		}catch (java.io.IOException e) {
			e.printStackTrace();
			return "";
		}catch(Exception e){
			e.printStackTrace();
			return "";
		} finally {
			if (post != null) {
				post.releaseConnection();
			}
		}
	}
	
	public OperationResult postHtmlEx(String url, String body, String charset) {
		OperationResult or = new OperationResult();
		or.setStatus(true);
		PostMethod post = null;
		if (StringUtil.isEmpty(charset)) {
			charset = "utf8";
		}
		String exception = "";
		String h = "";
		int code = 0;
		Header[] responseHeaders = null;
		try {
			post = new PostMethod(url);
			hc.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
			post.setRequestHeader("Accept-Language","zh-cn");
			post.setRequestHeader("Connection"," Keep-Alive");

			post.getParams().setContentCharset(charset);
			post.getParams().setParameter(HttpMethodParams.SO_TIMEOUT,readTimeOut);
			NameValuePair message = new NameValuePair("data", body);
			post.setRequestBody(new NameValuePair[]{message});
			//post.setRequestEntity(new StringRequestEntity(body,"application/x-www-form-urlencoded", null));

			int status = hc.executeMethod(post);

			if (status != 200) {
				h = "";
				code = status;
				or.setStatus(false);
			} else {
				code = status;
				byte[] bs = post.getResponseBody();
				h = new String(bs, charset);
			}

		} catch(Exception e){
			h = "";
			exception = e.getClass().getName();
			or.setStatus(false);
		} finally {
			if (post != null) {
				post.releaseConnection();
			}
		}
		or.setHtml(h);
		or.setCode(code);
		or.setException(exception);
		return or;
	}
	
	public String postJson(String url, String json, String charset) {
		String page = "";
		PostMethod post = null;
		if (StringUtil.isEmpty(charset)) {
			charset = "utf8";
		}
		try {
			post = new PostMethod(url);
			hc.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
			post.setRequestHeader("Accept-Language","zh-cn");
			post.setRequestHeader("Connection"," Keep-Alive");
			

			post.getParams().setContentCharset(charset);
			post.getParams().setParameter(HttpMethodParams.SO_TIMEOUT,readTimeOut); 
			post.setRequestEntity(new StringRequestEntity(json,"application/json", charset));

			hc.executeMethod(post);
			byte[] bs = post.getResponseBody();
			page = new String(bs, charset);
			return page;
		}catch (java.io.IOException e) {
			e.printStackTrace();
			return "";
		}catch(Exception e){
			e.printStackTrace();
			return "";
		} finally {
			if (post != null) {
				post.releaseConnection();
			}
		}
	}
	
	public  static void main(String[] args) {

	}
	
}
