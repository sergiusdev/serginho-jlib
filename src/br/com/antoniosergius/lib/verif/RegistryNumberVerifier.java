package br.com.antoniosergius.lib.verif;

import br.com.antoniosergius.lib.tools.Deformat;
import br.com.antoniosergius.lib.tools.Format;
import br.com.antoniosergius.lib.tools.Parse;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class RegistryNumberVerifier extends Verifier{
    private boolean wantFormat;
    private boolean wantValidate;

    public RegistryNumberVerifier() {
        wantFormat = false;
        wantValidate = false;
    }

    public RegistryNumberVerifier(boolean wantFormat, boolean wantValidate) {
        this.wantFormat = wantFormat;
        this.wantValidate = wantValidate;
    }
    
    @Override
    protected boolean validate(JComponent input) {
        boolean isValid = true;
        JTextField field = (JTextField)input;
        String inputText = field.getText();
        if (inputText.isEmpty()) {
            return true;
        }
        if (wantValidate) {
            inputText = Deformat.CPForCNPJ(inputText);
            if (inputText.length()==15 && inputText.charAt(0)=='0') {
                inputText = inputText.substring(1);
            }
            isValid = Parse.CPForCNPJ(inputText);
        }
        if (!isValid) {
            field.selectAll();
        } else if (wantFormat) {
            field.setText(Format.CPForCNPJ(inputText));
        }
        return isValid;
    } 
    
    @Override
    public void keyTyped(KeyEvent e) {
        if (Character.isDigit(e.getKeyChar())) {
            if (wantFormat) {
                if (cursorPosition > 17) {
                    e.consume();
                }
            } else if (cursorPosition > 13) {
                e.consume();
            }
        } else if (!Verifier.isFunctionKey(e)) {
            e.consume();
        }
    }
}
