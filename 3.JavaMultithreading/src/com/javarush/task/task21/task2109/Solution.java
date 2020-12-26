package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/

public class Solution {

    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        protected A clone() throws CloneNotSupportedException {
            return new A(i, j);
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected B clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException("NO CLONE!!");
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected C clone() throws CloneNotSupportedException {
            return new C(getI(), getJ(), getName());
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        A a = new A(2, 3);
        B b = new B(4,5, "nama");
        C c = new C(4,5, "nama");
        A a1 = a.clone();
        //B b1 = b.clone();
        C c1 = c.clone();

    }
}
