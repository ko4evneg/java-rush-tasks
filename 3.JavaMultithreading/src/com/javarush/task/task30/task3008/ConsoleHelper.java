package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String string = null;
        try {
            string = reader.readLine();
            return string;
        } catch (IOException ioException) {
            System.out.print("\nПроизошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            return readString();
        }
    }

    public static int readInt() {
        int num = 0;
        try {
            num = Integer.parseInt(readString());
        } catch (NumberFormatException e) {
            writeMessage("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            num = Integer.parseInt(readString());
        }
        return num;
    }
}
