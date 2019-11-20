<%@page import="java.math.BigDecimal"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.util.*,com.caishen91.jupiter.*,com.caishen91.jupiter.*,com.caishen91.jupiter.enums.*"%>
<%@ page import="com.caishen91.jupiter.config.Config" %>
<%@ page import="com.caishen91.jupiter.model.Notice" %>
<%@ page import="com.caishen91.jupiter.util.IDEncryptor" %>
<%@ page isELIgnored="true" %>

<%
    Notice notice =(Notice)request.getAttribute("notice");
    boolean update = (notice != null);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>公告详情</title>
    <jsp:include page="/common/baseCss.jsp"></jsp:include>
    <script>
        var time_stamp = '<%@include file='/include/.ver'%>';
        var newUI = true;
        var update = <%=update%>;
    </script>
</head>
<body style="height:0; background:#fff;">
<div class="portlet box blue">
    <div class="portlet-title">
        <div class="caption">
            <i class="fa fa-gift"></i>公告详情</div>
        <div class="tools">
            <a href="javascript:;" class="collapse" data-original-title="" title=""></a>
            <a href="#portlet-config" data-toggle="modal" class="config" data-original-title="" title=""> </a>
        </div>
    </div>
    <div class="portlet-body">

        <form action="<%=update ? "/manager/notice/updateNotice" : "/manager/notice/addNotice" %>" method="post" id="frm">
            <input name="id" id="id" type="hidden" value="<%=update ? IDEncryptor.getInstance().encryptWithoutException(notice.getId()) : ""%>">
            <div class="marlr20 dsfbox">
                <table align="center" cellspacing="0" cellpadding="0" border="none" width="100%" class="table table-light" id="queryTable">
                    <tbody>
                    <tr>
                        <td width="10%" align="center">公告标题:</td>
                        <td width="10%" align="left">
                            <input id="title" name="title" value="<%=update ? notice.getTitle() : ""%>" type="text" class="form-control input-inline input-medium">
                        </td>
                        <td width="80%" align="center"></td>
                    </tr>

                    <tr>
                        <td width="10%" align="center">内容:</td>
                        <td id="tuwenTr" width="70%" align="left">
                            <textarea id="content" tar="content" name="content" rows="40" style="width:60%;height: 300px" >
                                     <%=update ? notice.getContent() : "" %>
                            </textarea>
                        </td>
                        <td width="20%" align="center"></td>

                    </tr>
                    <tr>
                        <td width="10%" align="center">类型:</td>
                        <td width="10%" align="left">
                            <div class="mt-radio-inline"  style="padding-top: 25px">

                                <%for(Notice.NoticeType noticeType : Notice.NoticeType.values()){

                                %>
                                <label class="mt-radio">
                                    <input type="radio" name="type" <%=(update && notice.getType()==noticeType.getId()) ? "checked" : "" %> value="<%=noticeType.getId()%>"><%=noticeType.getDesc()%>
                                    <span></span>
                                </label>
                                <%}%>


                            </div>
                        </td>
                        <td width="80%" align="center"></td>
                    </tr>

                    <tr>
                        <td width="10%"></td>
                        <td width="25%" align="center">
                            <a href="/manager/notice/noticeList" class="btn yellow" style="margin-left: 60px">返回</a>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </form>
    </div>
</div>

</body>





<jsp:include page="/common/baseJs.jsp"></jsp:include>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/common.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/js/My97DatePicker/WdatePicker.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX%>/common/jquery.qsuggest.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX%>/manager/notice/editNotice.js?<%@include file='/include/.ver'%>"></script>
<script src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/swfupload/swfupload.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX%>/kindeditor/kindeditor.js?<%@include file='/include/.ver'%>"></script>

<script type="text/javascript">

</script>
</html>
