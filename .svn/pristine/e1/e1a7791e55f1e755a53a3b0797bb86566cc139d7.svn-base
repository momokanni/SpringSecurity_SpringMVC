$(function(){

    $("#importFile").change(function(){
        var fileName = $("#importFile").val();
        var fileName = fileName.split("\\");
        $("#fileName").val(fileName[fileName.length - 1]);
    });

    var update = true;
    $("#upload").click(function(){

        if(!update) {
            return false;
        }
        update = false;

        var uploadFile = $("#fileName").val();
        var type = $("[name='type']:checked").val();
        if (isEmpty(type)) {
            bootAlert("请选择文件类型");
            update = true;
        } else if (isEmpty(uploadFile)) {
            bootAlert("请选择excel文件");
            update = true;
        } else if (uploadFile.lastIndexOf(".xls") < 0) {
            bootAlert("只能上传excel文件");
            update = true;
        } else {
            var file = document.querySelector("#updateFile");
            var formData = new FormData(file);
            $.ajax({
                url : "/manager/olddata/updateExcelFile",
                type : "POST",
                data : formData,
                cache : false,
                contentType : false,
                processData : false,
                dataType : "json",
                success : function (result) {
                    if (result.ret == 1) {
                        bootAlert("上传成功");
                        $("#fileName").val('');
                        QNR.TableList.query();
                    } else {
                        if (isEmpty(result.errmsg)) {
                            bootAlert("上传失败");
                        } else {
                            bootAlert(result.errmsg);
                        }
                    }
                    update = true;
                }
            })
        }
    });


    var fillProcess = function(data) {
        var pObj = $("tr[eid=" + data.id + "]");
        pObj.find("[st]").html(data.status);
        pObj.find("[tt]").html(data.total);
        pObj.find("[sc]").html(data.success);
        pObj.find("[fl]").html(data.failNums);
        pObj.find("[rj]").html(data.repetitionNums);
        pObj.find(".layui-progress-bar").css("width", data.process + "%");
    };

    var queryHandleProcess = function(eids){
        $.get("/manager/olddata/getExcelHandleByIds", {eids: eids}, function(result){
            if (result.ret == 1) {
                $.each(result.data.content, function(k, v) {
                    fillProcess(v);
                });
            }
        },"json");
    };

    setInterval(function() {
        var eIds = [];
        $("tr[eid]").each(function(k, v) {
            var eid = $(this).attr("eid");
            var p = $(this).attr("p");
            p = parseFloat(p, 10);
            if (p < 100) {
                eIds.push(eid);
            }
        });

        if (eIds.length > 0) {
            queryHandleProcess(eids.join(","));
        }
    }, 1500);

    var init = function() {
        $("[name='type']").each(function(k,v){
           if ($(this).val() == type) {
               $(this).prop("checked", true);
           }
        });
    };

     init();
});