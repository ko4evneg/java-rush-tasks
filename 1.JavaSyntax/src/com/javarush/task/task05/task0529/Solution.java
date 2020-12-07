package com.javarush.task.task05.task0529;

/* 
Консоль-копилка
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.DoubleToIntFunction;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int sum = 0 ;

        while (true) {
            input = br.readLine();
            if (input.equals("сумма"))
                break;
            else
                sum += Integer.parseInt(input);
        }
        System.out.println(sum);
    }
}
