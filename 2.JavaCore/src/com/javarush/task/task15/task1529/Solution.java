package com.javarush.task.task15.task1529;

/* 
Осваивание статического блока
4. В статическом блоке инициализировать CanFly result вызвав метод reset.
5. Закрыть поток ввода методом close().
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

    }

    static {
        try {
            reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static CanFly result;

    public static void reset() throws IOException {
        String s = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        if (s.equals("helicopter")) {
            result = new Helicopter();
        } else if (s.equals("plane")) {
            int i = Integer.parseInt((new BufferedReader(new InputStreamReader(System.in))).readLine());
            result = new Plane(i);
        }
    }
}
