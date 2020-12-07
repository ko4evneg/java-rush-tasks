package com.javarush.task.task19.task1907;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String s = "";
        Pattern pattern = Pattern.compile("\\bworld\\b");
        Matcher matcher;
        int count = 0;
        while (fileReader.ready()) {
            s = fileReader.readLine();
            matcher = pattern.matcher(s);
            while (matcher.find())
                count++;
        }
        fileReader.close();
        System.out.println(count);
    }
}
