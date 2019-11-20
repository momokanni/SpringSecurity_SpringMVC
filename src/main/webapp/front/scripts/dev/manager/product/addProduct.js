(function(win, undefined) {
	var $ = win.jQuery, is;


    var validFormData = function () {
        var productName = $("#productName").val();
        if (isEmpty(productName)) {
            bootAlert("请输入产品名称");
            return false;
        }

        var issueId = $("#issueId").val();
        if (!isNumber(issueId)) {
            bootAlert("请选择发行方");
            return false;
        }

        var underwriterId = $("#underwriterId").val();
        if (!isNumber(underwriterId)) {
            bootAlert("请选择承销商");
            return false;
        }

        var danbaoId = $("#danbaoId").val();
        if (!isNumber(danbaoId)) {
            bootAlert("请选择担保方");
            return false;
        }

        var entrustedId = $("#entrustedId").val();
        if (!isNumber(issueId)) {
            bootAlert("请选择受托管理人");
            return false;
        }

        var raiseAmount = $("#raiseAmount").val();
        if (!isFloat(raiseAmount)) {
            bootAlert("请输入募集规模");
            return false;
        }

        var term = $("#term").val();
        if (!isNumber(term)) {
            bootAlert("请输入产品期限");
            return false;
        }

        var expectRate = $("#expectRate").val();
        if (!isFloat(expectRate)) {
            bootAlert("请输入预期收益费率");
            return false;
        }

        var baseAmount = $("#baseAmount").val();
        if (!isFloat(baseAmount)) {
            bootAlert("请输入认购基数");
            return false;
        }

        var increaseAmount = $("#increaseAmount").val();
        if (!isFloat(increaseAmount)) {
            bootAlert("请输入递增基数");
            return false;
        }

        var holdCalType = $("#holdCalType").val();
        if(holdCalType == 2){
            var enDate = $("#enDate").val();
            if (isEmpty(enDate)) {
                bootAlert("请选择截止日");
                return false;
            }
        }

        /*var dueDate = $("#dueDate").val();
        if (isEmpty(dueDate)) {
            bootAlert("请选择到期日");
            return false;
        }*/


        var trans = $("[name=trans]:checked").val();
        if(trans == 1){
            var lockTerm = $("#lockTerm").val();
            if (!isNumber(lockTerm)) {
                bootAlert("请输入锁定期");
                return false;
            }
        }

        var establishType = $("[name=establishType]:checked").val();
        if(establishType == 2){
            var h = "";
            var b = true;
            $.each($("[t=establishDay]"),function(i){

                if(!isNumber($(this).val())){
                    b = false;
                    return false;
                }

                if(i==0){
                    h = $(this).val();
                }else{

                    h = h + "," + $(this).val();
                }

            });

            if(!b){
                bootAlert("存在成立时间为空或格式不正确");
                return false;
            }

            if(isEmpty(h)){
                bootAlert("请输入成立时间");
                return false;
            }

            $("#establishDays").val(h);
        }

        var settlementType = $("#settlementType").val();

        var fixed = $("[name=fixed]:checked").val();
        if(fixed == 1){
            /*if(settlementType != 1 && settlementType != 2){
                var fixedMonth = $("#fixedMonth").val();
                if(!isNumber(fixedMonth)){
                    bootAlert("请输入固定还息月份");
                    return false;
                }
            }*/

            var fixedDay = $("#fixedDay").val();
            if(!isNumber(fixedDay)){
                bootAlert("请输入固定还息日");
                return false;
            }
        }

        var yizhiRate = $("#yizhiRate").val();
        var yizhiType = $("#yizhiType").val();
        var yueJieDay = $("#yueJieDay").val();



        var hangRate = $("#hangRate").val();
        var cxRate = $("#cxRate").val();
        var stRate = $("#stRate").val();

        var hangFeeType = $("#hangFeeType").val();
        var cxFeeType = $("#cxFeeType").val();
        var stFeeType = $("#stFeeType").val();


        var hangYueJieDay = $("#hangYueJieDay").val();
        var cxYueJieDay = $("#cxYueJieDay").val();
        var stYueJieDay = $("#stYueJieDay").val();

        if($("[name=fees]:checked").length ==1){
            var x = true;
            var y = true;
            $.each($("[name=fees]:checked"),function(i){
                var fee = $(this).val();
                if(fee == 0){
                    if (!isFloat(hangRate)) {
                        x = false;
                        return false;
                    }

                    if(hangFeeType == 3){
                        if (!isNumber(hangYueJieDay)) {
                            y = false;
                            return false;
                        }
                    }
                }
                if(fee == 1){
                    if (!isFloat(cxRate)) {
                        x = false;
                        return false;
                    }
                    if(cxFeeType == 3) {
                        if (!isNumber(cxYueJieDay)) {
                            y = false;
                            return false;
                        }
                    }
                }
                if(fee == 2){
                    if (!isFloat(stRate)) {
                        x = false;
                        return false;
                    }
                    if(stFeeType == 3) {
                        if (!isNumber(stYueJieDay)) {
                            y = false;
                            return false;
                        }
                    }
                }

            });
            if(!x){
                bootAlert("请输入收费规则年化费率");
                return false;
            }

            if(!y){
                bootAlert("请输入正确的月结日期");
                return false;
            }
        }
        if($("[name=fees]:checked").length >=2){
            var x = true;
            var y = true;

           /* var hangFeeType = $("#hangFeeType").val();
            var cxFeeType = $("#cxFeeType").val();
            var stFeeType = $("#stFeeType").val();*/

            var yizhi = $("[name=yizhi]:checked").val();
            if(yizhi == 1){

                if (!isFloat(yizhiRate)) {
                    bootAlert("请输入收费规则年化费率");
                    return false;
                }
                if(yizhiType == 3){
                    if (!isNumber(yueJieDay)) {
                        bootAlert("请输入正确的月结日期");
                        return false;
                    }
                }
            }else{
                $.each($("[name=fees]:checked"),function(i){
                    var fee = $(this).val();
                    if(fee == 0){
                        if (!isFloat(hangRate)) {
                            x = false;
                            return false;
                        }

                        if(hangFeeType == 3){
                            if (!isNumber(hangYueJieDay)) {
                                y = false;
                                return false;
                            }
                        }
                    }
                    if(fee == 1){
                        if (!isFloat(cxRate)) {
                            x = false;
                            return false;
                        }

                        if(cxFeeType == 3){
                            if (!isNumber(cxYueJieDay)) {
                                y = false;
                                return false;
                            }
                        }
                    }
                    if(fee == 2){
                        if (!isFloat(stRate)) {
                            x = false;
                            return false;
                        }

                        if(stFeeType == 3){
                            if (!isNumber(stYueJieDay)) {
                                y = false;
                                return false;
                            }
                        }
                    }

                });
            }
            if(!x){
                bootAlert("请输入收费规则年化费率");
                return false;
            }
            if(!y){
                bootAlert("请输入正确的月结日期");
                return false;
            }

        }

        var amountUse = $("#amountUse").val();
        if (isEmpty(amountUse)) {
            bootAlert("请输入资金用途");
            return false;
        }
        var increaseCredit = $("#increaseCredit").val();
        if (isEmpty(increaseCredit)) {
            bootAlert("请输入增信措施");
            return false;
        }


        return true;
    }

    var b = true;
    $("a[op=save]").click(function(){

        /*if (!b) {
            return false;
        }
        b = false;*/

        var flag = validFormData();

        if (!flag) {
            b = true;
            return false;
        }

        var frm = $("#frm");
        var opts = {};
        opts.url= frm.attr("action");
        opts.success = function(data) {

            if (data.ret == 1) {
                bootAlert("添加成功", function(){
                    location.href = "/manager/product/addProduct";
                });
            } else {
                b = true;
                if (data.errmsg == "") {
                    bootAlert("操作失败");
                } else {
                    bootAlert(data.errmsg);
                }
            }
        };
        _jsonSubmit(frm, opts);
        return false;
    });

    $('#issueName').qsuggest({
        ajax: {
            url: '/manager/issue/getIssueBySgt?lang=zh&k=*',
            dataType: 'json',
            cache: false
        },
        //delay: 0,
        reader: function(data) {
            var ret = [];
            if ( data.data.length > 0 ) {
                for (var i=0,len= data.data.length; i < len; i += 1) {
                    var o = {};
                    o["id"] = data.data[i].id;
                    o["name"] = data.data[i].name;
                    ret.push(o);
                }
            }
            return ret;
        },
        on : {
            "q-suggest-user-action" : function(a,b,c){
                $('#issueName').val(c.name);
                $("#issueId").val( c.id);

            }
        }
    });


    $('#underwriterName').qsuggest({
        ajax: {
            url: '/manager/underwriter/getUnderwriterBySgt?lang=zh&k=*',
            dataType: 'json',
            cache: false
        },
        //delay: 0,
        reader: function(data) {
            var ret = [];
            if ( data.data.length > 0 ) {
                for (var i=0,len= data.data.length; i < len; i += 1) {
                    var o = {};
                    o["id"] = data.data[i].id;
                    o["name"] = data.data[i].name;
                    ret.push(o);
                }
            }
            return ret;
        },
        on : {
            "q-suggest-user-action" : function(a,b,c){
                $('#underwriterName').val(c.name);
                $("#underwriterId").val( c.id);

            }
        }
    });


    $('#danbaoName').qsuggest({
        ajax: {
            url: '/manager/danbao/getDanbaoBySgt?lang=zh&k=*',
            dataType: 'json',
            cache: false
        },
        //delay: 0,
        reader: function(data) {
            var ret = [];
            if ( data.data.length > 0 ) {
                for (var i=0,len= data.data.length; i < len; i += 1) {
                    var o = {};
                    o["id"] = data.data[i].id;
                    o["name"] = data.data[i].name;
                    ret.push(o);
                }
            }
            return ret;
        },
        on : {
            "q-suggest-user-action" : function(a,b,c){
                $('#danbaoName').val(c.name);
                $("#danbaoId").val( c.id);

            }
        }
    });

    $('#entrustedName').qsuggest({
        ajax: {
            url: '/manager/entrusted/getEntrustedBySgt?lang=zh&k=*',
            dataType: 'json',
            cache: false
        },
        //delay: 0,
        reader: function(data) {
            var ret = [];
            if ( data.data.length > 0 ) {
                for (var i=0,len= data.data.length; i < len; i += 1) {
                    var o = {};
                    o["id"] = data.data[i].id;
                    o["name"] = data.data[i].name;
                    ret.push(o);
                }
            }
            return ret;
        },
        on : {
            "q-suggest-user-action" : function(a,b,c){
                $('#entrustedName').val(c.name);
                $("#entrustedId").val( c.id);

            }
        }
    });

    $("#holdCalType").change(function () {
        var holdCalType =$("#holdCalType").val();
        if(holdCalType == 1){
            $("#endDateDiv").hide();
        }else{
            $("#endDateDiv").show();
        }
    });

    $("[name=trans]").change(function () {
        var trans =$("[name=trans]:checked").val();
        if(trans == 0){
            $("#lockDiv").hide();
        }else{
            $("#lockDiv").show();
        }
    });

    $("[name=establishType]").change(function () {
        var establishType =$("[name=establishType]:checked").val();
        if(establishType == 1){
            $("#establishDayDiv").hide();
        }else{
            $("#establishDayDiv").show();
        }
    });


    $("#addEstablishDay").click(function () {
        var h = [];
        h.push("<span><input type='text' style='width: 50px; display: inline-block;margin-left: 5px' class='form-control' t='establishDay' value=''>");


        h.push("<button o='c' type='button' class='close' style='float: none; height: 50px'></button></span>");
        $(h.join("")).insertAfter($("#establishDay"));
    });



    $("#establishDayDiv").delegate("button[o=c]", "click", function(){
        $(this).parent().remove();
    });


    $("#settlementType").change(function () {
        var settlementType =$("#settlementType").val();
        if(settlementType == 1){
            $("#fixedRadio").hide();
            $("#fixDiv").hide();
        }else{

            $("#fixedRadio").show();
            var fixed =$("[name=fixed]:checked").val();
            if(fixed == 0){
                $("#fixDiv").hide();
            }else{
                var settlementType =$("#settlementType").val();
                if(settlementType == 2){

                    $("#beforeText").html("每个自然月");
                    $("#fixedMonth").hide();
                    $("#middleText").hide();
                    // $("#startTime").css('visibility','visible');
                }else if(settlementType == 3){
                    $("#beforeText").html("每个自然季度的第");
                    $("#fixedMonth").show();
                    $("#middleText").show();
                    var html = "";
                    for(var i = 1;i <= 3 ;i++ ){
                        html = html + "<option value="+i+">"+i+"</option>"
                    }

                    $("#fixedMonth").html(html);
                }else if(settlementType == 4){
                    $("#beforeText").html("每个自然半年的第");
                    $("#fixedMonth").show();
                    $("#middleText").show();
                    var html = "";
                    for(var i = 1;i <= 6 ;i++ ){
                        html = html + "<option value="+i+">"+i+"</option>"
                    }

                    $("#fixedMonth").html(html);
                }else if(settlementType == 5){
                    $("#beforeText").html("每个自然年的第");
                    $("#fixedMonth").show();
                    $("#middleText").show();
                    var html = "";
                    for(var i = 1;i <= 12 ;i++ ){
                        html = html + "<option value="+i+">"+i+"</option>"
                    }

                    $("#fixedMonth").html(html);
                }
                $("#fixDiv").show();
            }
        }
    });

    $("[name=fixed]").change(function () {
        var fixed =$("[name=fixed]:checked").val();
        if(fixed == 0){
            $("#fixDiv").hide();
        }else{
            var settlementType =$("#settlementType").val();
            if(settlementType == 2){

                $("#beforeText").html("每个自然月");
                $("#fixedMonth").hide();
                $("#middleText").hide();
                // $("#startTime").css('visibility','visible');
            }else if(settlementType == 3){
                $("#beforeText").html("每个自然季度的第");
                $("#fixedMonth").show();
                $("#middleText").show();
                var html = "";
                for(var i = 1;i <= 3 ;i++ ){
                    html = html + "<option value="+i+">"+i+"</option>"
                }

                $("#fixedMonth").html(html);
            }else if(settlementType == 4){
                $("#beforeText").html("每个自然半年的第");
                $("#fixedMonth").show();
                $("#middleText").show();
                var html = "";
                for(var i = 1;i <= 6 ;i++ ){
                    html = html + "<option value="+i+">"+i+"</option>"
                }

                $("#fixedMonth").html(html);
            }else if(settlementType == 5){
                $("#beforeText").html("每个自然年的第");
                $("#fixedMonth").show();
                $("#middleText").show();
                var html = "";
                for(var i = 1;i <= 12 ;i++ ){
                    html = html + "<option value="+i+">"+i+"</option>"
                }

                $("#fixedMonth").html(html);
            }
            $("#fixDiv").show();
        }
    });

    $("[name=yizhi]").change(function () {
        var yizhi = $("[name=yizhi]:checked").val();
        if(yizhi == 1){
            $("#yizhiData").show();

            $("#hangTr").hide();
            $("#cxTr").hide();
            $("#stTr").hide();
        }else{
            $("#yizhiData").hide();
            $.each($("[name=fees]:checked"),function(i){
                var fee = $(this).val();
                if(fee == 0){
                    $("#hangTr").show();
                }
                if(fee == 1){
                    $("#cxTr").show();
                }
                if(fee == 2){
                    $("#stTr").show();
                }

            });
        }
    });

    $("[name=fees]").change(function () {
        var fees = $("[name=fees]:checked");
        if(fees.length == 0){
            $("#cxTr").hide();
            $("#stTr").hide();
            $("#hangTr").hide();
            $("#yizhiData").hide();
            $("#yizhiDiv").hide();
        }
        if(fees.length == 1){
            $("#yizhiDiv").hide();
            $("#yizhiData").hide();
            var feeT = $("[name=fees]:checked").val();
            if(feeT == 0){
                $("#cxTr").hide();
                $("#stTr").hide();
                $("#hangTr").show();
            }
            if(feeT == 1){
                $("#hangTr").hide();
                $("#stTr").hide();
                $("#cxTr").show();
            }
            if(feeT == 2){
                $("#hangTr").hide();
                $("#cxTr").hide();
                $("#stTr").show();
            }

        }
        if(fees.length >= 2){
            $("#hangTr").hide();
            $("#cxTr").hide();
            $("#stTr").hide();
            $("#yizhiData").hide();
            $("#yizhiDiv").show();
            var yizhi = $("[name=yizhi]:checked").val();
            if(yizhi == 2){
                $.each($("[name=fees]:checked"),function(i){
                    var fee = $(this).val();
                    if(fee == 0){
                        $("#hangTr").show();
                    }
                    if(fee == 1){
                        $("#cxTr").show();
                    }
                    if(fee == 2){
                        $("#stTr").show();
                    }

                });
            }
            if(yizhi == 1){
                $("#hangTr").hide();
                $("#cxTr").hide();
                $("#stTr").hide();
                $("#yizhiData").show();
            }
        }
    });


    $("#yizhiType").change(function () {
        var yizhiType = $("#yizhiType").val();
        if(yizhiType == 3){
            $("#yueJieDayDiv").show();
        }else {
            $("#yueJieDayDiv").hide();
        }
    });

    $("#hangFeeType").change(function () {
        var hangFeeType = $("#hangFeeType").val();
        if(hangFeeType == 3){
            $("#hangYueJieDayDiv").show();
        }else {
            $("#hangYueJieDayDiv").hide();
        }
    });

    $("#cxFeeType").change(function () {
        var cxFeeType = $("#cxFeeType").val();
        if(cxFeeType == 3){
            $("#cxYueJieDayDiv").show();
        }else {
            $("#cxYueJieDayDiv").hide();
        }
    });

    $("#stFeeType").change(function () {
        var stFeeType = $("#stFeeType").val();
        if(stFeeType == 3){
            $("#stYueJieDayDiv").show();
        }else {
            $("#stYueJieDayDiv").hide();
        }
    });



	var pageInit = function() {

        $("#termUnit").selectpicker({width : '60px'});
        $("#holdCalType").selectpicker({width : '80px'});
        $("#lockUnit").selectpicker({width : '60px'});
        $("#yearCalType").selectpicker({width : '100px'});
        $("#settlementType").selectpicker({width : '150px'});

        $("#yizhiType").selectpicker({width : '80px'});
        $("#hangFeeType").selectpicker({width : '80px'});
        $("#cxFeeType").selectpicker({width : '80px'});
        $("#stFeeType").selectpicker({width : '80px'});

    };

	$(pageInit);
})(window);
