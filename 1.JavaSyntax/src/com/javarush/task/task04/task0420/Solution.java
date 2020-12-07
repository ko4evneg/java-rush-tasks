package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
        int[] num = new int[3];
        int temp;

        for (int i = 0; i < 3; i++)
            num[i] = Integer.parseInt(bR.readLine());

        for (int i = 0; i < num.length - 1; i++) {
            for (int j = 0; j < num.length - 1 - i; j++) {
                if (num[j] <= num[j + 1]) {
                    temp = num[j + 1];
                    num[j + 1] = num[j];
                    num[j] = temp;
                }
            }
        }
        System.out.println(num[0] + " " + num[1] + " " + num[2]);
    }
}
