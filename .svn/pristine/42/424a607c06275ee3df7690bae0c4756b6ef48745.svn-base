(function($){

	var current=false;

	var _config={
	    tpl : '<div class="csSelect" tabindex="0">'
				+'<div class="csStitle" js-select-item="show" ></div>'
				+'<div class="csContent">'
				+'<ul class="csSlist" js-select-item="list">'
				+'<li><a js-select-item="option" value="{value}" href="javascript:void(0);" tabindex="-1">{name}</a></li>'
				+'</ul>'
				+'</div>'
				+'</div>',
		key: "js-select-item",
		defineTpl : "<input type='text' placeholder='{defineTip}' de='true' />",
		dayTpl : "<input type='text' placeholder='{dayTip}' de='true' name='day' />"
	};
	
	var defindObj = null;
	/**
	 *
	 *
	 *
	 *
	 *
	 *
	 *
	 **/
	var csSelect=function(el,args){
	
		this.config=$.extend({},_config,args);
		if (this.config.define) {
			if (this.config.defineTip) {
				this.config.defineTpl = this.config.defineTpl.replace("{defineTip}",this.config.defineTip);
			} else {
				this.config.defineTpl = this.config.defineTpl.replace("{defineTip}","");
			}
		} 
		if(this.config.day){
			if (this.config.dayTip) {
				this.config.dayTpl = this.config.dayTpl.replace("{dayTip}",this.config.dayTip);
			} else {
				this.config.dayTpl = this.config.dayTpl.replace("{dayTip}","");
			}
		}
		this.init(el);
		this.render();
		
		this.bindEvents();
		this.load();
		var dom = this.dom;
		var list = this.list;
		var link = this.link;
		$(this.dom).delegate('.csStitle input', 'change', function(ev) {
			if($(this).attr('name') == 'day'){
				$(link).find('#day').val($(this).val());
			}else{
				$(link).find("#define").val($(this).val());
			}
		});
	}
	
	$.extend(csSelect.prototype,{
		init: function(el){
			this.link=el;
			
			var data=[];
			
			var define = (this.config.define == true);
			
			var day = (this.config.day == true);
			
			var self=this;
			
			if(el.tagName.toLowerCase()=="select"){
				$(el).find("option").each(function(i,v){
					data.push({name:$(v).html(),value:$(v).val()});
				});
				if (define) {
					data.push({
						name : "自定义还贷月",
					    value : "define"
					});
				}
				
				if(day){
					data.push({
						name : "自定义还贷日",
					    value : "day"
					});
				}
			}
			
			this.data=data;
			
			this.shown=false;
			
			this.doc=$(document);
		},
		
		render: function(){
			//this.data;
			
			this.dom=$(this.config.tpl);
			
			if(this.config.cls){
				this.dom.addClass(this.config.cls);
			}
			
			this.list=this.find("list");
			this.list.hide();
			
			this.stage=this.find("show");
			
			var tpl=this.list.html();
			
			var items=[];
			for( var i=0; i<this.data.length; i++){
				var d = this.data[i];
				if (d.value == "define") {
					items.push("<li><a js-select-item='option' value='define' href='javascript:void(0);' tabindex='-1'>" + this.config.defineTpl + "</a></li>");
				}else if(d.value == "day"){
					items.push("<li><a js-select-item='option' value='day' href='javascript:void(0);' tabindex='-1'>" + this.config.dayTpl + "</a></li>");
				}else {
					items.push(tpl.replace(/\{name\}/g,this.data[i].name).replace(/\{value\}/g,this.data[i].value));
				}
			}
			this.list.html(items.join(""));
			
			this.change(this.link.selectedIndex);
			this.tpl=tpl;
			if (this.config.define) {
				this.defindObj = this.list.find("input[de]");
			}
			
		},
		
		update: function(){
			this.init(this.link);
			
			this.list.html('');
			var items=[], tpl=this.tpl;
			for( var i=0; i<this.data.length; i++){
				items.push(tpl.replace(/\{name\}/g,this.data[i].name).replace(/\{value\}/g,this.data[i].value));
			}
			this.list.html(items.join(""));
			
			var _index=this.selectedIndex;
			this.selectedIndex=-1;
			this.change(_index);
			
			this.initOptionsEvents();
		},
		
		hide: function(e){
			this.list.hide();
			
			if(e){
				e.stopPropagation();
			}
			
			this.doc.unbind("mousedown",this._hide);
			this.shown=false;
			if(current==this){
				current=false;
			}
		},
		
		show: function(e){
			this.list.show();
			
			if(e){
				e.stopPropagation();
				if(current&&current!=this){
					current.hide();
				}
			}
			
			this.doc.bind("mousedown",this._hide);
			this.shown=true;
			current=this;
		},
		
		bindEvents: function(){
			var self=this;
			this.stage.bind("mousedown",$.proxy(function(e){
				
				if(e.which!=1){
					return;
				}
				if($(e.target).attr("type") == "text") {
					return;
				}
				e.stopPropagation();
				e.preventDefault();
				if(this.shown){
					this.hide(e);
				}else{
					this.show(e);
				}
			},this));
			
			this.stage.bind("click",function(e){ e.preventDefault(); });
			this.stage.bind("dblclick",function(e){ e.preventDefault(); });
			this.stage.bind("mousemove",function(e){ e.preventDefault(); });
			
			
			
			this._hide=function(){
				self.hide();
			};
			
			this.list.bind("mouseenter",function(){
				self.doc.unbind("mousedown",self._hide);
			});
			
			this.list.bind("mouseleave",function(){
				self.doc.bind("mousedown",self._hide);
			});
			
			this.dom.bind("mousemove",function(e){
				e.preventDefault();
			});
			
			this.initOptionsEvents();
			
			
		},
		
		initOptionsEvents: function(){
			var self=this;
			this.find("option").each(function(i,v){
				$(v).bind("mouseup",function(e){
					if(e.which!=1){
						return;
					}
					var item=$(this);
					self.change(i,e);
					self._hide();
					e.stopPropagation();
					e.preventDefault();
				});
			});
		},
		/**
		 *将模拟select插入到真实select前 
		 *隐藏真实select并将真实select位置移到不可见区域内 
		 */
		load: function(){
			this.dom.insertBefore($(this.link).hide());
			$(this.link).css({"position":"absolute","left":"-10000px","top":"-10000px"});
			if (this.config.define) {
				$(this.link).append("<option id='define'></option>");
			}
			if(this.config.day) {
				$(this.link).append("<option id='day'></option>");
			}
		},
		/**
		 * 根据index 更新模拟select 和 真实select选项
         * @param {Object} index
         * @param {Object} eve
		 */
		change: function(index,eve){
		
			if(index<0||index>=this.data.length||index==this.selectedIndex){
				return;
			}
		
			this.selectedIndex=index;
			var define = (this.data[this.selectedIndex].value == "define");
			var day = (this.data[this.selectedIndex].value == "day");
			if (define || day) {
				var html = this.config.defineTpl;
				if(day){
					html = this.config.dayTpl;
				}
				this.stage.html(html);
				this.value = "";
				this.link.selectedIndex=this.selectedIndex;
				if(eve){
					$(this.link).trigger("change",[this.val()]);
					this.dom.trigger("change",[this.val()]);
				}
				return;
			} 
			
			//如果name长度大于14 格式化成前14个字符 加 ...
			var name = this.data[this.selectedIndex].name;
			this.stage.html(name.length > 14 ? 
			    (name.substring(0, 14) + "...") :
			    name
			);
			this.value=this.data[this.selectedIndex].value;
			
			this.link.selectedIndex=this.selectedIndex;
			
			if(eve){
				$(this.link).trigger("change",[this.val()]);
				this.dom.trigger("change",[this.val()]);
			}
		},
		
		val: function(){
			if(arguments.length){
				var v=arguments[0].toString();
				var f = false;
				for( var i=0; i<this.data.length; i++){
					if(this.data[i].value==v){
						this.change(i,arguments[1]);
						f = true;
						break;
					}
				}
				if (!f && this.config.define) {
					this.change(this.data.length - 1);
					this.stage.find("input").val(v);
					this.stage.find("input").change();
				}
				
				return this.value;
			}else{
				return this.value;
			}
		},
		
		find: function(items){
			
			if(typeof items=="undefined"){
				return this.dom.find("["+this.config.key+"]");
			}
		
			if(!(items instanceof Array)){
				return this.find([items]);
			}
			
			var ps=[];
			for( var i=0; i<items.length; i++){
				ps.push("["+this.config.key+"='"+items[i]+"']");
			}
			
			return this.dom.find(ps.join(","));
		},
		
		addClass: function(arg){
			this.dom.addClass(arg);
			return this;
		},
		
		removeClass: function(){
			this.dom.removeClass(arg);
			return this;
		},
		
		bind: function(eve,func){
			$(this.link).bind(eve,func);
			return this;
		},
		
		unbind: function(eve,func){
			$(this.link).unbind(eve,func);
			return this;
		}
	});
	
	$.fn.csSelect=function(args){
		if(this[0]){
			new csSelect(this[0],args);
		}
		
		return this;
	}
	
	$.csSelect=function(el,args){
		var el=$(el);
		
		if(el[0]){
			return new csSelect(el[0],args);
		}
		return false;
	}

})(jQuery);