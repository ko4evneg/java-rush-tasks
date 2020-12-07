package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bR.readLine());
        String output = "";

        if (num % 2 == 0) {
            output += "четное ";
        } else if (num % 2 != 0) {
            output += "нечетное ";
        }

        if (num < 10) {
            output += "однозначное число";
        } else if (num < 100) {
            output += "двузначное число";
        } else {
            output += "трехзначное число";
        }

        if (!(num < 1 || num > 999))
            System.out.println(output);

    }
}
