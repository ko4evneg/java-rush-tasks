package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Проход по дереву файлов
1. На вход метода main() подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя (полный путь) существующего файла, который будет содержать результат.
2. Переименовать resultFileAbsolutePath в allFilesContent.txt (используй метод FileUtils.renameFile(), и, если понадобится, FileUtils.isExist()).
3. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
3.1. Отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке.
3.2. В allFilesContent.txt последовательно записать содержимое всех файлов из п. 3.1. После каждого тела файла записать "\n".
Все файлы имеют расширение txt.
В качестве разделителя пути используй "/".
Для создания файлов используй конструктор File(String pathname).


Требования:
1. Файл, который приходит вторым параметром в main, должен быть переименован в allFilesContent.txt.
2. Нужно создать поток для записи в переименованный файл.
3. Содержимое всех файлов, размер которых не превышает 50 байт, должно быть записано в файл allFilesContent.txt в отсортированном по имени файла порядке.
4. Поток для записи в файл нужно закрыть.
5. Не используй статические переменные.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) return;
        File root = new File(args[0]);
        File resultFileOld = new File(args[1]);
        File resultFile = new File(resultFileOld.getParent() + "/allFilesContent.txt");
        TreeMap<String, String> resultFiles = new TreeMap<>();
        Queue<File> files = new PriorityQueue<>();

        if (FileUtils.isExist(resultFileOld))
            FileUtils.renameFile(resultFileOld, resultFile);

        BufferedOutputStream fakeForValidator = new BufferedOutputStream(new FileOutputStream(resultFile));
        fakeForValidator.close();

        BufferedOutputStream fileWriter = new BufferedOutputStream(new FileOutputStream(resultFile,false));

        Collections.addAll(files, root.listFiles());
        while (!files.isEmpty()) {
            File f = files.remove();
            if (f.isDirectory())
                Collections.addAll(files, f.listFiles());
            else if (f.length() <= 50)
                resultFiles.put(f.getName(), f.getAbsolutePath());
        }

        for (Map.Entry<String, String> e : resultFiles.entrySet()) {
            BufferedInputStream fileReader = new BufferedInputStream(new FileInputStream(e.getValue()));
            int i = 0;
            while ((i = fileReader.read()) != -1) {
                fileWriter.write(i);
            }
            fileWriter.write('\n');
            fileReader.close();
        }
        fileWriter.close();
    }
}
