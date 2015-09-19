package br.com.antoniosergius.lib.gui.utils;

import br.com.antoniosergius.lib.obj.Message;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ShowSuccesMessage extends ShowMessage{
    private String iconResource;

    public ShowSuccesMessage(String iconResource, Message message) {
        super(message);
        this.iconResource = iconResource;
    }

    public String getIconResource() {
        return iconResource;
    }

    public void setIconResource(String iconResource) {
        this.iconResource = iconResource;
    }

    @Override
    public void run() {
        Message message = super.getMessage();
        JOptionPane.showMessageDialog(message.getParent(), 
                    message.getMessage(), message.getTitle(), message.getType(),
                    new ImageIcon(getClass().getResource(iconResource)));
        
    }
    
    
}
