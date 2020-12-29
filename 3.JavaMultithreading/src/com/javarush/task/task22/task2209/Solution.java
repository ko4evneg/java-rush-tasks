package com.javarush.task.task22.task2209;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Составить цепочку слов
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = "";
        try {
            // inputString = reader.readLine();
            reader.close();
        } catch (Exception ioException) {
            ioException.printStackTrace();
        }
        inputString = "heh huy loh ";
        inputString = inputString.replaceAll("\\s+", " ").strip();
        try {
            StringBuilder result = getLine(inputString.split(" "));
            System.out.println(result.toString());
        } catch (NullPointerException e) {
            System.out.println("Invalid input string!");
        }
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder result = null;
        ArrayList<String> listStrings = new ArrayList<>(Arrays.asList(words));
        if (listStrings.size() == 1)
            return new StringBuilder(words[0]);

        for (int i = 0; i < words.length && i + 1 != words.length; i++) {
            String lastChar = Character.toString(words[i].charAt(words[i].length() - 1)).toLowerCase();
            String s = words[i + 1];
            if (s.toLowerCase().startsWith(lastChar)) {
                listStrings.remove(s);
                listStrings.remove(words[i]);
                listStrings.add(0, s);
                result = getLine(listStrings.toArray(new String[]{}));
                if (result == null)
                    continue;
                return result.insert(0, words[i] + " ");
            }
        }
        return null;
    }
}
