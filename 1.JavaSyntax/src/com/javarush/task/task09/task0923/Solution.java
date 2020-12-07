package com.javarush.task.task09.task0923;

/* 
Гласные и согласные
*/



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        reader.close();
        String vowels = "";
        String others = "";

        char[] charset = str.toCharArray();
        for (char c : charset) {
            if (isVowel(c))
                vowels += c + " ";
            else if (!Character.isSpaceChar(c))
                others += c + " ";
        }

        System.out.println(vowels);
        System.out.println(others);
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}