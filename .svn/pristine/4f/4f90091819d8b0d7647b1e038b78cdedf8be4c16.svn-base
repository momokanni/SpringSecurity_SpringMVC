(function(win, undefined) {
	var $ = win.jQuery, is;

	if (typeof QNR === 'undefined' || !$.isPlainObject(QNR)) {
		QNR = {};
	}

	if (typeof QNR.btn === 'undefined' || !$.isPlainObject(QNR.btn)) {
		QNR.btn = {};
	}
	
	var login = function() {
		var user = $("#username").val();
		var pwd = $("#passwd").val();
		if (isEmpty(user)) {
			$(".alert").find("span").html("用户名不能为空");
			$(".alert").css("display","block");
			return;
		}
		if (isEmpty(pwd)) {
			$(".alert").find("span").html("密码不能为空");
			$(".alert").css("display","block");
			return;
		}
		
		var frm = $(".login-form");
		var opts = {};
		opts.url=$(frm).attr("action");
		opts.success = function(data) {
			if(data.code != 200){
				$(".alert").find("span").html("用户名或密码错误");
				$(".alert").css("display","block");
				return;
			} else {
				location.href = "/manager/newHome";
			}
		};
		opts.error = function(data){
			var data = data.responseJSON;
			console.log(data);
			$(".alert").find("span").html(data.msg);
			$(".alert").css("display","block");
		}
		_jsonSubmit(frm, opts);
	};
	
	
	var pageInit = function() {
		$(".content").keypress(function(ev){
			if (ev.keyCode == 13) {
				if(!isEmpty($('#username').val()) && !isEmpty($('#passwd').val()))
				login();
			}
			
		});
		$("#lgnBtn").click(function(){
			login();
			return false;
		});
	};

	$(pageInit);
})(window);
