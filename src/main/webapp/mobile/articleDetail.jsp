<%@ page import="java.util.List" %>
<%@ page import="com.caishen91.jupiter.util.IDEncryptor" %>
<%@ page import="com.caishen91.jupiter.util.DateUtil" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.caishen91.jupiter.util.StringUtil" %>
<%@ page import="com.caishen91.jupiter.config.Config" %>
<%@ page import="com.caishen91.jupiter.model.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%
    Article article=(Article)request.getAttribute("article");
    String articleId=IDEncryptor.getInstance().encryptWithoutException(article.getId());
    Blog blog=(Blog)request.getAttribute("blog");
    String blogId=IDEncryptor.getInstance().encryptWithoutException(blog.getId());
    String id= IDEncryptor.getInstance().encryptWithoutException(blog.getId());
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



    List<Article> rmdArticles=(List<Article>)request.getAttribute("rmdArticles");

    Map map=(Map)request.getAttribute("map");
    //获取到移动端用户Id
    String userId=(String)request.getAttribute("userId");

    BlogFocus blogFocus=(BlogFocus)request.getAttribute("blogFocus");

    ArticleLaud articleLaud=(ArticleLaud)request.getAttribute("articleLaud");

    ArticleCollection articleCollection=(ArticleCollection)request.getAttribute("articleCollection");


%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=1.0, user-scalable=yes" />
    <meta name = "format-detection" content="telephone = no" />
    <title>文章详情</title>
    <link href="/css/mobile/common.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
    <link href="/css/mobile/art_list.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
    <script>
        var articleId='<%=articleId%>';
        var userId='<%=userId%>';
        var id='<%=id%>';
    </script>
</head>

<body class="bgf7">
<!--头部-->
<div class="header widbig"><!--需判断topnav_ios-->
    <h3 class="col4 ft18">文章详情</h3>
    <div class="navback">
        <a href="javascript:void(0);" op="back" id="back"><img src="http://img.91caishen.com/source/images/contpla/app/nav_back.png"></a>
    </div>
    <div class="navfr">
        <a href="javascript:void(0);" op="fx"><img src="http://img.91caishen.com/source/images/contpla/app/nav_share.png"></a>
    </div>
</div>
<div style="width:100%; height:45px;"></div>
<!--头部 end-->

<div class="artdetail clearfix widbig bgff pt15 pb20">
    <div class="arttitle clearfix ft20 col4"><%=article!=null ? article.getTitle() : ""%></div>
    <div class="art_public clearfix pr">
        <a href="javascript:void(0);" op="gz" id="gz"   class="a_follow <%=blogFocus!=null ? "a_follow_ok" : ""%>"><%=blogFocus!=null ? "已关注" : "关注"%></a><!--已关注 a_follow_ok -->

        <dl class="artpulic fl">
            <a href="/mobile/blog/blogDetail?id=<%=blogId%>&&userId=<%=userId%>">
                <%if(blog.getHeadImgMb()!=null){%>
                <dt class="fl"><img src="<%=blog.getHeadImgMb()%>"></dt>
                <%}%>

                <dd class="fl ft16 col4"><%= blog.getName()!=null ?blog.getName() : ""%></dd>

            </a>
        </dl>

        <p class="fl ft12 col8"><%=res%></p>
    </div>

    <div class="article clearfix pt10 col3 ft16">
        <%=article!=null ? article.getContent() : ""%>
    </div>
    <ul class="art_read art_read02 clearfix mt5">
        <li class="art_readli ft12 col8 fl"><img src="http://img.91caishen.com/source/images/contpla/app/icon_read.png"><%=article!=null ? article.getReadCount() : "0"%></li>
       <%-- <li class="art_readli ft12 col8 fr"><img src="http://img.91caishen.com/source/images/contpla/app/icon_fab.png"><%=article!=null ? article.getLaudCount() : "0"%></li>--%>
    </ul>
</div>

<div class="art_ad mt15 bgff"><a href="javascript:void(0)"><img src="http://img.91caishen.com/source/images/contpla/app/art_ad.png"></a></div>

<div class="bgff clearfix widbig pt20">
    <%if(rmdArticles.size()>0){%>
        <h3 class="ft16 col4 art_tj pb5"><b>文章推荐</b></h3>
    <%}%>


    <!--列表-->
    <div class="clearfix">
        <%for(Article rmdArticle :rmdArticles){
            String encId= IDEncryptor.getInstance().encryptWithoutException(rmdArticle.getId());

            //处理时间
            String ress=null;
            Date dates=new Date();
            String dateStrs= DateUtil.formatDate(dates, "yyyy");
            String releaseTimeStrs=DateUtil.formatDate(rmdArticle.getReleaseTime(), "yyyy");
            if(rmdArticle.getReleaseTime()!=null){
                long differenceValue = new Date().getTime() - rmdArticle.getReleaseTime().getTime();
                if(differenceValue<60000){
                    ress ="刚刚";
                }else if(differenceValue<3600000){
                    ress = (differenceValue / 1000 / 60 ) + "分钟前";
                }else if(differenceValue > 3600000&&differenceValue < 3600000*24){
                    ress = (differenceValue / 1000 / 60 / 60 ) + "小时前";
                }else if(differenceValue>3600000*24&&differenceValue<3600000*24*3){
                    ress = (differenceValue / 1000 / 60 / 60/ 24 ) + "天前";
                }else if(differenceValue>3600000*24*3&&releaseTimeStr.equals(dateStr)){
                    ress =DateUtil.formatDate(rmdArticle.getReleaseTime(), "MM-dd");
                }else if(!releaseTimeStr.equals(dateStr)){
                    ress =DateUtil.formatDate(rmdArticle.getReleaseTime(), "yyyy-MM-dd");
                }
            }
            Blog rmdBlog=(Blog)map.get(rmdArticle.getId());
        %>
        <div class="artli">
            <a href="/mobile/article/articleDetail?id=<%=encId%>&&userId=<%=userId%>">
                <div class="art_top clearfix">
                	<img style="width:auto;" src="<%=rmdBlog.getHeadImgMb()!=null ? rmdBlog.getHeadImgMb() : "http://img.91caishen.com/source/images/contpla/icon/user_tx.png"%>"/>
                    &nbsp;&nbsp;
                    <span><%=rmdBlog.getHeadImgMb()==null ? rmdBlog.getName() : ""%></span>
                	<span class="ft12 cola fr"><%=ress%></span>
                </div>
                <div class="art_con pr">
                    <div class="art_tit col4 pt5 ellipsis2"><%=rmdArticle!=null ? StringUtil.shortStr(StringUtil.getDescsStr(rmdArticle.getTitle()),90) : ""%></div>
                    <ul class="art_read clearfix">
                        <li class="art_readli ft12 col8"><img src="http://img.91caishen.com/source/images/contpla/app/icon_read.png"><%=rmdArticle!=null ?rmdArticle.getCollecCount() : "0"%></li>
                        <li class="art_readli ft12 col8"><img src="http://img.91caishen.com/source/images/contpla/app/icon_fab.png"><%=rmdArticle!=null ?rmdArticle.getLaudCount() : "0"%></li>
                        <li class="art_readli ft12 col8"><img src="http://img.91caishen.com/source/images/contpla/app/icon_share.png"><%=rmdArticle!=null ?rmdArticle.getForwardCount() : "0"%></li>
                    </ul>
                    <div class="art_img"><img src="<%=rmdArticle!=null ? rmdArticle.getThumb() : ""%>"></div>
                </div>
            </a>
        </div>
        <%}%>
    </div>
    <!--列表 end-->

    <div class="bottom_h"></div>

    <!--悬浮操作-->
    <div class="">
        <div class="art_zhezhao"></div>
        <ul class="art_ope">
            <li>
                <a href="javascript:void(0)" op="dz" id="dz"  class="art_fab <%=articleLaud!=null ? "art_fab_in" : ""%>">
                    <em></em>
                    <span class="ft14 cola" id="laud"><%=article.getLaudCount()!=0 ? article.getLaudCount() : ""%></span>
                </a>
            </li>
            <li>
                <a href="javascript:void(0)" op="sc" id="sc" class="art_col <%=articleCollection!=null ? "art_col_in" : ""%>">
                    <em></em>
                </a>
            </li>
            <li>
                <a href="javascript:void(0)" op="fx" id="fx" class="art_share">
                    <em></em>
                </a>
            </li>
        </ul>
    </div>
    <!--悬浮操作 end-->


    <!--app里分享-->
    <div id="appFx" class="dn">
        <div class="art_zhezhao02"></div>
        <div class="art_appshare" style="width:92%;padding: 0 4%;">
            <a href="javascript:void(0);">
                <img src="http://img.91caishen.com/source/images/contpla/app/share_wx.png">
                <span>微信好友</span>
            </a>
            <a href="javascript:void(0);">
                <img src="http://img.91caishen.com/source/images/contpla/app/share_pyq.png">
                <span>微信朋友圈</span>
            </a>
        </div>
    </div>
    <!--app里分享 end-->
</div>
<div id="output"></div>
</body>
<script type="text/javascript" src="/js/jquery-1.10.1.min.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/mobile/mui.min.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX%>/mobile/articleDetail.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/common.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/wx.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
<script type="text/javascript">
mui.init({
	swipeBack: true
});
//点击空白区域隐藏弹出层
mui('body')[0].addEventListener("tap",function(e){
    var target = e.target;
    var classStr = target.className;
    if (target.tagName != "A"){
    	mui("#appFx")[0].className = "dn";
    }
});

(function(){
	var video, output;
    var scale = 0.8;

    var initialize = function() {
        output = mui("#output")[0];
        video = mui("#video")[0];
        video.addEventListener('tap',function(){
        	video.canplay();
            var canvas = document.createElement("canvas");
            var	ctx = canvas.getContext('2d');
            var img = new Image();
            img.setAttribute('crossorigin', 'anonymous');
            
            canvas.width = video.videoWidth * scale;
            canvas.height = video.videoHeight * scale;
            
            img.onload = function() {
            	ctx.drawImage(video, 2, 2, canvas.width, canvas.height);
            	img.src = canvas.toDataURL("image/png");
            }
            output.appendChild(img);
            video.pause();
        });
    };
 
    var captureImage = function() {
    	
    };
 
    initialize();
    
    video.trigger('tap');
})();
</script>
</html>


