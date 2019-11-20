
package com.caishen91.jupiter.util;

import com.caishen91.jupiter.exception.IllegalPlatformAugumentException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @since v1.1
 * @history
 * @see
 */
public class DateUtil
{
	private static Map<Integer,String> weekMap = new HashMap<Integer,String>();
	static{
		weekMap.put(1, "星期日");
		weekMap.put(2, "星期一");
		weekMap.put(3, "星期二");
		weekMap.put(4, "星期三");
		weekMap.put(5, "星期四");
		weekMap.put(6, "星期五");
		weekMap.put(7, "星期六");
	}
	
	/**
	 * 根据传入的时间返回不包含时分秒的date
	 * @param date
	 * @return
	 */
	public static Date truncateTime(Date date) {
		return parseDate(formatDate(date, "yyyy-MM-dd"), "yyyy-MM-dd");
	}
	public static Date parseDate(String ds, String pattern) {
		if(ds == null || ds.equals("")) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			Date d = sdf.parse(ds);
			return d;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String formatDate(Date d, String pattern) {
		if(d==null){
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(d);
	}
	
	/**
	 * 按毫秒获取时间
	 * @param times
	 * @param pattern
	 * @return
	 */
	public static String formatDateByLong( long times , String pattern ){
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis( times );
		return formatDate( calendar.getTime() , pattern );
	}
    
    public static String fomatToYYYYMMddHHmmss(Date date){
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    	return sdf.format(date);
    }

	public static String fomatToYYYY_MM_dd_HH_mm_ss(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
    
    
    public static String formatToMMDD(Date date){
    	SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
    	return sdf.format(date);
    }
    
    /**
     * 返回一个二维数组，单位分别是月和日，代表两个Date之差。 <br>
     * 本方法忽略小时和分钟。 <br>
     * <br>
     * 例： <br>
     * 1，2012年6月1日到2012年6月3日，返回值是[0,2] （2天） <br>
     * 2，2012年6月15日到2012年8月4日，返回值是[1,20] （1个月零20天） <br>
     * 3，2011年11月3日到2013年1月14日，返回值是[14,11] （14个月零11天）
     * 
     * @param olderDate
     *            较早的日期
     * @param newerDate
     *            较晚的日期
     * @return
     * @throws IllegalPlatformAugumentException
     *             当olderDate晚于newerDate时
     */
    public static int[] getDateDifferenceInMonthAndDay(Date olderDate, Date newerDate)
            throws IllegalPlatformAugumentException
    {
        int[] differenceInMonthAndDay = new int[2];
        int years = 0;
        int months = 0;
        int days = 0;

        Calendar older = Calendar.getInstance();
		Calendar newer = Calendar.getInstance();
		older.setTime(olderDate);
		newer.setTime(newerDate);
		
        if(olderDate.getTime()>newerDate.getTime()){
        	throw new IllegalPlatformAugumentException();
        }else{
        	years = newer.get(Calendar.YEAR)-older.get(Calendar.YEAR);
        	if(years>=0){
        		
        		months = newer.get(Calendar.MONTH)-older.get(Calendar.MONTH)+12*years;
            	older.add(Calendar.MONTH,months);
            	days = newer.get(Calendar.DATE)-older.get(Calendar.DATE);
            	
            	if(days<0){
            		months = months - 1;
            		older.add(Calendar.MONTH,-1);
            	}
            	
            	days = daysBetween(newer.getTime(),older.getTime());
            	differenceInMonthAndDay[0] = months;
            	differenceInMonthAndDay[1] = days;
        	}
        	
        }  
        return differenceInMonthAndDay;
    }

    /**
     * 取两个Date之间的天数差<br>
     * <br>例：newerDate是6月3日，olderDate是5月31日，则应返回3
     * <br>一个更极端的列子：newerDate是6月3日 00:01，olderDate是6月2日 23:59，则应返回1，说明相差一天，即便实际上只差2分钟
     * <br>此代码来自网上
     * <br>http://blog.csdn.net/rmartin/article/details/1452867
     * @param newerDate
     * @param olderDate
     * @return
     */
    public static int daysBetween(Date newerDate, Date olderDate)
    {
    	newerDate = DateUtil.parseDate(DateUtil.formatDate(newerDate, "yyyy-MM-dd HH:ss:mm"),"yyyy-MM-dd");
    	olderDate = DateUtil.parseDate(DateUtil.formatDate(olderDate, "yyyy-MM-dd HH:ss:mm"),"yyyy-MM-dd");
        long todayMs = newerDate.getTime();
        long returnMs = olderDate.getTime();
        long intervalMs = todayMs - returnMs;
        return millisecondsToDays(intervalMs);
    }

    public static String getLeftDay(Date newerDate, Date olderDate){
		int i = daysBetween(newerDate, olderDate);
		if(i == 0){
			return "今天";
		}else if(i == 1){
			return "明天";
		}else if(i == 2){
			return "后天";
		}else {
			return i+"天";
		}
	}
    
    
    public static int monthBetween(Date newerDate, Date olderDate)
    {
    	 Calendar c1=Calendar.getInstance();
         Calendar c2=Calendar.getInstance();
         c1.setTime( newerDate );
         c2.setTime(olderDate);
         int year =c2.get(Calendar.YEAR)-c1.get(Calendar.YEAR);
         
         if(year < 0){
             year=-year;
             return year*12+c1.get(Calendar.MONTH)-c2.get(Calendar.MONTH);
         }
        
         return year*12+c2.get(Calendar.MONTH)-c1.get(Calendar.MONTH);
    }


    private static int millisecondsToDays(long intervalMs)
    {
        return (int) (intervalMs / (1000 * 86400));
    }
    
    /**
     * 获取两个日期之间的用时
     * @param newerDate
     * @param olderDate
     * @return
     */
    public static String timeBetween(Date newerDate, Date olderDate)
    {
    	 
        long todayMs = newerDate.getTime();
        long returnMs = olderDate.getTime();
        long intervalMs = todayMs - returnMs;
        
        long time=intervalMs/1000;//转化成多少秒
        
        
        return  time/(60*60)+":"+((time%(60*60))/60+":"+time%60); 
    }
    
    

    private static void setTimeToMidnight(Calendar calendar)
    {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
    }
    /**
     * 得到距离当前时间前一个月的时间
     * @return
     * 
     */
    public static Date getLastMonthDate(){
    	Calendar lastMonthDate = Calendar.getInstance();
    	lastMonthDate.add(Calendar.MONTH, -1) ;
    	return lastMonthDate.getTime() ;
    }
    /**
     * 得到距离当前时间前一年的时间
     * @Title: getLastYearDate 
     * @param @return    
     * @return Date    返回类型 
     * @throws
     */
    public static Date getLastYearDate(){
    	Calendar lastYearDate = Calendar.getInstance();
    	lastYearDate.add(Calendar.YEAR, -1) ;
    	return lastYearDate.getTime() ;
    }
    /**
     * 得到距离所传时间前一个月的时间
     * @Title: getLastMonthDateByDate 
     * @param @param date
     * @param @return    
     * @return Date    返回类型 
     * @throws
     */
    public static Date getLastMonthDateByDate(Date date){
    	Calendar lastMonthDate = Calendar.getInstance();
    	lastMonthDate.setTime(date);
    	lastMonthDate.add(Calendar.MONTH, -1) ;
    	return lastMonthDate.getTime() ;
    }
    /**
     * 得到距离所传时间前一年的时间
     * @Title: getLastYearDateByDate 
     * @param @param date
     * @param @return    
     * @return Date    返回类型 
     * @throws
     */
    public static Date getLastYearDateByDate(Date date){
    	Calendar lastYearDate = Calendar.getInstance();
    	lastYearDate.setTime(date);
    	lastYearDate.add(Calendar.YEAR, -1) ;
    	return lastYearDate.getTime() ;
    }
    
    /**
     * 
     * @param _date
     * @param _day
     * @return
     */
    public static Date addDay(Date _date, int _day) {
		if (_day == 0)
			return _date;
		Calendar c = Calendar.getInstance();
		c.setTime(_date);
		c.add(Calendar.DAY_OF_YEAR, _day);
		return c.getTime();
	}

    public static Date addMinute(Date date, int mu) {
    	if (mu == 0) {
    		return date;
    	}

    	Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MINUTE , mu);
		return c.getTime();
    }

    /**
     *
     * @param _date
     * @param _day
     * @return
     */
    public static Date addDay2(Date _date, int _day) {
		if (_day == 0)
			return _date;
		Calendar c = Calendar.getInstance();
		c.setTime(_date);
		c.add(Calendar.DATE, _day);
		return c.getTime();
	}

    public static Date addMonth(Date _date, int _day){
		if (_day == 0)
			return _date;
		Calendar c = Calendar.getInstance();
		c.setTime(_date);
		c.add(Calendar.MONTH, _day);
		return c.getTime();
	}
    
    public static Date getFirstDatetime(){
    	Calendar c = Calendar.getInstance();
    	c.set(Calendar.DAY_OF_MONTH, 1);
    	return c.getTime();
    }
    /**
     * 获取本月最后一天时间
     * @Title: getLastDateTime 
     * @param @return    
     * @return Date    返回类型 
     * @throws
     */
    public static Date getLastDateTime(){
    	Calendar c = Calendar.getInstance();    
	    c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));  
	    return c.getTime();
    }
    
    public static int getTransLeftDay(int totalDay, Date investorDate, Date transDate) {
    	int past = daysBetween(transDate, investorDate);
    	return totalDay - past + 1;
    }
    public static int getTransLeftDay(int totalDay, Date investorDate) {
    	return getTransLeftDay(totalDay, investorDate, new Date());
    }
    
    public static int getTotalDay(int termCount, int termUnit) {
    	int totalDay = 0;
    	switch (termUnit) {
		case 1: 
			totalDay = termCount;
			break;
		case 2:
			totalDay = termCount * 7;
			break;
		case 3:
			totalDay = termCount * 30;
			break;
		}
    	return totalDay;
    }
    
    public static String getWeekDesc(Date date){
    	Calendar c = Calendar.getInstance();
    	c.setTime(date);
    	int day_of_week = c.get(Calendar.DAY_OF_WEEK);
    	return weekMap.get(day_of_week);
    	
    }
    
    public static Date getRapeseedExpireDate(Date date){
    	Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, 1);
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		
		return getDateNoTime(cal.getTime());
    }
    
    public static Date getNextYear(Date date, int year){
    	Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, 1);
		return cal.getTime();
    }
    
    public static Date getDateNoTime(Date date) {
    	return DateUtil.parseDate( DateUtil.formatDate(date, "yyyy-MM-dd"), "yyyy-MM-dd");
    }
    
    public static Date getNextDateNoTime(Date date, int day) {
    	Date nd = DateUtil.parseDate( DateUtil.formatDate(date, "yyyy-MM-dd"), "yyyy-MM-dd");
    	return getNextDate(nd, day);
    }
    public static Date getNextDate(Date date,int day){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, day);
		return cal.getTime();
	}    
       
    public static void main(String[] args) throws Exception {
    	
    	String s1 = "2017-02-01";
    	Date d1 = DateUtil.parseDate(s1, "yyyy-MM-dd");
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(d1);
    	calendar.add(Calendar.MONTH, 1);
    	Date d2 = calendar.getTime();
    	String s2 = DateUtil.formatDate(d2, "yyyy-MM-dd");
    	System.out.println(s2);
    }
    
    public static String getTimeKey() {
		String timeKey = System.currentTimeMillis() + "";
		return timeKey;
	}
    
    public static Boolean isBetweenHours(int startHours, int endHours,Date nextRepayTime) {
    	if(nextRepayTime==null){
    		return false;
    	}else{
    		Date d = new Date();
    		if(DateUtil.formatDate(d, "yyyyMMdd").equals(DateUtil.formatDate(nextRepayTime, "yyyyMMdd"))){
    			return false;
    		}else{
    			Calendar calendar = Calendar.getInstance();
    			calendar.setTime(new Date());
    			int hour = calendar.get(Calendar.HOUR_OF_DAY);
    			if(hour >= endHours)
    				return false;
    			if(hour < startHours)
    				return false;
    			if(hour == startHours){
    				int min = calendar.get(Calendar.MINUTE);
    				if(min < 30)
    					return false;
    			}
    			return true;
    		}
    	}
	}
    
    /**
     * 获取某日期最后一天 
     * @param date
     * @return
     */
    public static String getLastDayOfMonth(Date date) {   
		  Calendar cal = Calendar.getInstance();
		  cal.setTime(date);
	      cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DATE));
	      return  new   SimpleDateFormat( "yyyy-MM-dd ").format(cal.getTime());
	   } 
    
    public static Date getLastDayOfMonthExt(Date date){
    	  Calendar cal = Calendar.getInstance();
		  cal.setTime(date);
	      cal.set(Calendar.DAY_OF_MONTH,cal.getActualMaximum(Calendar.DATE));
	      return  cal.getTime();
    }
    
    public static Date getFirstDayOfMonthExt(Date date){
    	  Calendar cal = Calendar.getInstance(); 
	      cal.setTime(date);
	      cal.set(Calendar.DAY_OF_MONTH,cal.getMinimum(Calendar.DATE));
	      return cal.getTime();
    }
    /**
     * 获取某日期第一天	
     * @param date
     * @return
     */
	 public static String getFirstDayOfMonth(Date date) {   
	       Calendar cal = Calendar.getInstance(); 
	       cal.setTime(date);
	       cal.set(Calendar.DAY_OF_MONTH,cal.getMinimum(Calendar.DATE));
	       return   new   SimpleDateFormat( "yyyy-MM-dd ").format(cal.getTime());
	  }
	 
	 public static Map<String,Object> getHbiDate(Date edate, int days,int diff, int internalDay){
		 Map<String,Object> map = new HashMap<String,Object>();
		 Calendar cal = Calendar.getInstance(); 
		 if(internalDay == 7){
			 edate = addDay(edate,-1*internalDay);
			 cal.setTime(edate);
			 map.put("sdate", cal.getTime());
			 edate = addDay(edate,(days == 1 && diff > 0)? diff-1 : diff);
			 cal.setTime(edate);
			 map.put("edate", cal.getTime());
		 }else{
			 cal.setTime(edate);
			 cal.add(Calendar.MONTH, -1);
			 map.put("sdate", cal.getTime());
			 edate = addDay(cal.getTime(),(days == 1 && diff > 0)? diff-1 : diff);
			 cal.setTime(edate);
			 map.put("edate", cal.getTime());
		 }
		 map.put("days", days);
		 return map;
	 }
	 
	 public static Map<String,Object> getTbiDate(Date sdate, int days,int diff){
		 Map<String,Object> map = new HashMap<String,Object>();
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(sdate);
		 cal.add(Calendar.YEAR, -1);
		 map.put("sdate", cal.getTime());
		 
		 sdate = addDay(cal.getTime(),diff);
		 map.put("edate", sdate);
		 map.put("days", days);
		 return map;
	 }
	 
	 public static Map<String,Object> getPreWeekInfo(Date date){
		 Calendar cal = Calendar.getInstance(); 
	     cal.setTime(date);
	     int day_of_week = cal.get(Calendar.DAY_OF_WEEK);
	     if(day_of_week == 1){
	    	 cal.setTime(addDay(date,-1));
	     }
	     Date day = addDay(cal.getTime(),-7);
	     cal.setTime(day);
	    Map<String,Object> map = new HashMap<String,Object>();
	    cal.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
	    map.put("sdate", cal.getTime());
	    map.put("edate", addDay(cal.getTime(),6));
	    map.put("diff", 6);
	    map.put("days", 7);
	    
	    return map;
	 }
	 
	 public static Date getComFirstDayOfWeek(Date date){
		 Calendar cal = Calendar.getInstance(); 
	     cal.setTime(date);
	     int day_of_week = cal.get(Calendar.DAY_OF_WEEK);
	     if(day_of_week == 1){
	    	 date = addDay(date,-1);
	     }
	     return getFirstDayOfWeek(date);
	 }
	 
	 public static Date getFirstDayOfWeek(Date date){
		 Calendar cal = Calendar.getInstance(); 
	     cal.setTime(date);
	     cal.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
	     return   cal.getTime();
	 }
	 
	 public static Date getFirstDateOfMonth(Date date) {   
	       Calendar cal = Calendar.getInstance(); 
	       cal.setTime(date);
	       cal.set(Calendar.DAY_OF_MONTH,cal.getMinimum(Calendar.DATE));
	       return  cal.getTime();
	  }
	 
	 /**
	  * 
	  * @param startTime  --时间 HH:mm:ss
	  * @param endTime	  --结束时间  HH:mm:ss
	  * @return
	  */
	 public static boolean TimeBetween ( Date startTime , Date endTime , Date current){
		 if ( current.after( startTime ) && current.before( endTime ) ){
			 return true ;
		 }
		 return false ;
	 }
	 
	 public static List<HashMap<String,Object>> getAllWeekBeginAndEndTime(Date beginTime , Date endTime){
		 List<HashMap<String, Object>> list =  new ArrayList<HashMap<String,Object>>();
		 HashMap<String, Object> m = new HashMap<String, Object>();
		 //判断beginTime是否是周日 
		 Calendar  cal = Calendar.getInstance();
		 cal.setTime(beginTime);
		 int week=cal.get(Calendar.DAY_OF_WEEK)-1; 
		 if(week == 0){
			 m.put("beginTime", beginTime);
			 m.put("endTime", beginTime);
			 list.add(m);
			 
			 Date nextDay = DateUtil.addDay(beginTime, 1);
			 
			 
			 
		 }else{
			 
		 }
		 return list;
	 }
	 
	 public static Date getLastSecondOfDay(Date d) {
		 if (d == null) {
			 return null;
		 }
		 
		 String dStr = formatDate(d, "yyyy-MM-dd") + " 23:59:59";
		 return parseDate(dStr, "yyyy-MM-dd HH:mm:ss");
	 }
}
