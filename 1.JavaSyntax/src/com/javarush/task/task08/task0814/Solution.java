package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;


/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static Set<Integer> createSet() {
        Set<Integer> nums = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            int num = (int)(Math.random() * 10.0 + Math.random() * 100.0);
            while (nums.contains(num)) {
                num = (int) (Math.random() * 10.0 + Math.random() * 100.0);
            }
            nums.add(num);
        }
        //System.out.println(nums);
        return nums;
    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        Iterator<Integer> i = set.iterator();
        while (i.hasNext()) {
            int num = i.next();
            if (num > 10)
                i.remove();
        }
        return set;
    }

    public static void main(String[] args) {
    Set<Integer> set = createSet();
    set = removeAllNumbersGreaterThan10(set);
    //    System.out.println(set);
    }
}
