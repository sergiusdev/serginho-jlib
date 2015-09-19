package br.com.antoniosergius.lib.verif;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public abstract class Verifier extends InputVerifier implements ActionListener, CaretListener, KeyListener {

    protected int cursorPosition;
    private JLabel errorLabel;

    public Verifier() {
    }

    public Verifier(JLabel errorLabel) {
        this.errorLabel = errorLabel;
    }
    
    public JLabel getErrorLabel() {
        return errorLabel;
    }

    public void setErrorLabel(JLabel errorLabel) {
        this.errorLabel = errorLabel;
    }
    
    protected abstract boolean validate(JComponent input);
    
    @Override
    public boolean verify(JComponent input) {
        return validate(input);
    }
    
    @Override
    public void caretUpdate(CaretEvent e) {
        cursorPosition = e.getDot();
    }
    
    @Override
    public boolean shouldYieldFocus(JComponent component) {
        boolean inputOk = verify(component);
        if (inputOk) {
            return true;
        } else {
            Toolkit.getDefaultToolkit().beep();
            return false;
        }
    }
     
    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField source = (JTextField)e.getSource();
        if (!shouldYieldFocus(source)) {
            source.selectAll();
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
    
    public static void set(JTextField field, Verifier verif) {
        field.setInputVerifier(verif);
        field.addActionListener(verif);
        field.addKeyListener(verif);
        field.addCaretListener(verif);
    }
    
    public static boolean isFunctionKey(KeyEvent e) {
        return  e.getKeyCode() == KeyEvent.VK_BACK_SPACE ||
                e.getKeyCode() == KeyEvent.VK_LEFT ||
                e.getKeyCode() == KeyEvent.VK_RIGHT ||
                e.getKeyCode() == KeyEvent.VK_TAB ||
                e.getKeyCode() == KeyEvent.VK_ENTER;
    }
}
