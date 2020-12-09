package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;


/* 
Что внутри папки?
*/

public class Solution {
    static int files = 0;
    static int dirs = -1;
    static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Provide folder path: ");
        String path = reader.readLine();
        reader.close();

        if (!Files.isDirectory(Paths.get(path))) {
            System.out.println(path + " - не папка");
            return;
        }

        Files.walkFileTree(Paths.get(path), new Visitor());
        System.out.println("Всего папок - " + dirs);
        System.out.println("Всего файлов - " + files);
        System.out.println("Общий размер - " + size);
    }

    static class Visitor extends SimpleFileVisitor {
        @Override
        public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
            files++;
            size += Files.size((Path) file);
            return super.visitFile(file, attrs);
        }

        @Override
        public FileVisitResult preVisitDirectory(Object dir, BasicFileAttributes attrs) throws IOException {
            dirs++;
            return super.preVisitDirectory(dir, attrs);
        }
    }
}

