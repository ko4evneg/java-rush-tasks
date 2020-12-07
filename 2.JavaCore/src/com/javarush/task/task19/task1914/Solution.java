package com.javarush.task.task19.task1914;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream sout = System.out;
        ByteArrayOutputStream byteStr = new ByteArrayOutputStream();
        PrintStream tmp = new PrintStream(byteStr);

        System.setOut(tmp);
        testString.printSomething();
        System.setOut(sout);

        String task = byteStr.toString();
        String[] opers = task.split(" ");
        int a = Integer.parseInt(opers[0]);
        int b = Integer.parseInt(opers[2]);
        int c = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        switch (opers[1]) {
            case "+":
                c = a + b;
                break;
            case "-":
                c = a - b;
                break;
            case "*":
                c = a * b;
                break;
        }
        task = task.replaceAll(System.lineSeparator(),"") + Integer.toString(c);

        System.out.print(task);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

