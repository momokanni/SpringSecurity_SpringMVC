<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.caishen91.jupiter.model.*,com.caishen91.jupiter.util.*"%>

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

    FaeInvestor faeInvestor = (FaeInvestor)request.getAttribute("faeInvestor");
    String investorIdStr = "";
    if(faeInvestor != null){
        investorIdStr = IDEncryptor.getInstance().encrypt(faeInvestor.getId());
    }

    Map<String, Tab> tabMap = new LinkedHashMap<String, Tab>();
    tabMap.put("base", new Tab("base", "/manager/investor/getFaeInvestorDetailById?id="+investorIdStr, "基本信息"));
    tabMap.put("record", new Tab("record", "/manager/investor/investorRecord?id="+investorIdStr, "投资记录"));
    tabMap.put("flowing", new Tab("flowing", "/manager/investor/getFaeInvestFlowing?id="+investorIdStr, "交易流水"));
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
    <%for (Map.Entry<String, Tab> entry : tabMap.entrySet()) {%>
        <li class="<%=tab.equals(entry.getKey()) ? "active" : "false"%>">
            <a href="<%=entry.getValue().link %>" aria-expanded="<%=tab.equals(entry.getKey()) ? "true" : "false"%>"><%=entry.getValue().name%></a>
        </li>
    <%}%>
</ul>
</div>