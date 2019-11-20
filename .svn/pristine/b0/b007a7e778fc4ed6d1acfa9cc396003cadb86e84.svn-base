(function($){
	/**
		Event :
			q-suggest-user-action
			q-suggest-hide
			q-suggest-show
			q-suggest-dispose

	*/



	/**
        usage : 
            bind :
                detect_oninput.bind( element , callback )
            unbind : 
                detect_oninput.unbind( element , callback )
            set value safely , prevent to call back :
                detect_oninput.set( element , value )
            
            ------
            callback parameter:
                callback( new_value , old_value)

        warn :
            in some browser , it may call the function back when the input's value was changed by javascript unless using detect_input.set()
    */
    var detect_oninput = (function(){
        var _h = 'data-detect-oninput', _cache = {} , _check = {} , $$guid = 1 , $$eid = 1;
        var _bindEvent = function( element , type , handler , _guid ){
            if( element.addEventListener )
                element.addEventListener( type , handler , false );
            else if( element.attachEvent )
                element.attachEvent( 'on' + type , handler );
            
            ( _cache[ _guid ] || ( _cache[ _guid ] = [] ) ).push( { 't' : type , 'h' : handler } );
        };
        var _removeEvent = function( element , _guid ){
            if( !_cache[ _guid ] )
                return;
            for( var i = 0 , _evt  ; _evt = _cache[ _guid ][i] ; i++ )
                if( element.removeEventListener )
                    element.removeEventListener( _evt['t'] , _evt['h'] , false);
                else if( element.detachEvent )
                    element.detachEvent( 'on' + _evt['t'] , _evt['h'] );
            delete _cache[ _guid ];
        };

        var _create_checker = function( input , callback ){
            var _old = input.value;
            var _checker = function(){
                var _new;
                if( ( _new = input.value ) !== _old ){
                    if( _checker._sleep !== true )
                        callback.call( input , _new , _old );
                    _old = input.value;
                }
            }
            return _checker;
        };

        var ua = navigator.userAgent.toLowerCase();

        return {
            version : '1.3',
            bind : function( input , callback ){
                var _eid , _guid = callback[ _h ];
                if( !_guid )
                    callback[ _h ] = _guid = $$guid++;
                if( !( _eid = input.getAttribute( _h ) ) )
                    input.setAttribute( _h , _eid = "" + $$eid++ );

                var _cb = _create_checker( input , callback );
                if( 'oninput' in input && !/opera/.test( ua ) )
                    _bindEvent( input , 'input'  , _cb , _guid );
                else{
                    var _check_handler;
                    _bindEvent( input , 'focus' , function(){
                        if( !_check_handler )
                            _check_handler = setInterval( _cb , 100 );
                    } , _guid );
                    _bindEvent( input , 'blur' , function(){
                        if( _check_handler ){
                            clearInterval( _check_handler );
                            _check_handler = null;
                        }
                    } , _guid );
                }
                _check[ _guid ] = { eid : _eid , checker : _cb };
                return input;
            } ,
            unbind : function( input , callback ){
                if( callback[ _h ] ){
                    _removeEvent( input ,  callback[ _h ] );
                    delete _check[ callback[ _h ] ];
                }
                return input;
            },
            set : function( input , value, id ){
                var _eid = input.getAttribute( _h );
                if( _eid ){
                    var _checkers = [];
                    for( var _x in _check )
                        if( _check[ _x ][ 'eid' ] === _eid ){
                            _checkers.push( _check[ _x ][ 'checker' ] );
                            _check[ _x ][ 'checker' ]._sleep = true;
                        }
                    input.value = value;
                    for( var i = 0 , len = _checkers.length ; i < len ; i++ ){
                        _checkers[i].call( input );
                        _checkers[i]._sleep = false;
                    }
                }else
                    input.value = value;
                if (id != null) {
                	$(input).attr("eid", id);
                	$(input).attr("evalue", value);
                }
            }
        };
    })();


	/*
		plugin detect oninput end
	*/

    /*
     *arg description
     *@ajax the suggest's ajax option
     *render  : render the data back from the interface, you can also cache the data , this function is open
     *focus   : true means the 'input' will request the ajax.url when it focus   add by jieqing.song
     *
    */
	$.qsuggest = { version : '1.3' };
	
	var ROOT_KEY = $.qsuggest.ROOT_KEY = 'q-suggest';

	var gInd = 0;

	var defArgs = {
		ajax : {
			url : null ,
			cache : false,
			success : function(){}
		},
		reader : function( data ){ return data; },
		loader : function( val ){ return val; },
		max : 10,
		min : 1,
		container : null,
		delay : 100 ,	// Reaction time
		rdelay : 1000,	// Reaction time after request ( delay hiding when no response )
		requestWithNothing : false,
		trimQuery : true ,
        focus : false,//增加文本框获取焦点时候的时候就请求
		css : { 'z-index' : 10000 },
		render : function( val ){ return String( val ).replace(/&/g,"&amp;").replace(/</g,"&lt;").replace(/>/g,"&gt;") }
	};

	
	function _calc_pos( el ){
			var of = el.offset();
			of['top'] += el.outerHeight();
			return of;
	}	
	
	function _getData ( el ){
		return el.closest("table").data('data')[ el.attr('data-ind') * 1 ];
	}
	function QSuggest( el , args ){
		if( !this.init )
			return new qsuggest( el , args );
		else
			return this.init( el , args );
	}
	
	$.extend(QSuggest.prototype,{
		init : function ( aEl , args ){
			this.key = ++gInd;
			var ns = this.ns = ROOT_KEY + this.key;
			args = this.args = $.extend( true , {} , defArgs ,args || {} );
			var activeEl = this.activeEl = $(aEl);
			var self = this;
			
			this.el = $('<div class="' + ROOT_KEY + (args.customClass ? ' ' + args.customClass : '') + '"></div>').appendTo( args['container'] || document.body ).hide();
			this.el.data( ROOT_KEY , this );
			
			this._handler = null;
			this._ajaxHandler = null;
			this._excludeEl = null;
			this._mouseFocus = null;
			this._last = []; // [ cond , result ]
			this._cache = {};
			this._value = null;

            this.timer =new Date().getTime();
			
			$.each( args['on'] || {} , function ( k , v ){
				activeEl.bind( k + '.' + ns  , v );
			});
			
			if( args['css'] )
				this.el.css( self.args['css'] );
				
			var self = this;
			
            activeEl.bind("focus",function(){
                self.timer = (new Date()).getTime();
            });
			detect_oninput.bind( activeEl[0] , function(){
				self.show();
			});
			activeEl.bind('keyup.' + ns  , function( evt ){
			    //速度快的时候发送N多请求	
                var d =new Date().getTime();
                if(d-self.timer<50){
                    return;
                }
                self.timer = d;
				var visible = self.visible();
				var code = evt.keyCode;
				
				if( code === 40 && !visible ){
					self.show();
					return;
				}
				
				var elements = self.el.find( 'tr' );
				var active = elements.filter('.active');
				
				switch( code ){
					case 38 :  //	up
					case 40 :  //	down
						if( visible ){
							self._excludeEl = self._mouseFocus;
							active.removeClass('active');
							var p = evt.keyCode === 38 ? active.prev() : active.next();
							if( p.size() === 0)
								p = elements.filter( code === 38 ? ':last' : ':first');
							var val = _getData( p );
							self.setValue( val );
							p.addClass('active');
							evt.preventDefault();
							self._trigger('q-suggest-user-action' , [ evt.type , val , code ] );
						}
						break;
					case 13 :  
                        if( visible ){
							self._excludeEl = self._mouseFocus;
							var val = _getData( active );
							self.setValue( val );
							evt.preventDefault();
							self._trigger('q-suggest-user-action' , [ "enter" , val , code ] );
                            self.hide();
						}
                        
                        break;
					case 27 :  //	esc
						if( visible ){
							self.hide();
							self._trigger('q-suggest-user-action' , [ evt.type , self.getValue() , code ] );
						}
						break;
					case 18 :	//	alt
					case 9	:	//	tab
						break;
					default :
						;
				}
			});

			activeEl.bind('blur.' + ns , function( evt ){
				if( self.visible() )
					self.hide();
			});
            if( self.args.focus){
                activeEl.bind('focus.' + ns , function( evt ){
                     self.show();
                });	
            }
            
            $(this.el[0]).delegate("tr", "mouseover." + ns + " mouseout." + ns + " mousedown." + ns, function (evt) {
            	var el = $.nodeName( evt.target , 'tr' ) ? $( evt.target ) : $( evt.target ).parents('tr').eq(0);
				var v = el[0]  != self._excludeEl;
				if( evt.type === 'mouseover' ){
					if( v ){
						el.parents().children().removeClass( 'active' );
						el.addClass( 'active' );
						self._excludeEl = null;
					}
					self._mouseFocus = el[0];
				}else if( evt.type === 'mouseout' ){
					self._mouseFocus = null;
				}else{
					self.setValue( _getData( el ) );
					self.hide();
					self._trigger('q-suggest-user-action' , [ evt.type , self.getValue() , null ] );
				}
            });

			return this;
		},
		req : function(){
			var self = this;
			if(self._handler)
				clearTimeout( self._handler );
			if(self._timeoutHandler){
				clearTimeout( self._timeoutHandler );
				self._timeoutHandler = null;
			}
			if(self._ajaxHandler){
				self._ajaxHandler.abort();
				self._ajaxHandler = null;
			}
			self._handler = setTimeout( function(){
				
				var sv = self.activeEl.val() , val = self.args.loader( sv ) , data = null , status;
			    if(self.args.focus){
                    val = "a";
                }
				if( self.args.trimQuery )
					val = $.trim( val );
				if( !val && !self.args.requestWithNothing ){
					self.draw( null );
					return;
				}
				if( self._last && self._last[0] === val ){
					self.draw( self._last[1] );
					return;
				}
					
				if( self._last && self._last[0] == val )
					data = self._last;
				else if( self.args.cache && self._cache[ val ] )
					data = self._cache[ val ];
					
				if( data )
					self.draw( ( self._last = data )[1] );
				else if( !self.args.ajax.url )
					self.draw( null );
				else{
					var url = self.args.ajax.url.replace("*", encodeURIComponent( val ) );
					var _success = self.args.ajax.success;
					self._timeoutHandler = setTimeout( function(){ self.hide(); } , self.args.rdelay );
					self._ajaxHandler = $.ajax( $.extend( {} , self.args.ajax , { url : url , success : function( data , status ){
						clearTimeout( self._timeoutHandler );
						self._timeoutHandler = null;
						self._ajaxHandler = null;
						
						// double check if returns too late
						if( sv !== self.activeEl.val() )
							return;
						var tmp = self.args.reader.call( self ,  data , status );
						if(self.type(tmp)==="Array")	{
							self.draw( tmp );
							self._last = self._cache[ val ] = [ val , tmp , status ];
						}
                        
						_success.apply( this,arguments );
					}}));
					
				}
			} , self.args.delay );
		},
		type : function(data){
			return Object.prototype.toString.call(data).slice(8,-1);
		},
		show : function( ){
			this.req();
		},
		hide : function(){
			if( this.visible() ){
				this.el.hide();
				this._trigger( 'q-suggest-hide' );
			}
		},
		draw : function( data ){
			this.el.empty();
			
			var min = this.args.min , max = this.args.max;
			if( !data || !data.length || data.length < min ){
				this.hide();
				return;
			}
			
			var x = [] , r = this.args.render;
			x.push('<table cellspacing="0" cellpadding="2"><tbody>');
			$.each( data , function( ind , v ){
				if( ind >= max )
					return false;
                if(v instanceof Object){
				    x.push('<tr data-ind="', ind ,'"><td did="',v.id,'">' , r( v.name ) , '</td></tr>');
                }else{
				    x.push('<tr data-ind="', ind ,'"><td>' , r( v ) , '</td></tr>');
                }
			});
			x.push('</tbody></table>');
			var o = $( x.join('') ).appendTo( this.el ).data( 'data' , data );
			
			// calc position & width
			if( !this.args['container'] )
				this.el.css( _calc_pos( this.activeEl ) );
			
			var width = this.args['width'] ;
			if( !width )
				this.el.css( 'width' , this.activeEl.outerWidth() );
			else
				this.el.css( 'width' , width );
				
			this.el.show();
			this._trigger('q-suggest-show' , [ data ] );
		},
		dispose : function(){
			this._trigger('q-suggest-dispose');
			this.activeEl.unbind( '.' + this.ns );
			$( window ).unbind( '.' + this.ns )
			this.el.remove();
		},
		visible : function(){
			return this.el.is(":visible");
		},
		_trigger : function(){
			this.activeEl.triggerHandler.apply( this.activeEl , arguments );
		},
		setValue : function( val ){
            if (val instanceof Object){
                detect_oninput.set( this.activeEl[0] , val.name, val.id ); 
            }else{
                detect_oninput.set( this.activeEl[0] , val);
            }
			//this.activeEl.val( val );
			this._value = val;
		},
		getValue : function(){
			return this._value;
		},
		set : function( key , value ){
			var handled = false;
			switch( key ){
				case 'container' :
					this.el.appendTo( value || document.body );
					this.el.css( { top : '' , left : '' } );
				break;
			}
			if( !handled )
				for( var i = 0 , w = key.split( '.' ) , len = w.length , z = this.args; i < len && ( i !== len - 1 && ( z[ w[i] ] || ( z[ w[i] ] = {} ) ) || ( z[ w[i] ] =  value ) ); z = z[ w[i] ] , i++ ){}
			return value;	
		},
		get : function( key ){
			for( var i = 0 , z = this.args , w = key.split(".") , len = w.length ; i < len && ( z = z[ w[i] ] ); i++ ){}
			return z;
		}
	});
	
	$.fn.qsuggest = function( ){
		var args = arguments;
		
		if( arguments.length > 1 && this.data( ROOT_KEY )){
			var val = null;
			if( arguments[0] === 'option' || arguments[0] === 'setting' )
				this.each( function( ind , el ){
					var jEl = $( el );
					var sug = this.data( ROOT_KEY );
					if( sug )
						val = val || ( args.length > 2 ? sug.set(args[1] , args[2]) : sug.get(args[1]) );
				});
			return val;
		//init a suggest
		}else if( arguments.length <= 1) {
			
			this.each( function( ind , el ){
				var jEl = $( el );
				if( jEl.data( ROOT_KEY ) ){
					jEl.data( ROOT_KEY ).dispose();
					jEl.removeData(ROOT_KEY);
				}
				var sug = new QSuggest( el , args[0] );
				jEl.data( ROOT_KEY , sug );
			});
			
		}
		return this;
	}
})(jQuery);
