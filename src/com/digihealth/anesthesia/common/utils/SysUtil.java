package com.digihealth.anesthesia.common.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class SysUtil {
    public static boolean isEmptyList(List<?> obj) {
        if (obj == null || obj.isEmpty()) {
            return true;
        }

        return false;
    }

    public static boolean isEmptyStr(String str) {
        if (str == null || str.equals("")) {
            return true;
        }

        return false;
    }

    public static Date getCurrentDate() {
        Date currDate = new java.util.Date();
        return currDate;
    }
    
    public static Timestamp getCurrentTimeStamp() {
        Timestamp timeStamp = new java.sql.Timestamp(getCurrentDate().getTime());
        return timeStamp;
    }

    public static Timestamp getCurrentTimeStamp(Date date) {
        Timestamp timeStamp = new java.sql.Timestamp(date.getTime());
        return timeStamp;
    }

    public static String getTimeFormat(Date date) {
        SimpleDateFormat dateformat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        return dateformat.format(date);
    }

    public static String getTimeFormat(Timestamp time) {
        SimpleDateFormat dateformat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        return dateformat.format(time);
    }

    public static Timestamp getTimestamp(String time) {
        SimpleDateFormat dateformat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = dateformat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return getCurrentTimeStamp(date);
    }
    
    public static Date getDate(String time) {
        SimpleDateFormat dateformat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = dateformat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    
    public static String getDateFormat(Date date,String format){
    	SimpleDateFormat dateformat = new SimpleDateFormat(
                format);
        return dateformat.format(date);
    }
    
    public static Date getDate(String time,String format){
    	SimpleDateFormat dateformat = new SimpleDateFormat(
                format);
        Date date = null;
        try {
            date = dateformat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static float strParseToFloat(String tmp) {
        float value = 0;
        if (!isEmptyStr(tmp)) {
            value = Float.parseFloat(tmp);
        }

        return value;
    }

    public static int strParseToInt(String tmp) {
        int value = 0;
        if (!isEmptyStr(tmp)) {
            value = Integer.parseInt(tmp);
        }

        return value;
    }
    
    public static int getRandomNum() {
        int max=100;
        int min=1;
        Random random = new Random();

        return random.nextInt(max)%(max-min+1) + min;
    }
}
