package com.javarush.task.task19.task1913;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Выводим только цифры
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
        System.out.println(byteStr.toString().replaceAll("\\D+",""));
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
