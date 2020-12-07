package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines.
4. Если условие из п.3 не выполнено, то:
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
Не забудь закрыть потоки.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        readFile(file1, allLines);
        readFile(file2, forRemoveLines);
        reader.close();
        new Solution().joinData();
    }

    private static void readFile(String file, List<String> x) throws IOException {
        String tmpStr = "";
        FileReader fr = new FileReader(file);
        while (fr.ready()) {
            char ch = (char) fr.read();
            if (ch != '\r' && ch != '\n')
                tmpStr += ch;
            else {
                if (ch == '\n') {
                    x.add(tmpStr);
                    tmpStr = "";
                }
            }
        }
        if (tmpStr != "")
            x.add(tmpStr);
        fr.close();
    }

    public void joinData() throws CorruptedDataException {
        List<String> allLinesCopy = allLines;
            int strings = 0;
            for (String s : allLines) {
                if (forRemoveLines.contains(s)) strings++;
            }
            //all lines
            if (strings == forRemoveLines.size()) {
                for (String s : forRemoveLines) {
                    allLines.remove(s);
                }
            } else {
                allLines.clear();
                //allLines = allLinesCopy;
                throw new CorruptedDataException();
            }

    }
}

