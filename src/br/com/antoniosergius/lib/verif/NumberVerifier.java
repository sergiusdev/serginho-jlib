package br.com.antoniosergius.lib.verif;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;

public abstract class NumberVerifier extends Verifier{

    public NumberVerifier() {
    }

    @Override
    public boolean shouldYieldFocus(JComponent component) {
        boolean inputOk = verify(component);
        formatValue(component);
        if (inputOk) {
            return true;
        } else {
            Toolkit.getDefaultToolkit().beep();
            return false;
        }
    }
    
    @Override
    public abstract void keyTyped(KeyEvent e);
    
    
    protected abstract void formatValue(JComponent input);
    
    @Override
    public abstract boolean verify(JComponent input);
}
