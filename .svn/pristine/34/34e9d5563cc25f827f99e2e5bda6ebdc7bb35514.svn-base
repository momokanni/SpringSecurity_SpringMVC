(function(win, undefined) {
    var $ = win.jQuery, is;

    function commonTimeout(){
        setTimeout(function() {
            location.href = "/blog/blogHome";
        }, 1000);
    }
    var canSub = true;
    //发布草稿
    $("a[op=ljfbcg]").click(function(){

        if (!canSub) {
            return false;
        }
        canSub = false;

        var frm = $("#frm");
        var opts = {};
        opts.url= frm.attr("action");
        opts.success = function(data) {
            if (data.ret == 1) {
                successTips("立发布成功");
                commonTimeout();
            } else {
                b = true;
                if (data.errmsg == "") {
                    errorTips("操作失败");
                } else {
                    errorTips(data.errmsg);
                }
            }
        }
        _jsonSubmit(frm, opts);
        return false;
    });

    var search = function(){
        var options={
            queryURL : "/blog/queryArlist",
            listTitle:[],
            allSelcet: false,
            orderBy: "",
            pageNo: 1,
            tempId : "indexListTemplate",
            totalHeaderId : "statisticsTemplate",
            statistics : true
        };
        options.queryURL = options.queryURL;
        QNR.TableList.init(options);
    }

    var pageInit = function() {
        search();
    }
    $(pageInit);
})(window);
