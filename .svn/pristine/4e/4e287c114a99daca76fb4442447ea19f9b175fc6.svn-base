<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.caishen91.jupiter.config.Config, com.caishen91.jupiter.model.ExcelHandle" %>
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
            <div class="caption">&nbsp;投资人列表</div>
        </div>

        <div class="portlet-body">
            <form id="query_form" action="">
                <div class="marlr20 dsfbox">
                    <table cellspacing="0" cellpadding="0" border="0px" width="100%" class="table table-light" id="queryTable">
                        <tbody>
                        <tr>
                            <td style="width:60px" align="center">姓名</td>
                            <td width="12%" align="left">
                                <input name="name" class="form-control" type="text">
                            </td>
                            <td style="width:80px" align="center">身份证号</td>
                            <td width="12%" align="left">
                                <input name="idCardNo" class="form-control" type="text">
                            </td>
                            <td style="width:80px" align="center">注册时间</td>
                            <td width="9%">
                                <input type="text" style="width:99%;height:35px" onclick="WdatePicker()" class="Wdate" name="startTime"  id="startTime" class="Wdate bdinput">
                            </td>
                            <td width="9%">
                                <input type="text" style="width:99%;height:35px" onclick="WdatePicker()" class="Wdate" name="endTime"  id="endTime" class="Wdate bdinput">
                            </td>
                            <td>
                                <p style="margin:0px">
                                    <a class="btn blue" id="queryLink" t="1">查询</a>
                                    <a class="btn yellow" href="/manager/olddata/toOldDataImport?t=<%=ExcelHandle.ExcelHandleType.investor.getType()%>">导入</a>
                                    <a class="btn yellow" id="newAdd">新增</a>
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
					<td width="5%" align="center">
						${number}
					</td>
					<td width="10%" align="center">
						${name}
					</td>
					<td width="10%" align="center">
						${code}
					</td>
					<td width="5%" align="center">
						${type}
					</td>
					<td width="10%" align="center">
					    {{if bankAccount.length != 0}}
						 <select id="bankAccount" tb="1">
                            {{each bankAccount}}
                                <option>${$value}</option>
						    {{/each}}
                        </select>
                        {{else}}
                            ---
                        {{/if}}
					</td>
					<td width="5%" align="center">
						${investAmount}
					</td>
					<td width="5%" align="center">
						${registerTime}
					</td>
					<td width="10%" align="center">
					    {{if userSource.length != 0}}
                            <select id="userSource" tb="1">
                                {{each userSource}}
                                    <option>${$value}</option>
                                {{/each}}
                            </select>
                        {{else}}
                            ---
                        {{/if}}
					</td>
					<td width="5%" align="center">
						${referrer}
					</td>
					<td width="5%" align="center">
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
            queryURL : "/manager/investor/queryFaeInvestorList",
            listTitle:[
                {title:"序号",width:"5%"},
                {title:"真实姓名/企业名称",width:"10%"},
                {title:"身份证号/统一社会代码",width:"10%"},
                {title:"用户类型",width:"5%"},
                {title:"银行账户",width:"10%"},
                {title:"投资金额",width:"5%"},
                {title:"注册时间",width:"5%"},
                {title:"用户来源",width:"10%"},
                {title:"推荐人",width:"5%"},
                {title:"操作",width:"5%"}
            ],
            allSelcet: false,
            orderBy: "",
            pageNo: 1,
            tempId : "pageListTemplate",
            afterQuery : function() {
                $("select[tb]").selectpicker({width : '150px'});
            }
        };
        var param = $("#query_form").serialize();
        options.queryURL = options.queryURL + "?" + param;
        QNR.TableList.init(options);
    }

    $("#reset").click(function(){
        $("#query_form")[0].reset();
        search();
    });

    $("#queryLink").click(function(){
        search();
    });

    search();

    $("#newAdd").click(function(){
       window.location.href = "/manager/member/toAddMember";
    });
</script>
</body>
</html>