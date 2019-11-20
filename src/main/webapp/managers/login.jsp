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
<title>内容管理后台</title>
<jsp:include page="/common/baseCss.jsp"></jsp:include>
<link href="/css/manager/home/login.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css" /> 
</head>
<body class="login">
<div class="logo">
<a href="/">
      <img src="/images/manager/nrlogo.png" />
    <%--<h2 class="form-title font-yellow">银川产权交易中心后台</h2>--%>
</a>
</div>

<div class="content">
            <form class="login-form" action="/auth/form" method="post" >
                <h3 class="form-title font-green">登录</h3>
                <div class="alert alert-danger display-hide">
                    <button class="close" data-close="alert"></button>
                    <span> Enter any username and password. </span>
                </div>
                <div class="form-group">
                    <input class="form-control form-control-solid placeholder-no-fix" autocomplete="off" placeholder="用户名" name="username" id="username" type="text" /> 
                </div>
                <div class="form-group">
                    <input class="form-control form-control-solid placeholder-no-fix" autocomplete="off" placeholder="密码" name="password" id="passwd" type="password"/> 
                </div>
                <div class="form-actions">
                    <button type="button" id="lgnBtn" class="btn green uppercase">登录</button>
                    <label class="rememberme check mt-checkbox mt-checkbox-outline">
                        <input name="remember-me" value="1" type="checkbox" />记住我
                        <span></span>
                    </label>
                </div>
            </form>
        </div>
<jsp:include page="/common/baseJs.jsp"></jsp:include>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/common.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/manager/login.js?<%@include file='/include/.ver'%>"></script>
<script language="JavaScript"> 
  if (window != top) 
    top.location.href = location.href; 
</script>
</body>
</html>

				