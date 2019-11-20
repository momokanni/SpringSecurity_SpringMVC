<%@page import="com.caishen91.jupiter.vo.BlogDetailVO"%>
<%@page import="java.math.BigDecimal"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.caishen91.jupiter.model.*,com.caishen91.jupiter.util.*,com.caishen91.jupiter.enums.*"%>
<%@ page import="com.caishen91.jupiter.config.Config" %>
<%@ page isELIgnored="true" %>

<%
	BlogDetailVO blog = (BlogDetailVO) request.getAttribute("blog");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>公众号详情</title>

<jsp:include page="/common/baseCss.jsp"></jsp:include>

    <link rel="stylesheet" href="/front/styles/<%=Config.FRONT_PREFIX%>/qsuggest.css?<%@include file='/include/.ver'%>" />
    <link href="/css/newstyle.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
<script>
    var time_stamp = '<%@include file='/include/.ver'%>';
    var newUI = true;
</script>
    <style type="text/css">
        .static-info {
            margin-bottom: 0px;
        }
    </style>

</head>
<body  class="page-header-fixed page-sidebar-closed-hide-logo page-content-white" style="background-color:#fff">
<div id="modelDv">
</div>
	<div class="portlet box blue">
		<div class="portlet-title">
			<div class="caption">
				&nbsp;公众号详情</div>
			<div class="tools">
				<a href="javascript:;" class="collapse" data-original-title="" title=""></a>
				<a href="#portlet-config" data-toggle="modal" class="config" data-original-title="" title=""> </a>
			</div>
		</div>
		<div class="portlet-body">

            <jsp:include page="/managers/blog/blogTab.jsp">
                <jsp:param value="base" name="tab" />
            </jsp:include>
			<style>
			.table>tbody>tr>td{ padding:12px 15px}
			</style>
	        <form action="/manager/product/motifyProduct" method="post" id="frm">
	        
		        <table class="table_show table table-striped table-bordered table-hover mt20 productnew" rules="none" id="queryTable" style="width: 100%; border: 0px" cellspacing="0" cellpadding="0">
					<tbody>
						<tr>
							<td><span>公众号名称：</span><b><%=StringUtil.isNotEmpty(blog.getBlogName())? blog.getBlogName():""%></b></td>
							<td><span>头像：</span><b><image style="width:50px;height:50px; border-radius:50px" src="<%=StringUtil.isNotEmpty(blog.getHeadImg())? blog.getHeadImg():"http://img.91caishen.com/source/images/contpla/icon/user_tx.png" %>"/></b></td>
							<td></td>
						</tr>
						<tr>
							<td><span>公众号描述：</span><b><%=StringUtil.isNotEmpty(blog.getDesc())? blog.getDesc():""%></b></td>
							<td><span>认证情况：</span><b><%=BlogAuthStatus.getBlogAuthStatus(blog.getAuthStatus()).getMsg()%></b></td>
							<td></td>
						</tr>
						<% if(blog.getType() == BlogType.COMPANY.getType()){ %>
						<tr>
							<td><span>企业名称：</span><b><%=StringUtil.isNotEmpty(blog.getEnterpriseName())? blog.getEnterpriseName():""%></b></td>
							<td><span>企业类型：</span><b><%=EnterpriseType.getEnterpriseType(blog.getEnterpriseType()).getMsg()%></b></td>
							<td><span>企业邮箱：</span><b><%=StringUtil.isNotEmpty(blog.getEmail())? blog.getEmail():""%></b></td>
							
						</tr>
						<tr>
							<td><span>社会信用代码：</span><b><%=StringUtil.isNotEmpty(blog.getScc())? blog.getScc():""%></b></td>
							<td></td>
							<td></td>
						</tr>
						<% } %>
						<tr>
							<td><span>管理员：</span><b><%=StringUtil.isNotEmpty(blog.getBlogManagerName())? blog.getBlogManagerName():""%></b></td>
							<td><span>昵称：</span><b><%=StringUtil.isNotEmpty(blog.getNickName())? blog.getNickName():""%></b></td>
							<td><span>联系方式：</span><b><%=StringUtil.isNotEmpty(blog.getMobile())? blog.getMobile():""%></b></td>
						</tr>
					</tbody>
				</table>
	
				<table class="table" rules="none" id="queryTable" style="width: 100%; border: 0px" cellspacing="0" cellpadding="0">
					<tbody>
						 <tr>
		                    <td width="25%" style="border:0"></td>
		                    <td width="25%" align="right" style="border:0">
		                       <% if(blog.getAuthStatus() == BlogAuthStatus.CERTIFIED.getAuthCode()){ %>
		                        	<a href="/manager/blog/toBlogSigning" id="back" class="btn btn-lg grey">返回</a>
		                       <% } else { %>
		                       		<a href="/manager/blog/toBlogUnSign" id="back" class="btn btn-lg grey">返回</a>
		                       <% } %>
		                    </td>
		                    <td width="25%" align="left" style="border:0">
		
		                    </td>
		                    <td width="25%" style="border:0"></td>
		                    <td width="25%" style="border:0"></td>
		                </tr>
	                </tbody>
	            </table>
	        </form>
		</div>
	</div>
</body>
<jsp:include page="/common/baseJs.jsp"></jsp:include>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/common.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX%>/common/jquery.qsuggest.js?<%@include file='/include/.ver'%>"></script>
</html>
