package br.com.antoniosergius.lib.gui.utils;

public abstract class TableItem<Type> {
    private int row;

    public TableItem(int row) {
        this.row = row;
    }

    public TableItem() {
    }
    
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }
    
    public abstract Type toObject();
    
    public abstract void set(Type object);
}
