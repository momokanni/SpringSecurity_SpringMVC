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

	FaeProduct product = (FaeProduct)request.getAttribute("product");
	String productId = "";
	if(product != null){
		productId = IDEncryptor.getInstance().encrypt(product.getId());
	}

	Map<String, Tab> tabMap = new LinkedHashMap<String, Tab>();
	tabMap.put("base", new Tab("base", "/manager/product/productDetail?id="+productId, "详情"));
	tabMap.put("record", new Tab("record", "/manager/product/investRecord?id="+productId, "投资记录"));
	tabMap.put("repay", new Tab("repay", "/manager/product/repayInfo?id="+productId, "还款计划"));
	tabMap.put("establish", new Tab("establish", "/manager/product/establishInfo?id="+productId, "成立记录"));
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


