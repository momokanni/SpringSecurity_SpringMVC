(function (win,undefined) {
    var $ = win.jQuery, is;

    if (typeof QNR === 'undefined' || !$.isPlainObject(QNR)) {
        QNR = {};
    }

    if (typeof QNR.btn === 'undefined' || !$.isPlainObject(QNR.btn)) {
        QNR.btn = {};
    }
    
    $("#typeDiv").find("input[type='radio']").click(function(){
    	var blogType = $("#typeDiv").find("input[type='radio']:checked").val();
    	if (blogType == "1"){
            $("input[name='enterpriseType']").attr("disabled",false);
            $("#enterpriseNameInput").attr("disabled",false);
    	} else {
    		$("input[name='enterpriseType']").attr("disabled",true);
    		$("#enterpriseNameInput").attr("disabled",true);
    	}
    });
    
    $("#save").click(function(){
    	// 用户类型
        var blogType = $(".sysBlogType:checked").val();
        // 管理员名称
        var managerName = $("#managerName").val();
        // 管理员昵称
        var nickName = $("#managerNickName").val();
        // 手机号
        var mobile = $("#sysUserMobile").val() == "" ? null : $("#sysUserMobile").val();
        // 企业类型
        var enType = $(".sysEnType:checked").val();
        // 企业名称
        var enterpriseName = $("#enterpriseNameInput").val();

        if (isEmpty(blogType)) {
            bootAlert("用户类型不能为空");
        } else if(!isEmpty(blogType) && blogType == "1" && isEmpty(enType)){
        	bootAlert("企业类型不能为空");
        } else if(!isEmpty(blogType) && blogType == "1" && isEmpty(enterpriseName)){
        	bootAlert("企业名称不能为空");
        } else if (isEmpty(managerName)) {
            bootAlert("管理员名称不能为空");
        } else if (isEmpty(nickName)) {
            bootAlert("昵称不能为空");
        } else if (isEmpty(mobile) || !isMobile(mobile)) {
            bootAlert("请正确填写手机号");
        } else {
            var url = $("#frm").prop("action");
            var param = $("#frm").serialize();
            $.post(url, param,
                function(result){
                    if (1 == result.ret) {
                        bootAlert("保存成功", function(){
                        	window.location = "/manager/blog/toBlogUnSign";
                        });
                    } else {
                        if (result.errmsg == '') {
                            bootAlert("保存失败");
                        } else {
                            bootAlert(result.errmsg);
                        }
                    }
                },"json")
        }
    });

    var pageInit = function() {
       
    };

    $(pageInit);

})(window);