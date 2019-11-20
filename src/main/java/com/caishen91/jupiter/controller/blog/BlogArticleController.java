package com.caishen91.jupiter.controller.blog;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.caishen91.jupiter.authorize.model.BlogManagerDetailsModel;
import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.dto.ArticleDTO;
import com.caishen91.jupiter.enums.ArticleReleaseType;
import com.caishen91.jupiter.enums.CommonStatus;
import com.caishen91.jupiter.enums.ShareStatus;
import com.caishen91.jupiter.model.Article;
import com.caishen91.jupiter.model.ArticleKeyWords;
import com.caishen91.jupiter.model.ArticleType;
import com.caishen91.jupiter.model.Blog;
import com.caishen91.jupiter.model.BlogLabel;
import com.caishen91.jupiter.model.BlogManager;
import com.caishen91.jupiter.model.BlogMenuTree;
import com.caishen91.jupiter.service.IArticleService;
import com.caishen91.jupiter.service.IArticleTypeService;
import com.caishen91.jupiter.service.IBlogLableService;
import com.caishen91.jupiter.service.IBlogManagerService;
import com.caishen91.jupiter.service.IBlogPermitService;
import com.caishen91.jupiter.util.DateUtil;
import com.caishen91.jupiter.util.IDEncryptor;
import com.caishen91.jupiter.util.OperationResult;
import com.caishen91.jupiter.util.ShareUtil;
import com.caishen91.jupiter.util.StringUtil;
import com.caishen91.jupiter.vo.ARDetailVO;
import com.caishen91.jupiter.vo.BlogDetailVO;

/**
 * 	商户平台 文章管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/blog/article")
public class BlogArticleController {
	
	@Autowired
	private IBlogManagerService blogManagerService;
	
	@Autowired
	private IBlogLableService labelService;
	
	@Autowired
	private IArticleTypeService arTypeService;
	
	@Autowired
	private IArticleService articleService;
	
	@Autowired
    private HttpServletRequest request;
	
	@Autowired
	private IBlogPermitService blogPermitService;
	
	@Autowired
	private ShareUtil shareutil;
	
	
	/**
	 * 	文章编辑页面
	 * @return
	 */
	@GetMapping("toArticleEditor")
	public String toArticlePublish(HttpServletRequest req,HttpServletResponse resp) {
		BlogManagerDetailsModel bmd = (BlogManagerDetailsModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int bmId = IDEncryptor.getInstance().decryptWithoutException(bmd.getId());
		int blogId = IDEncryptor.getInstance().decryptWithoutException(bmd.getBlogId());
		
		BlogManager bm = blogManagerService.getBMById(bmId);
        req.setAttribute("blogManager", bm);
        //获取登陆用户的公众号信息  展示top页面个人信息
        Blog blog=blogManagerService.getBlogById(blogId);
        req.setAttribute("blog", blog);
        
        List<BlogMenuTree> menuTree = blogPermitService.getMenu(blog.getId(),bmId);
		request.setAttribute("menuTree",menuTree);
        
        // 获取文章类型
        List<ArticleType> typeList = arTypeService.getListByStatus(CommonStatus.available.getStatus());
        req.setAttribute("typeList", typeList);
        
        // 获取公众号标签
        List<BlogLabel> labels = labelService.queryLabelListByBlogId(blogId,CommonStatus.available.getStatus());
        req.setAttribute("labels", labels);
        
        // 文章来源
        List<BlogDetailVO> blogs = blogManagerService.getNotEmptyAll();
        req.setAttribute("blogs", blogs);
        
        // 文章标签
        List<ArticleKeyWords> keyWords = articleService.getKeyWordsByBlogId(blogId);
        req.setAttribute("keyWords", keyWords);
        
        return "../blogPlatform/articleEditor";
	}
	
	/**
	 * 	跳转至文章修改页面
	 * @return
	 */
	@GetMapping("/toEdit")
	public String toEdit(HttpServletRequest req,HttpServletResponse resp,@RequestParam("id") String id) {
		
		BlogManagerDetailsModel bmd = (BlogManagerDetailsModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int bmId = IDEncryptor.getInstance().decryptWithoutException(bmd.getId());
		
		BlogManager bm = blogManagerService.getBMById(bmId);
        req.setAttribute("blogManager", bm);
        //获取登陆用户的公众号信息  展示top页面个人信息
        Blog blog=blogManagerService.getBlogById(bm.getBlogId());
        req.setAttribute("blog", blog);
        
        List<BlogMenuTree> menuTree = blogPermitService.getMenu(blog.getId(),bmId);
		request.setAttribute("menuTree",menuTree);
        
        // 获取文章类型
        List<ArticleType> typeList = arTypeService.getListByStatus(CommonStatus.available.getStatus());
        req.setAttribute("typeList", typeList);
        
        // 获取公众号标签
        List<BlogLabel> labels = labelService.queryLabelListByBlogId(bm.getBlogId(),CommonStatus.available.getStatus());
        req.setAttribute("labels", labels);
        
        List<BlogDetailVO> blogs = blogManagerService.getNotEmptyAll();
        req.setAttribute("blogs", blogs);
        
        req.setAttribute("arId", id);
        
        // 文章标签
        List<ArticleKeyWords> keyWords = articleService.getKeyWordsByBlogId(blog.getId());
        req.setAttribute("keyWords", keyWords);
        
        return "../blogPlatform/articleEdit";
	}
	
	/**
	 * 	获取文章详情（修改页面）
	 * @param req
	 * @param resp
	 * @return
	 */
	@GetMapping(value = "/getARDetail")
	@ResponseBody
	public Map<String, Object> edit(@RequestParam(value = "id") String id) {
		BlogManagerDetailsModel bmd = (BlogManagerDetailsModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int bmId = IDEncryptor.getInstance().decryptWithoutException(bmd.getId());
		
		BlogManager bm = blogManagerService.getBMById(bmId);
        request.setAttribute("blogManager", bm);
        //获取登陆用户的公众号信息  展示top页面个人信息
        Blog blog = blogManagerService.getBlogById(bm.getBlogId());
        request.setAttribute("blog", blog);
        
        Map<String, Object> retMap = new HashMap<String, Object>();
        // 验参
     	int arId = IDEncryptor.getInstance().decryptWithoutException(id);
     	if(arId == 0) {
     		retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"请选择文章");
            return retMap;
     	}
        
     	ARDetailVO arVO = articleService.getARDetailByIdAndBlogId(arId,blog.getId());
     	if(arVO == null) {
     		retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"文章不存在");
            return retMap;
     	}
        
     	retMap.put(Config.RET, Config.RET_OK);
     	retMap.put(Config.RET_DATA,arVO);
		return retMap;
	}
	
	/**
	 * 	【分享赚】获取文章详情接口
	 * @param req
	 * @param resp
	 * @return
	 */
	@GetMapping(value = "/getArticle")
	@ResponseBody
	public Map<String, Object> getArticle(@RequestParam(value = "id") String id) {
        Map<String, Object> retMap = new HashMap<String, Object>();
        // 验参
     	int arId = IDEncryptor.getInstance().decryptWithoutException(id);
     	if(arId == 0) {
     		retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"获取文章失败");
            return retMap;
     	}
     	Article article = articleService.getArticleById(arId);
     	if(article == null) {
     		retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"文章不存在");
            return retMap;
     	}
        
     	retMap.put(Config.RET, Config.RET_OK);
     	retMap.put(Config.RET_DATA,article.getContent());
		return retMap;
	}
	
	/**
	 * 	【新建文章】提交并发布文章
	 * @param
	 * @param arDto
	 * @return
	 */
	@PostMapping("/subRelease")
	@ResponseBody
	public Map<String, Object> submitAR(ArticleDTO arDto){
		Map<String, Object> retMap = new HashMap<String, Object>();
		OperationResult paramOR = parseInterfaceInfo(arDto);
		if (!paramOR.isSuccess()) {
			retMap.put(Config.RET, Config.RET_ERROR);
		    retMap.put(Config.ERR_MSG,paramOR.getMessage());
		    return retMap;
		}
		
		if(Integer.parseInt(arDto.getReleaseType()) == ArticleReleaseType.TIMING.getCode()) {
			if(!StringUtil.isEmpty(arDto.getTime())) {
				Date send = DateUtil.parseDate(arDto.getTime(), "yyyy-MM-dd HH:mm");
				if(send.before(new Date())) {
					retMap.put(Config.RET, Config.RET_ERROR);
				    retMap.put(Config.ERR_MSG,"定时发布不得早于当前时间");
				    return retMap;
				}
			}
		}
		
		BlogManagerDetailsModel bmd = (BlogManagerDetailsModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int bmId = IDEncryptor.getInstance().decryptWithoutException(bmd.getId());
		
		BlogManager bm = blogManagerService.getBMById(bmId);
		
        //获取登陆用户的公众号信息  展示top页面个人信息
        Blog blog=blogManagerService.getBlogById(bm.getBlogId());
		
		int arCount = articleService.getARCountByTitleAndBlogId(arDto.getTitle(),blog.getId());
		if(arCount > 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
		    retMap.put(Config.ERR_MSG,"标题已存在");
		    return retMap;
		}
		
        if(blog.getName() == null) {
        	retMap.put(Config.RET, Config.RET_ERROR);
		    retMap.put(Config.ERR_MSG,"您还未设置公众号名称");
		    return retMap;
        }
		
		// 保存文章
        arDto.setBlogId(blog.getId());
        arDto.setManagerId(bm.getId());
        Article result = articleService.saveArticle(arDto);
		if (result == null) {
			retMap.put(Config.RET, Config.RET_ERROR);
		    retMap.put(Config.ERR_MSG,"文章发布失败");
		    return retMap;
		}
		arDto.setId(String.valueOf(result.getId()));
		arDto.setStatus(String.valueOf(result.getStatus()));
		// 文章推送
		if(StringUtil.isNotEmpty(blog.getPushUrl())) {
			if(Integer.parseInt(arDto.getReleaseType()) == ArticleReleaseType.RIGHT_NOW.getCode()) {
				OperationResult op = shareutil.shareOpera(arDto,blog);
				if(!op.isSuccess()) {
					retMap.put(Config.RET, Config.RET_EXCEPTION);
				    retMap.put(Config.MESSAGE,"加入分享赚失败");
				    return retMap;
				}
			}
		}
		retMap.put(Config.RET, Config.RET_OK);
	    retMap.put(Config.MESSAGE,"文章发布成功");
		return retMap;
	}
	
	/**
	 * 	【修改文章】提交并发布文章
	 * @param
	 * @param arDto
	 * @return
	 */
	@PostMapping("/subEdit")
	@ResponseBody
	public Map<String, Object> subEdit(ArticleDTO arDto){
		Map<String, Object> retMap = new HashMap<String, Object>();
		OperationResult paramOR = parseInterfaceInfo(arDto);
		if (!paramOR.isSuccess()) {
			retMap.put(Config.RET, Config.RET_ERROR);
		    retMap.put(Config.ERR_MSG,paramOR.getMessage());
		    return retMap;
		}
		
		if(Integer.parseInt(arDto.getReleaseType()) == ArticleReleaseType.TIMING.getCode()) {
			if(!StringUtil.isEmpty(arDto.getTime())) {
				Date send = DateUtil.parseDate(arDto.getTime(), "yyyy-MM-dd HH:mm");
				if(send.before(new Date())) {
					retMap.put(Config.RET, Config.RET_ERROR);
				    retMap.put(Config.ERR_MSG,"定时发布不得早于当前时间");
				    return retMap;
				}
			}
		}
		
		BlogManagerDetailsModel bmd = (BlogManagerDetailsModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int blogId = IDEncryptor.getInstance().decryptWithoutException(bmd.getBlogId());
		//获取登陆用户的公众号信息  展示top页面个人信息
        Blog blog=blogManagerService.getBlogById(blogId);
		
		int arId = IDEncryptor.getInstance().decryptWithoutException(arDto.getId());
		int arCount = articleService.getARCountByTitle(arDto.getTitle(),arId,blogId);
		if(arCount > 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
		    retMap.put(Config.ERR_MSG,"标题已存在");
		    return retMap;
		}
		
		if(arId == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
		    retMap.put(Config.ERR_MSG,"您要修改的文章不存在");
		    return retMap;
		}
		arDto.setId(String.valueOf(arId));
		
		if(Integer.parseInt(arDto.getReleaseType()) == ArticleReleaseType.TIMING.getCode()) {
			arDto.setStatus(String.valueOf(Article.ArticleStatus.toBeReleased.getId()));
		} else if(Integer.parseInt(arDto.getReleaseType()) == ArticleReleaseType.RIGHT_NOW.getCode()) {
			arDto.setStatus(String.valueOf(Article.ArticleStatus.hasBeenReleased.getId()));
		}
		// 分享赚推送
		if(StringUtil.isNotEmpty(blog.getPushUrl())) {
			if(Integer.parseInt(arDto.getReleaseType()) == ArticleReleaseType.RIGHT_NOW.getCode()) {
				OperationResult result = shareutil.shareOpera(arDto,blog);
				if(result.isSuccess()) {
					articleService.updateArticle(arDto);
				} else {
					retMap.put(Config.RET, Config.RET_ERROR);
				    retMap.put(Config.ERR_MSG,"加入分享赚失败");
				    return retMap;
				}
			} else {
				int rt = articleService.updateArticle(arDto);
				if (rt == 0) {
					retMap.put(Config.RET, Config.RET_ERROR);
				    retMap.put(Config.ERR_MSG,"文章编辑失败");
				    return retMap;
				}
			}
		} else {
			int result = articleService.updateArticle(arDto);
			if (result == 0) {
				retMap.put(Config.RET, Config.RET_ERROR);
			    retMap.put(Config.ERR_MSG,"文章编辑失败");
			    return retMap;
			}
		}
		retMap.put(Config.RET, Config.RET_OK);
	    retMap.put(Config.MESSAGE,"文章发布成功");
		return retMap;
	}
	
	/**
	 * 	【新建文章】保存草稿
	 * @param arDto
	 * @return
	 */
	@PostMapping("/save")
	@ResponseBody
	public Map<String, Object> save(ArticleDTO arDto){
		Map<String, Object> retMap = new HashMap<String, Object>();
		if (StringUtil.isEmpty(arDto.getTitle())) {
			retMap.put(Config.RET, Config.RET_ERROR);
		    retMap.put(Config.ERR_MSG,"请填写文章标题");
		    return retMap;
		}
		
		if(!arDto.getReleaseType().equals(String.valueOf(ArticleReleaseType.RIGHT_NOW.getCode())) && !StringUtil.isEmpty(arDto.getTime())) {
			Date send = DateUtil.parseDate(arDto.getTime(), "yyyy-MM-dd HH:mm");
			if(send.before(new Date())) {
				retMap.put(Config.RET, Config.RET_ERROR);
			    retMap.put(Config.ERR_MSG,"定时发布不得早于当前时间");
			    return retMap;
			}
		}
		
		BlogManagerDetailsModel bmd = (BlogManagerDetailsModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int bmId = IDEncryptor.getInstance().decryptWithoutException(bmd.getId());
		BlogManager bm = blogManagerService.getBMById(bmId);

        //获取登陆用户的公众号信息  展示top页面个人信息
        Blog blog=blogManagerService.getBlogById(bm.getBlogId());
		
		int arCount = articleService.getARCountByTitleAndBlogId(arDto.getTitle(),blog.getId());
		if(arCount > 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
		    retMap.put(Config.ERR_MSG,"标题已存在");
		    return retMap;
		}
		
		// 保存草稿
        arDto.setBlogId(blog.getId());
        arDto.setManagerId(bm.getId());
        arDto.setImgCount(arDto.getImgCount() == null ? 0 : arDto.getImgCount());
        arDto.setWordCount(arDto.getWordCount() == null ? 0 : arDto.getWordCount());
        arDto.setTime(arDto.getReleaseType().equals(String.valueOf(ArticleReleaseType.RIGHT_NOW.getCode())) ? null : arDto.getTime());
		int result = articleService.saveDraft(arDto);
		if (result == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
		    retMap.put(Config.ERR_MSG,"保存失败");
		    return retMap;
		}
		retMap.put(Config.RET, Config.RET_OK);
	    retMap.put(Config.MESSAGE,"保存成功");
	    return retMap;
	}
	
	/**
	 * 	【修改文章】保存草稿
	 * @param arDto
	 * @return
	 */
	@PostMapping("/secondSub")
	@ResponseBody
	public Map<String, Object> secondSub(ArticleDTO arDto){
		Map<String, Object> retMap = new HashMap<String, Object>();
		
		if (StringUtil.isEmpty(arDto.getTitle())) {
			retMap.put(Config.RET, Config.RET_ERROR);
		    retMap.put(Config.ERR_MSG,"请填写文章标题");
		    return retMap;
		}
		
		if(!arDto.getReleaseType().equals(String.valueOf(ArticleReleaseType.RIGHT_NOW.getCode())) && !StringUtil.isEmpty(arDto.getTime())) {
			Date send = DateUtil.parseDate(arDto.getTime(), "yyyy-MM-dd HH:mm");
			if(send.before(new Date())) {
				retMap.put(Config.RET, Config.RET_ERROR);
			    retMap.put(Config.ERR_MSG,"定时发布不得早于当前时间");
			    return retMap;
			}
		}
		
		BlogManagerDetailsModel bmd = (BlogManagerDetailsModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int blogId = IDEncryptor.getInstance().decryptWithoutException(bmd.getBlogId());
		
		int arId = IDEncryptor.getInstance().decryptWithoutException(arDto.getId());
		int arCount = articleService.getARCountByTitle(arDto.getTitle(),arId,blogId);
		if(arCount > 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
		    retMap.put(Config.ERR_MSG,"标题已存在");
		    return retMap;
		}
		
		if(arId == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
		    retMap.put(Config.ERR_MSG,"您要修改的文章不存在");
		    return retMap;
		}
		arDto.setId(String.valueOf(arId));
		arDto.setTime(arDto.getReleaseType().equals(String.valueOf(ArticleReleaseType.RIGHT_NOW.getCode())) ? null : arDto.getTime());
		int result = articleService.updateDraft(arDto);
		if (result == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
		    retMap.put(Config.ERR_MSG,"更新保存失败");
		    return retMap;
		}
		retMap.put(Config.RET, Config.RET_OK);
	    retMap.put(Config.MESSAGE,"更新保存成功");
	    return retMap;
	}
	
	/**
	 * 	参数验证
	 * @param
	 * @return
	 * @throws IOException 
	 */
	private OperationResult parseInterfaceInfo(ArticleDTO arDto){
		OperationResult or = new OperationResult();
		if (StringUtil.isEmpty(arDto.getTitle())) {
			or.setStatus(false);
			or.setMessage("文章标题不能为空");
			return or;
		}
		
		ArticleType at = arTypeService.getArticleTypetById(Integer.valueOf(arDto.getType()));
		if(at == null || at.getStatus() == CommonStatus.unAvailable.getStatus()) {
			or.setStatus(false);
			or.setMessage("文章类型已失效");
			return or;
		}
		
		if(!arDto.getLabel().equals("0") && !arDto.getLabel().equals("")) {
			BlogLabel label = labelService.getLabelById(Integer.valueOf(arDto.getLabel()));
			if (label == null || label.getStatus() == CommonStatus.unAvailable.getStatus()) {
				or.setStatus(false);
				or.setMessage("文章标签不存在");
				return or;
			} 
		}
		
		if (StringUtil.isEmpty(arDto.getThumb())) {
			or.setStatus(false);
			or.setMessage("请上传文章首图");
			return or;
		}
		
		// 发布形式 定时 发布时间 != null
		/*
		 * if(arDto.getReleaseType() == null) { or.setStatus(false);
		 * or.setMessage("请选择文章发布类型"); return or; }
		 */
		if (Integer.valueOf(arDto.getReleaseType()) == ArticleReleaseType.TIMING.getCode()) {
			if(arDto.getTime() == null) {
				or.setStatus(false);
				or.setMessage("请选择发布时间");
	            return or;
			}
		}
		or.setStatus(true);
		return or;
	}
}
