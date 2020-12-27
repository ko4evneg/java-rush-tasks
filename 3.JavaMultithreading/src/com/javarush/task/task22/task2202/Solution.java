package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null)
            throw new TooShortStringException();
        string = string.substring(string.indexOf(" ") + 1);
        String arrStr[] = string.split(" ");
        if (arrStr.length < 4)
            throw new TooShortStringException();
        return arrStr[0] + " " + arrStr[1] + " " +  arrStr[2] + " " +  arrStr[3];
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
