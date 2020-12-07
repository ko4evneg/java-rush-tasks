package com.javarush.task.task10.task1011;

/* 
Большая зарплата
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";
        ArrayList<Character> str = new ArrayList<Character>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            str.add(c);
        }
        for (int i = 0; i < 40; i++) {
            for (char c : str) {
                System.out.print(c);
            }
            str.remove(0);
            System.out.println();
        }
        //напишите тут ваш код
    }

}

