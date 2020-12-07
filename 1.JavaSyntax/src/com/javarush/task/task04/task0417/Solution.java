package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Solution {
    public static void main(String[] args) throws Exception {
//        Ввести с клавиатуры три целых числа
        InputStream in = System.in;
        InputStreamReader iR = new InputStreamReader(in);
        BufferedReader bR = new BufferedReader(iR);
        int[] num = new int[3];

        for (int i = 0; i < 3; i++) {
            num[i] = Integer.parseInt(bR.readLine());
        }

//        Определить, имеется ли среди них хотя бы одна пара равных между собой чисел.
        if (num[0] == num[1] && num[1] == num[2])
            System.out.println(num[1] + " " + num[1] + " " + num[1]);

        else if (num[0] == num[1] || num[0] == num[2])
            System.out.println(num[0] + " " + num[0]);

        else if (num[1] == num[2])
            System.out.println(num[1] + " " + num[1]);
//                Если такая пара существует, вывести на экран числа через пробел.
//                Если все три числа равны между собой, то вывести все три.
    }
}