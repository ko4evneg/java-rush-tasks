package com.javarush.task.task08.task0828;

import java.io.*;
import java.util.*;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, String> monthes = new HashMap<>();
        monthes.put(1, "January");
        monthes.put(2, "February");
        monthes.put(3, "March");
        monthes.put(4, "April");
        monthes.put(5, "May");
        monthes.put(6, "June");
        monthes.put(7, "July");
        monthes.put(8, "August");
        monthes.put(9, "September");
        monthes.put(10, "October");
        monthes.put(11, "November");
        monthes.put(12, "December");

        String month = reader.readLine();
        for (Map.Entry<Integer, String> s : monthes.entrySet()) {
            if (s.getValue().equals(month))
                System.out.println(month + " is the " + s.getKey() + " month");
        }
    }}
