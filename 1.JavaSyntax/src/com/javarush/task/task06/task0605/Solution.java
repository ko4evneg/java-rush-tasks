package com.javarush.task.task06.task0605;


/* 
Контролируем массу тела
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        double weight = Double.parseDouble(bis.readLine());
        double height = Double.parseDouble(bis.readLine());

        Body.calculateMassIndex(weight, height);
    }

    public static class Body {
        public static void calculateMassIndex(double weight, double height) {
            double index;
            index = weight / (height * height);
            if (index < 18.5)
                System.out.println("Недовес: меньше чем 18.5");
            else if (index < 25)
                System.out.println("Нормальный: между 18.5 и 25");
            else if (index < 30)
                System.out.println("Избыточный вес: между 25 и 30");
            else
                System.out.println("Ожирение: 30 или больше");

            // . Метод calculateMassIndex должен выводить "Недовес: меньше чем 18.5" на экран, если индекс массы тела меньше 18.5 (не включая).
            //3. Метод calculateMassIndex должен выводить "Нормальный: между 18.5 и 25" на экран, если индекс массы тела между 18.5 и 25 (не включая).
            //4. Метод calculateMassIndex должен выводить "Избыточный вес: между 25 и 30" на экран, если индекс массы тела между 25 и 30 (не включая).
            //5. Метод calculateMassIndex должен выводить "Ожирение: 30 или больше" на экран, если индекс массы тела 30 или больше.
        }
    }
}
