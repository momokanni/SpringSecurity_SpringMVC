<%@page import="java.math.BigDecimal"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.caishen91.jupiter.config.Config,
				 com.caishen91.jupiter.model.*" %>
<%@ page import="com.caishen91.jupiter.util.IDEncryptor" %>
<%@ page isELIgnored="true" %>

<%
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>待还款</title>
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
				&nbsp;待还款
			</div>
		</div>

		<div class="portlet-body">
			<form id="query_form" action="">
				<input type="hidden" name="repayStatus" value="0">
				<div class="marlr20 dsfbox">
					<table cellspacing="0" cellpadding="0" border="0px" width="100%" class="table table-light" id="queryTable">
						<tbody>
						<tr>

							<td width="80px" align="left">产品名称:</td>
							<td width="200px" align="left">
								<input name="productName" class="form-control" style="width:160px" type="text">
							</td>
							<td width="80px" align="left">发行人:</td>
							<td width="200px">
								<input name="issueName" class="form-control" style="width:160px" type="text">
							</td>
							<td align="left">
								<a class="btn blue" id="queryLink" t="1">查询</a><a class="btn yellow" id="resetBtn">重置</a>
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
<script id="totalHeader" type="text">
					<tr>
						<td align="left">
						合计：<font color='red'><b>${total}</b></font>条记录;
							待还总额(元)<font color='red'><b>￥${totalRepay}</b></font>
						</td>
					</tr>
			</script>

<script id="pageListTemplate" type="text">
				<tr>
					<td width="15%" align="center">
						${repayDate}
					</td>

					<td width="10%" align="center">
						${leftDay}
					</td>
					<td width="15%" align="center">
                        ${productName}
					</td>
					<td width="10%" align="center">
						${phase}
					</td>
					<td width="10%" align="center">
                        ${issueName}
					</td>
					<td width="15%" align="center">
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
                {title:"还款日期",width:"15%"},
                {title:"剩余天数",width:"10%"},
                {title:"产品名称",width:"15%"},
                {title:"成立期数/还款期数",width:"10%"},
                {title:"发行方",width:"10%"},
                {title:"待还总额(元)",width:"15%"},
                {title:"状态",width:"10%"},
                {title:"操作",width:"15%"}
            ],
            allSelcet: false,
            orderBy: "",
            pageNo: 1,
            totalHeaderId : "totalHeader",
            totalHeaderPos : "before",
            tempId : "pageListTemplate"
        };
        var param = $("#query_form").serialize();
        options.queryURL = options.queryURL + "?" + param;
        QNR.TableList.init(options);
    }


    $("#queryLink").click(function(){
        search();
    });

    $("#resetBtn").click(function(){
        $("#query_form")[0].reset();
        search();
    });


    search();

</script>
</body>
</html>
