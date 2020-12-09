package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

/* 
Продвинутый поиск файлов
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        SearchFileVisitor searchFileVisitor = new SearchFileVisitor();

        searchFileVisitor.setPartOfName("");
        searchFileVisitor.setPartOfContent("UY");
        searchFileVisitor.setMinSize(50);
        searchFileVisitor.setMaxSize(300);

        Files.walkFileTree(Paths.get("D:/temp_java/java_dir"), searchFileVisitor);

        List<Path> foundFiles = searchFileVisitor.getFoundFiles();
        for (Path file : foundFiles) {
            System.out.println(file);
        }
    }

}
