<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.caishen91.jupiter.config.Config" %>
<%@ page isELIgnored="true" %>

<%
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>账户管理</title>
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
    </script>
</head>
<body class="page-header-fixed page-sidebar-closed-hide-logo page-content-white" style="background-color:#fff">
<div  style="min-height:800px">
    <div class="portlet box blue ">
        <div class="portlet-title">
            <div class="caption">
                &nbsp;账户管理
            </div>
        </div>

        <div class="portlet-body">
            <form id="query_form" action="">
                <div class="marlr20 dsfbox">
                    <table cellspacing="0" cellpadding="0" border="0px" width="100%" class="table table-light" id="queryTable">
                        <tbody>
                        <tr>
                            <td style="width:70px" align="center">登录名:</td>
                            <td width="12%" align="left">
                                <input name="loginName" class="form-control" type="text">
                            </td>
                            <td>
                                <p style="margin:0px">
                                    <a class="btn blue" id="queryLink" t="1">查询</a>
                                    <a id="addSysUser" href="javascript:void(0)" class="btn yellow">新增</a>
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
						${loginName}
					</td>
					<td width="10%" align="center">
						${mobile}
					</td>
					<td width="10%" align="center">
						${email}
					</td>
					<td width="10%" align="center">
						${companyName}
					</td>
					<td width="10%" align="center">
						${roleName}
					</td>
					<td width="10%" align="center">
						${registerTime}
					</td>
					<td width="10%" align="center">
						${status}
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
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/manager/manager/sysUserTemplate.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/manager/manager/sysUserManager.js?<%@include file='/include/.ver'%>"></script>

<script type="text/javascript">
    function search(){
        var options={
            queryURL : "/manager/sysuser/querySysUserListByParam",
            listTitle:[
                {title:"登录名",width:"10%"},
                {title:"电话",width:"10%"},
                {title:"邮箱",width:"10%"},
                {title:"部门",width:"10%"},
                {title:"岗位",width:"10%"},
                {title:"创建时间",width:"10%"},
                {title:"状态",width:"10%"},
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