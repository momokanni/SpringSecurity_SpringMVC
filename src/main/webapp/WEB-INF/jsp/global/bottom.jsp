<%@ page contentType="text/html; charset=UTF-8" language="java"%>
 <link href="/resource/css/common/web/style.css?<%@include file='/resource/include/.ver'%>" rel="stylesheet" type="text/css" /> 

<!--客服-->
<div id="wap" style="display:none;">
<div class="xyc_tool">
    <ul>
        <li class="tool_item_1 kf2">  
        	         
            
               <div class="t_ic00">
                   <span style=" font-size:12px; color:#fff; line-height:12px; height:12px;display:block; overflow:hidden">09:00<br/></span>
                   <span style=" font-size:5px; color:#fff;line-height:7px; height:7px; display:block; overflow:hidden;margin-top:2px">|<br/></span>
                   <span style=" font-size:12px;color:#fff; line-height:12px; height:12px; display:block; overflow:hidden;">18:00<br/></span>
               </div>
               <img style="display:block; margin-left:4px;margin-top:2px" src="//www.xiaoyoucai.com/source/images/web/icon/xf_icon_06.png"/>
        </li>  
        <li class="tool_item kff">   

               
             <a target="_blank" href="javascript:void(0);" id="jinfukfSubmit">  
               <div class="tool_item000" >
               <img src="//www.xiaoyoucai.com/source/images/web/icon/xf_icon_01.png"style="  margin-top:5px;margin-bottom:5px;" class="t_ic01"/>
               <p style=" font-size:12px; color:#fff; height:15px; line-height:15px;margin-top:5px">在线<br/>客服</p>
               </div>
             </a>
        </li>
        <li class="tool_item kf ">
            <a target="_blank" href="//www.xiaoyoucai.com/accountInfo">
            <div class="tool_item000" >
               <img src="//www.xiaoyoucai.com/source/images/web/icon/xf_icon_02.png"style="margin-top:5px;margin-bottom:5px;" class="t_ic01"/>
               <p style=" font-size:12px; color:#fff; height:15px; line-height:15px;margin-top:5px">我的<br/>账户</p>
            </div>
            </a>
       </li>
        <li class="tool_item kf">
   
        
            <div class="item_tc" style="right:55px;">
                <div class="item_box">
                    
                    <div class="app_ewm">
                    	<img src="//www.xiaoyoucai.com/source/images/web/icon/xf_icon_07.png"> 
                    </div>
                    <div style="color:#666; manrgi-top:5px;">下载手机客户端</div>
                </div>
            </div>
       
            <a target="_blank"  href="//www.xiaoyoucai.com/app/pcdownload.html">
            <div class="tool_item000" >
               <img src="//www.xiaoyoucai.com/source/images/web/icon/xf_icon_03.png"style="margin-top:5px;margin-bottom:5px;" class="t_ic01"/>
               <p style=" font-size:12px; color:#fff; height:15px; line-height:15px;margin-top:5px">下载<br/>APP</p>
            </div>
            </a>
        </li>
        <li class="tool_item kf">
            <a target="_blank" href="//www.xiaoyoucai.com/support/question">
               <div class="tool_item000" >
               <img src="//www.xiaoyoucai.com/source/images/web/icon/xf_icon_04.png"style="  margin-top:5px;margin-bottom:5px;" class="t_ic01"/>
               <p style=" font-size:12px; color:#fff; height:15px; line-height:15px;margin-top:5px">常见<br/>问题</p>
               </div>
            </a>
        </li>        <li class="tool_item kf">
            <a  href="#top">
            <div class="tool_item000" >
               <img src="//www.xiaoyoucai.com/source/images/web/icon/xf_icon_05.png"style="  margin-top:5px;margin-bottom:5px;" class="t_ic01"/>
               <p style=" font-size:12px; color:#fff; height:15px; line-height:15px;margin-top:5px">返回<br/>顶部</p>
            </div>
            </a>
        </li>
    </ul>
</div>
</div>
<!--客服ends--> 

<script type='text/javascript' src='//webchat.7moor.com/javascripts/7moorInit.js?accessId=a7f53aa0-c4d6-11e5-b534-9f8adb1fb39a&autoShow=false' async='async'></script>

<!-- 在线客服 -->
<script type="text/javascript">
$(function(){
	
	$("#jinfukfSubmit").click(function(){
//		var u = "//chat.talk99.cn/chat/chat/p.do?c=10037501&f=10050773&g=10055239";
//		window.open(u, "kfwds", "width=700,height=500,top=100,left=100");
		qimoChatClick();
		return false;
	});
	
});
 
</script>
<script type="text/javascript">
 $(function(){
 	$(window).scroll( function() { 
 		var scrollTop = window.pageYOffset|| document.documentElement.scrollTop || document.body.scrollTop;
  		//alert(scrollTop);
 	    if(scrollTop<300){
 	    	 $("#wap").hide();
 	    }else{
 	    	$("#wap").show();
 	    }
 	 } );
 });
</script>
	