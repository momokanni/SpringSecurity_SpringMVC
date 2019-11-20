<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.List"%>
<%@ page import="com.caishen91.jupiter.config.Config" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="robots" content="nofollow" />
<title>内容管理平台</title>
<jsp:include page="/blogPlatform/common/baseCss.jsp"></jsp:include>
<link href="/css/blog/login.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css" /> 
</head>
<body style=" background:#408ffb">
	<div class="loginbody"></div>
	<div class="login_logo">
		<img src="http://img.91caishen.com/source/images/contpla/img/login_logo.png" />
	</div>
	<div class="login pr content">
		<form class="login-form" id="frm" action="/auth/blogForm" method="post" >
	    	<h3 class="ft30 colblue fapf"><b>登录</b></h3>
	        <div class="login_inp mt25">
	        	<em class="icon_login login_name fl"></em>
	            <em class="login_bar fl"></em>
	        	<input type="text" placeholder="手机号/账号"  class="fr" name="username" id="username"/>
	        </div>        
	         <div class="login_inp mt20">
	        	<em class="icon_login login_pass fl"></em>
	            <em class="login_bar fl"></em>
	        	<input type="password" placeholder="密码"  class="fr" name="password" id="passwd" />
	        </div>
	        <div class="mt10">
	        	<label id="rememberLabel" for="logincheck" class="label label_checkbox check_in"><!--选中check_in-->
					<input type="checkbox" id="logincheck" name="remember-me" checked />
					<span>记住我</span>
				</label>
	        </div>
	        
	        <div class="login_btn"><a id="lgnBtn" op="lgnBtn" href="javascript:void(0)" class="button colf shadow_red shadingred ft18">登录</a></div>
        </form>
        <!--错误提示-->
        <div class="login_error colf ft16 dn">手机号错误</div>
    </div>
<script type="text/javascript" src="/js/jquery-1.10.1.min.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/common.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/blogPlatform/login.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/blogPlatform/toast.js?<%@include file='/include/.ver'%>"></script>
</body>
</html>

				