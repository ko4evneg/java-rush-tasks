package com.javarush.task.task03.task0307;

/* 
Привет StarCraft!
*/

public class Solution {
    public static void main(String[] args) {
        long num = 1;
        for (int i = 1; i <= 10; i++) {
            num *= i;
        }
        System.out.println(num);
    }
       /* Zerg[] zerg = new Zerg[5];
        for (int i = 0; i < 5; i++) {
            zerg[i] = new Zerg();
            zerg[i].name = "zorge " + i;
        }
        Protoss[] prot = new Protoss[3]{prot.name = "shprot", this.name = "shprott", this.name = "shprottt",};
        //for (int i = 0; i < 3; i++) {
       //     prot[i] = new Protoss();
       //     prot[i].name = "shprott " + i;
       // }
        Terran[] tr = new Terran[4];
        for (int i = 0; i < 4; i++) {
            tr[i] = new Terran();
            tr[i].name = "tir " + i;
        }
    }*/

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}