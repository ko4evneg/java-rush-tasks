package com.javarush.task.task13.task1319;

/* 
Писатель в файл с консоли
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> strs = new ArrayList<String>();
        String fName = reader.readLine();

        while (true) {
            String cStr = reader.readLine();
            strs.add(cStr);
            if (cStr.equals("exit")) {
                reader.close();
                break;
            }
        }

        BufferedWriter fileWrite = new BufferedWriter(new FileWriter(fName));
        for (String s : strs) {
            fileWrite.newLine();
            fileWrite.write(s);
        }
        fileWrite.close();
    }
}
