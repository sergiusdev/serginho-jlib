package br.com.antoniosergius.lib.verif;

import br.com.antoniosergius.lib.tools.Deformat;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class MoneyVerifier extends NumberVerifier{
    
    private NumberFormat format;
    protected double value;
    
    public MoneyVerifier() {
        value = 0.0;
        format = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
        format.setMaximumFractionDigits(2);
        format.setMinimumFractionDigits(2);
    }
    
    public MoneyVerifier(int decimalFields) {
        value = 0.0;
        format = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
        format.setMaximumFractionDigits(decimalFields);
        format.setMinimumFractionDigits(decimalFields);
    }
    
    @Override
    protected void formatValue(JComponent input) {
        validate(input, true);
    }

    @Override
    protected boolean validate(JComponent input) {
        boolean isValid = true;
        JTextField field = (JTextField)input;
        String inputText = field.getText();
        if (inputText.isEmpty()) {
            return true;
        }
        if (inputText.matches("(((\\d{1,3}.)+\\d{3})|\\d+),\\d{1,6}")) {
            inputText = Deformat.decimal(inputText);
        }
        if (!inputText.matches("(\\d){1,15}\\.(\\d){1,6}") && //valor sem formato
            !inputText.matches("(\\d){1,12}"))  {
            isValid = false;
        }
        try {
            value = Double.parseDouble(inputText);
        } catch (NumberFormatException ex) {
            isValid = false;
        }
        if (value<0.0) {
            isValid = false;
        }
        if (!isValid) {
            field.selectAll();
        }
        return isValid;
    }
    
    protected boolean validate(JComponent input, boolean modify) {
        boolean isValid = validate(input);
        JTextField field = (JTextField)input;
        if (modify && isValid && !field.getText().equals("")) {
            field.setText(value != 0.0 ? format.format(value) : "");
        }
        return isValid;
    }

    @Override
    public boolean verify(JComponent input) {
        return validate(input, false);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        if (Character.isSpaceChar(e.getKeyChar())) {
            e.consume();
        } else if (!Character.isDigit(e.getKeyChar()) &&
            !Verifier.isFunctionKey(e) &&
            e.getKeyChar() != ',' &&
            e.getKeyChar() != '.') {
                    
            e.consume();        
        }    
    }
}
