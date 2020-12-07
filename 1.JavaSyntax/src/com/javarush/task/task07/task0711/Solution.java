package com.javarush.task.task07.task0711;

/* 
Удалить и вставить
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strs = new ArrayList<String>();

        for (int i = 0; i < 5; i++) {
            strs.add(br.readLine());
        }

        for (int i = 0; i < 13; i++) {
            String temp = strs.get(strs.size()-1);
            strs.remove(strs.size()-1);
            strs.add(0, temp);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(strs.get(i));
        }
    }
}
