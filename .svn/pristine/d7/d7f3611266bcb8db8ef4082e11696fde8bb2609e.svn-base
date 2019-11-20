(function($) {
	
	$.fn.formatCurrency = function(settings) {
		settings = jQuery.extend({
		    name: "formatCurrency",
		    useHtml: false,
		    symbol: '',
		    global: true
		}, settings);
		
		return this.each(function() {
		    var num = "0";
		    var suffix = "";
		    num = $(this)[settings.useHtml ? 'html' : 'val']();
		    num = num.replace(/\$|\,/g, '');
		    if (isNaN(num))
		        num = "0";
		    if(num.indexOf('.') > 0){
		    	suffix = num.substring(num.indexOf('.')+1, num.length);
		    	num = num.substring(0, num.indexOf('.'));
		    }
		    sign = (num == (num = Math.abs(num)));
		    num = Math.floor(num * 100 + 0.50000000001);
		    cents = num % 100;
		    num = Math.floor(num / 100).toString();
//		    if (cents < 10)
//		        cents = "0" + cents;
		    for (var i = 0; i < Math.floor((num.length - (1 + i)) / 3); i++)
		        num = num.substring(0, num.length - (4 * i + 3)) + ',' + num.substring(num.length - (4 * i + 3));
		    if(suffix != ""){
		    	num = num + '.' + suffix;
		    }
		    $(this)[settings.useHtml ? 'html' : 'val'](((sign) ? '' : '-') + settings.symbol + num);
		});
	};

  // Remove all non numbers from text
  $.fn.toNumber = function(settings) {
		settings = jQuery.extend({
		    name: "toNumber",
		    useHtml: false,
		    global: true
		}, settings);  

    return this.each(function() {
      var method = settings.useHtml ? 'html' : 'val';   
      $(this)[method]($(this)[method]().replace(/[^\d\.]/g, ''));
    });
  };


})(jQuery);