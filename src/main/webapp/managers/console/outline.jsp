<%@page import="java.math.BigDecimal"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.caishen91.jupiter.config.Config" %>
<%@ page import="com.caishen91.jupiter.model.Notice" %>
<%@ page import="com.caishen91.jupiter.util.IDEncryptor" %>
<%@ page import="com.caishen91.jupiter.util.DateUtil" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ page isELIgnored="true" %>

<%

    Integer articleYesterdayCount = (Integer) request.getAttribute("articleYesterdayCount");
	Integer articleCount = (Integer) request.getAttribute("articleCount");

	Integer AccountYesterdayCount = (Integer) request.getAttribute("AccountYesterdayCount");
	Integer AccountCount = (Integer) request.getAttribute("AccountCount");
	Notice notice=(Notice)request.getAttribute("notice");
	String noticeId = null;
	if(notice != null){
		noticeId= IDEncryptor.getInstance().encryptWithoutException(notice.getId());
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>概要</title>
<jsp:include page="/common/baseCss.jsp"></jsp:include>
<link href="/css/TableList.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
<link href="/css/newstyle.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
<style type="text/css">
#queryTable td{
color:black
}
#queryTable input {
display:inherit
}
 .nw_dlg{
	border: 3px solid #3598dc;
	box-shadow: 0 0 8px #3598dc
 }
 tr td{
 	height:45px;
 }


</style>
<script>
	var newUI = true;
</script>
</head>
<body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white" style="background-color:#fff">
<div  style="min-height:800px">
	<div class="portlet box blue ">
		<div class="portlet-title">
			<div class="caption">&nbsp;概要</div>
		</div>
		
		<div class="portlet-body"> 
			<form id="query_form" action="">
				<input type="hidden" id="repayStatus" name="repayStatus" value="0">
                <input type="hidden" id="outline" name="outline" value="1">
			</form>

<style>
	/* 通知 */
	.icon{ background:url(http://img.91caishen.com/source/images/contpla/icon/icon_new.png);}
	.home_notice{ height:40px; line-height:40px}
	.home_notice .icon_notice{ background-position:-30px -32px; width:30px; height:30px; margin-top:5px; margin-right:10px}
	.home_notice .notice_cont{ font-weight:600; width:88%}
	.home_notice .notice_cont span{ font-weight:normal; display:inline-block; margin-left:12px}

	.colgray{ color:#94969b}/*三级色*/
	.colgblock{ color:#2d3036}/*一级色*/
	.colblue02{ color:#559df7}/*蓝色 浅一点*/
	.colbule_hov:hover{ color:#418aec}

	/*标签icon*/
	.more{ height:14px; line-height:14px; position:absolute; right:0; top:50%; margin-top:-7px}
	.more em{ display:inline-block; background-position:0 -86px; width:14px; height:14px; float:right}
	.more:hover em{ background-position:-78px -86px}
</style>

			<div class="home_notice pr">
				<em class="icon fl icon_notice"></em>
				<%if(notice != null){%>
					<a href="/manager/console/noticeDetail?id=<%=noticeId%>" class="colbule_hov ft16 colgblock fl notice_cont">
						<span class="fr colgray ft14"><%=notice != null ? DateUtil.formatDate(notice.getReleaseTime(), "yyyy-MM-dd HH:mm:ss") : ""%></span>
						<b class="fapf"><%=notice != null ? notice.getTitle() : "暂无公告"%></b>
					</a>
					<a href="/manager/console/noticeList?" class="more ft14 colblue02 colbule_hov">更多<em class="icon"></em></a>
				<%} else {%>
					<a href="javascript:void(0);" class="colbule_hov ft16 colgblock fl notice_cont">
						<span class="fr colgray ft14"><%=notice != null ? DateUtil.formatDate(notice.getReleaseTime(), "yyyy-MM-dd HH:mm:ss") : ""%></span>
						<b class="fapf"><%=notice != null ? notice.getTitle() : "暂无公告"%></b>
					</a>
				<%}%>	
			</div>

			<div class="row widget-row mt20">
				<div class="col-md-3">
					<div class="widget-thumb widget-bg-color-white text-uppercase margin-bottom-20 bordered">
						<h4 class="widget-thumb-heading">昨日发文量</h4>
						<div class="widget-thumb-wrap">
							<div class="widget-thumb-body">
								<span class="widget-thumb-body-stat"><%=articleYesterdayCount%>篇</span>
								<span class="widget-thumb-subtitle" style="font-size:11px"></span>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="widget-thumb widget-bg-color-white text-uppercase margin-bottom-20 bordered">
						<h4 class="widget-thumb-heading">总发文量</h4>
						<div class="widget-thumb-wrap">
							<div class="widget-thumb-body">
								<span class="widget-thumb-body-stat"><%=articleCount%>篇</span>
								<span class="widget-thumb-subtitle" style="font-size:11px"></span>
							</div>
						</div>
					</div>
				</div>


				<div class="col-md-3">
					<div class="widget-thumb widget-bg-color-white text-uppercase margin-bottom-20 bordered">
						<h4 class="widget-thumb-heading">昨日申请账号数</h4>
						<div class="widget-thumb-wrap">
							<div class="widget-thumb-body">
								<span class="widget-thumb-body-stat"><%=AccountYesterdayCount%>个</span>
								<span class="widget-thumb-subtitle" style="font-size:11px"></span>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="widget-thumb widget-bg-color-white text-uppercase margin-bottom-20 bordered">
						<h4 class="widget-thumb-heading">总用户数</h4>
						<div class="widget-thumb-wrap">
							<div class="widget-thumb-body">
								<span class="widget-thumb-body-stat"><%=AccountCount%>人</span>
								<span class="widget-thumb-subtitle" style="font-size:11px"></span>
							</div>
						</div>
					</div>
				</div>

			</div>

			</div>


  		




 	</div>
</div>
</div>

<jsp:include page="/common/baseJs.jsp"></jsp:include>

<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/common.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/dlgEx.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js?<%@include file='/include/.ver'%>"></script> 
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/querytable.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/TableListEx.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/jquery.pager.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/jquery.tmpl.js?<%@include file='/include/.ver'%>"></script>

<script type="text/javascript">

</script>
</body>
</html>
