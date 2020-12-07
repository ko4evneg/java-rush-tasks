package com.javarush.task.task18.task1803;

/* 
Самые частые байты
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> bytes = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream fis = new FileInputStream(fileName);
        while (fis.available() > 0) {
            bytes.add(Integer.valueOf(fis.read()));
        }
        fis.close();

        int maxOccurence = 0;
        ArrayList<Integer> maxBytes = new ArrayList<Integer>();
        for (Integer i : bytes) {
            int curOccurence = 0;
            for (Integer j : bytes) {
                if (i.equals(j)) curOccurence++;
            }
            if (curOccurence > maxOccurence) {
                maxBytes.clear();
                maxBytes.add(i);
                maxOccurence = curOccurence;
            } else if (curOccurence == maxOccurence) {
                maxBytes.add(i);
                maxOccurence = curOccurence;
            }
        }
        String s = "";
        for (Integer integer : maxBytes) {
            if (!s.contains(Integer.toString(integer)))
                s += integer.intValue() + " ";
        }
        System.out.println(s);
    }
}
