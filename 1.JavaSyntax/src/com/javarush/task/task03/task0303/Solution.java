package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(convertEurToUsd(10, 1.12));
        System.out.println(convertEurToUsd(537, 1.17));

    }

    public static double convertEurToUsd(int eur, double exchangeRate) {
        double usd;
        usd = eur * exchangeRate;
        return usd;
    }
}
