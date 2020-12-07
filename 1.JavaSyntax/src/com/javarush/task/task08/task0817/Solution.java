package com.javarush.task.task08.task0817;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> people = new HashMap<>();
        people.put("Иванов", "Сергей");
        people.put("Андреев", "Антон");
        people.put("Антонов", "Сергей");
        people.put("Соколов", "Артур");
        people.put("Артуров", "Сокол");
        people.put("Алексеев", "Сергей");
        people.put("Сергеев", "Мамед");
        people.put("Мамедов", "Агшин");
        people.put("Карпачев", "Павел");
        people.put("Вежнин", "Антон");
        return people;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        ArrayList<String> strs = new ArrayList<>(map.values());
        for (String s :strs) {
            if (Collections.frequency(map.values(), s) > 1) {
                removeItemFromMapByValue(map,s);
            }
        }

        //System.out.println(map);
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        // Удаление пары из map по ключу из copy.
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
        //removeTheFirstNameDuplicates(createMap());
    }
}
