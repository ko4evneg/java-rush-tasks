package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    Thread t;
    Thread.State currentState;

    public LoggingStateThread (Thread t) {
        this.t = t;
    }

    @Override
    public void run() {
        State state;
        State lastState = null;
        do {
            state = t.getState();
            if (state != lastState) {
                System.out.println(state);
                lastState = state;
            }
        } while (state != State.TERMINATED);
    }
}
