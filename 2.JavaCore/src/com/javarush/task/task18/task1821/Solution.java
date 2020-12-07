package com.javarush.task.task18.task1821;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/* 
Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете).

Пример:
','=44, 's'=115, 't'=116.

Вывести на консоль отсортированный результат:
[символ1] частота1
[символ2] частота2
Закрыть потоки.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedInputStream fileIn = new BufferedInputStream(new FileInputStream(args[0]));
        HashMap<Integer, Integer> charOccurence = new HashMap<>();
        ArrayList<Integer> sortList = new ArrayList<>();

        int i;
        while ((i = fileIn.read()) != -1) {
            if (!charOccurence.containsKey(i)) {
                charOccurence.put(i, 1);
                sortList.add(i);
            } else
                charOccurence.put(i, charOccurence.get(i) + 1);
        }
        fileIn.close();
        Collections.sort(sortList);
        for (Integer intCh : sortList) {
            System.out.println((char) intCh.intValue() + " " + charOccurence.get(intCh));
        }

    }
}
