package br.com.antoniosergius.lib.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;

public class Parse {
    public static boolean date(String strDate, String format) {
        if (strDate.contains(" ")) {
            return false;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            sdf.setLenient(false);
            sdf.parse(strDate);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }
    
    public static boolean date(String strDate) {
        return Parse.date(strDate, "dd/MM/yyyy");
    }
    
    public static boolean timestamp(String strDate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            sdf.setLenient(false);
            sdf.parse(strDate);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }
    
    /**
     * Verifica se o CPF é valido
     * @param CPF
     * @return 
     */
    public static boolean CPF(String CPF) {
        if (CPF.length() != 11) {
            return false;
        }
        char dig10, dig11;
        int sm, i, r, num, peso;
        try {
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
                num = CPF.charAt(i) - 48;  
                sm += (num * peso);
                peso -= 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            }
            else {
                dig10 = (char)(r + 48);
            } 
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
                num = CPF.charAt(i) - 48;
                sm += (num * peso);
                peso -= 1;
            }
            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            }
            else {
                dig11 = (char)(r + 48);
            }
            if (dig10 == CPF.charAt(9) && dig11 == CPF.charAt(10)) {
                return true;
            }
            else {
                return false;
            }
        } catch (InputMismatchException erro) {
            return false;
        }
    }
    
    /**
     * Verifica se o CNPJ é válido
     * @param CNPJ
     * @return 
     */
    public static boolean CNPJ(String CNPJ) {
        if (CNPJ.length() != 14) {
            return false;
        }
        char dig13, dig14;
        int sum = 0;
        int result; 
        int num;
        int weight=2;
        try {
            for (int i=11; i>=0; i--) {
                num = CNPJ.charAt(i) - 48;
                sum += (num * weight);
                weight += 1;
                if (weight == 10) {
                    weight = 2;
                }
            }
            result = sum % 11;
            if ((result == 0) || (result == 1)) {
                dig13 = '0';
            }
            else {
                dig13 = (char)((11-result) + 48);
            }
            sum = 0;
            weight = 2;
            for (int i=12; i>=0; i--) {
                num = CNPJ.charAt(i)- 48;
                sum += (num * weight);
                weight += 1;
                if (weight == 10) {
                    weight = 2;
                }
            }
            result = sum % 11;
            if ((result == 0) || (result == 1)) {
                dig14 = '0';
            }
            else {
                dig14 = (char)((11-result) + 48);
            }
            if (dig13 == CNPJ.charAt(12) && dig14 == CNPJ.charAt(13)) {
                return true;
            }
            else {
                return false;
            }
        } catch (InputMismatchException ex) {
            return false;
        }
    }
    
    public static boolean CNPJ2(String CNPJ) {
        if (CNPJ.length() != 14) {
            return false;
        }
        char dig13, dig14;
        int sum = 0;
        int result; 
        int num;
        int weight=2;
        try {
            for (int i=11; i>=0; i--) {
                num = CNPJ.charAt(i) - 48;
                sum += (num * weight);
                weight += 1;
                if (weight == 10) {
                    weight = 2;
                }
            }
            result = sum % 11;
            if ((result == 0) || (result == 1)) {
                dig13 = '0';
            }
            else {
                dig13 = (char)((11-result) + 48);
            }
            sum = 0;
            weight = 2;
            for (int i=12; i>=0; i--) {
                num = CNPJ.charAt(i)- 48;
                sum += (num * weight);
                weight += 1;
                if (weight == 10) {
                    weight = 2;
                }
            }
            result = sum % 11;
            if ((result == 0) || (result == 1)) {
                dig14 = '0';
            }
            else {
                dig14 = (char)((11-result) + 48);
            }
            if (dig13 == CNPJ.charAt(12) && dig14 == CNPJ.charAt(13)) {
                return true;
            }
            else {
                return false;
            }
        } catch (InputMismatchException ex) {
            return false;
        }
    }
    
    public static boolean CPForCNPJ(String registry) {
        if (registry.length()==11) {
            return Parse.CPF(registry);
        } else if (registry.length()==14) {
            return Parse.CNPJ(registry);
        } else {
            return false;
        }   
    }
}
