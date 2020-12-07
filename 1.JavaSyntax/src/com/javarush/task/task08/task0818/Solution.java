package com.javarush.task.task08.task0818;

//import jdk.nashorn.internal.objects.IteratorResult;

import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("1",200);
        map.put("2",600);
        map.put("3",700);
        map.put("4",300);
        map.put("5",400);
        map.put("6",1200);
        map.put("7",2500);
        map.put("8",800);
        map.put("9",100);
        map.put("10",220);
        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> key = iterator.next();
            if (key.getValue() < 500) {
                iterator.remove();
            }
        }
        //System.out.println(map);
        /*for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (map.get(entry.getKey()) < 500) {
                map.remove(entry.getKey());
            }
        }*/

    }

    public static void main(String[] args) {
        //removeItemFromMap(createMap());
    }
}