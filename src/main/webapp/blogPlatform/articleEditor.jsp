<%@page import="java.util.List"%>
<%@ page import="com.caishen91.jupiter.config.Config,
				 com.caishen91.jupiter.model.*,
				 com.caishen91.jupiter.vo.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE HTML>
<%
	List<ArticleType> typeList = (List<ArticleType>)request.getAttribute("typeList");
	List<BlogLabel> labels = (List<BlogLabel>)request.getAttribute("labels");
	List<BlogDetailVO> blogs = (List<BlogDetailVO>)request.getAttribute("blogs");
	List<ArticleKeyWords> keyWords = (List<ArticleKeyWords>)request.getAttribute("keyWords");
%>
<html>
<head>
<title>发布文章</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1" name="viewport">
<jsp:include page="/blogPlatform/common/baseCss.jsp"></jsp:include>
<link href="/css/blog/article.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
<link href="/css/blog/wangEditor-fullscreen-plugin.css?<%@include file='/include/.ver'%>" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="/blogPlatform/common/top.jsp"/>
<jsp:include page="/blogPlatform/common/leftMenu.jsp"/>

	<!--右侧内容 发布文章-->
	<form id="arForm" action="#" method="post">
		<div id="mainbody" class="mainbody" style="padding-bottom:110px">
			<div class="clearfix mt30 bgf radius3 shadow pd30 plr35">
		    	<div class="rel_tit pr">
		        	<input id="titleInp" name="title" maxlength="50" type="text" placeholder="请输入文章标题" class="rel_input colgblock ft24" />
		            <p class="colgray04 ft16"><span id="characterCount" class="colgray02">0</span>/50</p>
		        </div>
		        
		        <input type="hidden" id="videoThumbPath" value=""/>
		        <input type="hidden" id="editorInp" name="content" value=""/>
		        <div id="editor" class="clearfix pd30">
		        	<!-- 此处放编辑器 -->
		        </div>
		        
		        <div class="pd30 rel_srk">
		            <div class="screen_inp">
		                <span class="fl ft14 colgblock">文章类型：</span>
		                <select id="typeSel" name="type" class="screen_sel">
		                	<option value="0">请选择</option>
		                	<%
		                       for (int i = 0; i < typeList.size(); i++) {	
		                    	   ArticleType type = typeList.get(i);
		                    %>
		                    	<option value="<%= type.getId() %>"><%=type.getName() %></option>
		                    <% } %>
		                </select>
		            </div>
		            <security:authorize access="hasRole('FXZWZBJMK')">
			            <div class="screen_inp mt15">
			                <span class="fl ft14 colgblock">文章来源：</span>
			                <select id="arSourceSel" name="articleSourceId" class="screen_sel">
			                	<option value="0">请选择</option>
			                	<%
			                       for (int i = 0; i < blogs.size(); i++) {	
			                    	   BlogDetailVO blog = blogs.get(i);
			                    %>
			                    	<option value="<%= blog.getId() %>"><%=blog.getBlogName() %></option>
			                    <% } %>
			                </select>
			            </div>
		            </security:authorize>
		            
		            <div class="screen_inp mt15">
		                <span class="fl ft14 colgblock">文章栏目：</span>
		                <select id="labelSel" name="label" class="screen_sel">
		                	<option value="0">请选择</option>
		                	<%
		                       for (int i = 0; i < labels.size(); i++) {	
		                    	   BlogLabel label = labels.get(i);
		                    %>
		                    	<option value="<%= label.getId() %>"><%=label.getName() %></option>
		                     <% } %>
		                </select>
		            </div>
					<security:authorize access="hasRole('SCST')">
			            <div class="screen_inp mt15" style="height:200px">
			                <span class="fl ft14 colgblock">设置封面：</span>
			               	
			               	<!-- 首图上传 -->
			               	<div id="drop_area" class="fl rel_cover pr "></div>
			               	<input id="thumbPath" type="hidden" value="" name="thumb"/>
			                
			                <div class="fl rel_cover pr dn"><!--上传完成-->
			                    <img src="http://img.91caishen.com/source/images/contpla/img/img03.jpg">
			                    <a href="#" class="rel_a colf ft14 shadingblue shadow">重新上传</a>
			                </div>
			             </div>
		            </security:authorize>
		            <security:authorize access="hasRole('FXZWZBJMK')">
		            	<security:authorize access="hasRole('SCYP')">
				             <div class="screen_inp mt15" style="height:90px">
				                <span class="fl ft14 colgblock">上传音频：</span>
				               	
				               	<!-- 音频上传 -->
				               	<div id="drop_audio_area" class="fl rel_cover pr"></div>
				               	<input id="audioPath" type="hidden" value="" name="audioPath"/>
				                <input id="audioName" type="hidden" value="" name="audioName"/>
				                <div class="fl rel_cover pr dn"><!--上传完成-->
				                    <img src="http://img.91caishen.com/source/images/contpla/img/img03.jpg">
				                    <a href="#" class="rel_a colf ft14 shadingblue shadow">重新上传</a>
				                </div>
				             </div>
			             </security:authorize>
			             
			             <div class="screen_inp">
			                <span class="fl ft14 colgblock">分享内容：</span>
			                <input type="text" name="shareContent" value="" class="inputbox" style="width:70%" />
			             </div>
			             
			              <input type="hidden" name="imgCount" value="0" class="inputbox" />
			              <input type="hidden" name="wordCount" value="0" class="inputbox" />
			             
			             <div class="screen_inp mt10">
			                <span class="fl ft14 colgblock">文章标签：</span>
			                <%
		                       for (int i = 0; i < keyWords.size(); i++) {	
		                    	   ArticleKeyWords keyWord = keyWords.get(i);
		                    %>
			                	<input type="checkbox" class="" name="otherStatus" value="<%=keyWord.getId() %>" style="border:1px solid blue;width:15px;height:15px;-webkit-appearance:checkbox;"/>
			                	<span><%=keyWord.getName() %></span> &nbsp;&nbsp;&nbsp;
			                <% } %>
			             </div>
		             </security:authorize>
		            
		            <div class="screen_inp mt15">
		                <span class="fl ft14 colgblock">其它设置：</span>

		                <input type="radio" id="rightNow" name="releaseType" value="1" style="display:none" />
	                    <label name="radioLabel" id="rl1" for="rightNow" class="label label_check "><!--选中c_in-->
	                   		<span>立即发布</span>
	                  	</label>
	                  	<input type="radio" id="timing" name="releaseType" value="0" checked style="display:none"/>
	                  	<label name="radioLabel" id="rl0" for="timing" class="label label_check c_in"><!--选中c_in-->
	                   		<span>定时发布</span>
	                  	</label>
		                 
		                <div class="rel_date layui-input-inline" style="display:inline-block"><!--定时发布 设定时间,隐藏为 display:none ,显示 display:inline-block -->
		                    <input  id="releaseTime" type="text" name="time" class="demo-input inputbox inp_date" placeholder="选择发布时间"  value=""/>
		                </div>
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
	
	<!--右侧内容  发布文章 end-->
	
	<!--底部悬浮 发布文章-->
	<div class="rel_bottom shadow bgf">
		<div class="widcont_bot">
			<security:authorize access="hasRole('BCZCG')">
	    		<a id="subDraft" href="javascript:void(0);" class="button bgf border_blue ft16 colblue02 bot_a1 transition">保存至草稿</a>
	    	</security:authorize>
	    	<security:authorize access="hasRole('BCBFB')">
	        	<a id="subAR" href="javascript:void(0);" class="button shadingblue shadow_blue colf ft16 bot_a2">保存并发布</a>
	        </security:authorize>
	        <a href="javascript:scrollTo(0,0);" class="top ft16 colgray02 colbule_hov transition"><em class="icon"></em>返回顶层</a>
	    </div>
	</div>
	<!--底部悬浮 发布文章 end-->
	</form>
	
	<!--弹框 提示-->
	<div class="dn">
		<div class="zhezhao zhezhao_w"></div>
	    <div class="tk_ts colf ft18 textcent bggreen shadow_green dn">发布成功</div>
	    <div class="tk_ts colf ft18 textcent bgred shadow_red">请输入文章标题</div>
	</div>
	<!--弹框 提示 end-->
</body>
<!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/common/common.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/blogPlatform/xss.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/blogPlatform/wangEditor.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/blogPlatform/wangEditor-fullscreen-plugin.js?<%@include file='/include/.ver'%>"></script>
<security:authorize access="hasRole('SCST')">
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/blogPlatform/uploadThumb.js?<%@include file='/include/.ver'%>"></script>
</security:authorize>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/blogPlatform/uploadAudio.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/blogPlatform/toast.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/blogPlatform/editor.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/blogPlatform/layer.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/blogPlatform/laydate.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript" src="/front/scripts/<%=Config.FRONT_PREFIX %>/blogPlatform/articleEditor.js?<%@include file='/include/.ver'%>"></script>
<script type="text/javascript">
$(function(){
	$("#arLi").addClass("menuli_in");
	$(".menu_home").removeClass("menu_home_in");
});
// 编辑器
var E = window.wangEditor
var editor = new E('#editor')

//执行一个laydate实例
//日期时间选择器
laydate.render({ 
		  elem: '#releaseTime',
		  type: 'datetime',
		  theme: '#418aec',
		  trigger: 'click',
		  min:minDate(),
		  done: function(value){
			    // 得到日期生成的值，如：2017-08-18
		  }
});

function minDate(){
    var now = new Date();
    return now.getFullYear() + "-" + (now.getMonth()+1) + "-" + now.getDate() + " " + now.getHours() + ":" + now.getMinutes() + ":" + now.getSeconds();
}
	
	$("#titleInp").bind("input propertychange",function(){
		var title = $("#titleInp").val().trim();
		var actualLen = parseInt(title.length);
		if(actualLen >= 50){
			$("#characterCount").attr("style","font-weight:blod;color:red;");
		} else {
			$("#characterCount").removeAttr("style");
		}
		$("#characterCount").text(actualLen)
	});
	
	<security:authorize access="hasRole('SCST')">
	// -------------- uploadThumb -------------------
	var dragImgUpload = new DragImgUpload("#drop_area",{
       callback:function (files) {
          //回调函数，可以传递给后台等等
          var file = files[0];
          var form = new FormData();
          form.append("thumb",file);
          $.ajax({
        	 url:"/blog/upload/thumb", 
        	 data:form,
        	 type:"post",
        	 processData:false,
             contentType:false,
             success:function(data){
            	 if (1 == data.ret) {
            		 successTips("上传成功");
                    $("#thumbPath").attr("value",data.data);
                    $(".img-responsive").attr("src",data.data);
                 } else {
                	 errorTips(data.errmsg);
                	 $(".img-responsive").attr("src","//img.91caishen.com/source/images/contpla/img/add_bg01.png");
                 }
             },
             error:function(data){
             }
          });
      }
    });
	</security:authorize>
	
	var dragAudioUpload = new DragAudioUpload("#drop_audio_area",{
	       callback:function (files) {
	    	  var index = layer.load();
	          //回调函数，可以传递给后台等等
	          var file = files[0];
	          var form = new FormData();
	          form.append("audio",file);
	          $.ajax({
	        	 url:"/blog/upload/audio", 
	        	 data:form,
	        	 type:"post",
	        	 processData:false,
	             contentType:false,
	             success:function(data){
	            	 layer.close(index);
	            	 if (1 == data.ret) {
	            		 dragAudioUpload.init();
	            		 successTips("上传成功");
	                    $("#audioPath").attr("value",data.data.audioPath);
	                    $("#audioFileName").attr("style","display:block");
	                    $("#audioName").attr("value",data.data.audioName);
	                 } else {
	                	 errorTips(data.errmsg);
	                	 init();
	                	 $(".audio-responsive").attr("src","/images/manager/audio.png");
	                 }
	             },
	             error:function(data){
	            	 layer.close(index);
	             }
	          });
	      }
	    });
	
</script>
</html>

