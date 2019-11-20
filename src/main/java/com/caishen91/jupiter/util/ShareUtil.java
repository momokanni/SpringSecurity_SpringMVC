package com.caishen91.jupiter.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.dto.ArticleDTO;
import com.caishen91.jupiter.enums.ArticleOtherStatus;
import com.caishen91.jupiter.enums.ShareStatus;
import com.caishen91.jupiter.model.Article;
import com.caishen91.jupiter.model.Blog;
import com.caishen91.jupiter.model.ShareForRequest;
import com.caishen91.jupiter.model.ShareSource;
import com.caishen91.jupiter.service.IArticleService;
import com.caishen91.jupiter.service.IArticleShareService;

/**
 * 	分享赚工具类
 * @author Administrator
 *
 */
@Component
public class ShareUtil {
	
	private static Logger logger = LoggerFactory.getLogger(ShareUtil.class);
	
	@Autowired
	private IArticleService articleService;
	
	@Autowired
	private IArticleShareService shareService;
	

	public Map<String, Object> share(ArticleDTO arDto,Blog blog) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		ShareForRequest shareReq = new ShareForRequest();
		shareReq.setFkId(IDEncryptor.getInstance().encryptWithoutException(Integer.valueOf(arDto.getId())));
		shareReq.setTitle(arDto.getTitle());
		shareReq.setPic(arDto.getThumb());
		shareReq.setShareType(0);
		shareReq.setShareTitle(arDto.getTitle());
		shareReq.setShareContent(arDto.getShareContent() == null ? "" : arDto.getShareContent());
		shareReq.setCategoryId(IDEncryptor.getInstance().encryptWithoutException(Integer.valueOf(arDto.getLabel())));
		shareReq.setSeq(0);
		shareReq.setStatus(1);
		shareReq.setTitleCount(arDto.getWordCount() == null ? 0 : arDto.getWordCount());
		shareReq.setPicCount(arDto.getImgCount() == null ? 0 : arDto.getImgCount());
		shareReq.setAudioUrl(arDto.getAudioPath() == null ? "" : arDto.getAudioPath());
		shareReq.setVedioUrl("");
		shareReq.setCreateTime(new Date());
		shareReq.setUpdateTime(new Date());
		shareReq.setSourceId(arDto.getArticleSourceId());
		shareReq.setLabel(arDto.getOtherStatus() == null ? String.valueOf(ArticleOtherStatus.NO_STATUS.getType()) : arDto.getOtherStatus());
		List<ShareForRequest> lists = new ArrayList<ShareForRequest>();
		lists.add(shareReq);
		String json = JSON.toJSONString(lists);
		HtmlClient client = new HtmlClient();
		OperationResult resp = client.postHtmlEx(Config.SHARE_ARTICLE_URL, json, "utf-8");
		if(resp.isSuccess()) {
			// 修改文章分享状态（id,当前文章状态，要变更状态）
			int upResult = articleService.updateARShareStatusById(Integer.valueOf(arDto.getId()),Integer.valueOf(arDto.getStatus()),ShareStatus.SHARED.getStatus(),ShareStatus.NOT_SHARED.getStatus(),DateUtil.fomatToYYYY_MM_dd_HH_mm_ss(new Date()));
			if(upResult == 0) {
				retMap.put(Config.RET, Config.RET_ERROR);
	            retMap.put(Config.ERR_MSG,"添加分享赚失败");
	            return retMap;
			}
			// 添加到分享赚
			int shareResult = shareService.add(Integer.valueOf(arDto.getId()));
			
			if(shareResult == 0) {
				retMap.put(Config.RET, Config.RET_ERROR);
	            retMap.put(Config.ERR_MSG,"添加分享赚失败");
	            return retMap;
			}
		} else {
			retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"分享赚接口访问异常");
            return retMap;
		}
		retMap.put(Config.RET, Config.RET_OK);
		retMap.put(Config.MESSAGE, "已成功加入分享赚");
		return retMap;
	}
	
	public OperationResult shareOpera(ArticleDTO arDto,Blog blog) {
		ShareForRequest shareReq = new ShareForRequest();
		shareReq.setFkId(IDEncryptor.getInstance().encryptWithoutException(Integer.valueOf(arDto.getId())));
		shareReq.setTitle(arDto.getTitle());
		shareReq.setPic(arDto.getThumb());
		shareReq.setShareType(0);
		shareReq.setShareTitle(arDto.getTitle());
		shareReq.setShareContent(arDto.getShareContent() == null ? "" : arDto.getShareContent());
		shareReq.setCategoryId(IDEncryptor.getInstance().encryptWithoutException(Integer.valueOf(arDto.getLabel())));
		shareReq.setSeq(0);
		shareReq.setStatus(1);
		shareReq.setTitleCount(arDto.getWordCount() == null ? 0 : arDto.getWordCount());
		shareReq.setPicCount(arDto.getImgCount() == null ? 0 : arDto.getImgCount());
		shareReq.setAudioUrl(arDto.getAudioPath() == null ? "" : arDto.getAudioPath());
		shareReq.setVedioUrl("");
		shareReq.setCreateTime(new Date());
		shareReq.setUpdateTime(new Date());
		shareReq.setSourceId(arDto.getArticleSourceId());
		shareReq.setLabel(arDto.getOtherStatus() == null ? String.valueOf(ArticleOtherStatus.NO_STATUS.getType()) : arDto.getOtherStatus());
		List<ShareForRequest> lists = new ArrayList<ShareForRequest>();
		lists.add(shareReq);
		String json = JSON.toJSONString(lists);
		HtmlClient client = new HtmlClient();
		OperationResult resp = client.postHtmlEx(blog.getPushUrl(), json, "utf-8");
		if(resp.isSuccess()) {
			// 修改文章分享状态（id,当前文章状态，要变更状态）
			articleService.updateARShareStatusById(Integer.valueOf(arDto.getId()),Integer.valueOf(arDto.getStatus()),ShareStatus.SHARED.getStatus(),ShareStatus.NOT_SHARED.getStatus(),DateUtil.fomatToYYYY_MM_dd_HH_mm_ss(new Date()));
			
			// 添加到分享赚
			shareService.add(Integer.valueOf(arDto.getId()));
			
		} else {
			resp.setStatus(false);
		}
		return resp;
	}
	
	public Map<String, Object> share(Article article,Blog blog) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		ShareForRequest shareReq = new ShareForRequest();
		shareReq.setFkId(IDEncryptor.getInstance().encryptWithoutException(article.getId()));
		shareReq.setTitle(article.getTitle());
		shareReq.setPic(article.getThumb());
		shareReq.setShareType(0);
		shareReq.setShareTitle(article.getTitle());
		shareReq.setShareContent(article.getShareContent() == null ? "" : article.getShareContent());
		shareReq.setCategoryId(IDEncryptor.getInstance().encryptWithoutException(article.getLabelId()));
		shareReq.setSeq(0);
		shareReq.setStatus(1);
		shareReq.setTitleCount(article.getWordCount());
		shareReq.setPicCount(article.getImgCount());
		shareReq.setAudioUrl(article.getAudioPath() == null ? "" : article.getAudioPath());
		shareReq.setVedioUrl("");
		shareReq.setCreateTime(article.getCreateTime());
		shareReq.setUpdateTime(article.getUpdateTime());
		shareReq.setSourceId(article.getSourceId());
		shareReq.setLabel(String.valueOf(article.getOtherStatus()));
		List<ShareForRequest> lists = new ArrayList<ShareForRequest>();
		lists.add(shareReq);
		String json = JSON.toJSONString(lists);
		HtmlClient client = new HtmlClient();
		OperationResult resp = client.postHtmlEx(blog.getPushUrl(), json, "utf-8");
		if(resp.isSuccess()) {
			// 修改文章分享状态（id,当前文章状态，要变更状态）
			if(article.getStatus() == Article.ArticleStatus.toBeReleased.getId()) {
				article.setStatus(Article.ArticleStatus.hasBeenReleased.getId());
			}
			int upResult = articleService.updateARShareStatusById(article.getId(),article.getStatus(),ShareStatus.SHARED.getStatus(),ShareStatus.NOT_SHARED.getStatus(),DateUtil.fomatToYYYY_MM_dd_HH_mm_ss(new Date()));
			if(upResult == 0) {
				retMap.put(Config.RET, Config.RET_ERROR);
	            retMap.put(Config.ERR_MSG,"添加分享赚失败");
	            return retMap;
			}
			// 添加到分享赚
			int shareResult = shareService.add(article.getId());
			
			if(shareResult == 0) {
				retMap.put(Config.RET, Config.RET_ERROR);
	            retMap.put(Config.ERR_MSG,"添加分享赚失败");
	            return retMap;
			}
		} else {
			retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"分享赚接口访问异常");
            return retMap;
		}
		retMap.put(Config.RET, Config.RET_OK);
		retMap.put(Config.MESSAGE, "已成功加入分享赚");
		return retMap;
	}
	
	public OperationResult shareForTiming(Article article, Blog blog) {
		ShareForRequest shareReq = new ShareForRequest();
		shareReq.setFkId(IDEncryptor.getInstance().encryptWithoutException(article.getId()));
		shareReq.setTitle(article.getTitle());
		shareReq.setPic(article.getThumb());
		shareReq.setShareType(0);
		shareReq.setShareTitle(article.getTitle());
		shareReq.setShareContent(article.getShareContent() == null ? "" : article.getShareContent());
		shareReq.setCategoryId(IDEncryptor.getInstance().encryptWithoutException(article.getLabelId()));
		shareReq.setSeq(0);
		shareReq.setStatus(1);
		shareReq.setTitleCount(article.getWordCount());
		shareReq.setPicCount(article.getImgCount());
		shareReq.setAudioUrl(article.getAudioPath() == null ? "" : article.getAudioPath());
		shareReq.setVedioUrl("");
		if(article.getStatus() == Article.ArticleStatus.toBeReleased.getId()){
			shareReq.setCreateTime(article.getReleaseTime());
		} else {
			shareReq.setCreateTime(article.getCreateTime());
		}
		shareReq.setUpdateTime(article.getUpdateTime());
		shareReq.setSourceId(article.getSourceId());
		shareReq.setLabel(String.valueOf(article.getOtherStatus()));
		List<ShareForRequest> lists = new ArrayList<ShareForRequest>();
		lists.add(shareReq);
		String json = JSON.toJSONString(lists);
		HtmlClient client = new HtmlClient();
		OperationResult resp = client.postHtmlEx(blog.getPushUrl(), json, "utf-8");
		if(resp.isSuccess()) {
			// 修改文章分享状态（id,要变更状态,，当前文章状态）
			articleService.updateARShareStatusAndOtherStatusById(article.getId(),Article.ArticleStatus.hasBeenReleased.getId(),ShareStatus.SHARED.getStatus(),
																 DateUtil.fomatToYYYY_MM_dd_HH_mm_ss(new Date()));

			// 添加到分享赚
			int shareResult = shareService.add(article.getId());
			
			if(shareResult == 0) {
				resp.setStatus(false);
			}
		} else {
			resp.setStatus(false);
		}
		return resp;
	}
	
	public OperationResult shareForXx(Article article, Blog blog) {
		ShareForRequest shareReq = new ShareForRequest();
		shareReq.setFkId(IDEncryptor.getInstance().encryptWithoutException(article.getId()));
		shareReq.setTitle(article.getTitle());
		shareReq.setPic(article.getThumb());
		shareReq.setShareType(0);
		shareReq.setShareTitle(article.getTitle());
		shareReq.setShareContent(article.getShareContent() == null ? "" : article.getShareContent());
		shareReq.setCategoryId(IDEncryptor.getInstance().encryptWithoutException(article.getLabelId()));
		shareReq.setSeq(0);
		shareReq.setStatus(0);
		shareReq.setTitleCount(article.getWordCount());
		shareReq.setPicCount(article.getImgCount());
		shareReq.setAudioUrl(article.getAudioPath() == null ? "" : article.getAudioPath());
		shareReq.setVedioUrl("");
		if(article.getStatus() == Article.ArticleStatus.toBeReleased.getId()){
			shareReq.setCreateTime(article.getReleaseTime());
		} else {
			shareReq.setCreateTime(article.getCreateTime());
		}
		shareReq.setUpdateTime(article.getUpdateTime());
		shareReq.setSourceId(article.getSourceId());
		shareReq.setLabel(String.valueOf(article.getOtherStatus()));
		List<ShareForRequest> lists = new ArrayList<ShareForRequest>();
		lists.add(shareReq);
		String json = JSON.toJSONString(lists);
		HtmlClient client = new HtmlClient();
		OperationResult resp = client.postHtmlEx(blog.getPushUrl(), json, "utf-8");
		if(resp.isSuccess()) {
			// 修改文章分享状态（id,要变更状态,，当前文章状态）
			articleService.updateARShareStatusAndOtherStatusById(article.getId(),Article.ArticleStatus.hasBeenReleased.getId(),ShareStatus.SHARED.getStatus(),
																 DateUtil.fomatToYYYY_MM_dd_HH_mm_ss(new Date()));

			// 添加到分享赚
			int shareResult = shareService.add(article.getId());
			
			if(shareResult == 0) {
				resp.setStatus(false);
			}
		} else {
			resp.setStatus(false);
		}
		return resp;
	}

	public void shareSource(Blog blog) {
		ShareSource shareSource = new ShareSource();
		shareSource.setId(blog.getId());
		shareSource.setImgUrl(blog.getHeadImgMb());
		shareSource.setStatus(blog.getStatus());
		shareSource.setCreateTime(blog.getCreateTime());
		shareSource.setUpdateTime(blog.getUpdateTime());
		List<ShareSource> lists = new ArrayList<ShareSource>();
		lists.add(shareSource);
		String json = JSONObject.toJSONString(lists);
        HtmlClient client = new HtmlClient();
     	OperationResult result = client.postHtmlEx(Config.SHARE_SOURCE_URL, json, "utf-8");
     	logger.info("upload imgMB status :{}, msg: {}", result.isSuccess(),result.getMessage());
	}
}
