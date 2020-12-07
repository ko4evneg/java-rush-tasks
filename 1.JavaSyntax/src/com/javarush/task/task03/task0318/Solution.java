package com.javarush.task.task03.task0318;

/* 
План по захвату мира
*/

import java.io.*;
import java.nio.Buffer;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inReader = new InputStreamReader(inputStream);
        BufferedReader bufReader = new BufferedReader(inReader);
        String s1 = bufReader.readLine();
        String s2 = bufReader.readLine();
        int i1 = Integer.parseInt(s2);
        System.out.println(s1 + " захватит мир через " + i1 + " лет. Му-ха-ха!");
    }
}
