package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strs = new ArrayList<String>();
        int shortestIndex = 0;
        int longestIndex = 0;

        for (int i = 0; i < 10; i++) {
            strs.add(br.readLine());
        }

        for (int i = 1; i < 10; i++) {
            if (strs.get(shortestIndex).length() > strs.get(i).length()) {
                shortestIndex = i;
            } else if (strs.get(longestIndex).length() < strs.get(i).length()) {
                longestIndex = i;
            }
        }

        if (shortestIndex < longestIndex) {
            System.out.println(strs.get(shortestIndex));
            } else {
            System.out.println(strs.get(longestIndex));
            }
        }
    }

