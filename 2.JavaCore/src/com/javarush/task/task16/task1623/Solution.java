package com.javarush.task.task16.task1623;

/* 
Рекурсивное создание нитей

3. Переопредели метод toString, для этого внутри GenerateThread нажми Alt+Insert -> Override Methods. Начни печатать toString.
3.1. Метод toString должен возвращать № текущей нити и слово " created". Используй getName().
4. Пока количество созданных нитей меньше Solution.count метод run должен:
4.1. Создать новую нить типа GenerateThread.
4.2. Вывести в консоль созданную в пункте 4.1 нить.
5. В итоге должно быть выведено в консоль 15 строк.


*/


public class Solution {
    static int count = 15;
    static volatile int createdThreadCount = 0;

    public static void main(String[] args) {
        System.out.println(new GenerateThread());
    }

    public static class GenerateThread extends Thread {
        public GenerateThread() {
            super(Integer.toString(++createdThreadCount));
            start();
        }

        @Override
        public String toString() {
            return getName() + " created";
        }

        public void run() {
            if (createdThreadCount < count) {
                System.out.println(new GenerateThread());
            }
        }
    }
}
