package com.caishen91.jupiter.enums;

import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.model.SmsTrace;
import com.caishen91.jupiter.util.HtmlClient;
import com.caishen91.jupiter.util.OperationResult;
import com.caishen91.jupiter.util.StringUtil;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum SmsChannel {
	
	
//	clyx("clyx", "创蓝营销") {
//
//		@Override
//		public OperationResult send(SmsTrace trace) {
//			OperationResult or = new OperationResult();
//			
//			
//			
//			Map jsonMap = new HashMap();
//			jsonMap.put("account", Config.SMS_CL_YX_ACCOUNT);
//			jsonMap.put("password", Config.SMS_CL_YX_PWD);
//			jsonMap.put("phone", trace.getMobile() );
//			jsonMap.put("report", "true");
//			jsonMap.put("msg", trace.getContent() + " 退订回T");
//			jsonMap.put("uid", trace.getSeq());
//			
//			HtmlClient client = new HtmlClient();
//			
//			String js = StringUtil.parseJsonString(jsonMap);
//			String rs = client.postJson("http://sms.253.com/msg/send/json", js, "utf8");
//			if (StringUtil.isEmpty(rs)) {
//				or.setStatus(false);
//				or.setOther("empty");
//				return or;
//			}
//			
//			or.setOther(rs);
//			
//			Map rm = StringUtil.parseJsonMap(rs);
//			if (rm == null) {
//				or.setStatus(false);
//				return or;
//			}
//			
//			String code = rm.get("code") + "";
//			
//			or.setStatus("0".equals(code));
//			
//			return or;
//		}
//		
//	},
	clyzm ("clyzm", "创蓝验证码") {

		@Override
		public OperationResult send(SmsTrace trace) {
			OperationResult or = new OperationResult();
			
			
			
			Map jsonMap = new HashMap();
			jsonMap.put("account", Config.SMS_CL_YZM_ACCOUNT);
			jsonMap.put("password", Config.SMS_CL_YZM_PWD);
			jsonMap.put("phone", trace.getMobile() );
			jsonMap.put("report", "true");
			jsonMap.put("msg", trace.getContent());
			jsonMap.put("uid", trace.getSeq());
			
			HtmlClient client = new HtmlClient();
			
			String js = StringUtil.parseJsonString(jsonMap);
			String rs = client.postJson("http://sms.253.com/msg/send/json", js, "utf8");
			if (StringUtil.isEmpty(rs)) {
				or.setStatus(false);
				or.setOther("empty");
				return or;
			}
			
			or.setOther(rs);
			
			Map rm = StringUtil.parseJsonMap(rs);
			if (rm == null) {
				or.setStatus(false);
				return or;
			}
			
			String code = rm.get("code") + "";
			
			or.setStatus("0".equals(code));
			
			return or;
		}
		
	};
	
	private String channel;
	
	private String name;
	
	

	public String getChannel() {
		return channel;
	}



	public void setChannel(String channel) {
		this.channel = channel;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	private SmsChannel(String channel, String name) {
		setChannel(channel);
		setName(name);
	}
	
	public static SmsChannel getChannel(String channel) {
		for(SmsChannel sc : values() ) {
			if (sc.getChannel().equals(channel)) {
				return sc;
			}
		}
		return null;
	}
	
	public static OperationResult sendSms(SmsTrace trace) {
		SmsChannel sc = getChannel(trace.getChannel());
		if (Config.DEBUG) {
			OperationResult or = new OperationResult();
			or.setStatus(true);
			or.setOther(System.currentTimeMillis());
			return or;
		} else {
			try {
				return sc.send(trace);
			} catch (Exception e){
				e.printStackTrace();
				OperationResult or = new OperationResult();
				or.setStatus(false);
				or.setOther("err");
				return or;
			}
			
		}
		
	}
	public OperationResult send(SmsTrace trace) {
		return null;
	}
	
	
	
	
	 /**
     * 短信 返回结果
     * @param xmlString
     */
    public  static String getSmsResult(String xmlString){ 
    	if(StringUtil.isEmpty(xmlString)){
    		return "1";
    	}    	 
    	xmlString=xmlString.trim();
        //创建一个新的字符串  
       StringReader read = new StringReader(xmlString);  
       //创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入  
       InputSource source = new InputSource(read);  
       //创建一个新的SAXBuilder  
       SAXBuilder saxbBuilder = new SAXBuilder();  
       try {  
           //通过输入源构造一个Document  
           Document doc = saxbBuilder.build(source);  
           //取的根元素  
           Element root = doc.getRootElement();  
           System.out.println(root.getName());
           List<?> node = root.getChildren();  
           for (int i = 0; i < node.size(); i++) {
               Element element=(Element)node.get(i);
               String  name=element.getName(); 
               if("error".equals(name)){
            	   return element.getText();
               }  
               
           }
       } catch (JDOMException e) {  
           e.printStackTrace();  
       } catch (IOException e) {  
           e.printStackTrace();  
       }finally{
    	   read.close();
       }
	return "1";  
   }
    
    /**
     * 短信 返回结果
     * @param xmlString
     */
    public  static String getSmsResult_new(String xmlString){ 
    	if(StringUtil.isEmpty(xmlString)){
    		return "1";
    	}    	 
    	xmlString=xmlString.trim();
        //创建一个新的字符串  
       StringReader read = new StringReader(xmlString);  
       //创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入  
       InputSource source = new InputSource(read);  
       //创建一个新的SAXBuilder  
       SAXBuilder saxbBuilder = new SAXBuilder();  
       try {  
           //通过输入源构造一个Document  
           Document doc = saxbBuilder.build(source);  
           //取的根元素  
           Element root = doc.getRootElement();  
           System.out.println(root.getName());
           List<?> node = root.getChildren();  
           for (int i = 0; i < node.size(); i++) {
               Element element=(Element)node.get(i);
               String  name=element.getName(); 
               if("mt".equals(name)){
            	   List<?> secondNode = element.getChildren();
            	   for (int j = 0; j < secondNode.size(); j++) {
					Element secondElement = (Element)secondNode.get(j);
					String secondName = secondElement.getName();
					if ("status".equals(secondName)) {
						return secondElement.getText();
					}
				}
               }  
               
           }
       } catch (JDOMException e) {  
           e.printStackTrace();  
       } catch (IOException e) {  
           e.printStackTrace();  
       }finally{
    	   read.close();
       }
	return "1";  
   }
     
}
