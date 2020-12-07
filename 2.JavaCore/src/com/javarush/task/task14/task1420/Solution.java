package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = new String[2];
        str[0] = reader.readLine();
        int i, j;
        try {
            i = Integer.parseInt(str[0]);
            if (i <= 0)
                throw new Exception("Suka");
        } catch (Exception e) {
            throw e;
        }
        str[1] = reader.readLine();
        try {
            j = Integer.parseInt(str[1]);
            if (j <= 0)
                throw new Exception("Suka");
        } catch (Exception e) {
            throw e;
        }

        int max = i > j ? i : j;
        int maxDiv = Integer.MIN_VALUE;
        for (int k = 1; k <= max; k++) {
            if (i % k == 0 && j % k == 0)
                maxDiv = k;
        }
        System.out.println(maxDiv);

    }
}
