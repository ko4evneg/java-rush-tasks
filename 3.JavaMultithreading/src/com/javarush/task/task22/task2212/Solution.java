package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null || !(telNumber.matches("^\\+([\\D]*\\d[\\D]*){12}$") ||    //1 check
                telNumber.matches("(^[0-9]([\\D]*\\d[\\D]*){9}$|^\\(([\\D]*\\d[\\D]*){10}$)")) ||    //2 check
                telNumber.matches("(.*--.*|(.*-.*){3,})") ||    //3 check
                telNumber.matches("((.*\\(.*){2,}|(.*\\).*){2,})") || telNumber.matches(".*-.*[\\(\\)].*") ||   //4 check
                telNumber.matches("\\((?!.*\\))") || telNumber.matches(".*(?<!\\(\\d{3})\\).*") ||  //double brackets check and 5 check
                //telNumber.matches(".*\\((?!\\d{3}\\)).*") ||    //5 check
                telNumber.matches(".*[^0-9\\(\\)\\+-].*") ||    //6 check
                telNumber.matches(".*\\D$")  //6 check
        )
            return false;
        return true;
    }

    public static void main(String[] args) {
        String num = "(0)501234567";
        System.out.println(checkTelNumber(num));

    }
}
