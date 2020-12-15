package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        long position = Integer.parseInt(args[1]);
        String text = args[2];

        String result = "";
        RandomAccessFile file = new RandomAccessFile(fileName, "rw");
        byte[] b = new byte[(int) (text.length())];
        file.seek(position);
        file.read(b, 0, text.length());
        String textFile = new String(b);
        result = text.equals(textFile) ? "true" : "false";
        file.seek(file.length());
        file.write(result.getBytes());
        file.close();
    }
}
