function getlength(str){
		 var realLength = 0, len = str.length, charCode = -1;
	    for (var i = 0; i < len; i++) {
	        charCode = str.charCodeAt(i);
	        if (charCode >= 0 && charCode <= 128) realLength += 1;
	        else realLength += 2;
	    }
	    return realLength;
	} 
	
function stripscript(s)
{
	var pattern = "[`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（） —|{}【】‘；：”“'。，、？\"]";
	for (var i = 0; i < s.length; i++) {
		var a = s.substr(i,i+1);
		if(pattern.indexOf(a)>-1){
			return false;			
		}
	}
	return true;

}

var checkpasswd = function(pwd,repwd,isre){
	var r = {
			'ret' : true,
			'msg' : ''
		};
	if(pwd.length < 6 || pwd.length > 16){
		r.ret = false;
		r.msg = '密码长度为6-16位';
		return r;
	}
	if(isre){
		if(pwd != repwd){
			r.ret = false;
			r.msg = '密码不一致';
			return r;
		}
	}
	return r;
};

var nameok = false;
var tmpName = '';
var checkName = function(name){
	var r = {
		'ret' : true,
		'msg' : ''
	};
	if(nameok && tmpName == name){
		r.ret = true;
		return r;
	}
	if(!nameok && tmpName == name){
		r.ret = false;
		r.msg = '用户名错误';
		return r;
	}
	tmpName = name;
	nameok = false;
	if(isEmpty(name)){
		r.ret = false;
		r.msg = '请输入用户名';
		return r;
	}
	var len = getlength(name);
	if(len < 4){
		r.ret = false;
		r.msg = '账号长度过短';
		return r;
	}
	if(len > 18){
		r.ret = false;
		r.msg = '账号长度过长';
		return r;
	}
	if(name.match("^[\\d]")){
		r.ret = false;
		r.msg = '不能以数字开头';
		return r;
	}
	if(!stripscript(name)){
		r.ret = false;
		r.msg = '只能是数字、字母或者中文';
		return r;
	}
	var rs = nameExist(name);
	if(rs == 1){
		r.ret = false;
		r.msg = '账号已存在！';
		return r;
	}else if(rs == 3){
		r.ret = false;
		r.msg = '昵称非法！';
		return r;
	}
	nameok = true;
	return r;
};

var nameExist = function(name){
	var r = null;
	$.ajax({
		url: '/dt/existsNickName',
		type: 'POST',
		data: {'nickname' : encodeURI(name)},
		async:false,
		dataType: 'text',
		success: function(d){
			r = d;
		}
	});
	return r;
};

var  inviteCodeOk = false;
var  tmpInviteCode ='';

var checkInviteCode = function(inviteCode){
	var r = {
			'ret' : true,
			'msg' : ''
		};
	if(inviteCodeOk && tmpInviteCode == inviteCode){
		r.ret = true ;
		return r;
	}
	 tmpInviteCode = inviteCode;
	 inviteCodeOk = false;

	 if(! isEmpty(inviteCode)){
		 if(!isMobile(inviteCode)){
			 r.ret = false ;
			 r.msg = '邀请码格式错误';
			 return r;
		 }
	 }
	 
	 inviteCodeOk = true;
	 return r;
};
 
var checkRealName = function(rname){
	var r = {
			'ret' : true,
			'msg' : ''
		};
	if(isEmpty(rname)){
		r.ret = false;
		r.msg = '姓名不能为空';
		return r;
	}
	if(rname.length > 12){
		r.ret = false;
		r.msg = '姓名过长';
	}
	return r;
};

var checkIdNo = function(idno){
	var r = {
			'ret' : true,
			'msg' : ''
		};
	if(isEmpty(idno)){
		r.ret = false;
		r.msg = '身份证号不能为空';
		return r;
	}
	if(!isValidIdCard(idno)){
		r.ret = false;
		r.msg = '身份证号格式错误';
	}
	return r;
};

var checkSysUsrName = function(name){
	var r = {
			'ret' : true,
			'msg' : ''
		};
	if(isEmpty(name)){
		r.ret = false;
		r.msg = '请输入用户名';
		return r;
	}
	var len = getlength(name);
	if(len < 4){
		r.ret = false;
		r.msg = '账号长度过短';
		return r;
	}
	if(len > 18){
		r.ret = false;
		r.msg = '账号长度过长';
		return r;
	}
	if(name.match("^[\\d]")){
		r.ret = false;
		r.msg = '不能以数字开头';
		return r;
	}
	if(!stripscript(name)){
		r.ret = false;
		r.msg = '只能是数字、字母或者中文';
		return r;
	}
	
	var rs = isSysUsrNameExist(name);
	if(rs == 1){
		r.ret = false;
		r.msg = '账号已存在！';
		return r;
	}else if(rs == 3){
		r.ret = false;
		r.msg = '昵称非法！';
		return r;
	}
	return r;
};


var isSysUsrNameExist = function(name){
	var r = null;
	$.ajax({
		url: '/dt/existSysAndUser',
		type: 'POST',
		data: {'sysname' : encodeURI(name)},
		async:false,
		dataType: 'text',
		success: function(d){
			r = d;
		}
	});
	return r;
};



var checkMobile = function(mobile){
	var r = {
			'ret' : true,
			'msg' : ''
		};
	if(isEmpty(mobile)){
		r.ret = false;
		r.msg = '手机号不能为空';
		return r;
	}
	if(!isMobile(mobile)){
		r.ret = false;
		r.msg = '手机号格式错误';
	}
	return r;
};