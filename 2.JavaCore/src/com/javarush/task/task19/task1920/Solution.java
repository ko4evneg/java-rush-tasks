package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/* 
Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Вывести в консоль имена в алфавитном порядке, у которых максимальная сумма.
Имена разделять пробелом либо выводить с новой строки.
Закрыть потоки.

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        TreeMap<String, Double> result = new TreeMap<>();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        String s;
        while ((s = fileReader.readLine()) != null) {
            String name = s.split(" ")[0];
            Double value = Double.parseDouble(s.split(" ")[1]);

            if (result.containsKey(name)) {
                result.put(name, result.get(name) + value);
            } else
                result.put(name, value);
        }
        fileReader.close();

        Double maxValue = result.get(result.firstKey());
        TreeMap<String, Double> maxResult = new TreeMap<>();

        for (Map.Entry<String, Double> stringDoubleEntry : result.entrySet()) {
            if (Double.compare(maxValue, stringDoubleEntry.getValue()) < 0) {
                maxResult.clear();
                maxResult.put(stringDoubleEntry.getKey(), stringDoubleEntry.getValue());
                maxValue = stringDoubleEntry.getValue();
            } else if (Double.compare(maxValue, stringDoubleEntry.getValue()) == 0) {
                maxResult.put(stringDoubleEntry.getKey(), stringDoubleEntry.getValue());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Double> stringDoubleEntry : maxResult.entrySet()) {
            sb.append(stringDoubleEntry.getKey() + " ");
        }
        System.out.println(sb.toString().trim());
    }
}
