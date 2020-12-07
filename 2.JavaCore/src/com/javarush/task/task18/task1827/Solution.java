package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы
Программа запускается со следующим набором параметров:
-c productName price quantity

Значения параметров:
где id - 8 символов.
productName - название товара, 30 символов.
price - цена, 8 символов.
quantity - количество, 4 символа.
-c - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле.

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity

Данные дополнены пробелами до их длины.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0)
            return;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        //looking fol max item ID in the file
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
        fileWriter.close();
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
