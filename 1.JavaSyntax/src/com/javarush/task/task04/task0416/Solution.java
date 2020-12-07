package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
        double min = Double.parseDouble(bR.readLine());

        min -= (int)(min / 5) * 5;

        if (min < 3.0)
            System.out.println("зелёный");
        else if (min < 4.0)
            System.out.println("жёлтый");
        else
            System.out.println("красный");
//в начале каждого часа в течение трех минут горит зелёный сигнал,
//        затем в течение одной минуты - жёлтый,
//        а потом в течение одной минуты - красный,
//        затем опять зелёный горит три минуты и т. д.
//        Ввести с клавиатуры вещественное число t, означающее время в минутах, прошедшее с начала очередного часа.


    }
}