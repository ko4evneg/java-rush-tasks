package com.javarush.task.task08.task0801;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Set из растений
*/

public class Solution {
    public static void main(String[] args) {
        Set<String> food = new HashSet<>();
        food.add("арбуз");
        food.add("банан");
        food.add("вишня");
        food.add("груша");
        food.add("дыня");
        food.add("ежевика");
        food.add("женьшень");
        food.add("земляника");
        food.add("ирис");
        food.add("картофель");
        
        Iterator<String> it = food.iterator();
        
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        
    }
}
