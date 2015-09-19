package br.com.antoniosergius.lib.gui.utils;

import br.com.antoniosergius.lib.obj.Message;
import javax.swing.JOptionPane;

public class ShowMessage implements Runnable{
    
    private Message message;

    public ShowMessage() {
    }

    public ShowMessage(Message message) {
        this.message = message;
    }
    
    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
    
    @Override
    public void run() {
        JOptionPane.showMessageDialog(message.getParent(), 
                    message.getMessage(), message.getTitle(), message.getType());
    }
    
}
