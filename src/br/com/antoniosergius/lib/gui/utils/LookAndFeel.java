package br.com.antoniosergius.lib.gui.utils;

import java.util.Objects;

public class LookAndFeel {
    private String className;

    public LookAndFeel(String className) {
        this.className = className;
    }

    public LookAndFeel() {
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "LookAndFeel{" + "className=" + className + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.className);
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
        final LookAndFeel other = (LookAndFeel) obj;
        if (!Objects.equals(this.className, other.className)) {
            return false;
        }
        return true;
    }
    
    
    
}
