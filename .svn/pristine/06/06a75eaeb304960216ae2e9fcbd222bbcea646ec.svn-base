<%@ page import="com.caishen91.jupiter.config.Config" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>关注</title>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link href="/css/mobile/mui.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
    <link href="/css/mobile/arList.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
    <link href="/css/mobile/common.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
    <link href="/css/mobile/art_list.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
</head>

<body>
		<input type="hidden" id="userId" name="userId" value="3803042451"/>
		<header class="mui-bar mui-bar-nav">
			<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
			<h1 class="mui-title">关注</h1>
		</header>
<!--下拉刷新容器-->
	<div id="pullrefresh" class="mui-content mui-scroll-wrapper">
			<div class="mui-scroll">
				<!--数据列表-->
				<ul id="followUL" class="mui-table-view mui-table-view-chevron"></ul>
			</div>
		</div>
		
<script id="pageListTemplate" type="text/x-jquery-tmpl">
{{each(i,data) content}}
<li class="mui-table-view-cell" opt="{{= data.id}}" style="position: relative;">
	<div class="followlist clearfix pr widbig mui-slider-handle" opt="{{= data.id}}" style="border:0;"><!--默认情况没有screen_left，向左滑动screen_left -->
    	<a href="javascript:void(0);" class="followa">
        	<div class="follow_img"><img src="{{= data.headImg}}"></div>
        	<h3 class="ft16 col4"><b>{{= data.name}}</b></h3>
            <p class="ft12 col9 ellipsis">{{= data.desc}}</p>
        </a>
        <div class="screena bgf dn"><a href="#" class="colf ft16 a_delete" opt="{{= data.id}}">取消关注</a></div>
    </div>
	<div class="mui-slider-right mui-disabled" style="border:1px solid blue;">
		<a uId={{= data.id}} class="mui-btn mui-btn-red unFollow">取消关注</a>
	</div>
</li>
{{/each}}
</script>
<div id="focusNone" class="clearfix widbig nodata dn">
	<img src="http://img.91caishen.com/source/images/contpla/app/qs.png">
    <h6 class="ft16 cola mt15"><b>暂无关注</b></h6>
    <p class="ft14 cola mt5">&nbsp;&nbsp;快来留住你在意的点滴~</p>
</div>
</body>
<script type="text/javascript" src="/js/jquery-1.10.1.min.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/mobile/mui.min.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/mobile/mui.pullToRefresh.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/mobile/mui.pullToRefresh.material.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/mobile/articleListTemp.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/jquery.pager.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/jquery.tmpl.js?<%@include file='/include/.ver'%>"></script>
<script>
mui('body')[0].addEventListener("tap",function(e){
    var target = e.target;
    var classStr = target.className;
    var li = mui(".mui-table-view-cell.mui-selected")[0];
    console.log(li);
    li.className = "mui-table-view-cell mui-transitioning";
    var liOpt = li.getAttribute("opt");
    var firstDiv = $("div[opt='"+liOpt+"']")[0];
    firstDiv.setAttribute("style","border: 0px; transform: translate(0px, 0px);");
    var lastDiv = mui(".mui-slider-right.mui-selected")[0];
    lastDiv.className = "mui-slider-right mui-disabled";
    var aEle = $("a[uid='"+liOpt+"']")[0];
    aEle.setAttribute("style","transform: translate(0px, 0px);");
}); 

mui("#followUL").on('tap','.mui-table-view-cell .followlist',function(){
	var param = mui("#userId")[0].getAttribute("value");
	var self =  mui(this)[0];
	location.href = "/mobile/blog/blogDetail?id=" + self.getAttribute("opt") + "&&userId="+param;
	console.log(self);
});

(function($) {
	//阻尼系数 值越大滚动切换速度就越慢
	var deceleration = mui.os.ios?0.003:0.001;
	$('.mui-scroll-wrapper').scroll({
		bounce: false,
		indicators: true, //是否显示滚动条
		deceleration:deceleration
	});
	
	// 模板查询
	var search = function(){
		var param = mui("#userId")[0].getAttribute("value");
	    var options={
	        queryURL : "/mobile/blog/list",
	        listTitle:[],
	        allSelcet: false,
	        orderBy: "",
	        pageNo: 1,
	        tempId : "pageListTemplate",
	        targetContent: "followUL"
	    };
	    options.queryURL = options.queryURL + "?id=" + param;
	    QNR.TableList.init(options);
	    mui('.mui-scroll-wrapper').scroll({});
	    // 取消关注
	    noFollow();
	};
	search();
	
	function noFollow(){
		mui("#followUL").on('tap','.mui-table-view-cell .unFollow',function(){
			var self =  mui(this)[0];
			var param = mui("#userId")[0].getAttribute("value");
			ajax("/mobile/blog/cancel",{"id":self.getAttribute("uId"),"userId":param},"post",cancelSuccess)
		});
	};
	
	var cancelSuccess = function (data){
		if(data.ret == 1){
			mui.toast("取消成功");
			var table = document.body.querySelector('.mui-table-view');
			var removeLi = mui("li[opt='"+data.data+"']")[0];
			var cells = document.body.querySelectorAll('.mui-table-view-cell');
			table.removeChild(removeLi);
			if(cells.length == 1){
				var node = mui('#focusNone')[0];
                node.className = "clearfix widbig nodata";
			}
		} else {
			mui.toast(data.errmsg);
		}
	}
	
	mui('.mui-bar.mui-bar-nav')[0].addEventListener("tap",function(){
		mui("div.mui-active .mui-scroll-wrapper").scroll({}).scrollTo(0,0,1000);//100毫秒滚动到顶
	});
	
	// 异步统一请求方法
	var ajax = function(url,param,reqType,process) {
		//利用RunJS的Echo Ajax功能测试
		var url = url;
		//请求方式，默认为Get；
		var type = reqType;
		//预期服务器范围的数据类型
		var dataType = "json";
		//发送数据
		var data = param;
		if (type === 'get') {
			if (dataType === 'json') {
				$.getJSON(url, data, process);
			} else {
				$.get(url, data, process, dataType);
			}
		} else if (type === 'post') {
			$.post(url, data, process, dataType);
		}
	};
})(mui);
		</script>
</html>


