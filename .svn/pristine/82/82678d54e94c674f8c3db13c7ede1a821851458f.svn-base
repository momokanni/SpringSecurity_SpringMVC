<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.caishen91.jupiter.config.Config"%>
<%@ page isELIgnored="true" %>

<%
    String department = (String) request.getAttribute("department");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>角色管理</title>
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
        .modal{
            margin-top: -30%;
            height: 0px;
            width: 0px;
            left: 40%;
        }
        .modal.fade.in {
            top: 20%;
        }

    </style>
    <script>
        var newUI = true;
        var sysDepartment = <%=department%>;
    </script>
</head>
<body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white" style="background-color:#fff">
<div  style="min-height:800px">
    <div class="portlet box blue ">
        <div class="portlet-title">
            <div class="caption">
                &nbsp;岗位管理
            </div>
        </div>

        <div class="portlet-body">
            <form id="query_form" action="">
                <div class="marlr20 dsfbox">
                    <table cellspacing="0" cellpadding="0" border="0px" width="100%" class="table table-light" id="queryTable">
                        <tbody>
                        <tr>
                            <td width="20%">
                                <p style="margin:0px">
                                    <a id="addSysRole" href="javascript:void(0)" class="btn blue">创建角色</a>
                                </p>
                            </td>
                            <td width="80%"></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </form>

            <script id="pageListTemplate" type="text/x-jquery-tmpl">
				<tr>
					<td width="10%" align="center">
						${roleName}
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
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/TableListEx.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/querytable.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/jquery.pager.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/jquery.tmpl.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/manager/manager/sysRoleTemplate.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/manager/manager/sysRoleManager.js?<%@include file='/include/.ver'%>"></script>

<script type="text/javascript">
    function search(){
        var options={
            queryURL : "/manager/sysrole/querySysRoleList",
            listTitle:[
                {title:"角色",width:"10%"},
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

    search();
</script>
</body>
</html>