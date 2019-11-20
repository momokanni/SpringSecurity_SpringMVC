(function(win, undefined) {
	var $ = win.jQuery, is;

	if (typeof QNR === 'undefined' || !$.isPlainObject(QNR)) {
		QNR = {};
	}

	if (typeof QNR.btn === 'undefined' || !$.isPlainObject(QNR.btn)) {
		QNR.btn = {};
	}
	
	var tar = null;
	/**
	 * 提交草稿
	 */
	var subDraft = function(){
		var contentNum = editor.txt.text().toString().length;
		$('input[name="wordCount"]').val(contentNum);
		var title = $("#titleInp").val();
		var content = editor.txt.html();
		$("#editorInp").attr("value",content);
		if(isEmpty(title)){
			errorTips("标题不能为空");
			return;
		}
		var param = $('#arForm').serialize();
		$.ajax({
			url:"/blog/article/secondSub",
			type:"post",
			data:param,
			dataType:"json",
			success:function(data){
				if (1 == data.ret) {
					successTips(data.message);
					setTimeout(location.href="/blog/article/manage/list",2000);
                 } else {
                	 errorTips(data.errmsg);
                 }
			},
			error:function(data){
				
			}
		});
	}
	
	/**
	 * 获取文章详情
	 */
	var getARDetail = function(){
		$.ajax({
			url:"/blog/article/getARDetail",
			type:"get",
			data:{"id":$("#arIdInp").val()},
			dataType:"json",
			success:function(data){
				if(data.ret == 1){
					var data = data.data;
					$("#titleInp").attr("value",data.title);
					$("#characterCount").text(parseInt(data.title.length))
					editor.txt.html(data.content);
					$("#typeSel option[value="+data.type+"]").attr("selected",true);
					$("#labelSel option[value="+data.label+"]").attr("selected",true);
					$("#arSourceSel option[value='"+data.articleSourceId+"']").attr("selected",true);
					if(data.url.length > 0){
						$(".img-responsive").attr("src",data.url);
						$("#thumbPath").attr("value",data.url);
					}
					$("#releaseTime").attr("value",data.time);
					$("#shareContentInp").attr("value",data.shareContent);
					$("#imgCountInp").attr("value",data.imgCount);
					$("#wordCountInp").attr("value",data.wordCount);
					if(data.audioPath != ""){
						$("#audioPath").attr("value",data.audioPath);
						$("#audioName").attr("value",data.audioName);
						$("#audioFileName").attr("style","display:block");
						$("#audioFileName").html(data.audioName);
					}
					var keyWords = data.otherStatus.split(",");
					//console.log(keyWords);
					for(var i = 0; i < keyWords.length; i++){
						$("#keyword"+keyWords[i]).attr("checked",true);
					}
				} else {
					errorTips(data.errmsg);
				}
			},
			error:function(data){
			}
		});
	}
	
	/**
	 * 保存并发布
	 */
	var subRelease = function(){
		var title = $("#titleInp").val();
		if(isEmpty(title)){
			errorTips("标题不能为空");
			return;
		}
		var content = editor.txt.html();
		if(isEmpty(content)){
			errorTips("内容不能为空");
			return;
		}
		var type = $('#typeSel option:selected').val();
		if(type == 0){
			errorTips("请选择文章类型");
			return;
		}
		var thumb = $("#thumbPath").val();
		if(isEmpty(thumb)){
			errorTips("请上传文章首图");
			return;
		}
		var releaseType = null;
		if(tar == null){
			releaseType = $("input[type='radio']:checked").val();
		} else {
			releaseType = $("#"+tar).children("input").val();
		}
		if(releaseType == 0){
			var time = $("#releaseTime").val();
			if(isEmpty(time)){
				errorTips("请选择发布时间");
				return;
			}
		}
		
		var contentNum = editor.txt.text().toString().length;
		$('input[name="wordCount"]').val(contentNum);
		
		$("#editorInp").attr("value",content);
		var param = $('#arForm').serialize();
		var index = layer.load();
		$.ajax({
			url:"/blog/article/subEdit",
			type:"post",
			data:param,
			dataType:"json",
			success:function(data){
				layer.close(index);
				if (1 == data.ret) {
					successTips(data.message);
					setTimeout(location.href="/blog/article/manage/list",2000);
                 } else {
                	 errorTips(data.errmsg);
                 }
			},
			error:function(data){
				layer.close(index);
			}
		});
	}
	
	$("[name=releaseType]").click(function() {
		  var v = $(this).val();
		  var f = $(this).attr("id");
		  $(".label_check").removeClass("c_in");
		  $("[for=" + f + "]").addClass("c_in");
		  
		  v = parseInt(v, 10);
		  if ( v == 1) {
		   $(".rel_date").css("display","none");
		  } else {
		   $(".rel_date").css("display","");
		  }
	});
	
	var pageInit = function() {
		getARDetail();
		$("#subDraft").click(function(){
			subDraft();
			return false;
		});
		
		$("#subAR").click(function(){
			subRelease();
			return false;
		});
	};
	$(pageInit);
})(window);