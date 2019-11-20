<%@ page import="com.caishen91.jupiter.model.Article" %>
<%@ page import="java.util.List" %>
<%@ page import="com.caishen91.jupiter.model.Blog" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.caishen91.jupiter.util.*" %>
<%@ page import="com.caishen91.jupiter.config.Config" %>
<%@ page import="com.caishen91.jupiter.model.BlogLabel" %>
<%@ page import="com.caishen91.jupiter.model.BlogFocus" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%
    List<Article> articles=(List<Article>)request.getAttribute("articles");
    Blog blog=(Blog)request.getAttribute("blog");
    String id = IDEncryptor.getInstance().encryptWithoutException(blog.getId());
    double num = (double)blog.getFansCount()/10000;
    BigDecimal decimal = new BigDecimal(num);

    List<BlogLabel> blogLabels=(List<BlogLabel>)request.getAttribute("blogLabels");

    BlogFocus blogFocus=(BlogFocus)request.getAttribute("blogFocus");
    //获取到移动端用户Id
    String userId=(String)request.getAttribute("userId");
%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
    <title>公众号</title>
    <link href="/css/mobile/mui.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
    <link href="/css/mobile/common.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
    <link href="/css/mobile/art_list.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
	<style type="text/css">
		.mui-content>.mui-table-view:first-child {
			margin-top: -1px;
		}
	</style>
    <script>
        var userId='<%=userId%>';
        var id='<%=id%>';
    </script>
</head>

<body class="bgf7" id="drag">
<!--头部-->
<div class="header widbig" style="background:#419eff; border-bottom:1px solid #419eff;width: 100%;" ><!--需判断topnav_ios-->
    <h3 class="colf ft18"><%=blog.getName()!=null ? blog.getName() : "未设置"%></h3>
    <div class="navback">
        <a href="javascript:void(0)" op="back" id="back" ><img src="http://img.91caishen.com/source/images/contpla/app/nav_back_w.png"></a>
    </div>  
</div>
<div style="width:100%; height:45px;"></div>
<!--头部 end-->

<div class="widbig clearfix pub_top pt10 pb20" style="width:100%;">
    <dl class="pr public_cont">
        <a href="javascript:void(0)"  op="gz" id="gz"     class="a_follow <%=blogFocus!=null ? "a_follow_ok" : ""%>"><%=blogFocus!=null ? "已关注" : "关注"%></a><!--已关注 a_follow_ok -->
        <%if(blog.getHeadImgMb()!=null){%>
        <dt class="fl"><img src="<%=blog.getHeadImg()%>"></dt>
        <%}%>
        <dd class="fl colf">
            <h3 class="ft18"><%=blog.getName()!=null ? blog.getName() : "未设置"%></h3>
            <p class="ft12" style="color:white;"><span class="ft14"><%=blog.getFansCount()<10000 ? blog.getFansCount() : decimal.setScale(1, BigDecimal.ROUND_HALF_UP)+"万"%></span> 粉丝</p>
        </dd>
    </dl>

    <p class="ft14 colf ellipsis2 public_p mt10" style="width:100%;"><%=blog!=null&&blog.getDescription()!=null ? StringUtil.shortStr(StringUtil.getDescsStr(blog.getDescription()),90) : "暂无简述"%></p>
</div>

<div class="pub_tab pr bgff">
    <a href="javascript:void(0)"   op="qb" id="qb" class="pub_more ft14 col8">全部</a>
    <a href="#" class="pub_tab_a pr pub_tab_in"><em class="bggre"></em>文章</a><!--选中 pub_tab_in -->
    <a href="#" class="pub_tab_a pr"><em class="bggre"></em>视频</a><!--选中 pub_tab_in -->
</div>
<div class="clearfix  bgff" style="padding-top:5px; margin-bottom:10px">
<div class="mui-content" style="top:33%;">
    <input type="hidden" id="userId" name="userId" value="<%=userId%>"/>
    <!--下拉刷新容器-->
	<div id="pullrefresh" class="mui-content mui-scroll-wrapper" style="top:235px;">
		<div class="mui-scroll">
			<!--数据列表-->
			<ul id="ulview" class="mui-table-view mui-table-view-chevron" style="margin-top: 0px; background:none"></ul>
		</div>
	</div>
</div>
</div>

<script id="pageListTemplate" type="text/x-jquery-tmpl">
						{{each(i,data) content}}
							<li class="mui-table-view-cell" opt="{{= data.arId}}" style="padding-right:20px; padding: 5px 15px;">
								<div class="artli" style="border-bottom: 1px solid #f2f2f2;padding-top: 10px;">
                                  <a href="#">
                                   <div class="art_con pr">
                                     <div class="art_tit col4 pt5 ellipsis2">{{= data.title}}</div>
                                     <ul class="art_read clearfix">
                                      <li class="art_readli ft12 col8" ><img style="width:auto;" src="http://img.91caishen.com/source/images/contpla/app/icon_read.png">{{= data.readVolume}}</li>
                                      <li class="art_readli ft12 col8">{{= data.timeDesc}}</li>
                                     </ul>
                                     <div class="art_img"><img src="{{= data.headImg}}"></div>
                                   </div>
                                  </a>
                                </div>
							</li>
						{{/each}}
</script>
<!--无数据-->

<div class="clearfix widbig nodata dn">
    <img src="http://img.91caishen.com/source/images/contpla/app/qs.png">
    <p class="ft14 cola mt15">&nbsp;&nbsp;还未发布任何资讯哦~</p>
</div>

<!--无数据 end-->
<!--筛选-->

<div id="lable" class="dn" style="width:100%;">
    <div class="shade shade02"></div>
    <div class="tk_screen bgff" id="menu" style="width:100%;padding: 20px 4%;">
        <a href="javascript:void(0)" id="qbzx" class="mui_lable screen_in" v="">全部</a><!--选中 screen_in -->
        <%for(BlogLabel blogLabel : blogLabels){
        %>
        <a href="javascript:void(0)" class="mui_lable" v="<%=IDEncryptor.getInstance().encryptWithoutException(blogLabel.getId())%>"> <%=blogLabel!=null ? blogLabel.getName() : ""%></a>
        <%}%>
    </div>
</div>

<!--筛选 end-->

</body>
<script type="text/javascript" src="/js/jquery-1.10.1.min.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX%>/mobile/blogDetail.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/mobile/mui.min.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/mobile/articleListTemp.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/jquery.pager.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/jquery.tmpl.js?<%@include file='/include/.ver'%>"></script>

<script>
	mui.init({
		pullRefresh: {
			container: '#pullrefresh',
			up: {
				auto:true,
				contentrefresh: '正在加载...',
				contentnomore: "没有更多数据了",
				callback: pullupRefresh
			}
		}
	});
	// 右滑
	window.addEventListener('swiperight',function(){
		window.history.go(-1);
	});
	
	// 上拉刷新
	function pullupRefresh() {
		setTimeout(function() {
			mui('#pullrefresh').pullRefresh().endPullupToRefresh(); //参数为true代表没有更多数据了。
			var ul = mui('.mui-table-view')[0];
            var node = ul.lastChild;
            var labelId = mui(".screen_in")[0].getAttribute("v");
            var userId = mui("#userId")[0].getAttribute("value");
            var param = {"arId": node.getAttribute("opt"),"blogId":id,"labelId":labelId};
            mui.ajax('/mobile/blog/pullUp',{
                data:param,
                dataType:'json',//服务器返回json格式数据
                type:'get',//HTTP请求类型
                timeout:10000,//超时时间设置为10秒；
                success:function(data){
                    if(data.ret == 0){
                    	mui.toast("没有更多数据了");
                    	mui('#pullrefresh').pullRefresh().disablePullupToRefresh();
                    } else {
                        respProcess(data,"pullUp");
                    }
                },
                error:function(xhr,type,errorThrown){
                    mui.toast("访问超时");
                }
            });

		}, 500);
	};
	

    (function($) {
    	// 点击空白区域隐藏弹出层
    	mui('body')[0].addEventListener("tap",function(e){
    	    var target = e.target;
    	    var classStr = target.className;
    	    if (classStr == "shade shade02"){
    	    	mui("#lable")[0].className = "dn";
    	    }
    	});
    	
        mui("#menu").on("click",".mui_lable",function(){
        	// 滑倒顶部
        	mui(".mui-scroll-wrapper").scroll({}).scrollTo(0,0,0);
        	// 清空UL
        	mui('#ulview')[0].innerHTML = "";
        	// 刷新滚动区域
        	mui('.mui-scroll-wrapper').scroll().refresh();
        	// 取消之前选中标签的默认样式
        	mui(".mui_lable.screen_in")[0].className = "mui_lable";
        	var labelId = mui(this)[0].getAttribute("v");
        	// 给定当前选中标签添加选中样式
        	mui(this)[0].className = "mui_lable screen_in";
        	mui("#qb")[0].innerHTML = mui(this)[0].text; 
            search(labelId);
        });
        //阻尼系数 值越大滚动切换速度就越慢
        var deceleration = mui.os.ios?0.003:0.001;
        $('.mui-scroll-wrapper').scroll({
            bounce: false,
            deceleration:deceleration
        });





        //循环初始化所有下拉刷新，上拉加载。
        var slideFun = function(){
            $.each(document.querySelectorAll('.mui-slider-group .mui-scroll'), function(index, pullRefreshEl) {
                $(pullRefreshEl).pullToRefresh({
                    up: { // 上拉刷新
                        callback: function() {
                            var self = this;
                            setTimeout(function() {
                                var ul = self.element.querySelector('.mui-table-view');
                                var node = ul.lastChild;
                                var userId = mui("#userId")[0].getAttribute("value");
                                var param = {"arId": node.getAttribute("opt"),"blogId":id};
                                mui.ajax('/mobile/blog/pullUp',{
                                    data:param,
                                    dataType:'json',//服务器返回json格式数据
                                    type:'get',//HTTP请求类型
                                    timeout:10000,//超时时间设置为10秒；
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





        //循环初始化所有下拉刷新，上拉加载。
        var slideFun = function(){
            $.each(document.querySelectorAll('.mui-slider-group .mui-scroll'), function(index, pullRefreshEl) {
                $(pullRefreshEl).pullToRefresh({
                    up: { // 上拉刷新
                        callback: function() {
                            var self = this;
                            setTimeout(function() {
                                var ul = self.element.querySelector('.mui-table-view');
                                var node = ul.lastChild;
                                var userId = mui("#userId")[0].getAttribute("value");
                                var param = {"arId": node.getAttribute("opt"),"blogId":id};
                                mui.ajax('/mobile/blog/pullUp',{
                                    data:param,
                                    dataType:'json',//服务器返回json格式数据
                                    type:'get',//HTTP请求类型
                                    timeout:10000,//超时时间设置为10秒；
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


        // 模板查询
        var search = function(labelId){
        	var labelId = mui(".screen_in")[0].getAttribute("v");
            var options={
                queryURL : "/mobile/blog/articleList",
                listTitle:[],
                allSelcet: false,
                orderBy: "",
                pageNo: 1,
                tempId : "pageListTemplate",
                targetContent: "ulview"
            };

            options.queryURL = options.queryURL + "?id=" + id+"&labelId="+labelId;
            QNR.TableList.init(options);
            // 刷新滚动区域
            mui('.mui-scroll-wrapper').scroll().refresh();
            toDetail();
        }
        search();


        function toDetail(){
            mui("#ulview").on('tap','.mui-table-view-cell',function(){
                location.href = '/mobile/article/articleDetail?id='+ this.getAttribute("opt") +'&&userId='+userId;
            });
        };


    })(mui);


    //【文章下拉刷新】处理函数
    var respProcess = function(data,flag) {
        var data = eval(data);
        var node = mui("#ulview");
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


