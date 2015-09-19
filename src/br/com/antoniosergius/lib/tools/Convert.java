package br.com.antoniosergius.lib.tools;

import java.util.Date;
import java.util.GregorianCalendar;

public class Convert {
    
    public static String nullToString(String str) {
        return str == null ? "" : str.trim();
    }
    
    public static GregorianCalendar toGregorian(String strData, String formato) {
        if (!Parse.date(strData, formato)) {
            return null;
        }
        String []dateFields = strData.split("/");
        int ano;
        if (formato.equals("dd/MM/yy")) {
            ano = 2000 + Integer.parseInt(dateFields[2]);
        } else {
            ano = Integer.parseInt(dateFields[2]);
        }
        
        GregorianCalendar objData = new GregorianCalendar(ano, 
                                                          Integer.parseInt(dateFields[1])-1,
                                                          Integer.parseInt(dateFields[0]));
        return objData;
    }
    
    public static Date toDate(GregorianCalendar gregorianCal) {
        Date date = new Date(gregorianCal.getTimeInMillis());
        return date;
    }
    
    public static GregorianCalendar toGregorian(String strDate) {
        if (!Parse.date(strDate)) {
            return null;
        }
        String []dateField = strDate.split("/");
        GregorianCalendar date = new GregorianCalendar(Integer.parseInt(dateField[2]), 
                                                          Integer.parseInt(dateField[1])-1,
                                                          Integer.parseInt(dateField[0]));
        return date;
    }
    
    public static GregorianCalendar toGregorianTimestamp(String strDate) {
        if (!Parse.timestamp(strDate)) {
            return null;
        }
        String []dateAndHour = strDate.split(" ");
        String []dataField = dateAndHour[0].split("/");
        GregorianCalendar date = new GregorianCalendar(Integer.parseInt(dataField[2]), 
                                                       Integer.parseInt(dataField[1])-1,
                                                       Integer.parseInt(dataField[0]));
        String []hourField = dateAndHour[1].split(":");
        date.set(GregorianCalendar.HOUR_OF_DAY, Integer.parseInt(hourField[0]));
        date.set(GregorianCalendar.MINUTE, Integer.parseInt(hourField[1]));
        return date;
    }
    
}
