package com.javarush.task.task10.task1007;

/* 
Задача №7 на преобразование целых типов
*/

public class Solution {
    public static void main(String[] args) {
        //ответ: 1234567
        long l = (int) 1234_564_890L;
        int x = (int) 0b1000_1100_1010;
        double m = (byte) 110_987_654_6299.123_34;
        float f = (int) l++ + 10 + ++x - (int) m;
        l = (long) f / 1000;
        System.out.println(l);
    }
}