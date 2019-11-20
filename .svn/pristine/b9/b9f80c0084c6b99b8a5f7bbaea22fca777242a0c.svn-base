if (typeof QNR === 'undefined') {
    QNR = {};
}  
(function(){  
	
var tmpl = {

    repayPhaseDetail : {
			header : "回款详情",
    		data : true,
    		width : 700,
    		tmplId : "repayPhaseDlg",
    		dfunc : function(datas) { 
    			var ret = {};
    			if (datas.id != null) {
    				$.ajax({
        	            url : "/manager/repayPhase/queryRepayPhaseByRecordId",
        	            data : {
                            recordId : datas.id
        	            },
        	            async : false,
        	            dataType : "json",
        	            success : function(data){
        	                var ret2 = data;
        	                
        	                $.extend( ret, ret2);
        	            }
        	        });
    				ret.update = true;
    			} else {
    				ret.update = false;
    			}
    			
    			
    			return ret;
    		},
    		init : function(datas) {
    		},
    		tmpl : function (datas) {
    			var html = [];
    			html.push("<div id='repayPhaseDlg'>");


                html.push("<table class='psell_table table table-striped table-bordered table-advance'width='100%' cellspacing='0' cellpadding='0' border='0'>");
                html.push("<tbody>");
                html.push("<tr class='tr_bg' style='background-color:#d3d3d3'>");
                html.push("<th style='text-align:center' width='15%'>回款时间</th>");
                html.push("<th style='text-align:center' width='10%'>回款本金(元)</th>");
                html.push("<th style='text-align:center' width='10%'>回款利息(元)</th>");
                html.push("<th style='text-align:center' width='10%'>回款总额(元)</th>");
                html.push("<th style='text-align:center' width='10%'>状态</th>");
                html.push("</tr>");
                html.push("</tbody>");
                html.push("</table>");


                html.push("<table class='table_show table table-striped table-bordered table-hover' width='100%' cellspacing='0' cellpadding='0' border='0'>");
                html.push("<tbody id='tablelist_templete'>");


                jQuery.each(datas.data ,function (i,v) {
                    html.push("<tr>");
                    html.push("<td width='15%' align='center'>",v.repayDate,"</td>");
                    html.push("<td width='10%' align='center'>",v.repayPrincipal,"</td> ");
                    html.push("<td width='10%' align='center'>",v.repayInterest,"</td>");
                    html.push("<td width='10%' align='center'>",v.totalRepay,"</td>");
                    html.push("<td width='10%' align='center'>",v.repayStatus,"</td>");
                    html.push("</tr>");
                });

                html.push("</tbody>");
                html.push("</table>");
    			html.push("</div>");
    			return html.join("");
    		},
    		btns : [
    				{
    					   "text" : "关闭",
    					   fn : function (data) {
    						   dlg.close();
    					   },
    					   close : true
    				}
        		]
		
		},

};
QNR.tmpl  = tmpl;
})();