<%@page import="java.math.BigDecimal"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.caishen91.jupiter.config.Config,
				 com.caishen91.jupiter.model.*" %>
<%@ page import="com.caishen91.jupiter.util.IDEncryptor" %>
<%@ page isELIgnored="true" %>

<%
	FaeInvestor investor = (FaeInvestor)request.getAttribute("faeInvestor");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>投资记录</title>
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
		.sorting {
			background: url("/images/manager/sort_both.png") no-repeat center right;
		}

		.desc {
			background: url("/images/manager/sort_desc.png") no-repeat center right;
		}
		.asc {
			background: url("/images/manager/sort_asc.png") no-repeat center right;
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
				&nbsp;投资记录
			</div>
		</div>

		<div class="portlet-body">
				<jsp:include page="/manager/member/faeInvestor/faeInvestorTab.jsp">
					<jsp:param value="record" name="tab" />
				</jsp:include>
				<form id="query_form" action="">
					<input type="hidden" name="investorId" value="<%=investor != null ? IDEncryptor.getInstance().encryptWithoutException(investor.getId()):""%>">
					<div class="marlr20 dsfbox">
						<table cellspacing="0" cellpadding="0" border="0px" width="100%" class="table table-light" id="queryTable">
							<tbody>
                            <tr>
                                <td>
                                    <div style="width: 40%;display: inline-block;">
                                        <div class="mt-repeater-input" style="padding-top: 8px">
                                            <label class="control-label"></label>
											<label class="mt-radio lineblock bott"">
												<input type="radio" name="flag" checked value="">全部投资
												<span></span>
											</label>
                                            <label class="mt-radio lineblock bott" style="margin-left: 25px">
                                                <input type="radio" name="flag" value="1">当前投资
                                                <span></span>
                                            </label>
                                            <label class="mt-radio bott" style="margin-left: 25px">
                                                <input type="radio" name="flag"  value="2"> 历史投资
                                                <span></span>
                                            </label>
                                        </div>
                                    </div>
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
							认购<font color='red'><b>${total}</b></font>笔;
							累计认购金额<font color='red'><b>${totalInvestAmount}</b></font>元;
						</td>
					</tr>
			</script>

<script id="pageListTemplate" type="text">
				<tr>
					<td width="10%" align="center">
						${productName}
					</td>
					<td width="15%" align="center">
						${expectRate}
					</td>
					<td width="10%" align="center">
						${investTime}
					</td>
					<td width="10%" align="center">
						${investAmount}
					</td>
					<td width="10%" align="center">
						${establishDate}
					</td>
					<td width="10%" align="center">
						${incomeTerm}
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
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/manager/product/product_template.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript">



    function search(){
        var options={
            queryURL : "/manager/investRecord/queryInvestRecord",
            listTitle:[
                {title:"产品名称",width:"10%"},
                {title:"预期年化收益率(%)",width:"15%"},
                {title:"投资时间",width:"10%"},
                {title:"投资金额(元)",width:"10%",cls:"sorting",sort:"sort='investAmount'"},
                {title:"起息日",width:"10%",cls:"sorting",sort:"sort='establishDate'"},
                {title:"存续期",width:"10%",cls:"sorting",sort:"sort='incomeTerm'"},
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


    /*$("#queryLink").click(function(){
        QNR.TableList.query();
    });*/

    $("[name=flag]").change(function(){
        search();
    });




    search();

</script>
</body>
</html>
