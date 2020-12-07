package com.javarush.task.task18.task1805;

/* 
Сортировка байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        //reading file
        ArrayList<Integer> bytes = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream fis = new FileInputStream(fileName);
        while (fis.available() > 0) {
            bytes.add(Integer.valueOf(fis.read()));
        }
        fis.close();

        //remove duplicates
        Collections.sort(bytes);
        for (int i = 0; i < bytes.size() - 1; i++) {
            if (bytes.get(i).equals(bytes.get(i + 1))) {
                bytes.remove(i + 1);
                i--;
            }
        }
        for (Integer integer : bytes) {
            System.out.print(integer + " ");
        }

    }
}
