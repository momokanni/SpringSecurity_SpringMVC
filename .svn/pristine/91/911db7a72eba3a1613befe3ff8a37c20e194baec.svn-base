(function (win,undefinde) {
    var $ = win.jQuery;

    $("[name='memberType']").click(function(){
        $("[name='memberType']").prop("checked", false);
        $(this).prop("checked", true);
        $("form").addClass("dn");
        $("#" + $(this).val()).removeClass("dn");
    });

    var clearInput = function() {
        $("form").find(":input").val('');
    };

    $('#queryCliqueName').qsuggest({
        ajax: {
            url: '/manager/clique/getFaeCliqueByName?lang=zh&k=*',
            dataType: 'json',
            cache: false
        },
        //delay: 0,
        reader: function(data) {
            var ret = [];
            if (null != data.data && undefinde != data.data && data.data.length > 0 ) {
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
                $('#cliqueName').val(c.name);
                $("#cliqueId").val( c.id);
            }
        }
    });

    var checkCommonProperty = function(value) {
        var name = $("#" + value + "Name").val();
        if (isEmpty(name)) {
            bootAlert("公司全称不能为空");
            return true;
        }

        var shortName = $("#" + value + "ShortName").val();
        if (isEmpty(shortName)) {
            bootAlert("公司简称不能为空");
            return true;
        }

        var creditCode = $("#" + value + "CreditCode").val();
        if (isEmpty(creditCode)) {
            bootAlert("统一社会信用代码不能为空");
            return true;
        }
        return false;
    };

    var save = true;
    var addClique = function(value) {
        if (!save) {
            return false;
        }
        save = false;

        var result = checkCommonProperty(value);
        if (result) {
            save = true;
            return false;
        }

        var url = $("#" + value).prop("action");

        $.post(url, $("#" + value).serialize(), function(result){
            if (result.ret == 1) {
                bootAlert("保存成功");
                clearInput();
            } else {
                if (isEmpty(result.errmsg)) {
                    bootAlert("保存失败");
                } else {
                    bootAlert(result.errmsg);
                }
            }
            save = true;
        }, "json");
    };

    var addIssue = function(value) {
        if (!save) {
            return false;
        }
        save = false;

        var result = checkCommonProperty(value);
        if (result) {
            save = true;
            return false;
        }

        var url = $("#" + value).prop("action");

        $.post(url, $("#" + value).serialize(), function(result){
            if (result.ret == 1) {
                bootAlert("保存成功");
                clearInput();
            } else {
                if (isEmpty(result.errmsg)) {
                    bootAlert("保存失败");
                } else {
                    bootAlert(result.errmsg);
                }
            }
            save = true;
        }, "json");
    };

    var addDanbao = function(value) {
        if (!save) {
            return false;
        }
        save = false;

        var result = checkCommonProperty(value);
        if (result) {
            save = true;
            return false;
        }

        var url = $("#" + value).prop("action");

        $.post(url, $("#" + value).serialize(), function(result){
            if (result.ret == 1) {
                bootAlert("保存成功");
                clearInput();
            } else {
                if (isEmpty(result.errmsg)) {
                    bootAlert("保存失败");
                } else {
                    bootAlert(result.errmsg);
                }
            }
            save = true;
        }, "json");
    };

    var addUnderwriter = function(value) {
        if (!save) {
            return false;
        }
        save = false;

        var result = checkCommonProperty(value);
        if (result) {
            save = true;
            return false;
        }

        var url = $("#" + value).prop("action");

        $.post(url, $("#" + value).serialize(), function(result){
            if (result.ret == 1) {
                bootAlert("保存成功");
                clearInput();
            } else {
                if (isEmpty(result.errmsg)) {
                    bootAlert("保存失败");
                } else {
                    bootAlert(result.errmsg);
                }
            }
            save = true;
        }, "json");
    };

    var addEntrusted = function(value) {
        if (!save) {
            return false;
        }
        save = false;

        var result = checkCommonProperty(value);
        if (result) {
            save = true;
            return false;
        }

        var url = $("#" + value).prop("action");

        $.post(url, $("#" + value).serialize(), function(result){
            if (result.ret == 1) {
                bootAlert("保存成功");
                clearInput();
            } else {
                if (isEmpty(result.errmsg)) {
                    bootAlert("保存失败");
                } else {
                    bootAlert(result.errmsg);
                }
            }
            save = true;
        }, "json");
    };

    var saveInvestor = function (value) {
        var url = $("#" + value).prop("action");
        $.post(url, $("#" + value).serialize(), function(result){
            if (result.ret == 1) {
                bootAlert("保存成功");
                clearInput();
            } else {
                if (isEmpty(result.errmsg)) {
                    bootAlert("保存失败");
                } else {
                    bootAlert(result.errmsg);
                }
            }
            save = true;
        }, "json");
    };

    var addInvestor= function(value) {
        if (!save) {
            return false;
        }
        save = false;

        var type = $("#investorType").val();
        if (type == personType) {
            var realName = $("#investorRealName").val();
            var idCardNo = $("#investorIdCardNo").val();
            var mobile = $("#investorMobile").val();

            if (isEmpty(realName)) {
                bootAlert("真实姓名不能为空");
            } else if (isEmpty(idCardNo)) {
                bootAlert("身份证号不能为空");
            } else if (!isValidIdCard(idCardNo)) {
                bootAlert("身份证号不正确");
            } else if (!isEmpty(mobile) && !isMobile(mobile)) {
                bootAlert("手机号格式错误");
            } else {
                saveInvestor(value);
            }
            save = true;
        } else if (type == companyType) {
            var companyName = $("#investorCompanyName").val();
            var creditCode = $("#investorCreditCode").val();
            var businessLicense = $("#investorBusinessLicense").val();
            var legalPersonName = $("#investorLegalPersonName").val();
            var contacts = $("#investorContacts").val();
            var contactsTel = $("#investorContactsTel").val();

            if (isEmpty(companyName)) {
                bootAlert("公司名称不能为空");
            } else if (isEmpty(creditCode)) {
                bootAlert("统一社会信用代码不能为空");
            } else if (isEmpty(businessLicense)) {
                bootAlert("营业执照编号不能为空");
            } else if (isEmpty(legalPersonName)) {
                bootAlert("法人姓名不能为空");
            } else if (isEmpty(contacts)) {
                bootAlert("联系人不能为空");
            } else if (isEmpty(contactsTel)) {
                bootAlert("联系人电话不能为空");
            } else if (!isMobile(contactsTel)) {
                bootAlert("联系人电话格式错误");
            } else {
                saveInvestor(value);
            }
            save = true;
        }
    };

    $("#investorType").change(function(){
        var type = $(this).val();
        if (type == personType) {
            $(".company").addClass("dn");
            $(".person").removeClass("dn");
        } else if (type == companyType) {
            $(".person").addClass("dn");
            $(".company").removeClass("dn");
        }
    });


    $("a[op='save']").click(function(){
        var memberType = $("[name='memberType']:checked").val();
        if (memberType == "clique") {
            addClique("clique");
        } else if (memberType == "issue") {
            addIssue("issue");
        } else if (memberType == "danbao") {
            addDanbao("danbao");
        } else if (memberType == "underwriter") {
            addUnderwriter("underwriter");
        } else if (memberType == "entrusted") {
            addEntrusted("entrusted");
        } else if (memberType == "investor") {
            addInvestor("investor");
        }
    });

    var init = function () {
        $("#investorType").selectpicker();
    }
    init();
})(window);