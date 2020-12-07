package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    String name, address, color;
    int age, weight;
//7. У класса должен быть метод initialize, принимающий в качестве параметра имя, но инициализирующий все переменные класса, кроме адреса.
    public void initialize(String name){
        this.name = name;
        this.color = "red";
        this.age = 5;
        this.weight = 4;
    }
//8. У класса должен быть метод initialize, принимающий в качестве параметров имя, вес, возраст и инициализирующий все переменные класса, кроме адреса.

    public void initialize(String name, int weight, int age){
        this.name = name;
        this.color = "red";
        this.age = age;
        this.weight = weight;
    }
//9. У класса должен быть метод initialize, принимающий в качестве параметров имя, возраст и инициализирующий все переменные класса, кроме адреса.
    public void initialize(String name,int age){
    this.name = name;
    this.color = "red";
    this.age = age;
    this.weight = 5;
}
//            10. У класса должен быть метод initialize, принимающий в качестве параметров вес, цвет и инициализирующий все переменные класса, кроме имени и адреса.

    public void initialize(int weight,String color){
        //this.name = "Catz";
        this.color = color;
        this.age = 4;
        this.weight = weight;
    }
//            11. У класса должен быть метод initialize, принимающий в качестве параметров вес, цвет, адрес и инициализирующий все переменные класса, кроме имени.
public void initialize(int weight,String color,String address){
    //this.name = "Catz";
    this.color = color;
    this.age = 7;
    this.weight = weight;
    this.address = address;
}
    public static void main(String[] args) {

    }
}
