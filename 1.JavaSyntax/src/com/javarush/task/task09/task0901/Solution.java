package com.javarush.task.task09.task0901;

/* 
Возвращаем StackTrace
*/

public class Solution {
    public static void main(String[] args) {
        method1();
        StackTraceElement[] str = Thread.currentThread().getStackTrace();
    }

    public static StackTraceElement[] method1() {
        method2();
        StackTraceElement[] str = Thread.currentThread().getStackTrace();
        return str;
    }

    public static StackTraceElement[] method2() {
        method3();
        StackTraceElement[] str = Thread.currentThread().getStackTrace();
        return str;
    }

    public static StackTraceElement[] method3() {
        method4();
        StackTraceElement[] str = Thread.currentThread().getStackTrace();
        return str;
    }

    public static StackTraceElement[] method4() {
        method5();
        StackTraceElement[] str = Thread.currentThread().getStackTrace();
        return str;
    }

    public static StackTraceElement[] method5() {
        StackTraceElement[] str = Thread.currentThread().getStackTrace();
        return str;
    }
}
