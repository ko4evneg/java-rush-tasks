package com.javarush.task.task05.task0520;

/* 
Создать класс прямоугольник (Rectangle)
*/


public class Rectangle {
    //напишите тут ваш код
    int top, left, width, height;

    public Rectangle(int top, int left, int width, int height) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }

    public Rectangle(int top, int left, int width) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = width;
    }
    public Rectangle(int top, int left) {
        this.top = top;
        this.left = left;
        this.width = 5;
        this.height = 5;
    }
    public Rectangle() {
        this.top = 0;
        this.left = 0;
        this.width = 5;
        this.height = 5;
    }
    public static void main(String[] args) {

    }
}
