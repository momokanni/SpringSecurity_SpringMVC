var _jsonSubmit = function(formEl, opts) {
    $.ajax({
        url: opts.url,
        type: 'post',
        data: formEl.serialize(),
        dataType: 'json',
        success: opts.success,
        error: opts.error
    });
};

var notice = function(layobj){
	var li = setInterval(function(){
		$(layobj).html('');
		$(layobj).hide();
		clearInterval(li);
	},2000);
};

var loadCaptch = function(img, chg) {
	img.attr("src" ,captcha + "&t=" + new Date().getTime());
	$.ajax({
		url: challenge + "&t=" + new Date().getTime(),
		type: "get",
		dataType: "jsonp",
		success: function(data){
			if(data.ret){
				chg.val(data.id);
			}
		}
	});
};

var ageMore18 = function(idcard){
	var nian = 0,yue = 0,ri = 0;
	var curDate = new Date(); 
	switch (idcard.length) {
	case 15:
		nian=parseInt(idcard.substr(6,2));
		yue=parseInt(idcard.substr(8,2));
		ri=parseInt(idcard.substr(10,2));
		nian = 1900 + nian;
		break;
	case 18:
		nian=parseInt(idcard.substr(6,4));
		yue=parseInt(idcard.substr(10,2));
		ri=parseInt(idcard.substr(12,2));
		break;
	default:
		r = false;
	}
	if(nian == 0 && yue == 0 && ri == 0){
		return false;
	}
	if(curDate.getFullYear()-nian < 18){
		return false;
	}else if(curDate.getFullYear()-nian > 18){
		return true;
	}else if(curDate.getMonth()+1 < yue){
		return false;
	}else if(curDate.getMonth() + 1 > yue){
		return true;
	}
	else if(curDate.getDate() < ri){
		return false;
	}else{
		return true;
	}
};

var isValidIdCard = function (idcard) {
	idcard = idcard.replace('x','X');
	var area = {
		11 : "北京",
		12 : "天津",
		13 : "河北",
		14 : "山西",
		15 : "内蒙古",
		21 : "辽宁",
		22 : "吉林",
		23 : "黑龙江",
		31 : " 上海",
		32 : "江苏",
		33 : "浙江",
		34 : "安徽",
		35 : "福建",
		36 : "江西",
		37 : "山东",
		41 : "河南",
		42 : "湖北",
		43 : " 湖南",
		44 : "广东",
		45 : "广西",
		46 : "海南",
		50 : "重庆",
		51 : "四川",
		52 : "贵州",
		53 : "云南",
		54 : "西藏",
		61 : " 陕西",
		62 : "甘肃",
		63 : "青海",
		64 : "宁夏",
		65 : "新疆",
		71 : "台湾",
		81 : "香港",
		82 : "澳门",
		91 : "国外"
	};

	var Y, JYM;
	var S, M;
	var idcard_array = new Array();
	idcard_array = idcard.split("");
	/* 地区检验 */
	if (area[parseInt(idcard.substr(0, 2))] == null) {
		// alert(Errors[4 ]);
		return false;
	}
	/* 身份号码位数及格式检验 */
	switch (idcard.length) {
	case 15:
		if ((parseInt(idcard.substr(6, 2)) + 1900) % 4 == 0
				|| ((parseInt(idcard.substr(6, 2)) + 1900) % 100 == 0 && (parseInt(idcard
						.substr(6, 2)) + 1900) % 4 == 0)) {
			ereg = /^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}$/;// 测试出生日期的合法性
		} else {
			ereg = /^[1-9][0-9]{5}[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}$/;// 测试出生日期的合法性
		}
		if (ereg.test(idcard)) {
			// alert(Errors[0]+"15" );
			return true;
		} else {
			// alert(Errors[2 ]);
			return false;
		}
		break;

	case 18:
		// 18位身份号码检测
		// 出生日期的合法性检查
		// 闰年月日:((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))
		// 平年月日:((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))
		if (parseInt(idcard.substr(6, 4)) % 4 == 0
				|| (parseInt(idcard.substr(6, 4)) % 100 == 0 && parseInt(idcard
						.substr(6, 4)) % 4 == 0)) {
			ereg = /^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|[1-2][0-9]))[0-9]{3}[0-9Xx]$/;// 闰年出生日期的合法性正则表达式
		} else {
			ereg = /^[1-9][0-9]{5}19[0-9]{2}((01|03|05|07|08|10|12)(0[1-9]|[1-2][0-9]|3[0-1])|(04|06|09|11)(0[1-9]|[1-2][0-9]|30)|02(0[1-9]|1[0-9]|2[0-8]))[0-9]{3}[0-9Xx]$/;// 平年出生日期的合法性正则表达式
		}
		if (ereg.test(idcard)) {// 测试出生日期的合法性
			// 计算校验位
			S = (parseInt(idcard_array[0]) + parseInt(idcard_array[10])) * 7
					+ (parseInt(idcard_array[1]) + parseInt(idcard_array[11]))
					* 9
					+ (parseInt(idcard_array[2]) + parseInt(idcard_array[12]))
					* 10
					+ (parseInt(idcard_array[3]) + parseInt(idcard_array[13]))
					* 5
					+ (parseInt(idcard_array[4]) + parseInt(idcard_array[14]))
					* 8
					+ (parseInt(idcard_array[5]) + parseInt(idcard_array[15]))
					* 4
					+ (parseInt(idcard_array[6]) + parseInt(idcard_array[16]))
					* 2 + parseInt(idcard_array[7]) * 1
					+ parseInt(idcard_array[8]) * 6 + parseInt(idcard_array[9])
					* 3;
			Y = S % 11;
			M = "F";
			JYM = "10X98765432";
			M = JYM.substr(Y, 1);/* 判断校验位 */
			if (M == idcard_array[17]) {
				return true; /* 检测ID的校验位 */
			} else {
				return false;
			}
		} else {
			return false;
		}
		break;

	default:
		return false;
	}
};

var getMidScreen = function(divObj){
	var offset = {
			left : 0,
			top : 0
	};
	var h = $(divObj).height();
	var w = $(divObj).width();
	var ww = window.innerWidth ? window.innerWidth : $(window).width();
	var wh = window.innerHeight ? window.innerHeight : $(window).height();
	
	var left = 0;
	if (ww > w) {
		left = (ww - w) / 2;
	} else {
		left = (1024 - w) / 2;
	}
	var top = 0;
	if (wh > h) {
		top = (wh - h) / 2;
	} else {
		top = (768 - h) / 2;
	}
	var doc = document.documentElement, body = document.body;
	top = top + (doc && doc.scrollTop  ||  body && body.scrollTop  || 0) - (doc && doc.clientTop  || body && body.clientTop  || 0);
	offset.top = top;
	offset.left = left;
	return offset;
};

var closeDiv = function() {
	var coverdv = $("#coverdv");
	var upperdv = $("#upperdv");
	upperdv.empty();
	coverdv.addClass("dn");
	upperdv.addClass("dn");
};
var closeDiv1 = function() {
	var coverdv = $("#coverdv");
	var upperdv = $("#cardmaskdiv");
	upperdv.empty();
	coverdv.addClass("dn");
	upperdv.addClass("dn");
};

var openParentDiv = function(innerFunc, dofunc,addclass){
	var coverdv = $("#divly",parent.document);
	var upperdv = $("#tandiv",parent.document);
	var h = innerFunc();
	upperdv.html(h);
	$(upperdv).removeClass("dn");
	
	coverdv.removeClass('dn');
	coverdv.height($(parent.document).height());
	if(addclass){
		upperdv.find('.sqdiv').addClass('extsqdiv')
	}else{
		upperdv.find('.sqdiv').addClass('lextsqdiv')
		upperdv.find('.sqdiv').attr('style','');
		upperdv.find('#htitle').attr('style','');
		upperdv.find('#tbRepayDetails').attr('style','');
	}
	if (dofunc != null) {
		dofunc();
	}
}

var openDiv = function(innerFunc, dofunc) {
	var coverdv = $("#coverdv");
	var upperdv = $("#upperdv");
	var h = innerFunc();
	upperdv.html(h);
	$(upperdv).removeClass("dn");
	var offset = getMidScreen(upperdv);
	
//	$(upperdv).offset(offset);
	$(upperdv).css("left", offset.left);
	$(upperdv).css("top", offset.top);
	
	
	coverdv.removeClass('dn');
	coverdv.height($(document).height());
	
	if (dofunc != null) {
		dofunc();
	}
};

var openDiv3 = function(innerFunc, dofunc) {
	var coverdv = $("#coverdv");
	var upperdv = $("#upperdv");
	var h = innerFunc();
	upperdv.html(h);
	$(upperdv).removeClass("dn");
	var offset = getMidScreen(upperdv);
	
	$(upperdv).offset(offset);
	
	
	coverdv.removeClass('dn');
	coverdv.height($(document).height());
	
	if (dofunc != null) {
		dofunc();
	}
}; 



var openDivApp1 = function(innerFunc, dofunc) {
	var coverdv = $("#coverdv");
	var upperdv = $("#upperdv");
	var h = innerFunc();
	upperdv.html(h);
	$(upperdv).removeClass("dn");
	coverdv.removeClass('dn');
	if (dofunc != null) {
		dofunc();
	}
}; 

/**
 * 全屏显示
 */
var openDivAllWindow = function(innerFunc, dofunc) {
	var coverdv = $("#coverdv");
	var upperdv = $("#upperdv");
	var h = innerFunc();
	upperdv.html(h);
	$(upperdv).removeClass("dn");
	var offset = {
			left : 0,
			top : 0
	}; 
	$(upperdv).offset(offset);
	
	
	coverdv.removeClass('dn');
	coverdv.height($(document).height());
	
	if (dofunc != null) {
		dofunc();
	}
};


var openDiv5 = function(h,dofunc){
	var coverdv = $("#coverdv");
	var upperdv = $("#cardmaskdiv");
	upperdv.html(h);
	$(upperdv).removeClass("dn");
	coverdv.removeClass('dn');
	coverdv.height($(document).height());
	
	if (dofunc != null) {
		dofunc();
	}
};
var openDiv6 = function(h,dofunc){
	var coverdv = $("#coverdv");
	var upperdv = $("#cardmaskdiv1");
	upperdv.html(h);
	$(upperdv).removeClass("dn");
	coverdv.removeClass('dn');
	coverdv.height($(document).height());
	
	if (dofunc != null) {
		dofunc();
	}
};
var openDiv2 = function(h,dofunc){
	var coverdv = $("#coverdv");
	var upperdv = $("#upperdv");
	upperdv.html(h);
	$(upperdv).removeClass("dn");
	var offset = getMidScreen(upperdv);
	
	$(upperdv).offset(offset);
	
	
	coverdv.removeClass('dn');
	coverdv.height($(document).height());
	
	if (dofunc != null) {
		dofunc();
	}
};

var notify2 = function(p, eid,enable,msg,type) {
	if (type == 'input') {
	if (enable) {
		$(p).find("span[tar='" + eid + "'] i").addClass("q_bg dis");
		$(p).find("span[tar='" + eid + "'] span[class='tipscontent']").html(msg);
	} else {
		$(p).find("span[tar='" + eid + "'] i").removeClass("q_bg dis");
		$(p).find("span[tar='" + eid + "'] span[class='tipscontent']").html('');
		}
	}
};

var notify = function(eid,enable,msg,type) {
	if (type == 'input') {
	if (enable) {
		$("span[tar='" + eid + "'] i").addClass("q_bg dis");
		$("span[tar='" + eid + "'] span[class='tipscontent']").html(msg);
	} else {
		$("span[tar='" + eid + "'] i").removeClass("q_bg dis");
		$("span[tar='" + eid + "'] span[class='tipscontent']").html('');
		}
	}
};

var getTimeLeft = function(time) {
	var day = parseInt(time / (24 * 60 * 60 * 1000), 10);
	var hours = time % (24 * 60 * 60 * 1000);
	var hour = parseInt(hours / (60 * 60 * 1000), 10);
	var minutes = hours % (60 * 60 * 1000);
	var minute = parseInt(minutes / (60 * 1000), 10);
	var seconds = minutes % (60 * 1000);
	var second = parseInt(Math.ceil(seconds / 1000), 10);
	return {
		day : day,
		hour : hour,
		minute : minute,
		second : second
	};
};
var round = function (x, y) {
	var f = parseFloat(x); 
    if (isNaN(f)) { 
        return; 
    }
    var b = 1;
    for(var i = 0; i < y; i++) {
    	b *= 10;
    }
    f = Math.floor( x * b) / b;
    return f;
};
var toDecimal = function (x) { 
    var f = parseFloat(x); 
    if (isNaN(f)) { 
        return; 
    } 
    f = Math.floor(x*100)/100; 
    return f; 
};
var replaceFullWithNumber = function(f) {
	f = f.replace(/１/g, 1)
		 .replace(/２/g, 2)
		 .replace(/３/g, 3)
		 .replace(/４/g, 4)
		 .replace(/５/g, 5)
		 .replace(/６/g, 6)
		 .replace(/７/g, 7)
		 .replace(/８/g, 8)
		 .replace(/９/g, 9)
		 .replace(/０/g, 0);
	return f;
};
var replaceNoFloat = function(f) {
	f = replaceFullWithNumber(f);
	f = f.replace(/[^0-9\.]/g, "");
	return f;
};
var replaceNoNumber = function(f) {
	f = replaceFullWithNumber(f);
	f = f.replace(/[^0-9]/g, "");
	return f;
};

var isEmpty = function(name) {
	return name == null || $.trim(name) == "";
};

var isPartnerPath = function(path) {
	if(path == null) return false;
	
	var regex = /^\/\/www.xiaoyoucai.com\/source\/images\/.*\.(jpg|png)$/;
	return regex.test($.trim(path));
}

var isMobile = function(mobile) {
	if (mobile == null) return false;
	
	var regex = /^\d{11}$/;
	return regex.test($.trim(mobile));
};
var isNumber = function(number) {
	if (number == null) return false;
	
	var regex = /^\d+$/;
	return regex.test(number);
};
var isFloat = function(number) {
	if (number == null) return false;
	
	var regex = /^(\d+|\d+\.\d+)$/;
	return regex.test(number);
};
var isPhone = function(phone) {
	if (phone == null) return false;
	
	var regex = /^[\d][\d\-]*$/;
	return regex.test(phone);
};
var isLoginName = function(name) {
	if (name == null) return false;
	
	var regex = /^[a-zA-Z][\da-zA-Z_]*$/;
	return regex.test(name);
};

var isPinYin = function(pinyin) {
	if (pinyin == null) return false;
	var regex = /^[a-zA-Z]+$/;
	return regex.test(pinyin);
};
var isValidIdNo = function (e) {
	e = e.toUpperCase();
	if (!(/(^\d{15}$)|(^\d{17}([0-9]|X)$)/.test(e))) {
		return false;
	}
	var f, l;
	f = e.length;
	if (f == 15) {
		l = new RegExp(/^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})$/);
		var k = e.match(l);
		var c = new Date("19" + k[2] + "/" + k[3] + "/" + k[4]);
		var b;
		b = (c.getYear() == Number(k[2]))
				&& ((c.getMonth() + 1) == Number(k[3]))
				&& (c.getDate() == Number(k[4]));
		if (!b) {
			return false;
		} else {
			var h = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4,
					2);
			var j = new Array("1", "0", "X", "9", "8", "7", "6", "5", "4", "3",
					"2");
			var g = 0, d;
			e = e.substr(0, 6) + "19" + e.substr(6, e.length - 6);
			for (d = 0; d < 17; d++) {
				g += e.substr(d, 1) * h[d];
			}
			e += j[g % 11];
			return true;
		}
	}
	if (f == 18) {
		l = new RegExp(/^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/);
		var k = e.match(l);
		var c = new Date(k[2] + "/" + k[3] + "/" + k[4]);
		var b;
		b = (c.getFullYear() == Number(k[2]))
				&& ((c.getMonth() + 1) == Number(k[3]))
				&& (c.getDate() == Number(k[4]));
		if (!b) {
			return false;
		} else {
			var a;
			var h = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4,
					2);
			var j = new Array("1", "0", "X", "9", "8", "7", "6", "5", "4", "3",
					"2");
			var g = 0, d;
			for (d = 0; d < 17; d++) {
				g += e.substr(d, 1) * h[d];
			}
			a = j[g % 11];
			if (a != e.substr(17, 1)) {
				return false;
			}
			return true;
		}
	}
	return false;
}
var isMail = function(mail) {
	if (mail == null) return false;
	
	var regex = /^([a-zA-Z0-9]+[_|\_|\.|\-]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.|\-]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	return regex.test(mail);
};

var isBankNo = function(bankNo){
	if(bankNo == null) return fasle;
	var regex = /^[0-9]{16,19}$/;
	return regex.test(bankNo);
};


var showConfirmDlg2 = function(title, msg,  close, func) {
	var dlg = new Dlg({width : "400"});
    dlg.setHeader("<h2 class='title'>"+title+"</h2>");
    var html = msg;
    dlg.setBody(html);   
    dlg.setBtns([
       {
           "text" : "确定",
           fn : function(data){
        	   func(data);
        	   if (close) {
        		   dlg.close();
        	   }
           }
       },
       {
    	   "text" : "取消",
    	   fn : function (data) {
    		   dlg.close();
    	   }
       }
    ]);
    dlg.show();
};

var showConfirmDlg4 = function(title, msg,  close, func, id) {
	var dlg = new Dlg({width : "400"});
    dlg.setHeader("<h2 class='title'>"+title+"</h2>");
    var html = msg;
    dlg.setBody(html);   
    dlg.setBtns([
       {
           "text" : "通过复审",
           fn : function(data){
        	   func(id);
        	   if (close) {
        		   dlg.close();
        	   }
           }
       },
       {
    	   "text" : "取消",
    	   fn : function (data) {
    		   dlg.close();
    	   }
       }
    ]);
    dlg.show();
};

var showConfirmDlg3 = function(title, msg,  close, func, id) {
	var dlg = new Dlg({width : "400"});
    dlg.setHeader("<h2 class='title'>"+title+"</h2>");
    var html = msg;
    dlg.setBody(html);   
    dlg.setBtns([
       {
           "text" : "通过初审",
           fn : function(data){
        	   func(id);
        	   if (close) {
        		   dlg.close();
        	   }
           }
       },
       {
    	   "text" : "取消",
    	   fn : function (data) {
    		   dlg.close();
    	   }
       }
    ]);
    dlg.show();
};

var showConfirmDlg5 = function(title, msg,  close, func, id) {
	var dlg = new Dlg({width : "400"});
    dlg.setHeader("<h2 class='title'>"+title+"</h2>");
    var html = msg;
    dlg.setBody(html);   
    dlg.setBtns([
       {
           "text" : "确定",
           fn : function(data){
        	   func(id);
        	   if (close) {
        		   dlg.close();
        	   }
           }
       },
       {
    	   "text" : "取消",
    	   fn : function (data) {
    		   dlg.close();
    	   }
       }
    ]);
    dlg.show();
};

var showConfirmDlg = function(title, msg, func) {
	var dlg = new Dlg({width : "400"});
    dlg.setHeader("<h2 class='title'>"+title+"</h2>");
    var html = msg;
    dlg.setBody(html);   
    dlg.setBtns([
       {
           "text" : "确定",
           fn : function(){
        	   dlg.close();
        	   if (func != null) {
        		   func();
        	   }
           }
       }, 
       {
    	   "text" : "取消",
           fn : function(){
        	   dlg.close();
           }
       }
    ]);
    dlg.show();
};
var showNoticeDlg = function(title,msg,func) {
	var dlg = new Dlg({width : "400"});
    dlg.setHeader("<h2 class='title'>"+title+"</h2>");
    var html = msg;
    dlg.setBody(html);   
    dlg.setBtns([
       {
           "text" : "确定",
           fn : function(){
        	   dlg.close();
        	   if (func != null) {
        		   func();
        	   }
           }
       }
    ]);
    dlg.show();
};



function isUrl(str){
	/*var regu=/^(http|https|ftp):\/\/([a-zA-Z0-9]([a-zA-Z0-9\-]{0,61}[a-zA-Z0-9])?\.)+[a-zA-Z]{2,6}$/;*/
	var regu=/^(http|https|ftp):\/\/[\w\-_]+(\.[\w\-_]+)+([\w\-\.,@?^=%&amp;:\/~\+#]*[\w\-\@?^=%&amp;\/~\+#])?$/;
	return regu.test(str);
}

var showLay = function(div,maskdiv){
	var offset = getMidScreen(div);
	$(div).css('top',offset.top + 'px');			
	$(maskdiv).attr('style','height:' + $(document).height() + 'px;');
	$(maskdiv).removeClass('dn');
	$(div).removeClass('dn');
};

var showNoTopLay = function(div,maskdiv){
	getMidScreen(div);
	$(maskdiv).attr('style','height:' + $(document).height() + 'px;');
	$(maskdiv).removeClass('dn');
	$(div).removeClass('dn');
};

var showParentLay = function(div,maskdiv){
	var offset = getMidScreen(div);
	$(div).css('top',offset.top + 'px');			
	$(maskdiv).attr('style','height:' + $(parent.document).height() + 'px;');
	$(maskdiv).removeClass('dn');
	$(div).removeClass('dn');
};

var showXmsParentLay = function(div,maskdiv){
	$(maskdiv).attr('style','height:' + $(parent.document).height() + 'px;');
	$(maskdiv).removeClass('dn');
	$(div).removeClass('dn');
};

function validateUploadImg(containerId){
	var container = $("#" + containerId);
	if (container.length == 0)
		return false;
	
	var img = container.children("img:first");
	var isOk = true;
	if (img.length == 0)
		isOk = false;
	else {
		if (isEmpty(img.attr("dl")))
			isOk = false;
	}
	container.removeClass("redBd");
	if (!isOk){
		container.addClass("redBd");
	}
	
	return isOk;
}






//银行卡号合法性验证
function luhmCheck(bankno){
	if(bankno==""||bankno==null){ 
		  return false;    	
	}
	var lastNum=bankno.substr(bankno.length-1,1);
	
	var first15Num=bankno.substr(0,bankno.length-1);
	var newArr=new Array();
	for(var i=first15Num.length-1;i>-1;i--){  
		newArr.push(first15Num.substr(i,1));
	}
	var arrJiShu=new Array();  
	var arrJiShu2=new Array();
	
	var arrOuShu=new Array(); 
	for(var j=0;j<newArr.length;j++){
	if((j+1)%2==1){
	   if(parseInt(newArr[j])*2<9)
	   arrJiShu.push(parseInt(newArr[j])*2);
	   else
	   arrJiShu2.push(parseInt(newArr[j])*2);
	}
	else
		arrOuShu.push(newArr[j]);
	}
	
	var jishu_child1=new Array();
	var jishu_child2=new Array();
	for(var h=0;h<arrJiShu2.length;h++){
		jishu_child1.push(parseInt(arrJiShu2[h])%10);
		jishu_child2.push(parseInt(arrJiShu2[h])/10);
	}       
	
	var sumJiShu=0; 
	var sumOuShu=0; 
	var sumJiShuChild1=0;
	var sumJiShuChild2=0;
	var sumTotal=0;
	for(var m=0;m<arrJiShu.length;m++){
		sumJiShu=sumJiShu+parseInt(arrJiShu[m]);
	}
	
	for(var n=0;n<arrOuShu.length;n++){
		sumOuShu=sumOuShu+parseInt(arrOuShu[n]);
	}
	
	for(var p=0;p<jishu_child1.length;p++){
		sumJiShuChild1=sumJiShuChild1+parseInt(jishu_child1[p]);
		sumJiShuChild2=sumJiShuChild2+parseInt(jishu_child2[p]);
	}     
	sumTotal=parseInt(sumJiShu)+parseInt(sumOuShu)+parseInt(sumJiShuChild1)+parseInt(sumJiShuChild2);
	
	var k= parseInt(sumTotal)%10==0?10:parseInt(sumTotal)%10;       
	var luhm= 10-k;
	if(bankno.length == 17){
	luhm = lastNum;
	}
	if(lastNum==luhm){
		return true;
	}
	else{ 
	return false;
	}	       
}



/**
 * 检测字符传是否为非图片文件
 */
function checkFile(url){
	if(isEmpty(url)){
		return null;
	}
	var str=url.substr(url.lastIndexOf(".")+1);
	str=str.toLowerCase();
	if("jpg"==str||"gif"==str||"png"==str||"bmp"==str){
		return false;
	}
	return true;
}




function convertCurrency( currencyDigits ) {
	 
    var MAXIMUM_NUMBER = 99999999999.99;  //最大值
    // 定义转移字符
    var CN_ZERO = "零";
    var CN_ONE = "壹";
    var CN_TWO = "贰";
    var CN_THREE = "叁";
    var CN_FOUR = "肆";
    var CN_FIVE = "伍";
    var CN_SIX = "陆";
    var CN_SEVEN = "柒";
    var CN_EIGHT = "捌";
    var CN_NINE = "玖";
    var CN_TEN = "拾";
    var CN_HUNDRED = "佰";
    var CN_THOUSAND = "仟";
    var CN_TEN_THOUSAND = "万";
    var CN_HUNDRED_MILLION = "亿";
    var CN_DOLLAR = "元";
    var CN_TEN_CENT = "角";
    var CN_CENT = "分";
    var CN_INTEGER = "整";
 
    // 初始化验证:
    var integral, decimal, outputCharacters, parts;
    var digits, radices, bigRadices, decimals;
    var zeroCount;
    var i, p, d;
    var quotient, modulus;
 
    // 验证输入字符串是否合法
    if (currencyDigits.toString() == "") {
        return "";
    }
    if (!isFloat( currencyDigits )) {
        return "";
    }
 
    //判断是否输入有效的数字格式
    var reg = /^((\d{1,3}(,\d{3})*(.((\d{3},)*\d{1,3}))?)|(\d+(.\d+)?))$/;
    if (!reg.test(currencyDigits)) {
        return "" ;
 
    }
 
    currencyDigits = currencyDigits.replace(/,/g, ""); 
    currencyDigits = currencyDigits.replace(/^0+/, ""); 
    //判断输入的数字是否大于定义的数值
    if (Number(currencyDigits) > MAXIMUM_NUMBER) {
        return "";
    }
     
    parts = currencyDigits.split(".");
    if (parts.length > 1) {
        integral = parts[0];
        decimal = parts[1];
        decimal = decimal.substr(0, 2);
    }
    else {
        integral = parts[0];
        decimal = "";
    }
    // 实例化字符大写人民币汉字对应的数字
    digits = new Array(CN_ZERO, CN_ONE, CN_TWO, CN_THREE, CN_FOUR, CN_FIVE, CN_SIX, CN_SEVEN, CN_EIGHT, CN_NINE);
    radices = new Array("", CN_TEN, CN_HUNDRED, CN_THOUSAND);
    bigRadices = new Array("", CN_TEN_THOUSAND, CN_HUNDRED_MILLION);
    decimals = new Array(CN_TEN_CENT, CN_CENT);
    
    outputCharacters = "";
    //大于零处理逻辑
    if (Number(integral) > 0) {
        zeroCount = 0;
        for (i = 0; i < integral.length; i++) {
            p = integral.length - i - 1;
            d = integral.substr(i, 1);
            quotient = p / 4;
            modulus = p % 4;
            if (d == "0") {
                zeroCount++;
            }
            else {
                if (zeroCount > 0) {
                    outputCharacters += digits[0];
                }
                zeroCount = 0;
                outputCharacters += digits[Number(d)] + radices[modulus];
            }
            if (modulus == 0 && zeroCount < 4) {
                outputCharacters += bigRadices[quotient];
            }
        }
        outputCharacters += CN_DOLLAR;
    }
    // 包含小数部分处理逻辑
    if (decimal != "") {
        for (i = 0; i < decimal.length; i++) {
            d = decimal.substr(i, 1);
            if (d != "0") {
                outputCharacters += digits[Number(d)] + decimals[i];
            }
        }
    }
    //确认并返回最终的输出字符串
    if (outputCharacters == "") {
        outputCharacters = CN_ZERO + CN_DOLLAR;
    }
    if (decimal == "") {
        outputCharacters += CN_INTEGER;
    }
 
    //获取人民币大写
    return outputCharacters;
}

var bootAlert = function(mess, func) {
	var iKj = (top.location.href != location.href);
	if (iKj) {
		top.bootbox.alert(mess, func);
	} else {
		bootbox.alert(mess, func);
	}
};

var bootConfirm = function(mess, func) {
	var iKj = (top.location.href != location.href);
	if (iKj) {
		top.bootbox.confirm(mess, function(conf){
			if (conf) {
				func();
			}
		});
	} else {
		bootbox.confirm(mess, function(conf){
			if (conf) {
				func();
			}
		});
	}
};

var initDataPicker = function(obj) {
	var ops = {
		language : "zh-CN",
		format : "yyyy-mm-dd",
		autoclose : true,
		clearBtn : true,
		todayHighlight : true
	};
	obj.datepicker(ops);
};


var mobileNotice = function( mess, func) {
	var h = [];
	h.push("<div id='_common_mess' class='lay_cw'>");
	h.push(mess);
	h.push("</div>");
	
	$("body").append(h.join(""));
	
	setTimeout(function() {
		$("#_common_mess").remove();
		if (func != null) {
			func();
		}
	}, 1000);
};

var mobileConfirm = function(title, func, cancelFunc) {
	var h = [];
	var t = new Date().getTime();
	var idt = "_confirm_" + t;
	h.push("<div id='", idt ,"'>");
	h.push("	<div class='zhezhao'></div>");
	h.push(" 	<div class='tk_box_c bgf' style='padding:0; padding-top:5%; width:76%'>");
	h.push("	<h3 class='ft18 col3' style='padding-bottom:20px'>", title ,"</h3>");
	h.push("	<div class='my_aqtc_btn'><a href='javascript:void(0)' class='fl ft14 col6' _del='t'>取消</a><a href='javascript:void(0)' _con='t' class='fr ft14 colgreen02'>确定</a></div>");
	h.push("	</div>");
	h.push("</div>");
	
	$("body").append(h.join(""));
	
	$("#" + idt).find("[_del]").click(function() {
		if (cancelFunc != null) {
			cancelFunc();
		}
		$("#" + idt).remove();
		return false;
	});
	
	$("#" + idt).find("[_con]").click(function() {
		func();
		$("#" + idt).remove();
	});
};

var mobileConfirmTip = function(title, tip, func, cancelFunc) {
	var h = [];
	var t = new Date().getTime();
	var idt = "_confirm_" + t;
	h.push("<div id='", idt ,"'>");
	h.push("	<div class='zhezhao'></div>");
	h.push(" 	<div class='tk_box_c bgf' style='padding:0; padding-top:5%; width:76%'>");
	h.push("	<h3 class='ft18 col3' style='padding-bottom:20px'>", title ,"</h3>");
	h.push("	<p class='col6 ft14' style='padding-bottom:20px'>", tip ,"</p>");
	h.push("	<div class='my_aqtc_btn'><a href='javascript:void(0)' class='fl ft14 col6' _del='t'>取消</a><a href='javascript:void(0)' _con='t' class='fr ft14 colgreen02'>确定</a></div>");
	h.push("	</div>");
	h.push("</div>");
	
	$("body").append(h.join(""));
	
	$("#" + idt).find("[_del]").click(function() {
		if (cancelFunc != null) {
			cancelFunc();
		}
		$("#" + idt).remove();
		return false;
	});
	
	$("#" + idt).find("[_con]").click(function() {
		func();
		$("#" + idt).remove();
	});
};

var fmoney = function(s, n) {
   n = n > 0 && n <= 20 ? n : 2;  
   s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(n) + "";  
   var l = s.split(".")[0].split("").reverse();
   var r = s.split(".")[1];  
   var t = "";  
   for(var i = 0; i < l.length; i ++ ) {  
      t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? "," : "");  
   }  
   return t.split("").reverse().join("") + "." + r;  
};

var addDay = function(d, n) {
	var l = d.getTime();
	l = l + (24 * 60 * 60 * 1000) * n;
	
	return new Date(l);
};

var formatDateyyyyMMdd = function(d) {
	var year = d.getFullYear();
	var month = d.getMonth() + 1;
	  
	month = month <= 9 ? ("0" + month) : ("" + month);
	
	var day = d.getDate();
	day = day <= 9 ? ("0" + day) : ("" + day);
	  
	return year + "-" + month + "-" + day;
};


var charCount = function (c,s){
//	mobileNotice("a");
	if (s.indexOf(c) == -1) {
		return 0;
	}
	var re = eval("/"+c+"/ig");
	return s.match(re).length;
}

/**
 * 错误提示消息
 */
var errorTips = function(msg){
	$('body').toast({
		position:'fixed',
		content:msg,
		duration:1000,
		fontSize:20,
		isCenter:true,
		background:'#fb6041',
		animateIn:'bounceIn-hastrans',
		animateOut:'bounceOut-hastrans',
	});
}

/**
 * 正常提示消息
 */
var successTips = function(msg){
	$('body').toast({
		position:'fixed',
		content:msg,
		duration:1000,
		fontSize:20,
		isCenter:true,
		background:'#418aec',
		animateIn:'bounceIn-hastrans',
		animateOut:'bounceOut-hastrans',
	});
}
	
