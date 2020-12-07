package com.javarush.task.task07.task0709;

/* 
Выражаемся покороче
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strs = new ArrayList<String>();
        int shortestIndex = 0;
        ArrayList<Integer> shorts = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            strs.add(br.readLine());
        }
        for (int i = 1; i < 5; i++) {
            if (strs.get(shortestIndex).length() > strs.get(i).length()) {
                shortestIndex = i;
            }
        }
        for (int i = 0; i < 5; i++) {
            if (strs.get(shortestIndex).length() == strs.get(i).length()) {
                shorts.add(i);
            }
        }
        System.out.println(strs.get(shortestIndex));

        if (shorts.size() > 0) {
            for (int i = 0; i < shorts.size(); i++) {
                int j = shorts.get(i);
                System.out.println(strs.get(j));
            }
        }
            /*else if (strs.get(shortestIndex).length() == strs.get(i).length()) {
                areSame1 = shortestIndex;
                areSame2 = i;
            }
        }
        if (areSame1 != 0 || areSame2 != 0) {
            System.out.println(strs.get(areSame1));
            System.out.println(strs.get(areSame2));
        }*/
//        3. Используя цикл, найди самую короткую строку в списке.
//        4. Выведи найденную строку на экран.
//        5. Если таких строк несколько, выведи каждую с новой строки.


    }
}