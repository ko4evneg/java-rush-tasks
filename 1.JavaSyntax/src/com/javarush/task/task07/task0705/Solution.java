package com.javarush.task.task07.task0705;

/* 
Один большой массив и два маленьких
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[20];
        int[] nums1 = new int[10];
        int[] nums2 = new int[10];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            if (i < 10) {
                nums1[i] = nums[i];
            } else {
                nums2[i - 10] = nums[i];
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            System.out.println(nums2[i]);
        }
    }
}
