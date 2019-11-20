<%@ page import="java.util.Map" %>
<%@ page import="com.caishen91.jupiter.model.Article" %>
<%@ page import="com.caishen91.jupiter.model.ArticleCollection" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.caishen91.jupiter.util.DateUtil" %>
<%@ page import="com.caishen91.jupiter.model.Blog" %>
<%@ page import="com.caishen91.jupiter.util.IDEncryptor" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%
    List<ArticleCollection> articleCollections=(List<ArticleCollection> )request.getAttribute("articleCollections");
    Map map=(Map)request.getAttribute("map");
    Map blogMap=(Map)request.getAttribute("blogMap");
    //获取到移动端用户Id
    String userId=(String)request.getAttribute("userId");
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=1.0, user-scalable=yes" />
    <meta name = "format-detection" content="telephone = no" />
    <title>收藏</title>
    <link href="/css/mobile/common.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
    <link href="/css/mobile/art_list.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
</head>

<body>
<!--头部-->
<div class="header widbig"><!--需判断topnav_ios-->
    <h3 class="col4 ft18">收藏</h3>
    <div class="navback">
        <a href="#"><img src="http://img.91caishen.com/source/images/contpla/app/nav_back.png"></a>
    </div>
</div>
<div style="width:100%; height:45px;"></div>
<!--头部 end-->


<!--文章-->
<%if(articleCollections.size()>=1){%>
<div class="clearfix widbig bgff colbox" style="padding-top:5px;border-top:1px solid #f7f7f7">
    <%

      for(ArticleCollection articleCollection :articleCollections){

          Article article=(Article) map.get(articleCollection.getId());
          String encId = IDEncryptor.getInstance().encryptWithoutException(article.getId());
          Blog blog=(Blog)blogMap.get(articleCollection.getId());
          //处理时间
          String res=null;
          Date date=new Date();
          String dateStr= DateUtil.formatDate(date, "yyyy");
          String releaseTimeStr=DateUtil.formatDate(article.getReleaseTime(), "yyyy");
          if(article.getReleaseTime()!=null){
              long differenceValue = new Date().getTime() - article.getReleaseTime().getTime();
              if(differenceValue<60000){
                  res ="刚刚";
              }else if(differenceValue<3600000){
                  res = (differenceValue / 1000 / 60 ) + "分钟前";
              }else if(differenceValue > 3600000&&differenceValue < 3600000*24){
                  res = (differenceValue / 1000 / 60 / 60 ) + "小时前";
              }else if(differenceValue>3600000*24&&differenceValue<3600000*24*3){
                  res = (differenceValue / 1000 / 60 / 60/ 24 ) + "天前";
              }else if(differenceValue>3600000*24*3&&releaseTimeStr.equals(dateStr)){
                  res =DateUtil.formatDate(article.getReleaseTime(), "MM-dd");
              }else if(!releaseTimeStr.equals(dateStr)){
                  res =DateUtil.formatDate(article.getReleaseTime(), "yyyy-MM-dd");
              }
          }


    %>
    <div class="artli">
        <a href="/mobile/article/articleDetail?id=<%=encId%>&&userId=<%=userId%>">
            <div class="art_top clearfix"><img src="<%=blog!=null ? blog.getHeadImgMb() : ""%>"></div>
            <div class="art_con pr">
                <div class="art_tit col4 pt5 ellipsis2"><%=article!=null ? article.getTitle() : ""%></div>
                <ul class="art_read clearfix">
                    <li class="art_readli ft12 col8"><%=res%></li>
                </ul>
                <div class="art_img"><img src="<%=article!=null ? article.getThumb() : ""%>"></div>
            </div>
        </a>
    </div>
   <% }%>

</div>
<% }%>
<!--文章 end-->


<!--无数据-->
<%if(articleCollections.size()==0){%>
<div class="clearfix widbig nodata ">
    <img src="http://img.91caishen.com/source/images/contpla/app/qs.png">
    <h6 class="ft16 cola mt15"><b>暂无收藏</b></h6>
    <p class="ft14 cola mt5">&nbsp;&nbsp;快来留住你在意的点滴~</p>
</div>
<%}%>
<!--无数据 end-->


</body>
</html>


