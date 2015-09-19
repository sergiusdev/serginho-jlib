package br.com.antoniosergius.lib.util.io;

import br.com.antoniosergius.lib.gui.utils.LookAndFeel;
import br.com.antoniosergius.lib.util.MySQLParameters;
import java.util.Objects;

public class Configuration {
    private MySQLParameters mysqlParameters;
    private LookAndFeel lookAndFeel;
    
    public Configuration(MySQLParameters mysqlParameters) {
        this.mysqlParameters = mysqlParameters;
    }

    public Configuration(MySQLParameters mysqlParameters, LookAndFeel lookAndFeel) {
        this.mysqlParameters = mysqlParameters;
        this.lookAndFeel = lookAndFeel;
    }

    public MySQLParameters getMysqlParameters() {
        return mysqlParameters;
    }

    public void setMysqlParameters(MySQLParameters mysqlParameters) {
        this.mysqlParameters = mysqlParameters;
    }

    public LookAndFeel getLookAndFeel() {
        return lookAndFeel;
    }

    public void setLookAndFeel(LookAndFeel lookAndFeel) {
        this.lookAndFeel = lookAndFeel;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Configuration{");
        str.append("mysqlParameters=");
        str.append(mysqlParameters);
        str.append(", lookAndFeel=");
        str.append(lookAndFeel);
        str.append('}');
        return str.toString();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.mysqlParameters);
        hash = 73 * hash + Objects.hashCode(this.lookAndFeel);
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
        final Configuration other = (Configuration) obj;
        if (!Objects.equals(this.mysqlParameters, other.mysqlParameters)) {
            return false;
        }
        if (!Objects.equals(this.lookAndFeel, other.lookAndFeel)) {
            return false;
        }
        return true;
    }
}
