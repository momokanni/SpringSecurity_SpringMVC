(function(win, undefined) {
	var $ = win.jQuery, is;

	var canSub = true;
	var login = function(){

		if (!canSub) {
			return false;
		}
		var user = $("#username").val();
		var pwd = $("#passwd").val();
		if (isEmpty(user)) {
			errorTips("用户名或者手机号不可为空");
			canSub = true;
			return false;
		}
		if (isEmpty(pwd)) {
			errorTips("密码不可为空");
			canSub = true;
			return false;
		}

		var frm = $("#frm");
		var opts = {};
		opts.url=$(frm).attr("action");
		opts.success = function(data) {
			location.href = data.data;
		};
		opts.error = function(data){
			errorTips(data.responseJSON.msg);
		};
		_jsonSubmit(frm, opts);
		return false;
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
		});
	};

	$(pageInit);
})(window);
