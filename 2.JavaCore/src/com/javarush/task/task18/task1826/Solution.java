package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
Придумать механизм шифровки/дешифровки.

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName

где:
fileName - имя файла, который необходимо зашифровать/расшифровать.
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования.
-e - ключ указывает, что необходимо зашифровать данные.
-d - ключ указывает, что необходимо расшифровать данные.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = args[1];
        String fileOutputName = args[2];
        FileInputStream fileIn = new FileInputStream(fileName);
        FileOutputStream fileOut = new FileOutputStream(fileOutputName);

        if (args[0].equals("-e")) {
            while (fileIn.available() > 0) {
                fileOut.write(fileIn.read() + 1);
            }
        } else {
            while (fileIn.available() > 0) {
                fileOut.write(fileIn.read() - 1);
            }
        }
        fileIn.close();
        fileOut.close();
    }

}
