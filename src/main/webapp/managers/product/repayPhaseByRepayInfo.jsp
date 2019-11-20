<%@page import="java.math.BigDecimal"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.caishen91.jupiter.config.Config,
				 com.caishen91.jupiter.model.*" %>
<%@ page import="com.caishen91.jupiter.util.IDEncryptor" %>
<%@ page isELIgnored="true" %>

<%
	FaeRepayInfo repayInfo = (FaeRepayInfo)request.getAttribute("repayInfo");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>回款详细</title>
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
				&nbsp;回款详细
			</div>
		</div>

		<div class="portlet-body">
			<form id="query_form" action="">
				<input type="hidden" name="repayInfoId" value="<%=repayInfo != null ? IDEncryptor.getInstance().encryptWithoutException(repayInfo.getId()):""%>">
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
						<td align="center">
							<font size='3'>应还本金(元)</font><font color='red' class='ft24'><b>${repayPrincipal}</b></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<font size='3'>应还利息(元)</font><font color='red' class='ft24'><b>${repayInterest}</b></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<font size='3'>应还总额(元)</font><font color='red' class='ft24'><b>${totalRepay}</b></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
						<td style="width:5%;" align="left">
							<p style="margin:0px">
								<a class="btn yellow" onclick="exportExcel()" href="javascript:void(0)">导出</a>
							</p>
                         </td>
					</tr>
			</script>


<script id="pageListTemplate" type="text">
				<tr>
					<td width="10%" align="center">
						${num}
					</td>
					<td width="10%" align="center">
						${investorName}
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
						${certNo}
					</td>
					<td width="10%" align="center">
						${bankCode}
					</td>
					<td width="10%" align="center">
						${bankName}
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
            queryURL : "/manager/repayPhase/queryRepayPhase",
            listTitle:[
                {title:"序号",width:"10%"},
                {title:"投资人名称",width:"10%"},
                {title:"应回本金(元)",width:"10%"},
                {title:"应回利息(元)",width:"10%"},
                {title:"应回总额(元)",width:"10%"},
                {title:"证件号",width:"10%"},
                {title:"银行卡号",width:"10%"},
                {title:"开户行",width:"10%"}
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



    function exportExcel() {
        var param = $("#query_form").serialize();
        window.location.href = "/manager/repayPhase/queryRepayPhaseExport" + "?" + param;
	}

</script>
</body>
</html>
