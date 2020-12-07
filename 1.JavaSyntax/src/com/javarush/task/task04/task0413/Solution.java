package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(bR.readLine());
        String[] days = {"понедельник", "вторник", "среда", "четверг", "пятница", "суббота", "воскресенье"};

        if (s < 1 || s > 7)
            System.out.println("такого дня недели не существует");
        else {
            s--;
            System.out.println(days[s]);
        }
    }
}