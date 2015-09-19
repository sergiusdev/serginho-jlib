package br.com.antoniosergius.lib.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.binary.Base64;


public class PasswordService {
    private static final Logger LOG = Logger.getLogger(PasswordService.class.getName());
    public static final String CHARSET = "UTF-16";
    public static final String ALGORITHM = "SHA-1";
    
    
    public static String encrypt(String str) {
        MessageDigest msgDigest;
        String hashValue = null;
        try {
            msgDigest = MessageDigest.getInstance(PasswordService.ALGORITHM);
            msgDigest.update(str.getBytes(PasswordService.CHARSET));
            
            byte rawByte[] = msgDigest.digest();
            hashValue = new String(Base64.encodeBase64(rawByte));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            LOG.log(Level.WARNING, e.getMessage(), e);
        }
        return hashValue;
    }
}
