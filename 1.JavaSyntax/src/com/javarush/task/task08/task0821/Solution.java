package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleMap();
        printPeopleMap(map);
    }

    public static Map<String, String> createPeopleMap() {
        Map<String, String> people = new HashMap<>();
        people.put("Иванов", "Сергей");
        people.put("Андреев", "Антон");
        people.put("Антонов", "Сергей");
        people.put("Соколов", "Артур");
        people.put("Артуров", "Сокол");
        people.put("Алексеев", "Сергей");
        people.put("Соколов", "Мамед");
        people.put("Мамедов", "Агшин");
        people.put("Карпачев", "Павел");
        people.put("Вежнин", "Антон");
        return people;
    }

    public static void printPeopleMap(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
