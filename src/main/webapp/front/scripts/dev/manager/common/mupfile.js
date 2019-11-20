

var _initUpFile = function(obj) {
	$(obj).change(function() {
		var tar = $(this).attr("tar");
		_tryUpload(tar);
	});
};


var _addImage = function(tar , imageData) {
	var container = $("#c_" + tar);
	
	var l = $(container).attr("l");
	l = parseInt(l, 10);
	
	var s = $(container).find("dl").length;
	
	//var img = "<a gallery='"+ fileServer + imageData.imgOri + "' class='fl pr' fl='t' href='javascript:void(0)' ><img src='" + fileServer + imageData.resize + "' class='imgaut' v='" + imageData.imgKey + "' /><div style='position:absolute; top:0; left:0; width:100%; height:100%; z-index:1;-webkit-touch-callout:none; -webkit-user-select:none; -khtml-user-select:none; -moz-user-select:none;  -ms-user-select:none;  user-select:none; '></div></a>";
	
	var html = [];
	
	var html = [];
	html.push('<dl>');
    html.push("<dt style='height: 50px; '></dt>");
    html.push('<dd><img  src="' + fileServer +imageData.resize + '" style="width:150px;height:150px;" rz="', imageData.resize ,'" key="', imageData.imgKey  ,'"></dd>');
    html.push('<dd><a  title="删除"  href="javascript:void(0);"><b style="font-weight: normal;"  class="addpic_button">删除</b></a>');
    html.push("</dd></dl>");
	
	
	if (s < l) {
		
	} else {
		$(container).find("dl:first").remove();
	}
	
	$(container).append(html.join(""));
};


/*
function addImage(imgData, container) {
	//删除提示信息----------------------------------------
	
	var l = container.attr("l");
	var html = [];
	html.push('<dl>');
    html.push("<dt style='height: 50px; '></dt>");
    html.push('<dd><img  src="' + updhost +imgData.resize + '" style="width:140px;height:140px;" rz="', imgData.resize ,'" key="', imgData.imgKey  ,'"></dd>');
    html.push('<dd><a  title="删除"  href="javascript:void(0);"><b style="font-weight: normal;"  class="addpic_button">删除</b></a>');
    html.push("</dd></dl>");
   //initUpload2("img1",id);
    var c = container.find(".pic_list").find("dl").length;
    if (c < l) {
    	container.find(".pic_list").append(html.join(""));
    } else {
    	container.find(".pic_list").find("dl:first").remove();
    	container.find(".pic_list").append(html.join(""));
    }  
}
*/

$("body").delegate(".addpic_button", "click", function(e) {
	var obj = $(this);
	
	obj.parent().parent().parent().remove();
});

var _tryUpload = function(tar) {
	
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
};
