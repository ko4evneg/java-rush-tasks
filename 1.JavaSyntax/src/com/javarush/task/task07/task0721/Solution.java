package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Минимаксы в массивах
*/

public class Solution {
        static  int[] nums = new int[20];
    public static void main(String[] args) throws IOException {
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        nums = getInts();
        int maximum = nums[0];
        int minimum = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maximum)
                maximum = nums[i];
            else if (nums[i] < minimum)
                minimum = nums[i];
        }

        System.out.print(maximum + " " + minimum);
    }

    public static int[] getInts() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 20; i++) {
            nums[i] = (Integer.parseInt(reader.readLine()));
        }
        return nums;
    }
}
