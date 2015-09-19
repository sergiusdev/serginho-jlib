package br.com.antoniosergius.lib.gui.utils;

import java.awt.AWTKeyStroke;
import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class FocusPolicy extends FocusTraversalPolicy{

    public static final int FORWARD=-11;
    public static final int BACKWARD=-12;
    public static final int BOTH_DIRECTIONS=-13;
    
    ArrayList<Component> order;

    public FocusPolicy(ArrayList<Component> order) {
        this.order = order;
    }
    
    @Override
    public Component getComponentAfter(Container aContainer, Component aComponent) {
        int idx = (order.indexOf(aComponent) + 1) % order.size();
        return order.get(idx);
    }

    @Override
    public Component getComponentBefore(Container aContainer, Component aComponent) {
        int idx = order.indexOf(aComponent) - 1;
        if (idx < 0) {
            idx = order.size() - 1;
        }
        return order.get(idx);
    }

    @Override
    public Component getFirstComponent(Container aContainer) {
        return order.get(0);
    }

    @Override
    public Component getLastComponent(Container aContainer) {
        return order.get(order.size()-1);
    }

    @Override
    public Component getDefaultComponent(Container aContainer) {
        return order.get(0);
    }
    
    public static void setDefaultTrasversalKeys(JComponent component, int direction) {
        switch (direction) {
            case BOTH_DIRECTIONS:
                FocusPolicy.setBackwardTransversalKeys(component);
                FocusPolicy.setForwardTransversalKeys(component);
                break;
            case FORWARD:
                FocusPolicy.setForwardTransversalKeys(component);
                break;
            case BACKWARD:
                FocusPolicy.setBackwardTransversalKeys(component);
                break;
            default:
                throw new IllegalArgumentException("Parametro inválido.");
        } 
    }
    
    private static void setBackwardTransversalKeys(JComponent component) {
        Set<AWTKeyStroke> setBack = new HashSet<>(component.getFocusTraversalKeys(
                KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS));
        setBack.add(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, KeyEvent.SHIFT_DOWN_MASK));
        component.setFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, setBack); 
    }
    
    private static void setForwardTransversalKeys(JComponent component) {
        Set<AWTKeyStroke> set = new HashSet<>(component.getFocusTraversalKeys(
               KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS));
        set.add(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0));
        component.setFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, set); 
    }
}
