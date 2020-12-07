package com.javarush.task.task18.task1824;

import java.io.*;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file;
        while (true) {
            file = reader.readLine();
            try {
                FileInputStream f = new FileInputStream(file);
                f.close();
            } catch (FileNotFoundException e) {
                System.out.println(file);
                reader.close();
                return;
            } finally {

            }
        }
    }
}
