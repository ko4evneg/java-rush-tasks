package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/

public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        int arrWidth = a[0].length;
        int arrHeight = a.length;
        for (int j = 0; j < arrHeight; j++) {
            for (int i = 0; i < arrWidth; i++) {
                int boxWidth = 0;
                boolean isFound = false;
                int startInRow = 0;

                //Check for the corner of rectangle and measuring width
                while (a[j][i] == 1) {
                    if (!isFound) {
                        isFound = true;
                        count++;
                        startInRow = i;
                    }
                    a[j][i] = 0;
                    if (i + 1 < arrWidth)
                        i++;
                    boxWidth++;
                }
                //Zeroing next raws, when find rectangle
                if (isFound) {
                    i--;
                    int j2 = j;
                    while (j2 + 1 < arrHeight && a[++j2][startInRow] == 1) {
                        for (int k = startInRow; k < startInRow + boxWidth; k++) {
                            a[j2][k] = 0;
                        }
                    }
                }
            }
        }
        return count;
    }
}
