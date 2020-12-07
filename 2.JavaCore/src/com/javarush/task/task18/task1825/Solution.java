package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл

Каждый файл имеет имя: [someName].partN.
Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.

В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].

Например, Lion.avi.

В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки.
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = "";
        ArrayList<String> list = new ArrayList<>();
        try {
            while (!filename.equals("end")) {
                filename = reader.readLine();
                list.add(filename);
            }
        }catch (IOException e){
        }

        Collections.sort(list); // Сортировка имен частей
        filename = list.get(0).substring(0, list.get(0).lastIndexOf(".")); // Формирование имени основного файла
        int bytebuffer;
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(filename))){
            for (String s : list) {
                try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(s))){
                    while((bytebuffer = in.read()) != -1){
                        out.write(bytebuffer);
                    }
                } catch (IOException e){
                }
            }
        } catch (IOException e){
        }
    }
}