package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName2));
        boolean isFirstNum = true;

        while (fileReader.ready()) {
            String s = fileReader.readLine();
            String[] nums = s.split(" ");
            for (String str : nums) {
                if (str.matches("\\d+") && isFirstNum) {
                    fileWriter.write(str);
                    isFirstNum = false;
                } else if (str.matches("\\d+"))
                    fileWriter.write(" " + str);
            }
        }
        fileReader.close();
        fileWriter.close();
    }
}
