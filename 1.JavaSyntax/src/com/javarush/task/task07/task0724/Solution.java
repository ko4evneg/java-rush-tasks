package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
//Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
//5. Создай 9 разных объектов типа Human (4 объекта без отца и матери и 5 объектов с ними)).
//6. Выведи созданные объекты на экран
        ArrayList<Human> men = new ArrayList<>();
        men.add(new Human("Петр",true,78));
        men.add(new Human("Наталья",false,72));
        men.add(new Human("Василий",true,78));
        men.add(new Human("Василиса",false,72));
        men.add(new Human("Мать",true,72,men.get(0),men.get(1)));
        men.add(new Human("Отец",false,72,men.get(2),men.get(3)));
        men.add(new Human("Сын",true,72,men.get(5),men.get(4)));
        men.add(new Human("Ссын",true,72,men.get(5),men.get(4)));
        men.add(new Human("Дочь",false,72,men.get(5),men.get(4)));
        for (Human human : men) {
            System.out.println(human);
        }

    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }
    }
}