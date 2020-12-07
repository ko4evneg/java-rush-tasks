package com.javarush.task.task14.task1404;
import java.io.*;
import java.util.*;
/* 
Коты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader brd = new BufferedReader(new InputStreamReader(System.in));
        List<String> names = new ArrayList<String>();
        while (true) {
            String input = brd.readLine();
            if (input.equals("") || input == null) 
                break;
            names.add(input);
        }
        
        for (String s : names){
            Cat cat = CatFactory.getCatByKey(s);
            System.out.println(cat.toString());
        }
        
        //cat.toString();
        
        brd.close();
    }

    static class CatFactory {
        static Cat getCatByKey(String key) {
            Cat cat = null;
            if ("vaska".equals(key)) {
                cat = new MaleCat("Василий");
            } else if ("murka".equals(key)) {
                cat = new FemaleCat("Мурочка");
            } else if ("kiska".equals(key)) {
                cat = new FemaleCat("Кисюлька");
            } else {
                cat = new Cat(key);
            }
            return cat;
        }
    }

    static class Cat {
        private String name;

        protected Cat(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public String toString() {
            return "Я уличный кот " + getName();
        }
    }

    static class MaleCat extends Cat {
        MaleCat(String name) {
            super(name);
        }

        public String toString() {
            return "Я - солидный кошак по имени " + getName();
        }
    }

    static class FemaleCat extends Cat {
        FemaleCat(String name) {
            super(name);
        }

        public String toString() {
            return "Я - милая кошечка по имени " + getName();
        }
    }
}
