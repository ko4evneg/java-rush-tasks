package com.javarush.task.task09.task0921;

/* 
Метод в try..catch

Код внутри readData обернуть в try..catch.
Если пользователь ввёл какой-то текст, вместо ввода числа, то метод должен перехватить исключение и вывести на экран все ранее введенные числа в качестве результата.
Числа выводить с новой строки сохраняя порядок ввода.


Требования:
1. Программа должна считывать данные с клавиатуры.
4. Метод readData должен содержать блок try..catch.
5. Если пользователь ввел текст, а не число, программа должна вывести все ранее введенные числ
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> nums = new ArrayList<Integer>();
        try {
            while (true) {
                nums.add(Integer.parseInt(reader.readLine()));
            }
        } catch (Exception e) {
            for (int i : nums) {
                System.out.println(i);
            }
            //reader.close();
        }
    }
}
