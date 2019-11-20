<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.caishen91.jupiter.model.*, com.caishen91.jupiter.config.Config"%>
<%@ page isELIgnored="true" %>

<%

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>合作平台</title>

    <jsp:include page="/common/baseCss.jsp"></jsp:include>
    <link rel="stylesheet" href="/front/styles/<%=Config.FRONT_PREFIX%>/qsuggest.css?<%@include file='/include/.ver'%>" />
	<link href="/css/newstyle.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
    <script>
        var time_stamp = '<%@include file='/include/.ver'%>';
        var newUI = true;
        var personType = <%=FaeInvestor.FaeInvestorType.personInvestor.getType()%>;
        var companyType = <%=FaeInvestor.FaeInvestorType.companyInvestor.getType()%>;
    </script>

</head>
<body  class="page-header-fixed page-sidebar-closed-hide-logo page-content-white" style="background-color:#fff">
    <div class="portlet box blue">
    <div class="portlet-title">
        <div class="caption">
            &nbsp;添加会员</div>
        <div class="tools">
            <a href="javascript:;" class="collapse" data-original-title="" title=""></a>
            <a href="#portlet-config" data-toggle="modal" class="config" data-original-title="" title=""> </a>
        </div>
    </div>
    <div class="portlet-body">

        <div class="form-group">
        	<table cellspacing="0" cellpadding="0" border="0px" width="100%" class="table table-light" id="queryTable">
				<tbody>
				<tr>
					<td style="width:80px;vertical-align: initial;" align="left">会员类型:</td>
					<td>
						<label class="mt-radio" style="padding-left:25px">
	                        <input type="radio" name="memberType" checked="checked" value="clique">集团
	                        <span></span>
	                    </label>

	                    <label class="mt-radio" style="margin-left:15px; padding-left:25px">
                        	<input type="radio" name="memberType" value="issue">发行方
                       		<span></span>
	                    </label>

	                    <label class="mt-radio" style="margin-left:15px; padding-left:25px">
	                        <input type="radio" name="memberType" value="danbao">担保方
	                        <span></span>
	                    </label>

	                    <label class="mt-radio" style="margin-left:15px; padding-left:25px">
	                        <input type="radio" name="memberType" value="underwriter">承销商
	                        <span></span>
	                    </label>

	                    <label class="mt-radio" style="margin-left:15px; padding-left:25px">
	                        <input type="radio" name="memberType" value="entrusted">受托管理人
	                        <span></span>
	                    </label>

	                    <label class="mt-radio" style="margin-left:15px; padding-left:25px">
	                        <input type="radio" name="memberType" value="investor">投资人
	                        <span></span>
	                    </label>
					</td>
				</tr>

				</tbody>
			</table>
        </div>


        <%--添加集团会员--%>
        <form action="/manager/clique/addFaeClique" method="post" id="clique">
            <table rules="none" cellspacing="0" cellpadding="0" border="0px" width="100%" class="table table-light">
                <tbody>
                <tr>
                	<td width="25%" align="right">公司全称:<span class="required colred" aria-required="true"> * </span></td>
                    <td width="75%" align="right">
                        <div class="form-group">
                            <div class="col-md-4">
                                <input type="text" class="form-control" id="cliqueName" name="name" value="" placeholder="请输入公司全称">
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                	<td width="25%" align="right">公司简称:<span class="required colred" aria-required="true"> * </span></td>
                    <td width="75%" align="right">
                        <div class="form-group">
                            <div class="col-md-4">
                                <input type="text"  class="form-control" id="cliqueShortName" name="shortName" value="" placeholder="请输入公司简称">
                            </div>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td width="25%" align="right">统一社会信用代码:<span class="required colred" aria-required="true"> * </span></td>
                    <td width="75%" align="right">
                        <div class="form-group">
                            <div class="col-md-4">
                                <input type="text"  class="form-control" id="cliqueCreditCode" name="creditCode" value="" placeholder="请输入统一社会信用代码">
                            </div>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td width="25%"></td>
                    <td width="65%" style=" padding-left:10%">
                        <a href="javascript:void(0);" op="save" class="btn btn-lg green">保存</a>
                    </td>
                </tr>

                </tbody>
            </table>
        </form>

        <%--                    --%>
        <form action="/manager/issue/addFaeIssue" method="post" id="issue" class="dn">
            <table rules="none" cellspacing="0" cellpadding="0" border="0px" width="100%" class="table table-light">
                <tbody>
                <tr>
                	<td width="25%" align="right">公司全称:<span class="required colred" aria-required="true"> * </span></td>
                    <td width="75%" align="right">
                        <div class="form-group">
                            <div class="col-md-4">
                                <input type="text" class="form-control" id="issueName" name="name" value="" placeholder="请输入公司全称">
                            </div>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td width="25%" align="right">所属集团:<span class="required colred" aria-required="true"> * </span></td>
                    <td width="75%" align="right">
                        <div class="form-group">
                            <div class="col-md-4">
                                <input type="text"  class="form-control" name="queryCliqueName" id="queryCliqueName" value="" placeholder="请输入所属集团">
                                <input type="hidden"  class="form-control" name="cliqueId" id="cliqueId" value="">
                            </div>
                        </div>
                    </td>

                </tr>

                <tr>
                	<td width="25%" align="right">公司简称:<span class="required colred" aria-required="true"> * </span></td>
                    <td width="75%" align="right">
                        <div class="form-group">
                            <div class="col-md-4">
                                <input type="text"  class="form-control" id="issueShortName" name="shortName" value="" placeholder="请输入公司简称">
                            </div>
                        </div>
                    </td>
                </tr>

                <tr>
                	<td width="25%" align="right">统一社会信用代码:<span class="required colred" aria-required="true"> * </span></td>
                    <td width="75%" align="right">
                        <div class="form-group">
                            <div class="col-md-4">
                                <input type="text"  class="form-control" id="issueCreditCode" name="creditCode" value="" placeholder="请输入社会信用代码">
                            </div>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td width="25%"></td>
                    <td width="65%" style=" padding-left:10%">
                        <a href="javascript:void(0);" op="save" class="btn btn-lg green">保存</a>
                    </td>
                </tr>

                </tbody>
            </table>
        </form>

        <%--添加担保方会员--%>
        <form action="/manager/danbao/addFaeDanbao" method="post" id="danbao" class="dn">
            <table rules="none" cellspacing="0" cellpadding="0" border="0px" width="100%" class="table table-light">
                <tbody>
                <tr>
                	<td width="25%" align="right">公司全称:<span class="required colred" aria-required="true"> * </span></td>
                    <td width="75%" align="right">
                        <div class="form-group">
                            <div class="col-md-4">
                                 <input type="text" class="form-control" id="danbaoName" name="name" value="" placeholder="请输入公司全称">
                            </div>
                        </div>
                    </td>
                </tr>

                <tr>
                	<td width="25%" align="right">公司简称:<span class="required colred" aria-required="true"> * </span></td>
                    <td width="75%" align="right">
                        <div class="form-group">
                            <div class="col-md-4">
                                 <input type="text"  class="form-control" name="shortName" id="danbaoShortName" value="" placeholder="请输入公司简称">
                            </div>
                        </div>
                    </td>

                </tr>

                <tr>
                	<td width="25%" align="right">统一社会信用代码:<span class="required colred" aria-required="true"> * </span></td>
                    <td width="75%" align="right">
                        <div class="form-group">
                            <div class="col-md-4">
                                 <input type="text"  class="form-control" name="creditCode" id="danbaoCreditCode"  value="" placeholder="请输入社会信用代码">
                            </div>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td width="25%"></td>
                    <td width="65%" style=" padding-left:10%">
                        <a href="javascript:void(0);" op="save" class="btn btn-lg green">保存</a>
                    </td>
                </tr>

                </tbody>
            </table>
        </form>

        <%--添加承销商会员--%>
        <form action="/manager/underwriter/addFaeUnderwriter" method="post" id="underwriter" class="dn">
            <table rules="none" cellspacing="0" cellpadding="0" border="0px" width="100%" class="table table-light">
                <tbody>
                <tr>
                    <td width="25%" align="right">公司全称:<span class="required colred" aria-required="true"> * </span></td>
                    <td width="75%" align="right">
                        <div class="form-group">
                            <div class="col-md-4">
                                 <input type="text" class="form-control" id="underwriterName" name="name" value="" placeholder="请输入公司全称">
                            </div>
                        </div>
                    </td>
                </tr>

                <tr>
                	<td width="25%" align="right">公司简称:<span class="required colred" aria-required="true"> * </span></td>
                    <td width="75%" align="right">
                        <div class="form-group">
                            <div class="col-md-4">
                                <input type="text"  class="form-control" id="underwriterShortName" name="shortName" value="" placeholder="请输入公司简称">
                            </div>
                        </div>
                    </td>
                </tr>

                <tr>
                	<td width="25%" align="right">统一社会信用代码:<span class="required colred" aria-required="true"> * </span></td>
                    <td width="75%" align="right">
                        <div class="form-group">
                            <div class="col-md-4">
                                <input type="text"  class="form-control" id="underwriterCreditCode" name="creditCode" value="" placeholder="请输入社会信用代码">
                            </div>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td width="25%"></td>
                    <td width="65%" style=" padding-left:10%">
                        <a href="javascript:void(0);" op="save" class="btn btn-lg green">保存</a>
                    </td>
                </tr>

                </tbody>
            </table>
        </form>

        <%--添加受托管理人会员--%>
        <form action="/manager/entrusted/addFaeEntrusted" method="post" id="entrusted" class="dn">
            <table rules="none" cellspacing="0" cellpadding="0" border="0px" width="100%" class="table table-light">
                <tbody>
                <tr>
                	<td width="25%" align="right">公司全称:<span class="required colred" aria-required="true"> * </span></td>
                    <td width="75%" align="right">
                        <div class="form-group">
                            <div class="col-md-4">
                                <input type="text" class="form-control" id="entrustedName" name="name" value="" placeholder="请输入公司全称">
                            </div>
                        </div>
                    </td>
                </tr>

                <tr>
                	<td width="25%" align="right">公司简称:<span class="required colred" aria-required="true"> * </span></td>
                    <td width="75%" align="right">
                        <div class="form-group">
                            <div class="col-md-4">
                                 <input type="text"  class="form-control" id="entrustedShortName" name="shortName" value="" placeholder="请输入公司简称">
                            </div>
                        </div>
                    </td>
                </tr>

                <tr>
                	<td width="25%" align="right">统一社会信用代码:<span class="required colred" aria-required="true"> * </span></td>
                    <td width="75%" align="right">
                        <div class="form-group">
                            <div class="col-md-4">
								<input type="text"  class="form-control" id="entrustedCreditCode" name="creditCode" value="" placeholder="请输入社会信用代码">
                            </div>
                        </div>
                    </td>
                </tr>

               <tr>
                    <td width="25%"></td>
                    <td width="65%" style=" padding-left:10%">
                        <a href="javascript:void(0);" op="save" class="btn btn-lg green">保存</a>
                    </td>
                </tr>

                </tbody>
            </table>
        </form>

        <%--添加投资人会员--%>
        <form action="/manager/investor/addFaeInvestor" method="post" id="investor" class="dn">
            <table rules="none" cellspacing="0" cellpadding="0" border="0px" width="100%" class="table table-light">
                <tbody>
                <tr>
                	<td width="25%" align="right">用户类型:<span class="required colred" aria-required="true"> * </span></td>
                    <td width="75%" align="right">
                        <div class="form-group">
                            <div class="col-md-4">
								<select name="type" id="investorType" class="form-control">
                                    <option value="<%=FaeInvestor.FaeInvestorType.personInvestor.getType()%>"><%=FaeInvestor.FaeInvestorType.personInvestor.getDesc()%></option>
                                    <option value="<%=FaeInvestor.FaeInvestorType.companyInvestor.getType()%>"><%=FaeInvestor.FaeInvestorType.companyInvestor.getDesc()%></option>
                                </select>
                            </div>
                        </div>
                    </td>
                </tr>

                <tr class="person">
                    <td width="25%" align="right">真实姓名:<span class="required colred" aria-required="true"> * </span></td>
                    <td width="75%" align="right">
                        <div class="form-group">
                            <div class="col-md-4">
								<input type="text" class="form-control" name="realName" id="investorRealName" placeholder="请输入真实姓名" value="">
                            </div>
                        </div>
                    </td>
                </tr>

                <tr class="person">
                	<td width="25%" align="right">身份证号:<span class="required colred" aria-required="true"> * </span></td>
                    <td width="75%" align="right">
                        <div class="form-group">
                            <div class="col-md-4">
								<input type="text"  class="form-control" name="idCardNo" id="investorIdCardNo" placeholder="请输入身份证号" value="">
                            </div>
                        </div>
                    </td>
                </tr>

                <tr class="person">
                	<td width="25%" align="right">手机号:</td>
                    <td width="75%" align="right">
                        <div class="form-group">
                            <div class="col-md-4">
								<input type="text"  class="form-control" name="mobile" id="investorMobile" placeholder="请输入手机号" value="">
                            </div>
                        </div>
                    </td>
                </tr>

                <tr class="company dn">
                	<td width="25%" align="right">公司名称:<span class="required" aria-required="true"> * </span></td>
                    <td width="75%" align="right">
                        <div class="form-group">
                            <div class="col-md-4">
								<input type="text"  class="form-control" name="companyName" id="investorCompanyName" placeholder="请输入公司名称" value="">
                            </div>
                        </div>
                    </td>
                </tr>

                <tr class="company dn">
                	<td width="25%" align="right">统一社会信用代码:<span class="required" aria-required="true"> * </span></td>
                    <td width="75%" align="right">
                        <div class="form-group">
                            <div class="col-md-4">
								<input type="text"  class="form-control" name="creditCode" id="investorCreditCode" placeholder="请输入统一社会信用代码" value="">
                            </div>
                        </div>
                    </td>
                </tr>

                <tr class="company dn">
                	<td width="25%" align="right">营业执照编号:<span class="required" aria-required="true"> * </span></td>
                    <td width="75%" align="right">
                        <div class="form-group">
                            <div class="col-md-4">
								<input type="text"  class="form-control" name="businessLicense" id="investorBusinessLicense" placeholder="请输入营业执照编号" value="">
                            </div>
                        </div>
                    </td>
                </tr>

                <tr class="company dn">
                	<td width="25%" align="right">法人姓名:<span class="required" aria-required="true"> * </span></td>
                    <td width="75%" align="right">
                        <div class="form-group">
                            <div class="col-md-4">
								<input type="text"  class="form-control" name="legalPersonName" id="investorLegalPersonName" placeholder="请输入法人姓名" value="">
                            </div>
                        </div>
                    </td>
                </tr>

                <tr class="company dn">
                	<td width="25%" align="right">联系人:<span class="required" aria-required="true"> * </span></td>
                    <td width="75%" align="right">
                        <div class="form-group">
                            <div class="col-md-4">
								<input type="text"  class="form-control" name="contacts" id="investorContacts" placeholder="请输入联系人" value="">
                            </div>
                        </div>
                    </td>
                </tr>


                <tr class="company dn">
                	<td width="25%" align="right">联系人电话:<span class="required" aria-required="true"> * </span></td>
                    <td width="75%" align="right">
                        <div class="form-group">
                            <div class="col-md-4">
								<input type="text"  class="form-control" name="contactsTel" id="investorContactsTel" placeholder="请输入联系人电话" value="">
                            </div>
                        </div>
                    </td>
                </tr>

                <tr class="company dn">
                	<td width="25%" align="right">用户来源:
                                <%--<span class="required" aria-required="true"> * </span>--%></td>
                    <td width="75%" align="right">
                        <div class="form-group">
                            <div class="col-md-4">
								<input type="text"  class="form-control" name="userSource" id="investorUserSource" value="">
                            </div>
                        </div>
                    </td>
                </tr>

                <tr>
                	<td width="25%" align="right">推荐人:
                               <%-- <span class="required" aria-required="true"> * </span>--%></td>
                    <td width="75%" align="right">
                        <div class="form-group">
                            <div class="col-md-4">
								<input type="text"  class="form-control" name="referrer" id="investorReferrer" value="">
                            </div>
                        </div>
                    </td>
                </tr>

                <tr>
                    <td width="25%"></td>
                    <td width="65%" style=" padding-left:10%">
                        <a href="javascript:void(0);" op="save" class="btn btn-lg green">保存</a>
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
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX%>/manager/member/addMemberPage.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript">
    $("#back").click(function(){
        location.href = "/manager/issue/issueList";
    });
</script>

</html>
