<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.caishen91.jupiter.config.Config" %>
<%@ page isELIgnored="true" %>

<%
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>未签约商户</title>
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
                &nbsp;未签约商户
            </div>
        </div>

        <div class="portlet-body">
            <form id="query_form" action="/manager/blog/getBlogList">
                <div class="marlr20 dsfbox">
                    <table cellspacing="0" cellpadding="0" border="0px" width="100%" class="table table-light" id="queryTable">
                        <tbody>
                        <tr>
                            <td style="width:100px" align="center">商户名称:</td>
                            <td width="12%" align="left">
                                <input name="blogName" class="form-control" type="text">
                            </td>
                            <td style="width:70px" align="center">姓名:</td>
                            <td width="12%" align="left">
                                <input name="managerName" class="form-control" type="text">
                            </td>
                            <td style="width:70px" align="center">手机号:</td>
                            <td width="12%" align="left">
                                <input name="mobile" class="form-control" type="text">
                            </td>
                            <td>
                                <p style="margin:0px">
                                    <a class="btn blue" id="queryLink" t="1">查询</a>
                                   <!--  <a id="addSysUser" href="javascript:void(0)" class="btn yellow">创建用户</a> -->
                                </p>
                            </td>
                        </tr>
                        <tr>
                        	<td style="width:100px" align="center">账号类型:</td>
                            <td width="15%" align="left">
                                <input type='radio' id='type1' name='blogType' class='sysBlogType' value='0'>个人 &nbsp;&nbsp;
                                <input type='radio' id='type1' name='blogType' class='sysBlogType' value='1'>公司
                            </td>
                            <td style="width:100px" align="center">状态:</td>
                            <td width="15%" align="left">
                                <input type='radio' id='type1' name='blogStatus' class='sysBlogType' value='0'>无效 &nbsp;&nbsp;&nbsp;&nbsp;
                                <input type='radio' id='type1' name='blogStatus' class='sysBlogType' value='1'>有效
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </form>

            <script id="pageListTemplate" type="text/x-jquery-tmpl">
				<tr>
					<td width="27%" align="center">
						${blogName}
					</td>
					<td width="10%" align="center">
						${blogManagerName}
					</td>
					<td width="10%" align="center">
						${mobile}
					</td>
					<td width="8%" align="center">
						${blogType}
					</td>
					<td width="8%" align="center">
						${authStatus}
					</td>
					<td width="6%" align="center">
						${fansCount}
					</td>
					<td width="6%" align="center">
						${subAccount}
					</td>
					<td width="5%" align="center">
						${blogStatus}
					</td>
					<td width="20%" align="center">
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
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/manager/blog/blogTemplate.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/manager/blog/blogManager.js?<%@include file='/include/.ver'%>"></script>

<script type="text/javascript">
     function search(){
        var options={
            queryURL : "/manager/blog/getUnSignBlogList",
            listTitle:[
                {title:"商户名称",width:"27%"},
                {title:"姓名",width:"10%"},
                {title:"手机号",width:"10%"},
                {title:"账号类型",width:"8%"},
                {title:"认证情况",width:"8%"},
                {title:"粉丝数",width:"6%"},
                {title:"子账号",width:"6%"},
                {title:"状态",width:"5%"},
                {title:"操作",width:"20%"}
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