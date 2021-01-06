package com.javarush.task.task20.task2017;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.chrono.IsoEra;

/* 
Десериализация
*/
public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) {
        A obj = null;
        try {
            obj = (A) objectStream.readObject();
            return obj;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {

    }
}
