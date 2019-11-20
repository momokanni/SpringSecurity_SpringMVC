(function(win, undefined) {
    var $ = win.jQuery, is;

    $("#subSet").addClass("menuli_in");
    $(".menu_home").removeClass("menu_home_in");

    function commonTimeout(){
        setTimeout(function() {
            location.href = "/blog/subaccountSetting";
        }, 1000);
    }

    $("a[op=tjzzh]").click(function(){
        $('#addSub').removeClass("dn");
    });

    $("a[op=qx]").click(function(){
        $('#addSub').addClass("dn");
    });


    $("a[op=topqx]").click(function(){
        $('#addSub').addClass("dn");
    });

    $("#mainbody").delegate("a[op=czmm]","click",function () {
        var c =  $(this).attr("c");
        $("#subBlogManagerId").val(c);
        $('#rest').removeClass("dn");
    });

    $("a[op=qxcz]").click(function(){
        $('#rest').addClass("dn");
    });
    
    $(".authCancel").click(function(){
    	$('#authDiv').addClass("dn");
    });
    
    $(".authElement").click(function(){
    	$('#authDiv').removeClass("dn");
    	var bmId = $(this).attr("bmId");
    	$.ajax({
    		url:"/blog/getAuthorizes",
    		type:"get",
    		data:{"bmId":bmId},
    		dataType:"json",
    		success:function(data){
    			if (1 == data.ret) {
    				authTree(data.data,bmId);
    			} else {
    				errorTips(data.errmsg);
    			}
    			
    		}
    	});
    });
    
    var authIds = [];
    var authTree = function(data,bmId){
    	layui.use([ 'tree', 'util' ], function() {
			var tree = layui.tree, layer = layui.layer, util = layui.util
			data = data;

			// 基本演示
			tree.render({
				elem : '#test12',
				data : data,
				showCheckbox : true, // 是否显示复选框
				id : 'demoId1',
				isJump : false, // 是否允许点击节点时弹出新窗口跳转
				click : function(obj) {
					/*
					 * var data = obj.data; // 获取当前点击的节点数据 layer.msg('状态：' +
					 * obj.state + '<br>节点数据：' + JSON.stringify(data));
					 */
				}
			});
			
		  	// 按钮事件
			util.event('lay-demo', {
				getChecked : function(othis) {
					var checkedData = tree.getChecked('demoId1'); // 获取选中节点的数据
					for(var i = 0; i < checkedData.length; i++){
						authIds.push(checkedData[i].id);
						if(checkedData[i].children != null){
							childTree(checkedData[i].children);
						}
					}
					$.ajax({
						url:"/blog/subAccountBatchAuth",
						type:"POST",
						traditional: true,
						data:{"ids":authIds.length > 0 ? authIds : null,"bmId":bmId},
						dataType:"json",
						success:function(data){
							if (data.ret == 1) {
								$('#authDiv').addClass("dn");
								successTips("授权成功");
							} else {
								$('#authDiv').addClass("dn");
								 errorTips("授权失败");
							}
							setTimeout(window.location.reload(),3000);
						},
						error:function(data){
							$('#authDiv').addClass("dn");
							 errorTips("授权失败");
							 setTimeout(window.location.reload(),3000);
						}
					});
				},
				setChecked : function() {
					tree.setChecked('demoId1', [ 12, 16 ]); // 勾选指定节点
				},
				reload : function() {
					// 重载实例
					tree.reload('demoId1', {

					});
				}
			});
		});
    }
    
    var childTree = function(children){
    	children = JSON.stringify(children);
    	children = JSON.parse(children);
    	for(var i = 0; i < children.length; i++){
    		authIds.push(children[i].id);
        	if(children[i].children != null){
        		childTree(children[i].children);
        	}
    	}
    }

    var canSub = true;
    // 创建子账号
    $("a[op=cj]").click(function(){
        if (!canSub) {
            return false;
        }
        canSub = false;
        var name=$("#name").val();
        if(isEmpty(name)){
            errorTips("姓名不可为空");
            canSub = true;
            return false;
        }else if(name.length>5){
            errorTips("姓名不可超过5个字符");
            canSub = true;
            return false;
        }

        var nickName=$("#nickName").val();
        if(isEmpty(nickName)){
            errorTips("昵称不可为空");
            canSub = true;
            return false;
        }else if(nickName.length>10){
            errorTips("昵称不可超过10个字符");
            canSub = true;
            return false;
        }

        var frm = $("#frm");
        var opts = {};
        opts.url= frm.attr("action");
        opts.success = function(data) {
            if (data.ret == 1) {
                successTips("创建子账号成功");
                commonTimeout();
            } else {
                if (data.errmsg == "") {
                    errorTips("操作失败");
                } else {
                    errorTips(data.errmsg);
                }
                canSub = true;
            }
        }
        _jsonSubmit(frm, opts);
        return false;
    });

    $("#qdcz").click(function () {
        $('#rest').addClass("dn");
        var frm = $("#frmpwd");
        var opts = {};
        opts.url= frm.attr("action");
        opts.success = function(data) {
            if (data.ret == 1) {
                successTips("重置密码成功");
                commonTimeout();
            } else {
                b = true;
                if (data.errmsg == "") {
                    errorTips("操作失败");
                } else {
                    errorTips(data.errmsg);
                }
            }
        }
        _jsonSubmit(frm, opts);
    });

    var pageInit = function() {}
    $(pageInit);
})(window);
