package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0)
            return;

        //reading file name
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        switch (args[0]) {
            case "-u":
                updateRecord(addSpaces(args[1],8), args[2], args[3], args[4], fileName);
                break;
            case "-d":
                deleteRecord(args[1], fileName);
                break;
        }
/*        //looking fol max item ID in the file
        String line;
        boolean endsWithNewLine = false;
        int maxItemID = 0; //max ID
        while ((line = fileReader.readLine()) != null) {
            int currentItemID = Integer.parseInt(line.substring(0,8).trim());
            if (currentItemID > maxItemID) maxItemID = currentItemID;
            if (line.endsWith("\n")) endsWithNewLine = true;
            else endsWithNewLine = false;
        }
        fileReader.close();

        //writing new item
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName,true));
        if (!endsWithNewLine) fileWriter.newLine();
        String newItem = addSpaces(args[1],30) + addSpaces(args[2],8) + addSpaces(args[3],4);
        newItem = addSpaces(Integer.toString(++maxItemID), 8) + newItem;
        fileWriter.write(newItem);
        fileWriter.close();*/

    }

    private static void updateRecord(String id, String productName, String price, String quantity, String fileName) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String file = "", tmp = null;
        while ((tmp = fileReader.readLine()) != null) {
            if (!(tmp.startsWith(id)))
                file += tmp + System.lineSeparator();
            else
                file += id + addSpaces(productName,30) + addSpaces(price,8) + addSpaces(quantity,4) + System.lineSeparator();
        }
        fileReader.close();
        BufferedOutputStream fileBOS = new BufferedOutputStream(new FileOutputStream(fileName));
        fileBOS.write(file.getBytes());
        fileBOS.close();
    }

    private static void deleteRecord(String toDelStrId,String fileName) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String file = "", tmp = null;
        while ((tmp = fileReader.readLine()) != null) {
            if (!(tmp.startsWith(toDelStrId)))
                file += tmp + System.lineSeparator();
        }
        fileReader.close();
        BufferedOutputStream fileBOS = new BufferedOutputStream(new FileOutputStream(fileName));
        fileBOS.write(file.getBytes());
        fileBOS.close();
    }

    private static String addSpaces (String str, int n) {
        StringBuffer s = new StringBuffer();
        s.append(str);
        if (s.length() < n) {
            for (int i = s.length(); i < n; i++) {
                s.append(" ");
            }
        }
        return s.toString();
    }
}