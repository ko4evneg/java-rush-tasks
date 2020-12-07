package com.javarush.task.task18.task1817;

import java.io.*;

/* 
Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45.
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой.
4. Закрыть потоки.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = args[0];
        FileInputStream fis = new FileInputStream(fileName);
        BufferedInputStream bis = new BufferedInputStream(fis);
        int chars = 0;
        int spaces = 0;
        int i;

        while ((i = bis.read()) != -1) {
            if ((char) i != ' ')
                chars++;
            else
                spaces++;
        }
        chars += spaces;
        bis.close();
        fis.close();

        System.out.println((Math.round(spaces / (double) chars * 10000))/100.0);
    }
}
