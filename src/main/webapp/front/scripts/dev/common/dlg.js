/**
 * 对话框样式已独立出来
 * 位置:styles/common/dlg.css
 * 
 * @class Dlg 
 * @see Simple popup dialog
 * @require jQuery, order page CSS
 * @config:
 *    width
 *    bgcolor
 *    opacity
 * 
 * @custom events:
 *    beforeshow
 *    aftershow
 *    beforeclose
 *    afterclose
 *
 * @use
 *    Show a dialog:
 *    
 *    var dlg = new Dlg({ width:400 });
 *    dlg.setBody('<p>Dialog contents');
 *    dlg.show();
 *
 *    Setup multible buttons:
 *    
 *    dlg.setBtns([
 *        { text: 'ok', fn: function(evt, dialog, btn){ alert(btn.html()); } },
 *        { text: 'close' }
 *    ]);
 */
var Dlg = function(cfg) {
    cfg = cfg || {};
    this.defaultCfg = {
        bgcolor: '#666',
        opacity: 0.2,
        recycle: false,
        fixTop:  -85,  // if page is iframe, fixTop is the iframe's offset top
        drag  : false,//the dialog can drag or not 
        lock  : true, //need the overlay or not
        //新增zIndex可配置 modified by mik.zhang
        zIndex: 55555
    };
    $.extend( this, this.defaultCfg, cfg );
    this._init();
};
Dlg.prototype = {

    _init: function() {

            //dlg
            var html = '<div class="oe_dlg">' +
                '<a class="aclose_btn oe_dlg_close" href="#"></a>' + 
                '</div>';

            this.dlg = $(html)
                .css({
                    position: 'absolute',
                    zIndex: this.zIndex,
                    display: 'none'
            });

            this.width && this.dlg.css('width', this.width);

            // init the header, body, footer and btns of dialog
            this.header = $('<div class="oe_dlg_hd"></div>')
                .html('<h2 class="title">提示<h2>')
                .appendTo(this.dlg);
            
            this.body = $('<div class="oe_dlg_bd"></div>')
                .appendTo(this.dlg);
            
            this.footer = $('<div class="oe_dlg_ft"></div>')
                .html('<table width="100%"><tr><td align="center"  style="border-bottom:0px;border-right:0px">' +
                    '</td></tr></table>')
                .appendTo(this.dlg);

            this.setBtns([{text:'确定'}]);

            $('body').append(this.dlg);
            
            this._bindEvents();
    },
    _initoverlay : function(){
        // overlay
        this.overlay = $('<div></div>')
            .addClass('overlay')
            .css({
                background: this.bgcolor,
                opacity: this.opacity,
                top: 0,
                left: 0,
                width: $(window).width(),
                height: Math.max($(window).height(), $(document).height()),
                position: 'absolute',
                zIndex: this.zIndex - 1,
                display: 'none'
         });
         $('body').append(this.overlay);               
    },
    _bindEvents: function() {
        var self = this, doc = $(document);

        // close 
        this.dlg.find('.oe_dlg_close').click(function(evt){
            evt.preventDefault();
            self.close();
        });

        // close when press ESC
        var closeOnESC = function(evt){
            if(evt.which == 27){
                self.close();
                doc.unbind(evt);
            }
        };
        this.on('aftershow', function(){
            doc.bind('keyup', closeOnESC);
        });
        this.on('afterclose', function(){
            doc.unbind('keyup', closeOnESC);
        });

         if(this.lock){
            this._initoverlay();
         }
         if(this.drag){
            this._initDrag();
         }
    },
    unlock : "unlock",
    /**
     * @param {String} eventName
     * @param {Function} handler
     */
    on: function(eventName, handler){
        this.dlg.bind(eventName, handler);
    },

    /**
     * @param {String} eventName
     * @param {Function} handler
     */
    off: function(eventName, handler) {
        this.dlg.unbind(eventName, handler);
    },

    /**
     * @param {String} s
     */
    setHeader: function(s) {
        this.header.html(s);
    },

    /**
     * @param {String} s
     */
    setBody: function(s){
        this.body.html(s);
    },

    /**
     * @param {String} s
     */
    setFooter: function(s) {
        this.footer.html(s);
    },
    
    unLock : function(target) {
    	$(target).attr("en","t");
    	$(target).css("color", "#fff");
    },
    /**
     * @param {Array} btns
     *   [
     *      { text: 'ok', fn: function(evt, dialog, btnEl){...} },
     *      { text: 'close' }
     *   ]
     */
    setBtns: function(btns){
        var ft = this.footer.find('td').empty();
        var self = this;

        $(btns).each(function(i, btn) {
           
            var btnEl = $('<a class="oe_btn" hidefocus="true" href="'+(typeof btn.href !== 'undefined' ? btn.href : '#') +'"></a>')
                .css({
                    display: 'inline-block',
                    marginLeft: '10px'
                })
                .html( btn.text || '确定' );
            
            if (typeof btn.flag !== 'undefined') {
            	btnEl.attr("flag", btn.flag);
            }

            btnEl.click(function(evt){
                evt.preventDefault();
                if( typeof btn.fn == 'function' ){
                	if (btn.lock) {
                		var target = evt.target;
                    	if (target != null) {
                    		var en = $(target).attr("en");
                    		if (en == "f") {
                    			return;
                    		}
                    	}
                	}
                    var r = btn.fn(evt, self, btnEl);
                    if (btn.lock && r != "unlock") {
                    	btnEl.attr("en", "f");
                    	btnEl.css("color", "#9b9b9b");
                    }
                }
                else{
                    self.close();
                }
            });
            
            ft.append(btnEl);

        });
    },

    _shim: function() {
        var el = this.dlg,
        offset = el.offset(),
        html = '<iframe frameborder="0" tabindex="-1" src="javascript:;" style="' +
            'display: block;'+
            'position: absolute;' +
            'top:0;' +
            'left:-1px;' +
            'width:' + el.outerWidth() + 'px;' +
            'height:' + el.outerHeight() + 'px;' +
            'z-index:-1;' + 
            //'border: 1px solid #000' +
            'filter:alpha(opacity=0)' +
            '"/>';
        
        el.append(html);   
    },

    show: function() {
        if ( this.dlg.triggerHandler('beforeshow') === false ) return;
        
        this.overlay&&this.overlay.show();
        $(window.parent.document).find("body").css("overflow","hidden");

        var t, self = this;
    
        if( window.self == window.top ){
            t = $(top).scrollTop() + $(window).height() / 2
            - this.dlg.outerHeight() / 2; 
        }else {
        	  var ih = $(window.parent.document).find("iframe").offset().top;
        	  var ch = $(top).scrollTop();
        	  var wh =  top.window.innerHeight;
        	  if(wh==undefined){
        		  wh=top.document.documentElement.clientHeight;

        	  } 
        	  //t = (ch + wh - this.dlg.outerHeight()) / 2 - ih;
        	  t = ( wh - this.dlg.outerHeight()) / 2 - ih+ch;
        }

        var l = $(document).scrollLeft() + $(window).width() / 2 
            - this.dlg.outerWidth() / 2;

//        if(t + this.dlg.outerHeight()>$(document.body).height()){
//             t = $(document.body).height() - this.dlg.outerHeight();
//        }
        if (t <= 0) {
        	t = 0;
        }
        this.dlg.css({ top: t, left: l});

        if(!window.XMLHttpRequest) {
            this._shim();
        }

        this.dlg.show();
        this.dlg.triggerHandler('aftershow');
    },
    close: function(f) {// f是否执行closeFunc
        if ( this.dlg.triggerHandler('beforeclose') === false ) return;    
        
        this.overlay&&this.overlay.remove();
        this.dlg.hide();
        //$('body').css('overflow', 'auto');
        $(window.parent.document).find("body").css("overflow","auto");
        
        this.dlg.triggerHandler('afterclose');
        if (f == null || f) {
        	if (this.closeFunc != null) {
            	this.closeFunc();
            }
        }
        if(!this.recycle){
			this.dlg.remove();
		}
    },
    _initDrag : function(){
        this.isClick = false;
        var t=l=0;
        var self = this;
        self.position ={};

        this.dlg.mousedown(function(e){
            self.isClick = true;        
            t=$(this).css("top");
            l=$(this).css("left");
            self.position.defaultX = e.pageX;
            self.position.defaultY = e.pageY;
            self.position.left = parseFloat(l);
            self.position.top = parseFloat(t);
        });

        this.dlg.mousemove(function(e){
           if(!self.isClick){
               return;
           }
           //console.log(self.isClick);
           var x = e.pageX,y = e.pageY;
           //new position
           var nx = parseFloat(x)-self.position.defaultX+self.position.left;
           var ny = parseFloat(y)-self.position.defaultY+self.position.top;

           //check the bound
           var height = $(window).height(),width = $(window).width();
           nx = (nx<=0)?0:(nx+this.offsetWidth>width)?width-this.offsetWidth:nx;
           ny = (ny<=0)?0:(ny+this.offsetHeight>height)?height-this.offsetHeight:ny;
           $(this).css({
               top  : ny+'px',
               left : nx+'px'
           });
        });
        this.dlg.mouseup(function(e){
            //console.log('333333333');
            self.isClick = false;
        })
    }
};
