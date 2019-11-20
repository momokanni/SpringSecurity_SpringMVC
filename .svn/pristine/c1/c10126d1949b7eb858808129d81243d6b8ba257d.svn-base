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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caishen91.jupiter.authorize.init.SecurityWebInitializer;
import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.dto.BlogManagerDTO;
import com.caishen91.jupiter.enums.CommonStatus;
import com.caishen91.jupiter.model.BlogManager;
import com.caishen91.jupiter.service.IBlogManagerService;
import com.caishen91.jupiter.service.ISysBlogService;
import com.caishen91.jupiter.util.Action;
import com.caishen91.jupiter.util.ActionFactory;
import com.caishen91.jupiter.util.CommonUtil;
import com.caishen91.jupiter.util.IDEncryptor;
import com.caishen91.jupiter.util.StringUtil;
import com.caishen91.jupiter.vo.BlogDetailVO;
import com.caishen91.jupiter.vo.BlogManagerVO;

/**
 * 	公众号子账号
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/manager/blogManager")
public class SysBlogManagerController {

	@Autowired
	private IBlogManagerService bmService;
	
	@Autowired
	private ISysBlogService blogService;
	
	@GetMapping("/tosubAccount")
    public String toSysRoleManager(HttpServletRequest req,HttpServletResponse response,@RequestParam String id) {
		
		BlogDetailVO blog = blogService.queryBlogDetail(IDEncryptor.getInstance().decryptWithoutException(id));
		if (blog != null) {
			req.setAttribute("blog", blog);
		}
		req.setAttribute("blogId", id);
		req.setAttribute("tab", "record");
		response.setHeader("X-Frame-Options", "SAMEORIGIN");
        return "../managers/blog/subAccount";
    }
	
	/**
	 * 	查询【子账号列表】
	 * @param pageNo
	 * @param perPageNo
	 * @return
	 */
	@GetMapping(value = "/getBMList")
	@ResponseBody
	public Map<String, Object> getBlogList(
								@RequestParam(defaultValue = "0", required = false) String  pageNo,
								@RequestParam(defaultValue = "10", required = false) String perPageNo,@RequestParam String id){
		Map<String, Object> retMap = new HashMap<>();
		// 验参
		int blogId = IDEncryptor.getInstance().decryptWithoutException(id);
		if(blogId == 0) {
			// 验参失败
			retMap.put(Config.RET, Config.RET_ERROR);
			retMap.put(Config.ERR_MSG,"获取公众号信息失败");
			return retMap;
		}
		// 查询状态为有效和无效的子账号
    	int[] statusArray = {CommonStatus.available.getStatus(),CommonStatus.unAvailable.getStatus()};
    	
    	Map<String, Object> paramMap = CommonUtil.pageParam(pageNo, perPageNo);
		paramMap.put("blogId", blogId);
		paramMap.put("statusArrary", statusArray);
        // 获取数据总数
        int count = bmService.queryBMCountByBlogId(blogId,statusArray);
        List<BlogManagerVO> bmList = null;
        if (count > 0) {
        	// 子账号列表
        	bmList = bmService.queryBMListByBlogId(paramMap);
		} else {
			retMap.put(Config.RET, Config.RET_ERROR);
			retMap.put(Config.ERR_MSG, "暂无数据");
			return retMap;
		}
        List<Map<String, Object>> listResultMap = null;
        if (null != bmList && bmList.size() > 0) {
        	listResultMap = new ArrayList<>();
        	for (BlogManagerVO bmVO : bmList) {
        		Map<String, Object> resultMap = new HashMap<>();
        		String blogIdStr = IDEncryptor.getInstance().encryptWithoutException(bmVO.getId());
        		// 登录名
        		resultMap.put("loginName", bmVO.getMobile()); 
        		// 姓名
        		resultMap.put("name", bmVO.getName());
        		// 昵称
                resultMap.put("nickName", bmVO.getNickName()); 
                // 状态
                resultMap.put("status", CommonStatus.getCommonStatus(bmVO.getStatus()).getDesc());
                
                List<Action> actions = new ArrayList<Action>();
                
                if (bmVO.getStatus() == CommonStatus.available.getStatus()) {
                	// 有效--停用、重置密码
                	Action unUse = ActionFactory.build(ActionFactory.BM_ACCOUNT_UN_USE, "", "",
                            ActionFactory.OPTYPE_SCRIPT, "/manager/blogManager/upBMCloseStatus?id=" + blogIdStr, ActionFactory.REQ_TYPE_CONFIRM, "updateBlogAuth");
                	
                	Action resetPwd = ActionFactory.build(ActionFactory.BM_ACCOUNT_PWD_RESET, "", "",
                            ActionFactory.OPTYPE_SCRIPT, "/manager/blogManager/pwdReset?id=" + blogIdStr, ActionFactory.REQ_TYPE_DIV, "bmPwdReset");
                	actions.add(unUse);
                	actions.add(resetPwd);
				} else {
					// 无效--启用、删除账号
					Action use = ActionFactory.build(ActionFactory.BM_ACCOUNT_USE, "", "",
                            ActionFactory.OPTYPE_SCRIPT, "/manager/blogManager/upBMOpenStatus?id=" + blogIdStr, ActionFactory.REQ_TYPE_CONFIRM, "upBMOpenStatus");
                	
                	Action del = ActionFactory.build(ActionFactory.BM_ACCOUNT_DEL, "", "",
                            ActionFactory.OPTYPE_SCRIPT, "/manager/blogManager/delSubAccount?id=" + blogIdStr, ActionFactory.REQ_TYPE_CONFIRM, "updateBlogAuth");
                    
                	actions.add(use);
                	actions.add(del);
				}

                resultMap.put("opList", actions);
                listResultMap.add(resultMap);
			}
        }
        
        retMap.put("data", CommonUtil.commonListData(count, listResultMap));
        retMap.put(Config.RET, Config.RET_OK);
		return retMap;
	}
	
	/**
	 * 	重置密码
	 * @param blogManagerVO
	 * @return
	 */
	@PostMapping(value = "/pwdReset")
	@ResponseBody
	public Map<String, Object> pwdReset(@RequestParam("pwd")String pwd,@RequestParam("confirmPwd") String confirmPwd,@RequestParam("id") String id){
		Map<String, Object> retMap = new HashMap<>();
		// 验参
		int bmId = IDEncryptor.getInstance().decryptWithoutException(id);
		if (bmId == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
		    retMap.put(Config.ERR_MSG,"密码修改失败");
		    return retMap;
		}
		BlogManager bm = bmService.getBMById(bmId);
		String newPwd = StringUtil.MD5Encode(pwd);
		String confirmPwdEncode = StringUtil.MD5Encode(confirmPwd);
		if(!confirmPwdEncode.equals(newPwd)) {
			retMap.put(Config.RET, Config.RET_ERROR);
		    retMap.put(Config.ERR_MSG,"确认密码不一致");
		    return retMap;
		} else if (newPwd.equals(bm.getPassword())) {
			retMap.put(Config.RET, Config.RET_ERROR);
		    retMap.put(Config.ERR_MSG,"不能使用旧密码");
		    return retMap;
		}
		BlogManagerDTO blogManagerDTO = new BlogManagerDTO();
		blogManagerDTO.setId(bmId);
		blogManagerDTO.setPwd(newPwd);
		int pwdReset = bmService.updateBMPwd(blogManagerDTO);
		if (pwdReset == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
		    retMap.put(Config.ERR_MSG,"重置密码失败");
		    return retMap;
		}
		retMap.put(Config.RET, Config.RET_OK);
	    retMap.put(Config.MESSAGE,"重置成功");
	    return retMap;
	}
	
	/**
	 * 	修改【子账号状态】：停用（无效）
	 * @param blogDTO
	 * @return
	 * @TODO: 这个地方应该是POST，原因：前端同一封装请求是getJSON，所以有时间再改
	 */
	@GetMapping(value = "/upBMCloseStatus")
	@ResponseBody
	public Map<String, Object> upCloseStatus(@RequestParam String id){
		Map<String, Object> retMap = new HashMap<>();
		// 验参
		int bmId = IDEncryptor.getInstance().decryptWithoutException(id);
		if (bmId == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"停用失败");
            return retMap;
		}
		// 停用
		int upResult = bmService.updateBMStatus(bmId,CommonStatus.unAvailable.getStatus());
		if (upResult == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"停用失败");
            return retMap;
		}
		SecurityWebInitializer.setBMStatusMap(id);
		retMap.put(Config.RET, Config.RET_OK);
        retMap.put(Config.MESSAGE,"操作成功");
        return retMap;
	}
	
	/**
	 * 	修改【子账号状态】：启用（有效）
	 * @param blogDTO
	 * @return
	 * @TODO: 这个地方应该是POST，原因：前端同一封装请求是getJSON，所以有时间再改
	 */
	@GetMapping(value = "/upBMOpenStatus")
	@ResponseBody
	public Map<String, Object> upOpenStatus(@RequestParam String id){
		Map<String, Object> retMap = new HashMap<>();
		// 验参
		int bmId = IDEncryptor.getInstance().decryptWithoutException(id);
		if (bmId == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"启用失败");
            return retMap;
		}
		// 启用
		int upResult = bmService.updateBMStatus(bmId,CommonStatus.available.getStatus());
		if (upResult == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"启用失败");
            return retMap;
		}
		retMap.put(Config.RET, Config.RET_OK);
        retMap.put(Config.MESSAGE,"操作成功");
        return retMap;
	}
	
	/**
	 * 	修改【子账号状态】：删除（逻辑删除）
	 * @param blogDTO
	 * @return
	 * @TODO: 这个地方应该是POST，原因：前端同一封装请求是getJSON，所以有时间再改
	 */
	@GetMapping(value = "/delSubAccount")
	@ResponseBody
	public Map<String, Object> delSubAccount(@RequestParam String id){
		Map<String, Object> retMap = new HashMap<>();
		// 验参
		int bmId = IDEncryptor.getInstance().decryptWithoutException(id);
		if (bmId == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"删除失败");
            return retMap;
		}
		// 启用
		int upResult = bmService.updateBMStatus(bmId,CommonStatus.DELETE.getStatus());
		if (upResult == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"删除失败");
            return retMap;
		}
		retMap.put(Config.RET, Config.RET_OK);
        retMap.put(Config.MESSAGE,"操作成功");
        return retMap;
	}
	
}
