package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //private String relation;
        //relation = "дедушка";

        Cat gDad = new Cat(reader.readLine());
        Cat gMom = new Cat(reader.readLine());
        Cat Dad = new Cat(reader.readLine(), null , gDad);
        Cat Mom = new Cat(reader.readLine(), gMom,null );
        Cat son = new Cat(reader.readLine(), Mom, Dad);
        Cat daughter = new Cat(reader.readLine(), Mom, Dad);
        System.out.println(gDad);
        System.out.println(gMom);
        System.out.println(Dad);
        System.out.println(Mom);
        System.out.println(son);
        System.out.println(daughter);
    }

    public static class Cat {
        private String name;
        private Cat mParent;
        private Cat dParent;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat mParent, Cat dParent) {
            this.name = name;
            this.mParent = mParent;
            this.dParent = dParent;
        }

        @Override
        public String toString() {
            String output = "The cat's name is " + name;
            output += (mParent == null) ? ", no mother" : ", mother is " + mParent.name;
            output += (dParent == null) ? ", no father" : ", father is " + dParent.name;
            return output;
        }

    }
}

