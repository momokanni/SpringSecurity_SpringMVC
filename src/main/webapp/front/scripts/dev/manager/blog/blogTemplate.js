if (typeof QNR === 'undefined') {
    QNR = {};
}

(function(){
    var tmpl = {
        addSysUser: {
            header: "创建用户",
            data: true,
            width: 800,
            tmplId: "addSysUser",
            dfunc: function (datas) {
                var ret = {};
                return ret;
            },
            init: function (datas) {
            	var html = [];
                top.$("#addSysUser").find("[mi]").css("display", "");
                top.$("#addSysUser").find("input[type='radio']").click(function(){
                	var blogType = top.$("#addSysUser").find("input[type='radio']:checked").val();
                	if (blogType == "1"){
                        top.$("#addSysUser").find("#enterpriseType").attr("style","");
                        top.$("#addSysUser").find("#enterpriseName").attr("style","");
                	} else {
                		top.$("#addSysUser").find("#enterpriseType").attr("style","display:none");
                        top.$("#addSysUser").find("#enterpriseName").attr("style","display:none");
                	}
                });
            },
            tmpl: function (datas) {
                var html = [];

                html.push("<div id='addSysUser'>");
                html.push("<form action='/manager/blog/create' method='post' id='frm'>");
                html.push("		<table rules='none' cellspacing='0' cellpadding='0' border='0px' width='100%' class='table'>");
                html.push("			<tbody>");
                html.push("				<tr>");
                html.push("					<td width='5%'></td>");
                html.push("					<td width='80%' align='right'>");
                html.push("						<div class='form-group'>");
                html.push("							<label class='control-label col-md-3'>用户类型:");
                html.push("								<span class='required' aria-required='true'> * </span>");
                html.push("							</label>");
                html.push("						<div class='col-md-4'>");
                html.push("							<div class='mt-radio-inline'>");
                html.push("								<label class='mt-radio'>");
                html.push("									<input type='radio' id='type1' name='blogType' class='sysBlogType' value='0'>个人账号");
                html.push("									<span></span>");
                html.push("								</label>");
                html.push("								<label class='mt-radio'>");
                html.push("									<input type='radio' id='type2' name='blogType' class='sysBlogType' value='1'>公司账号");
                html.push("									<span></span>");
                html.push("								</label></div></div></div></td>");
                html.push("					<td width='5%'></td>");
                html.push("			 </tr>");
                
                html.push("			<tr id='enterpriseType' style='display:none;'>");
                html.push("				<td width='5%'></td>");
                html.push("				<td width='80%' align='right'>");
                html.push("					<div class='form-group'>");
                html.push("						<label class='control-label col-md-3'>企业类型:");
                html.push("							<span class='required' aria-required='true'> * </span>");
                html.push("						</label>");
                html.push("					<div class='col-md-4'>");
                html.push("						<div class='mt-radio-inline'>");
                html.push("							<label class='mt-radio'>");
                html.push("								<input type='radio' id='enterpriseType1' name='enterpriseType' class='sysEnType' value='0'>个体商户");
                html.push("								<span></span>");
                html.push("							</label>");
                html.push("							<label class='mt-radio'>");
                html.push("								<input type='radio' id='enterpriseType2' name='enterpriseType' class='sysEnType' value='1'>企业");
                html.push("								<span></span>");
                html.push("							</label></div></div></div></td>");
                html.push("				<td width='5%'></td>");
                html.push("		  </tr>");
        		html.push("		  <tr id='enterpriseName' style='display:none'>");
                html.push("			<td width='5%'></td>");
                html.push("			<td width='80%' align='right'>");
                html.push("				<div class='form-group'>");
                html.push("					<label class='control-label col-md-3'>企业名称:");
                html.push("						<span class='required' aria-required='true'> * </span>");
                html.push("					</label>");
                html.push("				<div class='col-md-5'>");
                html.push("					<input type='text'  class='form-control' id='enterpriseNameInput' name='enterpriseName' value=''>");
                html.push("				</div></div></td>");
                html.push("			<td width='5%'></td>");
                html.push("		 </tr>");
                
                html.push("			 <tr>");
                html.push("				<td width='5%'></td>");
                html.push("				<td width='80%' align='right'>");
                html.push("					<div class='form-group'>");
                html.push("						<label class='control-label col-md-3'>管理员名称:");
                html.push("							<span class='required' aria-required='true'> * </span>");
                html.push("						</label>");
                html.push("					<div class='col-md-5'>");
                html.push("						<input type='text'  class='form-control' id='managerName' name='managerName' value=''>");
                html.push("					</div></div></td>");
                html.push("				<td width='5%'></td>");
                html.push("			</tr>");
                html.push("			<tr>");
                html.push("				<td width='5%'></td>");
                html.push("				<td width='80%' align='right'>");
                html.push("					<div class='form-group'>");
                html.push("						<label class='control-label col-md-3'>昵称:");
                html.push("							<span class='required' aria-required='true'> * </span>");
                html.push("						</label>");
                html.push("					<div class='col-md-5'>");
                html.push("						<input type='text'  class='form-control' id='managerNickName' name='managerNickName' value=''>");
                html.push(" 			</div></div></td>");
                html.push("				<td width='5%'></td>");
                html.push("			</tr>");
                html.push("			<tr>");
                html.push("				<td width='5%'></td>");
                html.push("			</tr>");
                html.push("			<tr>");
                html.push("				<td width='5%'></td>");
                html.push("				<td width='80%' align='right'>");
                html.push("					<div class='form-group'>");
                html.push("						<label class='control-label col-md-3'>手机号:");
                html.push("							<span class='required' aria-required='true'> * </span>");
                html.push("						</label>");
                html.push("					<div class='col-md-5'>");
                html.push("						<input type='text'  class='form-control' id='sysUserMobile' name='mobile' value=''>");
                html.push("				</div></div></td>");
                html.push("				<td width='5%'></td>");
                html.push("		   </tr>");
                html.push(" </tbody></table></form></div>");
                return html.join("");
            },
            btns: [
                {
                    "text": "创建",
                    fn: function (data, self) {
                    	// 用户类型
                        var blogType = top.$(".sysBlogType:checked").val();
                        // 管理员名称
                        var managerName = top.$("#managerName").val();
                        // 管理员昵称
                        var nickName = top.$("#managerNickName").val();
                        // 手机号
                        var mobile = top.$("#sysUserMobile").val();
                        // 企业类型
                        var enType = top.$(".sysEnType:checked").val();
                        // 企业名称
                        var enterpriseName = top.$("#enterpriseNameInput").val();

                        if (isEmpty(blogType)) {
                            bootAlert("用户类型不能为空");
                        } else if(!isEmpty(blogType) && blogType == "1" && isEmpty(enType)){
                        	bootAlert("企业类型不能为空");
                        } else if(!isEmpty(blogType) && blogType == "1" && isEmpty(enterpriseName)){
                        	bootAlert("企业名称不能为空");
                        } else if (isEmpty(managerName)) {
                            bootAlert("管理员名称不能为空");
                        } else if (isEmpty(nickName)) {
                            bootAlert("昵称不能为空");
                        } else if (!isEmpty(mobile) && !isMobile(mobile)) {
                            bootAlert("手机号格式错误");
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
                    "text": "取消",
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
        }
    };

    QNR.tmpl  = tmpl;
})();