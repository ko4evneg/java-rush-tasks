package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
/*
3. Если в SearchFileVisitor задан критерий поиска partOfName, метод visitFile должен добавить файл в foundFiles, если в названии содержится строка partOfName.
4. Если в SearchFileVisitor задан критерий поиска partOfContent, метод visitFile должен добавить файл в foundFiles, если в содержимом встречается строка partOfContent.
5. Если в SearchFileVisitor задан критерий поиска maxSize, метод visitFile должен добавить файл в foundFiles, если размер файла меньше maxSize.
6. Если в SearchFileVisitor задан критерий поиска minSize, метод visitFile должен добавить файл в foundFiles, если размер файла больше minSize.
*/

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName, partOfContent;
    private int minSize, maxSize;
    private HashSet<Path> result = new HashSet<>();
    private List<Path> foundFiles = new LinkedList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (partOfName != null && partOfName.length() > 0) {
            if (file.getFileName().toString().contains(partOfName)) result.add(file);
        }

        if (partOfContent != null && partOfName.length() > 0) {
            byte[] content = Files.readAllBytes(file);
            byte[] searchByteFor = partOfContent.getBytes();

            for (int i = 0; i < content.length; i++) {
                try {
                    if (content[i] == searchByteFor[0] && i + searchByteFor.length < content.length) {
                        for (int j = 0; j < searchByteFor.length; j++) {
                            if (content[i + j] != searchByteFor[j])
                                break;
                            if (j + 1 == searchByteFor.length)
                                result.add(file);
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("FULL SHIT AT: " + file.toString());
                    return FileVisitResult.CONTINUE;
                }
            }
        }

        if (minSize > 0) {
            if (file.toFile().length() > minSize)
                result.add(file);
        }
        if (maxSize > 0) {
            if (file.toFile().length() < maxSize)
                result.add(file);
        }
        return super.visitFile(file, attrs);
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
        Collections.addAll(foundFiles, result.toArray(new Path[]{}));
        return foundFiles;
    }
}
