package com.freiz.client.utility;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileManager {

    private final String filename;

    public FileManager(String filename) {
        this.filename = filename;
    }

    public String read() throws IOException {
        StringBuilder strData = new StringBuilder();
        int inChar;
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filename))) {
            inChar = bufferedInputStream.read();
            while (bufferedInputStream.available() > 0) {
                strData.append((char) inChar);
                inChar = bufferedInputStream.read();
            }
            strData.append((char) inChar);
        }
        return strData.toString();
    }
    

    public void save(String data) throws FileNotFoundException {
        byte[] strToBytes = data.getBytes();
        try (FileOutputStream outputStream = new FileOutputStream(filename)) {
            outputStream.write(strToBytes);
        } catch (IOException e) {
            //never throwns
            System.out.println(" ");
        }
    }
}
