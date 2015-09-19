package br.com.antoniosergius.lib.verif;

import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class IntegerVerifier extends NumberVerifier{

    private String format;
    private DecimalFormat formatter;
    private int stringSize;
    private double value;
    
    public IntegerVerifier(int stringSize) {
        value = 0.0;
        this.stringSize = stringSize;
        
        StringBuilder temp = new StringBuilder();
        for (int i=0; i<stringSize; i++) {
            temp.append("0");
        }
        format = temp.toString();
        formatter = new DecimalFormat(format);
        formatter.setParseIntegerOnly(true);
        formatter.setMinimumIntegerDigits(stringSize);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        JTextField textField = (JTextField) e.getComponent();
        if (cursorPosition > stringSize-1) {
            e.consume();
            return;
        }
        if (cursorPosition > stringSize-1 || textField.getText().length()>=stringSize) {
            if (textField.getSelectedText()==null) {
                e.consume();
                return;
            }
        }
        if (!Character.isDigit(e.getKeyChar()) && !Verifier.isFunctionKey(e)) {
            e.consume();
        }    
    }

    @Override
    protected void formatValue(JComponent input) {
        validate(input, true);
    }

    @Override
    public boolean verify(JComponent input) {
        return validate(input, false);
    }

    @Override
    public boolean validate(JComponent input) {
        boolean isValid = true;
        JTextField field = (JTextField)input;
        String strInput = field.getText().trim();
        if (strInput.isEmpty()) {
            return true;
        }
        try {
            value = Integer.parseInt(strInput);
        } catch (NumberFormatException ex) {
            isValid = false;
        }
        if (value < 0 || value > Math.pow(10, stringSize)-1){
            isValid = false;
        } 
        return isValid;
    }
    
    protected boolean validate(JComponent input, boolean modify) {
        boolean isValid = validate(input);
        JTextField field = (JTextField)input;
        if (modify && isValid && field.getText().length() <= stringSize-1) {
            String text = field.getText();
            if (!text.equals("")) {
                field.setText(formatter.format(value));
            }
        }
        return isValid;
    }
}
