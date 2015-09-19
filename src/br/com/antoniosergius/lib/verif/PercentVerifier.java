package br.com.antoniosergius.lib.verif;

import br.com.antoniosergius.lib.tools.Deformat;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class PercentVerifier extends MoneyVerifier{

    public PercentVerifier(int decimalFields) {
        super(decimalFields);
    }

    public PercentVerifier() {
    }

    
    @Override
    protected boolean validate(JComponent input) {
        boolean isValid = true;
        JTextField field = (JTextField)input;
        String strInput = field.getText().trim();
        if (strInput.isEmpty()) {
            return true;
        }
        if (strInput.matches("(\\d){1,2}\\,(\\d){1,10}")) {
            strInput = Deformat.decimal(strInput);
        }
        if (!strInput.matches("(\\d){1,2}\\.(\\d){1,10}") && //valor sem formato
            !strInput.matches("(\\d){1,2}"))  {
            isValid = false;
        }
        try {
            value = Double.parseDouble(strInput);
        } catch (NumberFormatException ex) {
            isValid = false;
        }
        if (value<0.0) {
            isValid = false;
        }
        return isValid;
    }
}
