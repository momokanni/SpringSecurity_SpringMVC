<%@ page import="com.caishen91.jupiter.model.Blog" %>
<%@ page import="com.caishen91.jupiter.model.Notice" %>
<%@ page import="com.caishen91.jupiter.util.StringUtil" %>
<%@ page import="com.caishen91.jupiter.util.DateUtil" %>
<%@ page import="com.caishen91.jupiter.model.Article" %>
<%@ page import="java.util.List" %>
<%@ page import="com.caishen91.jupiter.util.IDEncryptor" %>
<%@ page import="com.caishen91.jupiter.config.Config" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE HTML>
<%
	Integer readCount = (Integer) request.getAttribute("readCount");
	Integer collecCount = (Integer) request.getAttribute("collecCount");;
	Integer forwardCount = (Integer) request.getAttribute("forwardCount");
	Integer blogFocusYesterdayCount = (Integer) request.getAttribute("blogFocusYesterdayCount");
	Blog blog = (Blog) request.getAttribute("blog");
	double num = (double) blog.getFansCount()/10000;
	BigDecimal decimal = new BigDecimal(num);
	Notice notice = (Notice) request.getAttribute("notice");
	String noticeId = null;
	if(notice != null){
		noticeId = IDEncryptor.getInstance().encryptWithoutException(notice.getId());
	}
	Article articleDraft = (Article) request.getAttribute("articleDraft");
	String articleDraftId = "";
	if(articleDraft != null){
	    articleDraftId = IDEncryptor.getInstance().encryptWithoutException(articleDraft.getId());
    }
	List<Article> articleLauched = (List<Article>) request.getAttribute("articleLauched");
%>
<html>
<head>
<title>内容管理平台</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1" name="viewport">
<jsp:include page="/blogPlatform/common/baseCss.jsp"></jsp:include>
</head>
<body>
<jsp:include page="/blogPlatform/common/top.jsp"/>
<jsp:include page="/blogPlatform/common/leftMenu.jsp"/>

	<!--右侧内容 首页-->
	<div id="mainbody" class="widcont mainbody pr">

		<!--通知-->
		<div class="home_notice mt30 pr">
	    	<em class="icon fl icon_notice"></em>
	    	<%if(notice != null){%>
	    		<security:authorize access="hasRole('GGXQY')">
		        <a href="/blog/noticeDetail?id=<%=noticeId%>" class="colbule_hov ft16 colgblock fl notice_cont transition">
		        </security:authorize>
		            <span class="fr colgray ft14"><%=notice != null ? DateUtil.formatDate(notice.getReleaseTime(), "yyyy-MM-dd HH:mm:ss") : ""%></span>
		            <b class="fapf"><%=notice != null ? notice.getTitle() : "暂无公告"%></b>
		        <security:authorize access="hasRole('GGXQY')">
		        </a>
		        </security:authorize>
		        <security:authorize access="hasRole('GGLBY')">
		        	<a href="/blog/noticeList" class="more ft14 colblue02 colbule_hov">更多<em class="icon"></em></a>
		        </security:authorize> 
		   <%} else {%>
		   		<a href="javascript:void(0);" class="colbule_hov ft16 colgblock fl notice_cont transition">
		            <span class="fr colgray ft14"><%=notice != null ? DateUtil.formatDate(notice.getReleaseTime(), "yyyy-MM-dd HH:mm:ss") : ""%></span>
		            <b class="fapf"><%=notice != null ? notice.getTitle() : "暂无公告"%></b>
		        </a>
		   <%}%>
	    </div>
	    <!--通知 end-->

	    
	    <!--数据-->
	    <div class="clearfix mt30 home_data">
	    	<div class="data_cont fl bgf radius3 pd25 textcent shadow clearfix">
	        	<h6 class="colgray02 ft14">昨日点击量</h6>
	            <h3 class="colgray02 ft14 mt10"><span class="colorg fadin"><%=readCount!=null ? readCount : "0"%></span>次</h3>
	        </div>
	        <div class="data_cont fl bgf radius3 pd25 textcent shadow clearfix">
	        	<h6 class="colgray02 ft14">昨日收藏量</h6>
	            <h3 class="colgray02 ft14 mt10"><span class="colgreen fadin"><%=collecCount!=null ? collecCount : "0"%></span>次</h3>
	        </div>
	        <div class="data_cont fl bgf radius3 pd25 textcent shadow clearfix">
	        	<h6 class="colgray02 ft14">昨日转载量</h6>
	            <h3 class="colgray02 ft14 mt10"><span class="colgreen fadin"><%=forwardCount!=null ? forwardCount : "0"%></span>次</h3>
	        </div>
	        <div class="data_cont fl bgf radius3 pd25 textcent shadow clearfix">
	        	<h6 class="colgray02 ft14">昨日新增粉丝</h6>
	            <h3 class="colgray02 ft14 mt10"><span class="colblue02 fadin"><%=blogFocusYesterdayCount!=null ? blogFocusYesterdayCount : "0"%></span></h3>
	        </div>
	        <div class="data_cont fl bgf radius3 pd25 textcent shadow_blue clearfix shadingblue" style="margin-right:0">
	        	<h6 class="colf ft14">总粉丝数</h6>
	            <h3 class="colf ft14 mt10"><span class="fadin"><%=blog.getFansCount()<10000 ? blog.getFansCount() : decimal.setScale(1, BigDecimal.ROUND_HALF_UP)+"w"%></span></h3>
	        </div>
	    </div>
	    <!--数据 end-->


	    <!--最新草稿-->

	    <div class="title mt50 clearfix pr ft14 colgray02"><b class="ft22 fapf colgblock">最新草稿</b><%--<a href="#" class="more ft14 colblue02 colbule_hov">更多<em class="icon"></em></a>--%></div>
		<form action="/blog/updateArticleDraft" method="post" id="frm" accept-charset="UTF-8">
			<input name="articleDraftId" id="articleDraftId" type="hidden" value="<%=articleDraft!=null ? articleDraftId : ""%>">
			<div class="bgf radius3 pd30 plr35 clearfix shadow mt15 pr">
				<div class="cgbtn">
					<%if(articleDraft!=null){%>
						<security:authorize access="hasRole('WZGLBJ')">
							<a href="/blog/article/toEdit?id=<%=articleDraftId%>" class="fr colf shadingred shadow_red ft16 button">编辑</a>
						</security:authorize> 
					<%--<a href="javascript:void(0)" class="fr colf shadingred shadow_red ft16 button" op="ljfbcg" id="ljfbcg">立即发布</a>--%>
					<%}%>
				</div>
				<h3 class="fapf ft18"><b><%=articleDraft!=null ? articleDraft.getTitle() : ""%></b></h3>
				<p class="ft14 colgray line24 mt10 ellipsis2" style="width:65%">
					<%=articleDraft!=null ? StringUtil.shortStr(StringUtil.getDescsStr(articleDraft.getContent()),90) : "暂无数据"%>
				</p>
			</div>
		</form>
	    <!--最新草稿 end-->
	    
		<!--已发布内容-->
	    <div class="title mt50 clearfix pr ft14 colgray02"><b class="ft22 fapf colgblock">已发布内容</b>&nbsp;（近<span class="colblue">7</span>天）</div>
	    

	    
	   <%-- <!--page-->
	    <div class="page">
			<span id="pspan">
			<a class="pagePrev" href="javascript:void(0)" style="display:"><b></b></a>
			<a title="第1页" href="javascript:void(0)" class="hov" p="1" t="1">1</a>
			<a title="第2页" href="javascript:void(0)" p="2" t="2">2</a>
			<a title="第3页" href="javascript:void(0)" p="3" t="3">3</a>
			<a class="pageNext" href="javascript:void(0)"><b></b></a>
			</span>
		</div>--%>
		<div id="indexContent" class="bgf radius3 pd15 clearfix shadow mt15 pr plr35">
		<%if(articleLauched.size()==0){%>
            <p class="ft14 colgray line24 mt10 ellipsis2" style="width:100%">
		 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;暂无数据
		</p>
			<%}%>
		</div>

		<script id="indexListTemplate" type="text/x-jquery-tmpl">
				{{each(i,data) content}}
						<div class="content pr clearfix">
							<div class="date fadin">
								<h4 class="ft20"><span class="colgray fama ft18"><font color="black">{{= data.mmdd}}</font></span></h4>
								<h6 class="ft16 colgray04">{{= data.hhss}}</h6>
							</div>

							<dl class="contbox pd20">
								<a href="<security:authorize access="hasRole('WZGLCKWZXQ')">/blog/articleDetail?id={{= data.arId}}</security:authorize>" class="a_box">
									<dt class="fl radius5"><img src="{{= data.headImg}}" class="imgaut"></dt>
									<dd class="fl">
										<h3 class="ft16 fapf colgblock pd5 transition"><b>{{= data.title}}</b></h3>
										<ul class="clearfix contli pd5">
								         <li class="fadin colgray04"><em class="icon icon_read"></em>{{= data.readVolume}}</li>
								         <li class="fadin colgray04"><em class="icon icon_coll"></em>{{= data.collectVolume}}</li>
								         <li class="fadin colgray04"><em class="icon icon_forw"></em>{{= data.forwardVolume}}</li>
							            </ul>
									</dd>
								</a>
							</dl>
						</div>
				{{/each}}
		  </script>

		<div id="statistics_header" class="ft14 colgray02 mt30">

		</div>

		<script id="statisticsTemplate" type="text/x-jquery-tmpl">
				 <div class="ft12 colgray02 pd10" align="right">共<span class="colblue">{{= actualCount}}</span>条</div>
	  	</script>

	    <!--page end-->

		<div class="maninput nobd">
			<div class="tab colltab">
				<div class="tab_content pselltdiv"></div>
				<div id="page"  class="page" style="text-align:center">
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
	<!--右侧内容 首页 end-->
</body>
<script type="text/javascript" src="/js/jquery-1.10.1.min.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX%>/blogPlatform/index.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/common.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/blogPlatform/toast.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/querytable.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/blogPlatform/common/indexTemp.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/jquery.pager.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/jquery.tmpl.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/blogPlatform/laydate.js?<%@include file='/include/.ver'%>"></script>

</html>

