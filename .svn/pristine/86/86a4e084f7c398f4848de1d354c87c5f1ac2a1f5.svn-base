<%@ page import="com.caishen91.jupiter.model.Notice" %>
<%@ page import="java.util.List" %>
<%@ page import="com.caishen91.jupiter.util.DateUtil" %>
<%@ page import="com.caishen91.jupiter.util.IDEncryptor" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <link href="/css/manager/home/components.css" rel="stylesheet" type="text/css">
    <link href="/css/blog/common.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
    <link href="/css/blog/article.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
    <link href="/css/blog/jianrong.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">

</head>

<body  class="page-header-fixed page-sidebar-closed-hide-logo page-content-white" style="background-color:#fff">
<div style="min-height:800px">
	<div class="portlet box blue ">
		<div class="portlet-title">
			<div class="caption colf"><a href="/manager/console/outline" class="colf">&nbsp;概要</a><span class="colf">&nbsp;&gt;&nbsp;</span>公告</div>
		</div>

<!--右侧内容 文章详情-->
<div class="portlet-body">
    <div class="clearfix bgf radius3 pd35 plr35" style="min-height:350px; padding-top:10px;">
        <ul class="clearfix">
            <%
                for(Notice notice : notices){
                    String encId = IDEncryptor.getInstance().encryptWithoutException(notice.getId());
            %>
            <li class="noticeli">
                <a href="/manager/console/noticeDetail?id=<%=encId%>" class="a_box"><!--未读not_unread-->
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

</div>
<!--右侧内容 文章详情 end-->
</div>
</div>


</body>

</html>

