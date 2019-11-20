<%@page import="java.math.BigDecimal"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.caishen91.jupiter.model.*,com.caishen91.jupiter.util.*,com.caishen91.jupiter.enums.*"%>
<%@ page import="com.caishen91.jupiter.config.Config" %>
<%@ page import="com.caishen91.jupiter.model.SysRole" %>
<%@ page isELIgnored="true" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>创建商户</title>

    <jsp:include page="/common/baseCss.jsp"></jsp:include>

    <link rel="stylesheet" href="/front/styles/<%=Config.FRONT_PREFIX%>/qsuggest.css?<%@include file='/include/.ver'%>" />
    <link href="/css/newstyle.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
    <script>
        var time_stamp = '<%@include file='/include/.ver'%>';
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
            &nbsp;创建商户</div>
        <div class="tools">
            <a href="javascript:;" class="collapse" data-original-title="" title=""></a>
            <a href="#portlet-config" data-toggle="modal" class="config" data-original-title="" title=""> </a>
        </div>
    </div>
    <div class="portlet-body">

        <form action="/manager/blog/create" method="post" id="frm">
            <div class="marlr20 dsfbox">
            <table align="center" cellspacing="0" cellpadding="0" border="none" width="50%" class="table table-light" id="queryTable">
                <tbody>
                <tr>
                    <td width="150px" align="right">用户类型:</td>
                    <td width="400px" align="left" >
                    	<div id="typeDiv">
	                    	<label class='mt-radio'>
	                			<input type='radio' id='type1' name='blogType' class='sysBlogType' value='0'>个人账号
	                			<span></span>
	                		</label>
	                		<label class='mt-radio'>
	               				<input type='radio' id='type2' name='blogType' class='sysBlogType' value='1'>公司账号
	                			<span></span>
	                		</label>
                    	</div>
						
                    </td>

                </tr>
                
                <tr>
                    <td width="150px" align="right">企业类型:</td>
                    <td width="400px" align="left" colspan="2">
                    	<label class="mt-radio">
                    		<input type="radio" id="enterpriseType1" name="enterpriseType" class="sysEnType" value="0">个体商户
                    		<span></span>	
                    	</label>
                    	<label class="mt-radio">
                    		<input type="radio" id="enterpriseType2" name="enterpriseType" class="sysEnType" value="1">企业
                    		<span></span>
                    	</label>
                    </td>
                    <td>
                    </td>
                </tr>

                <tr>
                    <td width="150px" align="right">企业名称:</td>
                    <td width="400px" align="left" colspan="2">
                        <input type='text'  class="form-control" id="enterpriseNameInput" name='enterpriseName' value=''>
                    </td>
                    <td>
                    </td>
                </tr>

                <tr>
                    <td width="150px" align="right">管理员名称:</td>
                    <td width="400px" align="left" colspan="2">
                        <input type='text'  class='form-control' id='managerName' name='managerName' value=''>
                    </td>
                    <td>
                    </td>
                </tr>
                
                <tr>
                    <td width="150px" align="right">昵称:</td>
                    <td width="400px" align="left" colspan="2">
                        <input type='text'  class='form-control' id='managerNickName' name='managerNickName' value=''>
                    </td>
                    <td>
                    </td>
                </tr>
                
                <tr>
                    <td width="150px" align="right">手机号:</td>
                    <td width="400px" align="left" colspan="2">
                        <input type='text'  class='form-control' id='sysUserMobile' name='mobile' value=''>
                    </td>
                    <td>
                    </td>
                </tr>

                <tr>
                    <td width="150px"></td>
                    <td width="400px" align="center" colspan="2">
                       	<a id="save" href="javascript:void(0) " op="save" class="btn blue" style="margin-left: 60px">创建</a>
                        <!-- <a href="/manager/account/accountList" class="btn yellow" style="margin-left: 60px">返回</a> -->
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
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX%>/common/jquery.qsuggest.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX%>/manager/blog/addBlog.js?<%@include file='/include/.ver'%>"></script>
</html>
