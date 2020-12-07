package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самая длинная строка
*/

public class Solution {
    private static ArrayList<String> strings;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        strings = new ArrayList<String>();
        int shortestIndex = 0;
        ArrayList<Integer> shorts = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            strings.add(br.readLine());
        }
        for (int i = 1; i < 5; i++) {
            if (strings.get(shortestIndex).length() < strings.get(i).length()) {
                shortestIndex = i;
            }
        }
        for (int i = 0; i < 5; i++) {
            if (strings.get(shortestIndex).length() == strings.get(i).length()) {
                shorts.add(i);
            }
        }

        if (shorts.size() > 0) {
            for (int i = 0; i < shorts.size(); i++) {
                int j = shorts.get(i);
                System.out.println(strings.get(j));
            }
        } else {
            System.out.println(strings.get(shortestIndex));
        }
    }
}
