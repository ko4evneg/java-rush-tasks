package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> params = new HashMap<>();
        params.put("A","5");
        params.put("B","6");
        params.put("C","6");
        params.put("D","6");
        System.out.println(getQuery(params));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (entry.getValue() == null)
                continue;
            sb.append(entry.getKey()).append(" = '").append(entry.getValue()).append("' and ");
        }
        sb.replace(sb.lastIndexOf("' and ") + 1, sb.length(), "");
        return sb.toString();
    }
}
