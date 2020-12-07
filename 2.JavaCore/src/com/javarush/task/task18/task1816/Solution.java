package com.javarush.task.task18.task1816;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв).
Закрыть потоки.

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileIn = new FileInputStream(args[0]);
        BufferedInputStream fileInB = new BufferedInputStream(fileIn,16000);
        int count = 0;

        int i;
        while ((i = fileInB.read()) != -1){
            if ((i > 96 && i < 123) || (i > 64 && i < 91))
                count++;
        }
        fileIn.close();
        fileInB.close();
        System.out.println(count);
    }
}
