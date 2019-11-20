(function (win,undefined) {
    var $ = win.jQuery, is;

    if (typeof QNR === 'undefined' || !$.isPlainObject(QNR)) {
        QNR = {};
    }

    if (typeof QNR.btn === 'undefined' || !$.isPlainObject(QNR.btn)) {
        QNR.btn = {};
    }

    $("#addSysUser").click(function(){
        var divType = "addSysUser";
        var tmplData = QNR.tmpl[divType];
        if (tmplData == null) {
            return false;
        }
        var data = tmplData.dfunc();
        var html = tmplData.tmpl(data);
        var w = 800;
        dlg = new Dlg({width: w});
        dlg.setHeader("<h2 class='title'>" + tmplData.header + "</h2>");
        dlg.setBody(html);
        dlg.setBtns(tmplData.btns);
        dlg.show();
        tmplData.init(data);
    });

    var pageInit = function() {
        $("#sysUserDepartment").selectpicker({width : '150px'});
        $("#sysUserDepartment").selectpicker({width : '150px'});
        $("#sysUserReportDepartment").selectpicker({width : '150px'});
        $("#sysUserReportRoleId").selectpicker({width : '150px'});
    };

    $(pageInit);

})(window);