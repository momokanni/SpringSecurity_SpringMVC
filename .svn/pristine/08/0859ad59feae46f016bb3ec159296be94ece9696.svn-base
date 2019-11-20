$(function(){
	if($('#loginDiv')[0]!=undefined&&$('#h_userName').text()!=""){
		$('#loginDiv').hide();
	}
	$('#submit').click(formSubmit);
	
	if (document.addEventListener) { // 如果是Firefox
		document.addEventListener("keypress", fireFoxHandler, true);
	} else {
		document.attachEvent("onkeypress", ieHandler);
	}
	
});

function fireFoxHandler(evt) { // 如果是Firefox
	if (evt.keyCode == 13) {
		var id=$("input:focus").attr("id");
		if(id=='userName'){
			$('#password').focus();
		}else if(id=='password'){
			formSubmit();
		}
	}
}

function ieHandler(evt) {
	if (evt.keyCode == 13) {
		var id=$("input:focus").attr("id");
		if(id=='userName'){
			$('#password').focus();
		}else if(id=='password'){
			formSubmit();
		}
	}
}

function formSubmit(){
	var userName=$('#userName').val();
	var password=$('#password').val();
	switch (validation(userName,'账号')) {
		case "null":
			return;
		case "short":
			return;
	}
	switch (validation(password,'密码')) {
		case "null":
			return;
		case "short":
			return;
	}
	
	var autosession=$("input[name='autosession']").is(':checked');
	$.ajax({
		type:"POST",
		url:"/dt/login.action",
		data: {
			userName : userName,
			password : password,
			autosession : autosession,
			ret : ret
		},
		dataType:"text",
		success: function(data) {
			var res = data.split("#");
			switch(res[0]){
				case  "-1" :$('#errorStr').html('邮箱不存在!').css("visibility",""); break;
				case  "-2" : $('#errorStr').html('手机号不存在!').css("visibility",""); break;
				case  "-3" :  $('#errorStr').html('账号不存在!').css("visibility","");break;
				case  "-4" : $('#errorStr').html('密码错误!').css("visibility",""); break;
				case  "-5" : $('#errorStr').html('请重新登录!').css("visibility",""); break;
				case  "-6" : $('#errorStr').html('您已被禁止登录系统').css("visibility",""); break;
				case  "-99" : $('#errorStr').html('账号已被锁定，24小时后解锁!').css("visibility",""); break;
				default:
					if(res[1] !='') {
						if (res[1] == "null") {
							window.location.reload();
						} else {
							window.location.href=res[1];
						}
						
					}else {
						window.location.href=address+'accountInfo.action';
					}
					break;
			}
		}
		
	});
}

function validation(str,msg){
	if($.trim(str).length==0||$.trim(str)=='手机号/用户名/邮箱'){
		$("#errorStr").html(msg+"不能为空!").css("visibility","");
		return "null";
	}
	if($.trim(str).length<2){
		$('#errorStr').html(msg+"长度过短").css("visibility","");
		return "short";
	}
	return false;
}



