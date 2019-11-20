(function(win, undefined) {
    var $ = win.jQuery, is;

    $("#lableSet").addClass("menuli_in");
    $(".menu_home").removeClass("menu_home_in");
    function commonTimeout(){
        setTimeout(function() {
            location.href = "/blog/lable/lableList";
        }, 1000);
    }

    $("a[op=tjbq]").click(function(){
        $('#updatelabel').removeClass("dn");
        $('#labelDesc').val("");
    });
    
    $("#newCreate").click(function(){
        $('#addlabel').removeClass("dn");
        $('#desc').val("");
        $('#name').val("");
    });
    
    $(".cancel").click(function(){
    	$('#addlabel').addClass("dn");
    })

    $("a[op=qx]").click(function(){

        $('#updatelabel').addClass("dn");
    });
    $("a[op=headQx]").click(function(){

        $('#updatelabel').addClass("dn");
    });

    var canSub = true;
     
    $("#createLabel").click(function(){

        if (!canSub) {
            return false;
        }
        canSub = false;

        var name=$("#name").val();
        if(isEmpty(name)){
            errorTips("栏目名称不可为空");
            canSub = true;
            return false;
        }else if(name.length>5){
            errorTips("栏目名称不可超过5个字符");
            canSub = true;
            return false;
        }

        var scc=$("#desc").val();
        if(isEmpty(scc)){
            errorTips("栏目描述不可为空");
            canSub = true;
            return false;
        }else if(scc.length>100){
            errorTips("栏目描述不可超过100个字符");
            canSub = true;
            return false;
        }

        var frm = $("#addFrm");
        var opts = {};
        opts.url= frm.attr("action");
        opts.success = function(data) {
            if (data.ret == 1) {
                successTips("创建栏目成功");
                commonTimeout();
            } else {
                if (data.errmsg == "") {
                    errorTips("操作失败");
                } else {
                    errorTips(data.errmsg);
                }
                commonTimeout();
                canSub =true;
            }
        }
        _jsonSubmit(frm, opts);
        return false;
    });

    $("a[op=xg]").click(function(){

        if (!canSub) {
            return false;
        }
        canSub = false;

        var name=$("#labelName").val();
        if(isEmpty(name)){
            errorTips("栏目名称不可为空");
            canSub = true;
            return false;
        } else if(name.length>5) {
            errorTips("栏目名称不可超过5个字符");
            canSub = true;
            return false;
        }

        var scc=$("#labelDesc").val();
        if(isEmpty(scc)){
            errorTips("栏目描述不可为空");
            canSub = true;
            return false;

        }else if(scc.length>100){
            errorTips("栏目描述不可超过100个字符");
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
                    commonTimeout();
                }
                canSub = true;
            }
        }
        _jsonSubmit(frm, opts);
        return false;
    });

    function radioControll(obj){
        var tar = obj.attr("id");
        $("label[name='radioLabel").each(function(){
            var id = $(this).attr("id");
            if(id == tar){
                $(this).attr("class","label label_check c_in");
                $(this).children("input[name]").attr("checked",true);
            } else {
                $(this).attr("class","label label_check");
                $(this).children("input[name]").attr("checked",false);
            }
        });
    }

    var search = function(){
        var options={
            queryURL : "/blog/lable/queryLableList",
            listTitle:[],
            allSelcet: false,
            orderBy: "",
            pageNo: 1,
            tempId : "lableTemplate",
            statistics : true,
            tHeadCls: "tab"
        };
        var param = $("#query_form").serialize();
        options.queryURL = options.queryURL + "?" + param;
        QNR.TableList.init(options);
    }

    $("#chaxun").click(function(){
        search();
    });

    var pageInit = function() {
        search();
        $("label[name='radioLabel']").click(function(){
            radioControll($(this));
            return false;
        });
    }
    $(pageInit);
})(window);

