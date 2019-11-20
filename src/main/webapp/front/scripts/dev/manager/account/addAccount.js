(function(win, undefined) {
    var $ = win.jQuery, is;

    var canSub = true;
    $("a[op=save]").click(function(){

        if (!canSub) {
            return false;
        }

        canSub = false;

        var name = $("#name").val();
        if (isEmpty(name)) {
            bootAlert("姓名不能为空");
            canSub = true;
            return false;
        }

        var mobile = $("#mobile").val();
        if (isEmpty(mobile)) {
            bootAlert("手机号不能为空");
            canSub = true;
            return false;
        }

        var loginName = $("#loginName").val();
        if (isEmpty(loginName)) {
            bootAlert("登陆账号不能为空");
            canSub = true;
            return false;
        }

        var roleId = $("[name=roleId]:checked").val();

        if(roleId == null){
            bootAlert("角色不能为空");
            canSub = true;
            return false;
        }


        var frm = $("#frm");
        var opts = {};
        opts.url= frm.attr("action");
        opts.success = function(data) {

            if (update) {
                if (data.ret == 1) {
                    bootAlert("修改成功", function(){
                        location.href = "/manager/account/accountList";
                    });

                } else {
                    bootAlert(data.errmsg);
                }
            } else {
                if (data.ret == 1) {
                    bootAlert("添加成功", function(){
                        location.href = "/manager/account/accountList";
                    });
                } else {
                    if (data.errmsg == "") {
                        bootAlert("操作失败");

                    } else {
                        bootAlert(data.errmsg);

                    }
                    canSub=true;
                }
            }

        };
        _jsonSubmit(frm, opts);
        return false;
    });
    var pageInit = function() {

    };

    $(pageInit);
})(window);
