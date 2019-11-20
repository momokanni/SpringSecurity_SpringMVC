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
<title>添加标的</title>

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
				&nbsp;新建产品</div>
			<div class="tools">
				<a href="javascript:;" class="collapse" data-original-title="" title=""></a>
				<a href="#portlet-config" data-toggle="modal" class="config" data-original-title="" title=""> </a>
			</div>
		</div>
		<div class="portlet-body">

        <form action="/manager/product/motifyProduct" method="post" id="frm">
            <table rules="none" cellspacing="0" cellpadding="0" border="0px" width="100%" class="table addpaoductnew" id="queryTable">
                <tbody>
                <tr>
                    <td colspan="3">
                        <div class="mt-repeater-input">
                            <span class="addprotit">产品类型:</span>
                            <label class="mt-radio lineblock bott">
                                <input type="radio" name="productType" checked value="1">定向融资
                                <span></span>
                            </label>
                            <label class="mt-radio bott" style="margin-left: 25px">
                                <input type="radio" name="productType" value="2"> 收益权转让
                                <span></span>
                            </label>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td width="33%">
                        <div><span class="addprotit">产品名称:</span> <%--<span class="required" aria-required="true"> * </span>--%><input type="text" class="form-control offset" name="productName" id="productName" value=""></div>
                    </td>
                    <td width="33%">
                        <div>
                        	<span class="addprotit">发行方:</span>
                                <%--<span class="required" aria-required="true"> * </span>--%>
                            <input type="text" class="form-control offset" id="issueName" name="issueName" value="">
                            <input type="hidden" name="issueId" id="issueId">
                        </div>
                    </td>
                    <td width="33%">
                        <div>
                        	<span class="addprotit">承销商:</span>
                                <%--<span class="required" aria-required="true"> * </span>--%>
                            <input type="text" class="form-control offset" id="underwriterName" name="underwriterName" value="">
                            <input type="hidden" name="underwriterId" id="underwriterId">
                        </div>
                    </td>
                </tr>

                <tr style="">
                    <td width="33%">
                        <div>
                        	<span class="addprotit">担保方:</span>
                                <%--<span class="required" aria-required="true"> * </span>--%>
                            <input type="text" class="form-control offset" name="danbaoName" id="danbaoName" value="">
                            <input type="hidden" name="danbaoId" id="danbaoId">
                        </div>
                    </td>
                    <td width="33%">
                        <div>
                        	<span class="addprotit">受托管理人:</span>
                                <%--<span class="required" aria-required="true"> * </span>--%>
                            <input type="text" class="form-control offset" name="entrustedName" id="entrustedName" value="">
                            <input type="hidden" name="entrustedId" id="entrustedId">
                        </div>
                    </td>
                    <td width="33%"></td>
                </tr>

                <tr style="">
                    <td width="33%">
                        <div>
								<span class="addprotit">募集规模(万元):</span>
                                <%--<span class="required" aria-required="true"> * </span>--%>
                                <input type="text" class="form-control offset" id="raiseAmount" name="raiseAmount" value="">
                        </div>
                    </td>
                    <td width="33%">
                        <div>
								<span class="addprotit"> 产品期限:</span>
                                <%--<span class="required" aria-required="true"> * </span>--%>
                                <input type="text" style="width: 37.5%;display: inline-block;padding-top: 3px" class="form-control offset"id="term" name="term" value="">

                                <select id="termUnit" name="termUnit" class="form-control" style="padding: 0px 0px;width: 50px;display: inline-block" >
                                    <option value="2" selected>月</option>
                                    <option value="1">天</option>

                                </select>
                        </div>
                    </td>
                    <td width="33%">
                        <div>
								<span class="addprotit">预期收益费率(%):</span>
                                <%--<span class="required" aria-required="true"> * </span>--%>
                                <input type="text" class="form-control offset" id="expectRate" name="expectRate" value="">
                        </div>
                    </td>
                </tr>

                <tr style="">
                    <td width="33%">
                        <div>
							<span class="addprotit">认购基数(万元):</span>
                            <%--<span class="required" aria-required="true"> * </span>--%>
                            <input type="text" class="form-control offset" name="baseAmount" id="baseAmount" value="">
                        </div>
                    </td>
                    <td width="33%">
                        <div>
							<span class="addprotit">递增基数(万元):</span>
                            <%--<span class="required" aria-required="true"> * </span>--%>
                            <input type="text" class="form-control offset" name="increaseAmount" id="increaseAmount" value="">
                        </div>
                    </td>
                    <td width="33%">
                        <div>
                            <div class="mt-repeater-input" style="padding-top: 8px">
                                <label class="control-label">认购方式:</label>
                                <label class="mt-radio lineblock bott" style="margin-left: 40px">
                                    <input type="radio" name="buyType" checked value="1">线上
                                    <span></span>
                                </label>
                                <label class="mt-radio bott" style="margin-left: 25px">
                                    <input type="radio" name="buyType"  value="2"> 线下
                                    <span></span>
                                </label>
                            </div>
                        </div>
                    </td>
                </tr>

                <tr style="">
                    <td width="33%">
                        <div>
							<span class="addprotit">存续期计算方式:</span>
                            <%--<span class="required" aria-required="true"> * </span>--%>
                            <select id="holdCalType" name="holdCalType" class="form-control" style="padding: 0px 0px;width:20%;display: inline-block" >
                                <option value="1" selected>固定</option>
                                <option value="2">递减</option>
                            </select>
                            <span>&nbsp;(存续期=产品期限)</span>

                        </div>
                    </td>
                    <td width="33%">
                        <div id="endDateDiv" style="display: none">
							<span class="addprotit"> 截止日:</span>
                            <%--<span class="required" aria-required="true"> * </span>--%>
                            <input style="width: 130px" type="text" class="form-control offset Wdate bdinput"  onclick="WdatePicker()"  name="enDate"  id="enDate">
                            <span>(存续期=截止日-起息日)</span>
                        </div>
                    </td>
                    <td width="33%">
                        <div>
							<span class="addprotit">到期日:</span>
                            <%--<span class="required" aria-required="true"> * </span>--%>
                            <input type="text" style="width: 130px" class="form-control offset Wdate bdinput" onclick="WdatePicker()"  name="dueDate"  id="dueDate" >
                        </div>
                    </td>
                </tr>

                <tr>
                    <td width="33%">
                        <div class="mt-repeater-input" style="padding-top: 8px">
                            <span class="addprotit">是否可转让:</span>
                            <label class="mt-radio lineblock bott">
                                <input type="radio" name="trans" checked value="0">否
                                <span></span>
                            </label>
                            <label class="mt-radio bott" style="margin-left: 25px">
                                <input type="radio" name="trans" value="1">是
                                <span></span>
                            </label>
                        </div>
                    </td>
                    <td width="33%">
                        <div id="lockDiv" style="display: none;">
							<span class="addprotit"> 锁定期:</span>
                            <%--<span class="required" aria-required="true"> * </span>--%>
                            <input type="text" style="width: 37.5%;display: inline-block;padding-top: 3px" class="form-control offset" name="lockTerm" id="lockTerm" value="">

                            <select id="lockUnit" name="lockUnit" class="form-control" style="padding: 0px 0px;display: inline-block" >
                                <option value="2">月</option>
                                <option value="1">天</option>

                            </select>
                        </div>
                    </td>
                    <td width="33%"></td>
                </tr>


                <tr>
                    <td width="33%">
                        <div>
                        	<span class="addprotit" style="width:125px">最低成立金额(万元):</span>
                            <%--<span class="required" aria-required="true"> * </span>--%>
                            <input type="text" class="form-control offset" name="minEstablishAmount" id="minEstablishAmount" value="" placeholder="非必填">
                        </div>
                    </td>
                    <td width="33%">
                        <div class="mt-repeater-input" style="padding-top: 8px">
                            <span class="addprotit">成立方式:</span>
                            <label class="mt-radio lineblock bott">
                                <input type="radio" name="establishType" checked value="1">手动
                                <span></span>
                            </label>
                            <label class="mt-radio bott" style="margin-left: 25px">
                                <input type="radio" name="establishType" value="2">自动
                                <span></span>
                            </label>
                        </div>
                    </td>
                    <td width="33%"></td>
                    
                </tr>
                
                <tr id="establishDayDiv" style="display: none">
                	<td width="33%" colspan="3">
                        <div>
							<span class="addprotit">成立时间:</span>
                            <input type="hidden" id="establishDays" name="establishDays">
                            <%--<span class="required" aria-required="true"> * </span>--%>
                            <span>每个自然月</span>
                            <input type="text" style="width: 50px; display: inline-block" class="form-control" id="establishDay" t="establishDay" value="">

                            <span>日</span>

                            <a id="addEstablishDay" href="javascript:void (0);" class="btn btn-circle btn-default btn-sm" style="margin-left: 20px"><i class="fa fa-plus"></i> Add </a>
                        </div>

                    </td>
                </tr>


                <tr>
                    <td width="33%">
                        <div>
							<span class="addprotit">年化单位</span>
                            <select id="yearCalType" name="yearCalType" class="form-control" style="padding: 0px 0px;width: 100px;display: inline-block" >
                                <option value="360">360天</option>
                                <option value="365">365天</option>

                            </select>
                        </div>
                    </td>
                    <td width="33%">
						<span class="addprotit">结息方式:</span>
                        <select  name="settlementType" id="settlementType" class="form-control" style="padding: 0px 0px;width: 150px;display: inline-block" >

                           <%
                                for(FaeProduct.SettlementType st : FaeProduct.SettlementType.values()){
                           %>
                                    <option value="<%=st.getType()%>" <%=st.getType() == 1 ? "selected" : ""%>><%=st.getDesc()%></option>
                            <%
                                }
                            %>

                        </select>
                    </td>
                     <td width="33%"></td>
                </tr>
                <tr>
                <td width="33%">
                        <div id="fixedRadio" class="mt-repeater-input" style="padding-top: 8px;display: none">
                            <span" style="width:120px">是否固定日期还息:</span>
                            <label class="mt-radio lineblock bott">
                                <input type="radio" name="fixed" value="0" checked>否
                                <span></span>
                            </label>
                            <label class="mt-radio bott" style="margin-left: 25px">
                                <input type="radio" name="fixed" value="1">是
                                <span></span>
                            </label>
                        </div>

                    </td>
                    <td width="33%">
                        <div id="fixDiv" style="display: none">
                            <span id="beforeText">每个自然季度的第</span>
                            <%--<span class="required" aria-required="true"> * </span>--%>
                            <select id="fixedMonth" name="fixedMonth" class="form-control" style="padding: 0px 0px;width: 50px;display: inline-block" >

                            </select>
                            <span id="middleText">个月</span>

                            <input type="text" style="width: 50px; display: inline-block" class="form-control" id="fixedDay" name="fixedDay">
                            <span>日</span>

                        </div>
					</td>
                </tr>
                
                <tr>
                    <td colspan="4" style="border:none">
                        <div class="portlet-title">
                            <div class="caption pd5">
                                <span class="caption-subject bold uppercase colblue ft14">授信信息</span>
                            </div>
                        </div>
                    </td>
                </tr>

                <tr style="">
                    <td width="33%">
                        <div>
							<span class="addprotit">授信主体:</span>
                            <%--<span class="required" aria-required="true"> * </span>--%>
                            <input type="text" class="form-control offset" name="jjsLoanNo" disabled value="">
                        </div>
                    </td>
                    <td width="33%">
                        <div>
							<span class="addprotit"> 授信额度(万元):</span>
                            <%--<span class="required" aria-required="true"> * </span>--%>
                            <input type="text" class="form-control offset" name="jjsLoanNo" disabled value="">
                        </div>
                    </td>
                    <td width="33%">
                        <div>
							<span class="addprotit" style="width:125px">累计申请额度(万元):</span>
                            <%--<span class="required" aria-required="true"> * </span>--%>
                            <input type="text" class="form-control offset" name="jjsLoanNo" disabled value="">
                        </div>
                    </td>
                </tr>

                <tr>
                	 <td colspan="4" style="border:none">
                        <div class="portlet-title">
                            <div class="caption pd5">
                                <span class="caption-subject bold uppercase colblue ft14">服务费设置</span>
                            </div>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td colspan="3">
                        <div class="form-group">
                            <span class="addprotit fl pd10">服务费</span>
                            <div class="col-md-7">
                                <div class="mt-checkbox-inline">
                                    <label class="mt-checkbox" style="margin-bottom: 0px;">
                                        <input type="checkbox" name="fees" value="0">挂牌费
                                        <span></span>
                                    </label>
                                    <label class="mt-checkbox" style="margin-bottom: 0px;margin-left: 10px">
                                        <input type="checkbox" name="fees" value="1">承销商费
                                        <span></span>
                                    </label>
                                    <label class="mt-checkbox" style="margin-bottom: 0px;margin-left: 10px">
                                        <input type="checkbox" name="fees" value="2">受托管理费
                                        <span></span>
                                    </label>
                                </div>
                            </div>
                        </div>
                    </td>
                </tr>

                <tr id="yizhiDiv" style="display: none">
                    <td width="33%">
                        <div class="mt-repeater-input">
                            <span class="addprotit">收费规则</span>
                            <label class="mt-radio lineblock bott" style="margin-left: 10px">
                                <input type="radio" name="yizhi" checked value="1">一致
                                <span></span>
                            </label>
                            <label class="mt-radio bott" style="margin-left: 25px">
                                <input type="radio" name="yizhi" value="2"> 不一致
                                <span></span>
                            </label>
                        </div>
                    </td>
                  <td colspan="3"></td>
                </tr>

                <tr id="yizhiData" style="display:none">
                    <td colspan="3">
						
                        <div style="float:left;">
       
                        	最低额(元):
                            <%--<span class="required" aria-required="true"> * </span>--%>
                            <input type="text" class="form-control offset" name="yizhiMinFee" placeholder="非必填" id="yizhiMinFee" value="">
                        </div>
                        
                        <div style="float:left;">
							年化费率(%):
                            <%--<span class="required" aria-required="true"> * </span>--%>
                            <input type="text" class="form-control offset" id="yizhiRate" name="yizhiRate" value="">
                        </div>
                        
                        <div style="float:left;">
							<span class="addprotit">收费方式:</span>
                            <select id="yizhiType" name="yizhiType" class="form-control" style="padding: 0px 0px;width: 80px;display: inline-block" >

                                <%
                                    for (FaeProduct.FeeType ft:FaeProduct.FeeType.values()){
                                %>
                                <option value="<%=ft.getType()%>"><%=ft.getDesc()%></option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                        
                        <div id="yueJieDayDiv" style="float:left; margin-left:20px;display: none">
                            <span>每个自然月</span>
                            <input type="text" style="width: 50px; display: inline-block" class="form-control" id="yueJieDay" name="yueJieDay" value="">
                            <span>日</span>
                        </div>
                    </td>

                </tr>

                <tr id="hangTr" style="display:none">
                    <td colspan="3">
							
                        <div style="float:left;">
                        	<span class="addprotit">挂牌费:</span>
                        	最低额(元):
                            <%--<span class="required" aria-required="true"> * </span>--%>
                            <input type="text" class="form-control offset" name="hangMinFee" placeholder="非必填" id="hangMinFee" value="" style="width:30%">
                        </div>
                        
                        <div style="float:left;">
                        	年化费率(%):
                            <%--<span class="required" aria-required="true"> * </span>--%>
                            <input type="text" class="form-control offset" id="hangRate" name="hangRate" value="" >
                        </div>
                        
                         <div style="float:left;">
                         	收费方式:
                            <select id="hangFeeType" name="hangFeeType" class="form-control" style="padding: 0px 0px;width: 80px;display: inline-block" >

                                <%
                                for (FaeProduct.FeeType ft:FaeProduct.FeeType.values()){
                                %>
                                <option value="<%=ft.getType()%>"><%=ft.getDesc()%></option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                        
                         <div id="hangYueJieDayDiv" style="float:left; margin-left:40px; display: none">
                            <span>每个自然月</span>
                            <input type="text" style="width: 50px; display: inline-block" class="form-control" id="hangYueJieDay" name="hangYueJieDay" value="">
                            <span>日</span>
                        </div>
                    </td>
                </tr>
                <tr id="cxTr" style="display:none">
                     <td colspan="3">

                        <div style="float:left">
                        	<span class="addprotit">承销商费:</span>
                        	最低额(元):
                            <%--<span class="required" aria-required="true"> * </span>--%>
                            <input type="text" class="form-control offset" name="cxMinFee" placeholder="非必填" id="cxMinFee" value="" style="width:30%">
                        </div>
                        
                        <div style="float:left;">
							年化费率(%):
                            <%--<span class="required" aria-required="true"> * </span>--%>
                            <input type="text" class="form-control offset" id="cxRate" name="cxRate" value="">
                        </div>
                        
                         <div style="float:left;">
							  收费方式:
                            <select id="cxFeeType" name="cxFeeType" class="form-control" style="padding: 0px 0px;width: 50px;display: inline-block" >
                                <%
                                    for (FaeProduct.FeeType ft:FaeProduct.FeeType.values()){
                                %>
                                <option value="<%=ft.getType()%>"><%=ft.getDesc()%></option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                        
                        <div id="cxYueJieDayDiv" style="float:left; margin-left:40px;display: none">
                            <span>每个自然月</span>
                            <input type="text" style="width: 50px; display: inline-block" class="form-control" id="cxYueJieDay" name="cxYueJieDay" value="">
                            <span>日</span>
                        </div>
                    </td>
                </tr>

                <tr id="stTr" style="display:none">
                    <td colspan="3">
                        <div style="float:left;">
                        <span class="addprotit">受托管理费:</span>
                        	最低额(元):
                            <%--<span class="required" aria-required="true"> * </span>--%>
                            <input type="text" class="form-control" style="width:30%;display: inline-block;" name="stMinFee" placeholder="非必填" id="stMinFee" value="">
                        </div>
                        <div  style="float:left;">
							年化费率(%):
                            <%--<span class="required" aria-required="true"> * </span>--%>
                            <input type="text" class="form-control offset" id="stRate" name="stRate" value="">
                        </div>
                        <div  style="float:left;">
							 收费方式:
                            <select id="stFeeType" name="stFeeType" class="form-control" style="padding: 0px 0px;width: 50px;display: inline-block" >
                                <%
                                    for (FaeProduct.FeeType ft:FaeProduct.FeeType.values()){
                                %>
                                <option value="<%=ft.getType()%>"><%=ft.getDesc()%></option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                        
                        <div id="stYueJieDayDiv" style="float:left; margin-left:40px;display: none">
                            <span>每个自然月</span>
                            <input type="text" style="width: 50px; display: inline-block" class="form-control" id="stYueJieDay" name="stYueJieDay" value="">
                            <span>日</span>
                        </div>
                    </td>
  
                </tr>


                <tr>
                    <td colspan="4" style="border:none">
                        <div class="portlet-title">
                            <div class="caption pd5">
                                <span class="caption-subject bold uppercase colblue ft14">其他</span>
                            </div>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td colspan="3">
                        <div class="form-group">
                            <span class="addprotit fl pd5">资金用途:</span>
                            <div class="col-md-9" style="width: 50%;">
                                <textarea id="amountUse" name="amountUse" class="form-control" rows="3"></textarea>
                            </div>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td colspan="3">
                        <div class="form-group">
                            <span class="addprotit fl pd5">增信措施:</span>
                            <div class="col-md-9" style="width: 50%;">
                                <textarea id="increaseCredit" name="increaseCredit" class="form-control" rows="3"></textarea>
                            </div>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td colspan="3">
                        <div class="form-group">
                            <span class="addprotit fl pd5">特殊事项备注:</span>
                            <div class="col-md-9" style="width: 50%;">
                                <textarea id="remark" name="remark" class="form-control" rows="3"></textarea>
                            </div>
                        </div>
                    </td>
                </tr>

                <tr>
                	
                    <td width="" align="center"  colspan="3">
                        <a href="javascript:void(0);" op="save" class="btn btn-lg green">保存</a>
                    </td>
                    <td width="25%" align="center">
                        <%--<a href="javascript:void(0);" id="back" class="btn btn-lg grey">取消</a>--%>
                    </td>
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
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX%>/manager/product/addProduct.js?<%@include file='/include/.ver'%>"></script>


<script type="text/javascript">

	$("#back").click(function(){
        location.href = "/manager/loan/loanList";
	});
</script>
</html>
