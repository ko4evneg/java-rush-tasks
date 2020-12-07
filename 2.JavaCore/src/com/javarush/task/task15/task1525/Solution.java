package com.javarush.task.task15.task1525;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();
    static {

        try {
            BufferedReader br = new BufferedReader(new FileReader(Statics.FILE_NAME));
            String str = "";
            while (br.ready()) {
                lines.add(br.readLine());
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}
