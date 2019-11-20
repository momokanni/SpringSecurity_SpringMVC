<%@ page import="com.caishen91.jupiter.model.BlogManager" %>
<%@ page import="com.caishen91.jupiter.enums.BlogManagerType" %>
<%@ page import="com.caishen91.jupiter.config.Config" %>
<%@ page import="com.caishen91.jupiter.model.Blog" %>
<%@ page import="com.caishen91.jupiter.enums.BlogType" %>
<%@ page import="com.caishen91.jupiter.model.BlogMenuTree" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%
	BlogManager blogManager = (BlogManager)request.getAttribute("blogManager");
	Blog blog = (Blog)request.getAttribute("blog");
	List<BlogMenuTree> tree = (List<BlogMenuTree>) request.getAttribute("menuTree");
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
	<div class="menu pd20">
		<%
           for(BlogMenuTree menu : tree){
        %>
        	<%if(menu.getUrl() != null){%>
        		<%if(menu.getUrl().equals("/blog/blogHome")){%>
		        	<h3 class="menu_tit menu_home menu_home_in">
		        		<a href="/blog/blogHome" class="a_box ft18 colgblock colbule_hov fapf">
		        			<em class="fl icon"></em>
		        			<b><%=menu.getName()%></b>
		        		</a>
		        	</h3>
	        	<% } %>
	        <%} else {%>
	        	<h3 class="menu_tit menu_function ft18 colgblock mt10 fapf">
	        		<em class="fl icon"></em>
	        		<b><%=menu.getName()%></b>
	        	</h3>
	        <% } %>
	        <%if(menu.getChildren() != null){%>
	        	<ul class="clearfix">
	        		<%
			           for(BlogMenuTree child : (List<BlogMenuTree>) menu.getChildren()){
			        %>
						<li id="<%=child.getElementId() %>" class="menuli menuli">
							<a href="<%=child.getUrl() %>" class="ft16 colgray02 colbule_hov">
								<%=child.getName() %>
							</a>
						</li>
					<% } %>
				</ul>
	        <% } %>
        <% } %>
	</div>
</body>
<script type="text/javascript" src="/js/jquery-1.10.1.min.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript">
$("ul li").click(function(){
    var item = $(this).index();  //获取索引下标 也从0开始
    var textword = $(this).text();  //文本内容
    $(this).addClass("menuli_in");
    /* alert("下标索引值为：" + item +"\n"+ "文本内容是："+textword); //  \n换行 */
})
</script>
</html>

