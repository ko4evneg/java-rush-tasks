package com.javarush.task.task06.task0619;

/* 
Три статические переменные name
*/

public class Solution {
    public static String name = "0";
    public static class Cat {
        public static String name = "1";

    }

    public static class Dog {
        public static String name = "2";
    }

    public static void main(String[] args) {
        System.out.println(Cat.name + name + Dog.name);
    }
}
