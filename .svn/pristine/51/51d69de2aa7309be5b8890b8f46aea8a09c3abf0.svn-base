(function(win, undefined){
	 var parseActionParams = function(url) {
		var ret = {};
		if (url.indexOf("?") == -1) {
			ret.action = url;
			ret.params = {};
		} else {
			var urlSplits = url.split("?");
			ret.action = urlSplits[0];
			ret.params = {};
			var reg = /(.+?)=(.*?)(&)/g;
			var d = urlSplits[1] + "&";
			while ( r = reg.exec(d)) {
				ret.params[r[1]] = r[2];
			}
		}
		return ret;
	 };
	 
	 var canHandle = true;
	 var getUrl = function(op, url,hf,tag) {
		 if (!canHandle) {
			 return;
		 } 
		 canHandle = false;
		 $.getJSON(url ,function(data){
			 canHandle = true;
			 var msg = "操作成功";
			 if (data.ret == 1) {
				 if(!isEmpty(hf)){
					 if(!isEmpty(tag)){
						 top.window.setMenuFocus(tag);
					 }
					 location.href=hf;
		    			return false;
				 }
			 } else {
				 if (data.errmsg != null && data.errmsg != "") {
					 msg = data.errmsg;
				 } else {
					 msg = "操作失败";
				 }
				
			 }
			 showNoticeDlg(op, msg);
			 QNR.TableList.query();
		 });
	 };
	 $(".tab_content").delegate("a[opType='script']", "click", function(){
			//是否跳转
		var hf=$(this).attr("hf");
		var tag=$(this).attr("tag");//页面菜单项位置
		 var id = $(this).attr("data-id"); //添加
		 var op = $(this).html();
		 var rt = $(this).attr("req-type");
		 var url = $(this).attr("data-url");
		 
		 var desc=$(this).attr("confirm_desc");
		 
		 if ("link" == rt) {
			 url = url.replace("$id",id);//添加
			 getUrl(op,url);
		 } else if ("confirm" == rt) {
			 url = url.replace("$id",id);//添加
			 if(isEmpty(desc)){
				 showConfirmDlg2(op,"确定要执行" + op + "操作吗？", true, function() {
					 getUrl(op,url,hf,tag);
				 });
			 }else{
				 showConfirmDlg2(op,desc, true, function() {
					 getUrl(op,url,hf,tag);
				 });
			 }
		 } else if ("div"==rt) {
			 url = url.replace("$id",id);//添加
			 var div_type = $(this).attr("div-type");
			 var params = parseActionParams(url);
			 var tmplName = div_type;
			 var initDatas = params.params;
			 var tmplData = QNR.tmpl[tmplName];
			 if (tmplData == null) {
				 return;
			 }
			 var cache = {};
			 if (tmplData.data) {
				 cache = tmplData.dfunc(initDatas);
				 if (cache.ret == 0) {
					 if (cache.errmsg == null || cache.errmsg == "") {
						 showNoticeDlg(op,"获取数据失败");
					 } else {
						 showNoticeDlg(op,cache.errmsg);
					 }
					 return;
				 }
			 } 
			 var tmpl = tmplData.tmpl(cache);
			 html = tmpl;
			 var w = 400;
			 if(tmplName == 'changeSupplier'){
				 w = 650;
			 }
			 if (tmplData.width != null) {
				 w = tmplData.width;
			 }
			 dlg = new Dlg({width: w});
			 dlg.setHeader("<h2 class='title'>" + tmplData.header + "</h2>");
			 dlg.setBody(html);
			 dlg.setBtns(tmplData.btns);
			 dlg.show();
			 var frm = $("#" + tmplData.tmplId).find("#frm");
			 $(frm).attr("action", params.action);
			 for(var o in params.params) {
				 var p = params.params[o];
				 $(frm).append("<input type='hidden' name='" + o + "' value='" + p + "'/>");
			 }
			 if (tmplData.init != null) {
				 tmplData.init(cache);
			 }
		 }
		 return;
		 
		 
		return false;
	 });
	 
	 /*
	 $(".tab_content").delegate("a[opType='div']", "click", function(){
		 var dataUrl = $(this).attr("script-url");
		 var div_type = $(this).attr("div");
		 var params = parseActionParams(dataUrl);
		 var tmplName = div_type;
		 var initDatas = params.params;
		 var tmplData = MVR.tmpl[tmplName];
		 if (tmplData == null) {
			 return;
		 }
		 var cache = {};
		 if (tmplData.data) {
			 cache = tmplData.dfunc(initDatas);
		 } 
		 var tmpl = tmplData.tmpl(cache);
		 html = tmpl;
		 var w = 400;
		 if (tmplData.width != null) {
			 w = tmplData.width;
		 }
		 dlg = new Dlg({width: w});
		 dlg.setHeader("<h2 class='title'>" + tmplData.header + "</h2>");
		 dlg.setBody(html);
		 dlg.setBtns(tmplData.btns);
		 dlg.show();
		 var frm = $("#" + tmplData.tmplId).find("#frm");
		 $(frm).attr("action", params.action);
		 for(var o in params.params) {
			 var p = params.params[o];
			 $(frm).append("<input type='hidden' name='" + o + "' value='" + p + "'/>");
		 }
		 if (tmplData.init != null) {
			 tmplData.init(cache);
		 }
		return false;
	 });*/
})(window);