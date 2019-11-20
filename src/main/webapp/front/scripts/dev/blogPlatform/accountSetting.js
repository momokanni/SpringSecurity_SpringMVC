(function(win, undefined) {
    var $ = win.jQuery, is;

    $("#perSet").addClass("menuli_in");
    $("#admSet").addClass("menuli_in");
    $(".menu_home").removeClass("menu_home_in");

    var canSub = true;
    $("a[op=xggzhmc]").click(function(){
        $('#blogName').attr("disabled",false);
        var name = $('#blogName').val();
        $('#blogName').val('').focus().val(name);
        $("#qdgzhmc").show();
        $("#xggzhmc").hide();
    });

    $("a[op=xggzhms]").click(function(){
        $('#description').attr("disabled",false);
        var name = $('#description').val();
        $('#description').val('').focus().val(name);
        $("#qdgzhms").show();
        $("#xggzhms").hide();
    });

    $("a[op=xgyx]").click(function(){
        $('#email').attr("disabled",false);
        var name = $('#email').val();
        $('#email').val('').focus().val(name);
        $("#qdyx").show();
        $("#xgyx").hide();
    });
    
    $("a[op=xgtsjk]").click(function(){
        $('#pushUrl').attr("disabled",false);
        var name = $('#pushUrl').val();
        $('#pushUrl').val('').focus().val(name);
        $("#qdtsjk").show();
        $("#xgtsjk").hide();
    });

    $("a[op=xgmm]").click(function(){
        $('#dialogPasswd').removeClass("dn");
    });

    $("a[op=qx]").click(function(){
        $('#dialogPasswd').addClass("dn");
    });

    function commonTimeout(){
        setTimeout(function() {
            location.href = "/blog/accountSetting";
        }, 1000);
    }
   //修改密码
    $("a[op=qrxg]").click(function(){
        if (!canSub) {
            return false;
        }
        canSub = false;
        var frm = $("#frmPwd");
        var opts = {};
        opts.url= frm.attr("action");
        opts.success = function(data) {
            if (data.ret == 1) {
                successTips("密码修改成功");
                commonTimeout();
            } else {
                if (data.errmsg == "") {
                    errorTips("操作失败");
                } else {
                    errorTips(data.errmsg);
                }
                canSub = true;
            }
        }
        _jsonSubmit(frm, opts);
        return false;
    });

    //名称
    $("a[op=qdgzhmc]").click(function(){
        $('#description').attr("disabled",false);
        $('#email').attr("disabled",false);
        if (!canSub) {
            return false;
        }
        canSub = false;
        var blogName = $("#blogName").val();
        if (isEmpty(blogName)) {
            errorTips("公众号名称不能为空");
            canSub = true;
            return false;
        }
        if (blogName.length>7) {
            errorTips("公众号名称不能大于7个字符");
            canSub = true;
            return false;
        }

        var frm = $("#frm");
        var opts = {};
        opts.url= frm.attr("action");
        opts.success = function(data) {
                if (data.ret == 1) {
                    successTips("修改成功");
                    commonTimeout();
                } else {
                    if (data.errmsg == "") {
                        errorTips("操作失败");
                    } else {
                        errorTips(data.errmsg);
                    }
                    canSub = true;
                }
            }
        _jsonSubmit(frm, opts);
        return false;
    });

    //描述
    $("a[op=qdgzhms]").click(function(){
        $('#blogName').attr("disabled",false);
        $('#email').attr("disabled",false);
        if (!canSub) {
            return false;
        }
        canSub = false;
        var description = $("#description").val();
        if (isEmpty(description)) {
            errorTips("公众号描述不能为空");
            canSub = true;
            return false;
        }
        if (description.length>50) {
            errorTips("公众号描述不能大于50个字符");
            canSub = true;
            return false;
        }

        var frm = $("#frm");
        var opts = {};
        opts.url= frm.attr("action");
        opts.success = function(data) {

            if (data.ret == 1) {
                successTips("修改成功");
                commonTimeout();

            } else {
                if (data.errmsg == "") {
                    errorTips("操作失败");
                } else {
                    errorTips(data.errmsg);
                }
                canSub = true;
            }
        }
        _jsonSubmit(frm, opts);
        return false;
    });

     //邮箱
    $("a[op=qdyx]").click(function(){

        $('#description').attr("disabled",false);
        $('#blogName').attr("disabled",false);
        if (!canSub) {
            return false;
        }
        canSub = false;
        var email = $("#email").val();
        if (isEmpty(email)) {
            errorTips("公众号邮箱不能为空");
            canSub = true;
            return false;
        }

        if (!isMail(email)) {
            errorTips("请输入正确的邮箱格式");
            canSub = true;
            return false;
        }

        var frm = $("#frm");
        var opts = {};
        opts.url= frm.attr("action");
        opts.success = function(data) {

            if (data.ret == 1) {
                successTips("修改成功");
                commonTimeout();
            } else {
                if (data.errmsg == "") {
                    errorTips("操作失败");
                } else {
                    errorTips(data.errmsg);
                }
                canSub = true;
            }
        }

        _jsonSubmit(frm, opts);
        return false;
    });
    
    
    // 推送接口
    $("a[op=qdtsjk]").click(function(){

    	$('#description').attr("disabled",false);
        $('#blogName').attr("disabled",false);
        $('#email').attr("disabled",false);
        if (!canSub) {
            return false;
        }
        canSub = false;
        var pushUrl = $("#pushUrl").val();
        if (isEmpty(pushUrl)) {
            errorTips("推送接口不能为空");
            canSub = true;
            return false;
        }

        var frm = $("#frm");
        var opts = {};
        opts.url= frm.attr("action");
        opts.success = function(data) {

            if (data.ret == 1) {
                successTips("修改成功");
                commonTimeout();
            } else {
                if (data.errmsg == "") {
                    errorTips("操作失败");
                } else {
                    errorTips(data.errmsg);
                }
                canSub = true;
            }
        }

        _jsonSubmit(frm, opts);
        return false;
    });

    var pageInit = function() {

    }
    $(pageInit);
})(window);

function findOldPwd(id){
    var pwd = $("#oldPwd").val();
    $.ajax({
        url : "/blog/findOldPwd",
        data : {
            id :id,
            pwd:pwd
        },
        async : false,
        dataType : "json",
        success : function(data) {
            if (data.ret == 1) {
            	$(".ymmcw").addClass("dn");
            }else{
            	$(".ymmcw").removeClass("dn");
            }
        }
    });
}

function yzNewPwd(){
    var newPwd=$("#newPwd").val();
    if(newPwd==""){
        errorTips("新密码不可为空");
    }else if(newPwd.length<6||newPwd.length>12){
        errorTips("新密码限制6-12位")
    }
}

function newPwdCas(){
    var newPwd=$("#newPwd").val();
    var pwdCas=$("#pwdCas").val();

    if(newPwd!=pwdCas){
        $(".mmyz").removeClass("dn");
    }else{
        $(".mmyz").addClass("dn");
    }
}
