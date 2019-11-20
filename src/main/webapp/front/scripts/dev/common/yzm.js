var YZM = function(cfg) {
	cfg = cfg || {};
    this.defaultCfg = {
    		getSmsObj : $("#getSms"),
    		cTimer : $("#cTimer"),
    		timer : $("#timer"),
    		scode : $("#scode"),
    		mobile : $("#mobile"),
    		getSmsVo : $("#getSmsVo"),
    		getSmsCtr : $("#getSmsCtr"),
    		jdtiao :$("#jdtiao"),
    		jdt : $("#jdt"),
    		rt : 0,
    		ct : 0,
    		tu : 1,
    		fft: 0,
    		entt: 0,
    		smsSendLabel : 1,
    		voSendLabel : 1,
    		smsLabel : "",
    		voLabel : "",
    		canSend : true
    		
    };
    $.extend( this, this.defaultCfg, cfg );
    this._init();

};

YZM.prototype = {
	ci : null,
	reset : function () {
		if (this.ci != null) {
			clearInterval(this.ci);
		}
		this.cTimer.css("display", "none");
		this.jdtiao.css("display","none");
		this.getSmsObj.css("display", "");
		this.canSend = true;
	},
	_handle: function(sType) {
		var getSmsObj = this.getSmsObj;
		var getSmsVo = this.getSmsVo;
		var getSmsCtr = this.getSmsCtr;
		var cTimer = this.cTimer;
		var timer = this.timer;
		var scode = this.scode;
		var mobile = this.mobile;
		var jdtiao = this.jdtiao;
		var jdt = this.jdt;
		var obj = this;		
		var h = $(getSmsObj).html();
		var h2 = "";
		if (getSmsVo.length > 0) {
			h2 = $(getSmsVo).html();
		}
		if (sType == "sms") {
			if (this.smsSendLabel == 1) {
				if (this.smsLabel == "") {
					$(getSmsObj).html("发送中...");
				} else {
					$(getSmsObj).html(this.smsLabel);
				}
			}
			
		} else if (sType == "vo"){
			if (this.voSendLabel == 1) {
				if (this.voLabel == "") {
					$(getSmsVo).html("拨打中...");
				} else {
					$(getSmsVo).html(this.voLabel);
				}
			}
		}
		
		if (obj.showInfo != null) {
			obj.showInfo();
		} 
		var _ct = obj.ct;
		if($(getSmsObj).attr('ctt') != null && $(getSmsObj).attr('ctt') != ''){
			_ct = $(getSmsObj).attr('ctt');
		}
		var _fft = obj.fft;
		if($(getSmsObj).attr('fft') != null && $(getSmsObj).attr('fft') != ''){
			_fft = $(getSmsObj).attr('fft');
		}
		var _entt = obj.entt;
		if($(getSmsObj).attr('entt') != null && $(getSmsObj).attr('entt') != ''){
			_entt = $(getSmsObj).attr('entt');
		}
		
		$.ajax({
			url: '/sms/getSmsCode',
			data : {
				mobile : $.trim(mobile.val()),
				rt : obj.rt,
				ct : _ct,
				tu : obj.tu,
				fft: _fft,
				entt: _entt,
				st : sType,
				smsvf : $("#smsvf").val()
			},
			type: 'get',
			dataType: 'json',
			success: function(d){
				if (obj.smsSendLabel == 1) {
					$(getSmsObj).html(h);
				}
				if (obj.voSendLabel == 1) {
					$(getSmsVo).html(h2);
				}
				
				obj.canSend = true;
				if(d.ret == 1){
					getSmsVo.css("display", "none");
					getSmsObj.css("display", "none");
					getSmsCtr.css("display", "none");
					cTimer.show();
					jdtiao.show();
					timer.html("60");
					jdt.width("100%");
					ci = setInterval(function(){
						var ti = parseInt(timer.html(), 10);
						ti--;
						var tl = jdt.width();
						if (ti <= 0) {
							clearInterval(ci);
							cTimer.hide();
							jdtiao.hide();
							getSmsObj.css("display", "");
							getSmsVo.css("display", "");
							getSmsCtr.css("display","");
						}
						timer.html(ti);
						jdt.width(""+ti*1.67+"%");
					}, 1000);
					if (obj.sendSucc != null) {
						obj.sendSucc();
					}
					if(d.isHasFft == 1){
						$("#fftShowPro").show();
						$("#fftFgtPro").show();
						$("#fftProPassword").val("");
					}else{
						$("#fftShowPro").hide();
						$("#fftFgtPro").hide();
						$("#fftProPassword").val("");
					}
					
					if (d.vo) {
						if (obj.voFunc != null) {
							obj.voFunc();
						}
					}
				} else {
					switch(d.errcode) {
					case 0:
						if (obj.errMobile != null) {
							obj.errMobile();
						} else {
							mobileNotice("错误的手机号码");
						}
						break;
					case 1:
						if (obj.toManyTimes != null) {
							obj.toManyTimes();
						} else {
							mobileNotice("您的请求过于频繁，请在一分种后尝试");
						}
						break;
					case 2:
						if (obj.errGenCode != null) {
							obj.errGenCode();
						} else {
							mobileNotice("验证码生成失败");
						}
						break;
					case 5:
						if (obj.emptyMobile != null) {
							obj.emptyMobile();
						} else {
							mobileNotice("该手机号码未注册");
						}
						break;
					case 6:
						if (obj.regMobile != null) {
							obj.regMobile();
						} else {
							mobileNotice("该手机号码已注册");
							obj.reset();
						}
						break;
					case 7:
						if (obj.emptyImg != null) {
							obj.emptyImg();
						} else {
							mobileNotice("图形验证码为空");
							obj.reset();
						}
						break;
					case 8:
						if (obj.errImg != null) {
							obj.errImg();
						} else {
							mobileNotice("图形验证码不正确");
							obj.reset();
						}
						break;
					case 9:
						if (obj.errImg != null) {
							obj.errImg();
						} else {
							mobileNotice("图形验证码发送失败");
							obj.reset();
						}
						break;
					} 
				}
			}
		});
	},
	_init: function() {
		var getSmsObj = this.getSmsObj;
		var getSmsVo = this.getSmsVo;
		var cTimer = this.cTimer;
		var timer = this.timer;
		var scode = this.scode;
		var mobile = this.mobile;
		var obj = this;		
		var sendCode = function(st) {
			if (!obj.canSend) {
				return;
			}
			obj.canSend = false;
			if (!isMobile(mobile.val())) {
				if (obj.errMobile != null) {
					obj.errMobile();
				} else {
					mobileNotice("错误的手机号码");
				}
				obj.canSend = true;
				return;
			}
			if(obj.clearCode != null){
				obj.clearCode();
			}
			var hs = [];
			var d = new Date();
			hs.push("<div id='smsImgDv'>");
	        hs.push("<input maxlength='10' type='text' name='smsvf'  id='smsvf'  size='18' style='width:90px;font-family:微软雅黑;float:left;border:1px solid;height:28px;line-height:28px;padding:1px' />");
	        hs.push("<img style='float: left;cursor: pointer;width:126px;border:0;height:32px;margin-left:5px'   title='验证码' id='imgverCode2' src='/smsVerfyCode?a=", d.getTime() ,"'  />");
	        hs.push("</div>");
	        if (obj.tu == 1) {
	        	openL2("输入图片验证码",hs.join(""), 
    				function(){
    					obj.canSend = true;
    				},
    				function(){
    					obj._handle(st);
    				}
	    		);
	        } else {
	        	obj._handle(st);
	        }
			$("#smsImgDv").delegate("img", "click", function(){
				var dd = new Date();
				$(this).attr("src", "/dt/smsVerfyCode?a=" + dd.getTime());
			});
		}
		$(getSmsObj).click(function(){
			if (!obj.canSend) {
				return false;
			}
			sendCode("sms");
			return false;
		});
		
		$(getSmsVo).click(function(){
			if (!obj.canSend) {
				return false;
			}
			sendCode("vo");
			return false;
		});
	}
};