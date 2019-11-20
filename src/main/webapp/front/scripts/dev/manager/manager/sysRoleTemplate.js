if (typeof QNR === 'undefined') {
    QNR = {};
}
(function(){
    var tmpl = {
        addSysRole: {
            header: "创建角色",
            data: true,
            width: 800,
            tmplId: "addSysRole",
            dfunc: function (datas) {
                var ret = {};
                return ret;
            },
            init: function (datas) {
                top.$("#addSysRole").find("[mi]").css("display", "");
            },
            tmpl: function (datas) {
                var html = [];
                html.push("<div class='modal-body'>");
                html.push("<form action='/manager/sysrole/addSysRole' method='post' id='frm'>");
                html.push("<table rules='none' cellspacing='0' cellpadding='0' border='0px' width='100%' class='table'>");
                html.push("<tbody>");
                html.push("<tr>");
                html.push("<td width='5%'></td>");
                html.push("<td width='80%' align='right'>");
                html.push("<div class='form-group'>");
                html.push("<label class='control-label col-md-3'>角色:");
                html.push("<span class='required' aria-required='true'> * </span>");
                html.push("</label>");
                html.push("<div class='col-md-5'>");
                html.push("<input type='text' class='form-control' id='sysRoleName' name='roleName' value=''>");
                html.push("</div>");
                html.push("</div>");
                html.push("</td>");
                html.push("<td width='5%'></td>");
                html.push("</tr>");
                html.push("<tr>");
                html.push("<td width='5%'></td>");
                html.push("<td width='5%'></td>");
                html.push("</tr></tbody></table></form></div>");
                return html.join("");
            },
            btns: [
                {
                    "text": "创建",
                    fn: function (data, self) {
                        var roleName = top.$("#sysRoleName").val();
                        if (isEmpty(roleName)) {
                            bootAlert("角色名称不能为空");
                        } else {
                            var url = top.$("#frm").prop("action");
                            var param = top.$("#frm").serialize();

                            $.ajax({
                                url:url,
                                type:"POST",
                                data:param,
                                dataType:"json",
                                success:function(data){
                                        if (1 == data.ret) {
                                               bootAlert("保存成功", function(){
                                                     QNR.TableList.query();
                                               });
                                               dlg.close();
                                        } else {
                                               if (data.errmsg == '') {
                                                      bootAlert("保存失败");
                                               } else {
                                                      bootAlert(data.errmsg);
                                               }
                                        }
                                },
                                error:function(data){
                               	 var data = eval("("+data.responseText+")");
                               	 bootAlert(data.errmsg);
                                }
                           });
                        }
                    }
                },
                {
                    "text": "取消",
                    fn: function (data) {
                        dlg.close();
                    },
                    close: true
                }
            ]

        },
        
        sysRolePermit : {
            header : "设置权限",
            data : true,
            width : 800,
            tmplId : "sysRolePermit",
            dfunc : function(datas) {
                var ret = {};
                    $.ajax({
                        url : "/manager/sysrole/getSysPermit",
                        dataType : "json",
                        type : "GET",
                        async : false,
                        data: {
                        	"id": datas.id
                        },
                        success : function(result) {
                        	if (1 == result.ret) {
                                var ret2 = result.data;
                                $.extend(ret, ret2);
                            }
                        }
                    });
                return ret;
            },
            init : function(datas) {
                top.$("#sysRolePermit").find("[pr]").click(function() {
                    var checked = $(this).prop("checked");
                    var pId = $(this).prop("id");

                    top.$("#sysRolePermit").find("[pr]").each(function() {
                       if (pId == $(this).attr("pr")) {
                           $(this).prop("checked", checked);
                       }
                    });
                });
            },
            tmpl : function (datas) {
                var html = [];

                var sysRolePermit = datas.sysRolePermitMap;
                var parentSysPermit = datas.parentSysPermits;
                var sysPermit = datas.resultMap;

                html.push("<div id='sysRolePermit'>");
                html.push("<form action='/manager/sysrole/allotAuth' method='post' id='frm'>");
                html.push("<input type='hidden' name='sysRoleId' value=" + datas.id + ">");
                html.push("<table rules='none' cellspacing='0' cellpadding='0' border='0px' width='100%'>");
                html.push("<tr height='30px'>");
                html.push("<td>角色: ", datas.roleName ,"");
                html.push("</td>");
                html.push("</tr>");

                for (var p in parentSysPermit) {
                    var pId = parseInt(parentSysPermit[p].id);
                    var cked = "";
                    if (undefined != sysRolePermit) {
                        if (undefined != sysRolePermit[pId]) {
                            cked = sysRolePermit[pId].permit ? 'checked' : '';
                        }
                    }
                    html.push("<tr height='30px'>");
                    html.push("<td>");
                    html.push("<label class='mt-checkbox'>");
                    html.push("<input type='checkbox' ", cked ," pr='0' value='", pId ,"' class='' name='sysPermitId' id='", pId ,"'/>",parentSysPermit[p].modleName,"");
                    html.push("<span></span>");
                    html.push("</label>");

                    var sysPermits = sysPermit[pId];
                    if (undefined != sysPermits) {
                        var br = true;
                        for (var s = 0; s < sysPermits.length; s++) {
                            if (s != 0 && s % 5 == 0) {
                                br = true;
                            }
                            if (br) {
                                html.push("<tr height='30px'>");
                                br = false;
                            }
                            var cked = "";
                            if (undefined != sysRolePermit) {
                                var sup = sysRolePermit[sysPermits[s].id];
                                if (undefined != sup) {
                                    cked = sup.permit ? 'checked' : '';
                                }
                            }
                            html.push("<td>");
                            html.push("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                            html.push("<label class='mt-checkbox'>");
                            html.push("<input type='checkbox' ", cked ," pr='", pId ,"' value='", sysPermits[s].id ,"' name='sysPermitId' id='", sysPermits[s].id ,"' />", sysPermits[s].modleName  ,"");
                            html.push("<span></span>");
                            html.push("</label>");
                            html.push("</td>");
                            if (s == sysPermits.length - 1) {
                                br = true;
                            }
                            if (br) {
                                html.push("</tr>");
                                br = false;
                            }
                        }
                    }
                    html.push("</td>");
                    html.push("</tr>")
                }
                html.push("</table></form></div>");

                return html.join("");
            },
            btns : [
                {
                    "text" : "确定",
                    fn : function (data, self) {
                        var frm = top.$("#sysRolePermit").find("#frm");
                        $.post("/manager/sysrole/addRoleAuth", frm.serialize(), function(result){
                            if (1 == result.ret) {
                                bootAlert("操作成功", function() {
                                    QNR.TableList.query();
                                });
                                dlg.close();
                            } else {
                                bootAlert(result.errmsg);
                            }
                        }, "json");
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