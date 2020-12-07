package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(bR.readLine());

        if (year % 4 != 0)
            System.out.println("количество дней в году: 365");
        else if (year % 100 != 0)
            System.out.println("количество дней в году: 366");
        else if (year % 400 == 0)
            System.out.println("количество дней в году: 366");
        else
            System.out.println("количество дней в году: 365");

//Так, годы 1700, 1800 и 1900 не являются високосными, так как они кратны 100 и не кратны 400.
//Годы 1600 и 2000 - високосные, так как они кратны 100 и кратны 400.
//Годы 2100, 2200 и 2300 - не високосные.



    }
}