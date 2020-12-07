package com.javarush.task.task08.task0808;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* 
10 тысяч удалений и вставок
4. Метод insert10000(List list) должен вставлять 10 тысяч элементов в список.
5. Метод get10000(List list) должен вызывать 10 тысяч раз get у списка.
6. Метод set10000(List list) должен вызывать 10 тысяч раз set у списка.
7. Метод remove10000(List list) должен удалять 10 тысяч элементов из списка.
*/

public class Solution {
    public static void main(String[] args) {
        // ArrayList
        ArrayList arrayList = new ArrayList();
        insert10000(arrayList);
        insert100002(arrayList);
        get10000(arrayList);
        set10000(arrayList);
        remove10000(arrayList);

        // LinkedList
        LinkedList linkedList = new LinkedList();
        insert10000(linkedList);
        insert100002(arrayList);
        get10000(linkedList);
        set10000(linkedList);
        remove10000(linkedList);
    }

    public static void insert10000(List list) {
        long startDate = (new Date()).getTime();
        for (int i = 0; i < 10000; i++) {
            list.add(i, new Object());
        }
        long endDate = (new Date()).getTime();
        System.out.println("ins = " + (endDate - startDate) + " ms");
    }
    public static void insert100002(List list) {
        long startDate = (new Date()).getTime();
        for (int i = 0; i < 10000; i++) {
            list.add(0, new Object());
        }
        long endDate = (new Date()).getTime();
        System.out.println("insMid = " + (endDate - startDate) + " ms");
    }
    public static void get10000(List list) {
        long startDate = (new Date()).getTime();
        for (int i = 0; i < 10000; i++) {
            list.get(i);
        }
        long endDate = (new Date()).getTime();
        System.out.println("get = " + (endDate - startDate) + " ms");
    }

    public static void set10000(List list) {
        long startDate = (new Date()).getTime();
        for (int i = 0; i < 10000; i++) {
            list.set(i,new Object());
        }
        long endDate = (new Date()).getTime();
        System.out.println("set = " + (endDate - startDate) + " ms");
    }

    public static void remove10000(List list) {
        long startDate = (new Date()).getTime();
        for (int i = 0; i < 10000; i++) {
            list.remove(0);
        }
        long endDate = (new Date()).getTime();
        System.out.println("rm = " + (endDate - startDate) + " ms");
    }
}
