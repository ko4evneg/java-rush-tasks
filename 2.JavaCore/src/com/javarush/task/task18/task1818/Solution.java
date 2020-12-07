package com.javarush.task.task18.task1818;

import java.io.*;
import java.nio.Buffer;

/* 
Два в одном
Считать с консоли 3 имени файла.
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
Закрыть потоки.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        reader.close();

        FileInputStream sourceFileStream = new FileInputStream(file2);
        FileOutputStream destinationFileStream = new FileOutputStream(file1);
        int i;

        while ((i = sourceFileStream.read()) != -1) {
            destinationFileStream.write(i);
        }
        destinationFileStream.close();
        sourceFileStream.close();

        sourceFileStream = new FileInputStream(file3);
        destinationFileStream = new FileOutputStream(file1,true);
        while ((i = sourceFileStream.read()) != -1) {
            destinationFileStream.write(i);
        }

        destinationFileStream.close();
        sourceFileStream.close();
    }
}
