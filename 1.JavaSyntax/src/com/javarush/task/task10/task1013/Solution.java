package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private String name;
        private String surName;
        private boolean sex;
        private int age;
        private int height;
        private int weight;

        public Human(String surName, boolean sex, int age, int height, int weight, String hairColor, String eyesColor, int breastWide, int waistWide) {
            this.surName = surName;
            this.sex = sex;
            this.age = age;
            this.height = height;
            this.weight = weight;
        }

        public Human(String name, String surName, boolean sex, int age, int height, int weight, String hairColor, String eyesColor) {
            this.name = name;
            this.surName = surName;
            this.sex = sex;
            this.age = age;
            this.height = height;
            this.weight = weight;

        }
        public Human(String name, String surName) {
            this.name = name;
            this.surName = surName;
        }

        public Human(String surName) {
            this.surName = surName;
        }
        //3
        public Human(String name, String surName, boolean sex, int age, int height, int weight) {
            this.name = name;
            this.surName = surName;
            this.sex = sex;
            this.age = age;
            this.height = height;
            this.weight = weight;
        }
        public Human(String name, String surName, boolean sex, int age, int height) {
            this.name = name;
            this.surName = surName;
            this.sex = sex;
            this.age = age;
            this.height = height;
        }
        public Human(String name, String surName, boolean sex, int age) {
            this.name = name;
            this.surName = surName;
            this.sex = sex;
            this.age = age;
        }
        //6
        public Human(String name, String surName, boolean sex) {
            this.name = name;
            this.surName = surName;
            this.sex = sex;
        }

        public Human(String name, String surName, int age) {
            this.name = name;
            this.surName = surName;
            this.age = age;
        }
        public Human(String name, String surName, int age, int height) {
            this.name = name;
            this.surName = surName;
            this.age = age;
            this.height = height;
        }

    }
}
