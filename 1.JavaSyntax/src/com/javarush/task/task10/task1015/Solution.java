package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код
//1. Метод createList должен объявлять и инициализировать массив с типом элементов ArrayList<String>.
//2. Метод createList должен возвращать созданный массив.
//3. Метод createList должен добавлять в массив элементы (списки строк). Списки должны быть не пустые.
        ArrayList<String>[] strs = new ArrayList[2];
        ArrayList<String> temp = new ArrayList<>();
        temp.add("abc");
        temp.add("cde");
        strs[0] = temp;
        temp = new ArrayList<>();
        temp.add("eee");
        temp.add("rrr");
        strs[1] = temp;
        return strs;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}