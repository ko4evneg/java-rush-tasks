package com.javarush.task.task19.task1925;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6.
В конце файла2 запятой не должно быть.
Закрыть потоки.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) return;
        BufferedReader fileIn = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileOut = new BufferedWriter(new FileWriter(args[1]));
        String str;
        StringBuilder result = new StringBuilder();
        while ((str = fileIn.readLine()) != null) {
            String[] bufferWord = str.split(" ");
            for (String s : bufferWord) {
                if (s.length() > 6) result.append(s).append(",");
            }
        }
        result.deleteCharAt(result.length() - 1);
        fileOut.write(result.toString());
        fileIn.close();
        fileOut.close();
    }
}
