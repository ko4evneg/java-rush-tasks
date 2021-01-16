package com.javarush.task.task31.task3110;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

//Class for performing operations upon an archive.
public class ZipFileManager {
    //Archive absolute path
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    //Archives source
    public void createZip(Path source) throws Exception {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile))) {
            String sourceFileName = source.getFileName().toString();
            ZipEntry zipEntry = new ZipEntry(sourceFileName);
            zipOutputStream.putNextEntry(zipEntry);
            try (BufferedInputStream fileBIS = new BufferedInputStream(Files.newInputStream(source))) {
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                while ((bytesRead = fileBIS.read(buffer)) != -1) {
                    zipOutputStream.write(buffer, 0, bytesRead);
                }
            }
            zipOutputStream.closeEntry();
        }
    }
/*
4. Перепиши данные из файла, который архивируем в поток архива. Для этого:
4.1. Создай поток InputStream для добавляемого файла source, используя метод newInputStream класса Files
4.2. Сделай цикл, который будет читать данные из InputStream (созданного в п.4.1), пока они там есть и записывать их в ZipOutputStream (созданный в п.1)
4.3. Закрой InputStream, сделай это с помощью try-with-resources
5. Закрой элемент архива у потока архива
6. Закрой поток архива, сделай это также с помощью try-with-resources
7. Запусти программу и проверь, что файл архивируется


Требования:
1. Метод createZip должен создавать ZipOutputStream используя поле zipFile и метод Files.newOutputStream.
2. Метод createZip должен создавать элемент архива ZipEntry c именем файла, полученным из параметра source.
3. Созданный ZipEntry нужно добавить в ZipOutputStream.
4. Для переменной source должен быть создан InputStream с помощью метода Files.newInputStream.
5. Данные из InputStream нужно переписать в ZipOutputStream.
6. Закрой текущий Entry у объекта ZipOutputStream.
7. InputStream для source должен быть закрыт.
8. ZipOutputStream должен быть закрыт.*/
}
