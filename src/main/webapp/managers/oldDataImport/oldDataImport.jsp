<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.caishen91.jupiter.config.Config, com.caishen91.jupiter.model.ExcelHandle" %>
<%@ page isELIgnored="true" %>

<%
    String type = (String) request.getAttribute("type");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>导入管理</title>
    <jsp:include page="/common/baseCss.jsp"></jsp:include>
    <link href="/css/manager/layui.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css"/>
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
        var type = "<%=type%>";
    </script>
</head>
<body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white" style="background-color:#fff">
<div  style="min-height:800px">
    <div class="portlet box blue ">
        <div class="portlet-title">
            <div class="caption">
                <!-- <i class='fa fa-gears'></i> -->&nbsp;交易所数据导入
            </div>
        </div>

        <div class="portlet-body">
            <form id="updateFile" enctype="multipart/form-data" method="post" >
                <div class="marlr20 dsfbox">
                    <table cellspacing="0" cellpadding="0" border="0px" width="100%" class="table table-light" id="queryTable">
                        <tbody>
                        <tr>
                            <td width="80px" align="left">文件类型</td>
                            <td width="500px" align="left" colspan="2">
                                <%
                                    for(ExcelHandle.ExcelHandleType excelHandleType : ExcelHandle.ExcelHandleType.values()) {
                                %>
                                    <input type="radio" value="<%=excelHandleType.getType() %>" name="type" id="type_<%=excelHandleType.getType() %>"/><label for="fType_<%=excelHandleType.getType() %>"><%=excelHandleType.getDesc() %>&nbsp;&nbsp;</label>
                                <%
                                    }
                                %>
                            </td>
                        </tr>
                        <tr>
                            <td width="80px" align="left">选择文件</td>
                            <td width="200px" align="left">
                                <input type="text" id="fileName" readOnly="readonly" name="fileName" class="form-control" style="width:180px" />
                                <input type="file" name="excelFile" id="importFile" style="display: none;">
                            </td>
                            <td>
                                <div>
                                    <a class="btn blue" href="javascript:void(0)"><label for="importFile" style="height:15px">选择文件</label></a>
                                    <a class="btn yellow" href="javascript:void(0)" id="upload" >确定上传</a>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </form>


            <script id="pageListTemplate" type="text/x-jquery-tmpl">
				<tr eid="${id}" p="${process}">
					<td width="10%" align="center">
						${fileName}
					</td>
					<td width="10%" align="center">
						${type}
					</td>
					<td width="15%" align="center">
						${createTime}
					</td>
					<td width="10%" align="center" tt="1">
						${total}
					</td>
					<td width="10%" align="center" sc="1">
						${success}
					</td>
					<td width="10%" align="center" fl="1">
						${failNums}
					</td>
					<td width="10%" align="center" rj="1">
						${repetitionNums}
					</td>

					<td width="15%" align="center">
						<div class="layui-progress">
    						<div class="layui-progress-bar"  style="width: ${process}%;"></div>
  						</div>
					</td>
					<td width="10%" align="center" st="1">
						${status}
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
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/manager/oldDataImport/oldDataImport.js?<%@include file='/include/.ver'%>"></script>

<script type="text/javascript">
    function search(){
        var options={
            queryURL : "/manager/olddata/queryImportResult",
            listTitle:[
                {title:"文件名",width:"10%"},
                {title:"文件类型",width:"10%"},
                {title:"上传时间",width:"15%"},
                {title:"总数据量",width:"10%"},
                {title:"成功数据",width:"10%"},
                {title:"失败数据",width:"10%"},
                {title:"拒绝数据",width:"10%"},
                {title:"处理进度",width:"15%"},
                {title:"状态",width:"10%"}
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

    search();
</script>
</body>
</html>

