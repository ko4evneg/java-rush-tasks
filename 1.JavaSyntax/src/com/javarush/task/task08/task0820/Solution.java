package com.javarush.task.task08.task0820;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Множество всех животных



Требования:
1. Программа должна выводить текст на экран.
2. Внутри класса Solution должны быть созданы public static классы Cat, Dog.
3. Метод createCats() класса Solution должен возвращать множество (Set) содержащее 4 кота.
4. Метод createDogs() класса Solution должен возвращать множество (Set) содержащее 3 собаки.
5. Метод join() класса Solution должен возвращать объединенное множество всех животных - всех котов и собак.
6. Метод removeCats() должен удалять из множества pets всех котов, которые есть в множестве cats.
7. Метод printPets() должен выводить на экран всех животных, которые в нем есть. Каждое животное с новой строки.
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        Set<Cat> result = new HashSet<Cat>();
        for (int i = 0; i < 4; i++) {
            result.add(new Cat());
        }
        return result;
    }

    public static Set<Dog> createDogs() {
        Set<Dog> result = new HashSet<Dog>();
        for (int i = 0; i < 3; i++) {
            result.add(new Dog());
        }
        return result;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        Set<Object> animals = new HashSet<>();
        animals.addAll(cats);
        animals.addAll(dogs);
        return animals;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        Iterator<Object> iterator = pets.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if (cats.contains(obj)) {
                iterator.remove();
            }
        }

    }

    public static void printPets(Set<Object> pets) {
        for (Object o :pets) {
            System.out.println(o);
        }

    }

    public static class Cat {

    }

    public static class Dog {

    }
    //напишите тут ваш код
}
