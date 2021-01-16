package com.javarush.task.task31.task3110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

//Main class
public class Archiver {
    public static void main(String[] args) throws Exception {
        Path zipFilePath = null;
        Path sourceFilePath = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            zipFilePath = Paths.get(reader.readLine());
            sourceFilePath = Paths.get(reader.readLine());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        ZipFileManager zipFileManager = new ZipFileManager(zipFilePath);
        zipFileManager.createZip(sourceFilePath);
    }
}
