package br.com.antoniosergius.lib.report;

import net.sf.jasperreports.engine.JRDataSource;

public class DataSourceFactory {
    private static JRDataSource data;

    public static void setData(JRDataSource data) {
        DataSourceFactory.data = data;
    }
     
    public static JRDataSource createDatasource() {
        return data;
    }
}