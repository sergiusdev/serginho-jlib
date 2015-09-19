package br.com.antoniosergius.lib.util;

import java.util.Objects;

public class MySQLParameters {
    private String server;
    private int port;
    private String database;
    private String user;
    private String encryptedPassword;

    public MySQLParameters() {
    }

    public MySQLParameters(String server, int port, String database, String user, String encryptedPassword) {
        this.server = server;
        this.port = port;
        this.database = database;
        this.user = user;
        this.encryptedPassword = encryptedPassword;
    }
    
    public MySQLParameters(String server, int port, String database, String user) {
        this.server = server;
        this.port = port;
        this.database = database;
        this.user = user;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }
    
    public MySQLParameters copy() {
        return new MySQLParameters(server, port, database, user, encryptedPassword);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.server);
        hash = 83 * hash + this.port;
        hash = 83 * hash + Objects.hashCode(this.database);
        hash = 83 * hash + Objects.hashCode(this.user);
        hash = 83 * hash + Objects.hashCode(this.encryptedPassword);
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
        final MySQLParameters other = (MySQLParameters) obj;
        if (!Objects.equals(this.server, other.server)) {
            return false;
        }
        if (this.port != other.port) {
            return false;
        }
        if (!Objects.equals(this.database, other.database)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.encryptedPassword, other.encryptedPassword)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("MySQLParameters{");
        str.append("server=");
        str.append(server);
        str.append(", port=");
        str.append(port);
        str.append(", database=");
        str.append(database);
        str.append(", user=");
        str.append(user);
        str.append(", encryptedPassword=");
        str.append(String.valueOf(encryptedPassword));
        str.append('}');
        return str.toString();
    }

    
}
