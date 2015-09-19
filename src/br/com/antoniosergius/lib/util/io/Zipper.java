package br.com.antoniosergius.lib.util.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zipper {
    private static int BUFF_SIZE = 4096;
    
    public static void doCompact(String inputName, String outputName) throws IOException{
        byte[] data = new byte[BUFF_SIZE];
        
        try (FileInputStream fis = null;
             FileOutputStream fos = new FileOutputStream(new File(outputName));
             ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(fos))) {
            
            File inputFile = new File(inputName);
            if (inputFile.isDirectory()) {
                for(File objFile : inputFile.listFiles()) {
                    Zipper.setEntryAndZip(data, objFile, fis, out);
                }
            } else {
                Zipper.setEntryAndZip(data, inputFile, fis, out);
            }
        }
    }
    
    private static void setEntryAndZip(byte[] data, File inputFile, FileInputStream fis, 
            ZipOutputStream zout) throws FileNotFoundException, IOException {
        fis = new FileInputStream(inputFile);
        try (BufferedInputStream bufferedInput = new BufferedInputStream(fis, BUFF_SIZE)) {
            ZipEntry zipEntry = new ZipEntry(inputFile.getName());
            zout.putNextEntry(zipEntry);
            int cont;
            while ((cont = bufferedInput.read(data, 0, BUFF_SIZE)) != -1) {
                zout.write(data, 0, cont);
            }
        }
    }
    
    /*public static void main(String args[]) {
        try {
            Zipper.doCompact("build.xml", "teste.zip");
        } catch (IIOException ex) {
            Logger.getLogger(Zipper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Zipper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Zipper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
}


/*
 * fis = new FileInputStream(inputFile);
                try (BufferedInputStream bufferedInput = new BufferedInputStream(fis, BUFF_SIZE)) {
                    ZipEntry zipEntry = new ZipEntry(inputFile.getName());
                    out.putNextEntry(zipEntry);
                    int cont;
                    while ((cont = bufferedInput.read(data, 0, BUFF_SIZE)) != -1) {
                        out.write(data, 0, cont);
                    }
                }
 */