package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;
import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

//Archiving to archive
public class ZipCreateCommand extends ZipCommand{

    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Создание архива.");
            ZipFileManager zipFileManager = getZipFileManager();
            String toArchive = ConsoleHelper.readString();
            Path toArchivePath = Paths.get(toArchive);
            zipFileManager.createZip(toArchivePath);
            ConsoleHelper.writeMessage("Архив создан.");
        } catch (PathIsNotFoundException p) {
            ConsoleHelper.writeMessage("Вы неверно указали имя файла или директории.");
        }
    }
}
