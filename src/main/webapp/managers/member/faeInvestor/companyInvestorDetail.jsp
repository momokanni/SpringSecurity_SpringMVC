<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.caishen91.jupiter.model.*,com.caishen91.jupiter.util.*, com.caishen91.jupiter.config.Config"%>
<%@ page import="java.math.BigDecimal" %>
<%@ page isELIgnored="true" %>

<%
    FaeInvestor faeInvestor = (FaeInvestor)request.getAttribute("faeInvestor");
    List<FaeBankCard> faeBankCards = (List<FaeBankCard>) request.getAttribute("faeBankCards");
    FaeInvestorAccount faeInvestorAccount = (FaeInvestorAccount) request.getAttribute("faeInvestorAccount");
    List<String> underwriterNames = (List<String>) request.getAttribute("underwriterNames");
    BigDecimal investAmount = (BigDecimal) request.getAttribute("investAmount");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>基本信息</title>
    <jsp:include page="/common/baseCss.jsp"></jsp:include>
    <link href="/css/newstyle.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
    <script>
        var investorId = <%=IDEncryptor.getInstance().encryptWithoutException(faeInvestor.getId())%>;
    </script>
</head>
<body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white" style="background-color:#fff">
<div style="min-height:800px">
<div class="portlet box blue">
        <div class="portlet-title">
            <div class="caption">&nbsp;投资人详情</div>
            <div class="tools">
                <a href="javascript:;" class="collapse" data-original-title="" title=""></a>
                <a href="#portlet-config" data-toggle="modal" class="config" data-original-title="" title=""> </a>
            </div>
        </div>
        
        <div class="portlet-body">
                <jsp:include page="/manager/member/faeInvestor/faeInvestorTab.jsp">
                    <jsp:param value="base" name="tab" />
                </jsp:include>

                <%--个人信息--%>
                <div class="col-md-12" style="padding-left: 0px;padding-right: 0px; margin-top: 10px;">
                    <div class="portlet box baby tony">
                    	<div class="portlet-title tabletitle">
                            <div class="caption" style="font-size:16px">公司信息</div>
                        </div>
                        <div class="portlet-body tzrdetail">
                            <div class="">
                            	
                            	<table class="table_show table table-striped table-bordered table-hover" style="width: 100%; border: 0px" cellspacing="0" cellpadding="0">
                                    <tbody>
                                    <tr>
                                    	<td style="border:0"><span>用户ID：</span><b><%=IDEncryptor.getInstance().encryptWithoutException(faeInvestor.getId())%></b></td>
                                    	<td style="border:0"><span>用户类型：</span><b><%=FaeInvestor.FaeInvestorType.getFaeInvestorType(faeInvestor.getType()).getDesc()%></b></td>
                                    	<td style="border:0"><span>企业名称：</span><b><%=faeInvestor.getCompanyName()%></b></td>
                                    </tr>
									<tr>
                                    	
                                    	<td style="border:0"><span style="width:130px">统一社会信用代码：</span><b><%=faeInvestor.getCreditCode()%> </b></td>
                                    	<td style="border:0"><span>营业执照编号：</span><b><%=faeInvestor.getBusinessLicense()%></b></td>
                                    	<td style="border:0"><span>法人姓名：</span><b><%=faeInvestor.getLegalPersonName()%></b></td>
                                    </tr>
                                    <tr>
										<td style="border:0"><span>联系人：</span><b><%=StringUtil.isEmpty(faeInvestor.getContacts()) ? "---" : faeInvestor.getContacts()%></b></td>
                                    	<td style="border:0"><span>联系人电话：</span><b><%=StringUtil.isEmpty(faeInvestor.getContactsTel()) ? "---" : faeInvestor.getContactsTel()%></b></td>
                                    	<td style="border:0"><span>注册时间：</span><b><%=DateUtil.formatDate(faeInvestor.getCreateTime(), "yyyy-MM-dd HH:mm:ss")%></b></td>
                                    </tr>
                                    
                                    <tr>	
                                    	<td style="border:0"><span>推荐人：</span><b><%="0".equals(String.valueOf(faeInvestor.getReferrer())) ? "---" : faeInvestor.getReferrer()%></b></td>
                                    	<td style="border:0"></td>
                                    	<td style="border:0"></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

                <%--银行账户信息--%>
                <div class="col-md-12" style="padding-left: 0px;padding-right: 0px;">
                	<div class="portlet box baby tony">
                    	<div class="portlet-title tabletitle">
                            <div class="caption" style="font-size:16px">银行账户信息</div>
                        </div>
                        <div class="portlet-body tzrdetail">
                            <div class="">
                            	<table class="table_show table table-striped table-bordered table-hover" style="width: 100%; border: 0px" cellspacing="0" cellpadding="0">
                                    <tbody>
                                    <%
                                        if (null != faeBankCards && faeBankCards.size() > 0) {
                                            for (FaeBankCard faeBankCard : faeBankCards) {
                                    %>
                                    <tr>
                                    	<td style="border:0"><span>开户行：</span><b><%=faeBankCard.getBankName()%></b></td>
                                    	<td style="border:0"><span>支行：</span><b><%=faeBankCard.getSlaveName()%></b></td>
                                    	<td style="border:0"><span>银行账号：</span><b><%=faeBankCard.getBankCode()%></b></td>
                                    </tr>
                                    <%
                                            }
                                        }
                                    %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

                <%--账户信息--%>
                <div class="col-md-12" style="padding-left: 0px;padding-right: 0px; margin-top: 10px;">
                	<div class="portlet box baby tony">
                    	<div class="portlet-title tabletitle">
                            <div class="caption" style="font-size:16px">账户信息</div>
                        </div>
                        <div class="portlet-body tzrdetail">
                            <div class="">
                               <table class="table_show table table-striped table-bordered table-hover" style="width: 100%; border: 0px" cellspacing="0" cellpadding="0">
                                    <tbody>
                                    <%if (null != faeInvestorAccount) {%>
                                     <tr>
                                    	<td style="border:0"><span>账户余额：</span><b><%=FormatUtil.formatCurrency(faeInvestorAccount.getBalance())%>元</b></td>
                                    	<td style="border:0" colspan="2">
                                    		<span>待收金额：</span>
	                                    	<b>
	                                    	<%=FormatUtil.formatCurrency(investAmount)%>元&nbsp;
                                                (
												 待收本金:
                                                <%=FormatUtil.formatCurrency(faeInvestorAccount.getToCollectPrincipal())%>元
												 待收利息:
                                                <%=FormatUtil.formatCurrency(faeInvestorAccount.getToCollectInterest())%>元
                                                )
											</b>
										</td>
                                    </tr>
                                    
									<tr>
                                    	<td style="border:0"><span>冻结金额：</span><b><%=FormatUtil.formatCurrency(faeInvestorAccount.getFrozenAmount())%>元</b></td>
                                    	<td style="border:0"><span>累计投资：</span><b><%=FormatUtil.formatCurrency(faeInvestorAccount.getTotalInvest())%>元</b></td>
                                    	<td style="border:0"><span>累计收益：</span><b><%=FormatUtil.formatCurrency(faeInvestorAccount.getTotalIncome())%>元</b></td>
                                    </tr>
                                    <%}%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

                <%--用户来源--%>
                <div class="col-md-12" style="padding-left: 0px;padding-right: 0px; margin-top: 10px;">
                	<div class="portlet box baby tony">
                    	<div class="portlet-title tabletitle">
                            <div class="caption" style="font-size:16px">用户来源</div>
                        </div>
                        <div class="portlet-body tzrdetail">
                            <div class="">
                                <table class="table_show table table-striped table-bordered table-hover" style="width: 100%; border: 0px" cellspacing="0" cellpadding="0">
                                    <tbody>
                                    <tr class="active">
                                        <%
                                            if (null != underwriterNames && underwriterNames.size() > 0) {
                                                for (String underwriterName : underwriterNames) {
                                        %>
                                        <td><div class="row static-info"><div class="col-md-3 value"> <%=underwriterName%> </div></div></td>
                                        <%
                                                }
                                            }
                                        %>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

                <form id="frm" action=""  method="post">
                    <table width="100%" style="padding-top: 20px;"  align="center" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td style="text-align:center">
                                    <a class="btn btn-lg green" id="back" href="javascript:void(0);"><span>返回</span></a>
                                </td>
                        </tr>
                    </table>
                </form>
        </div>
    </div>
</div>
</body>
<jsp:include page="/common/baseJs.jsp"></jsp:include>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/common.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX%>/kindeditor/kindeditor.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" charset="utf-8" src="/front/scripts/<%=Config.FRONT_PREFIX%>/kindeditor/lang/zh_CN.js?<%@include file='/include/.ver'%>"></script>

<script type="text/javascript">
    $("#back").click(function(){
        location.href = "/manager/investor/toInvestorList";
    });

    var init = function () {
    };

    init();
</script>
</html>
