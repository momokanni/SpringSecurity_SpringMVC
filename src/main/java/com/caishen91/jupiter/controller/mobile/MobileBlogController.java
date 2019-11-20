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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.enums.CommonStatus;
import com.caishen91.jupiter.model.Article;
import com.caishen91.jupiter.model.Blog;
import com.caishen91.jupiter.model.BlogFocus;
import com.caishen91.jupiter.model.BlogLabel;
import com.caishen91.jupiter.service.IArticleService;
import com.caishen91.jupiter.service.IBlogLableService;
import com.caishen91.jupiter.service.IBlogManagerService;
import com.caishen91.jupiter.service.IFollowService;
import com.caishen91.jupiter.util.CommonUtil;
import com.caishen91.jupiter.util.IDEncryptor;
import com.caishen91.jupiter.vo.FollowVO;
import com.caishen91.jupiter.vo.MobileARListVO;

@Controller
@RequestMapping("/mobile/blog")
public class MobileBlogController {

    @Autowired
    private IArticleService articleService;

    @Autowired
    private IBlogManagerService blogManagerService;

    @Autowired
    private IBlogLableService blogLableService;
    
    @Autowired
    private IFollowService followService;


    /**
     * @Auther: gk
     * Description:跳转公众号首页
     */
    @RequestMapping("/blogDetail")
    public String blogDetail(HttpServletRequest request, HttpServletResponse response, @Param("id") String id,@Param("userId")String userId){
        //将移动端用户Id存入request
        request.setAttribute("userId",userId);
        int  blogId= IDEncryptor.getInstance().decryptWithoutException(id);
        Blog blog=blogManagerService.getBlogById(blogId);
        request.setAttribute("blog",blog);
       /* //获取该公众号文章
        List<Article> articles=articleService.getArticleByBlogId(blogId,Article.ArticleStatus.hasBeenReleased.getId());
        request.setAttribute("articles",articles);*/
        //获取该公众号标签
        List<BlogLabel> blogLabels=blogLableService.getLabelsByBlogIdByStatus(blog.getId(),BlogLabel.LableStatus.yx.getId());
        request.setAttribute("blogLabels",blogLabels);
        //获取当前用户是否已关注该公众号
        int  wapUserId= IDEncryptor.getInstance().decryptWithoutException(userId);

        BlogFocus blogFocus=blogManagerService.getBlogFocusByUserId(blogId,wapUserId);
        request.setAttribute("blogFocus",blogFocus);
        return "../mobile/blogDetail";
    }


    /**
     * @Auther: gk
     * Description:公众号文章数据组装
     */
    @GetMapping(value = "/articleList")
    @ResponseBody
    public Map<String, Object> articleList(@RequestParam(defaultValue = "0", required = false) String  pageNo,
                                      	   @RequestParam(defaultValue = "10", required = false) String perPageNo,
                                      	   @RequestParam(value = "id") String id,
                                           @RequestParam(value = "labelId") String labelId){
        Map<String, Object> retMap = new HashMap<String, Object>();

        int blogId = IDEncryptor.getInstance().decryptWithoutException(id);
        if(blogId == 0) {
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"获取当前公众号信息失败");
            return retMap;
        }

        // 【列表查询】page参数组装
        Map<String, Object> paramMap = CommonUtil.pageParam(pageNo, perPageNo);
        paramMap.put("blogId", blogId);
        paramMap.put("status", String.valueOf(Article.ArticleStatus.hasBeenReleased.getId()));
        int ilabelId = 0;
        if(labelId != null && !labelId.equals("")){
        	ilabelId = IDEncryptor.getInstance().decryptWithoutException(labelId);
            if(ilabelId == 0) {
                retMap.put(Config.RET, Config.RET_ERROR);
                retMap.put(Config.ERR_MSG,"获取当前标签信息失败");
                return retMap;
            }
        }
        paramMap.put("labelId", labelId == null || labelId.equals("") ? null : String.valueOf(ilabelId));

        List<MobileARListVO> arList = blogManagerService.getBlogArticleListByParam(paramMap);

        if(arList.size() == 0) {
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"还未发布任何资讯哦~");
            return retMap;
        }
        // 列表数据组装
        arList = CommonUtil.paramAssem(arList);
        retMap.put("data", CommonUtil.commonListData(arList.size(), arList));
        retMap.put(Config.RET, Config.RET_OK);
        return retMap;
    }

    @GetMapping(value = "/pullUp")
    @ResponseBody
    public Map<String, Object> pullUp(@RequestParam(value = "arId") String arId,
    								  @RequestParam(value = "blogId") String blogId,
    								  @RequestParam(value = "labelId") String labelId){
        Map<String, Object> retMap = new HashMap<String, Object>();

        int iarId = IDEncryptor.getInstance().decryptWithoutException(arId);
        int iblogId = IDEncryptor.getInstance().decryptWithoutException(blogId);
        int ilabelId = 0;
        if(iblogId == 0) {
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"获取当前公众号信息失败");
            return retMap;
        }
        if(!labelId.equals("") && labelId != null) {
        	ilabelId = IDEncryptor.getInstance().decryptWithoutException(labelId);
            if(ilabelId == 0) {
                retMap.put(Config.RET, Config.RET_ERROR);
                retMap.put(Config.ERR_MSG,"获取当前标签信息失败");
                return retMap;
            }
        }
        if(iarId == 0) {
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"请刷新当前页面重试");
            return retMap;
        }
        Article ar = articleService.getArticleById(iarId);
        if(ar == null) {
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"请刷新当前页面重试");
            return retMap;
        }
        // 【列表查询】page参数组装
        Map<String, Object> paramMap = CommonUtil.pageParam("1", "10");
        paramMap.put("blogId", iblogId);
        paramMap.put("status", String.valueOf(Article.ArticleStatus.hasBeenReleased.getId()));
        paramMap.put("labelId", labelId == null || labelId.equals("") ? null : String.valueOf(ilabelId));
        paramMap.put("endTime", ar.getReleaseTime());
        // 下拉刷新查询最近更新文章列表
        List<MobileARListVO> arList = blogManagerService.getBlogArticleListByParam(paramMap);
        if(arList == null || arList.size() == 0) {
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"暂无更新");
            return retMap;
        }
        arList = CommonUtil.paramAssem(arList);
        // 列表数据组装
        retMap.put("data", CommonUtil.commonListData(arList.size(), arList));
        retMap.put(Config.RET, Config.RET_OK);
        return retMap;
    }

    /**
     * @Auther: gk
     * Description:公众号首页关注
     */
    @RequestMapping("/blogFocus")
    @ResponseBody
    public Map<String, Object> blogFocus(HttpServletRequest request, HttpServletResponse response, @Param("id") String id,@Param("userId")String userId) {

        Map<String, Object> retMap = new HashMap<String, Object>();
        int  blogId= IDEncryptor.getInstance().decryptWithoutException(id);
        int wapUserId=IDEncryptor.getInstance().decryptWithoutException(userId);

        //获取当前用户是否关注过该公众号
        BlogFocus blogFocus=blogManagerService.getBlogFocusByUserIds(blogId,wapUserId);
        if(blogFocus==null){
            //关注表插入数据
            BlogFocus iblogFocus=new BlogFocus();
            iblogFocus.setBlogId(blogId);
            iblogFocus.setUserId(wapUserId);
            iblogFocus.setStatus(CommonStatus.available.getStatus());
            iblogFocus.setCreateTime(new Date());
            blogManagerService.addBlogFocus(iblogFocus);

            //同时公众号表中粉丝做修改
            Blog blog=blogManagerService.getBlogById(blogId);
            blog.setFansCount(blog.getFansCount()+1);
            blog.setUpdateTime(new Date());
            blogManagerService.updateBlogFocus(blog);

            retMap.put(Config.RET, Config.RET_OK);
        } else{
            blogFocus.setStatus(CommonStatus.available.getStatus());
            blogFocus.setUpdateTime(new Date());
            blogManagerService.updateBlogFouse(blogFocus);
            retMap.put(Config.RET, Config.RET_OK);
        }
        return retMap;
    }

    /**
     * 	跳转至【我的关注】
     * @return
     */
    @GetMapping("/follow")
    public String articleList(HttpServletRequest request, HttpServletResponse response){
        
        return "../mobile/follow";
    }
    
    /**
     * 	【我的关注列表】
     * @return
     */
    @GetMapping("/list")
    @ResponseBody
    public Map<String, Object> list(@RequestParam(defaultValue = "0", required = false) String  pageNo,
			  						@RequestParam(defaultValue = "10", required = false) String perPageNo,
			  						@RequestParam(value = "id") String id){
    	Map<String, Object> retMap = new HashMap<String, Object>();
    	// 验参
    	int userId = IDEncryptor.getInstance().decryptWithoutException(id);
    	if(userId == 0) {
    		retMap.put(Config.RET, Config.RET_ERROR);
    	    retMap.put(Config.ERR_MSG,"获取用户信息失败");
    	    return retMap;
    	}
    	
    	// 根据用户ID 查询关注列表
    	// 【列表查询】page参数组装
        Map<String, Object> paramMap = CommonUtil.pageParam(pageNo, perPageNo);
        paramMap.put("userId", userId);
        paramMap.put("status", String.valueOf(CommonStatus.available.getStatus()));
    	// 根据类型查询文章
    	List<FollowVO> followList = followService.getFollowList(paramMap);
    	if(followList.size() == 0) {
    		retMap.put(Config.RET, Config.RET_ERROR);
    	    retMap.put(Config.ERR_MSG,"快去关注您喜欢的公众号吧");
    	    return retMap;
    	}
    	// 列表数据组装
    	followList = paramAssem(followList);
    	retMap.put("data", CommonUtil.commonListData(followList.size(), followList));
    	retMap.put(Config.RET, Config.RET_OK);
    	return retMap;
    }
    
    /**
     * 	上拉刷新
     * @return
     * @description 上传关注列表当前分页【最后一个公众号ID】，取得该关注时间，然后查询【小于】该关注时间的列表按正序排列，limit前10条
     */
    @GetMapping(value = "/fwPullUp")
    @ResponseBody
    public Map<String, Object> fwpullUp(@RequestParam(value = "blogId") String lastChildId,@RequestParam(value = "userId") String id){
		Map<String, Object> retMap = new HashMap<String, Object>();
		// 验参
		int blogId = IDEncryptor.getInstance().decryptWithoutException(lastChildId);
		int userId = IDEncryptor.getInstance().decryptWithoutException(id);
		if(blogId == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
			retMap.put(Config.ERR_MSG,"未获取到关注信息");
			return retMap;
		}
		if(userId == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
			retMap.put(Config.ERR_MSG,"未获取到用户信息");
			return retMap;
		}
		BlogFocus blog = blogManagerService.getBlogFocusById(blogId,userId);
    	if(blog == null || blog.getStatus() == CommonStatus.unAvailable.getStatus()) {
    		retMap.put(Config.RET, Config.RET_ERROR);
    	    retMap.put(Config.ERR_MSG,"查询失败");
    	    return retMap;
    	}
		// 【列表查询】page参数组装
		Map<String, Object> paramMap = CommonUtil.pageParam("1", "10");
		paramMap.put("userId", String.valueOf(userId));
		paramMap.put("status", String.valueOf(CommonStatus.available.getStatus()));
		paramMap.put("endTime",blog.getCreateTime());
		// 下拉刷新查询最近更新文章列表
		List<FollowVO> followList = followService.getPullUpFollowList(paramMap);
		if(followList.size() == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
			retMap.put(Config.ERR_MSG,"别划了，到底啦");
			return retMap;
		}
		// 列表数据组装
		followList = paramAssem(followList);
		retMap.put("data", CommonUtil.commonListData(followList.size(), followList));
		retMap.put(Config.RET, Config.RET_OK);
		return retMap;
	}
    
    /**
     * 	【取消关注】
     * @return
     */
    @PostMapping("/cancel")
    @ResponseBody
    public Map<String, Object> cancel(@RequestParam(value = "id") String id,@RequestParam(value = "userId") String userId){
    	Map<String, Object> retMap = new HashMap<String, Object>();
    	
    	int uId = IDEncryptor.getInstance().decryptWithoutException(userId);
    	if(uId == 0) {
    		retMap.put(Config.RET, Config.RET_ERROR);
    	    retMap.put(Config.ERR_MSG,"获取用户信息失败");
    	    return retMap;
    	}
    	
    	// 验参
    	int blogId = IDEncryptor.getInstance().decryptWithoutException(id);
    	if(blogId == 0) {
    		retMap.put(Config.RET, Config.RET_ERROR);
    	    retMap.put(Config.ERR_MSG,"获取关注信息失败");
    	    return retMap;
    	}
    	
    	Blog blog = blogManagerService.getBlogById(blogId);
    	if(blog == null || blog.getStatus() == CommonStatus.unAvailable.getStatus()) {
    		retMap.put(Config.RET, Config.RET_ERROR);
    	    retMap.put(Config.ERR_MSG,"该公众号不存在");
    	    return retMap;
    	}
    	
    	int upResult = followService.updateStatus(uId,blogId,CommonStatus.unAvailable.getStatus(),new Date());
    	if(upResult == 0) {
    		retMap.put(Config.RET, Config.RET_ERROR);
    	    retMap.put(Config.ERR_MSG,"取消关注失败");
    	    return retMap;
    	}
    	retMap.put("data", id);
    	retMap.put(Config.RET, Config.RET_OK);
    	return retMap;
    }
    
    private List<FollowVO> paramAssem(List<FollowVO> followList) {
    	for (FollowVO fv : followList) {
    		fv.setId(IDEncryptor.getInstance().encryptWithoutException(Integer.valueOf(fv.getId())));
		}
		return followList;
	}
}
