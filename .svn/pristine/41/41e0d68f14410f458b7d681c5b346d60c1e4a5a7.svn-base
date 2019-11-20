package com.caishen91.jupiter.controller;

import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.util.ImageUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Servlet implementation class QuestionAnswerServlet
 */
public class FileUploadAction extends HttpServlet {
	private static final long serialVersionUID = -7825355637448948879L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.addHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", -10);
		
		System.out.println("here");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 设置内存缓冲区，超过后写入临时文件
		factory.setSizeThreshold(10240000);
		// 设置临时文件存储位置
		String base = Config.IMAGE_UPLOAD_PATH;
		File file = new File(base);
		if(!file.exists())
			file.mkdirs();
		factory.setRepository(file);
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 设置单个文件的最大上传值
		upload.setFileSizeMax(10002400000l);
		// 设置整个request的最大值
		upload.setSizeMax(10002400000l);
		upload.setHeaderEncoding("UTF-8");
		ObjectMapper om = new ObjectMapper();
		Map<String, String> m2 = new HashMap<String, String>();
		String ret2 = null;
		try {
			List items = upload.parseRequest(request);
			FileItem item = null;
			String fileName = null;
			for (int i = 0 ;i < items.size(); i++){
				item = (FileItem) items.get(i);
				fileName = base + item.getName();
				// 保存文件
				if (!item.isFormField() && item.getName().length() > 0) {
					File f = new File(fileName);
					item.write(new File(fileName));
					String ret = ImageUpload.richFileUpload(f, "");
					
					
					if (ret != null && !ret.isEmpty()) {
						ret2 = "{\"error\":0,\"url\":\"" + Config.IMAGE_SERVER + ret + "\"}";
					}
					
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			System.out.println(ret2);
			if (ret2 == null) {
				ret2 = "{\"error\":1,\"message\":\"上传失败\"}";
			}
			
			response.getWriter().write(ret2);
			
			response.getWriter().close();
		}
	
	}
}
