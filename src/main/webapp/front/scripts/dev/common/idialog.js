var Dialog  = (function($,window){
		var _isIE  = Browser.isIE,
		    _isIE6 = Browser.isIE6,
			$doc   = $(window.document),
			$body  = $('body'),
			$win   = $(window); 
        var IE6_LEFT_OFFSET = 16; //IE6下滑动条的宽度
		var _isMac = Browser.isMac;
		var hasScroll = false;
        //防止引用JS文件在head 里取不到body
        if (!$body[0]) {
            $(function(){
                $body =  $('body'); 
            });
        }
        //背景 前景 
		var dlg_mask_html = '<div class="g-pop-bg"></div>',
			dlg_box_html = '<div class="g_dlg_box g-pop"></div>';

		var dlgid = "dlg",
            mids=0 , 
            ids = 0,
			_d_zindex = 100000;

		var def_config = {
			content:'',
			maskVisible : true,
			top:0,
			left:0,
			width:0,
			height:0,
			newMask : false,
			contentStyle : "",
			borderStyle :"",  // border样式 
			titleStyle : "", //标题样式
			closeCls  : "", //关闭按钮 class 如果有会替换掉 原来的 dlg_close 
			closeBtn : {
				handler:function(dlg){
					dlg.close();
				}
			},
			hideCloseBtn: false
		};
		// mix config setting.
		var mix_cfg = function(n, d) {
			var cfg = {},
				i;
			for (i in d) {
				if (d.hasOwnProperty(i)) {
					cfg[i] = typeof n[i] !== 'undefined' ? n[i] : d[i];
				}
			}
			return cfg;
		}
		var getWinRect = function(){
				var win = $win;
				return {
					scrollTop :  $doc.scrollTop(),
					scrollLeft : $doc.scrollLeft(),
					width: win.width(),
					height: win.height()
				}
		}
		var _mask_id = "dlg_mask_";
		var Mask = function(){
		    this.id = _mask_id+(++mids);
			this._dom = $('<div id="'+(this.id)+'" class="g-pop-bg" style="z-index:'+(++_d_zindex)+'"></div>');
			this._init();
		};
	 	Mask.prototype = {
			_init : function(){
				$body.append(this._dom);
				this._dom.hide();
				this._initEvents();
				this.adaptWin();
				if(this._needIframe()){
					this._createIframe();
				}

			},
			_initEvents : function(){
				var me = this;
			},
			_createIframe: function(){
				this._iframe = $('<iframe class="dlg_miframe" frameborder="0" src="about:blank"></iframe>');
				this._dom.append(this._iframe);
			},
			addClass : function( clsName){
				this._dom.addClass(clsName);
			},
			/**
			 * 检测自动生成iframe条件
			 *
			 * @method
			 * @protected
			 * @param void
			 * @return {bool}
			 */
			_needIframe: function () {
				var useIframe = !!window.ActiveXObject
								&& ((_isIE6 && $('select').length)
								|| $('object').length);
				return useIframe;
			},
			adaptWin : function(){
				if(_isIE6){
					this._dom.css({
                        top : $doc.scrollTop(), 
                        left : $doc.scrollLeft(),
						height: $win.height(),
						width: $win.width()
					});
				}
			},
			hide : function(){
				this._dom.hide();
                var html_dom = $('html').css("overflow","");
				if(_isMac == false){
					if(hasScroll){
	                    html_dom.css("padding-right","0px");
					}
				}
			},
			show : function(){
                var me = this;
				var wa = $win.width();
                var html_dom = $('html').css("overflow","hidden");
				var wb = $win.width();
                me._dom.show();
				if(_isMac == false){
					if(wa != wb){
						hasScroll = true;
						html_dom.css("padding-right",IE6_LEFT_OFFSET+"px");
					}
				}
			},
			getDom : function(){
				return this._dom;
			},
			remove: function(){
				this._dom.remove();
			}
		}

		var most_mask; //公共的Mask
		var Dialog =  function(cfg){
			var c = cfg || {};
			this.config =  mix_cfg(c,def_config);
			this._init();
		}
		Dialog.prototype = {
			constructor : Dialog,
			_init : function(){
				if(!this.config){
					return ;
				}
				
				this.id = dlgid +(++ids);
				var cfg =  this.config;

				if(cfg.newMask){
					this._mask =  new Mask();
				}else{
					if(!most_mask){
						most_mask =  new Mask();
						this._mask = most_mask;
					}else{
						this._mask =  most_mask;
					}
				}
				this._creatDialog();
				this._initEvents();
				this.inited = true;
			},
			_initEvents : function(){
				var me = this,id=this.id;

				this._closeBtn.bind({
					click : function(e){
						e.preventDefault();
						me.config.closeBtn.handler.call(me,me);
					}
				});
				
				$win.bind("resize."+id,resize);
				
				me._unbindEvents = function(){
					$win.unbind("resize."+id);
				}

				function resize(){
                    if (_isIE6) {
                        me._dlg_container.css({
                            top : $doc.scrollTop(), 
                            left : $doc.scrollLeft(),
						    width : $win.width(),
						    height : $win.height()
					    });
  
                    } else {
                        me._dlg_container.css({
                            width : $win.width(),
                            height : $win.height()
                        });
                    }
					me.toCenter();
					me._mask.adaptWin();
				};
			},
			_creatDialog : function(){
				var cfg = this.config;
				var dlg_container = this._dlg_container = $(dlg_box_html).attr("id",this.id).css("z-index",(_d_zindex += 10));
				if(cfg.content instanceof $){
					this._dialog = cfg.content;
				}else{
					this._dialog = $(cfg.content);
				}
				var dlg = this._dialog;
				dlg.addClass("g_dlg_wrap_css3");	
				dlg_container.html(dlg);
				this._content = $(".js_content",dlg);
				this._closeBtn = $('.js_close',dlg);
				$body.append(dlg_container);

				if(cfg.hideCloseBtn){
					this._closeBtn.hide();
				}
				var pos =  "fixed";
				if(_isIE6){
					dlg_container.css({
                        top : $doc.scrollTop(), 
                        left : $doc.scrollLeft(),
						width : $win.width(),
						height : $win.height()
					});
					pos = "absoulte";
			    } else {
                    dlg_container.css({
						width : $win.width(),
						height : $win.height()
                    });
                }
                dlg.css("position","absolute");
				this.setPos(pos);				
				//this.toCenter();
			},
			setPos : function(pos){
				this._dlg_container.css("position",pos);
			},
			//得到content 返回jQuery 对象
			getContainer : function(){
				return this._dlg_container;
			},
			getContent : function(){
				return this._content;
			},
			setContent : function(dom){
				this._content.empty();
				this._content.html(dom);	
			},
			getCloseBtn : function(){
				return this._closeBtn;
			},
			_setStyle : function(dom,css){
				if(typeof css == "string"){
					if(_isIE){
						dom[0].style.cssText = css;
					}else{
						dom.attr("style",css);
					}
				}else{
					dom.css(css);
				}
			},
			toCenter : function(){
				var winRect =  getWinRect(),
					w = this._dialog.width(),
					h = this._dialog.height(),
					t = 0,l =0;
                var top = Math.max((winRect.height / 2 - h / 2) >>0 + t,0) ;
                var left  = (winRect.width / 2 - w / 2) >>0 + l;
                if (_isIE6) {
                    left -= IE6_LEFT_OFFSET/2;
                }
				var rect = {
					left :	left,
				   	top :  top
				}
				this._dialog.css(rect);
				return this;
			},
		    show : function(callback,context){
				var me = this;
				if(me.config.maskVisible){
					me._mask.show();
				}
                //IE8 以下计算窗口宽度
                me._dlg_container.css({width:$win.width(),height:$win.height()});
				me._dlg_container.show();
				me.toCenter();
				if(callback){
					callback.call(context || me,me);
				}
				me.showed = true;
				return this;
			},
			close : function(callback,context){
				var me = this;
				this._mask.hide();
				this._dlg_container.hide();
				if(callback){
					callback.call(context || me,me);
				}
				this.showed = false;
				return this;
			},
			destory : function(){
				this.close();
				this._unbindEvents();
				this.config.newMask && this._mask.remove();
				this._dlg_container.remove();
				this._dialog.remove();
				for(var i in this){
					delete this[i]
				}
			},
			getMask : function(){
				return this._mask;
			}


		}
		Dialog.prototype.In = Dialog.prototype.show;
		Dialog.prototype.out = Dialog.prototype.close;
		Dialog.prototype.hide = Dialog.prototype.close;
		Dialog.prototype.remove = Dialog.prototype.destory;
		
	    
    return Dialog;

})(jQuery,window);

