package com.javarush.task.task18.task1804;

/* 
Самые редкие байты
Ввести с консоли имя файла.
Найти байт или байты с минимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.
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

        int minOccurence = bytes.size();
        ArrayList<Integer> minBytes = new ArrayList<Integer>();
        for (Integer i : bytes) {
            int curOccurence = 0;
            for (Integer j : bytes) {
                if (i.equals(j)) curOccurence++;
            }
            if (curOccurence < minOccurence) {
                minBytes.clear();
                minBytes.add(i);
                minOccurence = curOccurence;
            } else if (curOccurence == minOccurence) {
                minBytes.add(i);
                minOccurence = curOccurence;
            }
        }
        for (Integer integer : minBytes) {
            System.out.print(integer + " ");
        }
    }
}
