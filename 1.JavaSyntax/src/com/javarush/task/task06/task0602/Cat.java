package com.javarush.task.task06.task0602;

/* 
Пустые кошки, пустые псы
*/

public class Cat {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat = null;
    }

    //напишите тут ваш код
    protected void finalize() throws Throwable {
        System.out.println("A Cat was destroyed");
    }
}

class Dog {
    protected void finalize() throws Throwable {
        System.out.println("A Dog was destroyed");
    }
}
