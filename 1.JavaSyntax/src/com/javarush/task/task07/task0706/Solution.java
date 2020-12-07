package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[15];
        int oddCount = 0;
        int evenCount = 0;

        for (int i = 0; i < 15; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                evenCount += nums[i];
            } else {
                oddCount += nums[i];
            }
        }

        if (evenCount > oddCount) {
            System.out.println("В домах с четными номерами проживает больше жителей.");
        } else
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
    }
}
