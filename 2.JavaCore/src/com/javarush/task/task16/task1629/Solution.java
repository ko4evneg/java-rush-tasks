package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();

        t1.start();
        t1.join();
        t2.start();
        t2.join();

        t1.printResult();
        t2.printResult();
    }

    public static class Read3Strings extends Thread {
        String s;

        public void run() {
            ArrayList<String> list = new ArrayList<>();
            try {
                list.add(reader.readLine());
                list.add(reader.readLine());
                list.add(reader.readLine());
                s = list.get(0) + " " + list.get(1) + " " + list.get(2);
            } catch (IOException e) {
            }
        }

        public void printResult() {
            System.out.println(s);
        }
    }

}
