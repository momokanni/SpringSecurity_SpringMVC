(function(win, undefined) {
    var $ = win.jQuery, is;


    $("#addArticleTypeBtn").click(function() {

        var div_type = "editArticleType";
        var params = {params :
                {
                }
        };
        var tmplName = div_type;
        var initDatas = params.params;
        var tmplData = QNR.tmpl[tmplName];
        if (tmplData == null) {
            return;
        }
        var iKj = (top.location.href != location.href);
        initDatas.iKj = iKj;
        var cache = {};
        if (tmplData.data) {
            cache = tmplData.dfunc(initDatas);
            if (cache.ret == 0) {
                if (cache.errmsg == null || cache.errmsg == "") {
                    bootAlert("获取数据失败");
                } else {
                    bootAlert(cache.errmsg);
                }
                return;
            }
        }
        cache.iKj = iKj;
        var tmpl = tmplData.tmpl(cache);
        html = tmpl;
        var w = 400;
        if (tmplData.width != null) {
            w = tmplData.width;
        }
        dlg = new Dlg({width: w});
        dlg.setHeader("<h2 class='title'>" + tmplData.header + "</h2>");
        dlg.setBody(html);
        dlg.setBtns(tmplData.btns);
        dlg.show();
        var frm = top.$("#" + tmplData.tmplId).find("#frm");
        $(frm).attr("action", params.action);
        for(var o in params.params) {
            var p = params.params[o];
            $(frm).append("<input type='hidden' name='" + o + "' value='" + p + "'/>");
        }
        if (tmplData.init != null) {
            tmplData.init(cache);
        }


    });

    var pageInit = function() {

    };

    $(pageInit);
})(window);
