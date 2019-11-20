<%@ page import="com.caishen91.jupiter.model.Notice" %>
<%@ page import="com.caishen91.jupiter.util.DateUtil" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%
    Notice notice=(Notice)request.getAttribute("notice");
%>
<html>
<head>
    <title>内容管理平台</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport">
    <link href="/css/manager/home/components.css" rel="stylesheet" type="text/css">
    <link href="/css/blog/common.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
    <link href="/css/blog/article.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
    <link href="/css/blog/jianrong.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">

</head>

<body  class="page-header-fixed page-sidebar-closed-hide-logo page-content-white" style="background-color:#fff">
<div style="min-height:800px">
	<div class="portlet box blue ">
		<div class="portlet-title">
			<div class="caption colf"><a href="/manager/console/outline" class="colf">&nbsp;概要</a><span class="colf">&nbsp;&gt;&nbsp;</span>公告详情</div>
		</div>

<!--右侧内容 文章详情-->
<%--<div id="mainbody" class="mainbody">--%>

    <div class="portlet-body">
    <div class="clearfix bgf radius3 pd35 plr35" style="padding-top;10px">
        <div class="art_title ft24 fapf"><b><%=notice!=null ? notice.getTitle() : ""%> </b></div>

        <div class="art_source" style="padding-bottom:0">
            <ul class="clearfix contli fl" style="margin:0">
                <li class="fadin colgray04"><em class="icon icon_date"></em><%=DateUtil.formatDate(notice.getReleaseTime(), "yyyy-MM-dd ")%> &nbsp; <%=DateUtil.formatDate(notice.getReleaseTime(), "HH:mm")%></li>
            </ul>
        </div>

        <div class="artcile_det clearfix pd20 plr15 noticedet">
            <%=notice!=null ? notice.getContent() : ""%>
           <%-- <p>FX168财经报社(香港)讯 周二（4月16日）亚市午后，欧元/美元位于1.1305附近水平徘徊。上一交易日汇价先温和走高至1.1321，之后自该点展开震荡回撤，当日以线略微收跌。本交易日目前来看，汇价继续呈现震荡整理格局。</p>
            <p>周二将公布德国4月ZEW调查，预计德国和欧元区经济景气指数将改善。欧元区将公布2月建筑业产出，而美国将公布3月产能利用率和工业产出，预计较上个月变化不大。</p>
            <p>英欧双方同意将英国脱欧期限延长至10月31日，英国无协议退欧的威胁暂时解除了。这对英国的资本市场并没有实质性的利好和提升。下图是上周迎来脱欧延期"利好"背景下，英国UK100指数和英镑/美元走势图，从图表中可清晰的看到资本市场对于脱欧延期没有"兴趣"，多头和空头双双缺乏做多/空动力。</p>
            <p>那么平台的发展需要出现这么几个点，最初时购买或者使用我们产品，我们称为"创新者"，他们往往就有很强的冒险精神，可承受较大的风险，然而这也是我们最初的用户，为第一群体</p>
            <p>那么平台的发展需要出现这么几个点，最初时购买或者使用我们产品，我们称为"创新者"，他们往往就有很强的冒险精神，可承受较大的风险，然而这也是我们最初的用户，为第一群体</p>--%>
        </div>
    </div>
</div>
<!--右侧内容   文章详情 end-->
</div>
</div>
<jsp:include page="/common/baseJs.jsp"></jsp:include>
</body>
<script>

    $("a[op=back]").click(function(){

        window.history.back();
    });
</script>


</html>


