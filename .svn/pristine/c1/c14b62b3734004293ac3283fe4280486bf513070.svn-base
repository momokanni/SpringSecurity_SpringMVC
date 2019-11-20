if (typeof QNR === 'undefined') {
    QNR = {};
}

(function(){
	var blogId = null;
    var tmpl = {
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
        upBlogStatusOff : {
            header : "账号禁用",
            data : true,
            width : 800,
            tmplId : "upBlogStatusOff",
            dfunc : function(datas) {
                var ret = {};
                return ret;

            },
            init : function(datas) {
            },
            tmpl : function (datas) {
                var html = [];

                html.push("<div>");
                html.push("<input type='hidden' name='id' value=" + datas.id + ">");
                html.push("	<span>确认禁用该账号？</span>");
                html.push("</div>");

                return html.join("");
            },
            btns : [
                {
                    "text" : "禁用",
                    fn : function (data, self) {
                        var blogId = top.$("input[name='id']").val();
                        $.post("/manager/blog/updateStatus", {id:blogId}, function(result){
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
                    "text" : "取消",
                    fn : function (data) {
                        dlg.close();
                    },
                    close : true
                }
            ]
        },
        blogRolePermit : {
            header : "设置权限",
            data : true,
            width : 800,
            tmplId : "sysRolePermit",
            dfunc : function(datas) {
                var ret = {};
                    $.ajax({
                        url : "/manager/blogPermit/getAllPermission",
                        dataType : "json",
                        type : "GET",
                        async : false,
                        data: {
                        	"id": datas.id
                        },
                        success : function(result) {
                        	if (1 == result.ret) {
                                var ret2 = JSON.parse(result.data);
                                blogId = result.blogId;
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

                html.push("<div id='sysRolePermit'>");
                html.push("<form action='#' method='post' id='frm'>");
                html.push("<input type='hidden' name='blogId' value=" + blogId + ">");
                html.push("<table rules='none' cellspacing='0' cellpadding='0' border='0px' width='100%'>");

                for (var p in datas) {
                    var pId = parseInt(datas[p].id);
                    var cked = datas[p].checked;
                    if(cked == undefined){
                    	continue;
                    }
                    html.push("<tr height='30px'>");
                    html.push("	 <td>");
                    html.push("		<label class='mt-checkbox'>");
                    html.push("			<input type='checkbox' checked='" + cked + "' pr='0' value='", pId ,"' class='' name='blogPermitId' id='", pId ,"'/>",datas[p].title,"");
                    html.push("			<span></span>");
                    html.push("		</label>");

                    var sysPermits = datas[p].children;
                    if (undefined != sysPermits) {
                        child(sysPermits,html,pId);
                    }
                    html.push("</td>");
                    html.push("</tr>")
                }
                html.push("</table></form></div>");

                return html.join("");
            },
            _bindEvents:function(){
            	
            },
            btns : [
                {
                    "text" : "确定",
                    fn : function (data, self) {
                        var frm = top.$("#sysRolePermit").find("#frm");
                        $.post("/manager/blogPermit/addAuth", frm.serialize(), function(result){
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
    
    var child = function(sysPermits,html,pId){
    	var br = true;
        for (var s = 0; s < sysPermits.length; s++) {
            if (s != 0 && s % 5 == 0) {
                br = true;
            }
            if (br) {
                html.push("<tr height='30px'>");
                br = false;
            }
            
            var level = parseInt(sysPermits[s].level);
        	var space = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
        	for(var l = 0; l < level; l++){
        		space += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
        	}
            var cked = sysPermits[s].checked ? 'checked' : '';
            html.push("<td>");
            html.push(space);
            html.push("<label class='mt-checkbox'>");
            html.push("<input type='checkbox' " + cked + " pr='", pId ,"' value='", sysPermits[s].id ,"' name='blogPermitId' id='", sysPermits[s].id ,"' />", sysPermits[s].title  ,"");
            html.push("<span></span>");
            html.push("</label>");
            html.push("</td>");
            var childs = sysPermits[s].children
            if (undefined != childs) {
            	child(childs,html,pId);
            }
            if (s == sysPermits.length - 1) {
                br = true;
            }
            if (br) {
                html.push("</tr>");
                br = false;
            }
        }
    }
    QNR.tmpl  = tmpl;
})();