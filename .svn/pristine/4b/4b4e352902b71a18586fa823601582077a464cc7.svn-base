package com.caishen91.jupiter.controller.manager;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caishen91.jupiter.authorize.enums.BlogEnabledStatus;
import com.caishen91.jupiter.authorize.init.SecurityWebInitializer;
import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.dto.BlogDTO;
import com.caishen91.jupiter.enums.BlogAuthStatus;
import com.caishen91.jupiter.enums.BlogType;
import com.caishen91.jupiter.enums.CommonStatus;
import com.caishen91.jupiter.model.BlogManager;
import com.caishen91.jupiter.service.IBlogManagerService;
import com.caishen91.jupiter.service.ISysBlogService;
import com.caishen91.jupiter.util.CommonUtil;
import com.caishen91.jupiter.util.IDEncryptor;
import com.caishen91.jupiter.util.OperationResult;
import com.caishen91.jupiter.util.StringUtil;
import com.caishen91.jupiter.vo.BlogDetailVO;

/**
 * 	公众号管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/manager/blog")
public class ManagerBlogController {

	@Autowired
	private ISysBlogService blogService;
	
	@Autowired
	private IBlogManagerService blogManagerSsservice;
	
	@Deprecated
	@GetMapping("/toBlogManager")
    public String toSysRoleManager(HttpServletResponse response) {
		response.setHeader("X-Frame-Options", "SAMEORIGIN");
        return "../managers/blog/blogManager";
    }
	
	@GetMapping("/toBlogSigning")
    public String toBlogSigning(HttpServletResponse response) {
		response.setHeader("X-Frame-Options", "SAMEORIGIN");
        return "../managers/blog/signing";
    }
	
	@GetMapping("/toBlogUnSign")
    public String toBlogUnSign(HttpServletResponse response) throws IOException {
		response.setHeader("X-Frame-Options", "SAMEORIGIN");
		response.getWriter().write("<script>window.location.reload();</script>");
        return "../managers/blog/unSign";
    }
	
	
	@GetMapping("/toAddBlog")
    public String toAddBlog(HttpServletResponse response) {
		response.setHeader("X-Frame-Options", "SAMEORIGIN");
        return "../managers/blog/addBlog";
    }
	
	/**
	 * 	查询已签约（已认证）公众号列表
	 * @param pageNo
	 * @param perPageNo
	 * @param blogDto
	 * @return
	 */
	@GetMapping(value = "/getSignBlogList")
	@ResponseBody
	public Map<String, Object> getSignBlogList(@RequestParam(defaultValue = "0", required = false) String  pageNo,
	        							   @RequestParam(defaultValue = "10", required = false) String perPageNo,BlogDTO blogDto){
		Map<String, Object> retMap = new HashMap<>();

        // 获取已认证数据总数
        int count = blogService.querySignBlogCount(blogDto,pageNo,perPageNo);
        List<Map<String, Object>> blogList = null;
        if (count > 0) {
        	blogList = blogService.querySignBlogList(blogDto,pageNo,perPageNo);
		}
        
        retMap.put("data", CommonUtil.commonListData(count, blogList));
        retMap.put(Config.RET, Config.RET_OK);
		return retMap;
	}
	
	/**
	 * 	查询未签约（未认证）公众号列表
	 * @param pageNo
	 * @param perPageNo
	 * @param blogDto
	 * @return
	 */
	@GetMapping(value = "/getUnSignBlogList")
	@ResponseBody
	public Map<String, Object> getBlogList(@RequestParam(defaultValue = "0", required = false) String  pageNo,
	        							   @RequestParam(defaultValue = "10", required = false) String perPageNo,BlogDTO blogDto){
		Map<String, Object> retMap = new HashMap<>();
		
        // 获取数据总数
        int count = blogService.queryUnSignBlogCount(blogDto,pageNo, perPageNo);
        List<Map<String, Object>> blogList = null;
        if (count > 0) {
        	blogList = blogService.queryUnSignBlogList(blogDto,pageNo, perPageNo);
		}
        
        retMap.put("data", CommonUtil.commonListData(count, blogList));
        retMap.put(Config.RET, Config.RET_OK);
		return retMap;
	}
	
	/**
	 * 	公众号详情
	 * @param id
	 * @return
	 */
	@GetMapping(value = "getBlogDtl")
	public String getBlogDetail(HttpServletResponse resp,HttpServletRequest req, @RequestParam String id) {
		resp.setHeader("X-Frame-Options", "SAMEORIGIN");
		// 验参
		int blogId = IDEncryptor.getInstance().decryptWithoutException(id);
		if(blogId == 0) {
			return null;
		}
		BlogDetailVO blog = blogService.queryBlogDetail(blogId);
		if (blog != null) {
			req.setAttribute("blog", blog);
			req.setAttribute("blogId", id);
			req.setAttribute("authStatus", blog.getAuthStatus());
		}
		return "../managers/blog/blogDetail";
	}
	
	/**
	 * 	创建【公众号】 && 】管理员】账号
	 * @param blogDTO
	 * @return
	 */
	@PostMapping(value = "/create")
	@ResponseBody
	public Map<String, Object> create(BlogDTO blogDTO){
		Map<String, Object> retMap = new HashMap<>();
		OperationResult paramResult = parseInterfaceInfo(blogDTO);
		if (!paramResult.isSuccess()) {
			// 验参失败
			retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,paramResult.getMessage());
            return retMap;
		}
		// 昵称，手机号去重
		int nickNamecount = blogService.getCountByNickName(blogDTO.getManagerNickName());
		if(nickNamecount > 0) {
			// 验参失败
			retMap.put(Config.RET, Config.RET_ERROR);
			retMap.put(Config.ERR_MSG,"该昵称已存在");
			return retMap;
		}
		if(blogDTO.getMobile() != null && !blogDTO.getMobile().equals("")) {
			int mobileCount = blogService.getCountByMobile(blogDTO.getMobile());
			if(mobileCount > 0) {
				// 验参失败
				retMap.put(Config.RET, Config.RET_ERROR);
				retMap.put(Config.ERR_MSG,"该手机号已存在");
				return retMap;
			}
		}
		// 创建公众号 && 管理员
		OperationResult createResult = blogService.addBlogAndManager(blogDTO);
		if (!createResult.isSuccess()) {
			retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"创建失败");
            return retMap;
		}
		retMap.put(Config.RET, Config.RET_OK);
        retMap.put(Config.MESSAGE,"创建成功");
		return retMap;
	}
	
	/**
	 * 	修改【公众号状态】：无效
	 * @param blogDTO
	 * @return
	 * @TODO: 这个地方应该是POST，原因：前端同一封装请求是getJSON，所以有时间再改
	 */
	@GetMapping(value = "/upCloseStatus")
	@ResponseBody
	public Map<String, Object> upCloseStatus(@RequestParam String id){
		Map<String, Object> retMap = new HashMap<>();
		// 验参
		int blogId = IDEncryptor.getInstance().decryptWithoutException(id);
		if (blogId == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"禁用失败");
            return retMap;
		}
		// 禁用
		int upResult = blogService.updateBlogStatus(blogId,CommonStatus.unAvailable.getStatus());
		blogManagerSsservice.updateBmStatusBatch(blogId,BlogEnabledStatus.NOT_ENABLED.getCode());
		if (upResult == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"禁用失败");
            return retMap;
		}
		Set<BlogManager> bm = blogManagerSsservice.getBmListByBlogId(blogId);
		for (BlogManager blogManager : bm) {
			String bmId = IDEncryptor.getInstance().encryptWithoutException(blogManager.getId());
			SecurityWebInitializer.setBMStatusMap(bmId);
		}
		retMap.put(Config.RET, Config.RET_OK);
        retMap.put(Config.MESSAGE,"操作成功");
        return retMap;
	}
	
	/**
	 * 	修改【公众号状态】：有效
	 * @param blogDTO
	 * @return
	 * @TODO: 这个地方应该是POST，原因：前端同一封装请求是getJSON，所以有时间再改
	 */
	@GetMapping(value = "/upOpenStatus")
	@ResponseBody
	public Map<String, Object> upOpenStatus(@RequestParam String id){
		Map<String, Object> retMap = new HashMap<>();
		// 验参
		int blogId = IDEncryptor.getInstance().decryptWithoutException(id);
		if (blogId == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"启用失败");
            return retMap;
		}
		// 启用
		int upResult = blogService.updateBlogStatus(blogId,CommonStatus.available.getStatus());
		blogManagerSsservice.updateBmStatusBatch(blogId,BlogEnabledStatus.ENABLED.getCode());
		if (upResult == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"启用失败");
            return retMap;
		}
		
		Set<BlogManager> bm = blogManagerSsservice.getBmListByBlogId(blogId);
		for (BlogManager blogManager : bm) {
			String bmId = IDEncryptor.getInstance().encryptWithoutException(blogManager.getId());
			SecurityWebInitializer.setBMStatusMap(bmId);
		}
		retMap.put(Config.RET, Config.RET_OK);
        retMap.put(Config.MESSAGE,"操作成功");
        return retMap;
	}
	
	/**
	 * 	【公众号认证】状态：通过认证
	 * @param blogDTO
	 * @return
	 * @TODO: 这个地方应该是POST，原因：前端同一封装请求是getJSON，所以有时间再改
	 */
	@GetMapping(value = "/upOpenAuth")
	@ResponseBody
	public Map<String, Object> upOpenAuth(@RequestParam String id){
		Map<String, Object> retMap = new HashMap<>();
		// 验参
		int blogId = IDEncryptor.getInstance().decryptWithoutException(id);
		if (blogId == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"认证失败");
            return retMap;
		}
		// 通过认证
		int upResult = blogService.updateBlogAuthStatus(blogId,BlogAuthStatus.CERTIFIED.getAuthCode());
		if (upResult == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"认证失败");
            return retMap;
		}
		retMap.put(Config.RET, Config.RET_OK);
        retMap.put(Config.MESSAGE,"操作成功");
        return retMap;
	}
	
	/**
	 * 	参数验证
	 * @param blogDTO
	 * @return
	 */
	private OperationResult parseInterfaceInfo(BlogDTO blogDTO){
		OperationResult or = new OperationResult();
		if(blogDTO == null) {
			or.setStatus(false);
			or.setMessage("参数不能为空");
			return or;
		} else if (StringUtil.isEmpty(blogDTO.getBlogType())) {
			or.setStatus(false);
			or.setMessage("用户类型不能为空");
			return or;
		} else if(!StringUtil.isEmpty(blogDTO.getBlogType()) && blogDTO.getBlogType().equals(String.valueOf(BlogType.COMPANY.getType()))
				&& StringUtil.isEmpty(blogDTO.getEnterpriseType())) {
			or.setStatus(false);
			or.setMessage("企业类型不能为空");
			return or;
		} else if(!StringUtil.isEmpty(blogDTO.getBlogType()) && blogDTO.getBlogType().equals(String.valueOf(BlogType.COMPANY.getType()))
				&& StringUtil.isEmpty(blogDTO.getEnterpriseType())){
			or.setStatus(false);
			or.setMessage("企业名称不能为空");
			return or;
		} else if(StringUtil.isEmpty(blogDTO.getManagerName())) {
			or.setStatus(false);
			or.setMessage("管理员名称不能为空");
			return or;
		} else if(StringUtil.isEmpty(blogDTO.getManagerNickName())) {
			or.setStatus(false);
			or.setMessage("昵称不能为空");
			return or;
		} 
		or.setStatus(true);
		return or;
	}
}
