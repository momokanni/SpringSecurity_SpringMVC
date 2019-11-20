//var callback = function ( result ) {
//	var msg = result.msg
//	if ( isEmpty(msg) ) {
//		 
//		getUserInfo( result.openid );
//		
//	}else {
//		//失败
//		return ;
//	}
//}

$(function(){
	var uInfo = {};//登录用户信息
	/**
	 * 全局变量
	 * appId 
	 * token 
	 */ 
//	//查询openId回调
	
	
	//按openId查询用户信息
//	var getUserInfo = function( openid ){
//		$.ajax({
//    		url: "https://graph.qq.com/user/get_user_info?oauth_consumer_key="+appId+"&access_token="+token+"&openid="+openid,    		 
//    		type: "GET", 
//    		dataType: 'jsonp',
//    		success: function(data){
//    			if( data.ret == 0 ){
//    				//返回成功
//    				//$("#actual_annualized_rate").html(data.actual_annualized_rate); 
//    				uInfo.nickname = data.nickname;//用户名
//    				alert("登录用户名称："+data)
//    			}else {
//    				
//    			}
//    		}
//		});
//	}
	
	var getUserInfo = function ( openid ) {
		$.ajax({
    		url: "/getQQUserInfo",
    		data : { 
    			openid : openid,
    			accessToken : token
    		},
    		type: "get",
    		dataType: "json",
    		success: function(data){
    			alert(data.data.nickname)
    		}
		});
	}
	
	
	
	
	
	
	
	 var getLoginUserInfo = function(){
			$.ajax({ 
	    		url: "https://graph.qq.com/oauth2.0/me",
	    		dataType: "jsonp",
	    		jsonpCallback : "callback",
	    		data : {
	    			access_token : token 	    			
	    		},
	    		success: function(json){
	    			var msg = json.msg
	    			if ( isEmpty(msg) ) {
	    				alert("正确");
	    				//成功
	    				getUserInfo( json.openid );
	    				
	    			}else {
	    				//失败
	    				alert("失败");
	    			}
	    		}
	    		
			}); 
	 };
//	 var getLoginUserInfo = function(){
//			$.ajax({ 
//	    		url: "https://graph.qq.com/oauth2.0/me",
//	    		type: "GET",
//	    		dataType: "jsonp",
//	    		jsonp : "callback",
//	    		data : {
//	    			access_token : token 	    			
//	    		},
//	    		success: function(json){
//	    			 
//	    		}
//	    		
//			}); 
//	 };
	getLoginUserInfo();
});



