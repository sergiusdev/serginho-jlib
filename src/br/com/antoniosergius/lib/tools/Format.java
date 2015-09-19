package br.com.antoniosergius.lib.tools;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.StringTokenizer;

public class Format {
   
    public static final String DATE_DEFAULT = "dd/MM/yyyy";
    public static final String TIMESTAMP_DEFAULT = "dd/MM/yyyy HH:mm";
    
    public static String zeroFill(int zeros, int number) {
        StringBuilder pattern = new StringBuilder("0");
        for (int i=0; i<zeros-1; i++) {
            pattern.append("0");
        }
        return new DecimalFormat(pattern.toString()).format(number);
    }
    
    public static String agency(int agency) {
        return Format.number("0000", agency);
    }
    
    public static String bank(int bank) {
        return Format.number("000", bank);
    }
    
    public static String clientId(int id) {
        return Format.number("000", id);
    }
    
    public static String checkNumber(int number) {
        return Format.number("000000", number);
    }
    
    public static String number(String format, Number number) {
        return new DecimalFormat(format).format(number);
    }
    
    public static String currency(Number number) {
        return NumberFormat.getCurrencyInstance(Locale.getDefault()).format(number);
    }
    
    public static String currency(Number number, Locale locale) {
        return NumberFormat.getCurrencyInstance(locale).format(number);
    }
    
    public static String decimal(Number number) {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.getDefault());
        formatter.setMaximumFractionDigits(2);
        formatter.setMinimumFractionDigits(2);
        return formatter.format(number);
    }
    
    public static String decimal(Number number, int fields) {
        NumberFormat formatter = NumberFormat.getNumberInstance(Locale.getDefault());
        formatter.setMaximumFractionDigits(fields);
        formatter.setMinimumFractionDigits(fields);
        return formatter.format(number);
    }
    
    public static String timestamp(GregorianCalendar date) {
        return Format.timestamp(date.getTime());
    }
    
    public static String timestamp(Date date) {
        return new SimpleDateFormat(Format.TIMESTAMP_DEFAULT).format(date);
    }
    
    public static String date(GregorianCalendar date) {
        if (date==null) {
            return "null";
        }
        return Format.date(date.getTime());
    }
    
    public static String date(Date date) {
        return new SimpleDateFormat(Format.DATE_DEFAULT).format(date);
    }
    
    public static String date(String format, GregorianCalendar date) {
        return Format.date(format, date.getTime());
    }
    
    public static String date(String format, Date date) {
        return new SimpleDateFormat(format).format(date);
    }
    
    public static String todayDate() {
        return Format.todayDate(Format.DATE_DEFAULT);
    }
    
    public static String todayDate(String format) {
        return new SimpleDateFormat(format).format(Days.TODAY.getTime());
    }
    
    public static String todayTimestamp() {
        return Format.todayDate(Format.TIMESTAMP_DEFAULT);
    }
    
    /**
     * Format nomes. Cada primeira letra de cada palavra é transformada em maiuscula.
     * O resto é minusculo. Se uma palavra tiver menos de 3 letras ela permanecerá minuscula.
     * @param name
     * @return
     */
    public static String name(String name) {
        StringTokenizer tokenizer = new StringTokenizer(name);
        StringBuilder all = new StringBuilder();
        while(tokenizer.hasMoreElements()) {
            StringBuffer temp = new StringBuffer(tokenizer.nextToken().toLowerCase().trim());
            if (temp.length() > 2) {
                temp.replace(0, 1, temp.substring(0, 1).toUpperCase());
            }
            all.append(temp).append(" ");
        }
        return all.toString().trim();
    }
    
    public static boolean isRegistryFormatted(String registry) {
        return registry.length()==14 || registry.length()==18;
    }
    
    public static String CPForCNPJ(String strNumber) {
        if (strNumber == null) {
            return "";
        }
        StringBuilder formatted = new StringBuilder(strNumber);
        if (strNumber.length()==11) { //cpf
            formatted.insert(3, ".");
            formatted.insert(7, ".");
            formatted.insert(11, "-");
        } else if (strNumber.length()==14){ //cnpj
            formatted.insert(2, ".");
            formatted.insert(6, ".");
            formatted.insert(10, "/");
            formatted.insert(15, "-");
        }
        return formatted.toString();
    }

    
}
