package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.

Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')' , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру


*/

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        //1 and 2 checks
        if (!(telNumber.matches("^\\+([\\D]*\\d[\\D]*){12}$") ||
                telNumber.matches("(^[0-9]([\\D]*\\d[\\D]*){9}$|^\\(([\\D]*\\d[\\D]*){10}$)")) ||
                telNumber.matches("(.*--.*|(.*-.*){3,})") ||    //3 check
                telNumber.matches("((.*\\(.*){2,}|(.*\\).*){2,})") || telNumber.matches(".*-.*[\\(\\)].*") || //4 check
                telNumber.matches("\\(\\d{3}\\)") //here we are
        )
            return false;
        return true;
    }

    public static void main(String[] args) {
        String num = "123gh(45l6789)0-";
        System.out.println(checkTelNumber(num));

    }
}
