package com.caishen91.jupiter.controller.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.enums.CategoryType;
import com.caishen91.jupiter.model.Article;
import com.caishen91.jupiter.model.BlogManager;
import com.caishen91.jupiter.service.IArticleService;
import com.caishen91.jupiter.service.IBlogManagerService;
import com.caishen91.jupiter.service.ISysBlogService;
import com.caishen91.jupiter.util.Action;
import com.caishen91.jupiter.util.ActionFactory;
import com.caishen91.jupiter.util.CommonUtil;
import com.caishen91.jupiter.util.DateUtil;
import com.caishen91.jupiter.util.IDEncryptor;
import com.caishen91.jupiter.vo.ArticleVO;
import com.caishen91.jupiter.vo.BlogDetailVO;
import com.caishen91.jupiter.vo.ReadArticleVO;

/**
 * 	公众号文章相关操作
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/manager/article")
public class SysBlogArticleController {

	@Autowired
    private IArticleService articleService;
	
	@Autowired
	private ISysBlogService blogService;
	
	@Autowired
	private IBlogManagerService bmService;
	
	@GetMapping("/toArticle")
    public String toSysRoleManager(HttpServletRequest req,HttpServletResponse response, @RequestParam String id) {
		response.setHeader("X-Frame-Options", "SAMEORIGIN");
		BlogDetailVO blog = blogService.queryBlogDetail(IDEncryptor.getInstance().decryptWithoutException(id));
		if (blog != null) {
			req.setAttribute("blog", blog);
		}
		req.setAttribute("blogId", id);
		req.setAttribute("tab", "establish");
        return "../managers/blog/articleList";
    }
	
	/**
	 * 	查询【文章列表】
	 * @param pageNo
	 * @param perPageNo
	 * @return
	 */
	@GetMapping(value = "/list")
	@ResponseBody
	public Map<String, Object> getBlogList(
								@RequestParam(defaultValue = "0", required = false) String  pageNo,
								@RequestParam(defaultValue = "10", required = false) String perPageNo,@RequestParam(value = "id") String id){
		// 验参
		int blogId = IDEncryptor.getInstance().decryptWithoutException(id);
		if(blogId == 0) {
			return null;
		}
		Map<String, Object> retMap = new HashMap<>();
    	
        // 获取数据总数
        int count = articleService.queryArticleCountByBlogId(blogId);
        List<ArticleVO> arList = null;
        if (count > 0) {
        	Map<String, Object> paramMap = CommonUtil.pageParam(pageNo, perPageNo);
    		paramMap.put("blogId", blogId);
        	// 文章列表
        	arList = articleService.queryListByBlogId(paramMap);
		} else {
			retMap.put(Config.RET, Config.RET_ERROR);
			retMap.put(Config.ERR_MSG, "暂无数据");
			return retMap;
		}
        List<Map<String, Object>> listResultMap = null;
        if (null != arList && arList.size() > 0) {
        	listResultMap = new ArrayList<>();
        	for (ArticleVO av : arList) {
        		Map<String, Object> resultMap = new HashMap<>();
        		String avIdStr = IDEncryptor.getInstance().encryptWithoutException(av.getId());
        		// 编号
        		resultMap.put("number", av.getNumber()); 
        		// 文章名称
        		resultMap.put("title", av.getTitle()); 
        		// 类型
                resultMap.put("type",av.getTypeName());
                // 标签
                resultMap.put("label",av.getLabelName());
        		// 种类
                resultMap.put("category",CategoryType.getCategoryType(av.getCategory()).getDesc());
                // 时间
                resultMap.put("time",DateUtil.fomatToYYYY_MM_dd_HH_mm_ss(av.getCreateTime()));
        		// 状态
                resultMap.put("status", Article.ArticleStatus.getArticleStatus(av.getStatus()).getDesc());
                
                List<Action> actions = new ArrayList<Action>();
                
                if (av.getStatus() == Article.ArticleStatus.hasBeenReleased.getId() || 
                	av.getStatus() == Article.ArticleStatus.toBeReleased.getId()	) {
                	// 已发布、待发布 -- 下线
                	Action unUse = ActionFactory.build(ActionFactory.ARTICLE_UN_USE, "", "",
                            ActionFactory.OPTYPE_SCRIPT, "/manager/article/upARCloseStatus?id=" + avIdStr, ActionFactory.REQ_TYPE_CONFIRM, "upARCloseStatus");
                	actions.add(unUse);
				} 
                // 其他 查看
				Action look = ActionFactory.build(ActionFactory.ARTICLE_LOOK, "/manager/article/articlrDetail?id=" + avIdStr, ActionFactory.TARGET_SELF,
						ActionFactory.OPTYPE_LINK,"", ActionFactory.REQ_TYPE_LINK, "");
				actions.add(look);
                
                resultMap.put("opList", actions);
                listResultMap.add(resultMap);
			}
        }
        
        retMap.put("data", CommonUtil.commonListData(count, listResultMap));
        retMap.put(Config.RET, Config.RET_OK);
		return retMap;
	}
	
	/**
	 * 	修改【文章状态】：下线
	 * @param blogDTO
	 * @return
	 * @TODO: 这个地方应该是POST，原因：前端同一封装请求是getJSON，所以有时间再改
	 */
	@GetMapping(value = "/upARCloseStatus")
	@ResponseBody
	public Map<String, Object> upCloseStatus(@RequestParam String id){
		Map<String, Object> retMap = new HashMap<>();
		// 验参
		int arId = IDEncryptor.getInstance().decryptWithoutException(id);
		if (arId == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"下线失败");
            return retMap;
		}
		// 禁用
		int upResult = articleService.updateARStatus(arId,Article.ArticleStatus.Offline.getId());
		if (upResult == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"下线失败");
            return retMap;
		}
		retMap.put(Config.RET, Config.RET_OK);
        retMap.put(Config.MESSAGE,"操作成功");
        return retMap;
	}
	
	
	/**
	 * 	阅读列表页面
	 * @param req
	 * @param id
	 * @return
	 */
	@GetMapping("/toReadList")
    public String toReadList(HttpServletRequest req,HttpServletResponse response,@RequestParam String id) {
		BlogDetailVO blog = blogService.queryBlogDetail(IDEncryptor.getInstance().decryptWithoutException(id));
		if (blog != null) {
			req.setAttribute("blog", blog);
		}
		req.setAttribute("blogId", id);
		req.setAttribute("tab", "read");
		response.setHeader("X-Frame-Options", "SAMEORIGIN");
        return "../managers/blog/readList";
    }
	
	/**
	 * 	查询【阅读列表】
	 * @param pageNo
	 * @param perPageNo
	 * @return
	 */
	@GetMapping(value = "/readList")
	@ResponseBody
	public Map<String, Object> getReadList(
								@RequestParam(defaultValue = "0", required = false) String  pageNo,
								@RequestParam(defaultValue = "10", required = false) String perPageNo,@RequestParam(value = "id") String id){
		Map<String, Object> retMap = new HashMap<>();
		// 验参
		int blogId = IDEncryptor.getInstance().decryptWithoutException(id);
		if(blogId == 0) {
			// 验参失败
			retMap.put(Config.RET, Config.RET_ERROR);
			retMap.put(Config.ERR_MSG,"获取公众号信息失败");
			return retMap;
		}
		// 获取公众号管理员
		BlogManager bm = bmService.getBMByBlogId(blogId);
		if(bm == null) {
			// 验参失败
			retMap.put(Config.RET, Config.RET_ERROR);
			retMap.put(Config.ERR_MSG,"获取管理员信息失败");
			return retMap;
		}
        // 获取阅读文章总数
        int count = articleService.queryReadCountByUserId(bm.getId(),Article.ArticleStatus.hasBeenReleased.getId());
        List<ReadArticleVO> arList = null;
        if (count > 0) {
        	Map<String, Object> paramMap = CommonUtil.pageParam(pageNo, perPageNo);
    		paramMap.put("userId", bm.getId());
    		paramMap.put("status", Article.ArticleStatus.hasBeenReleased.getId());
        	// 文章列表
        	arList = articleService.queryReadListByUserId(paramMap);
		} else {
			retMap.put(Config.RET, Config.RET_ERROR);
			retMap.put(Config.ERR_MSG, "暂无数据");
			return retMap;
		}
        List<Map<String, Object>> listResultMap = null;
        if (null != arList && arList.size() > 0) {
        	listResultMap = new ArrayList<>();
        	for (ReadArticleVO rav : arList) {
        		Map<String, Object> resultMap = new HashMap<>();
        		String avIdStr = IDEncryptor.getInstance().encryptWithoutException(rav.getArId());
        		// 编号
        		resultMap.put("number", rav.getNumber()); 
        		// 文章名称
        		resultMap.put("title", rav.getTitle()); 
        		// 类型
                resultMap.put("type",rav.getTypeName());
                // 标签
                resultMap.put("label",rav.getLabelName());
        		// 种类
                resultMap.put("category",CategoryType.getCategoryType(rav.getCategory()).getDesc());
                // 阅读时间
                resultMap.put("time",DateUtil.fomatToYYYY_MM_dd_HH_mm_ss(rav.getReadTime()));

                List<Action> actions = new ArrayList<Action>();
                
                // 查看
				Action look = ActionFactory.build(ActionFactory.ARTICLE_LOOK, "/manager/article/articlrDetail?id=" + avIdStr, ActionFactory.TARGET_SELF,
						ActionFactory.OPTYPE_LINK,"", ActionFactory.REQ_TYPE_LINK, "");
				actions.add(look);
                
                resultMap.put("opList", actions);
                listResultMap.add(resultMap);
			}
        }
        
        retMap.put("data", CommonUtil.commonListData(count, listResultMap));
        retMap.put(Config.RET, Config.RET_OK);
		return retMap;
	}
	
	/**
	 * 	收藏列表页面
	 * @param req
	 * @param id
	 * @return
	 */
	@GetMapping("/toCollectList")
    public String toCollectList(HttpServletRequest req,HttpServletResponse response,@RequestParam String id) {
		BlogDetailVO blog = blogService.queryBlogDetail(IDEncryptor.getInstance().decryptWithoutException(id));
		if (blog != null) {
			req.setAttribute("blog", blog);
		}
		req.setAttribute("blogId", id);
		req.setAttribute("tab", "collect");
		response.setHeader("X-Frame-Options", "SAMEORIGIN");
        return "../managers/blog/collectList";
    }
	
	/**
	 * 	查询【收藏列表】
	 * @param pageNo
	 * @param perPageNo
	 * @return
	 */
	@GetMapping(value = "/collectList")
	@ResponseBody
	public Map<String, Object> getCollectList(
								@RequestParam(defaultValue = "0", required = false) String  pageNo,
								@RequestParam(defaultValue = "10", required = false) String perPageNo,@RequestParam(value = "id") String id){
		Map<String, Object> retMap = new HashMap<>();
		// 验参
		int blogId = IDEncryptor.getInstance().decryptWithoutException(id);
		if(blogId == 0) {
			// 验参失败
			retMap.put(Config.RET, Config.RET_ERROR);
			retMap.put(Config.ERR_MSG,"获取公众号信息失败");
			return retMap;
		}
		// 获取公众号管理员
		BlogManager bm = bmService.getBMByBlogId(blogId);
		if(bm == null) {
			// 验参失败
			retMap.put(Config.RET, Config.RET_ERROR);
			retMap.put(Config.ERR_MSG,"获取管理员信息失败");
			return retMap;
		}
        // 获取收藏文章总数
        int count = articleService.queryCollectCountByUserId(bm.getId(),Article.ArticleStatus.hasBeenReleased.getId());
        List<ReadArticleVO> arList = null;
        if (count > 0) {
        	Map<String, Object> paramMap = CommonUtil.pageParam(pageNo, perPageNo);
    		paramMap.put("userId", bm.getId());
    		paramMap.put("status", Article.ArticleStatus.hasBeenReleased.getId());
        	// 文章列表
        	arList = articleService.queryCollectListByUserId(paramMap);
		} else {
			retMap.put(Config.RET, Config.RET_ERROR);
			retMap.put(Config.ERR_MSG, "暂无数据");
			return retMap;
		}
        List<Map<String, Object>> listResultMap = null;
        if (null != arList && arList.size() > 0) {
        	listResultMap = new ArrayList<>();
        	for (ReadArticleVO rav : arList) {
        		Map<String, Object> resultMap = new HashMap<>();
        		String avIdStr = IDEncryptor.getInstance().encryptWithoutException(rav.getArId());
        		// 编号
        		resultMap.put("number", rav.getNumber()); 
        		// 文章名称
        		resultMap.put("title", rav.getTitle()); 
        		// 类型
                resultMap.put("type",rav.getTypeName());
                // 标签
                resultMap.put("label",rav.getLabelName());
        		// 种类
                resultMap.put("category",CategoryType.getCategoryType(rav.getCategory()).getDesc());
                // 收藏时间
                resultMap.put("time",DateUtil.fomatToYYYY_MM_dd_HH_mm_ss(rav.getReadTime()));

                List<Action> actions = new ArrayList<Action>();
                
                // 查看
				Action look = ActionFactory.build(ActionFactory.ARTICLE_LOOK, "/manager/article/articlrDetail?id=" + avIdStr, ActionFactory.TARGET_SELF,
						ActionFactory.OPTYPE_LINK,"", ActionFactory.REQ_TYPE_LINK, "");
				actions.add(look);
                
                resultMap.put("opList", actions);
                listResultMap.add(resultMap);
			}
        }
        
        retMap.put("data", CommonUtil.commonListData(count, listResultMap));
        retMap.put(Config.RET, Config.RET_OK);
		return retMap;
	}
}
