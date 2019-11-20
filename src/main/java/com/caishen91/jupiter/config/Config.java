package com.caishen91.jupiter.config;

import java.util.List;

import com.caishen91.jupiter.util.GlobalProperties;

public class Config {
	public final static String ERR_MSG = "errmsg";
	public final static String MESSAGE = "message";
	public final static String ERR_CODE = "errcode";
	public final static String RET_DATA = "data";
	public final static String RET = "ret";
	public final static int RET_OK = 1;
	public final static int RET_ERROR = 0;
	public final static int RET_EXCEPTION = 2;
	
	public final static int EDITOR_OK = 0;
	public final static int EDITOR_ERROR = 1;
	public final static String EDITOR_CODE = "errno";
	
	public final static String DEFAULT_PASSWORD = "888888";


	public final static String FRONT_PREFIX = GlobalProperties.getProperty("front.prefix");

	public final static boolean DEBUG = GlobalProperties.getBooleanItem("debug", false);
	
	public final static String DOMAIN = GlobalProperties.getProperty("domain");
	
	public final static String ICP = "京ICP备14018507号-2";
	
	public final static	String DEBT_DOMAIN = GlobalProperties.getProperty("debt.domain");
	
	public final static String WAP_DOMAIN = GlobalProperties.getProperty("wap.domain");
	
	public final static String BM_DOMAIN = GlobalProperties.getProperty("bm.domain");

	public final static String WX_DOMAIN = GlobalProperties.getProperty("wx.domain"); //微信域
	
	public final static String IMAGE_SERVER = GlobalProperties.getProperty("image.upload.server") + "/imgs/";

	public final static String IMAGE_UPLOAD_PATH = GlobalProperties.getProperty("image.upload.path");
	
	public final static String IMAGE_UPLOAD_SIZE = GlobalProperties.getProperty("image.upload.size");
	
	public final static String IMAGE_UPLOAD_SERVER = GlobalProperties.getProperty("image.upload.server");
	
	public final static String IMAGE_DISPLAY_PATH = GlobalProperties.getProperty("image.display.path");
	
	public final static String IMAGE_WELCOME_BG = GlobalProperties.getProperty("image.welcome.bg");
	
	public final static String SMS_SIGN = "【】";
	
	public final static String SMS_CL_YZM_ACCOUNT = GlobalProperties.getProperty("sms.cl.yzm.account");
	
	public final static String SMS_CL_YZM_PWD = GlobalProperties.getProperty("sms.cl.yzm.pwd");
	
	public final static int SMS_CODE_PREDAY = 100;
	
	public final static int MOBILE_IP_AVAILABLE_PREDAY = 300; //每个ip每天能够查询手机是否存在次数
	
	public final static int MOBILE_MACHINE_AVAILABLE_PREDAY = 150; //每个机器每天能够查询手机是否存在次数
	
	public final static List<String> SMS_ALARM_MOBILE = GlobalProperties.getListItem("sms.alarm.mobile");
	
	public final static String EXCEL_FILE_PATH = GlobalProperties.getProperty("excel.file.path");
	
	/**
	 * 	避免被拦截静态资源路径
	 */
	public final static String STATIC_AVOID_PATH = GlobalProperties.getProperty("static.avoid.path");
	/**
	 * 	商户端请求路径头部
	 */
	public final static String BM_DOMAIN_REQUEST_START_CODE = GlobalProperties.getProperty("bm.domain.request.start.code");
	/**
	 * 	商户端登录页面URL
	 */
	public final static String BM_DOMAIN_LOGIN = GlobalProperties.getProperty("bm.domain.login.path");
	/**
	 * 	商户端退出跳转路径
	 */
	public final static String BM_LOGINOUT_SUCCESS_URL = GlobalProperties.getProperty("bm.logout.success.url");
	/**
	 * 	商户端登录成功后路径
	 */
	public final static String BM_DOMAIN_LOGIN_SUCCESS_URL = GlobalProperties.getProperty("bm.domain.login.success.url");
	/**
	 * 	系统管理请求路径头部
	 */
	public final static String DEBT_DOMAIN_REQUEST_START_CODE = GlobalProperties.getProperty("debt.domain.request.start.code");
	/**
	 * 	系统管理登录页面URL
	 */
	public final static String DEBT_DOMAIN_LOGIN = GlobalProperties.getProperty("debt.domain.login.path");
	/**
	 * 	系统管理退出成功后跳转路径
	 */
	public final static String DEBT_LOGINOUT_SUCCESS_URL = GlobalProperties.getProperty("debt.logout.success.url");
	/**
	 * 	系统管理登录成功后路径
	 */
	public final static String DEBT_DOMAIN_LOGIN_SUCCESS_URL = GlobalProperties.getProperty("debt.domain.login.success.url");
	/**
	 * 	移动端首页路径
	 */
	public final static String WAP_DOMAIN_INDEX_URL = GlobalProperties.getProperty("wap.domain.index.url");
	
	public final static int TOKEN_VALIDITY_SECONDS = GlobalProperties.getIntProperty("token.validity.seconds",0);
	
	/**
	 * 	小油菜推送文章栏目接口路径
	 */
	public static final String SHARE_TYPE_URL = GlobalProperties.getProperty("fxz.share.type.url");
	/**
	 * 	小油菜文章添加分享赚接口
	 */
	public static final String SHARE_ARTICLE_URL = GlobalProperties.getProperty("fxz.share.article.url");
	/**
	 * 	小油菜推送来源头像
	 */
	public static final String SHARE_SOURCE_URL = GlobalProperties.getProperty("fxz.share.source.url");
	/**
	 * 	聚合平台密钥
	 */
	public static final String GRAPES_KEY = GlobalProperties.getProperty("grapes.key");
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		for(String m: TRANSFER_ALARM_MOBILES) {
//			System.out.println(m);
//		}
	}

}
