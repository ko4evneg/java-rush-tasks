package com.javarush.task.task08.task0824;

/* 
Собираем семейство
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Выведи все объекты Human на экран (Подсказка: используй метод toString() класса Human).


Требования:
1. Программа должна выводить текст на экран.
4. Класс Solution должен содержать один метод.
5. Программа должна создавать объекты и заполнять их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей и выводить все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Human gDad1 = new Human("gDadOne", true, 91);
        Human gMom1 = new Human("gMomOne", false, 87);
        Human gDad2 = new Human("gDadTwo", true, 84);
        Human gMom2 = new Human("gMomTwo", false, 82);
        Human Dad = new Human("Dad", true, 52);
        Human Mom = new Human("Mom", false, 49);
        Human Tom = new Human("Tom", true, 14);
        Human Peter = new Human("Peter", true, 16);
        Human Soya = new Human("Soya", false, 22);

        gDad1.children.add(Dad);
        gMom1.children.add(Dad);
        gDad2.children.add(Mom);
        gMom2.children.add(Mom);
        Mom.children.add(Tom);
        Mom.children.add(Peter);
        Mom.children.add(Soya);
        Dad.children.add(Tom);
        Dad.children.add(Peter);
        Dad.children.add(Soya);
        System.out.println(gDad1);
        System.out.println(gDad2);
        System.out.println(gMom1);
        System.out.println(gMom2);
        System.out.println(Mom);
        System.out.println(Dad);
        System.out.println(Tom);
        System.out.println(Peter);
        System.out.println(Soya);


    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();
        //напишите тут ваш код
        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, ArrayList<Human> rels) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
