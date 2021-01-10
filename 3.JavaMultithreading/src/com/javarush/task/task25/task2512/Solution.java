package com.javarush.task.task25.task2512;

import java.util.LinkedList;
import java.util.List;

/* 
Живем своим умом
*/

public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        String s = getErrCause(e).toString();
        System.out.println(s);
    }

    private StringBuilder getErrCause(Throwable e){
        StringBuilder err = new StringBuilder();
        if (e.getCause() != null)
            err.insert(0, getErrCause(e.getCause()));
        else
            return new StringBuilder(e.toString());
        return err.append("\n" + e);
    }


    public static void main(String[] args) {
        new Solution().uncaughtException(Thread.currentThread(),new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}
