package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Округление чисел
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415.
Округлить числа до целых и записать через пробел во второй файл.
Закрыть потоки.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        BufferedInputStream fileIn = new BufferedInputStream(new FileInputStream(file1));
        BufferedOutputStream fileOut = new BufferedOutputStream(new FileOutputStream(file2));

        String content = "";
        while (fileIn.available() > 0) {
            content += (char) fileIn.read();
        }
        fileIn.close();
        List<String> numbers = Arrays.asList(content.split(" "));

        String outString = "";
        for (String s : numbers) {
            int i = (int) Math.round(Double.parseDouble(s));
            outString += Integer.toString(i) + " ";
        }
        fileOut.write(outString.trim().getBytes());
        fileOut.close();
    }
}

