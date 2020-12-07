package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Количество букв
 10 строчек и подсчитать в них количество различных букв (для 33 маленьких букв алфавита). Результат вывести на экран в алфавитном порядке.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
                'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц',
                'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я');

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        for (char c : alphabet)  {
            for (Map.Entry<Character, Integer> entry : countLetters(list, alphabet).entrySet()) {
                if (entry.getKey().equals(c))
                    System.out.println(entry.getKey() + " " + entry.getValue());
            }

        }

        // напишите тут ваш код
    }

    public static Map<Character, Integer> countLetters(ArrayList<String> arr, List<Character> alph) {
        Map<Character, Integer> result = new HashMap<>();
        for (char c : alph) {
            result.put(c, 0);
        }

        for (String s : arr) {
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (alph.contains(c))
                   result.put(c, result.get(c) + 1);
            }
        }
        return result;
    }
}
