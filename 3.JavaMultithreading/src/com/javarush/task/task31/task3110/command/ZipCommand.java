package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

//Commands for working with zip archive (non-supplement)
public abstract class ZipCommand implements Command {
    public ZipFileManager getZipFileManager() throws Exception {
        String zipFileName = ConsoleHelper.readString();
        Path zipFilePath = Paths.get(zipFileName);
        ZipFileManager zipFileManager = new ZipFileManager(zipFilePath);
        return zipFileManager;
    }
}
