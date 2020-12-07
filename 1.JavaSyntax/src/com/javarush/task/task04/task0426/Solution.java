package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bR.readLine());
        String output = "";
//        boolean isEven, isPos, isZero;

        if (num == 0) {
            output = "ноль";
        } else if (num > 0) {
            output = "положительное";
        } else {
            output = "отрицательное";
        }

        if (num % 2 == 0 && num != 0) {
            output += " четное число";
        } else if (num % 2 != 0 && num != 0) {
            output += " нечетное число";
        }
        System.out.println(output);
    }
}
