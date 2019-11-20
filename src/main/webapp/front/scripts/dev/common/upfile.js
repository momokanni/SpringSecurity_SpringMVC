
var __twx = false;
if (typeof _twx != "undefined") {
	__twx = _twx;
}
//mobileNotice(__wx);
if (__twx) {
	wx.config({
	    debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
	    appId: _appId, // 必填，企业号的唯一标识，此处填写企业号corpid
	    timestamp: _timestamp, // 必填，生成签名的时间戳
	    nonceStr: _nonceStr, // 必填，生成签名的随机串
	    signature: _signature,// 必填，签名，见附录1
	    jsApiList: ["chooseImage","uploadImage","previewImage"] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
	});
	
//	wx.checkJsApi({
//	    jsApiList: ['chooseImage'], // 需要检测的JS接口列表，所有JS接口列表见附录2,
//	    success: function(res) {
//	    	mobileNotice(res);
//	    // 以键值对的形式返回，可用的api值true，不可用为false
//	    // 如：{"checkResult":{"chooseImage":true},"errMsg":"checkJsApi:ok"}
//	    }
//	});
	
//	wx.error(function(res){
//	    mobileNotice("err");
//	});
//	
//	wx.ready(function(res) {
//		mobileNotice("ok");
//	});
//	mobileNotice(wx);
}

var _initUpFile = function(obj) {
	
	if (__twx) {
		var tar = $(obj).attr("tar");
		var vid = $(obj).attr("id");
		$("label[for=" + vid + "]").attr("for", "n_" + vid);
		
		$("label[for=" + "n_" + vid + "]").click(function() {
			_tryUpload(tar);
		});
	} else {
		$(obj).change(function() {
			var tar = $(this).attr("tar");
			_tryUpload(tar);
		});
	}
	
};


var _addImage = function(tar , imageData) {
	var container = $("#c_" + tar);
	
	var l = $(container).attr("l");
	l = parseInt(l, 10);
	
	var s = $(container).find("a[fl]").length;
	
	var img = "<a gallery='"+ fileServer + imageData.imgOri + "' class='fl pr' fl='t' href='javascript:void(0)' ><img src='" + fileServer + imageData.resize + "' class='imgaut' v='" + imageData.imgKey + "' /><div style='position:absolute; top:0; left:0; width:100%; height:100%; z-index:1;-webkit-touch-callout:none; -webkit-user-select:none; -khtml-user-select:none; -moz-user-select:none;  -ms-user-select:none;  user-select:none; '></div></a>";
	
	if (s < l) {
		
	} else {
		$(container).find("a[fl]:first").remove();
	}
	$(container).append(img);
};

var wxUpload = function(localIds, tar) {
	
	var localId = localIds.pop();
	var frm = $("#frm_" + tar);
	var h = frm.find("[name=h]").val();
	var w = frm.find("[name=w]").val();
	wx.uploadImage({
	    localId: localId, 
	    isShowProgressTips: 1, // 默认为1，显示进度提示
	    success: function (res) {
	        var serverId = res.serverId; // 返回图片的服务器端ID
	        $.ajax({  
		        url: "/wx/wxUpload",  
		        type: "get",
		        async : false,
		        data: {
		        	serverId : serverId,
		        	h : h,
		        	w : w
		        },
		        dataType : "json",
		        success:function(data){  
		        	if (data.ret == 1) {
//		        		mobileNotice(tar + "," + data);
		        		_addImage(tar, data);
		        	}
		        }   
		    });  
	        
	        if (localIds.length > 0) {
	        	 wxUpload(localIds, tar);
	        }
	       
	    }
	});
};

var _tryUpload = function(tar) {
	
//	mobileNotice(tar);
	if (__twx) {
		wx.chooseImage({
		    count: 9, // 默认9
		    sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
		    sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
		    success: function (res) {
		        var localIds = res.localIds ; // 返回选定照片的本地ID列表，localId可以作为img标签的src属性显示图片
		        wxUpload(localIds, tar);
		        
		       
		    }
		});
	} else {
		var iptFrm = $("#frm_" + tar);
		var data = new FormData(iptFrm[0]); 
		$.ajax({  
	        url: "/swfupload/ajaxUpload.do",  
	        type: "POST",  
	        data: data,  
	        dataType : "json",
	        cache: false,  
	        processData: false,  
	        contentType: false, 
	        success:function(data){  
	        	if (data.ret == 1) {
	        		_addImage(tar, data);
	        	}
	        }   
	    });  
	}
	
};

$("body").delegate("a[gallery]", "click", function() {
	
	var selImg = $(this).attr("gallery");
	var index = 0;
	var i = 0;
	var imgs = [];
	var curUrl = "";
	$("a[gallery]").each(function(){
		var img = $(this).attr("gallery");
		var imga = "http:" + img;
		imgs.push(imga);
		if (selImg == img) {
			index = i;
			curUrl = imga;
		}
		i++;
	});
	
	if (__twx) {
		wx.previewImage({
			current: curUrl, // 当前显示图片的http链接
			urls: imgs // 需要预览的图片http链接列表
			});
	} else {
		blueimp.Gallery(imgs, {index : index});
	}
	
});

var _lc;
$("body").delegate("a[gallery]", "touchstart", function(e) {
	var s = this;
	e.stopPropagation();
	_lc = setTimeout(function(){
		mobileConfirm("要删除这张图片吗？", function() {
			$(s).remove();
		});
	},1000);
});

$("body").delegate("a[gallery]", "touchend", function(e) {
	e.stopPropagation();
	clearTimeout(_lc);
});