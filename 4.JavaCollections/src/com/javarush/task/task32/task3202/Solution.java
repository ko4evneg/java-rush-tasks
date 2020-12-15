package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("D:\\temp_java\\a.txt"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringBuilder result = new StringBuilder();
        StringWriter sw = new StringWriter();
        if (is == null)
            return sw;
        byte[] buf = new byte[48];
        int length = 0;
        while ((length = is.read(buf)) > 0) {
            result.append(new String(buf), 0, length);
        }
        if (result.length() == 0)
            sw.write(" ");
        else
            sw.write(result.toString());
        return sw;
    }
}
