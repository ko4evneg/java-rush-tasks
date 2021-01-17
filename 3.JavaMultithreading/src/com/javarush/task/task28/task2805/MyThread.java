package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    private static AtomicInteger currentPriority = new AtomicInteger(Thread.MIN_PRIORITY);
    public MyThread() {
        super();
        setCurrentPriority();
    }

    public MyThread(Runnable target) {
        super(target);
        setCurrentPriority();
    }

    public MyThread(String name) {
        super(name);
        setCurrentPriority();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setCurrentPriority();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        setCurrentPriorityNoMoreThanInGroup(group.getMaxPriority());
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        setCurrentPriorityNoMoreThanInGroup(group.getMaxPriority());
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        setCurrentPriorityNoMoreThanInGroup(group.getMaxPriority());
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        setCurrentPriorityNoMoreThanInGroup(group.getMaxPriority());
    }

    private void setCurrentPriority (){
        if (currentPriority.get() < MAX_PRIORITY)
            setPriority(currentPriority.getAndIncrement());
        else {
            setPriority(currentPriority.get());
            currentPriority.set(MIN_PRIORITY);
        }
    }

    private void setCurrentPriorityNoMoreThanInGroup (int threadGroupPriority){
        if (currentPriority.get() < MAX_PRIORITY && currentPriority.get() <= threadGroupPriority)
            setPriority(currentPriority.getAndIncrement());
        else if (currentPriority.get() < MAX_PRIORITY && currentPriority.get() > threadGroupPriority) {
            setPriority(threadGroupPriority);
            currentPriority.set(currentPriority.get() + 1);
        }
        else{
            setPriority(currentPriority.get());
            currentPriority.set(MIN_PRIORITY);
        }
    }
}
