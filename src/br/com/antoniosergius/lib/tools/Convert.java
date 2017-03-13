package br.com.antoniosergius.lib.tools;

import java.util.Date;
import java.util.GregorianCalendar;

public class Convert {
    
    public static String nullToString(String str) {
        return str == null ? "" : str.trim();
    }
    
    public static GregorianCalendar strToGregorian(String strDate, String format) {
        if (!Parse.date(strDate, format)) {
            return null;
        }
        String []dateFields = strDate.split("/");
        int year;
        if (format.equals("dd/MM/yy")) {
            year = 2000 + Integer.parseInt(dateFields[2]);
        } else {
            year = Integer.parseInt(dateFields[2]);
        }
        
        GregorianCalendar gregorianObj = new GregorianCalendar(year, 
                                                          Integer.parseInt(dateFields[1])-1,
                                                          Integer.parseInt(dateFields[0]));
        return gregorianObj;
    }
    
    public static Date gregorianToDate(GregorianCalendar gregorianCal) {
        Date date = new Date(gregorianCal.getTimeInMillis());
        return date;
    }
    
    public static GregorianCalendar strToGregorian(String strDate) {
        if (!Parse.date(strDate)) {
            return null;
        }
        String []dateField = strDate.split("/");
        GregorianCalendar gregorianObj = new GregorianCalendar(Integer.parseInt(dateField[2]), 
                                                          Integer.parseInt(dateField[1])-1,
                                                          Integer.parseInt(dateField[0]));
        return gregorianObj;
    }
    
    public static GregorianCalendar strTimestampToGregorian(String strTimestamp) {
        if (!Parse.timestamp(strTimestamp)) {
            return null;
        }
        String []dateAndHour = strTimestamp.split(" ");
        String []dataField = dateAndHour[0].split("/");
        GregorianCalendar gregorianObj = new GregorianCalendar(Integer.parseInt(dataField[2]), 
                                                       Integer.parseInt(dataField[1])-1,
                                                       Integer.parseInt(dataField[0]));
        String []hourField = dateAndHour[1].split(":");
        gregorianObj.set(GregorianCalendar.HOUR_OF_DAY, Integer.parseInt(hourField[0]));
        gregorianObj.set(GregorianCalendar.MINUTE, Integer.parseInt(hourField[1]));
        return gregorianObj;
    }
    
    
    
}
