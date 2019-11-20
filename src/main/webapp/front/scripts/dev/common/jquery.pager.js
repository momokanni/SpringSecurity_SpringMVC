/*
depend: jquery_tmpl

options : 
-tmpl : 指定模板进行渲染
-on : {
    select : function( pageno ){}  //选择页码
 } , 
 buttons : {        //隐藏按钮
    first : false,    
    last : false
 }
-dispOmi : {boolean} 将页面以省略形式输出,　如 1...4,5,6...10
-dispNum : {number} 显示当前页码前后页码的数量，如设置为1,当前页码为５就是 1...4,5,6...10。
-recordCount : 设置总条数
-pageSize : 设置每页个数
-currentPage : 设置当前页码

默认模板为
<div class="pager">
    <a href="#" data-pager-link="first">第一页</a>
    <a href="#" data-pager-link="prev">上一页</a>
    {{each(idx,page) pages}}
        {{if page.type == "page"}}
        <a href="#" data-pager-pageno="${page.no}">${page.no}</a>   
        {{/if}}
        {{if page.type == "curr"}}
        <em>${page.no}</em>
        {{/if}}
        {{if page.type == "omission"}}
        ...
        {{/if}}
    {{/each}}
    <a href="#" data-pager-link="next">下一页</a>
    <a href="#" data-pager-link="last">最后一页</a>
    <span class="ps">共${pageCount}页</span>
</div>

*/

(function($){

var Pager = function( $elem , options ) {
    this.$elem = $elem;
    this.options = options;
}

Pager.prototype.selectPage = function( pageNo ) {
    this.options.currentPage = pageNo;
    this.render();
}

Pager.prototype.renderData = function() {
    var opt = this.options;
	opt.recordCount = parseInt( opt.recordCount , 10 );
	opt.currentPage = parseInt( opt.currentPage , 10 );
	 
    var pages = [];
    var pagecount = Math.floor( opt.recordCount / opt.pageSize ) + ( opt.recordCount % opt.pageSize == 0 ? 0 : 1 );
    var prefix_omi = false;
    var suffix_omi = false;

    opt.pageCount = pagecount;  
    for( var i = 1; i <= pagecount; i++ ) {
    
        var p = {
            type : 'page' ,
            no : i,
            currentPage: opt.currentPage, 
            recordCount: opt.recordCount
        };

        if ( i == opt.currentPage ) {
            p.type = 'curr';
        }
        
        if ( opt.dispOmi ) {
        
            if ( i < opt.currentPage - opt.dispNum ) { 
                if ( i == 1 ) {
                } else if ( !prefix_omi ){
                    p.type = 'omission';
                    p.no = null;
                    prefix_omi = true;                
                } else {
                    continue;
                }
            }
            
            if ( i > opt.currentPage + opt.dispNum ) {
                if ( i == pagecount ) {
                } else if ( !suffix_omi ) {
                    p.type = 'omission';
                    p.no = null;
                    suffix_omi = true;
                } else {
                    continue;
                }
            }
            
        }
        
        pages.push(p);
    }
    
    return $.extend({
        pages : pages 
    },opt);

}

Pager.prototype.bind = function(){
    
    var self = this;
    var opt = this.options; 
    
    //数字 切页
    this.$elem.find("[data-pager-pageno]").click(function(){
        var pn = $(this).attr("data-pager-pageno");
        self.selectPage( parseInt( pn , 10 ) );
        if( opt.on && opt.on.select ) {
            opt.on.select.call( self , pn );
        }
        return true;
    });
       
    //按钮　切页 
    this.$elem.find("[data-pager-link]").click(function(){
    
        var type = $(this).attr("data-pager-link");
        
        switch ( type ) {
            case 'first':
                var pn = 1;
                break;
            case 'prev':
                var pn = opt.currentPage - 1;
                
                break;
            case 'next':
                var pn = opt.currentPage + 1;
                
                break;
            case 'last':
                var pn = opt.pageCount;
                break;
        }
        
        self.selectPage( parseInt( pn , 10 ) );
        if( opt.on && opt.on.select ) {
            opt.on.select.call( self , pn );
        }
        
        return false;
    });
    
    //隐藏按钮
    this.$elem.find("[data-pager-link]").each(function(){
        
        var type = $(this).attr("data-pager-link");
        
        switch ( type ) {
            case 'first':
                if( opt.currentPage > 1 ) {
                    $(this).attr("disabled",false);
                } else {
                    $(this).attr("disabled",true);
                    $(this).attr("style","color:#9e9e9e;font-weight:bold;pointer-events:none;");
                }
                break;
            case 'prev':
                if( opt.currentPage - 1 >= 1 ) {
                    $(this).attr("disabled",false);
                } else {
                    $(this).attr("disabled",true);
                    $(this).attr("style","pointer-events:none;");
                }
                break;
            case 'next':
                if( opt.currentPage + 1 <= opt.pageCount ) {
                    $(this).attr("disabled",false);
                } else {
                    $(this).attr("disabled",true);
                    $(this).attr("style","pointer-events:none;");
                }
                break;
            case 'last':
                if( opt.currentPage < opt.pageCount ) {
                    $(this).attr("disabled",false);
                } else {
                    $(this).attr("disabled",true);
                    $(this).attr("style","color:#9e9e9e;font-weight:bold;pointer-events:none;");
                }
                break;
        }
        
        if ( opt.buttons && opt.buttons[ type ] == false ) {
            $(this).attr("disabled",true);
            $(this).attr("pointer-events","none");
        }
    
    });

}
 

Pager.prototype.render = function() {
    
    var $elem = this.$elem;
    var opt = this.options;

    if ( !opt.recordCount ) return;
    
    $elem.empty();
    
    this.curData = this.renderData();
    if ( opt.tmpl) {
      if (opt.tmpl.tmpl) {  
        opt.tmpl.tmpl( this.curData ).appendTo( $elem );
      } else {
        $.tmpl( $.template( null , opt.tmpl ) , this.curData ).appendTo( $elem );
      }
    } else {
        var tmpl = $.template( null , defaultTmpl );
        $.tmpl( tmpl , this.curData ).appendTo( $elem );
    }

    this.bind();

}


var defaultTmpl = '<a href="#" data-pager-link="first" style="font-weight:bold;"><<</a>\
        <a class="pagePrev" href="#" data-pager-link="prev"><b></b></a>\
        {{each(idx,page) pages}}\
            {{if page.type == "page"}}\
            <a href="#" data-pager-pageno="${page.no}">${page.no}</a>   \
            {{/if}}\
            {{if page.type == "curr"}}\
            <a href="#" class="hov" data-pager-pageno="${page.no}" class="on">${page.no}</a>   \
            {{/if}}\
            {{if page.type == "omission"}}\
            ...\
            {{/if}}\
        {{/each}}\
        <a href="#" class="pageNext" data-pager-link="next"><b></b></a>\
        <a href="#" data-pager-link="last" style="font-weight:bold;">>></a>\
';

jQuery.fn.pager = function( options ){
    
    options = $.extend({
        currentPage : 1 ,
        pageSize : 10 , 
        dispNum : 5 , 
        dispOmi : true 
    }, options || {});
    
    return $(this).each(function(){

        var self = this;
        var $self = $(this);
        
        var pager = new Pager( $(this) , options );
		
		$self.data( 'pager', pager );
        
        pager.render();
        
    });
}

})(jQuery);
