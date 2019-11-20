(function(win, undefined) {
	var $ = win.jQuery, is;

	if (typeof QNR === 'undefined' || !$.isPlainObject(QNR)) {
		QNR = {};
	}

	if (typeof QNR.btn === 'undefined' || !$.isPlainObject(QNR.btn)) {
		QNR.btn = {};
	}
	
	var updateStatus = function(){
		var arId = $("#submitTip").attr("arId");
		var arOper = $("#submitTip").attr("arOper");
		var index = layer.load();
		$.ajax({
			url : "/blog/article/manage/"+arOper,
			type : "post",
			data : {"id":arId},
			dataType : "json",
			success:function(data){
				layer.close(index);
				if (1 == data.ret) {
					closeWindow();
					successTips(data.message);
					if(arOper == "offline"){
						$("div[operationId='"+arId+"']").empty();
						$("div[operationId='"+arId+"']").html('<a href="javascript:void(0);" class="colblue transition a_release operation" onclick="operations('+arId+',\'send\');">发布</a><a href="/blog/article/toEdit?id='+arId+'" class="icon a_edit"></a><a href="javascript:void(0);" class="icon a_delete operation" onclick="operations('+arId+',\'del\');"></a>');
					} else if(arOper == "send"){
						$("div[operationId='"+arId+"']").empty();
						$("div[operationId='"+arId+"']").html('<a href="javascript:void(0);" class="icon a_top operation" onclick="operations('+arId+',\'top\');"></a><a href="javascript:void(0);" class="icon a_offline operation" onclick="operations('+arId+',\'offline\');"></a>');
					} else {
						setTimeout(search(),2000);
					}
                } else {
                	closeWindow();
                	errorTips(data.errmsg);
                }
			},
			error:function(data){
				layer.close(index);
				closeWindow();
				errorTips(data.responseJSON.msg);
				//setTimeout(window.location="/logout",2000);
			}
		});
	}
	
	var search = function(){
	    var options={
	        queryURL : "/blog/article/manage/getARList",
	        listTitle:[],
	        allSelcet: false,
	        orderBy: "",
	        pageNo: 1,
	        tempId : "pageListTemplate",
	        totalHeaderId : "statisticsTemplate",
	        statistics : true
	    };
	    var param = $("#query_form").serialize();
	    options.queryURL = options.queryURL + "?" + param;
	    QNR.TableList.init(options);
	}	
	
	var closeWindow = function(){
		$("#tipWindow").attr("class","dn");
	}
	
	var pageInit = function() {
		search();
		// 提示窗确定按钮触发事件
		$("#submitTip").click(function(){
			updateStatus();
			return false;
		});
		// 关闭弹窗
		$(".closeTip").click(function(){
			closeWindow();
		});
		
		// 头部状态栏筛选
		$(".a_status").click(function(){
			$(".a_status").attr("class","colgray04 radius2 a_status");
			$(this).attr("class","colgray04 radius2 scrtab_in a_status");
			var ast = $(this).attr("ast");
			$("#headerSt").attr("value",ast);
			search();
		});
	};
	$(pageInit);
})(window);