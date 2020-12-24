package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/

public class Solution {
    public static void main(String[] args) {
        new Solution().recurse(1);
    }

    public void recurse(int n) {
        if (n < 2) return;

        int i = 2;
        while (n % i != 0) {
            i++;
        }

        System.out.println(i);
        if (i < n)
            recurse(n / i);
    }
}


