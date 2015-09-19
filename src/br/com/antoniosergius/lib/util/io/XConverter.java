package br.com.antoniosergius.lib.util.io;

import com.thoughtworks.xstream.converters.SingleValueConverter;

public class XConverter<I extends Integer> implements SingleValueConverter{

    @Override
    public String toString(Object o) {
        return String.valueOf((Integer)o);
    }

    @Override
    public Integer fromString(String string) {
        return Integer.parseInt(string);
    }

    @Override
    public boolean canConvert(Class type) {
        return type.equals(Integer.class);
    }
    
}
