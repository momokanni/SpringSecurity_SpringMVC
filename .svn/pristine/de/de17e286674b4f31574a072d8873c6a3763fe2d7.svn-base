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
import com.caishen91.jupiter.enums.CommonStatus;
import com.caishen91.jupiter.model.BlogLabel;
import com.caishen91.jupiter.service.IBlogLableService;
import com.caishen91.jupiter.service.ISysBlogService;
import com.caishen91.jupiter.util.Action;
import com.caishen91.jupiter.util.ActionFactory;
import com.caishen91.jupiter.util.CommonUtil;
import com.caishen91.jupiter.util.IDEncryptor;
import com.caishen91.jupiter.vo.BlogDetailVO;

/**
 * 	公众号标签
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/manager/label")
public class SysBlogLabelController {

	@Autowired
    private IBlogLableService blogLableService;
	
	@Autowired
	private ISysBlogService blogService;
	
	@GetMapping("/toLabel")
    public String toSysRoleManager(HttpServletRequest req,HttpServletResponse response,@RequestParam String id) {
		
		BlogDetailVO blog = blogService.queryBlogDetail(IDEncryptor.getInstance().decryptWithoutException(id));
		if (blog != null) {
			req.setAttribute("blog", blog);
		}
		req.setAttribute("blogId", id);
		req.setAttribute("tab", "repay");
		response.setHeader("X-Frame-Options", "SAMEORIGIN");
        return "../managers/blog/labelList";
    }
	
	/**
	 * 	查询【标签列表】
	 * @param pageNo
	 * @param perPageNo
	 * @return
	 */
	@GetMapping(value = "/getLabelList")
	@ResponseBody
	public Map<String, Object> getBlogList(
								@RequestParam(defaultValue = "0", required = false) String  pageNo,
								@RequestParam(defaultValue = "10", required = false) String perPageNo,@RequestParam String id){
		// 验参
		int blogId = IDEncryptor.getInstance().decryptWithoutException(id);
		if(blogId == 0) {
			return null;
		}
    	
		Map<String, Object> retMap = new HashMap<>();
        // 获取数据总数
        int count = blogLableService.queryLabelCountByBlogId(blogId);
        List<BlogLabel> labelList = null;
        if (count > 0) {
        	Map<String, Object> paramMap = CommonUtil.pageParam(pageNo, perPageNo);
    		paramMap.put("blogId", blogId);
        	// 子账号列表
        	labelList = blogLableService.getLabelListByBlogId(paramMap);
		} else {
			retMap.put(Config.RET, Config.RET_ERROR);
			retMap.put(Config.ERR_MSG, "暂无数据");
			return retMap;
		}
        List<Map<String, Object>> listResultMap = null;
        if (null != labelList && labelList.size() > 0) {
        	listResultMap = new ArrayList<>();
        	for (BlogLabel bl : labelList) {
        		Map<String, Object> resultMap = new HashMap<>();
        		String labelIdStr = IDEncryptor.getInstance().encryptWithoutException(bl.getId());
        		// 标签名称
        		resultMap.put("labelName", bl.getName()); 
        		// 标签描述
        		resultMap.put("desc", bl.getDescription()); 
        		// 标签状态
                resultMap.put("status", CommonStatus.getCommonStatus(bl.getStatus()).getDesc());
                
                List<Action> actions = new ArrayList<Action>();
                
                if (bl.getStatus() == CommonStatus.available.getStatus()) {
                	// 有效--禁用
                	Action unUse = ActionFactory.build(ActionFactory.BLOG_LABEL_UN_USE, "", "",
                            ActionFactory.OPTYPE_SCRIPT, "/manager/label/upBLCloseStatus?id=" + labelIdStr, ActionFactory.REQ_TYPE_CONFIRM, "upBLCloseStatus");
                	actions.add(unUse);
                	
				} else {
					// 无效--启用
					Action use = ActionFactory.build(ActionFactory.BM_ACCOUNT_USE, "", "",
                            ActionFactory.OPTYPE_SCRIPT, "/manager/label/upBLOpenStatus?id=" + labelIdStr, ActionFactory.REQ_TYPE_CONFIRM, "upBLOpenStatus");
                	actions.add(use);
				}
				/*
				 * Action edit = ActionFactory.build(ActionFactory.BLOG_LABEL_EDIT, "", "",
				 * ActionFactory.OPTYPE_SCRIPT, "/manager/label/edit?id=" + labelIdStr,
				 * ActionFactory.REQ_TYPE_DIV, "blEdit"); actions.add(edit);
				 */
                
                resultMap.put("opList", actions);
                listResultMap.add(resultMap);
			}
        }
        
        retMap.put("data", CommonUtil.commonListData(count, listResultMap));
        retMap.put(Config.RET, Config.RET_OK);
		return retMap;
	}
	
	/**
	 * 	修改【标签状态】：禁用（无效）
	 * @param blogDTO
	 * @return
	 * @TODO: 这个地方应该是POST，原因：前端同一封装请求是getJSON，所以有时间再改
	 */
	@GetMapping(value = "/upBLCloseStatus")
	@ResponseBody
	public Map<String, Object> upCloseStatus(@RequestParam String id){
		Map<String, Object> retMap = new HashMap<>();
		// 验参
		int blId = IDEncryptor.getInstance().decryptWithoutException(id);
		if (blId == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"禁用失败");
            return retMap;
		}
		// 禁用
		int upResult = blogLableService.updateBLStatus(blId,CommonStatus.unAvailable.getStatus());
		if (upResult == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"禁用失败");
            return retMap;
		}
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
	@GetMapping(value = "/upBLOpenStatus")
	@ResponseBody
	public Map<String, Object> upOpenStatus(@RequestParam String id){
		Map<String, Object> retMap = new HashMap<>();
		// 验参
		int blId = IDEncryptor.getInstance().decryptWithoutException(id);
		if (blId == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"启用失败");
            return retMap;
		}
		// 启用
		int upResult = blogLableService.updateBLStatus(blId,CommonStatus.available.getStatus());
		if (upResult == 0) {
			retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG,"启用失败");
            return retMap;
		}
		retMap.put(Config.RET, Config.RET_OK);
        retMap.put(Config.MESSAGE,"操作成功");
        return retMap;
	}
	
}
