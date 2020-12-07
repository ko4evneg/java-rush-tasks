package com.javarush.task.task07.task0702;

/* 
Массив из строчек в обратном порядке
*/

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = new String[10];

        for (int i = 0; i < 8; i++) {
            nums[i] = br.readLine();
        }
        nums[8] = "a";
        nums[9] = "b";
        //for (int i = 0; i < 10; i++) {
       //     System.out.println(nums[i]);
        //}

        for (int i = 9; i > -1; i--) {
            System.out.println(nums[i]);
        }
    }
}