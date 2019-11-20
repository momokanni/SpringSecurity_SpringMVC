package com.caishen91.jupiter.controller.blog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.caishen91.jupiter.authorize.model.BlogManagerDetailsModel;
import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.dto.ArticleDTO;
import com.caishen91.jupiter.enums.ArticleOtherStatus;
import com.caishen91.jupiter.enums.BlogManagerType;
import com.caishen91.jupiter.enums.ShareStatus;
import com.caishen91.jupiter.model.Article;
import com.caishen91.jupiter.model.ArticleType;
import com.caishen91.jupiter.model.Blog;
import com.caishen91.jupiter.model.BlogLabel;
import com.caishen91.jupiter.model.BlogManager;
import com.caishen91.jupiter.model.BlogMenuTree;
import com.caishen91.jupiter.model.ShareForRequest;
import com.caishen91.jupiter.service.IArticleService;
import com.caishen91.jupiter.service.IArticleShareService;
import com.caishen91.jupiter.service.IBlogManagerService;
import com.caishen91.jupiter.service.IBlogPermitService;
import com.caishen91.jupiter.util.CommonUtil;
import com.caishen91.jupiter.util.DateUtil;
import com.caishen91.jupiter.util.HtmlClient;
import com.caishen91.jupiter.util.IDEncryptor;
import com.caishen91.jupiter.util.OperationResult;
import com.caishen91.jupiter.util.ShareUtil;
import com.caishen91.jupiter.vo.ArticleVO;

/**
 * 	文章管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/blog/share")
public class BlogShareController {
	
	@Autowired
	private IBlogManagerService blogManagerService;
	
	@Autowired
	private IArticleService articleService;
	
	@Autowired
	private IArticleShareService shareService;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private IBlogPermitService blogPermitService;
	
	@Autowired
	private ShareUtil shareUtil;
	

	/**
	 * 	文章列表页
	 * @param req
	 * @param resp
	 * @return
	 */
	@GetMapping(value = "/list")
	public String toArticleList(HttpServletRequest req,HttpServletResponse resp) {
		BlogManagerDetailsModel bmd = (BlogManagerDetailsModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int bmId = IDEncryptor.getInstance().decryptWithoutException(bmd.getId());
		int blogId = IDEncryptor.getInstance().decryptWithoutException(bmd.getBlogId());
		
		BlogManager bm = blogManagerService.getBMById(bmId);
        req.setAttribute("blogManager", bm);
        //获取登陆用户的公众号信息  展示top页面个人信息
        Blog blog = blogManagerService.getBlogById(blogId);
        req.setAttribute("blog", blog);
        
        List<BlogMenuTree> menuTree = blogPermitService.getMenu(blog.getId(),bmId);
		request.setAttribute("menuTree",menuTree);
        
		return "../blogPlatform/shareList";
	}
	
	
	/**
	 * 	文章列表
	 * @param pageNo
	 * @param perPageNo
	 * @return
	 */
	@GetMapping(value = "/getShareList")
	@ResponseBody
	public Map<String, Object> getBlogList(
								@RequestParam(defaultValue = "0", required = false) String  pageNo,
								@RequestParam(defaultValue = "10", required = false) String perPageNo,ArticleDTO arDto){
		BlogManagerDetailsModel bmd = (BlogManagerDetailsModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int bmId = IDEncryptor.getInstance().decryptWithoutException(bmd.getId());
		BlogManager bm = blogManagerService.getBMById(bmId);
		
		Map<String, Object> retMap = new HashMap<>();
		// 【列表查询】page参数组装
        Map<String, Object> paramMap = CommonUtil.pageParam(pageNo, perPageNo);
        paramMap.put("blogId", bm.getBlogId());
        paramMap.put("sDate", DateUtil.parseDate(arDto.getStart(), "yyyy-MM-dd HH:mm:ss"));
        paramMap.put("eDate", DateUtil.parseDate(arDto.getEnd(), "yyyy-MM-dd HH:mm:ss"));
        paramMap.put("title", arDto.getTitle());
        paramMap.put("status", arDto.getStatus());
        paramMap.put("share", String.valueOf(ShareStatus.SHARED.getStatus()));
        paramMap.put("otherStatus", String.valueOf(ArticleOtherStatus.PENDING_SHARING.getType()));
        if(bm.getIsManager() == BlogManagerType.NON_ADMIN.getType()) {
        	paramMap.put("managerId", String.valueOf(bm.getId()));
        }
		// 获取数据总数
        int total = 0;
        int count = articleService.queryArticleCountByParamMap(paramMap);
        List<ArticleVO> arList = null;
        ArticleVO topAR = null;
        if (count > 0) {
        	// 置顶文章
        	// topAR = articleService.queryTopAR(bm.getBlogId());
        	// 文章列表
        	arList = articleService.queryForCustomerByBlogId(paramMap);
        	total = arList.size();
		} else {
			retMap.put(Config.RET, Config.RET_ERROR);
			retMap.put(Config.ERR_MSG, "暂无数据");
			return retMap;
		}
        // 统计模块
        List<Map<String, Object>> statusCount = articleService.getCountGroupByTimeAndTitle(paramMap);
        retMap = statisticsMethod(retMap,statusCount);
        // 组装文章列表显示数据
        arList = dsplayDataAssem(arList,topAR,count);
        Map<String, Object> data = CommonUtil.commonListData(count, arList);
        data.put("actualCount", total);
        retMap.put("data", data);
        retMap.put(Config.RET, Config.RET_OK);
		return retMap;
	}
	
	@GetMapping("/articleDetail")
	public String articleDetail(HttpServletRequest request,HttpServletResponse response,@RequestParam String id) {

		BlogManagerDetailsModel bmd = (BlogManagerDetailsModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int bmId = IDEncryptor.getInstance().decryptWithoutException(bmd.getId());
		
		BlogManager bm = blogManagerService.getBMById(bmId);
		request.setAttribute("blogManager", bm);

		//获取登陆用户的公众号信息  展示top页面以及详情页个人信息
		Blog blog=blogManagerService.getBlogById(bm.getBlogId());
		request.setAttribute("blog", blog);
		
		List<BlogMenuTree> menuTree = blogPermitService.getMenu(blog.getId(),bmId);
		request.setAttribute("menuTree",menuTree);

		int arid = IDEncryptor.getInstance().decryptWithoutException(id);
		Article article = articleService.getArticleById(arid);
		request.setAttribute("article", article);
		if(article!=null){
			ArticleType articleType=blogManagerService.getArticleTypeByArticlrId(article.getTypeId());
			request.setAttribute("articleType", articleType);
			BlogLabel blogLabel=articleService.getBlogLabelById(article.getLabelId());
            request.setAttribute("blogLabel", blogLabel);
		}
		return "../blogPlatform/shareArticleDetail";
	}
	
	/**
	 * 	取消置顶
	 * @param id
	 * @return
	 */
	@PostMapping(value = "/offTop")
	@ResponseBody
	public Map<String, Object> offTop(@RequestParam(value = "id") String id){
		Map<String, Object> retMap = new HashMap<String, Object>();
		// 验参
		int arId = IDEncryptor.getInstance().decryptWithoutException(id);
		if(arId == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"请选择文章");
            return retMap;
		}
		// 修改置顶状态（id,当前文章置顶状态，要变更状态）
		int upResult = articleService.updateIsTopStatus(arId,Article.ArticleOntop.top.getId(),Article.ArticleOntop.no.getId(),DateUtil.fomatToYYYY_MM_dd_HH_mm_ss(new Date()));
		if(upResult == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"文章取消置顶失败");
            return retMap;
		}
		
		retMap.put(Config.RET, Config.RET_OK);
        retMap.put(Config.MESSAGE,"文章取消置顶成功");
		return retMap;
	}
	
	/**
	 * 	置顶
	 * @param id
	 * @return
	 */
	@PostMapping(value = "/top")
	@ResponseBody
	public Map<String, Object> top(@RequestParam(value = "id") String id){
		Map<String, Object> retMap = new HashMap<String, Object>();
		// 验参
		int arId = IDEncryptor.getInstance().decryptWithoutException(id);
		if(arId == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"请选择文章");
            return retMap;
		}
		
		BlogManagerDetailsModel bmd = (BlogManagerDetailsModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int bmId = IDEncryptor.getInstance().decryptWithoutException(bmd.getId());
		BlogManager bm = blogManagerService.getBMById(bmId);
		
		// 1. 先取消所有置顶文章
		articleService.updateIsTopByBlogId(bm.getBlogId(),Article.ArticleOntop.top.getId(),Article.ArticleOntop.no.getId());
		// 修改置顶状态（id,当前文章置顶状态，要变更状态）
		int upResult = articleService.updateIsTopStatus(arId,Article.ArticleOntop.no.getId(),Article.ArticleOntop.top.getId(),DateUtil.fomatToYYYY_MM_dd_HH_mm_ss(new Date()));
		if(upResult == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"文章置顶失败");
            return retMap;
		}
		
		retMap.put(Config.RET, Config.RET_OK);
        retMap.put(Config.MESSAGE,"文章置顶成功");
		return retMap;
	}
	
	/**
	 * 	发布
	 * @param id
	 * @return
	 */
	@PostMapping(value = "/send")
	@ResponseBody
	public Map<String, Object> send(@RequestParam(value = "id") String id){
		Map<String, Object> retMap = new HashMap<String, Object>();
		// 验参
		int arId = IDEncryptor.getInstance().decryptWithoutException(id);
		if(arId == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"请选择文章");
            return retMap;
		}
		// 修改文章状态（id,当前文章状态，要变更状态）
		int upResult = articleService.updateARStatusById(arId,Article.ArticleStatus.hasBeenReleased.getId(),Article.ArticleOntop.no.getId(),DateUtil.fomatToYYYY_MM_dd_HH_mm_ss(new Date()));
		if(upResult == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"文章发布失败");
            return retMap;
		}
		
		retMap.put(Config.RET, Config.RET_OK);
        retMap.put(Config.MESSAGE,"文章发布成功");
		return retMap;
	}
	
	/**
	 * 	下线
	 * @param id
	 * @return
	 */
	@PostMapping(value = "/offline")
	@ResponseBody
	public Map<String, Object> offline(@RequestParam(value = "id") String id){
		BlogManagerDetailsModel bmd = (BlogManagerDetailsModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int blogId = IDEncryptor.getInstance().decryptWithoutException(bmd.getBlogId());
		Blog blog=blogManagerService.getBlogById(blogId);
		
		Map<String, Object> retMap = new HashMap<String, Object>();
		// 验参
		int arId = IDEncryptor.getInstance().decryptWithoutException(id);
		if(arId == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"请选择文章");
            return retMap;
		}
		
		Article article = articleService.getArticleById(arId);
		if(article == null) {
			retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"文章不存在");
            return retMap;
		}
		
		String[] otherStatus = article.getOtherStatus().split(",");
		Set<String> statusSet = new HashSet<>(Arrays.asList(otherStatus));
		statusSet.remove(String.valueOf(ArticleOtherStatus.PENDING_SHARING.getType()));
		if(statusSet.size() == 0) {
			statusSet.add("0");
		}
		article.setOtherStatus(String.join(",", statusSet));
		OperationResult op = shareUtil.shareForTiming(article, blog);
     	if(!op.isSuccess()) {
     		retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"文章移除失败");
            return retMap;
     	}

		// 当前分享状态
		int currentShare = ShareStatus.SHARED.getStatus();
		// 期望的分享状态
		int expectShare = ShareStatus.NOT_SHARED.getStatus();
		int upResult = shareService.updateShareStatusById(String.valueOf(arId), blogId, currentShare,expectShare, DateUtil.fomatToYYYY_MM_dd_HH_mm_ss(new Date()),article.getOtherStatus());
		if(upResult == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"文章移除失败");
            return retMap;
		}
		
		shareService.deleteShareByArId(arId);
		
		
		
		retMap.put(Config.RET, Config.RET_OK);
        retMap.put(Config.MESSAGE,"文章移除成功");
		return retMap;
	}
	
	/**
	 * 	批量下线
	 * @param id
	 * @return
	 */
	@PostMapping(value = "/offlineBtach")
	@ResponseBody
	public Map<String, Object> offlineBtach(@RequestParam(value = "ids") String[] ids){
		
		BlogManagerDetailsModel bmd = (BlogManagerDetailsModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int blogId = IDEncryptor.getInstance().decryptWithoutException(bmd.getBlogId());
		Blog blog=blogManagerService.getBlogById(blogId);
		Map<String, Object> retMap = new HashMap<String, Object>();
		
		String[] str = new String[ids.length];
		for (int i = 0; i < ids.length; i++) {
			str[i] = String.valueOf(IDEncryptor.getInstance().decryptWithoutException(ids[i]));
		}
		// 验参
		if(str == null || str.length == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"请选择文章");
            return retMap;
		}
		String array = String.join(",", str);
		
		
		List<Article> articles = articleService.getArListByIds(array,blogId);
		List<ShareForRequest> lists = null;
		if(articles != null && articles.size() > 0) {
			lists = new ArrayList<ShareForRequest>();
			for (Article ar : articles) {
				ShareForRequest shareReq = new ShareForRequest();
		     	shareReq.setFkId(IDEncryptor.getInstance().encryptWithoutException(ar.getId()));
		     	shareReq.setTitle(ar.getTitle());
		     	shareReq.setPic(ar.getThumb());
		     	shareReq.setShareType(0);
		     	shareReq.setShareTitle(ar.getTitle());
		     	shareReq.setShareContent(ar.getShareContent() == null ? "" : ar.getShareContent());
		     	shareReq.setCategoryId(IDEncryptor.getInstance().encryptWithoutException(ar.getLabelId()));
		     	shareReq.setSeq(0);
		     	shareReq.setStatus(1);
		     	shareReq.setTitleCount(ar.getWordCount());
		     	shareReq.setPicCount(ar.getImgCount());
		     	shareReq.setAudioUrl(ar.getAudioPath() == null ? "" : ar.getAudioPath());
		     	shareReq.setVedioUrl("");
		     	shareReq.setCreateTime(ar.getReleaseTime());
		     	shareReq.setUpdateTime(ar.getUpdateTime());
		     	
		     	String[] otherStatus = ar.getOtherStatus().split(",");
				Set<String> statusSet = new HashSet<>(Arrays.asList(otherStatus));
				statusSet.remove(String.valueOf(ArticleOtherStatus.PENDING_SHARING.getType()));
		     	shareReq.setLabel(String.join(",", statusSet));
		     	
		     	lists.add(shareReq);
			}
		}
		
     	String json = JSON.toJSONString(lists);
     	HtmlClient client = new HtmlClient();
     	OperationResult resp = client.postHtmlEx(blog.getPushUrl(), json, "utf-8");
     	if(!resp.isSuccess()) {
     		retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"文章移除失败");
    		return retMap;
     	}
     	
		// 当前分享状态
		int currentShare = ShareStatus.SHARED.getStatus();
		// 期望的分享状态
		int expectShare = ShareStatus.NOT_SHARED.getStatus();
		int upResult = shareService.updateBatchShareStatusById(array,blogId,currentShare,expectShare,DateUtil.fomatToYYYY_MM_dd_HH_mm_ss(new Date()),"0");
		if(upResult == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"文章移除失败");
            return retMap;
		}
		// 批量删除分享赚文章关联数据
		shareService.deleteBatchShareByArId(array);
		
		retMap.put(Config.RET, Config.RET_OK);
        retMap.put(Config.MESSAGE,"文章移除成功");
		return retMap;
	}
	
	
	/**
	 * 	批量插入分享赚
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/batchShare")
	@ResponseBody
	public Map<String, Object> batchShare(@RequestParam(value = "blogId") String blogId){
		Map<String, Object> retMap = new HashMap<String, Object>();
		List<Article> arlists = articleService.getBlogArticleByShare(Integer.valueOf(blogId), Article.ArticleStatus.hasBeenReleased.getId(),ShareStatus.NOT_SHARED.getStatus());
		List<ShareForRequest> lists = new ArrayList<ShareForRequest>();
		for (Article article : arlists) {
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
	     	shareReq.setLabel(article.getOtherStatus());
	     	lists.add(shareReq);
		}
		
		int size = lists.size();
		int startNum = 0;
		int endNum = 100;
		int count = (int) Math.ceil(size /100);
		for (int i = 0; i <= count; i++) {
			String json = null;
			if(endNum > (count * 100)) {
				json = JSON.toJSONString(lists.subList(startNum, size));
			} else {
				json = JSON.toJSONString(lists.subList(startNum, endNum));
			}
	     	HtmlClient client = new HtmlClient();
	     	OperationResult result = client.postHtmlEx(Config.SHARE_ARTICLE_URL, json, "utf-8");
	     	if(!result.isSuccess()) {
	     		retMap.put(Config.RET, Config.RET_ERROR);
	            retMap.put(Config.ERR_MSG,"批量推送失败");
	            return retMap;
	     	}
	     	startNum += 100;
	     	endNum += 100;
		}
		
		retMap.put(Config.RET, Config.RET_OK);
        retMap.put(Config.MESSAGE,"批量添加分享赚成功");
		return retMap;
	}
	
	/**
	 * 	删除
	 * @param id
	 * @return
	 */
	@PostMapping(value = "/del")
	@ResponseBody
	public Map<String, Object> del(@RequestParam(value = "id") String id){
		Map<String, Object> retMap = new HashMap<String, Object>();
		// 验参
		int arId = IDEncryptor.getInstance().decryptWithoutException(id);
		if(arId == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"请选择文章");
            return retMap;
		}
		// 删除为逻辑删除 当文章状态为（已下线，草稿）方可删除
		int[] delStatus = {Article.ArticleStatus.Offline.getId(),Article.ArticleStatus.draft.getId()};
		// 修改文章状态（id,当前文章状态，要变更状态）
		int upResult = articleService.delARById(arId,delStatus,Article.ArticleStatus.DEL.getId(),DateUtil.fomatToYYYY_MM_dd_HH_mm_ss(new Date()));
		if(upResult == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"文章删除失败");
            return retMap;
		}
		
		retMap.put(Config.RET, Config.RET_OK);
        retMap.put(Config.MESSAGE,"文章删除成功");
		return retMap;
	}
	
	/**
	 * 	文章列表显示数据组装
	 * @param arList
	 * @return
	 */
	private List<ArticleVO> dsplayDataAssem(List<ArticleVO> arList,ArticleVO topAR,int count) {
		if (null != arList && arList.size() > 0) {
        	for (ArticleVO arVO : arList) {
        		String blogIdStr = IDEncryptor.getInstance().encryptWithoutException(arVO.getId());
        		arVO.setArId(blogIdStr);
        		// 发布时间
        		arVO.setTime(DateUtil.formatDate(arVO.getReleaseTime(), "yyyy-MM-dd HH:mm:ss"));
                // 状态
        		arVO.setStatusDesc(Article.ArticleStatus.getArticleStatus(arVO.getStatus()).getDesc());
        		// 分享状态
        		arVO.setShareDesc(ShareStatus.getShareStatus(arVO.getShare()).getDesc());
                // 置顶
        		arVO.setIsTopDesc(Article.ArticleOntop.getArticleOntop(arVO.getIsTop()).getDesc());
        		if(topAR != null) {
        			if(topAR.getId() == arVO.getId()) {
        				arList.remove(arVO);
        				topAR = arVO;
        			} else {
        				String topId = IDEncryptor.getInstance().encryptWithoutException(topAR.getId());
        				topAR.setArId(topId);
                		// 发布时间
        				topAR.setTime(DateUtil.formatDate(topAR.getReleaseTime(), "yyyy-MM-dd HH:mm:ss"));
                        // 状态
        				topAR.setStatusDesc(Article.ArticleStatus.getArticleStatus(topAR.getStatus()).getDesc());
        				// 分享状态
        				arVO.setShareDesc(ShareStatus.getShareStatus(arVO.getShare()).getDesc());
                        // 置顶
        				topAR.setIsTopDesc(Article.ArticleOntop.getArticleOntop(topAR.getIsTop()).getDesc());
        			}
        		}
			}
        	if(topAR != null) {
        		// 分享状态
        		topAR.setShareDesc(ShareStatus.getShareStatus(topAR.getShare()).getDesc());
        		arList.add(0, topAR);
        	}
        	return arList;
      } else {
    	  if(count > 0) {
    		  arList.add(0, topAR);
    		  return arList;
    	  }
      }
		return null;
	}

	/**
	 * 	文章列表页--统计区域数据组装
	 * @param retMap
	 * @param statusCount
	 * @return
	 */
	private Map<String, Object> statisticsMethod(Map<String, Object> retMap, List<Map<String, Object>> statusCount) {
		if(statusCount != null && statusCount.size() > 0) {
        	for (Map<String, Object> map : statusCount) {
            	// 已发布
    			if(map.get("status").equals(Article.ArticleStatus.hasBeenReleased.getId())) {
    				retMap.put("releaseCount",map.get("count"));
    			} else if(map.get("status").equals(Article.ArticleStatus.toBeReleased.getId())) {
    				// 待发布
    				retMap.put("toBeReleasedCount",map.get("count"));
    			}  else if(map.get("status").equals(Article.ArticleStatus.draft.getId())) {
    				// 草稿
    				retMap.put("draftCount",map.get("count"));
    			} else if(map.get("status").equals(Article.ArticleStatus.Offline.getId())) {
    				// 已下线
    				retMap.put("OfflineCount",map.get("count"));
    			}
    		}
        } else {
        	retMap.put("releaseCount",0);
        	retMap.put("toBeReleasedCount",0);
        	retMap.put("draftCount",0);
        	retMap.put("OfflineCount",0);
        }
		return retMap;
	}
	
}
