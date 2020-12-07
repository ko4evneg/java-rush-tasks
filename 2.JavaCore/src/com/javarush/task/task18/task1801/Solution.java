package com.javarush.task.task18.task1801;

/* 
Максимальный байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream fis = new FileInputStream(fileName);
        int max = fis.read();
        while (fis.available() > 0) {
            int curByte = fis.read();
            if (curByte > max)
                max = curByte;
        }
        System.out.println(max);
        fis.close();
    }
}
