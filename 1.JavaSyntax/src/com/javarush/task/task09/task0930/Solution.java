package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
Задача по алгоритмам Ӏ Java Syntax: 9 уровень, 11 лекция
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Integer> rInt = new ArrayList<>();
        ArrayList<String> rStr = new ArrayList<>();
        Map<Integer, Boolean> map = new HashMap<>();
        int i = 0;
        //read input
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) {
                break;
            }
            list.add(s);
            map.put(i++, isNumber(s));
        }

        String[] array = list.toArray(new String[list.size() - 1]);
        sort(array);
        //here is ASC sorted list
        list = new ArrayList<String>(Arrays.asList(array));
        //split to nums and strings
        for (String s : list) {
            if (isNumber(s))
                rInt.add(Integer.parseInt(s));
            else
                rStr.add(s);
        }
        //reverse numbers sort
        for (int j = 0; j < rInt.size() / 2; j++) {
            int temp = rInt.get(j);
            rInt.set(j, rInt.get(rInt.size() - 1 - j));
            rInt.set(rInt.size() - 1 - j, temp);
        }
        //output
        int numCounter = 0;
        int strCounter = 0;
        for (int j = 0; j < map.size(); j++) {
            if (map.get(j))
                System.out.println(rInt.get(numCounter++));
            else
                System.out.println(rStr.get(strCounter++));
        }
    }

    public static void sort(String[] array) {

            //Напишите тут ваш код


            int counterW = 0;
            int counterN = 0;
            for (int i=0;i<array.length;i++) {
                if (isNumber(array[i])){

                    counterN++;
                }
                else    counterW++;

            }



            String[] words = new String[counterW];
            String[] numbers = new String[counterN];

            counterW=0;counterN=0;

            for (int i=0;i<array.length;i++) {
                if (isNumber(array[i])) {
                    numbers[counterN]=array[i]; counterN++;
                }
                else {words[counterW]=array[i]; counterW++;}
            }

            //descending bubble sort:
            String temp;
            for (int i=0;i<numbers.length;i++) {
                for (int j=1;j<numbers.length-i;j++) {
                    int a = Integer.parseInt(numbers[j-1]);
                    int b = Integer.parseInt(numbers[j]);
                    if(a>b) {
                        temp =numbers[j-1];
                        numbers[j-1]=numbers[j];
                        numbers[j]=temp;
                    }
                }
            }
            // increasing bubble sort
            for (int i=0;i<words.length;i++) {
                for (int j=0;j<words.length-1;j++) {
                    if (isGreaterThan(words[j],words[j+1])){
                        temp = words[j];
                        words[j]=words[j+1];
                        words[j+1]=temp;

                    }
                }
            }
            counterW=0;counterN=0;
            for (int i=0;i<array.length;i++) {
                if (isNumber(array[i])) {
                    array[i]=numbers[counterN]; counterN++;
                }
                else {array[i]=words[counterW]; counterW++;}
            }

        }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
