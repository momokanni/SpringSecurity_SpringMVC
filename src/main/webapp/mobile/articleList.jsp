<%@ page import="com.caishen91.jupiter.config.Config" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>资讯</title>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link href="/css/mobile/mui.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
    <link href="/css/mobile/arList.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
    <link href="/css/mobile/common.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
    <link href="/css/mobile/art_list.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
</head>

<body>
		<header class="mui-bar mui-bar-nav">
			<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
			<h1 class="mui-title">资讯</h1>
		</header>
		<div class="mui-content">
			<div id="slider" class="mui-slider mui-fullscreen"> 
				<div id="sliderSegmentedControl" class="mui-scroll-wrapper mui-slider-indicator mui-segmented-control mui-segmented-control-inverted">
					<div id="slideTab" class="mui-scroll">
					</div>
				</div>
				<div id="contentTemp" class="mui-slider-group">
					
				</div>
			</div>
		</div>
<script id="pageListTemplate" type="text/x-jquery-tmpl">
						{{each(i,data) content}}
							<li class="mui-table-view-cell" opt="{{= data.arId}}">
								<div class="artli" style="border-bottom: 1px solid #f2f2f2;margin-top:-20px;">
    								<a href="#">
    									<div class="art_top clearfix">
											{{if (data.blogImg == null)}}
												<img style="width:auto;" src="http://img.91caishen.com/source/images/contpla/icon/user_tx.png">
												&nbsp;&nbsp;
												<span>{{= data.blogName}}</span>
											{{else}}
												<img style="width:auto;" src="{{= data.blogImg}}">
											{{/if}}
											<span class="ft12 cola fr">{{= data.timeDesc}}</span>
										</div>
        								<div class="art_con pr">
        									<div class="art_tit col4 pt5 ellipsis2">{{= data.title}}</div>
            								<ul class="art_read clearfix">
            									<li class="art_readli ft12 col8"><img style="width:auto;" src="http://img.91caishen.com/source/images/contpla/app/icon_read.png">{{= data.readVolume}}</li>
               		 							<li class="art_readli ft12 col8"><img style="width:auto;" src="http://img.91caishen.com/source/images/contpla/app/icon_fab.png">{{= data.laudVolume}}</li>
                								<li class="art_readli ft12 col8"><img style="width:auto;" src="http://img.91caishen.com/source/images/contpla/app/icon_share.png">{{= data.forwardVolume}}</li>
            								</ul>
        									<div class="art_img"><img src="{{= data.headImg}}"></div>
        								</div>
    								</a>    
    							</div>
							</li>
						{{/each}}
</script>
</body>
<script type="text/javascript" src="/js/jquery-1.10.1.min.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/common.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/mobile/mui.min.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/mobile/mui.pullToRefresh.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/mobile/mui.pullToRefresh.material.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/mobile/articleListTemp.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/jquery.pager.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/jquery.tmpl.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/mobile/arList.js?<%@include file='/include/.ver'%>"></script>
<script>
mui.init({
	swipeBack: false
});
(function($) {
	
	// 页面函数初始化
	$.ready(function() {
		mui.plusReady();
		// 加载文章类型tab（选项卡）
		ajax("/mobile/article/allType",null,"get",typeSuccess);
		
	});
	
	// 滚动和点击选项卡触发事件
	document.getElementById('slider').addEventListener('slide', function(e) {
		setTimeout(function() {
			search();
		}, 500);
		toDetail();
	});
	
	
	//阻尼系数 值越大滚动切换速度就越慢
	var deceleration = mui.os.ios?0.003:0.001;
	$('.mui-scroll-wrapper').scroll({
		bounce: false,
		indicators: true, //是否显示滚动条
		deceleration:deceleration
	});
	
	//循环初始化所有下拉刷新，上拉加载。
	var slideFun = function(){
		$.each(document.querySelectorAll('.mui-slider-group .mui-scroll'), function(index, pullRefreshEl) {
			$(pullRefreshEl).pullToRefresh({
				down: { // 下拉刷新
					callback: function() {
						var self = this;
						setTimeout(function() {
							var ul = self.element.querySelector('.mui-table-view');
							var node = ul.firstChild;
							// 参数组装
							var param = {"arId": node.getAttribute("opt"),"typeId":mui("a.mui-active")[0].getAttribute("param")};
							ajax("/mobile/article/pullDown",param,"get",pullDownSuccess);
							// 结束下拉刷新
							self.endPullDownToRefresh();
						}, 1000);
					}
				},
				up: { // 上拉刷新
					callback: function() {
						var self = this;
						setTimeout(function() {
							var ul = self.element.querySelector('.mui-table-view');
							var node = ul.lastChild;
							var param = {"arId": node.getAttribute("opt"),"typeId":mui("a.mui-active")[0].getAttribute("param")};

							mui.ajax('/mobile/article/pullUp',{
								data:param,
								dataType:'json',//服务器返回json格式数据
								type:'get',//HTTP请求类型
								timeout:10000,//超时时间设置为10秒
								success:function(data){
									if(data.ret == 0){
										self.endPullUpToRefresh(true);
									} else {
										respProcess(data,"pullUp");
									}
								},
								error:function(xhr,type,errorThrown){
									mui.toast("访问超时");
								}
							});
							
							// 结束上拉刷新
							self.endPullUpToRefresh();
						}, 1000);
					}
				}
			});
		});
	};
	
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
	
	// 【类型查询】成功响应的回调函数
	var typeSuccess = function(response) {
		var tabEle = document.getElementById("slideTab");
		var contentEle = document.getElementById("contentTemp");
		var response = eval(response.data);
		var html = "";
		var contentDiv = "";
		for (var i in response) {
			var aEle = document.createElement("a");
			// 父级
			var divEle = document.createElement("div");
			// 子级
			var child = document.createElement("div");
			// 爷孙级
			var grandchild = document.createElement("div");
			// ul
			var ulChild = document.createElement("ul");
			if(i == 0){
				aEle.className = "mui-control-item mui-active";
				aEle.href = "#item"+response[i].seq+"mobile";
				aEle.innerHTML = response[i].name;
				aEle.setAttribute("param",response[i].arTypeId);
				
				divEle.id = "item"+response[i].seq+"mobile";
				divEle.className = 'mui-slider-item mui-control-content mui-active';
				child.id = "scroll" + response[i].seq;
				child.className = 'mui-scroll-wrapper';
				grandchild.className = 'mui-scroll';
				ulChild.className = 'mui-table-view';
				ulChild.setAttribute("target","#item"+response[i].seq+"mobile");
				grandchild.appendChild(ulChild);
				child.appendChild(grandchild);
				divEle.appendChild(child);
			} else {
				aEle.className = "mui-control-item";
				aEle.href = "#item"+response[i].seq+"mobile";
				aEle.innerHTML = response[i].name;
				aEle.setAttribute("param",response[i].arTypeId);
				
				divEle.id = "item"+response[i].seq+"mobile";
				divEle.className = 'mui-slider-item mui-control-content';
				child.id = "scroll" + response[i].seq;
				child.className = 'mui-scroll-wrapper';
				grandchild.className = 'mui-scroll';
				ulChild.className = 'mui-table-view';
				ulChild.setAttribute("target","#item"+response[i].seq+"mobile");
				grandchild.appendChild(ulChild);
				child.appendChild(grandchild);
				divEle.appendChild(child);
			}
			
			tabEle.appendChild(aEle);
			contentEle.appendChild(divEle);
		}
		mui('#sliderSegmentedControl').scroll().refresh();
		search();
		//循环初始化所有下拉刷新，上拉加载。
		slideFun();
		// 给文章列表绑定点击事件
		toDetail();
	};
	
	// 【文章下拉刷新】成功响应的回调函数
	var pullDownSuccess = function(response) {
		if(response.ret == 0){
			mui.toast(response.errmsg);
		} else {
			respProcess(response,"pullDown");
		}
	}
	
	// 模板查询
	var search = function(){
		var aNode = $(".mui-control-item.mui-active")[0];
	    var param = aNode.getAttribute("param");
	    var target = aNode.getAttribute("href");
	    var options={
	        queryURL : "/mobile/article/list",
	        listTitle:[],
	        allSelcet: false,
	        orderBy: "",
	        pageNo: 1,
	        tempId : "pageListTemplate",
	        targetContent: target
	    };
	    options.queryURL = options.queryURL + "?id=" + param;
	    QNR.TableList.init(options);
	    toDetail();

	};
	
	function toDetail(){
		mui("div.mui-active ul").on('tap','.mui-table-view-cell',function(){
			location.href = '/mobile/article/articleDetail?id='+ this.getAttribute("opt") +'&&userId=3803042451';
		});
	};
	
	mui('.mui-bar.mui-bar-nav')[0].addEventListener("tap",function(){
		mui("div.mui-active .mui-scroll-wrapper").scroll({}).scrollTo(0,0,1000);//100毫秒滚动到顶
	});

})(mui);

//【文章下拉刷新】处理函数
var respProcess = function(data,flag) {
	var data = eval(data);
	var node = mui("div.mui-active ul");
	var ulNode =  node[0];
	var tmpl = $("#pageListTemplate").tmpl(data.data);
	if(flag == "pullDown"){
		for(var i = 0; i < tmpl.length; i++){
			ulNode.insertBefore(tmpl[i], ulNode.firstChild);
		}
	} else {
		for(var i = 0; i < tmpl.length; i++){
			ulNode.appendChild(tmpl[i]);
		}
	}
};
		</script>
</html>


