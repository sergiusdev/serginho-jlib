package br.com.antoniosergius.lib.verif;

import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EmailVerifier extends Verifier{

    public EmailVerifier() {
    }

    public EmailVerifier(JLabel errorLabel) {
        super(errorLabel);
    }

    @Override
    protected boolean validate(JComponent input) {
        JTextField field = (JTextField)input;
        String inputText = field.getText().trim();
        if (inputText.isEmpty()) {
            return true;
        }
        return !inputText.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (cursorPosition==0 && Character.isDigit(e.getKeyChar())) {
            e.consume();
            return;
        } 
        if (!Character.isLetterOrDigit(e.getKeyChar()) &&
            !Verifier.isFunctionKey(e) &&
            e.getKeyChar() != '@' && 
            e.getKeyChar() != '-' &&  
            e.getKeyChar() != '_' && 
            e.getKeyChar() != '.') {
            
            e.consume();
        }    
    }
}
