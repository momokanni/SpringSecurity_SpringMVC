<%@page import="java.math.BigDecimal"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.caishen91.jupiter.model.*,com.caishen91.jupiter.util.*,com.caishen91.jupiter.enums.*"%>
<%@ page import="com.caishen91.jupiter.config.Config" %>
<%@ page isELIgnored="true" %>

<%

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>合作平台</title>

<jsp:include page="/common/baseCss.jsp"></jsp:include>
<script>
    var time_stamp = '<%@include file='/include/.ver'%>';
    var newUI = true;
</script>

</head>
<body  class="page-header-fixed page-sidebar-closed-hide-logo page-content-white" style="background-color:#fff">
	<div class="portlet box blue">
		<div class="portlet-title">
			<div class="caption">
				<i class="fa fa-gift"></i>添加会员</div>
			<div class="tools">
				<a href="javascript:;" class="collapse" data-original-title="" title=""></a>
				<a href="#portlet-config" data-toggle="modal" class="config" data-original-title="" title=""> </a>
			</div>
		</div>
		<div class="portlet-body">



        <form action="" method="post" id="memberFrm">

            <table rules="none" cellspacing="0" cellpadding="0" border="0px" width="100%" class="table table-light" id="queryTable">
                <tbody>
                <tr>
                    <td width="15%"></td>
                    <td width="40%" align="right">
                        <div class="form-group">
                            <label class="control-label col-md-3">公司全称:
                                <span class="required" aria-required="true"> * </span>
                            </label>
                            <div class="col-md-4">
                                <input type="text" class="form-control" name="name" id="name" value="">
                            </div>
                        </div>
                    </td>
                    <td width="10%"></td>
                </tr>
                <tr>
                    <td width="15%"></td>
                    <td width="40%" align="right">
                        <div class="form-group">
                            <label class="control-label col-md-3">公司简称:
                                <span class="required" aria-required="true"> * </span>
                            </label>
                            <div class="col-md-4">
                                <input type="text"  class="form-control" id="shortName" name="shortName" value="">
                            </div>
                        </div>
                    </td>
                    <td width="10%"></td>
                </tr>

                <tr>
                    <td width="15%"></td>
                    <td width="40%" align="right">
                        <div class="form-group">
                            <label class="control-label col-md-3">统一社会信用代码:
                                <span class="required" aria-required="true"> * </span>
                            </label>
                            <div class="col-md-4">
                                <input type="text"  class="form-control" id="creditCode" name="creditCode" value="">
                            </div>
                        </div>
                    </td>

                    <td width="10%"></td>
                </tr>

                <tr>
                    <td width="15%"></td>
                    <td width="40%" align="right">
                        <a href="javascript:void(0);" op="save" class="btn btn-lg green">保存</a>
                    </td>
                    <td width="40%" align="left">
                        <a href="javascript:void(0);" id="back" class="btn btn-lg grey">取消</a>
                    </td>
                    <td width="10%"></td>
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
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX%>/manager/issue/editIssue.js?<%@include file='/include/.ver'%>"></script>



<script type="text/javascript">

	$("#back").click(function(){
        location.href = "/manager/issue/issueList";
	});
</script>
</html>
