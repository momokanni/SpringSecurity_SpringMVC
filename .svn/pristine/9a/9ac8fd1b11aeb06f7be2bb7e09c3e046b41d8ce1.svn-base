function renderSubmenu(mainmenuId, submenuId){
	$('.item').hide();//左侧导航全部隐藏
	$('#submenu_' + mainmenuId).show();
	$('.submenu >li >a').removeClass('on');
	$('.item h3 a').removeClass('on');
	$('#submenu_' + mainmenuId).addClass('on');
    $('#submenu_' + mainmenuId + ' li:eq(0) > a').addClass('on');
    if (!$('#submenu_' + mainmenuId + ' li:eq(0) > a').hasClass('on')) {
        $('#submenu_' + mainmenuId + ' h3:eq(0) > a').addClass('on');
    }
	return false;
};
//高亮选中的顶部导航
function renderMainMenu(obj){
	$('.mainmenu').removeClass('on');
	obj.addClass('on');
};

function removeCookie(name){
	if(document.cookie && document.cookie != ''){
		var cookies = document.cookie.split(';');
	    for (var i = 0; i < cookies.length; i++) {
	        var cookie = jQuery.trim(cookies[i]);
	        var vas = cookie.split('=');
	        if (vas[0] != name){
	        	continue;
	        }
	        document.cookie = name + '=;domain=' + domain + ';expire=-1;path=/';
	    }
	}
};

var _trigger = function(menu){
	//高亮选中的顶部导航
	renderMainMenu($(menu));
	//子菜单   mainmenu_30
	var mainmenuId = $(menu).attr('id').split('_')[1];
	var submenuId = $('#submenu_' + mainmenuId + ' li  a').first();
	submenuId = submenuId.length?submenuId:$('#submenu_' + mainmenuId).find("h3 a").first();
	renderSubmenu(mainmenuId, submenuId);
	removeCookie('_QP');
	$('#show_info').attr('src',submenuId.attr('href'));
    return false;
};

$(function(){
	
	var chanageHref=function(submenuId){
		removeCookie('_QP');
		$('#show_info').attr('src',submenuId.attr('href'));
	};
	
	var page={
		init: function(){
			this.initMenus();
			this.initFrameHeight();
		},
		
		initMenus: function(){
		    //顶部导航
			$('.mainmenu').click(function(){
			    //高亮选中的顶部导航
				renderMainMenu($(this));
				//子菜单   mainmenu_30
				var mainmenuId = $(this).attr('id').split('_')[1];
				var submenuId = $('#submenu_' + mainmenuId + ' li  a').first();
				submenuId = submenuId.length?submenuId:$('#submenu_' + mainmenuId).find("h3 a").first();
				renderSubmenu(mainmenuId, submenuId);
				chanageHref(submenuId);
                
                $(page).trigger('init-finished');
                return false;
			});
			//左侧导航
//			$('.item').each(function(){
//				if(!$(this).find('li').length)
//				{
//					$(this).find("h3 a").bind('click',function(){
//						$('.item h3 >a').removeClass('on');
//						browerDivDispaly(this);//判断充值提现，页面下边显示的提示框
//						$(this).addClass('on');
//                        chanageHref($(this));
//						return false;
//					})
//				}else{
//					$(this).find("li a").each(function(){
//						$(this).bind("click",function(){
//                            $('.item h3 >a').removeClass('on');
//							$('.submenu li >a').removeClass('on');
//							$(this).addClass('on');
//							chanageHref($(this));
//							return false;	
//						})
//					})
//				}
//			});
			$('.item').each(function(){
				if( $(this).find('li').length)
				 {
					$(this).find("li a").each(function(){
						$(this).bind("click",function(){
                            $('.item h3 >a').removeClass('on');
							$('.submenu li >a').removeClass('on');
							$(this).addClass('on');
							chanageHref($(this));
							return false;	
						})
					})
				}
			});
			
			$('.item h3 a ').each(function(){
				$(this).bind('click',function(){
					$('.item h3 >a').removeClass('on');
					$('.submenu li >a').removeClass('on');
					browerDivDispaly(this);//判断充值提现，页面下边显示的提示框					
					if ( $(this).attr("t") != "parentMenuHref") {
						$(this).addClass('on');
	                    chanageHref($(this));
					}
					return false;
				})
			});
            
            $(page).bind('init-finished', function(evt) {
                $('.item').delegate('h3 > a', 'click', function(evt) {
                    var self = this;
                    $('.item h3 > a').removeClass('on');
                    $('.submenu li > a').removeClass('on');
                    $(self).addClass('on');
                    chanageHref($(self));
                    
                    return false;
                });
            });
            
		},
		
		initFrameHeight: function(){
			var iframe=$("#show_info").removeAttr("id").removeAttr("height");
			
			chanageHref=function(submenuId){
				stop();
				removeCookie('_QP');
				iframe.attr('src',submenuId.attr('href'));
				iframe.height(500);
				run();
			};
			
			var _timer=false;
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
						
						if($.browser.msie){
							if($.browser.version<9){
								height=doc.body.scrollHeight;
							}else{
								doc.documentElement.scrollHeight;
							}
						}
						
						height=height||doc.documentElement.scrollHeight||iframe.contents().find('body').height();
						
						if(height<=500){
							height = 500;
						}
						//iframe.height(height + 200);--自动滚动
						iframe.height(height );
					}catch(e){
						var k=$.cookie("QN52");
						if(k){
							var height=parseInt(k,10);
							if(isNaN(height)||height<=500){
								height=500;
							}
							iframe.height(height);
						}else{
							iframe.height(500);
						}
					}
				},150);
			}
			
			var stop=function(){
				clearInterval(_timer);
			}
			
			run();
			
			var isFullscreen=false;
			QNR.event.bind("fullscreen",function(){
				isFullscreen=!isFullscreen;
				if(isFullscreen){
					iframe.removeAttr("style");
					iframe.addClass("fullscreen");
					
					$(document.body).css("overflow","hidden");
					
					stop();
				}else{
					iframe.removeClass("fullscreen");
					
					$(document.body).css("overflow","auto");
					
					run();
				}
			});
		}
	};
	
	 var st = $(window).scrollTop();
	 $(window).scroll(function() {
         var scroll = $(this).scrollTop();
         var delta = scroll - st;
         st = scroll;
         if ($(".pptc").length > 0) {
        	 var t = $(".pptc").offset().top;
             t = t + delta;
             $(".pptc").offset({top: t});
         }
     });
	 
	 var clearBox = function() {
		if (inprocess || nstatus == 3 || nstatus == 4) {
			return;
		}
		nstatus = 3;
		inprocess = true;
		$(".pptc").css("display", "");
		var h = 77;
		var t = $(".pptc").offset().top;
		var step = h / 10;
		var s = 0;
		var il2 = setInterval(function(){
				var t = $(".pptc").offset().top;
				$(".pptc").offset({top : t + step})
				s++;
				if (s == 12) {
					clearInterval(il2);
					$("#spn").html("");
					inprocess = false;
					nstatus = 4;
				}
	    }, 100);
		
		
		$.ajax({
    		url: "/notice.do?method=clearNotice",
    		type: "get",
    		dataType: "json",
    		success: function(data){
    				
    		}
    	});
	 };
	 
	 
	 var inprocess = false;
	 var nstatus = 0;
	 var noticeBox = function(total) {
		if (inprocess || nstatus ==1 || nstatus == 2) {
			return;
		}
		inprocess = true;
		nstatus = 1;
		var html = [];
		html.push("<div class='pptc wid200'>");
		html.push("<div class='pptctit'><span><i class='ic01'></i>订单提醒</span><a href='javascript:void(0)'></a></div>");
		html.push("<div class='pptcbox'><a href='javascript:void(0)'>新订单消息（", total , "）</a></div>");
		html.push("<div class='pptcft'><span></span></div>");
		html.push("</div>");
		
		$("#spn").html(html.join(""));
		$(".pptc > .pptctit").find("a").click(function(){
			clearBox();
			return false; 
		});
		 
		$(".pptc > .pptcbox").find("a").click(function(){
			clearBox();
			$("iframe[name=show_info]").attr("src", "/" + folder + "/order/orderlist.jsp");
			return false; 
		});
		 
		var h = 77;
		var wh = window.innerHeight;
		var t = st + wh;
		$(".pptc").offset({top: t});
		var step = h / 10;
		var s = 0;
		var il = setInterval(function(){
				var t = $(".pptc").offset().top;
				$(".pptc").offset({top : t - step});
				s++;
				if (s == 10) {
					clearInterval(il);
					inprocess = false;
					nstatus = 2;
				}
	    }, 100);
	 };
	$($.proxy(page.init,page));
	
	//充值提示洌览器兼容问题提示框
	var browerDivDispaly = function(id){
		if($(id).attr("href") == "/manager/recharge"){
			$("#browerdiv").removeClass("dn");
		}else{
			$("#browerdiv").addClass("dn");
		}
	};
	
	var changeUrl = function(href){
		$('.item h3 >a').each(function(){
			$(this).removeClass("on");
			if($(this).attr("href") == href){
				var self = this;
                $('.submenu li > a').removeClass('on');
                $(self).addClass('on');
                chanageHref($(self));
			}
		});
	};
	
	$('#bindCardDiv a').click(function(){
		$("#bindCardDiv").addClass('dn');
		$("#divly").addClass('dn');
		changeUrl($(this).attr('h'));
	});
	
	$('#withdrawDiv .ftbl06').click(function(){
		$("#withdrawDiv").addClass('dn');
		$("#divly").addClass('dn');
		changeUrl($(this).attr('h'));
	});
	
	$("#payconfirm .ftbl04").click(function(){
		$("#payconfirm").addClass('dn');
		$("#divly").addClass('dn');
		changeUrl($(this).attr('h'));
	});
	
	$("#payconfirm .abtn03").click(function(){
		$("#payconfirm").addClass('dn');
		$("#divly").addClass('dn');
	});
	
	var payAgain = function(){
		$("#payconfirm").addClass('dn');
		$("#divly").addClass('dn');
	};
	
	$('#payconfirm .clodiv').click(function(){
		payAgain();
	});
	
	$('#browerdiv .clodiv').click(function(){
		$('#browerdiv').addClass('dn');
	});
	
	$('.clodiv').click(function(){
		$(this).parent().addClass('dn');
		$("#divly").addClass('dn');
	});
	
	var canApplyTq = true;
	$('#applytqrepay a[t="apply"]').click(function(){
		if (!canApplyTq) {
			return false;
		}
		canApplyTq = false;
		$.ajax({
    		url: "/manager/tqrepay/apply",
    		data : {
				id : $('#applytqrepay').attr('l')
			},
			type: 'post',
    		dataType: "json",
    		success: function(data){
    			$('#applytqrepay .clodiv').trigger('click');
    			var id = $('#applytqrepay').attr('l');
    			$('#applytqrepay').attr('l','');
    			$('#applytqrepayok').attr('l',id);
    			if(data.ret){
    				 showParentLay($('#applytqrepayok'),$('#divly'));
    			}else{
    				alert(data.errmsg);
    			}
    			canApplyTq = true;
    		}
    	});
		return false;
	});
	
	$('#applytqrepayok a[t="close"]').click(function(){
		var href = '/manager/applyUser/loanDtl?id=' + $('#applytqrepayok').attr('l');		
		$('#applytqrepayok').addClass('dn');
		$("#divly").addClass('dn');
		$('#applytqrepayok').attr('l','');
		$('iframe[name="show_info"]').attr('src',href);
	});
	
	var tqrepayHref = '/manager/xyc/tqrepay.jsp';
	var canCheckOk = true;
	$('#checktqrepay a[t="checkok"]').click(function(){
		if (!canCheckOk) {
			return false;
		}
		canCheckOk = false;
		$.ajax({
    		url: "/manager/tqrepay/checkok",
    		data : {
				id : $('#checktqrepay').attr('tqid'),
				remark:$('#checktqrepay #remark').val()
			},
			type: 'post',
    		dataType: "json",
    		success: function(data){
    			$('#checktqrepay .clodiv').trigger('click');
    			if(data.ret){
    				changeUrl(tqrepayHref);
    			}else{
    				alert(data.errmsg);
    			}
    			canCheckOk = true;
    		}
    	});
		return false;
	});
	
	var canRefuse = true;
	$('#checktqrepay a[t="refuse"]').click(function(){
		if (!canRefuse) {
			return false;
		}
		canRefuse = false;
		$.ajax({
    		url: "/manager/tqrepay/refuse",
    		data : {
				id : $('#checktqrepay').attr('tqid'),
				remark:$('#checktqrepay #remark').val(),
				s : 2
			},
			type: 'post',
    		dataType: "json",
    		success: function(data){
    			$('#checktqrepay .clodiv').trigger('click');
    			if(data.ret){
    				changeUrl(tqrepayHref);
    			}else{
    				alert(data.errmsg);
    			}
    			canRefuse = true;
    		}
    	});
		
		return false;
	});
	
	var canCancel = true;
	$('#canceltqrepay a[t="cancel"]').click(function(){
		if (!canCancel) {
			return false;
		}
		canCancel = false;
		$.ajax({
    		url: "/manager/tqrepay/refuse",
    		data : {
				id : $('#canceltqrepay').attr('tqid'),
				remark:$('#canceltqrepay #remark').val(),
				s : 3
			},
			type: 'post',
    		dataType: "json",
    		success: function(data){
    			$('#canceltqrepay .clodiv').trigger('click');
    			if(data.ret){
    				changeUrl(tqrepayHref);
    			}else{
    				alert(data.errmsg);
    			}
    			canCancel = true;
    		}
    	});
		return false;
	});
	
//	$("h3[t=parentMenu]").click(function(){
//		$(this).next("ul").toggle();
//	});
	$("a[t=parentMenuHref]").click(function(){		
		if ( $(this).parent().next("ul").css("display") != "none" ){	 
			$(this).parent().next("ul").hide();
			$(this).parent().find("i").removeClass("on");
		}else { 
			$(this).parent().next("ul").show();
			$(this).parent().find("i").addClass("on");
		}
	});
});
