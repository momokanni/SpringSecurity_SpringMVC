(function (win,undefined) {
    var $ = win.jQuery, is;

    if (typeof QNR === 'undefined' || !$.isPlainObject(QNR)) {
        QNR = {};
    }

    if (typeof QNR.btn === 'undefined' || !$.isPlainObject(QNR.btn)) {
        QNR.btn = {};
    }

    $("#addSysRole").click(function(){
        var divType = "addSysRole";
        var tmplData = QNR.tmpl[divType];

        if (tmplData == null) {
            return false;
        }

        var frm = top.$("#" + tmplData.tmplId).find("#frm");

        var html = tmplData.tmpl(sysDepartment);
        var w = 800;
        dlg = new Dlg({width: w});
        dlg.setHeader("<h2 class='title'>" + tmplData.header + "</h2>");
        dlg.setBody(html);
        dlg.setBtns(tmplData.btns);
        dlg.show();
    });

    var pageInit = function() {
        $("#sysRoleDepartment").selectpicker({width : '286px'});
    };

    $(pageInit);

})(window);