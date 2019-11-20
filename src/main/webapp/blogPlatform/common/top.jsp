<%@ page import="com.caishen91.jupiter.model.BlogManager" %>
<%@ page import="com.caishen91.jupiter.model.Blog" %>
<%@ page import="com.caishen91.jupiter.enums.BlogType" %>
<%@ page import="com.caishen91.jupiter.enums.BlogManagerType" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE HTML>
<%
	BlogManager blogManager=(BlogManager)request.getAttribute("blogManager");
	Blog blog=(Blog)request.getAttribute("blog");
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
	<!--头部-->
	<div id="header" class="bgrblue shadow">
		<div class="pr widthall">
			<div class="logo"><a href="/blog/blogHome" class="a_box"><img src="http://img.91caishen.com/source/images/contpla/icon/logo.png" class="logoimg"></a></div>
			<ul class="head_fr">
				<li class="head_li">
	                <a href="/blog/noticeList" class="pr head_news a_box">
	                    <em class="icon icon_news"></em>
	                    <div class="unread"></div><!--无消息dn-->
	                </a>
	            </li>
	            <li class="head_li head_menu pr">
	            	<a href="#" class="a_box head_user">
	                	<dl class="user_cont pr">
	                    	<em class="icon block"></em>
	                    	<dt class="ovet fl"><img src="<%=blog.getHeadImg()!=null ? blog.getHeadImg() : "http://img.91caishen.com/source/images/contpla/icon/user_tx.png"%>" class="imgtx imgaut" ></dt>
							<%if(blog.getType()== BlogType.COMPANY.getType()){%>
	                        <dd class="fl"><!--公司号,隐藏dn-->
	                        	<h3 class="ft14 colf"><%=blog.getName()!=null ?blog.getName() : "未设置"%></h3>
	                            <p class="ft12 colf">
									<%=blogManager.getIsManager()==BlogManagerType.ADMIN.getType() ? BlogManagerType.getBlogType(blogManager.getIsManager()).getMsg() : "编辑"%>
								</p>
	                        </dd>
							<%}%>

							<%if(blog.getType()== BlogType.PERSONAL.getType()){%>
							<dd class="fl "><!--个人号,隐藏dn-->
								<h3 class="ft14 colf" style="line-height:38px"><%=blog.getName()!=null ?blog.getName() : "未设置"%></h3>
							</dd>
							<%}%>

	                    </dl>
	                </a>
	                
	                <ul class="dropdown_menu bgf shadow">
						<security:authorize access="hasRole('ZHSZ')">
							<li><a href="/blog/accountSetting" class="ft14 colgray02 a_box transition colbule_hov"><em class="icon fl em01"></em><span>账号设置</span></a></li>
						</security:authorize>
						<security:authorize access="hasRole('ZZHSZ')">
	                    	<li><a href="/blog/subaccountSetting" class="ft14 colgray02 a_box transition colbule_hov"><em class="icon fl em02"></em><span>子账号设置</span></a></li>
						</security:authorize>
	                    <li><a href="/logout" class="ft14 colgray02 a_box transition colbule_hov"><em class="icon fl em03"></em><span>安全退出</span></a></li>
					</ul>
	                
	            </li>
	        </ul>
	    </div>
	</div>
	<!--头部 end-->
</body>
</html>

