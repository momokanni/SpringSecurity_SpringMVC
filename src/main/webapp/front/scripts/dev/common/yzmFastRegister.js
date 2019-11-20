var YZM1 = function(cfg) {
	cfg = cfg || {};
    this.defaultCfg = {
    		getSmsObj : $("#getSms1"),
    		cTimer : $("#cTimer1"),
    		timer : $("#timer1"),
    		scode : $("#scode1"),
    		mobile : $("#fastMobile"),
    		rt : 0,
    		ct : 0
    		
    };
    $.extend( this, this.defaultCfg, cfg );
    this._init();
};

YZM1.prototype = {
	ci : null,
	reset : function () {
		if (this.ci != null) {
			clearInterval(this.ci);
		}
		this.cTimer.css("display", "none");
		this.getSmsObj.css("display", "");
	},
	_init: function() {
		var getSmsObj = this.getSmsObj;
		var cTimer = this.cTimer;
		var timer = this.timer;
		var scode = this.scode;
		var mobile = this.mobile;
		var obj = this;
		var canSend = true;
		$(getSmsObj).click(function(){
			if (!canSend) {
				return false;
			}
			canSend = false;
			if (!isMobile(mobile.val())) {
				if (obj.errMobile != null) {
					obj.errMobile();
				} else {
					openL("获取验证码","错误的手机号码");
				}
				canSend = true;
				return false;
			}
			if(obj.clearCode != null){
				obj.clearCode();
			}
			var h = $(this).html();
			var hs = [];
			var d = new Date();
			hs.push("<div id='smsImgDv'>");
	        hs.push("<input maxlength='10' type='text' name='smsvf'  id='smsvf'  size='18' style='width:90px;font-family:微软雅黑;float:left;border:1px solid;height:28px;line-height:28px;padding:1px' />");
	        hs.push("<img style='float: left;cursor: pointer;width:126px;border:0;height:32px;margin-left:5px'   title='验证码' id='imgverCode2' src='/smsVerfyCode?a=", d.getTime() ,"'  />");
	        hs.push("</div>");
			openL2("输入图片验证码",hs.join(""), 
				function(){
					canSend = true;
				},
				function(){
				canSend = true;
				$(getSmsObj).html("发送中...");
				$.ajax({
					url: '/getSmsCode',
					data : {
						mobile : $.trim(mobile.val()),
						rt : obj.rt,
						ct : obj.ct,
						smsvf : $("#smsvf").val()
					},
					type: 'get',
					dataType: 'json',
					success: function(d){
						$(getSmsObj).html(h);
						canSend = true;
						if(d.ret == 1){
							getSmsObj.css("display", "none");
							cTimer.css("display", "");
							timer.html("60");
							ci = setInterval(function(){
								var ti = parseInt(timer.html(), 10);
								ti--;
								if (ti <= 0) {
									clearInterval(ci);
									cTimer.css("display", "none");
									getSmsObj.css("display", "");
								}
								timer.html(ti);
								
							}, 1000);
							if (obj.sendSucc != null) {
								obj.sendSucc(); 
							}
						} else {
							switch(d.errcode) {
							case 0:
								if (obj.errMobile != null) {
									obj.errMobile();
								} else {
									openL("获取验证码","错误的手机号码");
								}
								break;
							case 1:
								if (obj.toManyTimes != null) {
									obj.toManyTimes();
								} else {
									openL("获取验证码","您的请求过于频繁，请在一分种后尝试");
								}
								break;
							case 2:
								if (obj.errGenCode != null) {
									obj.errGenCode();
								} else {
									openL("获取验证码","验证码生成失败");
								}
								break;
							case 5:
								if (obj.emptyMobile != null) {
									obj.emptyMobile();
								} else {
									openL("获取验证码","该手机号码未注册");
								}
								break;
							case 6:
								if (obj.regMobile != null) {
									obj.regMobile();
								} else {
									openL("获取验证码","该手机号码已注册");
									obj.reset();
								}
								break;
							case 7:
								if (obj.emptyImg != null) {
									obj.emptyImg();
								} else {
									openL("获取验证码","图形验证码为空");
									obj.reset();
								}
								break;
							case 8:
								if (obj.errImg != null) {
									obj.errImg();
								} else {
									openL("获取验证码","图形验证码不正确");
									obj.reset();
								}
								break;
							case 9:
								if (obj.errImg != null) {
									obj.errImg();
								} else {
									openL("获取验证码","图形验证码发送失败");
									obj.reset();
								}
								break;
							}
						}
					}
				});
			});
			
			$("#smsImgDv").delegate("img", "click", function(){
				var dd = new Date();
				$(this).attr("src", "/smsVerfyCode?a=" + dd.getTime());
			});
			
			return false;
		});
	}
};