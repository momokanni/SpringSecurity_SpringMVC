(function(win, undefined) {
    var $ = win.jQuery, is;
    
    if (typeof QNR === 'undefined' || !$.isPlainObject(QNR)) {
        QNR = {};
    }
    
    if (typeof QNR.btn === 'undefined' || !$.isPlainObject(QNR.btn)) {
        QNR.btn = {};
    }
    QNR.btn.addBtn = {
        isClick: false,
        isSubmit: false
    };
    QNR.btn.addnextBtn = {
        isClick: false,
        isSubmit: false
    };    
    
    var pageInit = function() {
    	$("INPUT[rtype='true']").click(function(){
    		var id = $(this).attr("id");
    		var c = $(this).is(':checked');
    		$("INPUT[id^='" + id  + "_']").each(function(){
    			$(this).attr("checked", c);
    		});
    	});
    	$("#prev").click(function() {
    		location.href="/manager/getSysUserById.action?id=" + $("#uid").val();
    		return false;
    	});
    	$("#sysUserList").click(function(){
    		location.href="/manager/sysUserList.jsp";
    		return false;
    	});
    	$("#save").click(function() {
    		var frm = $("#frm");
    		var opts = {};
    		opts.url=$(frm).attr("action");
    		opts.success = function(data) {
    			var title = "权限管理";
    			if (data.ret == 1) {
					msg = "权限编辑成功";
				} else {
					msg = data.errmsg;
				}
    			 showNoticeDlg(title, msg);
    		};
    		_jsonSubmit(frm, opts);
    		return false;
    	});
    };

    
 
    $(pageInit);
})(window)
