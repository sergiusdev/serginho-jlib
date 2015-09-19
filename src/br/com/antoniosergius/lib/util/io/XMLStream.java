package br.com.antoniosergius.lib.util.io;

import br.com.antoniosergius.lib.gui.utils.LookAndFeel;
import br.com.antoniosergius.lib.util.MySQLParameters;
import com.thoughtworks.xstream.XStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class XMLStream {
    private XStream xstream;
    private Configuration configuration;

    public XMLStream() {
        xstream = new XStream();
        xstream.registerConverter(new XConverter<>());
        xstream.alias("system", Configuration.class);
        xstream.alias("mysql", MySQLParameters.class);
        xstream.useAttributeFor(MySQLParameters.class, "server");
        xstream.useAttributeFor(MySQLParameters.class, "port");
        xstream.useAttributeFor(MySQLParameters.class, "database");
        xstream.useAttributeFor(MySQLParameters.class, "user");
        xstream.useAttributeFor(MySQLParameters.class, "encryptedPassword");
        xstream.alias("lookAndFeel", LookAndFeel.class);
        xstream.useAttributeFor(LookAndFeel.class, "className");
    }

    public XStream getXStream() {
        return xstream;
    }

    public void setXStream(XStream xstream) {
        this.xstream = xstream;
    }
    
    public Configuration read() throws IOException {
        File file = new File(Path.APP+"config.xml");
        if (file.exists() && file.length()>0L) {
            configuration = (Configuration) xstream.fromXML(file);
        } else {
            file.createNewFile();
            configuration = new Configuration(new MySQLParameters("localhost", 3306, 
                    "chequemate", "user", "*****"),new LookAndFeel("org.pushingpixels.substance.api.skin.MarinerSkin"));
            write(configuration);
        }
        return configuration;
    }
    
    public void write(Configuration configuration) throws IOException {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(
                Path.APP+"config.xml"))) {
            buffer.write( xstream.toXML(configuration) );
            buffer.flush();
        }
    }
    
    
}
