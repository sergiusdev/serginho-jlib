package br.com.antoniosergius.lib.util.io;

import br.com.antoniosergius.lib.tools.Format;
import br.com.antoniosergius.lib.util.MySQLParameters;
import java.io.File;
import java.io.IOException;
import java.util.GregorianCalendar;

public class BackupService {
    private MySQLParameters mySqlParameters;
    private GregorianCalendar dateTime;
    private char[] password;
    private File file;

    public BackupService(char[] password) {
        this.password = password;
    }

    public BackupService(MySQLParameters mySqlParameters, char[] password, File file) {
        this.mySqlParameters = mySqlParameters;
        this.password = password;
        this.file = file;
    }

    public BackupService(MySQLParameters mySqlParameters, char[] password) {
        this.mySqlParameters = mySqlParameters;
        this.password = password;
    }
    
    public MySQLParameters getMySqlParameters() {
        return mySqlParameters;
    }

    public void setMySqlParameters(MySQLParameters mySqlParameters) {
        this.mySqlParameters = mySqlParameters;
    }

    public GregorianCalendar getDateTime() {
        return dateTime;
    }

    public void setDateTime(GregorianCalendar dateTime) {
        this.dateTime = dateTime;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
    
    public char[] getPassword() {
        return password;
    }
    
    public boolean commitBackup() throws IOException, InterruptedException{
        String [] commandList = new String[]{
            "mysqldump",
            "--user="+mySqlParameters.getUser(),
            "--password="+String.valueOf(password),
            "--host="+mySqlParameters.getServer(),
            "--port="+mySqlParameters.getPort(),
            "--lock-all-tables", 
            mySqlParameters.getDatabase(), 
            "--result-file="+file.getPath()};
        Process runtimeProcess = Runtime.getRuntime().exec(commandList);
        int processComplete = runtimeProcess.waitFor();
        return processComplete == 0;
    }
    
    public String createFileName() {
        StringBuilder tmp = new StringBuilder();
        tmp.append("Backup-");
        tmp.append(Format.date("yyyyMMddHHmm", dateTime));
        tmp.append(".sql");
        return tmp.toString();
    }

    public boolean commitRestore() throws IOException, InterruptedException{
        String [] commandList = new String[]{
            "mysql",
            "-u", mySqlParameters.getUser(),
            "-p"+String.valueOf(password),
            "-h", mySqlParameters.getServer(),
            "-P", String.valueOf(mySqlParameters.getPort()),
            "-D", mySqlParameters.getDatabase(), 
            "-e",
            "\"source "+file.getPath()+"\""};
        Process runtimeProcess = Runtime.getRuntime().exec(commandList);
        int processComplete = runtimeProcess.waitFor();
        return processComplete == 0;
    }
    
    
}
