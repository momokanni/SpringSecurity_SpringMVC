if (typeof QNR === 'undefined') {
    QNR = {};
}
(function(){
    var tmpl = {
    	bmPwdReset: {
            header: "重置密码",
            data: true,
            width: 800,
            tmplId: "bmPwdReset",
            dfunc: function (datas) {
                var ret = datas;
                return ret;
            },
            init: function (datas) {
                top.$("#bmPwdReset").find("[mi]").css("display", "");
            },
            tmpl: function (datas) {
                var html = [];
                html.push("<div class='modal-body'>");
                html.push("		<form action='/manager/blogManager/pwdReset' method='post' id='frm'>");
                html.push("			<input type='hidden' name='id' value=" + datas.id + ">");
                html.push("			<table rules='none' cellspacing='0' cellpadding='0' border='0px' width='100%' class='table'>");
                html.push("				<tbody>");
                html.push("					<tr>");
                html.push("						<td width='5%'></td>");
                html.push("						<td width='80%'>");
                html.push("							<div class='form-group'>");
                html.push("								<label class='control-label col-md-3'>新密码:");
                html.push("									<span class='required' aria-required='true'> * </span>");
                html.push("								</label>");
                html.push("								<div class='col-md-5'>");
                html.push("									<input type='password' class='form-control' id='pwd' name='pwd' value=''>");
                html.push("								</div>");
                html.push("							</div>");
                html.push("						</td>");
                html.push("						<td width='5%'></td>");
                html.push("					</tr>");
                html.push("					<tr>");
                html.push("						<td width='5%'></td>");
                html.push("						<td width='80%'>");
                html.push("							<div class='form-group'>");
                html.push("								<label class='control-label col-md-3'>确认密码:");
                html.push("									<span class='required' aria-required='true'> * </span>");
                html.push("								</label>");
                html.push("								<div class='col-md-5'>");
                html.push("									<input type='password' class='form-control' id='confirmPwd' name='confirmPwd' value=''>");
                html.push("								</div>");
                html.push("							</div>");
                html.push("						</td>");
                html.push("						<td width='5%'></td>");
                html.push("					</tr>");
                html.push("					<tr>");
                html.push("						<td width='5%'></td>");
                html.push("						<td width='5%'></td>");
                html.push("					</tr></tbody></table></form></div>");
                return html.join("");
            },
            btns: [
                {
                    "text": "重置",
                    fn: function (data, self) {
                        var newPwd = top.$("#pwd").val();
                        var confirmPwd = top.$("#confirmPwd").val();
                        if (isEmpty(newPwd)) {
                            bootAlert("新密码不能为空");
                            return;
                        } else if(isEmpty(confirmPwd)){
                        	bootAlert("确认密码不能为空");
                        	return;
                        } else if(confirmPwd != newPwd){
                        	bootAlert("两次密码不一致");
                        	return;
                        } else {
                            var url = top.$("#frm").prop("action");
                            var param = top.$("#frm").serialize();
                            $.post(url, param,
                                    function(result){
                                        if (1 == result.ret) {
                                            bootAlert(result.message, function(){
                                                QNR.TableList.query();
                                            });
                                            dlg.close();
                                        } else {
                                            if (result.errmsg == '') {
                                                bootAlert("重置失败");
                                            } else {
                                                bootAlert(result.errmsg);
                                            }
                                        }
                                    },"json");
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

        }
    };

    QNR.tmpl  = tmpl;
})();