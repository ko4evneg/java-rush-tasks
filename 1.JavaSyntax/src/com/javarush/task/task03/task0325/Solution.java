package com.javarush.task.task03.task0325;

/* 
Финансовые ожидания
*/
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        int num;
        InputStream inputStream = System.in;
        InputStreamReader inRd = new InputStreamReader(inputStream);
        BufferedReader bfRd = new BufferedReader(inRd);
        num = Integer.parseInt(bfRd.readLine());
        System.out.println("Я буду зарабатывать $" + num + " в час");
    }
}
