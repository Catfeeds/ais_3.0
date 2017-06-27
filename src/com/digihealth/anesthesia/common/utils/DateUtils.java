/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.digihealth.anesthesia.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 
     * Title: DateUtils.java    
     * Description: 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
     * @author chengwang       
     * @created 2015-10-8 下午1:59:07
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
	
	private static String[] parsePatterns = {
		"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM", 
		"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
		"yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

	
	
	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd）
	 */
	public static String getDate() {
		return getDate("yyyy-MM-dd");
	}
	
	public static String getDate(Date d){
		SimpleDateFormat sim = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return sim.format(d);
	}
	
	public static String DateToString(Date d){
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		return sim.format(d);
	}
	
	public static String getDateToString(){
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM");
		return sim.format(new Date());
	}
	
	public static String getDateToString(String date) throws ParseException{
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM");
		return sim.format(sim.parse(date));
	}
	
	
	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String getDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}
	
	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String formatDate(Date date, Object... pattern) {
		String formatDate = null;
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString());
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}
	
	/**
	 * 时间字符串格式转化为另外一种时间字符串格式
	 * @param str               要转化的字符串
	 * @param fromFormat        要转化的字符串格式
	 * @param toFormat          目标字符串的格式
	 * @return                  目标字符串
	 */
	public static String strToStr(String str,String fromFormat,String toFormat){
		if(str == null || str.trim().equals(""))
			return str;
		DateFormat fromTime = new SimpleDateFormat(fromFormat);
		DateFormat toTime = new SimpleDateFormat(toFormat);
		try{
			Date date = fromTime.parse(str);
			return toTime.format(date);
		}catch(ParseException e){
			return null;
		}
	}
	
	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String formatDateTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}
	
	
	public static String formatLongTime(Long time) {
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sim.format(time);
	}

	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss");
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateStringTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm");
	}

	/**
	 * 得到当前年份字符串 格式（yyyy）
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}

	/**
	 * 得到当天字符串 格式（dd）
	 */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}

	/**
	 * 得到当前星期字符串 格式（E）星期几
	 */
	public static String getWeek() {
		return formatDate(new Date(), "E");
	}
	
	/**
	 * 日期型字符串转化为日期 格式
	 * { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", 
	 *   "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm",
	 *   "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
	 */
	public static Date parseDate(Object str) {
		if (str == null){
			return null;
		}
		try {
			return parseDate(str.toString(), parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 获取过去的天数
	 * @param date
	 * @return
	 */
	public static long pastDays(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(24*60*60*1000);
	}

	/**
	 * 获取过去的小时
	 * @param date
	 * @return
	 */
	public static long pastHour(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(60*60*1000);
	}
	
	/**
	 * 获取过去的分钟
	 * @param date
	 * @return
	 */
	public static long pastMinutes(Date date) {
		long t = new Date().getTime()-date.getTime();
		return t/(60*1000);
	}
	
	/**
	 * 转换为时间（天,时:分:秒.毫秒）
	 * @param timeMillis
	 * @return
	 */
    public static String formatDateTime(long timeMillis){
		long day = timeMillis/(24*60*60*1000);
		long hour = (timeMillis/(60*60*1000)-day*24);
		long min = ((timeMillis/(60*1000))-day*24*60-hour*60);
		long s = (timeMillis/1000-day*24*60*60-hour*60*60-min*60);
		long sss = (timeMillis-day*24*60*60*1000-hour*60*60*1000-min*60*1000-s*1000);
		return (day>0?day+",":"")+hour+":"+min+":"+s+"."+sss;
    }
	
	/**
	 * 获取两个日期之间的天数
	 * 
	 * @param before
	 * @param after
	 * @return
	 */
	public static double getDistanceOfTwoDate(Date before, Date after) {
		long beforeTime = before.getTime();
		long afterTime = after.getTime();
		return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
	}
	
	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
//		System.out.println(formatDate(parseDate("2010/3/6")));
//		System.out.println(getDate("yyyy年MM月dd日 E"));
//		long time = new Date().getTime()-parseDate("2012-11-19").getTime();
//		System.out.println(time/(24*60*60*1000));
		
		//System.out.println(getDate(new Date()));
		
		String formatDate = DateUtils.formatDate(new Date(), "yyyy-MM-dd");
		System.out.println(formatDate);
	}
	
	public static Date getCurrDate(){
		Date d = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			return sim.parse(sim.format(d));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static Date getParseTime(String time){
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sim.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getParseNYRTime(String time){
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sim.format(sim.parse(time));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getParseSFMTime(String time){
		SimpleDateFormat sim = new SimpleDateFormat("HH:mm:ss");
		try {
			return sim.format(sim.parse(time));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	/**
     * 返回指定日期的季的第一天
     * 
     * @param year
     * @param quarter
     * @return
     */
    public static Date getFirstDayOfQuarter(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getFirstDayOfQuarter(calendar.get(Calendar.YEAR), getQuarterOfYear(date));
    }
    
    /**
     * 返回指定日期的季的最后一天
     * 
     * @param year
     * @param quarter
     * @return
     */
    public static Date getLastDayOfQuarter(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getLastDayOfQuarter(calendar.get(Calendar.YEAR), getQuarterOfYear(date));
    }
    
    /**
     * 返回指定日期的季度
     * 
     * @param date
     * @return
     */
    public static int getQuarterOfYear(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) / 3 + 1;
    }
	
    /**
     * 返回指定年季的季的第一天
     * 
     * @param year
     * @param quarter
     * @return
     */
    public static Date getFirstDayOfQuarter(Integer year, Integer quarter)
    {
        Calendar calendar = Calendar.getInstance();
        Integer month = new Integer(0);
        if (quarter == 1)
        {
            month = 1 - 1;
        }
        else if (quarter == 2)
        {
            month = 4 - 1;
        }
        else if (quarter == 3)
        {
            month = 7 - 1;
        }
        else if (quarter == 4)
        {
            month = 10 - 1;
        }
        else
        {
            month = calendar.get(Calendar.MONTH);
        }
        return getFirstDayOfMonth(year, month);
    }
    
    /**
     * 返回指定年季的季的最后一天
     * 
     * @param year
     * @param quarter
     * @return
     */
    public static Date getLastDayOfQuarter(Integer year, Integer quarter)
    {
        Calendar calendar = Calendar.getInstance();
        Integer month = new Integer(0);
        if (quarter == 1)
        {
            month = 3 - 1;
        }
        else if (quarter == 2)
        {
            month = 6 - 1;
        }
        else if (quarter == 3)
        {
            month = 9 - 1;
        }
        else if (quarter == 4)
        {
            month = 12 - 1;
        }
        else
        {
            month = calendar.get(Calendar.MONTH);
        }
        return getLastDayOfMonth(year, month);
    }
	
    /**
     * 返回指定年月的月的第一天
     * 
     * @param year
     * @param month
     * @return
     */
    public static Date getFirstDayOfMonth(Integer year, Integer month)
    {
        Calendar calendar = Calendar.getInstance();
        if (year == null)
        {
            year = calendar.get(Calendar.YEAR);
        }
        if (month == null)
        {
            month = calendar.get(Calendar.MONTH);
        }
        calendar.set(year, month, 1);
        return calendar.getTime();
    }
    
    /**
     * 返回指定年月的月的最后一天
     * 
     * @param year
     * @param month
     * @return
     */
    public static Date getLastDayOfMonth(Integer year, Integer month)
    {
        Calendar calendar = Calendar.getInstance();
        if (year == null)
        {
            year = calendar.get(Calendar.YEAR);
        }
        if (month == null)
        {
            month = calendar.get(Calendar.MONTH);
        }
        calendar.set(year, month, 1);
        calendar.roll(Calendar.DATE, -1);
        return calendar.getTime();
    }
	
    /**
     * 返回指定日期的月的第一天
     * 
     * @param year
     * @param month
     * @return
     */
    public static Date getFirstDayOfMonth(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 1);
        return calendar.getTime();
    }
    
    /**
     * 返回指定日期的月的最后一天
     * 
     * @param year
     * @param month
     * @return
     */
    public static Date getLastDayOfMonth(Date date)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 1);
        calendar.roll(Calendar.DATE, -1);
        return calendar.getTime();
    }
    
    /**
     * 返回指定年的第一天
     * 
     * @param year
     * @param month
     * @return
     */
    public static Date getFirstDayOfYear(int year)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        return calendar.getTime();
    }
    
    /**
     * 返回指定年的最后一天
     * @param year 年份
     * @return Date
     */
    public static Date getLastDayOfYear(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();
         
        return currYearLast;
    }
    
    public static java.sql.Date stringToDate(String s){
    	SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
    	try {
			return new java.sql.Date(sim.parse(s).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }
	
}
