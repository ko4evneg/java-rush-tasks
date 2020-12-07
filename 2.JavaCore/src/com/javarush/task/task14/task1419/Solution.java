package com.javarush.task.task14.task1419;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        //1
        try {
            float i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
        }
        //2
        try {
            int[] arr = new int[0];
            arr[1] = 1;
        } catch (Exception e) {
            exceptions.add(e);
        }
        //3
        try {
            Solution s = null;
            s.toString();
        } catch (Exception e) {
            exceptions.add(e);
        }
        //4
        try {
            FileInputStream fs = new FileInputStream("C:\\huylo");
        } catch (Exception e) {
            exceptions.add(e);
        }
        //5
        try {
            int[] arr = new int[-5];
        } catch (Exception e) {
            exceptions.add(e);
        }
        exceptions.add(new IOException());
        exceptions.add(new NumberFormatException());
        exceptions.add(new ClassNotFoundException());
        exceptions.add(new ClassCastException());
        exceptions.add(new ArrayStoreException());
        //напишите тут ваш код

    }
}
