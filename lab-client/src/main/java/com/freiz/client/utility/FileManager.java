package com.freiz.client.utility;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;

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

    public void save(String data) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(filename);
        byte[] strToBytes = data.getBytes();
        outputStream.write(strToBytes);
        outputStream.close();
    }
}
