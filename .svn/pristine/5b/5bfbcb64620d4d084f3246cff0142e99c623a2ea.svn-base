if(typeof QNR=="undefined"){
	var QNR ={};
}


QNR.TableList=(function(){
    var q={};
    var defOpts = {
        perPageNo:{
            type:[10,20,40],
            current: 10
        },
        allSelcet: true,
        pageNo:1,
        el: "tab",
        orderBy : ""
    };
    var StaticData = function(st){
        this.st = st;
        this.st.tHeadCls = this.st.tHeadCls || 'psell_table table table-striped table-bordered table-advance';
        this.st.tBodyCls = this.st.tBodyCls || 'table_show table table-striped table-bordered table-hover';
        this.st.tHeadTrCls = this.st.tHeadTrCls || 'tr_bg';
        this.st.tToolbarCls =  this.st.tToolbarCls || 'ac_each';
        //todo: line 51 lose orderby
        this.shtml ='<table width="100%" border="0" cellspacing="0" class="'+this.st.tHeadCls+'" cellpadding="0">'+
                        '<tbody>'+
                        '<tr class="'+this.st.tHeadTrCls+'" style="background-color:#d3d3d3">'+
                        '</tr>'+
                        '</tbody></table>';
        this.tt = '<th width="${width}" class="${cls}" ${sort} style="text-align:center">${title}</th>';
    }
    /**
     * 负责数据表格title toolbar部分渲染 
     */
    StaticData.prototype.render = function(){
        //title  渲染表格title
        var titleData = this.doTitle();
        //清空内容区域 包括:title toolbar 数据区域
        jQuery("."+this.st.el+">.tab_content").empty();
        jQuery("."+this.st.el+">.tab_content").html(this.shtml);
        $.tmpl(this.tt,titleData).appendTo("."+ this.st.tHeadTrCls);
        
        //toolbar
        var toolBarData = this.doToolBar();
        // do twice for top and bottom's toolbar
        $('.psell_table').after(toolBarData);
    };
    /**
     * 准备表格数据的title列数据  以数组形式返回  还不是html
     * @return {Array<Object>} title中的列
     */
    StaticData.prototype.doTitle = function(){
        var LT = [];
        if(this.st.allSelcet){
            LT.push({title:"&nbsp;",width:"34"});
        }
        $.merge(LT,this.st.listTitle);
        return LT;
    };


    /**
     * 创建toolbar部分html 目前包括:全选 自定义按钮 每页显示数据量
     * @return {String} toolbar部分html
     */
    StaticData.prototype.doToolBar = function(){
        var html = [];
        var o = this.st;
        //allSelcet moreButton perPageNo有一个不存在就认为没有toolbar
        if(!(o.allSelcet&&o.moreButton&&o.perPageNo)){
            return html.join('');
        }
        html.push('<div class="tab_tool"><table width="100%" cellspacing="0" cellpadding="0" border="0">',
            '<tbody>',
                '<tr height="40">');
        if(o.allSelcet){
            html.push('<td width="35" class="aC"><input id="allcheck" type="checkbox" class="ck_mar" name="all_check"/></td>');
            html.push('<td width="40"><label for="allcheck">全选</label></td>');
        }
        o.moreButtonCls = o.moreButtonCls || 'ac_list';
        if(o.moreButton){
            html.push('<td width="400">');
            $.each(o.moreButton,function(i){
            	var r = false; 
            	if (o.moreButton[i].role) {
            		r = true;
            	}
            	var rk = '';
            	if (r) {
            		rk = o.moreButton[i].role_key;
            	}
                html.push('<a class="'+o.moreButtonCls+'" href="javascript:void(0)" role= ' + r + ' role-key=' + rk + '><span>'+i+'</span></a>');
            });               
            html.push('</td>');
        }
        if(o.perPageNo){
            html.push('<td class="aR"><span class="ac_each">每页显示：');
            var pn = o.perPageNo;
            for(var i=0;i<pn.type.length;i++){
                if(pn.current==pn.type[i]){
                    html.push('<a class="on" href="javascript:void(0)">'+pn.type[i]+'</a>');
                }else{
                    html.push('<a href="javascript:void(0)">'+pn.type[i]+'</a>');
                }
            }
            html.push('</span></td>');
        }
        html.push('</tr></tbody></table></div>');
        return html.join('');
    };


    var sort = function(){
        $("[sort]").click(function () {

            var w = $(this).attr("sort");
            $.each($("[sort]"),function(i){
                if(w == $(this).attr("sort")){
                    return true;
                }
                if(isEmpty($(this).attr("sort"))){
                    return true;
                }
                $(this).removeClass("desc");
                $(this).removeClass("asc");
                $(this).removeClass("activ");
                $(this).addClass("sorting");

            });

            if($(this).hasClass("sorting")){
                $(this).removeClass("sorting");
                $(this).addClass("desc activ");

            }else if($(this).hasClass("desc")){
                $(this).removeClass("desc");
                $(this).addClass("asc activ");
            }else{
                $(this).removeClass("asc");
                $(this).addClass("desc activ");
            }
            q.TableList.query();
        });
    };

    q.TableList = {
        setting : {},
        ids : [],
        totalRows : 0 ,
        U : {
            /**
             * 在接口url上添加要请求的页数和一页显示多少数据量还有orderby信息 
             */
            parseURL : function(){
                var url = q.TableList.setting.queryURL;
                var o = q.TableList.setting;
                if(url.split("?").length>1){
                    url += "&pageNo="+o.pageNo+"&perPageNo="+o.perPageNo.current;
                }else{
                    url += "?pageNo="+o.pageNo+"&perPageNo="+o.perPageNo.current;
                }
                //each theader
                $.each($("[sort]"),function(i){
                    if($(this).hasClass("activ")){
                        var sortBy = $(this).attr("sort");
                        sortBy = sortBy.split("'");
                        if($(this).hasClass("desc")){
                            url += "&sortField=" + sortBy[1] + "&orderBy=desc";
                        }else if($(this).hasClass("asc")) {
                            url += "&sortField=" + sortBy[1] + "&orderBy=asc";
                        }
                    }else{
                        return true;
                    }
                });

                return url;
            },
            removeArr : function(arr,del){
                var temp = [];
                $.each(arr,function(i,n){
                    if(!(n == del)){
                        temp.push(n);
                    }
                });
                return temp;
            }
        },
        init : function(opts){
            $.extend(defOpts,opts);
            q.TableList.setting = defOpts;
            //render title toolbar && addEvent
            var st = new StaticData(q.TableList.setting);
            //负责数据表格title toolbar部分渲染 
            st.render();
            q.TableList.addSaticEvt();
            
            //query data
            q.TableList.addDyEvt();

            sort();
            
            q.TableList.query();
            
        },
        /**
         * @param {String} 请求接口url 如果不传 默认使用q.TableList.setting.queryURL
         */
        query : function(queryURL){
            queryURL && (q.TableList.setting.queryURL = queryURL); 
            var self =this;
            //在接口url上添加要请求的页数和一页显示多少数据量还有orderby信息 
            var url = this.U.parseURL();
            this.ids = [];
            $.getJSON(url,function(data){
                if(!!data && !!data.ret){
                    q.TableList.totalRows = data.data.totalRows;
                    if($("#page").size()){
                        //#tablelist_templete数据区域tbody
                        $("#tablelist_templete").empty();
                    }
                    self.drawFooter();
                    self.drawTemplete(data.data);
                    if (self.setting.totalHeaderId) {
                    	self.drawTotalHeader(data.data.actualCount);	
                    }
                    if (self.setting.totalFooterId) {
                    	self.drawTotalFooter(data.data.totalRows);
                    }
                    if(self.setting.statistics){
                    	self.statistics(data);
                    }
                    $(".product_sell_table_no").remove();
                }else{
                    var containter = '<div class="product_sell_table_no" style="margin-left: 40%;margin-top: 10%;margin-bottom: 10%;font-size: 18px;color: gray;"><p>'+data.errmsg+'</p></div>';
                    if($(".tab_tool").size() > 0) {
                        $(".product_sell_table_no").remove();
                        $(".tab_tool").eq(0).after(containter);
                    } else{
                        $(".product_sell_table_no").remove();
                        $('.'+self.setting.tHeadCls).html(containter);
                        $('#nc').empty();
                        $('#nc').html(containter);
                    }
                    $('#tablelist_templete').empty();
                    $("#page").empty();
                    $("#statistics_header").attr("style","display:none");
                }
                
                $(self).trigger('init_finished');

                if (q.TableList.setting.afterQuery != null) {
                    q.TableList.setting.afterQuery();
                }
                
            });
            
        },
        drawTotalHeader : function(d) {
        	$("#statistics_header").attr("style","");
        	$("#statistics_header").empty();
        	var headParam = [{actualCount:d}];
        	var tmpl = $("#"+q.TableList.setting.totalHeaderId).tmpl(headParam);
            tmpl.appendTo("#statistics_header");
        },
        statistics : function(d) {
        	// 统计模块
        	$("#releaseSpan").text(d.releaseCount);
        	$("#toBeReleasedSpan").text(d.toBeReleasedCount);
        	$("#draftSpan").text(d.draftCount);
        	$("#OfflineSpan").text(d.OfflineCount);
        },
        drawTotalFooter : function(d) {
        	var ctrs = [];
        	$("#tablelist_footer_table").remove();
        	ctrs.push("<table id='tablelist_footer_table' width='100%' cellspacing='0' cellpadding='0' border='0' style='margin-top:10px;margin-bottom:10px'>");
        	ctrs.push("<tbody id='tablelist_footer'>");
        	ctrs.push("</tbody>");
        	ctrs.push("</table>");

        	 $('.table_show').after(ctrs.join(""));
        	 
        	var tmpl = $("#"+q.TableList.setting.totalFooterId).tmpl(d);
            tmpl.appendTo("#tablelist_footer");
        },
        /**
         * 数据部分渲染 
         */
        drawTemplete : function(d){
        	var data = [];
        	var content = [];
            var containter = '<div width="100%" cellspacing="0" cellpadding="0" border="0" class="'+q.TableList.setting.tBodyCls+'"><div id="tablelist_templete"></div></div>';
            var tmpl;
            if($(".tab_tool").size() > 0) {
                $(".tab_tool").eq(0).after(containter);
            }else{
            	$('.psell_table').after(containter);
                
            }
            if(!$("#"+q.TableList.setting.tempId).length){
               //什么情况会走这里?
               //reply  :  当模板比较复杂 需要根据回来的数据渲染的时候就会走这一步  by jieqing.song
               // 此时外面的options 里面定义一个动态template模块 方法名就叫 : templete
               for(var c  in d){
                  var templete = q.TableList.setting.templete(d[c]);
                  tmpl = $(templete).tmpl(d[c]);
                  tmpl.appendTo("#tablelist_templete");
               }
            }else{
            	//var eachData = { users: [{ name: 'jerry' }, { name: 'john'}]};
                tmpl = $("#"+q.TableList.setting.tempId).tmpl(d);
                if(q.TableList.setting.tempId == "indexListTemplate"){
                    $("#indexContent").empty();
                    tmpl.appendTo("#indexContent");
                }else if(q.TableList.setting.tempId == "lableTemplate"){
                    $("#tab").empty();
                    tmpl.appendTo("#tab");
                }else {
                    tmpl.appendTo("#tablelist_templete");
                }
            }
           
            //$.tmpl(q.TableList.setting.tempId,d).appendTo("#tablelist_templete");
        },
        /**
         * 翻页区域渲染 
         */
        drawFooter : function(){
            $("#page").pager({
                recordCount : q.TableList.totalRows ,
                dispOmi:true,
                dispNum: 3,
                currentPage : q.TableList.setting.pageNo, 
                pageSize : q.TableList.setting.perPageNo.current,
                on : {
                    select : function(pageno){
                        q.TableList.setting.pageNo = pageno;
                        q.TableList.query();
                    }
                }
            });
        },
        //注册全选  自定义按钮 每页显示数据量 click
        addSaticEvt : function(){
            //selectAll
            $(":checkbox[name=all_check]").change(function(){
                var $t = $(this);
                if($t.prop("checked")){
                    q.TableList.ids = [];
                    $(":checkbox[name=checkbox2]").prop("checked", true)
                    $(":checkbox[name=checkbox2]").each(function(){
                        var $_t = $(this);
                        q.TableList.ids.push($_t.attr("data-id"));
                    });
                }else{
                    $(":checkbox[name=checkbox2]").prop("checked", false);
                    q.TableList.ids = [];
                }
            });
            //perPageNo
            $(".tab_tool").find("."+q.TableList.setting.tToolbarCls+">a").click(function(){
                var $t = $(this);
                $(".tab_tool").find("."+q.TableList.setting.tToolbarCls+">a").each(function(){
                    var $tt = $(this);
                    $tt.removeClass("on");
                    if($tt.text() == $t.text()){
                        $tt.addClass("on");
                    }
                });
                q.TableList.setting.pageNo = 1;
                q.TableList.setting.perPageNo.current = parseInt($t.text(),10) ;
                q.TableList.query();
            });

            //toolbar
            $(".tab_tool ."+q.TableList.setting.moreButtonCls).each(function(i){
                $(this).click(function(){
                    var $el = $(this),
                        length = $("."+q.TableList.setting.moreButtonCls).length/2,
                        key = $el.text(),
                        fun = q.TableList.setting.moreButton[key].func;
	                    var s =  $(":checkbox[name=checkbox2]:checked").size();
	                    if(s>0){
	                        if(fun) fun.call(self);
	                    }else{
	                        alert("请至少选择一个！");
	                        return false;
	                    }
                })
            });
            
            $()
            //orderby
            
        },
        /**
         * 为每个数据项的checkbox注册change事件
         */
        addDyEvt : function(){
            //checkbox
        	
        },
        /**
         * 卸载每个数据项的checkbox的change事件
         */
        removeDyEvt : function(){
//            $(":checkbox[name=checkbox2]").die("change");
        },
        /**
         * 恢复配置参数页数相关信息(toolbar中每页显示数据项,当前每页显示数据量,当前页)成默认 
         * 卸载每个数据项的checkbox的change事件
         */
        refresh : function(){
            var initSetting = { 
                perPageNo:{
                    type:[10,20,40],
                    current: 10
                },
                pageNo:1
            };
            $.extend(q.TableList.setting,initSetting);
            q.TableList.removeDyEvt();
        },
        /**
         * 恢复配置参数页数相关信息(toolbar中每页显示数据项,当前每页显示数据量,当前页)成默认 
         */
        restoreDefault: function(){
            var initSetting = { 
                perPageNo:{
                    type:[10,20,40],
                    current: 10
                },
                pageNo:1
            };
            $.extend(q.TableList.setting, initSetting);
            
            //全选按钮恢复未勾选状态
            $(":checkbox[name=all_check]").attr("checked", false);
        },
        fire: function(evtType) {
            $(q.TableList).trigger(evtType);
        },
        bind: function(evtType, evtFn) {
            $(q.TableList).bind(evtType, evtFn);
        },
        init_finished : function() {
        	if (typeof this.setting.init_finished != "undefined") {
        		this.setting.init_finished();
        	}
        	
        	$(":checkbox[name=checkbox2]").change(function(){
        		var $t =$(this);
                var cid = $t.attr("data-id");
                if($t.prop("checked")){
                    q.TableList.ids.push(cid);
                }else{
                    var arr = q.TableList.ids;
                    var newArr = q.TableList.U.removeArr(arr,cid);
                    q.TableList.ids = newArr;
                }
        	});
        }
    }
    q.TableList.on = q.TableList.bind;
    
    return q.TableList;
})();
