package br.com.antoniosergius.lib.tools;

import java.util.Date;
import java.util.GregorianCalendar;
import org.joda.time.DateMidnight;

public class Days {
    
    public static GregorianCalendar TODAY = new GregorianCalendar();
    public static final long IN_MILLIS = 86400000;
    public static final int IN_YEAR = 365;
    
    public static void setTodayToMidnight() {
        TODAY.set(GregorianCalendar.MILLISECOND, 0);
        TODAY.set(GregorianCalendar.SECOND, 0);
        TODAY.set(GregorianCalendar.MINUTE, 0);
        TODAY.set(GregorianCalendar.HOUR_OF_DAY, 0);
    }
    
    public static void setToLastMinute(GregorianCalendar date) {
        date.set(GregorianCalendar.MILLISECOND, 999);
        date.set(GregorianCalendar.SECOND, 59);
        date.set(GregorianCalendar.MINUTE, 59);
        date.set(GregorianCalendar.HOUR_OF_DAY, 23);
    }
    
    public static Date setToLastMinute(Date dt) {
        GregorianCalendar date = new GregorianCalendar();
        date.setTime(dt);
        date.set(GregorianCalendar.MILLISECOND, 999);
        date.set(GregorianCalendar.SECOND, 59);
        date.set(GregorianCalendar.MINUTE, 59);
        date.set(GregorianCalendar.HOUR_OF_DAY, 23);
        return date.getTime();
    }
    
    public static boolean equals(GregorianCalendar date1, GregorianCalendar date2) {
        if (date1 == null || date2 == null) {
            return false;
        }
        DateMidnight dateMid1 = new DateMidnight(date1.getTimeInMillis());
        DateMidnight dateMid2 = new DateMidnight(date2.getTimeInMillis());
        return dateMid1.equals(dateMid2);
    }
    
    public static boolean isToday(GregorianCalendar date) {
        if (date == null) {
            return false;
        }
        DateMidnight today = new DateMidnight(TODAY.getTimeInMillis());
        DateMidnight other = new DateMidnight(date.getTimeInMillis());
        return today.equals(other);
    }
    
    public static int between(GregorianCalendar begin, GregorianCalendar end) {
        return Days.between(begin.getTimeInMillis(), end.getTimeInMillis());
    }
    
    public static int between(Date inicio, Date fim) {
        return Days.between(inicio.getTime(), fim.getTime());
    }
    
    public static int between(long begin, long end) {
        DateMidnight beginMid = new DateMidnight(begin);
        DateMidnight endMid = new DateMidnight(end);
        return org.joda.time.Days.daysBetween(beginMid, endMid).getDays();
    }
    
    public static void setupExpiration(GregorianCalendar exp) {
        long todayMilli = Days.TODAY.getTimeInMillis();
        long auxDateMilli = exp.getTimeInMillis();
        long diffInDays = (todayMilli-auxDateMilli)/Days.IN_MILLIS;
        if (diffInDays > 180) {
            exp.add(GregorianCalendar.YEAR, 1);
        } 
    }
}
