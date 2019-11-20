;(function($){

var DateUtil = {
	oneday : 24 * 60 * 60 * 1000 , 
	today : function(){
		var t = new Date();
		return new Date( t.getFullYear() , t.getMonth()  , t.getDate() );
	} , 
	format : function( date ){
		var arr = DateUtil.toArr( date );
        return arr.join("-");
	},
    toArr : function( date){
        var y = date.getFullYear();
		var m = date.getMonth() + 1;
		if( m < 10 ) { 	m = "0" + m;  }
		var d = date.getDate();
		if( d < 10 ) {  d = "0" + d;  }
		return [y,m,d];
    },
	addDay : function( day , num ){ 
		return new Date( day.getTime() + ( DateUtil.oneday * num ) );
	} ,
	getFirstByMonth : function( date ){
		return new Date( date.getFullYear() , date.getMonth() , 1 );
	} ,
	getLastByMonth : function( date ){ 
		var nextMonth = new Date( date.getFullYear() , date.getMonth() + 1 , 1 );
		return DateUtil.addDay( nextMonth , -1 );
	} ,
	parse : function( dateStr ){
		if( dateStr instanceof Date ){
			return dateStr;
		} else if( /^\d+$/.test( dateStr ) ) {
			return new Date( parseInt( dateStr , 10 ) );
		} else {
			return new Date( Date.parse( dateStr.replace(/-/g,'/') ) );
		}
	}
};

function CalendarCore( options ){
	this.opts = $.extend({
		currentDay : DateUtil.today() , 
		DAYS_HEADER : [0,1,2,3,4,5,6]  
	},options);
};

CalendarCore.prototype = {
	today : function(){
		return this.opts.currentDay;
	} ,
	nextMonth : function(){
		var o = this.opts.currentDay;
		this.opts.currentDay = new Date( o.getFullYear() , o.getMonth() + 1 , 1 );
		this._refreshTable();
	} ,
	prevMonth : function(){
		var o = this.opts.currentDay;
		this.opts.currentDay = new Date( o.getFullYear() , o.getMonth() - 1 , 1 );
		this._refreshTable();
	} ,
	changeDay : function( date ){
		this.opts.currentDay = DateUtil.parse( date );
		this._refreshTable();
	} ,
	refresh : function(){
		this._refreshTable();
	},
	_wrapItem : function( timeSpan ){
		return {
			date : new Date( timeSpan )
		}
	} , 
	_refreshTable : function(){
		var o = this.opts;

		var first = DateUtil.getFirstByMonth( o.currentDay );
		var last = DateUtil.getLastByMonth( o.currentDay );

		var start = this._findClosestDateByDay( first , o.DAYS_HEADER[0] , true );
		var end = this._findClosestDateByDay( last , o.DAYS_HEADER[ o.DAYS_HEADER.length - 1 ] , false );
		var n = start.getTime();
		var result = [];
		for( var i = 0; i < 6; i++ ){
			result[i] = [];
            /*
            var d = this._wrapItem(n);
            if( i === 5 && d.date.getDate()<28 ){
                break;
            }
            */
			for( var j = 0; j < o.DAYS_HEADER.length; j++ ){
                result[i][j] = this._wrapItem(n);
                n = n + DateUtil.oneday;
			} 
		}

		$(this).trigger('refreshed',[result])

	} , 
	_findClosestDateByDay : function( date , weekday , isPrev ) {
		var list = this.opts.DAYS_HEADER;
		var index = $.inArray( date.getDay() , list );
		
		if( isPrev ){
			return DateUtil.addDay( date , -index );
		} else {
			return DateUtil.addDay( date , list.length - index - 1 );
		}
	}
};



window.DateUtil = DateUtil;
window.CalendarCore = CalendarCore;


})(jQuery);