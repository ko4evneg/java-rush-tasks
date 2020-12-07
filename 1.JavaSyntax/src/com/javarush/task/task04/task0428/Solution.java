package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
        int[] num = new int[3];
        int pos = 0;

        for (int i = 0; i < 3; i++) {
            num[i] = Integer.parseInt(bR.readLine());
            if (num[i] > 0)
                pos++;
        }
        if (pos > 0)
            System.out.println(pos);
        else
            System.out.println(0);
    }
}
