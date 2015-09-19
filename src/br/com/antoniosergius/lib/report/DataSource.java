package br.com.antoniosergius.lib.report;

import java.util.ArrayList;
import java.util.Iterator;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public abstract class DataSource<Type> implements JRDataSource{
    
    private Type current;
    private Iterator<Type> iterator;

    public DataSource(ArrayList<Type> list) {
        iterator = list.iterator();
    }
    
    @Override
    public boolean next() throws JRException {
        boolean hasNext = iterator.hasNext();
        if (hasNext) {
            current = iterator.next();
        }
        return hasNext;
    }

    @Override
    public abstract Object getFieldValue(JRField jrf) throws JRException;

    public Type getCurrent() {
        return current;
    }

    public void setCurrent(Type current) {
        this.current = current;
    }

    public Iterator<Type> getIterator() {
        return iterator;
    }

    public void setIterator(Iterator<Type> iterator) {
        this.iterator = iterator;
    }
    
}
