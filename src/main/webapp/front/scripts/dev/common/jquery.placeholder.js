(function($){
    
    var version = '0.1.0';
$.fn.isPlaceHolderEmpty = function(){
	if ($(this).length > 1) {
		return false;
	}
	var def_text = $(this).attr("placeholder-data");
	var v = $(this).val();
	return def_text != null && v != null && v == def_text;
};
$.fn.placeholder = function(){
    
    return $(this).each(function(){
        
        var $self = $(this);
        var color = $self.css("color");
        var def_text = $self.attr("placeholder-data");
        var def_color = $self.attr("data-placeholder-color") || "#999" ;
		var def_clsname = $self.attr("data-placeholder-clsname");
        
        if ( !def_text ) return;
		if ( this.isPlaceHolderEmpty && this.initPlaceHolder ) {
    		this.initPlaceHolder();
		    return;
		}
        
        var _isDef = function(){
            return $.trim( $self.val() ) == "" || $self.val() == def_text;
        }

		//add to input
		this.isPlaceHolderEmpty = _isDef;

		var _removeGray = function(){
			if( def_clsname ) {
				$self.removeClass( def_clsname );
			} else {
				$self.css( "color" , color );
			}
		}

		var _addGray = function(){
			if( def_clsname ) {
				$self.addClass( def_clsname );
			} else {
				$self.css( "color" , def_color );
			}
		}
        
        $self.focus(function(){
            if( _isDef() ) {
                $self.val("");
				_removeGray();
			} 
        }).blur(function(){
            if( _isDef() ) {
                $self.val( def_text );
				_addGray();
            } else {
				_removeGray();
            }
        });

		//init
		this.initPlaceHolder = function(){
	        if( _isDef() ) {
                $self.val( def_text );
			    _addGray();
            } else {
			    _removeGray();
            }
        }

        this.initPlaceHolder();
        
    });

}

})(jQuery);

 
