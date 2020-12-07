package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
//1. Создай 5 различных своих нитей c отличным от Thread типом:
//1.1. Нить 1 должна бесконечно выполняться;
//1.2. Нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
//1.3. Нить 3 должна каждые полсекунды выводить "Ура";
//1.4. Нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
//1.5. Нить 5 должна читать с консоли числа пока не введено слово "N", а потом вывести в консоль сумму введенных чисел.
//2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
//3. Нити не должны стартовать автоматически.
//Подсказка:
//Нить 4 можно проверить методом isAlive()


public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        for (int i = 0; i < 5; i++) {

            if (i == 3)
                threads.add(new Y());
            else
                threads.add(new X(i));
        }

    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            threads.get(i).start();
        }
    }
    public static class Y extends Thread implements Message {
        @Override
        public void showWarning() {
            this.interrupt();
        }

        public void run () {
            while(!isInterrupted()) {
            }
        }
    }

    public static class X extends Thread {
        private int n;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int num;
        int sum = 0;

        public X(int n) {
            this.n = n;
        }

        @Override
        public void run() {
            switch (n) {
                case 0:
                    for (; ; ) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                        }
                    }
                case 1:
                    try {
                        while (true)
                            Thread.sleep(10);
                    } catch (InterruptedException e) {
                        System.out.println("InterruptedException");
                    }
                    break;
                case 2:
                    while (true) {
                        System.out.println("Ура");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                        }
                    }
                case 4:
                    do {
                        try {
                            s = reader.readLine();
                            num = Integer.parseInt(s);
                            sum += num;
                        } catch (Exception e) {
                            if (s.equals("N"))
                                System.out.println(sum);
                            break;
                        }
                    } while (true);
            }
        }

    }


}
