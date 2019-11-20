package com.caishen91.jupiter.controller.manager;

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
import com.caishen91.jupiter.model.SysUser;
import com.caishen91.jupiter.service.ISysUserService;
import com.caishen91.jupiter.util.LoginUtil;
import com.caishen91.jupiter.util.StringUtil;

@Controller
@RequestMapping("/manager")
public class LoginController {
	
	@Autowired
	private ISysUserService sysUserService;

	@GetMapping("/toLogin")
	public String loginPage(HttpServletResponse response) {
		response.setHeader("X-Frame-Options", "SAMEORIGIN");
		return "../managers/login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		LoginUtil.handleSysLogout(request, response);
		return "redirect:/";
	}

	/**
	 * 用户登录
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
		SysUser sysUser = null;
		try {
			sysUser = sysUserService.getUserByLoginNamePasswd(username, pwd);
		}catch (Exception e){
			e.printStackTrace();
		}
		if (sysUser != null) {
			try {
				LoginUtil.handleSysLogin(request, response, sysUser);
			}catch (Exception e){
				e.printStackTrace();
			}
		} else {
			retMap.put(Config.RET, 0);
			retMap.put(Config.ERR_MSG, "登录失败");
		}
		return retMap;
	}
}
