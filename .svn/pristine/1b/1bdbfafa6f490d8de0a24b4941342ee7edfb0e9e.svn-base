<%@page import="java.math.BigDecimal"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.caishen91.jupiter.config.Config,
				 com.caishen91.jupiter.model.*" %>
<%@ page import="com.caishen91.jupiter.util.IDEncryptor" %>
<%@ page isELIgnored="true" %>

<%
	FaeProduct product = (FaeProduct)request.getAttribute("product");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>还款计划</title>
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
				&nbsp;还款计划
			</div>
		</div>

		<div class="portlet-body">
			<jsp:include page="/manager/product/productInfoTab.jsp">
				<jsp:param value="repay" name="tab" />
			</jsp:include>
			<form id="query_form" action="">
				<input type="hidden" name="productId" value="<%=product != null ? IDEncryptor.getInstance().encryptWithoutException(product.getId()):""%>">
				<div class="marlr20 dsfbox mt20">
					<table cellspacing="0" cellpadding="0" border="0px" width="100%" class="table table-light" id="queryTable">
						<tbody>
						<tr>

							<td style="width:60px" align="center">状态:</td>
							<td width="12%" align="left">
								<select id="repayStatus" name="repayStatus">
									<option value="" id="select1">请选择</option>
									<option value="2">已还</option>
									<option value="0">未还</option>
								</select>
							</td>
							<td style="width:80px" align="right">开始时间:</td>
							<td width="10%">
								<input type="text" style="width:80%;height:35px" onclick="WdatePicker()" class="Wdate" name="sDate"  id="sDate" class="Wdate bdinput">
							</td>
							<td style="width:80px" align="right">截止时间:</td>
							<td width="10%">
								<input type="text" style="width:80%;height:35px" onclick="WdatePicker()" class="Wdate" name="eDate"  id="eDate" class="Wdate bdinput">
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
			<div class="maninput nobd">
				<div class="tab colltab">
					<div class="tab_content pselltdiv"></div>
					<div id="page"  class="page" style="text-align:center"></div>
				</div>
			</div>
		</div>
	</div>
</div>

<script id="pageListTemplate" type="text">
				<tr>
					<td width="10%" align="center">
						${repayDate}
					</td>
					<td width="10%" align="center">
						${phase}
					</td>
					<td width="10%" align="center">
						${repayPrincipal}
					</td>
					<td width="10%" align="center">
						${repayInterest}
					</td>
					<td width="10%" align="center">
						${totalRepay}
					</td>
					<td width="10%" align="center">
						${repayStatus}
					</td>
					<td width="15%" align="center">
						{{each(op, url, target, opType, req_type,div_type,data_url)  opList}}
							<a href="${url}" data-id="${id}" data-url="${data_url}" req-type="${req_type}" div-type="${div_type}"  class="a_blue order_action" target="${target}"  opType="${opType}">【${op}】</a>
						{{/each}}
					</td>
				</tr>
 		</script>


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
            queryURL : "/manager/repayInfo/queryRepayInfo",
            listTitle:[
                {title:"还款日期",width:"10%"},
                {title:"成立期数/还款期数",width:"10%"},
                {title:"应还本金(元)",width:"10%"},
                {title:"应还利息(元)",width:"10%"},
                {title:"应还总额(元)",width:"10%"},
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

    var init = function(){
        $("#repayStatus").selectpicker({width : '150px'});
        search();
    };
    $("#resetBtn").click(function(){

        $("#repayStatus").val("");
        $("#repayStatus").selectpicker("refresh");
        $("#query_form")[0].reset();
        search();
    });


    init();

</script>
</body>
</html>
