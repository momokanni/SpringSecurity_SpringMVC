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
		$.ajax({
			url : "/blog/share/"+arOper,
			type : "post",
			data : {"id":arId},
			dataType : "json",
			success:function(data){
				if (1 == data.ret) {
					closeWindow();
					successTips(data.message);
					setTimeout(window.location.reload(),2000);
                } else {
                	closeWindow();
                	errorTips(data.errmsg);
                }
			}
		});
	}
	
	var search = function(){
	    var options={
	        queryURL : "/blog/share/getShareList",
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
		
		$("#share").addClass("menuli_in");
		$(".menu_home").removeClass("menu_home_in");
		
		$(".searchA").click(function(){
			search();
		});
		
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
		
		/**
		 * 	批量移除
		 */
		$("#removeBatch").click(function(){
			var shareIds = [];
			$("input[name='shareId']:checked").each(function(){
				shareIds.push($(this).val());
			});
			var count = parseInt(shareIds.length);
			if(count == 0){
				layer.msg('请勾选批量移除的文章', {
					icon : 2
				});
			} else {
				layer.confirm('确认批量移除所选文章的分享赚标签？', {
					btn : [ '确认', '取消' ]
				// 按钮
				}, function() {
					$.ajax({
						url:"/blog/share/offlineBtach",
						type:"POST",
						traditional: true,
						data:{"ids":shareIds},
						dataType:"json",
						success:function(data){
							if (1 == data.ret) {
								layer.msg('移除成功', {
									icon : 1
								});
							} else {
								layer.msg('移除失败', {
									icon : 2
								});
							}
							
							window.location.reload();
						},
						error:function(data){
							layer.msg('移除失败', {
								icon : 2
							});
						}
					});
				});
			};
		});
	};
	$(pageInit);
})(window);