package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/

import java.util.Date;
import java.util.Set;

public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            System.out.println("obj1 lock");
            synchronized (obj2) {
                System.out.println("obj2 lock");
            }
        }
        System.out.println("objs unlock");
    }

    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2) throws Exception {
        boolean isCorrect = true;
        new Thread() {
            @Override
            public void run() {
                synchronized (o2) {
                    try {
                        System.out.println("o2 lock");
                        Thread.sleep(150);
                        System.out.println("o2 unlock");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // If the order is wrong, someMethodWithSynchronizedBlocks will wait till o1 lock below finished.
                // If the order is right, this lock ignored.
                synchronized (o1) {
                    try {
                        System.out.println("o1 lock");
                        Thread.sleep(300);
                        System.out.println("o1 unlock");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                System.out.println("started method");
                solution.someMethodWithSynchronizedBlocks(o1, o2);
                System.out.println("method finished");
            }
        }.start();

        Thread.sleep(300);
            Set<Thread> threads = Thread.getAllStackTraces().keySet();
            for (Thread t : threads) {
                if (t.getName().startsWith("Thread") && t.getState() == Thread.State.BLOCKED)
                    isCorrect = false;
            }
        return isCorrect;
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));
    }
}
