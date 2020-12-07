package com.javarush.task.task31.task3102;
/*
Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используй очередь, рекурсию не используй.
Верни список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.


Требования:
1. Метод getFileTree должен принимать аргументом String root, по которому нужно найти все вложенные файлы.
2. Метод getFileTree должен возвращать список строк.
3. Нужно реализовать метод getFileTree: найти все файлы по указанному пути и добавить их в список.
4. Метод getFileTree должен быть вызван только 1 раз (рекурсию не использовать).
*/

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) {
        File dir = new File(root);
        Queue<File> files = new LinkedList<>();
        LinkedList<String> result = new LinkedList<>();
        Collections.addAll(files, dir.listFiles());
        while (!files.isEmpty()) {
            File t = files.remove();
            if (t.isFile())
                result.add(t.getAbsolutePath());
            else
                Collections.addAll(files, t.listFiles());
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> files = getFileTree("E:\\Profile\\Documents\\CSS");
    }
}
