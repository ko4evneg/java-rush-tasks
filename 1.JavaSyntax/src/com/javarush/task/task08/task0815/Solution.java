package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.*;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> people = new HashMap<String, String>();
        people.put("Ивановс", "Сергей");
        people.put("Андреев", "Антон");
        people.put("Антонов", "Сергей");
        people.put("Соколов", "Артур");
        people.put("Артуров", "Сокол");
        people.put("Иванов", "Сергей");
        people.put("Сергеев", "Мамед");
        people.put("Мамедов", "Агшин");
        people.put("Иванова", "Павла");
        people.put("Вежнин", "Антон");
        return people;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        int count = 0;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            String cName = pair.getValue();
            if (cName.equals(name))
                count++;
        }

        return count;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        int count = 0;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            String cName = pair.getKey();
            if (cName.equals(lastName))
                count++;
        }

        return count;
    }

    public static void main(String[] args) {

    }
}
