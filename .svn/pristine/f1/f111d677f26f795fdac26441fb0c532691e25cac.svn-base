(function(win, undefined) {
	var $ = win.jQuery, is;


	var iframe = $("#show_info");
	
	var run=function(){
		_timer = setInterval(function(){
			try{
				try{
					var doc=iframe.contents()[0];
				}catch(e){
					iframe.height(1000 );
					//iframe跨域获取不到内容,加滚动条
					var $iframe = $(iframe);
					if($iframe.prop("scrolling") == "no"){
						$(iframe).prop("scrolling","yes");
					}
				}
				
				try{
					var doc=iframe.contents()[0];
				}catch(e){
					//iframe跨域获取不到内容,加滚动条
					iframe.height(1000 );
					var $iframe = $(iframe);
					if($iframe.prop("scrolling") == "no"){
						$(iframe).prop("scrolling","yes");
					}
				}
				
				if(!doc||!doc.documentElement){
					return;
				}
                //IE中 document.body.scrollHeight>document.documentElement.scrollHeight;
                //所以这里面取body的scrollHeight 代替原来的doc.body.offsetheight
				var height = iframe.contents().find('body').height();
				
                /*
				if($.browser.msie){
					if($.browser.version<9){
						height=doc.body.scrollHeight;
					}else{
						doc.documentElement.scrollHeight;
					}
				}*/
				
				height = height||doc.documentElement.scrollHeight||iframe.contents().find('body').height();
				
				if(height<=500){
					height = 500;
				}
				//iframe.height(height + 200);--自动滚动
				iframe.height(height );
			}catch(e){
				
			}
		},150);
	};
	
	$("a[mId]").click(function(){
		var mId = $(this).attr("mId");
		var ptId = $(this).attr("ptId");
		
		$("li[tId]").removeClass("active");
		$("li[tId=" + ptId +"]").addClass("active");
		
		$("li[mId]").removeClass("active");
		$("li[mId]").removeClass("open");
		
		$("li[mId=" + mId + "]").addClass("active");
		$("li[mId=" + mId + "]").addClass("open");
		
		var tp = $(this).attr("tp");
		$("div[pmId]").addClass("hide");
		
		if (tp == "fd") {
			
			
			$("div[pmId=" + mId + "]").removeClass("hide");
			
			$("div[pmId=" + mId + "]").find("label[lnk]:first").trigger("click");
			
			return false;
		}
	});
	
	$("label[lnk]").click(function(){
		var lnk = $(this).attr("lnk");
		$("label[lnk]").removeClass("active");
		$(this).addClass("active");
		$("#show_info").attr("src", lnk);
	});
	
	var pageInit = function() {
		run();
		toastr.options = {
		  "closeButton": true,
		  "debug": false,
		  "positionClass": "toast-bottom-right",
		  "onclick": null,
		  "showDuration": "1000",
		  "hideDuration": "1000",
		  "timeOut": "5000",
		  "extendedTimeOut": "1000",
		  "showEasing": "swing",
		  "hideEasing": "linear",
		  "showMethod": "fadeIn",
		  "hideMethod": "fadeOut"
		}
	};

	$(pageInit);
	
	
	
})(window);


//$(document).ready(function()
//{
//    $('#clickmewow').click(function()
//    {
//        $('#radio1003').attr('checked', 'checked');
//    });
//})
            
            
            
			
			
			
			