package com.caishen91.jupiter.controller.manager;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caishen91.jupiter.authorize.init.SecurityWebInitializer;
import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.enums.BlogManagerType;
import com.caishen91.jupiter.model.Blog;
import com.caishen91.jupiter.model.BlogManager;
import com.caishen91.jupiter.service.IBlogManagerPermitService;
import com.caishen91.jupiter.service.IBlogManagerService;
import com.caishen91.jupiter.service.IBlogService;
import com.caishen91.jupiter.util.IDEncryptor;
import com.caishen91.jupiter.util.StringUtil;

/**
 * 	商户号：【管理员及权限关联处理器】
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/manager/blogPermit")
public class ManagerBlogPermitController {

	@Autowired
	private IBlogManagerPermitService blogManagerPermitService;
	
	@Autowired
	private IBlogService blogService;
	
	@Autowired
	private IBlogManagerService blogManagerService;
	
	@GetMapping(value="/getAllPermission")
	@ResponseBody
	public Map<String, Object> getAllPermission(@RequestParam String id) {
		Map<String, Object> retMap = new HashMap<>();
	    retMap.put(Config.RET, Config.RET_OK);
		int blogId = IDEncryptor.getInstance().decryptWithoutException(id);
		String json = blogManagerPermitService.getAllPermission(blogId);
		if(StringUtil.isEmpty(json)) {
			retMap.put(Config.RET, Config.RET_ERROR);
		} else {
			retMap.put(Config.RET_DATA, json);
			retMap.put("blogId", id);
		}
		return retMap;
	}
	
	/**
     * 	商户授权菜单
     * @param sysUserIdStr
     * @return
     */
    @PostMapping("addAuth")
    @ResponseBody
    public Map<String,Object> addAuth(@RequestParam("blogId") String blogId,@RequestParam("blogPermitId") String[] blogPermitId) {
        Map<String, Object> retMap = new HashMap<>();
        retMap.put(Config.RET, Config.RET_OK);

        int id = IDEncryptor.getInstance().decryptWithoutException(blogId);

        Blog blog = blogService.getBlogById(id);
        if (null == blog) {
            retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "商户不存在");
            return  retMap;
        }
        
        BlogManager manager = blogManagerService.getBmByIdAndType(id,BlogManagerType.ADMIN.getType());
        if(null == manager) {
        	retMap.put(Config.RET, Config.RET_ERROR);
            retMap.put(Config.ERR_MSG, "未找到该商户超级管理员");
            return  retMap;
        }
        try {
        	blogManagerPermitService.updateBlogAuth(id,manager.getId(), blogPermitId);
        	SecurityWebInitializer.setBMAuthMap(IDEncryptor.getInstance().encryptWithoutException(manager.getId()));
        } catch (Exception e) {
            e.printStackTrace();
            retMap.put(Config.RET, Config.RET_OK);
            retMap.put(Config.ERR_MSG, "操作失败");
            return retMap;
        }

        return retMap;
    }
}
