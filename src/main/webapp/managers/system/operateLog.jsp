<%@page import="java.math.BigDecimal"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.caishen91.jupiter.config.Config" %>
<%@ page isELIgnored="true" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>操作日志</title>
<jsp:include page="/common/baseCss.jsp"></jsp:include>
<link href="/css/TableList.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
<link href="/css/newstyle.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
<style type="text/css">
#queryTable td{
color:black
}
#queryTable input {
display:inherit
}
 .nw_dlg{
	border: 3px solid #3598dc;
	box-shadow: 0 0 8px #3598dc
 }
 tr td{
 	height:45px;
 }
</style>
<script>
	var newUI = true;
</script>
</head>
<body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white" style="background-color:#fff">
<div  style="min-height:800px">
	<div class="portlet box blue ">
		<div class="portlet-title">
			<div class="caption">&nbsp;操作日志</div>
		</div>
		
		<div class="portlet-body"> 
		<form id="query_form" action="">

 		</form>
  		

	<script id="pageListTemplate" type="text/x-jquery-tmpl">
				<tr>
					<td width="10%" align="center">
						${sysName}
					</td>
					<td width="10%" align="center">
						${roleName}
					</td>
					<td width="20%" align="center">
						${logMessage}
					</td>
					<td width="10%" align="center">
						${createTime}
					</td>
				</tr>
 		</script>
		<div class="maninput nobd">
		<div class="tab colltab">
           <div class="tab_content pselltdiv"></div>           
           <div id="page"  class="page" style="text-align:center"></div>
    	</div>
    </div>
 	</div>
</div>
</div>

<jsp:include page="/common/baseJs.jsp"></jsp:include>

<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/common.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/dlgEx.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js?<%@include file='/include/.ver'%>"></script> 
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/querytable.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/TableListEx.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/jquery.pager.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/jquery.tmpl.js?<%@include file='/include/.ver'%>"></script>

<script type="text/javascript">
function search(){
    var options={
	            queryURL : "/manager/sysLog/querySysOperateLog",
	            listTitle:[
			            	{title:"登录名",width:"10%"},
	                       	{title:"角色",width:"10%"},
	                       	{title:"操作描述",width:"20%"},
	                       	{title:"操作时间",width:"10%"},
	                       ],
	            allSelcet: false,
	            orderBy: "",
	            pageNo: 1,
	            tempId : "pageListTemplate"
	        };
   		var param = $("#query_form").serialize();
   		options.queryURL = options.queryURL + "?" + param;
   		QNR.TableList.init(options);
	}

	search();
	
</script>
</body>
</html>
