package br.com.antoniosergius.lib.gui.utils;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public abstract class TableModel<Type extends Object, TypeItem extends TableItem<Type>> extends AbstractTableModel{

    private ArrayList<TypeItem> rows;

    public TableModel(ArrayList<TypeItem> rows) {
        this.rows = rows;
    }

    public TableModel() {
        rows = new ArrayList<>();
    }
    
    public void remove(int rowIndex) {
        rows.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
    
    public void clear() {
        rows.clear();
        fireTableDataChanged();
    }
    
    public boolean isEmpty() {
        return rows.isEmpty();
    }
    
    @Override
    public int getRowCount() {
        return rows.size();
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    public Type get(int rowIndex){
        return rows.get(rowIndex).toObject();
    }
    
    public abstract void add(Type type, int rowIndex);
    
    public void setValueAt(Type type, int rowIndex) {
        rows.get(rowIndex).set(type);
        int columns = getColumnCount();
        for (int i=0; i<columns; i++) {
            fireTableCellUpdated(rowIndex, i);
        }
    }
    
    public void addList(ArrayList<Type> list){
        int lastRow = getRowCount();
        for (Type type : list) {
            add(type, lastRow);
            lastRow++;
        }
    }

    public ArrayList<TypeItem> getRows() {
        return rows;
    }

    public void setRows(ArrayList<TypeItem> rows) {
        this.rows = rows;
    }
    
}
