package com.javarush.task.task05.task0532;

/* 
Задача по алгоритмам Ӏ Java Syntax: 5 уровень, 12 лекция
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = Integer.parseInt(reader.readLine());

        if (maximum > 0) {
            //System.out.println(maximum);
            int[] nums = new int[maximum];
            int maxNum = nums[0] = Integer.parseInt(reader.readLine());

            for (int i = 1; i < maximum - 1; i++) {
                nums[i] = Integer.parseInt(reader.readLine());
                if (maxNum <= nums[i]) {
                    maxNum = nums[i];
                }
            }
            System.out.println(maxNum);
        }
    }
}
