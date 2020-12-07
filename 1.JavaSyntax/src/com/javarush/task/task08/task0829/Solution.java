package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int counter = 1;
        Map<String, String> list = new HashMap<>();

        while (true) {
            String city = reader.readLine();
            if (city.isEmpty() || city == null)
                break;
            String family = reader.readLine();
            if (family.isEmpty() || family == null) {
                break;
            }
            list.put(family, city);
        }

        // Read the house number
        //System.out.println("city");
        String cityLookup = reader.readLine();

        if (list.containsValue(cityLookup)) {
            for (Map.Entry<String, String> en : list.entrySet()) {
                if (en.getValue().equals(cityLookup))
                    System.out.println(en.getKey());
            }

        }
    }
}

