package br.com.antoniosergius.lib.obj;

import java.awt.Component;
import java.util.Objects;

public class Message {
    private Component parent;
    private String title;
    private String message;
    private int type;

    public Message(Component parent, String title, String message, int type) {
        this.parent = parent;
        this.title = title;
        this.message = message;
        this.type = type;
    }

    public Message(String title, String message, int type, int option) {
        parent = null;
        this.title = title;
        this.message = message;
        this.type = type;
    }

    public Message(String title, String message, int type) {
        this.parent = null;
        this.title = title;
        this.message = message;
        this.type = type;
    }

    public Component getParent() {
        return parent;
    }

    public void setParent(Component parent) {
        this.parent = parent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.parent);
        hash = 71 * hash + Objects.hashCode(this.title);
        hash = 71 * hash + Objects.hashCode(this.message);
        hash = 71 * hash + this.type;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Message other = (Message) obj;
        if (!Objects.equals(this.parent, other.parent)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Message{");
        str.append("parent=");
        str.append(parent);
        str.append(", title=");
        str.append(title);
        str.append(", message=");
        str.append(message);
        str.append(", type=");
        str.append(type);
        str.append('}');
        return str.toString();
    }
    
    
}
