package com.caishen91.jupiter.util;

import com.caishen91.jupiter.config.Config;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.codehaus.jackson.map.ObjectMapper;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ImageUpload {
	
	public static String getSmallImage(String src, int width, int height) {
		
		//img.91caishen.com/source/wimgs/d/front/201801/03/7a823e5b8af64516b9b239b381ceebe7.jpg_o_s_200x200.jpg
		
		if (StringUtil.isEmpty(src)) {
			return "";
		}
		
		Matcher m = Pattern.compile(".*?\\.(.*$)").matcher(src);
		if (m.find()) {
			String ext = m.group(1);
			return src + "_o_s_" + width + "x" + height + "." + ext;
		} else {
			return src;
		}
	}
	
	public static String getOriginImage(String src) {
		
		//img.91caishen.com/source/wimgs/d/front/201801/03/7a823e5b8af64516b9b239b381ceebe7.jpg_o_s_200x200.jpg
		
		if (StringUtil.isEmpty(src)) {
			return "";
		}
		
		Matcher m = Pattern.compile(".*?\\.(.*$)").matcher(src);
		if (m.find()) {
			String ext = m.group(1);
			return src + "_origin_" +  "." + ext;
		} else {
			return src;
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static Map fileUpload3(File file, String user, String width, String heigth, String width2, String height2){
		PostMethod filePost = null;
		PostMethod filePost2 = null;
		Map retMap = new HashMap();
		try{
            HttpClient httpClient = new HttpClient();
            HttpConnectionManagerParams managerParams = httpClient.getHttpConnectionManager().getParams();
            managerParams.setConnectionTimeout(20000);
            managerParams.setSoTimeout(20000);
            
            
            String imgUrl = Config.IMAGE_UPLOAD_SERVER+ "/api/upload.do?method=overlapxdk";
            if(StringUtil.isNotEmpty(user)){
            	imgUrl += "&u=" + user;
            }
            
            String imgUrl1 = imgUrl + "&w=" + width + "&h=" + heigth;
            String imgUrl2 = imgUrl + "&w=" + width2 + "&h=" + height2;
            
            filePost = new PostMethod(imgUrl1);
            Part[] parts = { new FilePart("file", file) };
            filePost.setRequestEntity(new MultipartRequestEntity(parts, filePost.getParams()));
            int status = httpClient.executeMethod(filePost);
            ObjectMapper om = new ObjectMapper();
            if (status == HttpStatus.SC_OK) {
            	String response = filePost.getResponseBodyAsString();
            	if (response == null || response.isEmpty()) {
            		return null;
            	}
            	try {
            		Map m = om.readValue(response, Map.class);
            		int ret = (Integer)m.get("ret");
    				if (ret == 1) {
    					String imgId = (String)m.get("imgId");
    					retMap.put("imgId", imgId);
    				}
            	} catch (Exception e) {
            		e.printStackTrace();
            	}
            }
            
            filePost2 = new PostMethod(imgUrl2);
            Part[] parts2 = { new FilePart("file", file) };
            filePost2.setRequestEntity(new MultipartRequestEntity(parts2, filePost2.getParams()));
            int status2 = httpClient.executeMethod(filePost2);
            
            om = new ObjectMapper();
            if (status2 == HttpStatus.SC_OK) {
            	String response = filePost2.getResponseBodyAsString();
            	if (response == null || response.isEmpty()) {
            		return null;
            	}
            	try {
            		Map m = om.readValue(response, Map.class);
            		int ret = (Integer)m.get("ret");
    				if (ret == 1) {
    					String imgId = (String)m.get("imgId");
    					retMap.put("imgId2", imgId);
    				}
            	} catch (Exception e) {
            		e.printStackTrace();
            	}
            }
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			file.delete();
			if (filePost != null) {
				filePost.releaseConnection();
			}
			if (filePost2 != null) {
				filePost2.releaseConnection();
			}
		}
		return retMap;
	}
	
	
	@SuppressWarnings("rawtypes")
	public static String fileUpload2(File file, String user, String width, String heigth){
		PostMethod filePost = null;
		try{
            HttpClient httpClient = new HttpClient();
            HttpConnectionManagerParams managerParams = httpClient.getHttpConnectionManager().getParams();
            managerParams.setConnectionTimeout(20000);
            managerParams.setSoTimeout(20000);
            String imgUrl = Config.IMAGE_UPLOAD_SERVER+ "/api/upload.do?method=overlapxdk";
            if(StringUtil.isNotEmpty(user)){
            	imgUrl += "&u=" + user;
            }
            
            if(StringUtil.isNotEmpty(width)){
            	imgUrl +="&w=" + width;
            }
            if(StringUtil.isNotEmpty(heigth)){
            	imgUrl += "&h=" + heigth;
            }
            
            filePost = new PostMethod(imgUrl);
            Part[] parts = { new FilePart("file", file) };
            filePost.setRequestEntity(new MultipartRequestEntity(parts, filePost.getParams()));
            int status = httpClient.executeMethod(filePost);
            
            if (status == HttpStatus.SC_OK) {
            	String response = filePost.getResponseBodyAsString();
            	if (response == null || response.isEmpty()) {
            		return null;
            	}
            	ObjectMapper om = new ObjectMapper();
    			try {
    				Map m = om.readValue(response, Map.class);
    				int ret = (Integer)m.get("ret");
    				if (ret == 1) {
    					return (String)m.get("imgId");
    				} else {
    				}
    			} catch (Exception e ) {
    			}
            }
        
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			file.delete();
			if (filePost != null) {
				filePost.releaseConnection();
			}
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	public static String fileUpload(File file, String user){
		try{
            HttpClient httpClient = new HttpClient();
            HttpConnectionManagerParams managerParams = httpClient.getHttpConnectionManager().getParams();
            managerParams.setConnectionTimeout(60000);
            managerParams.setSoTimeout(60000);
            String imgUrl = Config.IMAGE_UPLOAD_SERVER+ "/api/upload.do?method=normal";
            if(StringUtil.isNotEmpty(user)){
            	imgUrl += "?u=" + user;
            }
            PostMethod filePost = new PostMethod(imgUrl);
            Part[] parts = { new FilePart("file", file) };
            filePost.setRequestEntity(new MultipartRequestEntity(parts, filePost.getParams()));
            int status = httpClient.executeMethod(filePost);
            if (status == HttpStatus.SC_OK) {
            	String response = filePost.getResponseBodyAsString();
            	if (response == null || response.isEmpty()) {
            		return null;
            	}
            	ObjectMapper om = new ObjectMapper();
    			try {
    				Map m = om.readValue(response, Map.class);
    				int ret = (Integer)m.get("ret");
    				if (ret == 1) {
    					return (String)m.get("imgId");
    				} else {
    				}
    			} catch (Exception e ) {
    			}
            }
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	@SuppressWarnings("rawtypes")
	public static String richFileUpload(File file, String user){
		try{
            HttpClient httpClient = new HttpClient();
            HttpConnectionManagerParams managerParams = httpClient.getHttpConnectionManager().getParams();
            managerParams.setConnectionTimeout(20000);
            managerParams.setSoTimeout(20000);
            String imgUrl = Config.IMAGE_UPLOAD_SERVER+ "/api/upload.do?method=normal";
            if(StringUtil.isNotEmpty(user)){
            	imgUrl += "?u=" + user;
            }
            PostMethod filePost = new PostMethod(imgUrl);
            Part[] parts = { new FilePart("file", file) };
            filePost.setRequestEntity(new MultipartRequestEntity(parts, filePost.getParams()));
            int status = httpClient.executeMethod(filePost);
            if (status == HttpStatus.SC_OK) {
            	String response = filePost.getResponseBodyAsString();
            	if (response == null || response.isEmpty()) {
            		return null;
            	}
            	ObjectMapper om = new ObjectMapper();
    			try {
    				Map m = om.readValue(response, Map.class);
    				int ret = (Integer)m.get("ret");
    				if (ret == 1) {
    					return (String)m.get("imgId");
    				} else {
    				}
    			} catch (Exception e ) {
    			}
            }
        
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args){
		File file = new File("/home/zhousl/Pictures/demo.bmp");
		System.out.println( ImageUpload.fileUpload2(file, "test", "260", "180"));
	}
}
