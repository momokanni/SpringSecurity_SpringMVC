<%@page import="java.math.BigDecimal"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.caishen91.jupiter.config.Config" %>
<%@ page isELIgnored="true" %>

<%
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>全部产品</title>
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
			<div class="caption">
				&nbsp;全部产品
			</div>
		</div>
		
		<div class="portlet-body"> 
		<form id="query_form" action="">
			<%--<input type="hidden" id="flag" name="flag" value="repaying">--%>
			<div class="marlr20 dsfbox">
		 	 <table cellspacing="0" cellpadding="0" border="0px" width="100%" class="table table-light" id="queryTable">
	  			<tbody>
	  				<tr>
						<td style="width:80px" align="center">产品名称:</td>
						<td width="10%" align="left">
							<input name="productName" class="form-control" style="width:160px" type="text">
						</td>
	  					<td style="width:80px" align="center">产品类型:</td>
	  					<td width="10%" align="left">
							<select id="productType" name="productType">
								<option value="">请选择</option>
								<option value="1">定向融资</option>
								<option value="2">收益权转让</option>
							</select>
	  					</td>
						<td style="width:80px" align="center">开始时间:</td>
						<td width="10%">
							<input type="text" style="width:98%;height:35px" onclick="WdatePicker()" class="Wdate" name="sDate"  id="sDate" class="Wdate bdinput">
						</td>
						<td style="width:80px" align="center">截止时间:</td>
						<td width="10%">
							<input type="text" style="width:98%;height:35px" onclick="WdatePicker()" class="Wdate" name="eDate"  id="eDate" class="Wdate bdinput">
						</td>
						<td>
							<a class="btn blue" id="queryLink" t="1">查询</a>
							<a class="btn yellow" id="resetBtn">重置</a>
						</td>
	  				</tr>
				</tbody>
	  		</table>

        </div>
 	</form>
  		

	<script id="pageListTemplate" type="text/x-jquery-tmpl">
				<tr>
					<td width="15%" align="center">
						${createTime}
					</td>

					<td width="15%" align="center">
						${productName}
					</td>
					<td width="10%" align="center">
						${productType}
					</td>
					<td width="10%" align="center">
						${issueName}
					</td>
					<td width="10%" align="center">
						${raiseAmount}
					</td>
					<td width="10%" align="center">
						${expectRate}
					</td>
					<td width="10%" align="center">
						${term}${termUnit}
					</td>

					<td width="10%" align="center">
						${statusName}
					</td>

					<td width="15%" align="center">
						{{each(op, url, target, opType, req_type,div_type,data_url)  opList}}				
							<a href="${url}" data-id="${id}" data-url="${data_url}" req-type="${req_type}" div-type="${div_type}"  class="a_blue order_action" target="${target}"  opType="${opType}">【${op}】</a>
						{{/each}}	
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
	            queryURL : "/manager/product/queryFaeProductList",
	            listTitle:[
							{title:"申请时间",width:"15%"},
			            	{title:"产品名称",width:"15%"},
	                       	{title:"产品类型",width:"10%"},
	                       	{title:"发行方",width:"10%"},
	                       	{title:"募集规模(万元)",width:"10%"},
	                       	{title:"预期年化收益率(%)",width:"10%"},

                    		{title:"产品期限",width:"10%"},
                    		{title:"状态",width:"10%"},
	                       	{title:"操作",width:"15%"}
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
	
	
	$("#queryLink").click(function(){
		 search();
	});

	$("#synLoan").click(function(){
        $.ajax({
            url: '/manager/loan/handSynLoan',
            type: 'POST',

            dataType: 'json',
            success: function(data){
                if (data.ret == 1) {
                    bootAlert("同步成功", function(){
                        location.href = "/manager/loan/loanList";
                    });
                } else {
                    if (data.errmsg == "") {
                        bootAlert("操作失败");
                    } else {
                        bootAlert(data.errmsg);
                    }
                }
            }
        });
	});



	
	$("#resetBtn").click(function(){
        $("#productType").val("");
        $("#productType").selectpicker("refresh");
		$("#query_form")[0].reset();
		search();
	});

	var init = function(){
        $("#productType").selectpicker({width : '150px'});
        search();
	}

	init();
	
</script>
</body>
</html>
