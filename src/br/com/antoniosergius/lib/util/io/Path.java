package br.com.antoniosergius.lib.util.io;

import java.io.File;
import java.io.FilenameFilter;

public class Path {
    public static final String APP = System.getProperty("user.dir") + File.separator;
    public static final String DATA = Path.APP + "data" + File.separator;
    
    public static class FilterFile implements FilenameFilter {
        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(".as");
        }
    }
}
