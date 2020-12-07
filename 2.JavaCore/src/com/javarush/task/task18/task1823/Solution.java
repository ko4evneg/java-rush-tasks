package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit".
Передайте имя файла в нить ReadThread.
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - эт    о имя файла, параметр Integer - это искомый байт.
Закрыть потоки.
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> files = new ArrayList<>();
        HashMap<String, Integer> resultMap = new HashMap<>();
        String s;

        while (!(s = reader.readLine()).equals("exit")) {
            new ReadThread(s);
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
            run();
        }

        public void run() {
            BufferedInputStream fileRead = null;
            try {
                fileRead = new BufferedInputStream(new FileInputStream(fileName));
            } catch (FileNotFoundException foundException) {
                System.out.println("FILE NOT FOUND U BI4! " + fileName);
            }
            int i;
            //key = char, value = frequency
            HashMap<Integer, Integer> maxOccurence = new HashMap<>();
            try {
                while ((i = fileRead.read()) != -1) {
                    if (maxOccurence.containsKey(i))
                        maxOccurence.put(i, maxOccurence.get(i) + 1);
                    else
                        maxOccurence.put(i, 1);
                }
            } catch (IOException e) {
                System.out.println("CANT READ SH1T");
            }
            int maxValue = -1;
            int maxInt = -1;

            for (Map.Entry<Integer, Integer> entry : maxOccurence.entrySet()) {
                if (entry.getValue() > maxInt) {
                    maxInt = entry.getValue();
                    maxValue = entry.getKey();
                }
            }
            synchronized (resultMap) {
                resultMap.put(fileName, Integer.valueOf(maxValue));
            }
            try {
                fileRead.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
