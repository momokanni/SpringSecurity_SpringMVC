<%@ page import="com.caishen91.jupiter.model.BlogLabel" %>
<%@ page import="java.util.List" %>
<%@ page import="com.caishen91.jupiter.config.Config" %>
<%@ page import="com.caishen91.jupiter.util.IDEncryptor" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE HTML>
<%
    List<BlogLabel> blogLabels=(List<BlogLabel>)request.getAttribute("blogLabels");
    BlogLabel blogLabelUpdate=(BlogLabel)request.getAttribute("blogLabelUpdate");
    boolean update = (blogLabelUpdate != null);
%>
<html>
<head>
    <title>内容管理平台</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport">
    <link href="/css/blog/common.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
    <link href="/css/blog/jianrong.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">

    <script>

        var update = <%=update%>;

    </script>
</head>

<body class="bg">
<jsp:include page="/blogPlatform/common/top.jsp"/>
<jsp:include page="/blogPlatform/common/leftMenu.jsp"/>

<!--右侧内容 文章详情-->
<div id="mainbody" class="mainbody">

    <!--二级页标题-->
    <div class="bigtitle mt20"><b class="ft22 fapf">栏目管理</b></div>
    <!--二级页标题 end-->

    <div class="clearfix mt15 bgf radius3 shadow pd35 plr35">
        <form id="query_form" action="">
        <!--筛选-->
        <div class="bq_screen clearfix">
            <div class="screen_inp fl">
                <span class="fl ft14 colgblock">栏目名称：</span>
                <input type="text" placeholder="" name="name"  class="inputbox">
            </div>

            <div class="screen_inp fl" style="margin-left:8%" id="sts">
                <span class="fl ft14 colgblock">状态：</span>
                <label  name="radioLabel" id="rl1" class="label label_check "><!--选中c_in-->
                    <input type="radio" name="status" value="1">
                    <span>有效</span>
                </label>
                <label name="radioLabel" id="rl0"  class="label label_check"><!--选中c_in-->
                    <input type="radio" name="status" value="0">
                    <span>无效</span>
                </label>
            </div>

            <div class="screen_btn fr">
                <a href="javascript:void(0)"  id="chaxun" class="colf border_blue bgrblue bgrblue_hov transition ft14 button fl">查询</a>
                <security:authorize access="hasRole('TJLM')"> 
                	<a href="javascript:void(0)" class="border_blue bgf colblue02 colbule_hov transition ft14 button fr" id="newCreate">添加栏目</a>
                </security:authorize>
            </div>
        </div>
        </form>
        <!--筛选 end-->

        <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_top mt30">
            <tr>
                <td class="colmd-5" style="text-align:center;">栏目名称</td>
                <td class="colmd-7" style="text-align:center;">栏目描述</td>
                <td class="colmd-3" style="text-align:center;">状态</td>
                <td class="colmd-5" style="text-align:center;">操作</td>
            </tr>
        </table>

        <!--标签列表 end-->
        <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_list mt5" id="tab">
        </table>
        <script id="lableTemplate" type="text/x-jquery-tmpl">
	   		{{each(i,data) content}}
            	<tr>
                	<td class="colmd-5" style="text-align:center;"><span>{{= data.name}}</span></td>
                	<td class="colmd-7" style="text-align:center;"><span>{{= data.description}}</span></td>
                	<td class="colmd-3" style="text-align:center;"><span>{{= data.statusStr}}</span></td>
                	<td class="colmd-5" style="text-align:center;">
						<span>
							<security:authorize access="hasRole('XGLMZT')"> 
                				{{if (data.statusStr == "有效")}}
                    				<a href="javascript:void(0);" data="{{= data.idStr}}" onclick="setStatus('{{= data.idStr}}')" class="colblue02 colbule_hov">禁用</a>&nbsp;&nbsp;&nbsp;
                   				{{/if}}
                     			{{if (data.statusStr == "无效")}}
                    				<a href="javascript:void(0);" data="{{= data.idStr}}" onclick="setStatus('{{= data.idStr}}')" class="colblue02 colbule_hov">启用</a>&nbsp;&nbsp;&nbsp;
                  				{{/if}}
							</security:authorize>
							<security:authorize access="hasRole('BJLM')"> 
                    			<a id="editA" onclick="editLabel('{{= data.idStr}}')" style="cursor: pointer;"   class="colblue02 colbule_hov">编辑</a>
							</security:authorize>
                		</span>
					</td>
            	</tr>
	  		{{/each}}
		</script>
    </div>

    <!--公用底部-->
    <div id="footer" class="footer textcent ft12 clearfix">
        <a href="#" class="ft14 colbule_hov transition">关于91财经</a>|<a href="#" class="ft14 colbule_hov transition">服务协议</a>|<a href="#" class="ft14 colbule_hov transition">联系邮箱</a>|<a href="#" class="ft14 colbule_hov transition">联系电话</a>
        <span class="ft14">Copyright © 2018-2019 91Caijing  All Rights Reserved</span>
    </div>
    <!--公用底部 end-->
</div>
<!--右侧内容   文章详情 end-->
	<security:authorize access="hasRole('WZLMTSDFXZ')"> 
		<div id="upTipWindow" class="dn">
			<div class="zhezhao"></div>
		    <div class="tk_box radius3 bgf">
		    	<div class="tk_top ft14 colgray02 plr20">
		    		<a href="#" class="icon tk_close fr closeTip"></a>提示
		    	</div>
		        <div id="tipMsg" class="tk_tit ft18 textcent pd30">是否与分享赚同步？</div>
		        <div class="tk_btn">
		        	<a id="cancelShare" href="javascript:void(0);" class="button bgf6 colgray04 border_gray transition ft14 colbule_hov closeTip closeTip">不推</a>
		        	<a id="shareLm" href="javascript:void(0);" class="button bgrblue bgrblue_hov colf transition border_blue ft14">推送</a>
		        </div>
		    </div>
		</div>
	</security:authorize>

<!--添加标签 弹框-->
<form action="/blog/lable/addLable" method="post" id="addFrm" accept-charset="UTF-8">
	<div id="addlabel" class="dn">
	    <div class="zhezhao"></div>
	    <div class="tk_box radius3 bgf" style="margin-top:-135px">
	        <div class="tk_top ft14 colgray02 plr20">
	        	<a href="javascript:void(0)" class="icon tk_close fr cancel"></a>
	        	创建栏目
	        </div>
	        <div class="screen_inp mt30" style=" padding-left:46px">
	            <span class="fl ft14 colgblock">栏目名称：</span>
	            <input type="text" placeholder="" name="name" id="name" value="" class="inputbox" style="width:210px">
	        </div>
	
	        <div class="screen_inp mt20" style=" padding-left:46px; height:70px">
	            <span class="fl ft14 colgblock">栏目描述：</span>
	            <textarea  class="inputbox fapf" style="width:210px; height:50px;" name="scc" id="desc" ></textarea>
	        </div>
	        <security:authorize access="hasRole('WZLMTSDFXZ')"> 
	        	<div class="mt20">
	            	<input type="checkbox" class="fl" name="share" style="border:1px solid blue;width:15px;height:15px;-webkit-appearance:checkbox;margin-right:15px;margin-left:100px;"/> 
	            	<span class="ft14 colgblock">推送到分享赚</span>
	        	</div>
			</security:authorize>
	        <div class="tk_btn mt20">
	            <a href="javascript:void(0)" class="cancel button bgf6 colgray04 border_gray transition ft14 colbule_hov">取消</a>
	            <a href="javascript:void(0)" id="createLabel" class="button bgrblue bgrblue_hov colf transition border_blue ft14">创建</a>
	        </div>
	    </div>
	 </div>
</form>
<!--添加标签 弹框 end-->

<!-- 修改 -->
<form action="/blog/lable/updateLable" method="post" id="frm" accept-charset="UTF-8">
    <input type="hidden" name="id" id="labelId" value="">
	<div id="updatelabel" class="dn">
	    <div class="zhezhao"></div>
	    <div class="tk_box radius3 bgf" style="margin-top:-135px">
	        <div class="tk_top ft14 colgray02 plr20"><a href="javascript:void(0)" op="headQx" class="icon tk_close fr"></a>创建栏目</div>
	        <div class="screen_inp mt30" style=" padding-left:46px">
	            <span class="fl ft14 colgblock">栏目名称：</span>
	            <input type="text" placeholder="" name="name" id="labelName" value="<%=update&&blogLabelUpdate!=null ? blogLabelUpdate.getName() : ""%>" class="inputbox" style="width:210px">
	        </div>
	
	        <div class="screen_inp mt20" style=" padding-left:46px; height:70px">
	            <span class="fl ft14 colgblock">栏目描述：</span>
	            <textarea  class="inputbox fapf" style="width:210px; height:50px;" name="scc" id="labelDesc" ><%=update&&blogLabelUpdate!=null ? blogLabelUpdate.getDescription() : ""%></textarea>
	        </div>
	        
	        <security:authorize access="hasRole('WZLMTSDFXZ')"> 
	        	<div class="mt20">
	            	<input type="checkbox" class="fl" name="share" style="border:1px solid blue;width:15px;height:15px;-webkit-appearance:checkbox;margin-right:15px;margin-left:100px;"/> 
	            	<span class="ft14 colgblock">推送到分享赚</span>
	        	</div>
			</security:authorize>
	
	        <div class="tk_btn mt20">
	            <a href="javascript:void(0)" op="qx" id="qx" class="button bgf6 colgray04 border_gray transition ft14 colbule_hov">取消</a>
	            <a href="javascript:void(0)" op="xg" id="xg" class="button bgrblue bgrblue_hov colf transition border_blue ft14">修改</a>
	        </div>
	    </div>
	 </div>
</form>

<!--提示弹框-->
<div class="dn">
    <div class="zhezhao"></div>
    <div class="tk_box radius3 bgf">
        <div class="tk_top ft14 colgray02 plr20"><a href="#" class="icon tk_close fr"></a>提示</div>
        <div class="tk_tit ft18 textcent pd30">删除后无法恢复，确认删除?</div>
        <div class="tk_btn"><a href="#" class="button bgf6 colgray04 border_gray transition ft14 colbule_hov">取消</a><a href="#" class="button bgrblue bgrblue_hov colf transition border_blue ft14">确定</a></div>
    </div>
</div>
<!--提示弹框 end-->

</body>
<script type="text/javascript" src="/js/jquery-1.10.1.min.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/js/slither.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/common.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/querytable.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/blogPlatform/common/articleListTemp.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/jquery.pager.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/jquery.tmpl.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/blogPlatform/toast.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/blogPlatform/laydate.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX%>/blogPlatform/lableList.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript">
function editLabel(id){
	$.ajax({
		url:"/blog/lable/labelDetail",
		type:"get",
		data:{"id":id},
		dataType:"json",
		success:function(data){
			if(data.ret == 1){
				$('#updatelabel').removeClass("dn");
				$("#labelId").val(data.data.id);
				$("#labelName").val(data.data.name);
				$("#labelDesc").val(data.data.description);
			}
		},
		error:function(data){
			var data = eval("("+data.response+")");
			errorTips(data.msg);
		}
	});
}

$(".closeTip").click(function(){
	console.log("不推送");
	$("#upTipWindow").addClass("dn");
});

var lmId = null;
$("#cancelShare").click(function(){
	updateStatus("");
});

$("#shareLm").click(function(){
	console.log("推送");
	updateStatus("on");
});

function setStatus(id){
	lmId = id;
	if($("#upTipWindow").length > 0){
		$("#upTipWindow").removeClass("dn");
	}else {
		updateStatus("");
	}
}

function updateStatus(share){
	$.ajax({
		url:"/blog/lable/setBlogLabelStatus",
		type:"post",
		data:{"id":lmId,"share":share},
		dataType:"json",
		success:function(data){
			if(data.ret == 1){
				window.location.reload();
			} else {
				errorTips(data.errmsg);
				setTimeout(function() {
		            location.href = "/blog/lable/lableList";
		        }, 1000);
			}
		},
		error:function(data){
			var data = eval("("+data.response+")");
			errorTips(data.msg);
		}
	});
}
</script>
</html>

