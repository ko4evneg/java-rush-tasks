package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
        int[] num = new int[3];
        int pos = 0;
        int neg = 0;

        for (int i = 0; i < 3; i++) {
            num[i] = Integer.parseInt(bR.readLine());
            if (num[i] > 0)
                pos++;
            else if (num[i] < 0)
                ++neg;
        }
        if (neg > 0)
            System.out.println("количество отрицательных чисел: " + neg);
        else
            System.out.println("количество отрицательных чисел: 0");
        if (pos > 0)
            System.out.println("количество положительных чисел: " + pos);
        else
            System.out.println("количество положительных чисел: 0");
    }
}
