package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> nums = new ArrayList<Integer>();
        ArrayList<Integer> mod3 = new ArrayList<Integer>();
        ArrayList<Integer> mod2 = new ArrayList<Integer>();
        ArrayList<Integer> leftNums = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            int readNum = Integer.parseInt(br.readLine());
            nums.add(readNum);
            if (readNum % 3 == 0) mod3.add(readNum);
            if (readNum % 2 == 0) mod2.add(readNum);
            if (!(readNum % 3 == 0 || readNum % 2 == 0)) leftNums.add(readNum);
        }
        //System.out.println("MOD3");
        printList(mod3);
        //System.out.println("MOD2");
        printList(mod2);
        //System.out.println("MODREST");
        printList(leftNums);
    }

    public static void printList(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
