<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import=" com.caishen91.jupiter.config.Config, com.caishen91.jupiter.model.SysUser"%>
<%@ page import="com.caishen91.jupiter.util.IDEncryptor" %>

<%
    SysUser sysUser = (SysUser) request.getAttribute("sysUser");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>系统管理</title>

    <jsp:include page="/common/baseCss.jsp"></jsp:include>
    <link href="/css/newstyle.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
    <script>
        var time_stamp = '<%@include file='/include/.ver'%>';
        var newUI = true;
    </script>

</head>
<body  class="page-header-fixed page-sidebar-closed-hide-logo page-content-white" style="background-color:#fff">
<div class="portlet box blue">
    <div class="portlet-title">
        <div class="caption">
            &nbsp;修改密码</div>
        <div class="tools">
            <a href="javascript:;" class="collapse" data-original-title="" title=""></a>
            <a href="#portlet-config" data-toggle="modal" class="config" data-original-title="" title=""> </a>
        </div>
    </div>
    <div class="portlet-body">

        <form action="/manager/sysuser/updatePassword" method="post" id="frm">
            <input type="hidden" name="id" value="<%=IDEncryptor.getInstance().encryptWithoutException(sysUser.getId())%>">
            <table rules="none" cellspacing="0" cellpadding="0" border="0px" width="100%" class="table table-light">
                <tbody>
                <tr>
                    <td width="25%" align="right">登录名:</td>
                    <td width="75%">
                        <div class="form-group">
                            <div class="col-md-4">
                                <input type="text" class="form-control" id="sysUserName" readonly="readonly" name="name" value="<%=sysUser.getName()%>">
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td width="25%" align="right">原始密码:<span class="required" aria-required="true"> * </span></td>
                    <td width="75%">
                        <div class="form-group">
                            <div class="col-md-4">
                                <input type="password"  class="form-control" id="sysUserPwd" name="oldPwd" value="">
                            </div>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td width="25%" align="right">新密码:<span class="required" aria-required="true"> * </span></td>
                    <td width="75%">
                        <div class="form-group">
                            <div class="col-md-4">
                                <input type="password"  class="form-control" id="sysUserNewPwd" name="newPwd" value="" placeholder="6-12位大小写字母、数字组合">
                            </div>
                        </div>
                    </td>
                </tr>
                
                <tr>
                    <td width="25%"></td>
                    <td width="65%" style=" padding-left:10%">
                        <a href="javascript:void(0);" op="save" class="btn btn-lg green" style="padding:">保存</a>
                    </td>
                </tr>

                </tbody>
            </table>
        </form>
    </div>
</div>

</body>
<jsp:include page="/common/baseJs.jsp"></jsp:include>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/common.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/manager/manager/updatePassword.js?<%@include file='/include/.ver'%>"></script>
</html>
