if (typeof QNR === 'undefined') {
    QNR = {};
}

(function(){
    var tmpl = {
        addSysUser: {
            header: "新增账户",
            data: true,
            width: 800,
            tmplId: "addSysUser",
            dfunc: function (datas) {
                var ret = {};
                $.ajax({
                    url : "/manager/sysuser/getDepartmentData",
                    dataType : "json",
                    type : "GET",
                    async : false,
                    success : function(result) {
                        if (1 == result.ret) {
                            ret = result.data;
                        }
                    }
                });
                return ret;
            },
            init: function (datas) {
                top.$("#addSysUser").find("[mi]").css("display", "");
                top.$("#addSysUser").find("#sysUserDepartment").change(function(){
                    var department = $(this).val();
                    $.ajax({
                       url:"/manager/sysrole/getSysRoleByDepartment",
                       data:{"department" : department},
                       dataType:"json",
                       type:"GET",
                       async:false,
                       success:function(result) {
                           if (1 == result.ret) {
                               top.$("#addSysUser").find("#sysUserRoleId option").remove();;
                               var data = result.data;
                               var html = [];
                               for (var d in data) {
                                   html.push("<option value=", data[d].sysRoleId, ">", data[d].roleName, "</option>");
                               }

                               top.$("#addSysUser").find("#sysUserRoleId").append(html.join(''));
                           }
                       }
                    });
                });

                top.$("#addSysUser").find("#sysUserReportDepartment").change(function(){
                    var department = $(this).val();
                    $.ajax({
                        url:"/manager/sysrole/getSysRoleByDepartment",
                        data:{"department" : department},
                        dataType:"json",
                        type:"GET",
                        async:false,
                        success:function(result) {
                            if (1 == result.ret) {
                                top.$("#addSysUser").find("#sysUserReportRoleId option").remove();;
                                var data = result.data;
                                var html = [];
                                for (var d in data) {
                                    html.push("<option value=", data[d].sysRoleId, ">", data[d].roleName, "</option>");
                                }

                                top.$("#addSysUser").find("#sysUserReportRoleId").append(html.join(''));
                            }
                        }
                    });
                });

                top.$("#addSysUser").find("#sysUserName").bind("blur, change", function(){
                    var str = $(this).val();
                    $.ajax({
                        url:"/manager/sysuser/getLoginNameByName",
                        data:{"name":str},
                        type:"GET",
                        dataType:"json",
                        async:false,
                        success:function(result){
                            if (1 == result.ret) {
                                top.$("#addSysUser").find("#sysUserLoginNameP").html("<b style='font-size: 18px;'>" + result.data + "</b>");
                                top.$("#addSysUser").find("#sysUserLoginName").val(result.data);
                            }
                        }
                    });
                });

            },
            tmpl: function (datas) {
                var html = [];
                var department = datas.department;

                html.push("<div id='addSysUser'>");
                html.push("<form action='/manager/sysuser/addSysUser' method='post' id='frm'>");
                html.push("<table rules='none' cellspacing='0' cellpadding='0' border='0px' width='100%' class='table'>");
                html.push("<tbody>");
                html.push("<tr>");
                html.push("<td width='5%'></td>");
                html.push("<td width='80%' align='right'>");
                html.push("<div class='form-group'>");
                html.push("<label class='control-label col-md-3'>姓名:");
                html.push("<span class='required' aria-required='true'> * </span>");
                html.push("</label>");
                html.push("<div class='col-md-5'>");
                html.push("<input type='text' class='form-control' id='sysUserName' name='name' value=''>");
                html.push("</div></div></td>");
                html.push("<td width='5%'></td>");
                html.push("</tr>");
                html.push("<tr>");
                html.push("<td width='5%'></td>");
                html.push("<td width='80%' align='right'>");
                html.push("<div class='form-group'>");
                html.push("<label class='control-label col-md-3'>性别:");
                html.push("<span class='required' aria-required='true'> * </span>");
                html.push("</label>");
                html.push("<div class='col-md-3'>");
                html.push("<div class='mt-radio-inline'>");
                html.push("<label class='mt-radio'>");
                html.push("<input type='radio' id='sysUserSex1' name='sex' class='sysUserSex' value=" + datas.man + ">" + datas.manDesc + "");
                html.push("<span></span>");
                html.push("</label>");
                html.push("<label class='mt-radio'>");
                html.push("<input type='radio' id='sysUserSex2' name='sex' class='sysUserSex' value=" + datas.woman + ">" + datas.womanDesc + "");
                html.push("<span></span>");
                html.push("</label></div></div></div></td>");
                html.push("<td width='5%'></td>");
                html.push("</tr>");
                html.push("<tr>");
                html.push("<td width='5%'></td>");
                html.push("<td width='80%' align='right'>");
                html.push("<div class='form-group'>");
                html.push("<label class='control-label col-md-3'>手机号:");
                html.push("<span class='required' aria-required='true'> * </span>");
                html.push("</label>");
                html.push("<div class='col-md-5'>");
                html.push("<input type='text'  class='form-control' id='sysUserMobile' name='mobile' value=''>");
                html.push("</div></div></td>");
                html.push("<td width='5%'></td>");
                html.push("</tr>");
                html.push("<tr>");
                html.push("<td width='5%'></td>");
                html.push("<td width='80%' align='right'>");
                html.push("<div class='form-group'>");
                html.push("<label class='control-label col-md-3'>邮箱:");
                html.push("<span class='required' aria-required='true'> * </span>");
                html.push("</label>");
                html.push("<div class='col-md-5'>");
                html.push("<input type='text'  class='form-control' id='sysUserEmail' name='email' value=''>");
                html.push(" </div></div></td>");
                html.push("<td width='5%'></td>");
                html.push("</tr></tr>");
                html.push("<tr>");
                html.push("<td width='5%'></td>");
                html.push("<td width='80%' align='right'>");
                html.push("<div class='form-group'>");
                html.push("<label class='control-label col-md-3'>部门和岗位:");
                html.push("<span class='required' aria-required='true'> * </span>");
                html.push("</label>");
                html.push("<div class='col-md-5'>");
                html.push("<select name='department' class='form-control sysUserDepartment' style='width: 48%; display: inline; margin-right: 1%' id='sysUserDepartment'>");
                html.push("<option value=''>请选择部门</option>");
                for (var i in department) {
                    html.push("<option value=" + department[i].departmentType + ">" + department[i].departmentDesc + "</option>");
                }
                html.push("</select>");
                html.push("<select name='roleId' class='form-control sysUserRoleId' style='width: 48%; display: inline;' id='sysUserRoleId'>");
                html.push("<option value=''>请选择岗位</option>");
                html.push("</select>");
                html.push("</div></div></td>");
                html.push("<td width='5%'></td>");
                html.push("</tr>");
                html.push("<tr>");
                html.push("<td width='5%'></td>");
                html.push("<td width='80%' align='right'>");
                html.push("<div class='form-group'>");
                html.push("<label class='control-label col-md-3'>汇报对象:");
                html.push("<span class='required' aria-required='true'> * </span>");
                html.push("</label>");
                html.push("<div class='col-md-5'>");
                html.push("<select name='reportDepartment' style='width: 48%; display: inline; margin-right: 1%' class='form-control sysUserReportDepartment' id='sysUserReportDepartment'>");
                html.push("<option value=''>请选择部门</option>");
                for (var i in department) {
                    html.push("<option value=" + department[i].departmentType + ">" + department[i].departmentDesc + "</option>");
                }
                html.push("</select>");
                html.push("<select name='reportRoleId' style='width: 48%; display: inline;' class='form-control sysUserReportRoleId' id='sysUserReportRoleId'>");
                html.push("<option value=''>请选择岗位</option>");
                html.push("</select>");
                html.push(" </div></div></td>");
                html.push("<td width='5%'></td>");
                html.push("</tr>");
                html.push("<tr>");
                html.push("<tr>");
                html.push("<td width='5%'></td>");
                html.push("<td width='80%' align='right'>");
                html.push("<div class='form-group'>");
                html.push("<label class='control-label col-md-3'>账号:");
                html.push("<span class='required' aria-required='true'> * </span>");
                html.push("</label>");
                html.push("<div class='col-md-3'>");
                html.push("<p id='sysUserLoginNameP'  class='form-control-static'></p>");
                html.push("<input type='hidden' id='sysUserLoginName' name='loginName' value=''>");
                html.push("</div></div></td>");
                html.push("<td width='5%'></td>");
                html.push("</tr>");
                html.push("<tr>");
                html.push("<td width='5%'></td>");
                html.push("<td width='80%' align='right'>");
                html.push("<div class='form-group'>");
                html.push("<label class='control-label col-md-3'>初始密码:");
                html.push("<span class='required' aria-required='true'> * </span>");
                html.push("</label>");
                html.push("<div class='col-md-5'>");
                html.push("<input type='password' class='form-control' id='sysUserPassword' name='password' placeholder='6-12位大小写字母、数字组合' value=''>");
                html.push(" </div></div></td>");
                html.push("<td width='5%'></td>");
                html.push(" </tbody></table></form></div>");
                return html.join("");
            },
            btns: [
                {
                    "text": "保存",
                    fn: function (data, self) {
                        var name = top.$("#sysUserName").val();
                        var sex = top.$(".sysUserSex:checked").val();
                        var mobile = top.$("#sysUserMobile").val();
                        var email = top.$("#sysUserEmail").val();
                        var roleId = top.$("#sysUserRoleId").val();
                        var reportRoleId = top.$("#sysUserReportRoleId").val();
                        var password = top.$("#sysUserPassword").val();

                        if (isEmpty(name)) {
                            bootAlert("岗位名称不能为空");
                        } else if (isEmpty(sex)) {
                            bootAlert("请选择部门");
                        } else if (isEmpty(mobile)) {
                            bootAlert("手机号不能为空");
                        } else if (!isMobile(mobile)) {
                            bootAlert("手机号格式错误");
                        } else if (isEmpty(email)) {
                            bootAlert("邮箱不能为空");
                        } else if (!isMail(email)) {
                            bootAlert("邮箱格式错误");
                        } else if (isEmpty(roleId)) {
                            bootAlert("请选择所属部门和岗位");
                        } else if (isEmpty(reportRoleId)) {
                            bootAlert("请选择汇报部门和岗位");
                        } else if (isEmpty(password)) {
                            bootAlert("密码不能为空");
                        } else {
                            var url = top.$("#frm").prop("action");
                            var param = top.$("#frm").serialize();
                            $.post(url, param,
                                function(result){
                                    if (1 == result.ret) {
                                        bootAlert("保存成功", function(){
                                            QNR.TableList.query();
                                        });
                                        dlg.close();
                                    } else {
                                        if (result.errmsg == '') {
                                            bootAlert("保存失败");
                                        } else {
                                            bootAlert(result.errmsg);
                                        }
                                    }
                                },"json")
                        }
                    }
                },
                {
                    "text": "关闭",
                    fn: function (data) {
                        dlg.close();
                    },
                    close: true
                }
            ]
        },
        seeSysUser: {
            header: "账户详情",
            data: true,
            width: 800,
            tmplId: "seeSysUser",
            dfunc: function (datas) {
                var ret = {};
                $.ajax({
                    url : "/manager/sysuser/getSysUserDetailById?id=" + datas.id,
                    dataType : "json",
                    type : "GET",
                    async : false,
                    success : function(result) {
                        if (1 == result.ret) {
                            ret = result.data;
                        }
                    }
                });
                return ret;
            },
            init: function (datas) {
                top.$("#seeSysUser").find("#resetPwdBotton").click(function(){
                   top.$("#seeSysUser").find("#resetPwd").show();
                    top.$("#seeSysUser").find("#ensure").val(true);
                });
            },
            tmpl: function (datas) {
                var html = [];

                html.push("<div class='modal-body' id='seeSysUser'>");
                html.push("<form action='/manager/sysuser/resetSysUserPwd' method='post' id='frm'>");
                html.push("<input type='hidden' name='sysUserId' value=" + datas.id + ">");
                html.push("<table rules='none' cellspacing='0' cellpadding='0' border='0px' width='100%' class='table'>");
                html.push("<tbody>");
                html.push("<tr>");
                html.push("<td width='5%'></td>");
                html.push("<td width='80%' align='right'>");
                html.push("<div class='form-group'>");
                html.push("<label class='control-label col-md-3'>姓名:");
                html.push("<span class='required' aria-required='true'> * </span>");
                html.push("</label>");
                html.push("<div class='col-md-5'>");
                html.push("<input type='text' class='form-control' readonly='readonly' value=" + datas.name + ">");
                html.push("</div></div></td>");
                html.push("<td width='5%'></td>");
                html.push("</tr>");
                html.push("<tr>");
                html.push("<td width='5%'></td>");
                html.push("<td width='80%' align='right'>");
                html.push("<div class='form-group'>");
                html.push("<label class='control-label col-md-3'>性别:");
                html.push("<span class='required' aria-required='true'> * </span>");
                html.push("</label>");
                html.push("<div class='col-md-3'>");
                html.push("<div class='mt-radio-inline'>");
                html.push("<label class='mt-radio'>");
                if (datas.man == datas.sex) {
                    html.push("<input type='radio' class='sysUserSex' checked='checked' readonly='readonly' >" + datas.manDesc + "");
                } else {
                    html.push("<input type='radio' class='sysUserSex' readonly='readonly'>" + datas.manDesc + "");
                }
                html.push("<span></span>");
                html.push("</label>");
                html.push("<label class='mt-radio'>");
                if (datas.woman == datas.sex) {
                    html.push("<input type='radio' class='sysUserSex' checked='checked' readonly='readonly'>" + datas.womanDesc + "");
                } else {
                    html.push("<input type='radio' class='sysUserSex' readonly='readonly'>" + datas.womanDesc + "");
                }
                html.push("<span></span>");
                html.push("</label></div></div></div></td>");
                html.push("<td width='5%'></td>");
                html.push("</tr>");
                html.push("<tr>");
                html.push("<td width='5%'></td>");
                html.push("<td width='80%' align='right'>");
                html.push("<div class='form-group'>");
                html.push("<label class='control-label col-md-3'>手机号:");
                html.push("<span class='required' aria-required='true'> * </span>");
                html.push("</label>");
                html.push("<div class='col-md-5'>");
                html.push("<input type='text'  class='form-control' readonly='readonly' value=" + datas.mobile+ ">");
                html.push("</div></div></td>");
                html.push("<td width='5%'></td>");
                html.push("</tr>");
                html.push("<tr>");
                html.push("<td width='5%'></td>");
                html.push("<td width='80%' align='right'>");
                html.push("<div class='form-group'>");
                html.push("<label class='control-label col-md-3'>邮箱:");
                html.push("<span class='required' aria-required='true'> * </span>");
                html.push("</label>");
                html.push("<div class='col-md-5'>");
                html.push("<input type='text'  class='form-control' readonly='readonly' value=" + datas.email + ">");
                html.push(" </div></div></td>");
                html.push("<td width='5%'></td>");
                html.push("</tr></tr>");
                html.push("<tr>");
                html.push("<td width='5%'></td>");
                html.push("<td width='80%' align='right'>");
                html.push("<div class='form-group'>");
                html.push("<label class='control-label col-md-3'>部门和岗位:");
                html.push("<span class='required' aria-required='true'> * </span>");
                html.push("</label>");
                html.push("<div class='col-md-5'>");
                html.push("<input type='text' style='display: inline; width: 49%; margin-right: 1%;' class='form-control' readonly='readonly' value=" + datas.department + ">");
                html.push("<input type='text' style='display: inline; width: 49%;' class='form-control' readonly='readonly' value=" + datas.roleName + ">");
                html.push("</div></div></td>");
                html.push("<td width='5%'></td>");
                html.push("</tr>");
                html.push("<tr>");
                html.push("<td width='5%'></td>");
                html.push("<td width='80%' align='right'>");
                html.push("<div class='form-group'>");
                html.push("<label class='control-label col-md-3'>汇报对象:");
                html.push("<span class='required' aria-required='true'> * </span>");
                html.push("</label>");
                html.push("<div class='col-md-5'>");
                html.push("<input type='text' style='display: inline; width: 49%; margin-right: 1%;' class='form-control' readonly='readonly' value=" + datas.department + ">");
                html.push("<input type='text' style='display: inline; width: 49%;' class='form-control' readonly='readonly' value=" + datas.roleName + ">");
                html.push(" </div></div></td>");
                html.push("<td width='5%'></td>");
                html.push("</tr>");
                html.push("<tr>");
                html.push("<tr>");
                html.push("<td width='5%'></td>");
                html.push("<td width='80%' align='right'>");
                html.push("<div class='form-group'>");
                html.push("<label class='control-label col-md-3'>账号:");
                html.push("<span class='required' aria-required='true'> * </span>");
                html.push("</label>");
                html.push("<div class='col-md-3'>");
                html.push("<p class='form-control-static'>" + datas.loginName + "</p>");
                html.push("</div></div></td>");
                html.push("<td width='5%'></td>");
                html.push("</tr>");
                html.push("<tr>");
                html.push("<td width='5%'></td>");
                html.push("<td width='80%' align='right'>");
                html.push("<div class='form-group'>");
                html.push("<label class='control-label col-md-3'>初始密码:");
                html.push("<span class='required' aria-required='true'> * </span>");
                html.push("</label>");
                html.push("<div class='col-md-8'>");
                html.push("<input type='text' style='width: 60%; display: inline; margin-right: 6%;' class='form-control' readonly='readonly' value=" + datas.password + ">");
                html.push("<input type='button' style='width: 21%; display: inline; margin-right: 11%;' id='resetPwdBotton' class='btn yellow' value='重置密码'>");
                html.push("</div>");
                html.push("</div></td></tr>");
                html.push("<td width='5%'></td>");
                html.push("<tr id='resetPwd' style='display: none;'>");
                html.push("<td width='5%'></td>");
                html.push("<td width='80%' align='right'>");
                html.push("<div class='form-group'>");
                html.push("<label class='control-label col-md-3'>新密码");
                html.push("<span class='required' aria-required='true'> * </span>");
                html.push("</label>");
                html.push("<div class='col-md-5'>");
                html.push("<input type='password' class='form-control' name='newPwd' value='' id='newPwd' placeholder='6-12位大小写字母、数字组合'>");
                html.push("<input type='hidden'  name='ensure' value='false' id='ensure'>");
                html.push("</div>");
                html.push("</div></td>");
                html.push("<td width='5%'></td>");
                html.push("</tr></tbody></table></form></div>");
                return html.join("");
            },
            btns: [
                {
                    "text": "保存",
                    fn: function (data, self) {

                        var ensure = top.$("#ensure").val();
                        var newPwd = top.$("#newPwd").val();
                        if (!ensure) {
                            dlg.close();
                        } else if (isEmpty(newPwd)) {
                            bootAlert("新密码不能为空");
                        } else {
                            var url = "/manager/sysuser/resetSysUserPwd";
                            var param = top.$("#seeSysUser").find("#frm").serialize();
                            $.post(url, param,
                                function(result){
                                    if (1 == result.ret) {
                                        bootAlert("保存成功", function(){
                                            QNR.TableList.query();
                                        });
                                        dlg.close();
                                    } else {
                                        if (result.errmsg == '') {
                                            bootAlert("保存失败");
                                        } else {
                                            bootAlert(result.errmsg);
                                        }
                                    }
                                },"json")
                        }
                    }
                },
                {
                    "text": "关闭",
                    fn: function (data) {
                        dlg.close();
                    },
                    close: true
                }
            ]
        },
        sysUserPermit : {
            header : "设置权限",
            data : true,
            width : 800,
            tmplId : "sysUserPermit",
            dfunc : function(datas) {
                var ret = {};
                    $.ajax({
                        url : "/manager/sysuser/getSysPermit?id=" + datas.id,
                        dataType : "json",
                        type : "GET",
                        async : false,
                        success : function(result) {
                            if (1 == result.ret) {
                                ret = result.data;
                            }
                        }
                    });
                return ret;

            },
            init : function(datas) {
                top.$("#sysUserPermit").find("[pr]").click(function() {
                    var checked = $(this).prop("checked");
                    var pId = $(this).prop("id");

                    top.$("#sysUserPermit").find("[pr]").each(function() {
                       if (pId == $(this).attr("pr")) {
                           $(this).prop("checked", checked);
                       }
                    });
                });
            },
            tmpl : function (datas) {
                var html = [];

                var sysUserPermit = datas.sysUserPermitMap;
                var parentSysPermit = datas.parentSysPermits;
                var sysPermit = datas.resultMap;

                html.push("<div id='sysUserPermit'>");
                html.push("<form action='/manager/sysuser/allotAuth' method='post' id='frm'>");
                html.push("<input type='hidden' name='sysUserId' value=" + datas.id + ">");
                html.push("<table rules='none' cellspacing='0' cellpadding='0' border='0px' width='100%'>");
                html.push("<tr height='30px'>");
                html.push("<td>账号: ", datas.name ,"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;角色:", datas.roleName ,"");
                html.push("</td>");
                html.push("</tr>");

                for (var p in parentSysPermit) {
                    var pId = parseInt(parentSysPermit[p].id);
                    var cked = "";
                    if (undefined != sysUserPermit) {
                        if (undefined != sysUserPermit[pId]) {
                            cked = sysUserPermit[pId].permit ? 'checked' : '';
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
                            if (undefined != sysUserPermit) {
                                var sup = sysUserPermit[sysPermits[s].id];
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
                        var frm = top.$("#sysUserPermit").find("#frm");
                        $.post("/manager/sysuser/allotAuth", frm.serialize(), function(result){
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