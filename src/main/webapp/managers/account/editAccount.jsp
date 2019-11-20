<%@page import="java.math.BigDecimal"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.caishen91.jupiter.model.*,com.caishen91.jupiter.util.*,com.caishen91.jupiter.enums.*"%>
<%@ page import="com.caishen91.jupiter.config.Config" %>
<%@ page import="com.caishen91.jupiter.model.SysRole" %>
<%@ page isELIgnored="true" %>

<%
   List<SysRole> sysRoles=(List<SysRole>)request.getAttribute("ssr");
   SysUser sysUser=(SysUser)request.getAttribute("sysUser");
    boolean update = (sysUser != null);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>创建账号</title>

    <jsp:include page="/common/baseCss.jsp"></jsp:include>

    <link rel="stylesheet" href="/front/styles/<%=Config.FRONT_PREFIX%>/qsuggest.css?<%@include file='/include/.ver'%>" />
    <link href="/css/newstyle.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
    <script>
        var time_stamp = '<%@include file='/include/.ver'%>';
        var update = <%=update%>;
        var newUI = true;
    </script>
    <style type="text/css">
        .offset{
            width: 50%;
            display: inline-block;
            margin-left: 40px;
        }
        .lineblock{
            display: inline-block;
        }
        .bott{
            margin-bottom: 0px;
        }
    </style>

</head>
<body  class="page-header-fixed page-sidebar-closed-hide-logo page-content-white" style="background-color:#fff">
<div id="modelDv">
</div>
<div class="portlet box blue">
    <div class="portlet-title">
        <div class="caption">
            &nbsp;<%=update ? "编辑账号": "创建账号"%></div>
        <div class="tools">
            <a href="javascript:;" class="collapse" data-original-title="" title=""></a>
            <a href="#portlet-config" data-toggle="modal" class="config" data-original-title="" title=""> </a>
        </div>
    </div>
    <div class="portlet-body">

        <form action="<%=update ? "/manager/account/updateAccount" : "/manager/account/addAccount" %>" method="post" id="frm">
            <input name="id" id="id" type="hidden" value="<%=update ? IDEncryptor.getInstance().encryptWithoutException(sysUser.getId()) : ""%>">
            <div class="marlr20 dsfbox">
            <table align="center" cellspacing="0" cellpadding="0" border="none" width="50%" class="table table-light" id="queryTable">
                <tbody>
                <tr>
                    <td width="150px" align="right">姓名:</td>
                    <td width="400px" align="left" >
                        <input id="name" name="name" value="<%=update ? sysUser.getName() :""%>" type="text"  class="form-control">
                    </td>

                </tr>

                <tr>
                    <td width="150px" align="right">手机号:</td>
                    <td width="400px" align="left" colspan="2">
                        <input id="mobile" name="mobile" value="<%=update ? sysUser.getMobile() :""%>" type="text" class="form-control">
                    </td>
                    <td>
                    </td>
                </tr>

                <tr>
                    <td width="150px" align="right">登陆账号:</td>
                    <td width="400px" align="left" colspan="2">
                        <input id="loginName" name="loginName" value="<%=update ? sysUser.getLoginName() :""%>" type="text" class="form-control">
                    </td>
                    <td>
                    </td>
                </tr>

                <tr>
                    <td width="150px" align="right">角色:</td>
                    <td width="400px" align="left" colspan="2">
                        <%for(SysRole ssr : sysRoles) {
                        %>
                        <input type="radio" id="roleId" name="roleId" value="<%=ssr.getId()%>" <%=(update && sysUser.getRoleId()==ssr.getId()) ? "checked" : "" %>/><label for="roleId"><%=ssr.getRoleName() %></label>&nbsp;&nbsp;
                        <%} %>
                    </td>
                    <td>
                    </td>
                </tr>


                <tr>
                    <td width="150px"></td>
                    <td width="400px" align="center" colspan="2">
                        <%if(update){
                            %>
                            <a id="save" href="javascript:void(0) " op="save" class="btn blue" style="margin-left: 60px">确认修改</a>
                        <%
                        }else{
                        %>
                        <a id="save" href="javascript:void(0) " op="save" class="btn blue" style="margin-left: 60px">创建</a>
                        <%
                        }
                        %>
                        <a href="/manager/account/accountList" class="btn yellow" style="margin-left: 60px">返回</a>
                    </td>
                    <td>
                    </td>
                </tr>


                </tbody>
            </table>

            </div>
        </form>
    </div>
</div>

</body>
<jsp:include page="/common/baseJs.jsp"></jsp:include>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/common.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX%>/common/jquery.qsuggest.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX%>/manager/account/addAccount.js?<%@include file='/include/.ver'%>"></script>
</html>
