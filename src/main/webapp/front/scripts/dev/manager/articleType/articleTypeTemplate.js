if (typeof QNR === 'undefined') {
    QNR = {};
}
(function(){
    var headername="创建类型";
    var tmpl = {
        editArticleType : {
            header : headername,
            data : true,
            width : 800,
            tmplId : "articleTypeDlg",
            dfunc : function(datas) {
                var ret = {};
                tmpl.editArticleType.header="创建类型";
                if (datas != null && datas.id != null) {
                    $.ajax({
                        url : "/manager/articleType/getArrticleById",
                        async : false,
                        dataType : "json",
                        data : {
                            id : datas.id
                        },
                        success : function(data){
                            var ret2 = data;
                             var aa=data.data.articleType;
                            if(aa!=null){
                                tmpl.editArticleType.header="编辑类型";
                            }
                            $.extend( ret, ret2);
                        }
                    });
                }
                return ret;
            },
            init : function(datas) {
                var update = (datas.articleType != null);

                if (update) {
                    top.$("#articleTypeDlg").find("#name").val(datas.data.articleType.name);
                }
            },
            tmpl : function (datas) {

                var update = (datas.articleType != null);
                var name;
                var seq;
                if(datas.ret==1){
                   name = datas.data.articleType.name;
                    seq = datas.data.articleType.seq;
                }
                var html = [];
                    html.push("<div id='articleTypeDlg'>");
                    html.push("<form id='frm'>");
                    html.push("<table rules='none' cellspacing='0' cellpadding='0' border='0px' width='100%' class='table'>");
                    html.push("<tbody>");
                    html.push("<tr>");
                    html.push("<td width='5%'></td>");
                    html.push("<td width='80%' align='right'>");
                    html.push("<div class='form-group'>");
                    html.push("<label class='control-label col-md-3'>类型:");
                    html.push("<span class='required' aria-required='true'> * </span>");
                    html.push("</label>");
                    html.push("<div class='col-md-5'>");
                    html.push("<input type='text' class='form-control' id='name' name='name' value='",name!=null ?name:"","' >");
                    html.push("</div>");
                    html.push("</div>");
                    html.push("</td>");
                    html.push("<td width='5%'></td>");
                    html.push("<tr>");
                    html.push("<td width='5%'></td>");
                    html.push("<td width='80%' align='right'>");
                    html.push("<div class='form-group'>");
                    html.push("<label class='control-label col-md-3'>权重值:");
                    html.push("<span class='required' aria-required='true'> * </span>");
                    html.push("</label>");
                    html.push("<div class='col-md-5'>");
                    html.push("<input type='text' class='form-control' id='seq' name='seq' value='",seq!=null ?seq:"","'>");
                    html.push("</div>");
                    html.push("</div>");
                    html.push("</td>");
                    html.push("<td width='5%'></td>");
                    html.push("</tbody></table>");
                    html.push("</form>");
                    html.push("</div>");
                return html.join("");
            },
            btns : [
                {
                    "text" : "确定",
                    fn : function (data, self) {
                         var update = false;

                         var id = top.$("#articleTypeDlg").find("[name=id]").val();
                         if (id != null) {
                             update = true;
                         }
                        var name = top.$("#name").val();
                        if (isEmpty(name)) {
                            bootAlert("类型不能为空");
                            return;
                        }else if(name.length>5){
                            bootAlert("最多5个字符");
                            return;
                        }
                        var seq = top.$("#seq").val();
                        var reg = new RegExp("[^0-9]","g");
                        if (isEmpty(seq)) {
                            bootAlert("权重值不能为空");
                            return;
                        }else if(reg.test(seq)){
                            bootAlert("只能输入数字");
                            return;
                        }

                         if (update) {
                             var frm = top.$("#articleTypeDlg").find("#frm")
                             var opts = {};
                             opts.url= "/manager/articleType/updateArticleType";
                             opts.success = function(data) {
                                 if (data.ret == 1) {
                                     bootAlert("操作成功", function() {
                                         QNR.TableList.query();
                                     });
                                     dlg.close();
                                 } else {
                                     bootAlert(data.errmsg);
                                 }
                             };
                             _jsonSubmit(frm, opts);
                         } else {
                            var frm = top.$("#articleTypeDlg").find("#frm")
                            var opts = {};
                            opts.url= "/manager/articleType/addArticleType";
                            opts.success = function(data) {
                                if (data.ret == 1) {
                                    bootAlert("操作成功", function() {
                                        QNR.TableList.query();
                                    });
                                    dlg.close();
                                } else {
                                    bootAlert(data.errmsg);
                                }
                            };
                            _jsonSubmit(frm, opts);
                        }
                    }
                },
                {
                    "text" : "关闭",
                    fn : function (data) {
                        dlg.close();
                    },
                    close : true
                }
            ]

        }
    };
    QNR.tmpl  = tmpl;
})();