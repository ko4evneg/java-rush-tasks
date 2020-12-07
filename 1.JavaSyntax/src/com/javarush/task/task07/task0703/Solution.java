package com.javarush.task.task07.task0703;

/* 
Общение одиноких массивов
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = new String[10];
        int[] nums = new int[10];

        for (int i = 0; i < str.length; i++) {
            str[i] = br.readLine();
            nums[i] = str[i].length();
            System.out.println(nums[i]);
        }

    }
}
