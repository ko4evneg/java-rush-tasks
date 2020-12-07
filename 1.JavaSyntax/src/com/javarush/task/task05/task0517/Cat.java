package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    //напишите тут ваш код
    String name, address, color;
    int age, weight;
//6. У класса должен быть конструктор, принимающий в качестве параметра имя, но инициализирующий все переменные класса, кроме адреса.
    public Cat (String name){
        this.name = name;
        this.color = "Gray";
        this.age = 5;
        this.weight = 5;
    }
//7. У класса должен быть конструктор, принимающий в качестве параметров имя, вес, возраст и инициализирующий все переменные класса, кроме адреса.
    public Cat (String name, int weight,int age){
    this.name = name;
    this.color = "Gray";
    this.age = age;
    this.weight = weight;
    //this.address = address;
    }
//8. У класса должен быть конструктор, принимающий в качестве параметров имя, возраст и инициализирующий все переменные класса, кроме адреса.
    public Cat (String name, int age){
        this.name = name;
        this.color = "Gray";
        this.age = age;
        this.weight = 6;
        //this.address = address;
    }
//9. У класса должен быть конструктор, принимающий в качестве параметров вес, цвет и инициализирующий все переменные класса, кроме имени и адреса.
    public Cat (int weight, String color){
        //this.name = "Oki";
        this.color = color;
        this.age = 6;
        this.weight = weight;
        //this.address = address;
    }
//10. У класса должен быть конструктор, принимающий в качестве параметров вес, цвет, адрес и инициализирующий все переменные класса, кроме имени.
    public Cat (int weight, String color, String address){
        //this.name = "Oki";
        this.color = color;
        this.age = 6;
        this.weight = weight;
        this.address = address;
    }
    public static void main(String[] args) {

    }
}
