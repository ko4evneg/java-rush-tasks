package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
        int[] num = new int[3];
        for (int i = 0; i < 3; i++)
            num[i] = Integer.parseInt(bR.readLine());
        if (num[0] + num[1] > num[2] && num[0] + num[2] > num[1] && num[1] + num[2] > num[0])
            System.out.println("Треугольник существует.");
        else
            System.out.println("Треугольник не существует.");

//        Определить возможность существования треугольника по сторонам.
//        Результат вывести на экран в следующем виде:
//        "Треугольник существует." - если треугольник с такими сторонами существует.
//        "Треугольник не существует." - если треугольник с такими сторонами не существует.
//
//        Подсказка:
//        Треугольник существует только тогда, когда сумма двух его сторон больше третьей.
//        Требуется сравнить каждую сторону с суммой двух других.
//        Если хотя бы в одном случае сторона окажется больше либо равна сумме двух других, то треугольника с такими сторонами не существует.
    }
}