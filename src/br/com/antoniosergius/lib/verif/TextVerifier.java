package br.com.antoniosergius.lib.verif;

import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class TextVerifier extends Verifier{

    private int size;
    
    public TextVerifier() {
        size = 75;
    }

    public TextVerifier(int size) {
        this.size = size;
    }
    
    @Override
    protected boolean validate(JComponent input) {
        JTextField field = (JTextField)input;
        String inputText = field.getText();
        boolean isValid = inputText.length()<=size;
        if (isValid) {
            field.selectAll();
        }
        return isValid;
    } 
    
    @Override
    public void keyTyped(KeyEvent e) {
        if (cursorPosition > size) {
            e.consume();
        } else if (!Character.isLetterOrDigit(e.getKeyChar()) &&
            !Character.isSpaceChar(e.getKeyChar()) &&
            !Verifier.isFunctionKey(e) &&
            e.getKeyChar() != '(' &&   
            e.getKeyChar() != ')' &&   
            e.getKeyChar() != '.' && 
            e.getKeyChar() != '/' && 
            e.getKeyChar() != '&' &&    
            e.getKeyChar() != '%') {

            e.consume();
        } else {
            e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
        }    
    }
    
}
