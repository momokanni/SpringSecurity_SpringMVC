package com.caishen91.jupiter.controller.blog;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.enums.BlogAuthStatus;
import com.caishen91.jupiter.enums.CommonStatus;
import com.caishen91.jupiter.model.Blog;
import com.caishen91.jupiter.model.BlogManager;
import com.caishen91.jupiter.service.IBlogManagerService;
import com.caishen91.jupiter.util.BMLoginUtil;
import com.caishen91.jupiter.util.LoginUtil;
import com.caishen91.jupiter.util.StringUtil;

@Controller
@RequestMapping("/blog")
public class BMLoginController {
	
	@Autowired
	private IBlogManagerService blogService;

	@Autowired
	private IBlogManagerService blogManagerService;

	@GetMapping("/toLogin")
	public String loginPage() {
		
		return "../blogPlatform/login";
	}
	
	/**
	 * 	登出
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		LoginUtil.handleBlogLogout(request, response);
		return "redirect:/";
	}

	/**
	 *	公众号管理员登录
	 */
	@RequestMapping("/login")
	@ResponseBody
	public Map<String,Object> login(HttpServletRequest request, HttpServletResponse response){
		Map<String,Object> retMap = new HashMap<String,Object>(); {
			retMap.put(Config.RET, Config.RET_OK);
		}
		String username = request.getParameter("username");
		String passwd = request.getParameter("passwd");
		String pwd = StringUtil.MD5Encode(passwd);
		if (StringUtil.isEmpty(username)) {
			retMap.put(Config.RET, 0);
			retMap.put(Config.ERR_MSG, "用户名或手机号不能为空");
			return retMap;
		}
		if (StringUtil.isEmpty(pwd)) {
			retMap.put(Config.RET, 0);
			retMap.put(Config.ERR_MSG, "密码不可为空");
			return retMap;
		}

		BlogManager bm = null;
		try {
			bm = blogService.getBMByLoginNamePasswd(username, pwd);
		}catch (Exception e){
			e.printStackTrace();
		}
		if (bm != null) {
			Blog blog=blogManagerService.getBlogById(bm.getBlogId());
			if(blog.getAuthStatus() == BlogAuthStatus.UNCERTIFIED.getAuthCode()){
				retMap.put(Config.RET, 0);
				retMap.put(Config.ERR_MSG, "当前账号尚未认证");
				return retMap;
			}else if(blog.getStatus()==CommonStatus.unAvailable.getStatus()){
				retMap.put(Config.RET, 0);
				retMap.put(Config.ERR_MSG, "当前账号已被禁用");
				return retMap;
			}else{
				try {
					BMLoginUtil.handleSysLogin(request, response, bm);
				}catch (Exception e){
					e.printStackTrace();
				}
			}


		}else{
			retMap.put(Config.RET, 0);
			retMap.put(Config.ERR_MSG, "登录失败");
		}
		return retMap;
	}
}
