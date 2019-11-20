package com.caishen91.jupiter.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;


public class FormatUtil
{

	public static String formatCurrency(double cur) {
		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.CHINA);
		return numberFormat.format(cur);
	}
	
	public static String formatCurrency(BigDecimal cur) {
		return formatCurrency(cur.doubleValue());
	}
	
	public static String formatCurrency3(long cur){
		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.CHINA);
		return numberFormat.format(cur);
	}
	

	public static String formatCurrency2(double cur) {
		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.CHINA);
		String s= numberFormat.format(cur);
		int index=s.indexOf(".");
		if(index==-1){
			s+=".00";
		}else if(s.length()-index==1){
			s+="0";
		}
		return s;
	}
	/**
	 * 
	* @描述：货币金额格式化
	* @开发时间： 2014-10-21 下午6:00:35
	 */
	 public static String changeToBig(double value){  
	        char [] hunit = {'拾', '佰', '仟'};     
	        char [] vunit = {'万', '亿'};      
	        char [] digit = {'零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖'}; //数字表示   
	        long midVal = (long)(value * 100);     //转化成整形   
	        String valStr = String.valueOf(midVal);  //转化成字符串   
	        String head = valStr.substring(0, valStr.length() - 2);  //取整数部分    	 
			String rail = valStr.substring(valStr.length() - 2); // 取小数部分
			
	        String prefix = "" ;        //整数部分转化的结果    	   
	        String suffix = ""; // 小数部分转化的结果
	        
	        // 处理小数点后面的数
			if (rail.equals("00")) { // 如果小数部分为0
				suffix = "整";
			} else {
				suffix = digit[rail.charAt(0) - '0'] + "角"
						+ digit[rail.charAt(1) - '0'] + "分"; // 否则把角分转化出来
			}
	        
	        //处理小数点前面的数   
	        char [] chDig = head.toCharArray();     //把整数部分转化成字符数组   
	        char zero = '0';           //标志'0'表示出现过0   
	        byte zeroSerNum = 0;      //连续出现0的次数   
	        for(int i = 0; i <chDig.length; i++){     //循环处理每个数字   
	            int idx = (chDig.length - i - 1) % 4 ;    //取段内位置   
	            int vidx = (chDig.length - i - 1) / 4 ;   //取段位置   
	            if (chDig[i] == '0'){                //如果当前字符是0   
	                zeroSerNum ++ ;             //连续0次数递增   
	                if (zero == '0'){           //标志   
	                    zero = digit[0];  
	                } else if (idx == 0 && vidx > 0 && zeroSerNum < 4){  
	                    prefix += vunit[vidx - 1];  
	                    zero = '0';  
	                }  
	                continue;  
	            }  
	            zeroSerNum = 0;       //连续0次数清零   
	            if (zero != '0') {    //如果标志不为0,则加上,例如万,亿什么的   
	                prefix += zero;  
	                zero = '0';  
	            }  
	            prefix += digit[chDig[i] - '0'];      //转化该数字表示   
	            if (idx > 0) prefix += hunit[idx - 1];                    
	            if (idx == 0 && vidx > 0){  
	                prefix += vunit[vidx - 1];  //段结束位置应该加上段名如万,亿   
	            }  
	        }  
	        if (prefix.length() > 0)
				prefix += '元'; // 如果整数部分存在,则有圆的字样
	       
	        return prefix+suffix  ;
	     }  
	 
	 public static String  formatMoney(double cur){
			NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
			return numberFormat.format(cur);
		}
	 
	 
	 public static double  formatAccount(String account){
		 	if(StringUtil.isEmpty(account)){
		 		double db = 0.00;
		 		return db;
		 	}
			String ss = "";
			String [] sList =account.split(",");
			for(int i= 0 ;i<sList.length;i++){
				ss +=sList[i];
			}
			BigDecimal b = new BigDecimal(ss); 
			double  f1  =  b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue(); 
		 	return f1;
		}	 
	 
	 public static BigDecimal[] splitInvestAmount(BigDecimal amount){
		 BigDecimal billUnit = new BigDecimal(100000000);
		 BigDecimal wanUnit = new BigDecimal(10000);
		 BigDecimal[] billRes = amount.divideAndRemainder(billUnit);
		 BigDecimal[] result = new BigDecimal[2];
		 result[0] = billRes[0];
		 BigDecimal[] wanRes = billRes[1].divideAndRemainder(wanUnit);
		 result[1] = wanRes[0];
		 return result;
	 }
	 
	 public static double getInvestAmountBill(BigDecimal amount){
		 BigDecimal billUnit = new BigDecimal(100000000);
		 BigDecimal r = amount.divide(billUnit, 8,BigDecimal.ROUND_HALF_EVEN);
		 return r.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
	 }
	 
	 public static String[] splitAmount(BigDecimal amount){
		 String amtstr = amount.toString();
		 int dot = amtstr.indexOf(".");
		 String[] res = new String[2];
		 if(dot == -1){
			 res[0] = amtstr;
			 res[1] = "00";
		 }else{
			 res[0] = amtstr.substring(0, dot);
			 res[1] = amtstr.substring(dot+1, amtstr.length());
			 if(res[1].length() == 1){
				 res[1] = res[1] + "0";
			 }
		 }
		 return res;
	 }

	 public static String formatNumber(int number,int unit){
			StringBuffer sb = new StringBuffer();
			while(unit/10 > 0){
				sb.append(number/unit);
				if(unit == 10){
					sb.append(number%unit);
				}
				number %= unit;
				unit /= 10;
			}
			return sb.toString();
		}
	 
	 /**
	  * 字符串长度输出 不够前边补0
	  * @param num
	  * @param length
	  * @return
	  */
	 public static String formatStringLength( String str , int length ){
		 if ( str == null   ){
			 str = "";
		 }
	     while ( str.length() < length ) {
	    	 str = "0" + str;
	     }
	     return str;
	 }
	 
	public static String formatDoubleNoDotZero(BigDecimal src) {
		
		if (src.doubleValue() == src.intValue()) {
			return src.intValue() + "";
		}
		
		DecimalFormat a = new DecimalFormat(".####"); 
		
		return a.format(src.doubleValue());
	}
	
	public static void main(String[] args)
	{
		DecimalFormat a = new DecimalFormat("0000"); 
		int d = 1;
		
		System.out.println(a.format(d));
		
	}

}
