package br.com.antoniosergius.lib.verif;

import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class StateVerifier extends Verifier{

    @Override
    protected boolean validate(JComponent input) {
        JTextField field = (JTextField)input;
        String inputText = field.getText();
        if (inputText.isEmpty()) {
            return true;
        }
        return inputText.matches("[A-Za-z][A-Za-z]") && inputText.length()==2;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (cursorPosition > 1) {
            e.consume();
        } else if (!Character.isLetter(e.getKeyChar()) && !Verifier.isFunctionKey(e)) {
            e.consume();
        } else {
            e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
        }  
    }
    
}
