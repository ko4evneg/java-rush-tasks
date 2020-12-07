package com.javarush.task.task17.task1702;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Вместе быстрее? Ща проверим :)
*/

public class Solution {
    public static int threadCount = 10;
    public static int[] testArray = new int[1000];

    static {
        for (int i = 0; i < Solution.testArray.length; i++) {
            testArray[i] = i;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //1000 -> 1, expected String with decreasing array
        StringBuffer expectedResult = new StringBuffer();
        for (int i = 1000 - 1; i >= 0; i--) {
            expectedResult.append(i).append(" ");
        }
        //creating threads
        long ms = new Date().getTime();
        initThreads();
        System.out.println("Execution time: " + (new Date().getTime() - ms) + "ms");

        //1 -> 1000, String with increasing array
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < testArray.length; i++) {
            result.append(testArray[i]).append(" ");
        }
        System.out.println(result);
        //compare
        System.out.println((result.toString()).equals(expectedResult.toString()));
    }

    public static void initThreads() throws InterruptedException {
        List<Thread> threads = new ArrayList<Thread>(threadCount);
        for (int i = 0; i < threadCount; i++)
            threads.add(new SortThread());
        for (Thread thread : threads) thread.start();
        for (Thread thread : threads) thread.join();
    }

    public static class SortThread extends Thread {
        public void run() {
            //synchronized (testArray) {
                sort(testArray);
           //}
        }
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (i % 10 == 0) System.out.println(Thread.currentThread().getName() + ": " + i);
            for (int j = i + 1; j < array.length; j++) {
                if (Math.random() > 0.75) {
                    if (array[i] < array[j]) {
                        int k = array[i];
                        array[i] = array[j];
                        array[j] = k;
                    }
                }
                if (Math.random() > 0.95) {
                    try {
                        Thread.sleep(0,1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

