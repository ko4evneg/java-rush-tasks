package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.*;

/* 
Ищем нужные строки
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words.
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String s;
        ArrayList<String> fileLines = new ArrayList<>();
        while ((s = fileReader.readLine()) != null) {
            fileLines.add(s);
        }
        fileReader.close();

        for (String string : fileLines) {
            List<String> words = Arrays.asList(string.split(" "));
            int wordsCount = 0;
            for (String s1 : words) {
                wordsCount += Collections.frequency(Solution.words, s1);
            }
            if (wordsCount == 2)
                System.out.println(string);
        }

    }

}
