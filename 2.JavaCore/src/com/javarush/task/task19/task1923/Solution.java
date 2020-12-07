package com.javarush.task.task19.task1923;

import java.io.*;
import java.util.ArrayList;

/* 
Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со словами, разделенными пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d.
Закрыть потоки.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        FileWriter fileWriter = new FileWriter(args[1]);
        boolean isFirst = true;

        String s;
        while ((s = fileReader.readLine()) != null) {
            for (String str : s.split(" ")) {
                if (isFirst && str.matches(".*\\d+.*")) {
                    fileWriter.write(str);
                    isFirst = false;
                    continue;
                }
                if (str.matches(".*\\d+.*")) {
                    fileWriter.write(" " + str);
                }
            }
        }
        fileReader.close();
        fileWriter.close();
    }
}
