package com.javarush.task.task05.task0528;

/* 
Вывести на экран сегодняшнюю дату
*/

import java.time.LocalDate;

public class Solution {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println(date.getDayOfMonth() + " " + date.getMonthValue() + " " + date.getYear());
    }
}
