package com.caishen91.jupiter.controller.mobile;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.enums.ArticleTypeSeq;
import com.caishen91.jupiter.enums.CommonStatus;
import com.caishen91.jupiter.model.Article;
import com.caishen91.jupiter.model.ArticleCollection;
import com.caishen91.jupiter.model.ArticleLaud;
import com.caishen91.jupiter.model.ArticleRead;
import com.caishen91.jupiter.model.ArticleType;
import com.caishen91.jupiter.model.Blog;
import com.caishen91.jupiter.model.BlogFocus;
import com.caishen91.jupiter.service.IArticleService;
import com.caishen91.jupiter.service.IArticleTypeService;
import com.caishen91.jupiter.service.IBlogManagerService;
import com.caishen91.jupiter.util.CommonUtil;
import com.caishen91.jupiter.util.IDEncryptor;
import com.caishen91.jupiter.vo.ArticleTypeVO;
import com.caishen91.jupiter.vo.MobileARListVO;


@Controller
@RequestMapping("/mobile/article")
public class MobileArticleController {

    @Autowired
    private IArticleService articleService;

    @Autowired
    private IBlogManagerService blogManagerService;
    
    @Autowired 
    private IArticleTypeService typeService;

    /**
     * 	文章列表首页
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/articleList")
    public String articleList(HttpServletRequest request, HttpServletResponse response){
        
        return "../mobile/articleList";
    }
    
    /**
     * 	文章列表
     * @return
     */
    @GetMapping(value = "/allType")
    @ResponseBody
    public Map<String, Object> getAllType(){
    	Map<String, Object> retMap = new HashMap<String, Object>();
    	// 查询有效的文章类型
    	List<ArticleTypeVO> typeList = typeService.getAllTypeByStatus(CommonStatus.available.getStatus());
    	for (ArticleTypeVO articleTypeVO : typeList) {
    		articleTypeVO.setArTypeId(IDEncryptor.getInstance().encryptWithoutException(Integer.valueOf(articleTypeVO.getArTypeId())));
		}
    	retMap.put("data", typeList);
    	return retMap;
    }
    
    @GetMapping(value = "/list")
    @ResponseBody
    public Map<String, Object> ARlist(@RequestParam(defaultValue = "0", required = false) String  pageNo,
									  @RequestParam(defaultValue = "10", required = false) String perPageNo,
									  @RequestParam(value = "id") String typeId){
    	Map<String, Object> retMap = new HashMap<String, Object>();
    	// 验参
    	int type = IDEncryptor.getInstance().decryptWithoutException(typeId);
    	if(type == 0) {
    		retMap.put(Config.RET, Config.RET_ERROR);
    	    retMap.put(Config.ERR_MSG,"请选择要查看的资讯类型");
    	    return retMap;
    	}
    	
    	ArticleType arType = typeService.getArticleTypetById(type);
    	if(arType == null) {
    		retMap.put(Config.RET, Config.RET_ERROR);
    	    retMap.put(Config.ERR_MSG,"请选择要查看的资讯类型");
    	    return retMap;
    	}
    	// 【列表查询】page参数组装
        Map<String, Object> paramMap = CommonUtil.pageParam(pageNo, perPageNo);
        if(arType.getSeq() ==  ArticleTypeSeq.RECOMMEND.getSeq()) {
        	paramMap.put("typeId", null);
        } else {
        	paramMap.put("typeId", String.valueOf(type));
        }
        paramMap.put("status", String.valueOf(Article.ArticleStatus.hasBeenReleased.getId()));
    	// 根据类型查询文章
    	List<MobileARListVO> arList = articleService.getARListByType(paramMap);
    	if(arList == null || arList.size() == 0) {
    		retMap.put(Config.RET, Config.RET_ERROR);
    	    retMap.put(Config.ERR_MSG,"小编正在飞速赶来~");
    	    return retMap;
    	}
    	// 列表数据组装
    	arList = CommonUtil.paramAssem(arList);
    	retMap.put("data", CommonUtil.commonListData(0, arList));
    	retMap.put(Config.RET, Config.RET_OK);
    	return retMap;
    }
    
	/**
     * 	下拉刷新
     * @param firstChildId 当前列表第一篇 文章ID
     * @param typeId 文章类型
     * @return
     * @description 上传文章列表【第一篇文章ID】，取得该文章发布时间，然后查询【大于】该文章的文章列表按正序排列，limit前10条
     */
    @GetMapping(value = "/pullDown")
    @ResponseBody
    public Map<String, Object> pullDown(@RequestParam(value = "arId") String firstChildId,@RequestParam(value = "typeId") String typeId){
		Map<String, Object> retMap = new HashMap<String, Object>();
		// 验参
		int type = IDEncryptor.getInstance().decryptWithoutException(typeId);
		int arId = IDEncryptor.getInstance().decryptWithoutException(firstChildId);
		if(type == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
			retMap.put(Config.ERR_MSG,"请选择要查看的咨询类型");
			return retMap;
		}
		if(arId == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
			retMap.put(Config.ERR_MSG,"请刷新当前页面重试");
			return retMap;
		}
		
		ArticleType arType = typeService.getArticleTypetById(type);
    	if(arType == null) {
    		retMap.put(Config.RET, Config.RET_ERROR);
    	    retMap.put(Config.ERR_MSG,"请选择要查看的资讯类型");
    	    return retMap;
    	}
		Article ar = articleService.getArticleById(arId);
		if(ar == null) {
			retMap.put(Config.RET, Config.RET_ERROR);
			retMap.put(Config.ERR_MSG,"请刷新当前页面重试");
			return retMap;
		}
		// 【列表查询】page参数组装
		Map<String, Object> paramMap = CommonUtil.pageParam("1", "10");
		if(arType.getSeq() == ArticleTypeSeq.RECOMMEND.getSeq()) {
        	paramMap.put("typeId", null);
        } else {
        	paramMap.put("typeId", String.valueOf(type));
        }
		paramMap.put("status", String.valueOf(Article.ArticleStatus.hasBeenReleased.getId()));
		paramMap.put("startTime", ar.getReleaseTime());
		// 下拉刷新查询最近更新文章列表
		List<MobileARListVO> arList = articleService.getPullDownARList(paramMap);
		if(arList == null || arList.size() == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
			retMap.put(Config.ERR_MSG,"已经是最新资讯啦~");
			return retMap;
		}
		// 列表数据组装
    	arList = CommonUtil.paramAssem(arList);
		retMap.put("data", CommonUtil.commonListData(arList.size(), arList));
		retMap.put(Config.RET, Config.RET_OK);
		return retMap;
	}

    
    /**
     * 	上拉刷新
     * @param firstChildId 当前列表第一篇 文章ID
     * @param typeId 文章类型
     * @return
     * @description 上传文章列表当前分页【最后一篇文章ID】，取得该文章发布时间，然后查询【小于】该文章的文章列表按正序排列，limit前10条
     */
    @GetMapping(value = "/pullUp")
    @ResponseBody
    public Map<String, Object> pullUp(@RequestParam(value = "arId") String firstChildId,@RequestParam(value = "typeId") String typeId){
		Map<String, Object> retMap = new HashMap<String, Object>();
		// 验参
		int type = IDEncryptor.getInstance().decryptWithoutException(typeId);
		if(firstChildId.equals("") || firstChildId == null || firstChildId.equals("null")) {
			return null;
		}
		int arId = IDEncryptor.getInstance().decryptWithoutException(firstChildId);
		if(type == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
			retMap.put(Config.ERR_MSG,"请选择要查看的咨询类型");
			return retMap;
		}
		if(arId == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
			retMap.put(Config.ERR_MSG,"请刷新当前页面重试");
			return retMap;
		}
		ArticleType arType = typeService.getArticleTypetById(type);
    	if(arType == null) {
    		retMap.put(Config.RET, Config.RET_ERROR);
    	    retMap.put(Config.ERR_MSG,"请选择要查看的资讯类型");
    	    return retMap;
    	}
		Article ar = articleService.getArticleById(arId);
		if(ar == null) {
			retMap.put(Config.RET, Config.RET_ERROR);
			retMap.put(Config.ERR_MSG,"请刷新当前页面重试");
			return retMap;
		}
		// 【列表查询】page参数组装
		Map<String, Object> paramMap = CommonUtil.pageParam("1", "10");
		if(arType.getSeq() == ArticleTypeSeq.RECOMMEND.getSeq()) {
        	paramMap.put("typeId", null);
        } else {
        	paramMap.put("typeId", String.valueOf(type));
        }
		paramMap.put("status", String.valueOf(Article.ArticleStatus.hasBeenReleased.getId()));
		paramMap.put("endTime", ar.getReleaseTime());
		// 下拉刷新查询最近更新文章列表
		List<MobileARListVO> arList = articleService.getPullUpARList(paramMap);
		if(arList == null || arList.size() == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
			retMap.put(Config.ERR_MSG,"暂无更新");
			return retMap;
		}
		// 列表数据组装
    	arList = CommonUtil.paramAssem(arList);
		retMap.put("data", CommonUtil.commonListData(arList.size(), arList));
		retMap.put(Config.RET, Config.RET_OK);
		return retMap;
	}



    /**
     * @Auther: gk
     * Description:文章详情
     */
    @RequestMapping("/articleDetail")
    public String articleDetail(HttpServletRequest request,HttpServletResponse response,@Param("id") String id,@Param("userId") String userId) {
        //将移动端用户Id存入request
        request.setAttribute("userId",userId);
        int  articleId= IDEncryptor.getInstance().decryptWithoutException(id);
        //获取文章详情
        Article article = articleService.getArticleById(articleId);
        request.setAttribute("article", article);
        //获取文章公众号
        Blog blog=blogManagerService.getBlogById(article.getBlogId());
        request.setAttribute("blog",blog);
        //获取文章详情页推荐文章
        Date date=new Date();
        List<Article> rmdArticles=articleService.getRmdArticleInfo(date,article.getTypeId(),article.getId());
        request.setAttribute("rmdArticles",rmdArticles);
        //获取推荐文章公众号
        Map map=new HashMap();
        for(Article rmdArticle : rmdArticles){
            Blog rmdBlog=blogManagerService.getBlogById(rmdArticle.getBlogId());
            map.put(rmdArticle.getId(),rmdBlog);
        }
        request.setAttribute("map",map);
        //获取当前用户是否已关注该公众号
        int  wapUserId= IDEncryptor.getInstance().decryptWithoutException(userId);
        BlogFocus blogFocus=blogManagerService.getBlogFocusByUserId(blog.getId(),wapUserId);
        request.setAttribute("blogFocus",blogFocus);
        //获取该用户是否已为该文章点赞
        ArticleLaud articleLaud=articleService.getArticleByUserId(article.getId(),wapUserId);
        request.setAttribute("articleLaud",articleLaud);
        //获取用户是否已收藏该文章
        ArticleCollection articleCollection=articleService.getArticleCollection(article.getId(),wapUserId);
        request.setAttribute("articleCollection",articleCollection);
        //点击进入一次详情页即为阅读一次(阅读一次位阅读量表插入数据)
        ArticleRead articleRead=new ArticleRead();
        articleRead.setArticleId(article.getId());
        articleRead.setUserId(wapUserId);
        articleRead.setCreateTime(new Date());
        articleService.addArticleRead(articleRead);

        //同时文章表中阅读量做修改
        article.setReadCount(article.getReadCount()+1);
        article.setUpdateTime(new Date());
        articleService.updateArticleReadCount(article);
        return "../mobile/articleDetail";
    }


    /**
     * @Auther: gk
     * Description:跳转文章收藏
     */
    @RequestMapping("/articleCollection")
    public String articleCollection(HttpServletRequest request,HttpServletResponse response,@Param("userId") String userId) {
        //将移动端用户Id存入request
        request.setAttribute("userId",userId);
        //移动端用户Id
        int  wapUserId= IDEncryptor.getInstance().decryptWithoutException(userId);
        List<ArticleCollection> articleCollections=articleService.getArticleCollectionByWapUserId(wapUserId);
        request.setAttribute("articleCollections",articleCollections);
        Map map=new HashMap();
        Map blogMap=new HashMap();
        for(ArticleCollection articleCollection :articleCollections){
            Article article=articleService.getArticleById(articleCollection.getArticleId());
            Blog blog=blogManagerService.getBlogById(article.getBlogId());
            map.put(articleCollection.getId(),article);
            blogMap.put(articleCollection.getId(),blog);
        }
        request.setAttribute("map",map);
        request.setAttribute("blogMap",blogMap);
        return "../mobile/articleCollection";
    }
    
    /**
     * @Auther: gk
     * Description:文章点赞
     */
    @RequestMapping("/articleLaud")
    @ResponseBody
    public Map<String, Object> articleLaud(HttpServletRequest request, HttpServletResponse response, @Param("articleId") String articleId,@Param("userId")String userId) {

        Map<String, Object> retMap = new HashMap<String, Object>();
        int id= IDEncryptor.getInstance().decryptWithoutException(articleId);
        int wapUserId=IDEncryptor.getInstance().decryptWithoutException(userId);

        //获取该用户是否已为该文章点赞
        ArticleLaud articleLaud=articleService.getArticleByUserIds(id,wapUserId);

        if(articleLaud==null){
            //点赞表插入数据
            ArticleLaud iarticleLaud=new ArticleLaud();
            iarticleLaud.setArticleId(id);
            iarticleLaud.setUserId(wapUserId);
            iarticleLaud.setCreateTime(new Date());
            iarticleLaud.setStatus(CommonStatus.available.getStatus());
            articleService.addArticleLaud(iarticleLaud);



            retMap.put(Config.RET, Config.RET_OK);
        } else{
            articleLaud.setStatus(CommonStatus.available.getStatus());
            articleLaud.setUpdateTime(new Date());
            articleService.updateArticleLuad(articleLaud);
            retMap.put(Config.RET, Config.RET_OK);
        }
        //同时文章表中点赞数做修改
        Article article=articleService.getArticleById(id);
        article.setLaudCount(article.getLaudCount()+1);
        article.setUpdateTime(new Date());
        articleService.updateArticleLuadCount(article);

        return retMap;
    }



    /**
     * @Auther: gk
     * Description:取消文章点赞
     */
    @RequestMapping("/editArticleLaud")
    @ResponseBody
    public Map<String, Object> editArticleLaud(HttpServletRequest request, HttpServletResponse response, @Param("articleId") String articleId,@Param("userId")String userId) {

        Map<String, Object> retMap = new HashMap<String, Object>();
        int id= IDEncryptor.getInstance().decryptWithoutException(articleId);
        int wapUserId=IDEncryptor.getInstance().decryptWithoutException(userId);

        //获取该用户是否已为该文章点赞
        ArticleLaud articleLaud=articleService.getArticleByUserId(id,wapUserId);

        if(articleLaud!=null){

            articleLaud.setStatus(CommonStatus.unAvailable.getStatus());
            articleLaud.setUpdateTime(new Date());
            articleService.updateArticleLuad(articleLaud);

            //同时文章表中点赞数做修改
            Article article=articleService.getArticleById(id);
            if(article.getLaudCount()==0){
                article.setLaudCount(0);
            }else{
                article.setLaudCount(article.getLaudCount()-1);
            }
            article.setUpdateTime(new Date());
            articleService.updateArticleLuadCount(article);

            retMap.put(Config.RET, Config.RET_OK);
        } else{
            retMap.put(Config.RET, Config.RET_ERROR);
        }
        return retMap;
    }



    /**
     * @Auther: gk
     * Description:文章详情页点击收藏文章
     */
    @RequestMapping("/clickArticleCollection")
    @ResponseBody
    public Map<String, Object> clickArticleCollection(HttpServletRequest request, HttpServletResponse response, @Param("articleId") String articleId,@Param("userId")String userId) {

        Map<String, Object> retMap = new HashMap<String, Object>();
        int id= IDEncryptor.getInstance().decryptWithoutException(articleId);
        int wapUserId=IDEncryptor.getInstance().decryptWithoutException(userId);

        //获取该用户是否已为该文章点赞
        ArticleCollection articleCollection=articleService.getArticleCollections(id,wapUserId);

        if(articleCollection==null){
            ArticleCollection iarticleCollection=new ArticleCollection();
            iarticleCollection.setStatus(CommonStatus.available.getStatus());
            iarticleCollection.setUserId(wapUserId);
            iarticleCollection.setCreateTime(new Date());
            iarticleCollection.setArticleId(id);
            articleService.addArticleCollection(iarticleCollection);



            retMap.put(Config.RET, Config.RET_OK);
        } else{

            articleCollection.setStatus(CommonStatus.available.getStatus());
            articleCollection.setUpdateTime(new Date());
            articleService.updateArticleCollection(articleCollection);
            retMap.put(Config.RET, Config.RET_OK);
        }

        //同时文章表中收藏数数做更新
        Article article=articleService.getArticleById(id);
        article.setCollecCount(article.getCollecCount()+1);
        article.setUpdateTime(new Date());
        articleService.updateArticleCollectionCount(article);

        return retMap;
    }


    /**
     * @Auther: gk
     * Description:取消收藏
     */
    @RequestMapping("/editArticleCollection")
    @ResponseBody
    public Map<String, Object> editArticleCollection(HttpServletRequest request, HttpServletResponse response, @Param("articleId") String articleId,@Param("userId")String userId) {

        Map<String, Object> retMap = new HashMap<String, Object>();
        int id= IDEncryptor.getInstance().decryptWithoutException(articleId);
        int wapUserId=IDEncryptor.getInstance().decryptWithoutException(userId);

        //获取该用户是否已为该文章点赞
        ArticleCollection articleCollection=articleService.getArticleCollection(id,wapUserId);

        if(articleCollection!=null){

            articleCollection.setStatus(CommonStatus.unAvailable.getStatus());
            articleCollection.setUpdateTime(new Date());
            articleService.updateArticleCollection(articleCollection);

            //同时文章表中收藏数数做更新
            Article article=articleService.getArticleById(id);
            if(article.getCollecCount()==0){
                article.setCollecCount(0);
            }else{
                article.setCollecCount(article.getCollecCount()-1);
            }
            article.setUpdateTime(new Date());
            articleService.updateArticleCollectionCount(article);

            retMap.put(Config.RET, Config.RET_OK);
        } else{
            retMap.put(Config.RET, Config.RET_ERROR);
        }
        return retMap;
    }




}
