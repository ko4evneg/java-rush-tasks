package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;
        String[] keys = new String[]{"user", "", "", ""};

        //тут цикл по чтению ключей, пункт 1
        while (true) {
            String input = reader.readLine();

            if (input.equals("user")) {
                person = new Person.User();
            } else if (input.equals("loser")) {
                person = new Person.Loser();
            } else if (input.equals("coder")) {
                person = new Person.Coder();
            } else if (input.equals("proger")) {
                person = new Person.Proger();
            } else
                break;
            doWork(person);
        }

        reader.close();
    }

    public static void doWork(Person person) {
        if (person instanceof Person.User)
            ((Person.User) person).live();
        if (person instanceof Person.Loser)
            ((Person.Loser) person).doNothing();
        if (person instanceof Person.Coder)
            ((Person.Coder) person).writeCode();
        if (person instanceof Person.Proger)
            ((Person.Proger) person).enjoy();
        // пункт 33.1. Вызывает метод live() у переданного объекта, если этот объект (person) имеет тип User.
        //3.2. Вызывает метод doNothing(), если person имеет тип Loser.
        //3.3. Вызывает метод writeCode(), если person имеет тип Coder.
        //3.4. Вызывает метод enjoy(), если person имеет тип Proger.
    }
}
