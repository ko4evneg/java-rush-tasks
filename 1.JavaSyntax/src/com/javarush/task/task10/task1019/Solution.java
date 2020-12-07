package com.javarush.task.task10.task1019;
import java.io.*;
import java.util.*;

/* 
Функциональности маловато!
Пустая строка - конец ввода данных.
Введенные данные не должны потеряться!
Затем программа выводит содержание HashMap на экран.
Каждую пару с новой строки.
Требования:

2. Программа должна выводить текст на экран.
3. В методе main объяви переменную коллекции HashMap и сразу проинициализируй ee.
4. Программа должна помещать в HashMap пары считанные с клавиатуры.
5. Программа должна выводить на экран содержимое HashMap согласно условию. Ключ и значение разделены пробелом. Каждое значение с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> result = new HashMap<>();

        while (true) {
            try {
                String strId = reader.readLine();
                if (strId == null || strId == "")
                    break;
                int id = Integer.parseInt(strId);
                String name = reader.readLine();
                result.put(name, Integer.valueOf(id));
            } catch (Exception e) {
//                System.out.println(e.getMessage());
//                System.out.println(e.getStackTrace());
                break;
            }
        }

        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.println(entry.getValue() + " " + entry.getKey());
        }
    }
}
