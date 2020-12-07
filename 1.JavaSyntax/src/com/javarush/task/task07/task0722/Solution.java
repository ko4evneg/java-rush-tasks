package com.javarush.task.task07.task0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Это конец
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strs = new ArrayList<>();

        while (true) {
            String str = reader.readLine();
            if (str.equals("end"))
                break;
            strs.add(str);
        }

        for (int i = 0; i < strs.size(); i++) {
            System.out.println(strs.get(i));
        }

//1. Объяви переменную типа список строк и сразу проинициализируй ee.
//2. Считывай строки с клавиатуры и добавляй их в список, пока пользователь не введет строку "end".
//3. Саму строку "end" не нужно добавлять в список.
//4. Выведи список на экран, каждое значение с новой строки.
//5. Используй цикл for.
        //напишите тут ваш код
    }
}