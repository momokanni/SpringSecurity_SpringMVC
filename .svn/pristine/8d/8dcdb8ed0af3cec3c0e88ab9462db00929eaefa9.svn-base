(function(win,undefined){
    var $ = win.jQuery;

    var save = true;
    $("a[op='save']").click(function(){
        if (!save) {
            return false;
        }
        save = false;

        var oldPwd = $("#sysUserPwd").val();
        var newPwd = $("#sysUserNewPwd").val();

        if (isEmpty(oldPwd)) {
            bootAlert("请输入原密码");
        } else if (isEmpty(newPwd)) {
            bootAlert("请输入新密码");
        } else {
            var url = $("#frm").prop("action");
            $.post(url, $("#frm").serialize(), function(result) {
                if (1 == result.ret) {
                    bootAlert("密码修改成功");
                } else {
                    if (isEmpty(result.errmsg)) {
                        bootAlert("密码修改失败");
                    } else {
                        bootAlert(result.errmsg);
                    }
                }
                save = true;
            }, "json")
        }

    });
})(window);