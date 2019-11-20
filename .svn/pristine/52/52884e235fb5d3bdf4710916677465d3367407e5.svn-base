<%@ page import="com.caishen91.jupiter.model.Blog" %>
<%@ page import="com.caishen91.jupiter.util.IDEncryptor" %>
<%@ page import="com.caishen91.jupiter.model.Article" %>
<%@ page import="com.caishen91.jupiter.util.DateUtil" %>
<%@ page import="com.caishen91.jupiter.model.ArticleType" %>
<%@ page import="com.caishen91.jupiter.model.BlogLabel" %>
<%@ page import="com.caishen91.jupiter.enums.BlogType" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%
    Blog blog=(Blog)request.getAttribute("blog");
    Article article =(Article)request.getAttribute("article");
    ArticleType articleType=(ArticleType)request.getAttribute("articleType");
    BlogLabel blogLabel=(BlogLabel)request.getAttribute("blogLabel");
%>
<html>
<head>
    <title>内容管理平台</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport">
    <link href="/css/blog/common.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
    <link href="/css/blog/jianrong.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
    <link href="/css/blog/article.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
</head>
<body class="bg">

<jsp:include page="/blogPlatform/common/top.jsp"/>
<jsp:include page="/blogPlatform/common/leftMenu.jsp"/>
<!--右侧内容 文章详情-->
<div id="mainbody" class="mainbody">

    <!--面包屑-->
    <div class="bigtitle mt20"><a href="javascript:void(0)" op="back" id="back" class="colgray02 colbule_hov transition">分享赚管理</a><span class="colgray04">&gt;</span>文章详情</div>
    <!--面包屑 end-->

    <div class="clearfix mt15 bgf radius3 shadow pd35 plr35">
        <div class="art_title ft24 fapf"><b><%=article!=null ? article.getTitle() : ""%></b></div>

        <div class="art_source">
            <dl class="fl">
                <dt class="fl"><img src="<%=blog!=null ? blog.getHeadImg() : "http://img.91caishen.com/source/images/contpla/icon/user_tx.png"%>"></dt>
                <dd class="ft16 fl"><%=blog!=null ? blog.getName() : ""%></dd>
            </dl>
            <ul class="clearfix contli fl">
                <li class="fadin colgray04"><em class="icon icon_date"></em><%=DateUtil.formatDate(article.getReleaseTime(), "yyyy-MM-dd")%>&nbsp;<%=DateUtil.formatDate(article.getReleaseTime(), "HH:mm")%></li>
                <li class="fadin colgray04"><em class="icon icon_read"></em><%=article!=null ? article.getReadCount() : "0"%></li>
                <li class="fadin colgray04"><em class="icon icon_coll"></em><%=article!=null ? article.getCollecCount() : "0"%></li>
                <li class="fadin colgray04"><em class="icon icon_forw"></em><%=article!=null ? article.getForwardCount() : "0"%></li>
            </ul>
        </div>

        <div class="artcile_det clearfix pd20 plr35">
            <%=article!=null ? article.getContent() : "暂无内容"%>
           <%-- <p>FX168财经报社(香港)讯 周二（4月16日）亚市午后，欧元/美元位于1.1305附近水平徘徊。上一交易日汇价先温和走高至1.1321，之后自该点展开震荡回撤，当日以线略微收跌。本交易日目前来看，汇价继续呈现震荡整理格局。</p>
            <p>周二将公布德国4月ZEW调查，预计德国和欧元区经济景气指数将改善。欧元区将公布2月建筑业产出，而美国将公布3月产能利用率和工业产出，预计较上个月变化不大。</p>
            <p>英欧双方同意将英国脱欧期限延长至10月31日，英国无协议退欧的威胁暂时解除了。这对英国的资本市场并没有实质性的利好和提升。下图是上周迎来脱欧延期"利好"背景下，英国UK100指数和英镑/美元走势图，从图表中可清晰的看到资本市场对于脱欧延期没有"兴趣"，多头和空头双双缺乏做多/空动力。</p>
            <p>那么平台的发展需要出现这么几个点，最初时购买或者使用我们产品，我们称为"创新者"，他们往往就有很强的冒险精神，可承受较大的风险，然而这也是我们最初的用户，为第一群体</p>
            <p><img src="http://img.91caishen.com/source/images/contpla/img/img01.jpg"></p>
            <p>FX168财经报社(香港)讯 周二（4月16日）亚市午后，欧元/美元位于1.1305附近水平徘徊。上一交易日汇价先温和走高至1.1321，之后自该点展开震荡回撤，当日以线略微收跌。本交易日目前来看，汇价继续呈现震荡整理格局。</p>
            <p>英欧双方同意将英国脱欧期限延长至10月31日，英国无协议退欧的威胁暂时解除了。这对英国的资本市场并没有实质性的利好和提升。下图是上周迎来脱欧延期"利好"背景下，英国UK100指数和英镑/美元走势图，从图表中可清晰的看到资本市场对于脱欧延期没有"兴趣"，多头和空头双双缺乏做多/空动力。</p>
            <p>那么平台的发展需要出现这么几个点，最初时购买或者使用我们产品，我们称为"创新者"，他们往往就有很强的冒险精神，可承受较大的风险，然而这也是我们最初的用户，为第一群体</p>--%>
        </div>

        <div class="art_label pd10 clearfix">
            <div class="screen_inp mt10">
                <span class="fl ft14 colgray02">文章类型：</span>
                <span class="ft14 colgblock"><%=articleType!=null ? articleType.getName() : ""%></span>
            </div>
            <%if(blog.getType()== BlogType.COMPANY.getType()){%>
            <div class="screen_inp mt10">
                <span class="fl ft14 colgray02">文章栏目：</span>
                <span class="ft14 colgblock"><%=blogLabel!=null ? blogLabel.getName() : ""%></span>
            </div>
            <%}%>

            <div class="screen_inp mt10" style="height:122px">
                <span class="fl ft14 colgray02">文章首图：</span>
                <div class="fl rel_cover radius5 ovet"><img src="<%=article!=null ? article.getThumb() : "http://img.91caishen.com/source/images/contpla/img/img03.jpg"%>"></div>
            </div>
        </div>
    </div>


    <!--公用底部-->
    <div id="footer" class="footer textcent ft12 clearfix">
        <a href="#" class="ft14 colbule_hov transition">关于91财经</a>|<a href="#" class="ft14 colbule_hov transition">服务协议</a>|<a href="#" class="ft14 colbule_hov transition">联系邮箱</a>|<a href="#" class="ft14 colbule_hov transition">联系电话</a>
        <span class="ft14">Copyright © 2018-2019 91Caijing  All Rights Reserved</span>
    </div>
    <!--公用底部 end-->

</div>
<!--右侧内容   文章详情 end-->

</body>
<script>
	$(function(){
		$("#share").addClass("menuli_in");
		$(".menu_home").removeClass("menu_home_in");
	})
    $("a[op=back]").click(function(){
        window.history.back();
    });
</script>
</html>
