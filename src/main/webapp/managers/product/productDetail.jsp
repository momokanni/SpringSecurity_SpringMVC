<%@page import="java.math.BigDecimal"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.caishen91.jupiter.model.*,com.caishen91.jupiter.util.*,com.caishen91.jupiter.enums.*"%>
<%@ page import="com.caishen91.jupiter.config.Config" %>
<%@ page isELIgnored="true" %>

<%

    FaeIssue issue = (FaeIssue) request.getAttribute("issue");
    FaeUnderwriter underwriter = (FaeUnderwriter) request.getAttribute("underwriter");
    FaeDanbao danbao = (FaeDanbao) request.getAttribute("danbao");
    FaeEntrusted entrusted = (FaeEntrusted) request.getAttribute("entrusted");
    FaeProduct product = (FaeProduct) request.getAttribute("product");
    
    
    
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>产品详情</title>

<jsp:include page="/common/baseCss.jsp"></jsp:include>

    <link rel="stylesheet" href="/front/styles/<%=Config.FRONT_PREFIX%>/qsuggest.css?<%@include file='/include/.ver'%>" />
    <link href="/css/newstyle.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
<script>
    var time_stamp = '<%@include file='/include/.ver'%>';
    var newUI = true;
</script>
    <style type="text/css">
        .static-info {
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
				&nbsp;产品详情</div>
			<div class="tools">
				<a href="javascript:;" class="collapse" data-original-title="" title=""></a>
				<a href="#portlet-config" data-toggle="modal" class="config" data-original-title="" title=""> </a>
			</div>
		</div>
		<div class="portlet-body">

            <jsp:include page="/manager/product/productInfoTab.jsp">
                <jsp:param value="base" name="tab" />
            </jsp:include>

        <form action="/manager/product/motifyProduct" method="post" id="frm">
        
	        <table class="table_show table table-striped table-bordered table-hover mt20 productnew" rules="none" id="queryTable" style="width: 100%; border: 0px" cellspacing="0" cellpadding="0">
				<tbody>
					<tr>
						<td style="border:0"><span>产品类型：</span><b><%=FaeProduct.ProductType.getProductType(product.getProductType()).getDesc()%></b></td>
						<td style="border:0"></td>
						<td style="border:0"></td>
					</tr>
					<tr>
						<td style="border:0"><span>产品名称：</span><b><%=StringUtil.isNotEmpty(product.getProductName())? product.getProductName():""%></b></td>
						<td style="border:0"><span>发行方：</span><b><%=issue != null && StringUtil.isNotEmpty(issue.getName())? issue.getName():""%></b></td>
						<td style="border:0"><span>承销商：</span><b><%=underwriter != null && StringUtil.isNotEmpty(underwriter.getName())? underwriter.getName():""%></b></td>
					</tr>
					<tr>
						<td style="border:0"><span>担保方：</span><b><%=danbao != null && StringUtil.isNotEmpty(danbao.getName())? danbao.getName():""%></b></td>
						<td style="border:0"><span>受托管理人：</span><b><%=entrusted != null && StringUtil.isNotEmpty(entrusted.getName())? entrusted.getName():""%></b></td>
						<td style="border:0"></td>
					</tr>
					<tr>
						<td style="border:0"><span>募集规模(万元)：</span><b><%=product.getRaiseAmount() != null && product.getRaiseAmount().doubleValue() > 0? product.getRaiseAmount().divide(DecimalUtil.TenThousand).setScale(2,BigDecimal.ROUND_HALF_EVEN):""%></b></td>
						<td style="border:0"><span>产品期限：</span><b><%=product.getTerm() != 0 ? product.getTerm() + FaeProduct.Unit.getUnitByUint(product.getTermUnit()).getDesc():""%></b></td>
						<td style="border:0"><span>预期收益费率(%)：</span><b><%=product.getExpectRate() != null && product.getExpectRate().doubleValue() > 0? product.getExpectRate():""%></b></td>
					</tr>
					<tr>
						<td style="border:0"><span>认购基数(万元)：</span><b><%=product.getBaseAmount() != null && product.getBaseAmount().doubleValue() > 0? product.getBaseAmount().divide(DecimalUtil.TenThousand).setScale(2,BigDecimal.ROUND_HALF_EVEN):""%></b></td>
						<td style="border:0"><span>递增基数(万元)：</span><b>><%=product.getIncreaseAmount() != null && product.getIncreaseAmount().doubleValue() > 0? product.getIncreaseAmount().divide(DecimalUtil.TenThousand).setScale(2,BigDecimal.ROUND_HALF_EVEN):""%></b></td>
						<td style="border:0"><span>认购方式：</span><b><%=product.getBuyType() != 0? FaeProduct.BuyType.getBuyTypeByType(product.getBuyType()).getDesc():""%></b></td>
					</tr>
					<tr>
						<td style="border:0"><span>存续期计算方式：</span><b><%=product.getHoldCalType() != 0? FaeProduct.HoldCalType.getHoldCalTypeByType(product.getHoldCalType()).getDesc():""%></b></td>
						<td style="border:0" <%=product.getHoldCalType() != 2 ? "style='display: none'":""%> >
							<span>截止日:：</span><b><%=product.getEndDate() != null ? DateUtil.formatDate(product.getEndDate(),"yyyy-MM-dd"):""%></b>
						</td>
						<td style="border:0"><span>到期日：</span><b><%=product.getDueDate() != null ? DateUtil.formatDate(product.getDueDate(),"yyyy-MM-dd"):""%></b></td>
					</tr>
					
					<tr>
						<td style="border:0"><span>是否可转让：</span><b><%=product.isTrans() ? "是":"否"%></b></td>
						<td style="border:0" <%=!product.isTrans() ? "style='display: none'":""%>><span>锁定期：</span><b><%=product.getLockTerm() != 0 ? product.getLockTerm() + FaeProduct.Unit.getUnitByUint(product.getLockUnit()).getDesc():""%></b></td>
						<td style="border:0"></td>
					</tr>
					
					<tr>
						<td style="border:0"><span>最低成立金额(万元):：</span><b><%=product.getMinEstablishAmount() != null && product.getMinEstablishAmount().doubleValue() > 0? product.getMinEstablishAmount().divide(DecimalUtil.TenThousand).setScale(2,BigDecimal.ROUND_HALF_EVEN):"---"%></b></td>
						<td style="border:0"><span>成立方式：</span><b><%=product.getEstablishType() != 0 ? FaeProduct.EstablishType.getEstablishTypeByType(product.getEstablishType()).getDesc():""%></b></td>
						<td style="border:0" <%=product.getEstablishType() != 2 ? "style='display: none'":""%>><span>成立时间：</span><b> 每个自然月
                                <%=StringUtil.isNotEmpty(product.getEstablishDay()) ? product.getEstablishDay() : ""%>日</b></td>
					</tr>
					
					<tr>
						<td style="border:0"><span>年化单位：</span><b><%=product.getYearCalType() != 0 ? product.getYearCalType() + "天":""%></b></td>
						<td style="border:0"><span>结息方式：</span><b><%=product.getSettlementType() != 0 ? FaeProduct.SettlementType.getSettlementTypeByType(product.getSettlementType()).getDesc():""%></b></td>
						<td style="border:0" <%=product.getSettlementType() <= 1  ? "style='display: none'":""%> ><span>是否固定日期还息：</span>
							<b><%=product.isFixed() ? "是":"否"%></b>
						
							<b style="margin-left:20px" <%=!product.isFixed() ? "style='display: none'":""%>>
							<%
                                    if(product.isFixed() && product.getSettlementType() >= 2){

                                        if(product.getSettlementType() == 2){
                                            out.print("每个自然月" + product.getFixedDay() + "日");
                                        }
                                        else if(product.getSettlementType() == 3){
                                            out.print("每个自然季度的第" + product.getFixedMonth() + "个月" + product.getFixedDay() + "日");
                                        }
                                        else if(product.getSettlementType() == 4){
                                            out.print("每个自然半年的第" + product.getFixedMonth() + "个月" + product.getFixedDay() + "日");
                                        }
                                        else if(product.getSettlementType() == 5){
                                            out.print("每个自然年的第" + product.getFixedMonth() + "个月" + product.getFixedDay() + "日");
                                        }
                                    }
                                    %>
								</b>
						</td>
					</tr>
					
				</tbody>
			</table>
			
			<div class="portlet-title tabletitle mt20">
				<div class="caption" style="font-size:16px">授信信息</div>
			</div>	
			 <table class="table_show table table-striped table-bordered table-hover mt15 productnew" rules="none" id="queryTable" style="width: 100%; border: 0px" cellspacing="0" cellpadding="0">
				<tbody>
					<tr>
						<td style="border:0"><span>授信主体：</span><b>---</b></td>
						<td style="border:0"><span>授信额度(万元)：</span><b>---</b></td>
						<td style="border:0"><span>累计申请额度(万元)：</span><b>---</b></td>
					</tr>
				</tbody>
			</table>
			
			<div class="portlet-title tabletitle mt20">
				<div class="caption" style="font-size:16px">服务费信息</div>
			</div>
			<table class="table_show table table-striped table-bordered table-hover mt15 productnew" rules="none" id="queryTable" style="width: 100%; border: 0px" cellspacing="0" cellpadding="0">
				<tbody>
					<tr>
						<td style="border:0" colspan="3" >
							<span>服务费</span>
							<div style="float:left; padding:0" class="mt-checkbox-inline">
                                    <label class="mt-checkbox" style="margin-bottom: 0px;margin-left: 10px">
                                        <input type="checkbox" name="fees" value="0" disabled <%=product.isHasHang() ? "checked ": ""%>>挂牌费
                                        <span style="min-width:18px"></span>
                                    </label>
                                    <label class="mt-checkbox" style="margin-bottom: 0px;margin-left: 10px">
                                        <input type="checkbox" name="fees" value="1" disabled <%=product.isHasCx() ? "checked": ""%>>承销商费
                                        <span style="min-width:18px"></span>
                                    </label>
                                    <label class="mt-checkbox" style="margin-bottom: 0px;margin-left: 10px">
                                        <input type="checkbox" name="fees" value="2" disabled <%=product.isHasSt() ? "checked": ""%>>受托管理费
                                        <span style="min-width:18px"></span>
                                    </label>
							</div>
						</td>
					</tr>
					<tr id="hangTr" <%=product.isHasHang() ? "": "style='display:none'"%>>
						<td style="border:0"><span>挂牌费：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;最低额(元):</span><b><%=product.getHangMinFee() != null && product.getHangMinFee().doubleValue() > 0 ? product.getHangMinFee() :"---"%></b></td>
						<td style="border:0"><span>年化费率(%)：</span><b>><%=product.getHangRate() != null && product.getHangRate().doubleValue() > 0  ? product.getHangRate() :"---"%></b></td>
						<td style="border:0">
							<span>收费方式：</span>
							<b><%=product.getHangFeeType() != 0 ? FaeProduct.FeeType.getFeeTypeByType(product.getHangFeeType()).getDesc() :"---"%></b>
							<b style="margin-left:20px" <%=product.getHangFeeType() == 3 ? "": "style='display:none'"%>>
								每个自然月<%=product.getHangYjDay()%>日
							</b>
						</td>
					</tr>
					
					<tr id="cxTr" <%=product.isHasCx() ? "": "style='display:none'"%> >
						<td style="border:0"><span>承销商费:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;最低额(元):</span><b><%=product.getCxMinFee() != null && product.getCxMinFee().doubleValue() > 0 ? product.getCxMinFee() :"---"%></b></td>
						<td style="border:0"><span>年化费率(%)：</span><b>><%=product.getCxRate() != null && product.getCxRate().doubleValue() > 0  ? product.getCxRate() :"---"%></b></td>
						<td style="border:0">
							<span>收费方式：</span>
							<b><%=product.getCxFeeType() != 0 ? FaeProduct.FeeType.getFeeTypeByType(product.getCxFeeType()).getDesc() :"---"%></b>
							<b style="margin-left:20px" <%=product.getCxFeeType() == 3 ? "": "style='display:none'"%> >
								每个自然月<%=product.getCxYjDay()%>日
							</b>
						</td>
					</tr>
					<tr id="danbaoTr" <%=product.isHasSt() ? "": "style='display:none'"%> >
						<td style="border:0"><span>受托管理费:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;最低额(元):</span><b><%=product.getStMinFee() != null && product.getStMinFee().doubleValue() > 0 ? product.getStMinFee() :"---"%></b></td>
						<td style="border:0"><span>年化费率(%)：</span><b><%=product.getStRate() != null && product.getStRate().doubleValue() > 0  ? product.getStRate() :"---"%></b></td>
						<td style="border:0">
							<span>收费方式：</span>
							<b><%=product.getStFeeType() != 0 ? FaeProduct.FeeType.getFeeTypeByType(product.getStFeeType()).getDesc() :"---"%></b>
							<b style="margin-left:20px" <%=product.getStFeeType() == 3 ? "": "style='display:none'"%> >
								每个自然月<%=product.getStYjDay()%>日
							</b>
						</td>
	                </tr>         
				</tbody>
			</table>

			<div class="portlet-title tabletitle mt20">
				<div class="caption" style="font-size:16px">其他</div>
			</div>
			<table class="table_show table table-striped table-bordered table-hover mt15 productnew" rules="none" id="queryTable" style="width: 100%; border: 0px" cellspacing="0" cellpadding="0">
			<tbody>
				<tr>
					<td style="border:0"  colspan="3">资金用途：<span></span><b style="width: 60%;"><%=StringUtil.isNotEmpty(product.getAmountUse()) ? product.getAmountUse():"---"%></b></td>
				</tr>
				<tr>
					<td style="border:0"  colspan="3">增信措施：<span></span><b style="width: 60%;"><%=StringUtil.isNotEmpty(product.getIncreaseCredit()) ? product.getIncreaseCredit():"---"%></b></td>
				</tr>
				<tr>
					<td style="border:0"  colspan="3">特殊事项备注：<span></span><b style="width: 60%;"><%=StringUtil.isNotEmpty(product.getRemark()) ? product.getRemark():"---"%></b></td>
				</tr>
			</tbody>
			</table>
					

				
			<table class="table" rules="none" id="queryTable" style="width: 100%; border: 0px" cellspacing="0" cellpadding="0">
			<tbody>
				 <tr>
                    <td width="25%" style="border:0"></td>
                    <td width="25%" align="right" style="border:0">
                        <%--<a href="javascript:void(0);" op="save" class="btn btn-lg green">保存</a>--%>
                        <a href="javascript:void(0);" id="back" class="btn btn-lg grey">返回</a>
                    </td>
                    <td width="25%" align="left" style="border:0">

                    </td>
                    <td width="25%" style="border:0"></td>
                    <td width="25%" style="border:0"></td>
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
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX%>/common/jquery.qsuggest.js?<%@include file='/include/.ver'%>"></script>
<%--<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX%>/manager/product/addProduct.js?<%@include file='/include/.ver'%>"></script>--%>


<script type="text/javascript">

	$("#back").click(function(){
        location.href = "/manager/product/repayingProduct";
	});
</script>
</html>
