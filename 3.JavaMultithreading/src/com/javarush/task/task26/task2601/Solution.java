package com.javarush.task.task26.task2601;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{32, 21, 14, 8, 10, 17};
        arr = sort(arr);
        Arrays.toString(arr);
        for (Integer integer : arr) {
            System.out.println(integer);
        }

    }

    public static Integer[] sort(Integer[] array) {
        double median = array.length % 2 != 0 ? array[array.length / 2] : (array[array.length / 2] + array[array.length / 2 - 1]) / 2.0;
        System.out.println(median);
        ArrayList<Integer> arrList = new ArrayList<>(Arrays.asList(array));
        Collections.sort(arrList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.printf("o1: %d o2: %d || median dif = %.1f, %.1f\n", o1, o2, (median - o1), (median - o2));
                //if (median > o1)
                if ((median - o1) > (median - o2))
                    return -1;
                else if ((median - o1) < (median - o2))
                    return 1;
                else
                    return Integer.compare(o1, o2);
            }
        });
        return arrList.toArray(new Integer[]{});
    }
}
