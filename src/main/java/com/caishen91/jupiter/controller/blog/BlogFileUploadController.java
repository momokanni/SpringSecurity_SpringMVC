package com.caishen91.jupiter.controller.blog;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.caishen91.jupiter.authorize.model.BlogManagerDetailsModel;
import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.model.Blog;
import com.caishen91.jupiter.model.BlogManager;
import com.caishen91.jupiter.service.IBlogManagerService;
import com.caishen91.jupiter.util.IDEncryptor;
import com.caishen91.jupiter.util.ImageUpload;
import com.caishen91.jupiter.util.ShareUtil;

/**
 * 	内容平台文件上传
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/blog/upload")
public class BlogFileUploadController {

	@Autowired
	private IBlogManagerService blogManagerService;
	
	@Autowired
	private ShareUtil shareUtil;

	/**
	 * 	【文章内容配图上传】支持多张同时上传
	 * @param req
	 * @param resp
	 * @return
	 */
	@PostMapping("/img")
	@ResponseBody
	public Map<String, Object> uploadImg(HttpServletRequest req,HttpServletResponse resp){
		Map<String, Object> retMap = new HashMap<String, Object>();
		if (req instanceof MultipartHttpServletRequest) {
			MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) req;
			MultipartFile multipartFile = multipartHttpServletRequest.getFile("img");
			if (!multipartFile.isEmpty()) {
				String user = "";
				String width = "";
				String height = "";
				
				// 验证图片类型
				BufferedImage image;
				try {
					image = ImageIO.read(multipartFile.getInputStream());
					if (image == null) {
						retMap.put(Config.EDITOR_CODE,Config.EDITOR_ERROR);
			            retMap.put(Config.ERR_MSG,"图片类型错误");
			            return retMap;
					}
					
					// 验证文件大小
					int imgSize = Integer.parseInt(Config.IMAGE_UPLOAD_SIZE);
					if ((multipartFile.getSize() / 1048576) > imgSize) {
						retMap.put(Config.EDITOR_CODE,Config.EDITOR_ERROR);
			            retMap.put(Config.ERR_MSG,"图片太大");
			            return retMap;
					}
					
					// 本地图片保存路径
					StringBuilder path = new StringBuilder(Config.IMAGE_UPLOAD_PATH);
					File dir = new File(path.toString());
					if (!dir.exists()) {
						dir.mkdirs();
					}
					// 文件名 = 当前毫秒级时间 + 上传图片管理员ID + 图片格式后缀
					path.append(multipartFile.getName());
					// 保存文件到本地服务器
					saveImageToSever(multipartFile.getInputStream(),path.toString());
					// 由本地服务器上传至图片服务器
					width = String.valueOf(image.getWidth());
					height = String.valueOf(image.getHeight());
					String ret = ImageUpload.fileUpload2(new File(path.toString()), user, width, height);
					if (ret != null && !ret.isEmpty()) {
						String[] imgUrls = {Config.IMAGE_SERVER + ret};
						retMap.put(Config.EDITOR_CODE,Config.EDITOR_OK);
						retMap.put(Config.MESSAGE,"图片上传成功");
			            retMap.put(Config.RET_DATA,imgUrls);
			            return retMap;
					}
				} catch (IOException e1) {
					e1.printStackTrace();
					retMap.put(Config.EDITOR_CODE,Config.EDITOR_ERROR);
		            retMap.put(Config.ERR_MSG,"上传失败");
		            return retMap;
				}
			}
		}
		return retMap;
	}
	
	
	/**
	 * 	【文章内容配图上传】支持多张同时上传
	 * @param req
	 * @param resp
	 * @return
	 */
	@PostMapping("/videoThumb")
	@ResponseBody
	public Map<String, Object> uploadVideoThumb(HttpServletRequest req,HttpServletResponse resp){
		Map<String, Object> retMap = new HashMap<String, Object>();
		if (req instanceof MultipartHttpServletRequest) {
			MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) req;
			MultipartFile multipartFile = multipartHttpServletRequest.getFile("videoThumb");
			if (!multipartFile.isEmpty()) {
				String user = "";
				String width = "";
				String height = "";
				
				// 验证图片类型
				BufferedImage image;
				try {
					image = ImageIO.read(multipartFile.getInputStream());
					if (image == null) {
						retMap.put(Config.EDITOR_CODE,Config.EDITOR_ERROR);
			            retMap.put(Config.ERR_MSG,"视频文件异常");
			            return retMap;
					}
					
					/*
					 * // 验证文件大小 int imgSize = Integer.parseInt(Config.IMAGE_UPLOAD_SIZE); if
					 * ((multipartFile.getSize() / 1048576) > imgSize) {
					 * retMap.put(Config.EDITOR_CODE,Config.EDITOR_ERROR);
					 * retMap.put(Config.ERR_MSG,"图片太大"); return retMap; }
					 */
					
					// 本地图片保存路径
					StringBuilder path = new StringBuilder(Config.IMAGE_UPLOAD_PATH);
					File dir = new File(path.toString());
					if (!dir.exists()) {
						dir.mkdirs();
					}
					// 文件名 = 当前毫秒级时间 + 上传图片管理员ID + 图片格式后缀
					path.append(multipartFile.getName());
					// 保存文件到本地服务器
					saveImageToSever(multipartFile.getInputStream(),path.toString());
					// 由本地服务器上传至图片服务器
					width = String.valueOf(image.getWidth());
					height = String.valueOf(image.getHeight());
					String ret = ImageUpload.fileUpload2(new File(path.toString()), user, width, height);
					if (ret != null && !ret.isEmpty()) {
						String[] imgUrls = {Config.IMAGE_SERVER + ret};
						retMap.put(Config.EDITOR_CODE,Config.EDITOR_OK);
						retMap.put(Config.MESSAGE,"视频上传成功");
			            retMap.put(Config.RET_DATA,imgUrls);
			            return retMap;
					}
				} catch (IOException e1) {
					e1.printStackTrace();
					retMap.put(Config.EDITOR_CODE,Config.EDITOR_ERROR);
		            retMap.put(Config.ERR_MSG,"上传失败");
		            return retMap;
				}
			}
		}
		return retMap;
	}
	
	/**
	 * 	【文章内容视频上传】支持多个视频同时上传
	 * @param req
	 * @param resp
	 * @return
	 */
	@PostMapping("/video")
	@ResponseBody
	public Map<String, Object> uploadVideo(HttpServletRequest req,HttpServletResponse resp){
		Map<String, Object> retMap = new HashMap<String, Object>();
		if (req instanceof MultipartHttpServletRequest) {
			MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) req;
			MultipartFile multipartFile = multipartHttpServletRequest.getFile("video");
			if (!multipartFile.isEmpty()) {
				String user = "";
				// 验证图片类型
				try {
					String filename = multipartFile.getOriginalFilename();
					if (!filename.endsWith("mp4")) {
						retMap.put(Config.RET,Config.RET_ERROR);
			            retMap.put(Config.ERR_MSG,"音频文件格式错误");
			            return retMap;
					}
					
					// 验证文件大小
					int imgSize = Integer.parseInt(Config.IMAGE_UPLOAD_SIZE);
					if ((multipartFile.getSize() / 1048576) > imgSize) {
						retMap.put(Config.EDITOR_CODE,Config.EDITOR_ERROR);
			            retMap.put(Config.ERR_MSG,"图片太大");
			            return retMap;
					}
					
					// 本地视频保存路径
					StringBuilder path = new StringBuilder(Config.IMAGE_UPLOAD_PATH);
					File dir = new File(path.toString());
					if (!dir.exists()) {
						dir.mkdirs();
					}
					// 文件名 = 当前毫秒级时间 + 上传视频管理员ID + 视频格式后缀
					path.append(multipartFile.getOriginalFilename());
					// 保存文件到本地服务器
					saveImageToSever(multipartFile.getInputStream(),path.toString());
					// 由本地服务器上传至视频服务器
					String ret = ImageUpload.fileUpload(new File(path.toString()), user);
					if (ret != null && !ret.isEmpty()) {
						String[] imgUrls = {Config.IMAGE_SERVER + ret};
						retMap.put(Config.EDITOR_CODE,Config.EDITOR_OK);
						retMap.put(Config.MESSAGE,"视频上传成功");
			            retMap.put(Config.RET_DATA,imgUrls);
			            return retMap;
					}
				} catch (IOException e1) {
					e1.printStackTrace();
					retMap.put(Config.EDITOR_CODE,Config.EDITOR_ERROR);
		            retMap.put(Config.ERR_MSG,"上传失败");
		            return retMap;
				}
			}
		}
		return retMap;
	}
	
	/**
	 * 	首图
	 * @param thumb
	 * @return
	 */
	@PostMapping("/thumb")
	@ResponseBody
	public Map<String, Object> uploadThumb(@RequestParam(value = "thumb") MultipartFile thumb){
		Map<String, Object> retMap = new HashMap<String, Object>();
		String user = "";
		String width = "300";
		String height = "300";
		// 验证图片类型
		BufferedImage image;
		try {
			image = ImageIO.read(thumb.getInputStream());
			if (image == null) {
				retMap.put(Config.RET,Config.RET_ERROR);
	            retMap.put(Config.ERR_MSG,"图片类型错误");
	            return retMap;
			}
			
			// 验证文件大小
			int imgSize = Integer.parseInt(Config.IMAGE_UPLOAD_SIZE);
			if ((thumb.getSize() / 1048576) > imgSize) {
				retMap.put(Config.RET,Config.RET_ERROR);
	            retMap.put(Config.ERR_MSG,"图片太大");
	            return retMap;
			}
			
			/*
			 * if(image.getWidth() != 300 || image.getHeight() != 300) {
			 * retMap.put(Config.RET,Config.RET_ERROR);
			 * retMap.put(Config.ERR_MSG,"首图尺寸需为：300 * 300"); return retMap; }
			 */
			
			// 本地图片保存路径
			StringBuilder path = new StringBuilder(Config.IMAGE_UPLOAD_PATH);
			File dir = new File(path.toString());
			if (!dir.exists()) {
				dir.mkdirs();
			}
			// 文件名 = 当前毫秒级时间 + 上传图片管理员ID + 图片格式后缀
			path.append(thumb.getName());
			// 保存文件到本地服务器
			saveImageToSever(thumb.getInputStream(),path.toString());
			// 由本地服务器上传至图片服务器
			/*
			 * width = String.valueOf(image.getWidth()); height =
			 * String.valueOf(image.getHeight());
			 */
			String ret = ImageUpload.fileUpload2(new File(path.toString()), user, width, height);
			if (ret != null && !ret.isEmpty()) {
				retMap.put(Config.RET,Config.RET_OK);
	            retMap.put(Config.RET_DATA,Config.IMAGE_SERVER + ret);
	            return retMap;
			}
		} catch (IOException e1) {
			e1.printStackTrace();
			retMap.put(Config.RET,Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"上传失败");
            return retMap;
		}
		return retMap;
	}
	
	/**
	 * 	上传音频
	 * @param audio
	 * @return
	 */
	@PostMapping("/audio")
	@ResponseBody
	public Map<String, Object> uploadAudio(@RequestParam(value = "audio") MultipartFile audio){
		Map<String, Object> retMap = new HashMap<String, Object>();
		String user = "";
		try {
			String filename = audio.getOriginalFilename();
			if (!filename.endsWith("mp3")) {
				retMap.put(Config.RET,Config.RET_ERROR);
	            retMap.put(Config.ERR_MSG,"音频文件格式错误");
	            return retMap;
			}
			
			// 验证文件大小
			int audioSize = Integer.parseInt(Config.IMAGE_UPLOAD_SIZE);
			if ((audio.getSize() / 20971520) > audioSize) {
				retMap.put(Config.RET,Config.RET_ERROR);
	            retMap.put(Config.ERR_MSG,"音频文件不能超过20MB");
	            return retMap;
			}
			
			// 本地视频保存路径
			StringBuilder path = new StringBuilder(Config.IMAGE_UPLOAD_PATH);
			File dir = new File(path.toString());
			if (!dir.exists()) {
				dir.mkdirs();
			}
			// 文件名 = 当前毫秒级时间 + 上传图片管理员ID + 图片格式后缀
			path.append(audio.getOriginalFilename());
			// 保存文件到本地服务器
			saveImageToSever(audio.getInputStream(),path.toString());
			// 由本地服务器上传至图片服务器
			String ret = ImageUpload.fileUpload(new File(path.toString()), user);
			if (ret != null && !ret.isEmpty()) {
				retMap.put(Config.RET,Config.RET_OK);
				Map<String, Object> resultMap = new HashMap<String, Object>();
				resultMap.put("audioPath", Config.IMAGE_DISPLAY_PATH + ret);
				resultMap.put("audioName", filename);
	            retMap.put(Config.RET_DATA,resultMap);
	            return retMap;
			}
		} catch (IOException e1) {
			e1.printStackTrace();
			retMap.put(Config.RET,Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"上传失败");
            return retMap;
		}
		return retMap;
	}

	/**
	 * 	更换头像
	 * @param headImg
	 * @return
	 */
	@PostMapping("/headImg")
	@ResponseBody
	public Map<String, Object> uploadHeadImg(@RequestParam(value = "headImg") MultipartFile headImg){
		Map<String, Object> retMap = new HashMap<String, Object>();
		String user = "";
		String width = "";
		String height = "";
		// 验证图片类型
		BufferedImage image;
		try {
			image = ImageIO.read(headImg.getInputStream());
			if (image == null) {
				retMap.put(Config.RET,Config.RET_ERROR);
				retMap.put(Config.ERR_MSG,"图片类型错误");
				return retMap;
			}

			// 验证文件大小
			int imgSize = Integer.parseInt(Config.IMAGE_UPLOAD_SIZE);
			if ((headImg.getSize() / 1048576) > imgSize) {
				retMap.put(Config.RET,Config.RET_ERROR);
				retMap.put(Config.ERR_MSG,"图片太大");
				return retMap;
			}

			// 本地图片保存路径
			StringBuilder path = new StringBuilder(Config.IMAGE_UPLOAD_PATH);
			File dir = new File(path.toString());
			if (!dir.exists()) {
				dir.mkdirs();
			}
			// 文件名 = 当前毫秒级时间 + 上传图片管理员ID + 图片格式后缀
			path.append(headImg.getName());
			// 保存文件到本地服务器
			saveImageToSever(headImg.getInputStream(),path.toString());
			// 由本地服务器上传至图片服务器
			width = String.valueOf(image.getWidth());
			height = String.valueOf(image.getHeight());
			String ret = ImageUpload.fileUpload2(new File(path.toString()), user, width, height);
			if (ret != null && !ret.isEmpty()) {
				BlogManagerDetailsModel bmd = (BlogManagerDetailsModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				int bmId = IDEncryptor.getInstance().decryptWithoutException(bmd.getId());
				BlogManager bm = blogManagerService.getBMById(bmId);

				Blog blog=blogManagerService.getBlogById(bm.getBlogId());
				blog.setHeadImg(Config.IMAGE_SERVER + ret);
				blogManagerService.uploadHeadImg(blog);
				retMap.put(Config.RET,Config.EDITOR_OK);
				retMap.put(Config.RET_DATA,Config.IMAGE_SERVER + ret);
				return retMap;
			}
		} catch (IOException e1) {
			e1.printStackTrace();
			retMap.put(Config.RET,Config.RET_ERROR);
			retMap.put(Config.ERR_MSG,"上传失败");
			return retMap;
		}
		return retMap;
	}

	/**
	 * 	更换头像
	 * @param headImgMb
	 * @return
	 */
	@PostMapping("/headImgMb")
	@ResponseBody
	public Map<String, Object> headImgMb(@RequestParam(value = "headImgMb") MultipartFile headImgMb){
		Map<String, Object> retMap = new HashMap<String, Object>();
		String user = "";
		String width = "";
		String height = "";
		// 验证图片类型
		BufferedImage image;
		try {
			image = ImageIO.read(headImgMb.getInputStream());
			if (image == null) {
				retMap.put(Config.RET,Config.RET_ERROR);
				retMap.put(Config.ERR_MSG,"图片类型错误");
				return retMap;
			}

			// 验证文件大小
			int imgSize = Integer.parseInt(Config.IMAGE_UPLOAD_SIZE);
			if ((headImgMb.getSize() / 1048576) > imgSize) {
				retMap.put(Config.RET,Config.RET_ERROR);
				retMap.put(Config.ERR_MSG,"图片太大");
				return retMap;
			}

			// 本地图片保存路径
			StringBuilder path = new StringBuilder(Config.IMAGE_UPLOAD_PATH);
			File dir = new File(path.toString());
			if (!dir.exists()) {
				dir.mkdirs();
			}
			// 文件名 = 当前毫秒级时间 + 上传图片管理员ID + 图片格式后缀
			path.append(headImgMb.getName());
			// 保存文件到本地服务器
			saveImageToSever(headImgMb.getInputStream(),path.toString());
			// 由本地服务器上传至图片服务器
			width = String.valueOf(image.getWidth());
			height = String.valueOf(image.getHeight());
			String ret = ImageUpload.fileUpload2(new File(path.toString()), user, width, height);
			if (ret != null && !ret.isEmpty()) {
				BlogManagerDetailsModel bmd = (BlogManagerDetailsModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				int bmId = IDEncryptor.getInstance().decryptWithoutException(bmd.getId());
				BlogManager bm = blogManagerService.getBMById(bmId);

				Blog blog=blogManagerService.getBlogById(bm.getBlogId());
				blog.setHeadImgMb(Config.IMAGE_SERVER + ret);
				blogManagerService.uploadHeadImgMb(blog);
				
				shareUtil.shareSource(blog);
				retMap.put(Config.RET,Config.EDITOR_OK);
				retMap.put(Config.RET_DATA,Config.IMAGE_SERVER + ret);
				return retMap;
			}
		} catch (IOException e1) {
			e1.printStackTrace();
			retMap.put(Config.RET,Config.RET_ERROR);
			retMap.put(Config.ERR_MSG,"上传失败");
			return retMap;
		}
		return retMap;
	}


	/**
	 * 	保存图片到本地
	 * @param inputStream
	 * @param url
	 * @return
	 */
	public static void saveImageToSever(InputStream inputStream, String url) {
		byte[] data = new byte[10240];
		int len = 0;
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(url);
			while ((len = inputStream.read(data)) != -1) {
				fileOutputStream.write(data, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public String parsePostContent(InputStream item){
		String content = "";
		LineNumberReader reader = null;
		try{
			reader = new LineNumberReader(new InputStreamReader(item));
			String tuser = "";
			while((tuser=reader.readLine()) != null){
				content += tuser;
			}
		}catch(Exception e){
			
		}finally{
			if(reader != null){
				try{
					reader.close();
				}catch(Exception e){}
			}
		}
		
		return content;
	}
}
