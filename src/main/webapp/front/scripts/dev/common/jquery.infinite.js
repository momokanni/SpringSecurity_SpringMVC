var _currentOffset = 2;
var _options = null;
var initInfinite = function(ioffset, ipages){
	_currentOffset = ioffset;
	_options.pages = ipages;
};
(function($){
	var _cobj = null;
	var loading = false;
    var defaults = {
            url: function (offset) { return "/"; },
            template: function (resp) { return ""; },
            offset: 1,
            pages: null,
            pageCount:20,
            pdata: '',
            loader: '<div class="loader"></div>',
            lengthReturned: function (resp) { return resp.length; },
            sensitivity: 0,
            dataType: 'jsonp',
            handleReturned: function(html) {}
        };
	$.fn.infinite = function(opts){
		_options = $.extend(defaults,opts);
		return this.each(function(i){
			if(_options.pages != null && _options.pages > 1){
				_cobj = $(this);
				start();
			}
		});
	};
	
	var scrollCallback = function(){
		if (typeof loanType != "undefined" && loanType == 3) {
			stop();
			return;
		}
	    var scrollTop = $(window).scrollTop();
        var objBottom = _cobj.height() + _cobj.offset().top;
        var winHeight = window.innerHeight ? window.innerHeight : $(window).height();
        var winBtmPos = scrollTop + winHeight;
        if (objBottom  < winBtmPos + _options.sensitivity && !loading){
        	if(_options.pages != null && _currentOffset > _options.pages){
        		return;
        	}
	    	var loader = jQuery(_options.loader);
	        loader.appendTo(_cobj);
	        loading = true;
        	
        	$.ajax({
    			url: _options.url(_currentOffset),
    			data : _options.pdata,
    			type: 'POST',
    			dataType: _options.dataType,
    			success: function(resp){
    				if(_options.lengthReturned(resp) > 0){
    					_options.handleReturned(_options.template(resp));
            			_currentOffset++;
            		}
    				if (_options.lengthReturned(resp) == 0 || (_options.pages != null && _currentOffset > _options.pages)){
                        stop();
                    }
            		loader.remove();
            		loading = false;
    			}
    		});
        }
	};
	
	var start = function(){
		$(window).scroll(scrollCallback);
	};
	
	var stop = function(){
		 $(window).unbind("scroll", scrollCallback);
	};
	
})(jQuery);