<%@ page import="com.caishen91.jupiter.config.Config" %>
<%@ page import="com.caishen91.jupiter.model.BlogManager" %>
<%@ page import="com.caishen91.jupiter.model.Blog" %>
<%@ page import="java.util.List" %>
<%@ page import="com.caishen91.jupiter.util.IDEncryptor" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE HTML>
<%
    BlogManager blogManager=(BlogManager)request.getAttribute("blogManager");
    Blog blog=(Blog)request.getAttribute("blog");
    List<BlogManager> subBlogManagers=(List<BlogManager>)request.getAttribute("subBlogManagers");
%>
<html>
<head>
    <title>内容管理平台</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport">
    <jsp:include page="/blogPlatform/common/baseCss.jsp"></jsp:include>
    <link href="/css/blog/common.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
    <link href="/css/blog/setup.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
    <link href="/css/blog/jianrong.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
    <link href="/css/layui/css/layui.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
</head>
<style>
.authContent{
	width:600px;
	height:300px;
	position: fixed;
    z-index: 101;
    overflow: hidden;
    padding-bottom: 35px;
    left:25%;
    margin-top:50px;
    padding-bottom:50px;
    overflow:auto
}
</style>

<body class="bg">
<jsp:include page="/blogPlatform/common/top.jsp"/>
<jsp:include page="/blogPlatform/common/leftMenu.jsp"/>

<!--右侧内容 文章详情-->
<div id="mainbody" class="mainbody">
    <div class="bigtitle mt20">
    	<security:authorize access="hasRole('TJZZH')">
    		<a href="javascript:void(0)" op="tjzzh" id="tjzzh" class="fr button colf bgrblue bgrblue_hov ft14 transition">添加子账号</a>
    	</security:authorize>
    	<b class="ft22 fapf">子账号管理</b>
    </div>
    <div class="clearfix mt15 bgf radius3 shadow pd35 plr35">
        <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_top">
            <tr>
                <td class="colmd-4" style="text-align:center;">登录名</td>
                <td class="colmd-4" style="text-align:center;">姓名</td>
                <td class="colmd-4" style="text-align:center;">昵称</td>
                <td class="colmd-3" style="text-align:center;">状态</td>
                <td class="colmd-5" style="text-align:center;">操作</td>
            </tr>
        </table>

        <form action="/blog/resetPwd" method="post" id="frmpwd" accept-charset="UTF-8">
            <input name="subBlogManagerId" id="subBlogManagerId" type="hidden" value="">
        </form>
        <!--标签列表-->
        
        <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_list mt5">
        <%for(BlogManager subBlogManager : subBlogManagers){
            String encId = IDEncryptor.getInstance().encryptWithoutException(subBlogManager.getId());
        %>
            <tr>
                <td class="colmd-4" style="text-align:center;"><span><%=subBlogManager!=null ? subBlogManager.getMobile() : ""%></span></td>
                <td class="colmd-4" style="text-align:center;"><span><%=subBlogManager!=null ? subBlogManager.getName() : ""%></span></td>
                <td class="colmd-4" style="text-align:center;"><span><%=subBlogManager!=null ? subBlogManager.getNickName() : ""%></span></td>
                <td class="colmd-3" style="text-align:center;"><span><%=subBlogManager!=null ? BlogManager.BlogManagerStatus.getSysuserStatus(subBlogManager.getStatus()).getDesc() : ""%></span></td>

                <td class="colmd-5" style="text-align:center;">
                	<span>
	                     <%if(subBlogManager.getStatus()==BlogManager.BlogManagerStatus.EFFECTIVE.getStatus()){%>
	                     	<security:authorize access="hasRole('XGZZHZT')">
		                    	<a href="/blog/setBlogManagerStatus?id=<%=encId%>" class="colblue02 colbule_hov">停用</a>&nbsp;&nbsp;&nbsp;
		                    </security:authorize>
		                    <security:authorize access="hasRole('CZZHHMM')">
		                    	<a href="javascript:void(0)" op="czmm" c="<%=encId%>"  class="colblue02 colbule_hov">重置密码</a>
		                    </security:authorize>
		                    &nbsp;&nbsp;&nbsp;
		                    <security:authorize access="hasRole('ZZHQXCX')">
		                    	<a href="javascript:void(0)" bmId="<%=encId %>" class="authElement colblue02 colbule_hov">权限</a>
		                    </security:authorize>
	                    <%}%>
	                    <%if(subBlogManager.getStatus()==BlogManager.BlogManagerStatus.INVALID.getStatus()){%>
	                    	<security:authorize access="hasRole('XGZZHZT')">
	                    		<a href="/blog/setBlogManagerStatus?id=<%=encId%>" class="colblue02 colbule_hov">启用</a>
	                    	</security:authorize>
	                    <%}%>
                    </span>
                </td>
            </tr>
             <%}%>
        </table>
       
        <!--标签列表 end-->
    </div>

    <!--公用底部-->
    <div id="footer" class="footer textcent ft12 clearfix">
        <a href="#" class="ft14 colbule_hov transition">关于91财经</a>|<a href="#" class="ft14 colbule_hov transition">服务协议</a>|<a href="#" class="ft14 colbule_hov transition">联系邮箱</a>|<a href="#" class="ft14 colbule_hov transition">联系电话</a>
        <span class="ft14">Copyright © 2018-2019 91Caijing  All Rights Reserved</span>
    </div>
    <!--公用底部 end-->

</div>
<!--右侧内容 文章详情 end-->

<!--提示弹框-->
<div id="rest" class="dn">
    <div class="zhezhao"></div>
    <div class="tk_box radius3 bgf">
        <div class="tk_top ft14 colgray02 plr20"><a href="#" op=qxcz class="icon tk_close fr"></a>提示</div>
        <div class="tk_tit ft18 textcent pd30">确定重置密码?</div>
        <div class="tk_btn"><a href="javascript:void(0)" op="qxcz" id="qxcz" class="button bgf6 colgray04 border_gray transition ft14 colbule_hov">取消</a>
            <a href="javascript:void(0)" op="qdcz" id="qdcz" class="button bgrblue bgrblue_hov colf transition border_blue ft14">确定</a></div>
    </div>
</div>
<!--提示弹框 end-->

<div id="authDiv" class="dn">
    <div class="zhezhao"></div>
    <div class="radius3 bgf authContent">
        <div class="tk_top ft14 colgray02 plr20">
        	<a href="#" class="authCancel icon tk_close fr"></a>授权
        </div>
        <div id="test12" class="demo-tree-more" style="padding-top:30px; padding-left:60px"></div>
        <div class="tk_btn mt30">
        	<a href="javascript:void(0)" op="qxcz" id="qxcz" class="authCancel button bgf6 colgray04 border_gray transition ft14 colbule_hov">取消</a>
            <a href="javascript:void(0)" op="qdcz" id="qdcz" class="button bgrblue bgrblue_hov colf transition border_blue ft14" lay-demo="getChecked">确定</a>
        </div>
    </div>
</div>

<!--添加 弹框-->
<form action="/blog/addSubBlogManager" method="post" id="frm" accept-charset="UTF-8">
<div id="addSub" class="dn">
    <div class="zhezhao"></div>
    <div class="tk_box radius3 bgf" style="margin-top:-135px">
        <div class="tk_top ft14 colgray02 plr20"><a href="javascript:void(0)" op="topqx" id="topqx" class="icon tk_close fr"></a>添加子账号</div>
        <div class="screen_inp mt30" style=" padding-left:46px">
            <span class="fl ft14 colgblock">&nbsp;&nbsp;&nbsp;姓名：</span>
            <input type="text" placeholder="" name="name" id="name" class="inputbox" style="width:210px">
        </div>


        <div class="screen_inp mt15" style=" padding-left:46px">
            <span class="fl ft14 colgblock">&nbsp;&nbsp;&nbsp;昵称：</span>
            <input type="text" placeholder="" name="nickName" id="nickName" class="inputbox" style="width:210px" >
        </div>


        <div class="screen_inp mt15" style=" padding-left:46px">
            <span class="fl ft14 colgblock">手机号：</span>
            <input type="text" placeholder="" name="mobile" id="mobile" class="inputbox" style="width:210px" >
        </div>


        <div class="tk_btn mt20">
            <a href="javascript:void(0)" op="qx" id="qx" class="button bgf6 colgray04 border_gray transition ft14 colbule_hov">取消</a>
            <a href="javascript:void(0)" op="cj" id="cj" class="button bgrblue bgrblue_hov colf transition border_blue ft14">创建</a>
        </div>
    </div>
</div>
</form>
<!--添加 弹框 end-->


</body>
<script type="text/javascript" src="/js/jquery-1.10.1.min.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/common.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/blogPlatform/toast.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX%>/layui/layui.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX%>/blogPlatform/subaccountSetting.js?<%@include file='/include/.ver'%>"></script>
</html>



