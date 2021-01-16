package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;
import com.javarush.task.task31.task3110.exception.WrongZipFileException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

//Main class
public class Archiver {
    public static void main(String[] args) throws Exception {
        Path zipFilePath = Paths.get("D:\\temp_java\\tmp.zip");
        Path sourceFilePath = Paths.get("D:\\temp_java\\tag.html");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            //zipFilePath = Paths.get(reader.readLine());
            //sourceFilePath = Paths.get(reader.readLine());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        ZipFileManager zipFileManager = new ZipFileManager(zipFilePath);
        zipFileManager.createZip(sourceFilePath);

        Operation operation;
        while (true) {
            try {
                operation = askOperation();
                if (operation == Operation.EXIT) {
                    new ExitCommand().execute();
                    break;
                }
                CommandExecutor.execute(operation);
            } catch (WrongZipFileException e) {
                ConsoleHelper.writeMessage("Вы не выбрали файл архива или выбрали неверный файл.");
            } catch (Exception e) {
                ConsoleHelper.writeMessage("Произошла ошибка. Проверьте введенные данные.");
            }
        }

    }

    //Method for requesting needed operation
    public static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage("Select operation type:");
        for (Operation operation : Operation.values()) {
            ConsoleHelper.writeMessage(operation.ordinal() + " - " + operation.name());
        }
        return Operation.values()[ConsoleHelper.readInt()];
    }
}
