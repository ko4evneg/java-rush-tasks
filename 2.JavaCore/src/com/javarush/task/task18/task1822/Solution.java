package com.javarush.task.task18.task1822;

import java.io.*;
import java.util.zip.InflaterInputStream;

/* 
Поиск данных внутри файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int).
Закрыть потоки.

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity
где id - int.
productName - название товара, может содержать пробелы, String.
price - цена, double.
quantity - количество, int.

Информация по каждому товару хранится в отдельной строке.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        String str = "";//
        //int id = Integer.parseInt(args[0]);

        BufferedReader filereader = new BufferedReader(new FileReader(fileName));

        while (true) {
            str = filereader.readLine();
            if (str == null)
                break;
            else if (str.startsWith(args[0] + " ")) {
                System.out.println(str);
                break;
            } else
                str = "";
        }
        filereader.close();

       /* String currentItem = "";
        int i;
        boolean idFound = false;
        boolean skipString = false;

        while ((i = bis.read()) != -1) {
            if (!Character.isDigit(i) && !skipString) {
                if (Integer.parseInt(currentItem) == id)
                    idFound = true;
                else
                    skipString = true;
            }

            if (idFound)
                break;

            if (skipString && (char) i != '\n') {
                continue;
            } else if (skipString && (char) i == '\n') {
                currentItem = "";
                skipString = false;
                continue;
            } else
                currentItem += (char) i;
        }
            System.out.print(currentItem + " ");
        while ((i = bis.read()) != -1 && i != (int) '\r') {
            System.out.print((char) i);
        }*/
        //bis.close();
    }
}
