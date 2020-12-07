package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileIn = new FileInputStream((new BufferedReader(new InputStreamReader(System.in))).readLine());
        List<Integer> nums = new ArrayList<Integer>();
        List<String> strs = new ArrayList<String>();

        int currentNum = 0;
        String allnums = "";

        while (fileIn.available() > 0) {
            char currentChar = (char) fileIn.read();
            allnums += Character.toString(currentChar);
        }

        strs = Arrays.asList(allnums.split(System.lineSeparator()));
        for (String s : strs) {
            nums.add(Integer.parseInt(s));
        }

        Collections.sort(nums);

        for (int i : nums) {
            if (i % 2 == 0)
                System.out.println(i);
        }


        fileIn.close();
    }
}
