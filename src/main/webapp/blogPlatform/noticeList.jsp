<%@ page import="com.caishen91.jupiter.model.Notice" %>
<%@ page import="java.util.List" %>
<%@ page import="com.caishen91.jupiter.util.DateUtil" %>
<%@ page import="com.caishen91.jupiter.util.IDEncryptor" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE HTML>
<%
    List<Notice> notices=(List<Notice>)request.getAttribute("notices");
%>
<html>
<head>
    <title>内容管理平台</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport">
    <link href="/css/blog/common.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
    <link href="/css/blog/article.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
    <link href="/css/blog/jianrong.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">

</head>

<body class="bg">
<jsp:include page="/blogPlatform/common/top.jsp"/>
<jsp:include page="/blogPlatform/common/leftMenu.jsp"/>

<!--右侧内容 文章详情-->
<div id="mainbody" class="mainbody">
    <div class="bigtitle mt20"><b class="ft22 fapf">公告</b></div>
    <div class="clearfix mt15 bgf radius3 shadow pd35 plr35" style="min-height:350px">
        <ul class="clearfix">
            <%
               for(Notice notice : notices){
                   String encId = IDEncryptor.getInstance().encryptWithoutException(notice.getId());
            %>
            <li class="noticeli">
                <a href="<security:authorize access="hasRole('GGXQY')">/blog/noticeDetail?id=<%=encId%></security:authorize> " class="a_box"><!--未读not_unread-->
                    <em class="unread_d radius6 bgred fl"></em>
                    <h3 class="fl ft16 colbule_hov colgblock transition ellipsis"><%=notice.getTitle()%></h3>
                    <span class="fr ft14 colgray04"><%=DateUtil.formatDate(notice.getReleaseTime(), "yyyy-MM-dd")%></span>
                </a>
            </li>
            <%
            }
            %>
           <%-- <li class="noticeli">
                <a href="#" class="a_box not_unread"><!--未读not_unread-->
                    <em class="unread_d radius6 bgred fl"></em>
                    <h3 class="fl ft16 colbule_hov colgblock transition ellipsis">文章审核通过 《为党和人民继续前进提供强大精神激励》</h3>
                    <span class="fr ft14 colgray04">2019-01-01</span>
                </a>
            </li>

            <li class="noticeli">
                <a href="#" class="a_box"><!--未读not_unread-->
                    <em class="unread_d radius6 bgred fl"></em>
                    <h3 class="fl ft16 colbule_hov colgblock transition ellipsis">文章审核通过 《银保监会调查奔驰_快资讯》</h3>
                    <span class="fr ft14 colgray04">2019-01-01</span>
                </a>
            </li>

            <li class="noticeli">
                <a href="#" class="a_box"><!--未读not_unread-->
                    <em class="unread_d radius6 bgred fl"></em>
                    <h3 class="fl ft16 colbule_hov colgblock transition ellipsis">系统维护通知：2019年3月16日进行系统升级</h3>
                    <span class="fr ft14 colgray04">2019-01-01</span>
                </a>
            </li>

            <li class="noticeli">
                <a href="#" class="a_box"><!--未读not_unread-->
                    <em class="unread_d radius6 bgred fl"></em>
                    <h3 class="fl ft16 colbule_hov colgblock transition ellipsis">「小程序评测」功能上线 </h3>
                    <span class="fr ft14 colgray04">2019-01-01</span>
                </a>
            </li>--%>
        </ul>
    </div>

    <!--page-->
   <%-- <div class="page mt20">
		<span id="pspan">
		<a class="pagePrev" href="javascript:void(0)" style="display:"><b></b></a>
		<a title="第1页" href="javascript:void(0)" class="hov" p="1" t="1">1</a>
		<a title="第2页" href="javascript:void(0)" p="2" t="2">2</a>
		<a title="第3页" href="javascript:void(0)" p="3" t="3">3</a>
		<a class="pageNext" href="javascript:void(0)"><b></b></a>
		</span>
    </div>--%>
    <!--page end-->

    <!--公用底部-->
    <div id="footer" class="footer textcent ft12 clearfix">
        <a href="#" class="ft14 colbule_hov transition">关于91财经</a>|<a href="#" class="ft14 colbule_hov transition">服务协议</a>|<a href="#" class="ft14 colbule_hov transition">联系邮箱</a>|<a href="#" class="ft14 colbule_hov transition">联系电话</a>
        <span class="ft14">Copyright © 2018-2019 91Caijing  All Rights Reserved</span>
    </div>
    <!--公用底部 end-->

</div>
<!--右侧内容 文章详情 end-->



</body>

</html>

