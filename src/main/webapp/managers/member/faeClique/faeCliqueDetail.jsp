<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.caishen91.jupiter.model.*,com.caishen91.jupiter.util.*"%>
<%@ page import="com.caishen91.jupiter.config.Config" %>
<%@ page isELIgnored="true" %>

<%
    FaeClique faeClique = (FaeClique) request.getAttribute("faeClique");
    List<String> faeIssueShortNames = (List<String>) request.getAttribute("faeIssueShortNames");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>基本信息</title>
    <jsp:include page="/common/baseCss.jsp"></jsp:include>
    <link href="/css/newstyle.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
    <script>
        var cliqueId = <%=IDEncryptor.getInstance().encryptWithoutException(faeClique.getId())%>;
    </script>
</head>
<body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white" style="background-color:#fff">
<div style="min-height:800px">
    <div class="portlet box blue">
        <div class="portlet-title">
            <div class="caption">
                &nbsp;会员信息详情</div>
            <div class="tools">
                <a href="javascript:;" class="collapse" data-original-title="" title=""></a>
                <a href="#portlet-config" data-toggle="modal" class="config" data-original-title="" title=""> </a>
            </div>
        </div>
        <div class="portlet-body">
            <div class="tabbable-custom nav-justified">

                <div class="maninput pdt5 pb50" style="border: none">
                    <form id="frm" action=""  method="post">
                        <table rules="none" cellspacing="0" cellpadding="0" border="0px" width="100%" class="table table-light">
                            <tbody>
                            <tr>
                                <td width="15%"></td>
                                <td width="40%" align="right">
                                    <div class="form-group">
                                        <label class="control-label col-md-3">公司全称:
                                            <span class="required" aria-required="true"> * </span>
                                        </label>
                                        <div class="col-md-4">
                                            <input type="text" class="form-control" id="entrustedName" name="name" readonly="readonly" value="<%=faeClique.getName()%>" placeholder="请输入公司全称">
                                        </div>
                                    </div>
                                </td>
                                <td width="10%"></td>
                            </tr>

                            <tr>
                                <td width="15%"></td>
                                <td width="40%" align="right">
                                    <div class="form-group">
                                        <label class="control-label col-md-3">公司简称:
                                            <span class="required" aria-required="true"> * </span>
                                        </label>
                                        <div class="col-md-4">
                                            <input type="text"  class="form-control" id="entrustedShortName" readonly="readonly" name="shortName" value="<%=faeClique.getShortName()%>" placeholder="请输入公司简称">
                                        </div>
                                    </div>
                                </td>
                                <td width="10%"></td>
                            </tr>

                            <tr>
                                <td width="15%"></td>
                                <td width="40%" align="right">
                                    <div class="form-group">
                                        <label class="control-label col-md-3">统一社会信用代码:
                                            <span class="required" aria-required="true"> * </span>
                                        </label>
                                        <div class="col-md-4">
                                            <input type="text"  class="form-control" id="entrustedCreditCode" name="creditCode" readonly="readonly" value="<%=faeClique.getCreditCode()%>" placeholder="请输入社会信用代码">
                                        </div>
                                    </div>
                                </td>
                                <td width="10%"></td>
                            </tr>

                            <tr>
                                <td width="15%"></td>
                                <td width="40%" align="right">
                                    <div class="form-group">
                                        <label class="control-label col-md-3">关联发行人:
                                            <span class="required" aria-required="true"></span>
                                        </label>
                                        <div class="col-md-4">
                                            <textarea class="form-control" rows="3">
                                                <%if (null != faeIssueShortNames && faeIssueShortNames.size() > 0) {
                                                    for (String faeIssueShortName : faeIssueShortNames) {
                                                %>
                                                    <%=faeIssueShortName%><br/>
                                                <%}
                                                }%>
                                            </textarea>
                                        </div>
                                    </div>
                                </td>
                                <td width="10%"></td>
                            </tr>

                            <tr>
                                <td colspan="6" style="text-align:center">
                                    <a class="btn btn-lg green" id="back" href="javascript:void(0);"><span>返回</span></a>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<jsp:include page="/common/baseJs.jsp"></jsp:include>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/common.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript">
    $("#back").click(function(){
        window.location.href = "/manager/clique/toCliqueList";
    });
</script>
</html>

