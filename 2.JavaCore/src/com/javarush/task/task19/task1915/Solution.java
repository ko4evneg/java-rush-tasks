package com.javarush.task.task19.task1915;

import java.io.*;

/* 
Дублируем текст
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        PrintStream sout = System.out;
        ByteArrayOutputStream byteStr = new ByteArrayOutputStream();
        PrintStream tmp = new PrintStream(byteStr);
        System.setOut(tmp);

        testString.printSomething();

        System.setOut(sout);
        System.out.println(byteStr.toString());

        BufferedOutputStream fileBOS = new BufferedOutputStream(new FileOutputStream(fileName));
        fileBOS.write(byteStr.toByteArray());
        fileBOS.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

