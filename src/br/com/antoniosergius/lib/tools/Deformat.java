package br.com.antoniosergius.lib.tools;

public class Deformat {
    
    public static String decimal(String strValor) {
        String novoValor = strValor.replaceAll("\\.", "");
        novoValor = novoValor.replace(",", ".");
        return novoValor;
    }
    
    public static Double andConvertDecimal(String strValue) {
        String newValue = Deformat.decimal(strValue);
        return Double.parseDouble(newValue);
    }
    
    public static String CPForCNPJ(String strNumber){
        if (strNumber.equals("")) {
            return "";
        }
        StringBuilder formatted = new StringBuilder(strNumber);
        if (!strNumber.contains(".") && !strNumber.contains("-") && !strNumber.contains("/")) {
            return strNumber;
        } else if (!strNumber.contains(".") && !strNumber.contains("-")) {
            return strNumber;
        }
        if (strNumber.length()==14) { //cpf
            formatted.deleteCharAt(3);
            formatted.deleteCharAt(6);
            formatted.deleteCharAt(9);
        } else if (strNumber.length()==18) {//cnpj
            formatted.deleteCharAt(2);
            formatted.deleteCharAt(5);
            formatted.deleteCharAt(8);
            formatted.deleteCharAt(12);
        }
        return formatted.toString();
    }
}
