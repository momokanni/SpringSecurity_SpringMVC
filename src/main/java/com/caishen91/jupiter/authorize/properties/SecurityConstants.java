package com.caishen91.jupiter.authorize.properties;

public interface SecurityConstants {

	/**
	 *	默认的用户名密码登录请求处理url
	 */
	String DEFAULT_LOGIN_PROCESSING_URL_FORM = "/auth/form";
	/**
	 * 	商户端登录处理路径
	 */
	String BLOG_LOGIN_PROCESSING_URL_FORM = "/auth/blogForm";
	/**
	 * 	系统管理创建管理员登录账号前缀
	 */
	String SYSTEM_ADMINISTRATOR_PREFIX = "bm_";
	/**
	 * 	暴露给小油菜获取文章详情接口
	 */
	String XYC_GET_SHARE_ARTICLE = "/blog/article/getArticle";
	/**
	 * 	聚合平台：同步JH_SYN_NRPT_ROLE系统角色
	 */
	String JH_SYN_NRPT_ROLE = "/manager/grapes/api/vi/syncSystemInfo";
	/**
	 * 	聚合平台：创建系统管理员
	 */
	String JH_ADD_SYS_USER = "/manager/grapes/api/vi/addSysUser";
	/**
	 * 	聚合平台：修改系统管理员
	 */
	String JH_MODIFY_SYS_USER = "/manager/grapes/api/vi/modifySysUser";
	/**
	 * 	聚合平台： 快速登录
	 */
	String JH_QUICK_LOGIN  = "/manager/grapes/api/vi/quickLogin";
	/**
	 * 	聚合平台：设置用户
	 */
	String JH_SET_SYS_USER_STATUS = "/manager/grapes/api/vi/setSysUserStatus";
}
