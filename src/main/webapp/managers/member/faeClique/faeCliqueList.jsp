<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.caishen91.jupiter.config.Config" %>
<%@ page import="com.caishen91.jupiter.model.ExcelHandle" %>
<%@ page isELIgnored="true" %>

<%
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>会员列表</title>
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
                &nbsp;集团列表
            </div>
        </div>

        <div class="portlet-body">
            <form id="query_form" action="">
                <div class="marlr20 dsfbox">
                    <table cellspacing="0" cellpadding="0" border="0px" width="100%" class="table table-light" id="queryTable">
                        <tbody>
                        <tr>
                            <td style="width:80px" align="center">公司简称</td>
                            <td width="12%" align="left">
                                <input name="shortName" class="form-control" type="text">
                            </td>
                            <td  style="width:70px; padding-left:30px" align="center">时间</td>
                            <td width="10%">
                                <input type="text" style="width:98%;height:35px" onclick="WdatePicker()" class="Wdate" name="startTime"  id="startTime" class="Wdate bdinput">
                            </td>
                            <td width="10%">
                                <input type="text" style="width:98%;height:35px" onclick="WdatePicker()" class="Wdate" name="endTime"  id="endTime" class="Wdate bdinput">
                            </td>
                            <td>
                                <p style="margin:0px">
                                    <a class="btn blue" id="queryLink" t="1">查询</a>
                                    <a class="btn yellow" href="/manager/olddata/toOldDataImport?t=<%=ExcelHandle.ExcelHandleType.clique.getType()%>">导入</a>
                                    <a class="btn yellow" id="reset">重置</a>
                                </p>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </form>

            <script id="pageListTemplate" type="text/x-jquery-tmpl">
				<tr>
					<td width="10%" align="center">
						${number}
					</td>
					<td width="10%" align="center">
						${shortName}
					</td>
					<td width="10%" align="center">
						${creditCode}
					</td>
					<td width="10%" align="center">
						${issueCount}
					</td>
					<td width="15%" align="center">
						{{each(op, url, target, opType, req_type,div_type,data_url)  opList}}
							<a href="${url}" data-id="${id}" data-url="${data_url}" req-type="${req_type}" div-type="${div_type}"  class="a_blue order_action" target="${target}"  opType="${opType}">【${op}】</a>
						{{/each}}
					</td>
				</tr>
 		</script>
            <div class="maninput nobd">
                <div class="tab colltab">
                    <div class="tab_content pselltdiv"></div>
                    <div id="page"  class="page" style="text-align:center"></div>
                </div>
            </div>
        </div>
    </div>
</div>

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
            queryURL : "/manager/clique/queryFaeCliqueList",
            listTitle:[
                {title:"序号",width:"10%"},
                {title:"公司简称",width:"10%"},
                {title:"统一社会信用代码",width:"10%"},
                {title:"发行人数量",width:"10%"},
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

    $("#reset").click(function(){
        $("#query_form")[0].reset();
        search();
    });

    search();
</script>
</body>
</html>