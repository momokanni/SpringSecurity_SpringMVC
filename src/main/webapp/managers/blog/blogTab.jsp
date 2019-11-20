<%@page import="com.caishen91.jupiter.vo.BlogDetailVO"%>
<%@page import="com.caishen91.jupiter.enums.*"%>
<%@page import="java.math.BigDecimal"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.caishen91.jupiter.model.*,com.caishen91.jupiter.util.*"%>
<%@ page isELIgnored="true" %>
<!DOCTYPE HTML>
<%!
	class Tab {
		String tab;
		String link;
		String name;
		
		Tab(String tab, String link, String name) {
			this.tab = tab;
			this.link = link;
			this.name = name;
		}
	}
%>
<%	
	String tab = request.getParameter("tab");

	String blogId = (String)request.getAttribute("blogId");
	BlogDetailVO blog = (BlogDetailVO)request.getAttribute("blog");
	
	Map<String, Tab> tabMap = new LinkedHashMap<String, Tab>();
	if(blog.getType() == BlogType.COMPANY.getType()){
		tabMap.put("base", new Tab("base", "/manager/blog/getBlogDtl?id="+blogId, "基本信息"));
		tabMap.put("record", new Tab("record", "/manager/blogManager/tosubAccount?id="+blogId, "子账号"));
		tabMap.put("repay", new Tab("repay", "/manager/label/toLabel?id="+blogId, "栏目列表"));
		tabMap.put("establish", new Tab("establish", "/manager/article/toArticle?id="+blogId, "文章列表"));
	} else {
		tabMap.put("base", new Tab("base", "/manager/blog/getBlogDtl?id="+blogId, "基本信息"));
		tabMap.put("establish", new Tab("establish", "/manager/article/toArticle?id="+blogId, "文章列表"));
		tabMap.put("read", new Tab("read", "/manager/article/toReadList?id="+blogId, "阅读列表"));
		tabMap.put("collect", new Tab("collect", "/manager/article/toCollectList?id="+blogId, "收藏列表"));
	}
	
%>

<style>
	.t{
	display: block;
    float: left;
    height: 32px;
    line-height: 32px;}
    .t a{
    color: #535353;
    cursor: pointer;
    display: inline;
    float: left;
    font-family: Tahoma;
    height: 32px;
    margin-right: 5px;
    padding: 0 15px;}
</style>

<div class="tabbable-line">
<ul class="nav nav-tabs">
	<%
		for(Map.Entry<String, Tab> entry : tabMap.entrySet()) {
	%>
	<li class="<%=tab.equals(entry.getKey()) ? "active" : "false"%>">
		<a href="<%=entry.getValue().link %>" aria-expanded="<%=tab.equals(entry.getKey()) ? "true" : "false"%>"><%=entry.getValue().name%></a>
	</li>

	<%
		}
	%>
	</ul>
</div>


