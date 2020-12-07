package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
        int[] num = new int[3];

        for (int i = 0; i < 3; i++)
            num[i] = Integer.parseInt(bR.readLine());

        if (num[0] == num [1])
            System.out.println(3);
        else if (num[0] == num [2])
            System.out.println(2);
        else if  (num[1] == num [2])
            System.out.println(1);
    }
}
