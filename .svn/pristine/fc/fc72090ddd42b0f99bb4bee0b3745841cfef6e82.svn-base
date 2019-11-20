<%@page import="java.util.List"%>
<%@ page import="com.caishen91.jupiter.config.Config,
				 com.caishen91.jupiter.model.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE HTML>
<html>
<head>
<title>文章管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1" name="viewport">
<jsp:include page="/blogPlatform/common/baseCss.jsp"></jsp:include>
<link href="/css/blog/article.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
</head>
	
<body>
<jsp:include page="/blogPlatform/common/top.jsp"/>
<jsp:include page="/blogPlatform/common/leftMenu.jsp"/>
	<!--右侧内容 文章管理-->
	<div id="mainbody" class="portlet-body mainbody">
	
		<!--筛选-->
		<form id="query_form" action="">
		    <div class="clearfix mt30 bgf radius3 shadow pd30 plr35">
		    	<div class="screen_tab pr">
		        	<span class="fl ft14 colgblock">文章状态：</span>
		        	<input type="hidden" id="headerSt" name="status" value=""/>
		        	<a href="#" class="colgray04 radius2 scrtab_in a_status" ast=""><span class="colgblock">全部</span></a>
		        	<a href="#" class="colgray04 radius2 a_status" ast="2"><span class="colgblock">已发布</span>&nbsp;(<span class="colgray02 countspan" id="releaseSpan">0</span>)</a>
		            <a href="#" class="colgray04 radius2 a_status" ast="1"><span class="colgblock">待发布</span>&nbsp;(<span class="colred countspan" id="toBeReleasedSpan">0</span>)</a>
		            <a href="#" class="colgray04 radius2 a_status" ast="0"><span class="colgblock">未通过</span>&nbsp;(<span class="colred countspan">0</span>)</a>
		            <a href="#" class="colgray04 radius2 a_status" ast="3"><span class="colgblock">草稿 </span>&nbsp;(<span class="colred countspan" id="draftSpan">0</span>)</a>
		            <a href="#" class="colgray04 radius2 a_status" ast="4"><span class="colgblock">已下线</span>&nbsp;(<span class="colgray02 countspan" id="OfflineSpan">0</span>)</a>
		        </div>
		        
		        <div class="screen_inp pr mt30">
		        	<div class="search fl">
		            	<input type="text" name="title" placeholder="文章标题" class="fl inp_search">
		            	<!-- <a id="searchA" href="#" class="icon a_search fr"></a> -->
		            </div>
		        	<span class="fl ft14 colgblock" style="margin-left:20px;">发布时间：</span>
		            <input id="startTime" name="startTime" type="text" placeholder="" class="fl inputbox inp_date">
		            <span class="fl colgray04">&nbsp;&nbsp;-&nbsp;&nbsp;</span>
		            <input id="endTime" name="endTime" type="text" placeholder="" class="fl inputbox inp_date">
		            
		            <a href="javascript:void(0)"  id="chaxun" class="colf border_blue bgrblue bgrblue_hov transition ft14 button fl searchA" style="margin-left:80px;">查询</a>
		        </div>
		    </div>
		</form>    
	    <!--筛选 end-->
	    
	  <div id="statistics_header" class="ft14 colgray02 mt30">
	    	
	  </div>  
	  <script id="statisticsTemplate" type="text/x-jquery-tmpl">
			<p class="">当页共找到<span class="colblue">{{= actualCount}}</span>条符合条件的内容</p>
	  </script>
	  
	  <div id="nc" class="nothingContent"></div>

<script id="pageListTemplate" type="text/x-jquery-tmpl">
	
		<!--文章列表-->   
	    <div class="bgf radius3 pd10 clearfix shadow mt10 pr">
			
			{{each(i,data) content}}
			<div class="content content_li pr clearfix" style="padding-left:20px;">
	        	<div class="cont_operation" operationId="{{= data.arId}}">
					{{if (data.statusDesc == "已发布")}}
						{{if (data.isTopDesc == "置顶")}}
							<security:authorize access="hasRole('WZGLQXZD')"> 
								<a href="javascript:void(0);" class="colgray04 colbule_hov a_cancel operation" onclick="operations({{= data.arId}},'offTop');">取消置顶</a>
							</security:authorize>
							<security:authorize access="hasRole('WZGLXX')"> 
								<a href="javascript:void(0);" class="icon a_offline operation" title="下线" onclick="operations({{= data.arId}},'offline');"></a><!--下线 a_offline -->
							</security:authorize>
						{{else}}
							<security:authorize access="hasRole('WZGLZD')"> 
								<a href="javascript:void(0);" class="icon a_top operation" title="置顶" onclick="operations({{= data.arId}},'top');"></a><!--置顶 a_top -->
							</security:authorize>
							<security:authorize access="hasRole('WZGLXX')"> 
								<a href="javascript:void(0);" class="icon a_offline operation" title="下线" onclick="operations({{= data.arId}},'offline');"></a><!--下线 a_offline -->
							</security:authorize>
						{{/if}}
					{{else (data.statusDesc == "待发布")}}
						<security:authorize access="hasRole('WZGLFB')"> 
	            			<a href="javascript:void(0);" class="colblue transition a_release operation" onclick="operations({{= data.arId}},'send');">发布</a>
						</security:authorize>
						<security:authorize access="hasRole('WZGLXX')"> 
							<a href="javascript:void(0);" class="icon a_offline operation" title="下线" onclick="operations({{= data.arId}},'offline');"></a><!--下线 a_offline -->
						</security:authorize>
					{{else (data.statusDesc == "草稿")}}
						<security:authorize access="hasRole('WZGLBJ')"> 
	                		<a href="/blog/article/toEdit?id={{= data.arId}}" title="编辑" class="icon a_edit"></a><!--编辑 a_edit -->
						</security:authorize>
						<security:authorize access="hasRole('WZGLSC')"> 
	                		<a href="javascript:void(0);" class="icon a_delete operation" title="删除" onclick="operations({{= data.arId}},'del');"></a><!--删除 a_delete -->
						</security:authorize>
					{{else (data.statusDesc == "已下线")}}
						<security:authorize access="hasRole('WZGLFB')"> 
							<a href="javascript:void(0);" class="colblue transition a_release operation" onclick="operations({{= data.arId}},'send');">发布</a>
						</security:authorize>
						<security:authorize access="hasRole('WZGLBJ')"> 
	                		<a href="/blog/article/toEdit?id={{= data.arId}}" title="编辑" class="icon a_edit"></a><!--编辑 a_edit -->
						</security:authorize>
						<security:authorize access="hasRole('WZGLSC')"> 
	                		<a href="javascript:void(0);" class="icon a_delete operation" title="删除" onclick="operations({{= data.arId}},'del');"></a><!--删除 a_delete -->
						</security:authorize>
					{{/if}}
	            </div>
				<dl class="contbox pd20 plr35" style="margin-left:0px;">
					<security:authorize access="hasRole('WZGLCKWZXQ')">
					<a href="/blog/articleDetail?id={{= data.arId}}" class="a_box">
					</security:authorize>
						<dt class="fl radius5">
							{{if (data.headImg == "" || data.headImg == null)}}
								<img src="/images/manager/article_default.jpg" class="imgaut"></dt>
							{{else}}
								<img src="{{= data.headImg}}" class="imgaut"></dt>
							{{/if}}
						<dd class="fl">
							<h3 class="ft16 fapf colgblock pd5 transition">
								{{if (data.statusDesc == "待发布")}}
									<span class="state state_dfb">待发布</span>
								{{else (data.statusDesc == "草稿")}}
									<span class="state state_cg">草稿</span>
								{{else (data.statusDesc == "已下线")}}
									<span class="state state_yxx">已下线</span>
								{{/if}}
	                        	<b style="font-weight: bold;">{{= data.title}}</b>
								{{if (data.isTopDesc == "置顶")}}
	                        		<span class="icontop colred border_red radius2 ft14">置顶</span><!--置顶-->
								{{/if}}
	                    	</h3>
							<ul class="clearfix contli pd5">
								<li class="fadin colgray04"><em class="icon icon_date"></em>{{= data.time}}</li>
								<li class="fadin colgray04"><em class="icon icon_read"></em>{{= data.readVolume}}</li>
								<li class="fadin colgray04"><em class="icon icon_coll"></em>{{= data.collectVolume}}</li>
								<li class="fadin colgray04"><em class="icon icon_forw"></em>{{= data.forwardVolume}}</li>
							</ul>
						</dd>
					<security:authorize access="hasRole('WZGLCKWZXQ')">
					</a>
					</security:authorize>
				</dl>
			</div>
		{{/each}}
		
		</div>
	
</script>		
 
<style>
.contbox { border-bottom:none; padding-left:0}
</style>
		
 		<div class="maninput nobd">
                <div class="tab colltab">
                    <div class="tab_content pselltdiv"></div>
                    <div id="page"  class="page mt20" style="text-align:center">
                    </div>
                </div>
        </div>

	    <!--公用底部-->
	    <div id="footer" class="footer textcent ft12 clearfix">
	        <a href="#" class="ft14 colbule_hov transition">关于91财经</a>|<a href="#" class="ft14 colbule_hov transition">服务协议</a>|<a href="#" class="ft14 colbule_hov transition">联系邮箱</a>|<a href="#" class="ft14 colbule_hov transition">联系电话</a>
	        <span class="ft14">Copyright © 2018-2019 91Caijing  All Rights Reserved</span>
	    </div>
	    <!--公用底部 end-->
	    
	</div>
	<!--右侧内容 文章管理 end-->
	
	<!--弹框-->
	<div id="tipWindow" class="dn">
		<div class="zhezhao"></div>
	    <div class="tk_box radius3 bgf">
	    	<div class="tk_top ft14 colgray02 plr20">
	    		<a href="#" class="icon tk_close fr closeTip"></a>提示
	    	</div>
	        <div id="tipMsg" class="tk_tit ft18 textcent pd30"></div>
	        <div class="tk_btn">
	        	<a href="javascript:void(0);" class="button bgf6 colgray04 border_gray transition ft14 colbule_hov closeTip closeTip">取消</a>
	        	<a id="submitTip" href="javascript:void(0);" class="button bgrblue bgrblue_hov colf transition border_blue ft14">确定</a>
	        </div>
	    </div>
	</div>
	<!--弹框 end-->

</body>
<!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
<script type="text/javascript" src="/js/jquery-1.10.1.min.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/common.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/querytable.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/blogPlatform/common/articleListTemp.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/jquery.pager.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/blogPlatform/layer.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/jquery.tmpl.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/blogPlatform/toast.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/blogPlatform/laydate.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/blogPlatform/articleList.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript">
	$(function(){
		$("#armanage").addClass("menuli_in");
		$(".menu_home").removeClass("menu_home_in");
		
		$(".searchA").click(function(){
			search();
		});
	});
	
	document.onkeydown = function (e) { // 回车提交表单
		// 兼容FF和IE和Opera
		var theEvent = window.event || e;
		var code = theEvent.keyCode || theEvent.which || theEvent.charCode;
		if (code == 13) {
			search();
		}
	}
	
	var search = function(){
	    var options={
	        queryURL : "/blog/article/manage/getARList",
	        listTitle:[],
	        allSelcet: false,
	        orderBy: "",
	        pageNo: 1,
	        tempId : "pageListTemplate",
	        totalHeaderId : "statisticsTemplate",
	        statistics : true
	    };
	    var param = $("#query_form").serialize();
	    options.queryURL = options.queryURL + "?" + param;
	    QNR.TableList.init(options);
	}
	
	function operations (arId,arOper){
		if(typeof arOper === 'undefined'){
			return false;
		}
		var msg = "";
		if(arOper == "offTop"){
			msg = "确定取消置顶当前文章吗";
		} else if(arOper == "top"){
			msg = "确定置顶当前文章吗";
		} else if(arOper == "offline"){
			msg = "确定下线当前文章吗";
		} else if(arOper == "send"){
			msg = "确定发布当前文章吗";
		} else if(arOper == "del"){
			msg = "确定删除当前文章吗";
		} else if(arOper == "share"){
			msg = "确定加入分享赚吗";
		}
		$("#tipWindow").attr("class","");
		$("#tipMsg").text(msg);
		$("#submitTip").attr("arId",arId);
		$("#submitTip").attr("arOper",arOper);
	}
	operations();
	
	//执行一个laydate实例
	//日期时间选择器
	laydate.render({ 
			  elem: '#startTime',
			  type: 'date',
			  theme: '#418aec',
			  trigger: 'click',
			  done: function(value){
				    // 得到日期生成的值，如：2017-08-18
			  }
	});
	
	//执行一个laydate实例
	//日期时间选择器
	laydate.render({ 
			  elem: '#endTime',
			  type: 'date',
			  theme: '#418aec',
			  trigger: 'click',
			  done: function(value){
				    // 得到日期生成的值，如：2017-08-18
			  }
	});
	
</script>
</html>

