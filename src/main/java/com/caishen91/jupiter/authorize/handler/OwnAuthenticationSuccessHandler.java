package com.caishen91.jupiter.authorize.handler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.caishen91.jupiter.authorize.enums.ResultEnums;
import com.caishen91.jupiter.authorize.model.AdminDetailsModel;
import com.caishen91.jupiter.authorize.model.BlogManagerDetailsModel;
import com.caishen91.jupiter.authorize.util.ResultUtil;
import com.caishen91.jupiter.config.Config;
import com.caishen91.jupiter.model.BlogMenuTree;
import com.caishen91.jupiter.service.IBlogPermitService;
import com.caishen91.jupiter.util.HtmlUtil;
import com.caishen91.jupiter.util.IDEncryptor;
import com.caishen91.jupiter.util.StringUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component(value = "ownAuthenticationSuccessHandler")
public class OwnAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	private static Logger log = LoggerFactory.getLogger(OwnAuthenticationSuccessHandler.class);
	/**
	 * 将Authentication转换成json的工具类
	 */
	@Autowired
	private ObjectMapper objMapper;
	
	@Autowired
	private IBlogPermitService blogPermitService;
	
	/**
	 * param : Authentication【封装的认证信息】
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		
		String domain = HtmlUtil.getDomain(request);
		if (Config.DEBT_DOMAIN.equals(domain)) {//后台管理
			
			if(authentication.getPrincipal() instanceof BlogManagerDetailsModel) {
				SecurityContextHolder.clearContext();
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
				response.setContentType("apllication/json;charset=UTF-8");
				response.getWriter().write(objMapper.writeValueAsString(ResultUtil.error(ResultEnums.USER_NOT_EXISTS.getCode(),ResultEnums.USER_NOT_EXISTS.getMsg())));
				return;
			}
			response.setContentType("apllication/json;charset=UTF-8");
			response.getWriter().write(objMapper.writeValueAsString(ResultUtil.success(authentication)));
		} else if(Config.BM_DOMAIN.equals(domain)) {
			
			if(authentication.getPrincipal() instanceof AdminDetailsModel) {
				SecurityContextHolder.clearContext();
				response.setStatus(HttpServletResponse.SC_NOT_FOUND);
				response.setContentType("apllication/json;charset=UTF-8");
				response.getWriter().write(objMapper.writeValueAsString(ResultUtil.error(ResultEnums.USER_NOT_EXISTS.getCode(),ResultEnums.USER_NOT_EXISTS.getMsg())));
				return;
			}
			
			/**
			 * 	查询出该认证账户所拥有的权限，然后返回第一个url
			 * 	seq排序
			 */
			BlogManagerDetailsModel bmd = (BlogManagerDetailsModel) authentication.getPrincipal();
			int bmId = IDEncryptor.getInstance().decryptWithoutException(bmd.getId());
			int blogId = IDEncryptor.getInstance().decryptWithoutException(bmd.getBlogId());
			List<BlogMenuTree> menuTree = blogPermitService.getMenu(blogId,bmId);
			if(menuTree != null && menuTree.size() > 0) {
				String redirectUrl = null;
				for (BlogMenuTree blogMenuTree : menuTree) {
					if(!StringUtil.isEmpty(blogMenuTree.getUrl())) {
						redirectUrl = blogMenuTree.getUrl();
						break;
					} else if(blogMenuTree.getChildren() != null && blogMenuTree.getChildren().size() > 0) {
						redirectUrl = child((List<BlogMenuTree>) blogMenuTree.getChildren());
						break;
					}
				}
				if(redirectUrl == null) {
					response.setStatus(HttpServletResponse.SC_FORBIDDEN);
					response.setContentType("apllication/json;charset=UTF-8");
					response.getWriter().write(objMapper.writeValueAsString(ResultUtil.error(ResultEnums.UNAUTHORIZED_ACCESS.getCode(),ResultEnums.UNAUTHORIZED_ACCESS.getMsg())));
				} else {
					response.setContentType("apllication/json;charset=UTF-8");
					response.getWriter().write(objMapper.writeValueAsString(ResultUtil.success(redirectUrl)));
				}
			} else {
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				response.setContentType("apllication/json;charset=UTF-8");
				response.getWriter().write(objMapper.writeValueAsString(ResultUtil.error(ResultEnums.UNAUTHORIZED_ACCESS.getCode(),ResultEnums.UNAUTHORIZED_ACCESS.getMsg())));
			}
			log.info("login success");
		}
	}

	private String child(List<BlogMenuTree> children) {
		String url = null;
		for (BlogMenuTree baseAuthTree : children) {
			if(!StringUtil.isEmpty(baseAuthTree.getUrl())) {
				url = baseAuthTree.getUrl();
				break;
			} else if(baseAuthTree.getChildren() != null && baseAuthTree.getChildren().size() > 0) {
				url = child((List<BlogMenuTree>) baseAuthTree.getChildren());
			}
		}
		return url;
	}

}
