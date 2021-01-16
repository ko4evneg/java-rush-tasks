package com.javarush.task.task31.task3110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Class for managing console input and output
public class ConsoleHelper {
    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString(){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return reader.readLine();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return "";
    }

    public static int readInt(){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return Integer.parseInt(reader.readLine());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return -1;
    }
}
