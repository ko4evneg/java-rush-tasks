package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;

    public Hippodrome (List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) {
        Horse horse1 = new Horse("Lili", 3, 0);
        Horse horse2 = new Horse("Petra", 3, 0);
        Horse horse3 = new Horse("Gorr", 3, 0);
        game = new Hippodrome(new ArrayList<>(Arrays.asList(horse1, horse2,horse3)));
        game.run();
        game.printWinner();
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }

    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public void run() {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Horse getWinner() {
        double winnerDistance = 0;
        Horse winner = null;
        for (Horse horse : horses) {
            if (winnerDistance < horse.getDistance())
                winner = horse;
        }
        return winner;
    }
    public void printWinner() {
        System.out.printf("Winner is %s!\n", getWinner().getName());
    }


}


