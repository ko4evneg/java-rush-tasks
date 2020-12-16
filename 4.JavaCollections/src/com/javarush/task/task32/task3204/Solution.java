package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        Random rand = new Random();
        StringBuilder password = new StringBuilder();
        password.append((char) (rand.nextInt(25) + (int) 'a'));
        password.append((char) (rand.nextInt(25) + (int) 'A'));
        password.append((char) (rand.nextInt(9) + (int) '0'));
        for (int i = 3; i < 8; i++) {
            int nextLetter = rand.nextInt(62);
            password.append(nextLetter <= 25 ? (char) (nextLetter + (int) 'a') :
                    nextLetter <= 51 ? (char) (nextLetter - 26 + (int) 'A') : (char) (nextLetter - 52 + (int) '0'));
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            bos.write(password.toString().getBytes());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return bos;
    }
}
