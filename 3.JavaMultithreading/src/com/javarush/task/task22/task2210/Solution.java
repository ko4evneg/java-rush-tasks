package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {
        String s1 = "la .stro .ka";
        String s2 = " .";
        System.out.println(Arrays.toString(getTokens(s1, s2)));
    }

    public static String[] getTokens(String query, String delimiter) {
        ArrayList<String> str = new ArrayList<>();
        StringTokenizer result = new StringTokenizer(query, delimiter);
        while (result.hasMoreTokens()) {
            str.add(result.nextToken());
        }
        return str.toArray(new String[]{});
    }
}
