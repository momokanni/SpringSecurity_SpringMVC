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
	 
	 $(document).delegate("[dlg]", "click", function(){
	
		 var id = $(this).attr("data-id"); //添加
		 var url = $(this).attr("data-url");
		 

		 url = url.replace("$id",id);//添加
		 var div_type = $(this).attr("div-type");
		 var params = parseActionParams(url);
		 var tmplName = div_type;
		 var initDatas = params.params;
		 var tmplData = QNR.tmpl[tmplName];
		 if (tmplData == null) {
			 return;
		 }
		 
		 var iKj = (top.location.href != location.href);
		 if (!iKj) {
			 var npg = typeof newUI != "undefined" && newUI;
			 if (npg) {
				 iKj = true;
			 }
		 }
		 initDatas.iKj = iKj;
		 var cache = {};
		 if (tmplData.data) {
			 cache = tmplData.dfunc(initDatas);
			 if (cache.ret == 0) {
				 if (cache.errmsg == null || cache.errmsg == "") {
					 alert("获取数据失败");
				 } else {
					 alert(cache.errmsg);
				 }
				 return;
			 }
		 }
		 cache.iKj = iKj;
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
		 var frm = top.$("#" + tmplData.tmplId).find("#frm");
		 $(frm).attr("action", params.action);
		 for(var o in params.params) {
			 var p = params.params[o];
			 $(frm).append("<input type='hidden' name='" + o + "' value='" + p + "'/>");
		 }
		 if (tmplData.init != null) {
			 tmplData.init(cache);
		 }
	 
		 
		 
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