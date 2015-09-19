package br.com.antoniosergius.lib.obj;

import java.io.File;
import java.io.Serializable;

public class Preferences implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private boolean showSplashScreen;
    private File backupPath;
    
    public Preferences() {
    }

    public boolean isShowSplashScreen() {
        return showSplashScreen;
    }

    public void setShowSplashScreen(boolean showSplashScreen) {
        this.showSplashScreen = showSplashScreen;
    }

    public File getBackupPath() {
        return backupPath;
    }

    public void setBackupPath(File backupPath) {
        this.backupPath = backupPath;
    }

}
