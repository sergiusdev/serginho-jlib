package br.com.antoniosergius.lib.util.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialize<Type extends Object> {
    private Type type;
    private String filePath;

    public Serialize() {
    }

    public Serialize(String filePath) {
        this.filePath = filePath;
    }
    
    public Serialize(Type type, String filePath) {
        this.type = type;
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
    
    public void write() throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
        StringBuilder path = new StringBuilder(filePath);
        try (FileOutputStream streamFile = new FileOutputStream(path.toString());
             ObjectOutputStream streamObject  = new ObjectOutputStream(streamFile)) {
             streamObject.writeObject(type);
        }
    }
    
    @SuppressWarnings("unchecked")
    public Type read() throws  ClassNotFoundException, FileNotFoundException, IOException{
        File file = new File(filePath);
        if (!file.exists()) {
            throw new IOException("Não foi possível localizar o arquivo.");
        }
        try (FileInputStream input = new FileInputStream(file);
            ObjectInputStream streamObject = new ObjectInputStream(input)) {
            type = (Type) streamObject.readObject();
        }
        return type;
    }
    
    public static void delete(String path) throws FileNotFoundException, IOException {
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        } else {
            throw new FileNotFoundException("Arquivo inexistente.");
        }
    }
    
    public static boolean hasFile(String path) {
        File file = new File(path);
        return file.exists();
    }
}
