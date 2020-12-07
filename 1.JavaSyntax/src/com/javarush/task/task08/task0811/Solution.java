package com.javarush.task.task08.task0811;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Квартет «Методы»
3. Метод getListForGet должен возвращать список, который лучше всего подходит для операции взятия элемента.
4. Метод getListForSet должен возвращать список, который лучше всего подходит для установки значения элемента.
5. Метод getListForAddOrInsert должен возвращать список, который лучше всего подходит для операций добавления или вставки элемента.
6. Метод getListForRemove должен возвращать список, который лучше всего подходит для операции удаления элемента.
*/

public class Solution {
    public static List getListForGet() {
        ArrayList list = new ArrayList<>();
        return list;
    }

    public static List getListForSet() {
        ArrayList list = new ArrayList<>();
        return list;
    }

    public static List getListForAddOrInsert() {
        LinkedList list = new LinkedList<>();
        return list;

    }

    public static List getListForRemove() {
        LinkedList list = new LinkedList<>();
        return list;

    }

    public static void main(String[] args) {

    }
}
