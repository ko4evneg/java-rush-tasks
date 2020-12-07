package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 Вызвать метод flush().
2.2 Дописать следующий текст "JavaRush © All rights reserved.", используй метод getBytes().
2.3 Закрыть поток методом close().


*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream orig;

    public AmigoOutputStream (FileOutputStream fos) throws FileNotFoundException {
        super(fileName);
        orig = fos;
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    @Override
    public void close() throws IOException {
        flush();
        write("JavaRush © All rights reserved.".getBytes());
        orig.close();
    }

    @Override
    public void write(int b) throws IOException {
        orig.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        orig.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        orig.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        orig.flush();
    }
}
