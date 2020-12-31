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
        ArrayList<String> listStrings = new ArrayList<>(Arrays.asList(words));

        StringBuilder result = new StringBuilder("");
        //?        if (words.length > 0)

        for (int i = 0; i < words.length; i++) {
            String nextWord;
            String firstWord;
            if (i + 1 == words.length) {
                String tempWord = listStrings.get(i);
                listStrings.remove(tempWord);
                listStrings.add(0, tempWord);
                nextWord = listStrings.get(1);
            } else {
                nextWord = listStrings.get(i + 1);
            }
            firstWord = listStrings.get(0);
            char lastChar = Character.toLowerCase(firstWord.charAt(firstWord.length() - 1));
            char firstChar = Character.toLowerCase(nextWord.charAt(0));
            System.out.printf("Comparing %s:%c with %s:%c.\n", firstWord, lastChar, nextWord, firstChar);

            if (firstChar == lastChar) {
                if (i < listStrings.size() - 1) {
                    //  Iterating unless 1 word left OR no matching words left
                    listStrings.remove(firstWord);
                    listStrings.remove(nextWord);
                    listStrings.add(0, nextWord);
                    StringBuilder iterationResult = getLine(listStrings.toArray(new String[]{}));
                    listStrings.add(firstWord);
                    if (!iterationResult.toString().equals(""))
                        result.append(iterationResult + " " + nextWord);
                } else {    //(i == listStrings.size() - 1)
                    //  The deepest iteration only
                    return new StringBuilder(firstWord);
                }
            } else {    //(firstChar != lastChar)
                continue;
            }
        }
        //  All iterations, except the deepest
        return result;
    }
}
