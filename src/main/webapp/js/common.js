/**
 * 等额本息月还本息
 * @param amount
 * @param rate
 * @param nMonth
 */
function getMonthMoney(amount,rate,month) {
    document.write(dightMath(getMonthMoneyReal(amount,rate,month),2));
}
function getMonthMoneyReal(amount,rate,month) {
    var rate_month = rate/1200.0;
    var tmp = Math.pow(1 + rate_month, month);
    var rs = amount * (rate_month * tmp)/(tmp - 1);
    return rs;
}

/**
 * 小数处理
 * @param dight
 * @param n
 * @returns
 */
function dightMath(dight, n){    
    dight = Math.round(dight*Math.pow(10,n))/Math.pow(10,n);
    return dight;    
 } 
/**
 * 按月还息，月还利息计算
 * @param amount
 * @param rate
 * @param productId
 */
function getMonthIntest(amount,rate,productId,termCount,termUnit) {
	var rate_month = rate/1200.0;
	if(productId == 1) {
		document.write(dightMath(amount*rate_month,2));
	}else if(productId == 2) {
		if(termUnit == 1) {
			document.write(dightMath(amount*rate/36000.0*termCount,2));
		}else if(termUnit == 3) {
			document.write(dightMath(amount*rate_month*termCount,2));
		}
	}
}
/**
 * 月还本息
 * @param amount
 * @param rate
 * @param month
 * @param productId
 */
function getMonthPrinIntes(amount,rate,month,productId,leftCount,termUnit) {
	if(productId == 1) {
		if(leftCount !=1) {
			document.write(dightMath(amount*rate/1200.0,2));
		}else {
			document.write(dightMath(amount*rate/1200.0,2)*1 + amount*1);
		}
	}else if(productId == 3) {
		getMonthMoney(amount,rate,month);
	}else if(productId == 2) {
		if(termUnit == 1) {
			document.write(dightMath(amount*rate/36000.0*month+ amount*1,2));
		}else if(termUnit == 3) {
			document.write(dightMath(amount*rate/1200.0*month + amount*1,2));
		}
	}
}

/**
 * 获取总利息的计算方法
 */
function getAllRepayInterest(amount,rate,month,productId,termUnit) {
	if(productId  ==  3) {
		return getAllOneReapyInterest(amount,rate,month);
	}else if(productId == 2) {
		return getAllArriveReapyInterest(amount,rate,month,termUnit);
	}else if(productId == 1) {
		return getAllMonthRepayInterest(amount,rate,month,productId);
	}
}
/**
 * 获取到期付本息的总利息方法
 * @param amount
 * @param rate
 * @param month
 * @param termUnit
 */
function getAllArriveReapyInterest(amount,rate,month,termUnit) {
	if(termUnit == 3) {
		return getAllOneReapyInterest(amount,rate,month);
	}else if(termUnit == 1) {
		return dightMath(amount * rate/36000.0 * month,2);
	}
}
/**
 * 等额本息获取总利息的计算方法
 */
function getAllMonthRepayInterest(amount,rate,month,productId) {
	var totalMoney = getMonthMoneyReal(amount,rate,month)*month;
	return dightMath(totalMoney - amount,2);
}
/**
 * 按月付息的总利息
 * @param amount
 * @param rate
 * @param month
 */
function getAllOneReapyInterest(amount,rate,month) {
	var rate_month = rate/1200.0;
	return dightMath(dightMath(amount*rate_month,2)*month,2);
}
/**
 * 获取还款方式
 * @param type
 */
function getRepayType(type) {
	var str;
	if(type == 1) {
		str = "按月付息";
	}else if(type == 3) {
		str = "等额本息";
	}else if(type == 2) {
		str = "到期付本息";
	}
	document.write(str);
}
/**
 * 返回还款方式显示
 */
function getRepayMonthMoney(amount,rate,month,productId,termUnit) {
	var str;
	if(productId == 1) {
		str = "每月付息：￥<span id='monthPay' class='red'>"+dightMath(amount*rate/1200.0,2)+"</span>";
	}else if(productId == 3) {
		str = "每月还款：￥<span id='monthPay' class='red'>"+dightMath(getMonthMoneyReal(amount,rate,month),2)+"</span>";
	}else if(productId == 2) {
		if(termUnit == 1) {
			str = "到期本息：￥<span id='monthPay' class='red'>"+dightMath((amount*1 + amount*rate/(100.0*360)*month),2)+"</span>";
		}else if(termUnit == 3) {
			str = "到期本息：￥<span id='monthPay' class='red'>"+dightMath((amount*1 + amount*rate/1200.0*month),2)+"</span>";
		}
	}
	document.write(str);
}
/**
 * 字符串是否含有html标签的检测
 * @param htmlStr
 */
function checkHtml(htmlStr) {
	var  reg = /<[^>]+>/g;
	return reg.test(htmlStr);
}

function openL2(title,content,closeEv, callback) {
	
	 var obj = null;
	 if (callback) {
		 obj = art.dialog({
				lock:true,
				title:title,	
			    content:content,
			    opacity:0.3,
			    ok: function () {
			    	callback();
			    },
			    close : function (){
			    	closeEv();
			    },
			    cancelVal: '关闭',
			    cancel: true 
		 }); 
	 } else {
		 obj = art.dialog({
				lock:true,
				title:title,	
			    content:content,
			    opacity:0.3,
			    close : function (){
			    	closeEv();
			    }
		 }); 
	 }
	 
	 return obj;
}

/**
 * 公共的弹窗方法
 * @param title 窗口标题
 * @param content 内容
 * @callback 确定的回调函数
 */
function openL(title,content,callback) {
	
	 var obj = null;
	 if(callback) {
		 obj = art.dialog({
				lock:true,
				title:title,	
			    content:content,
			    opacity:0.3,
			    ok: function () {
			    	callback();
			    },
			    cancelVal: '关闭',
			    cancel: true 
		 }); 
	 }else {
		 obj = art.dialog({
				lock:true,
				title:title,	
			    content:content,
			    opacity:0.3
		 }); 
	 }
	 return obj;
}