package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] num = new int[4];
        int max = 0;
        BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            num[i] = Integer.parseInt(bR.readLine());
        }
        System.out.println(Math.max(Math.max(num[0],num[1]),Math.max(num[2],num[3])));
    }
}
