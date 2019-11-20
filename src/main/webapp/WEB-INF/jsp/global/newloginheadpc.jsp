<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.xiaoyoucai.jinfu.util.RequestUtil" %>
<%
	int p = RequestUtil.getPort( request );
	String port1 = p == 80 ? "" : ":" + p;
	String loginSslPrefix = Config.SERVER_MAIN + port1;
	
	String jkLink = "http://" + Config.DAIKUAN_DOMAIN + port1;
%>

<div class="head">  
   	<a class="logo" title="小油菜" href="<%=loginSslPrefix %>/"><img alt="小油菜金服" src="  //www.xiaoyoucai.com/source/images/jinfu/logo/login_jf.png" style="display:inline-block; width:182px;margin-top:0px"></a>
   	<span class="login_tit">用户登录</span>
   	<div class="h_nav">
       	<ul>
<%--            	<li class="hn_li"><a href="<%=loginSslPrefix %>/" class="hn_a">首页</a></li> --%>
<!--            	<li class="hline">|</li> -->
           	<li class="hn_li"><a id="investLink" href="/loan/list_3_1.html" class="hn_a">我要投资<i class="hn_i"></i></a></li>
            <li class="hline">|</li>
            <li class="hn_li "><a href="//www.xycjinfu.com/disc/qywh.html" class="hn_a">企业文化</a></li>
            <li class="hline">|</li>
            <li class="hn_li "><a href="//www.xycjinfu.com/disc/mtbd.html" class="hn_a">媒体报道</a></li>
            <li class="hline">|</li>
            <li class="hn_li "><a href="/ptjs.html" class="hn_a">关于我们</a></li>
        </ul>
    </div>	
</div>
