package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/* 
Объединение файлов
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
Закрыть потоки.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        BufferedOutputStream destinationFileStream = new BufferedOutputStream(new FileOutputStream(file1));
        BufferedInputStream sourceFileStream = new BufferedInputStream(new FileInputStream(file2));
        ArrayList<Integer> bytes = new ArrayList<>();

        //read second file
        while (sourceFileStream.available() > 0) {
            bytes.add(Integer.valueOf(sourceFileStream.read()));
        }
        sourceFileStream.close();

        //read first file
        sourceFileStream = new BufferedInputStream(new FileInputStream(file1));
        while (sourceFileStream.available() > 0) {
            bytes.add(Integer.valueOf(sourceFileStream.read()));
        }
        sourceFileStream.close();

        //write file
        for (int i = 0; i < bytes.size(); i++) {
            destinationFileStream.write(bytes.get(i));
        }
        destinationFileStream.close();
    }
}
