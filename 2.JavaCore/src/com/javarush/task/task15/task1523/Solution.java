package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {
    int a;
    double b;
    private Solution(int a){}
    Solution(double b){}
    protected Solution(int a, double b){}
    public Solution(double b, int a){}

    public static void main(String[] args) {

    }
}

