package com.javarush.task.task31.task3111;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName = "";
    private String partOfContent = "";
    private int minSize = Integer.MIN_VALUE;
    private int maxSize = Integer.MAX_VALUE;
    private List<Path> foundFiles = new LinkedList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (!file.getFileName().toString().contains(partOfName))
            return FileVisitResult.CONTINUE;
        if (!(new String(Files.readAllBytes(file))).contains(partOfContent))
            return FileVisitResult.CONTINUE;
        if (attrs.size() <= minSize)
            return FileVisitResult.CONTINUE;
        if (attrs.size() >= maxSize )
            return FileVisitResult.CONTINUE;

        foundFiles.add(file);
        return FileVisitResult.CONTINUE;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}

