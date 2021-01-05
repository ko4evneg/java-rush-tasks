package com.javarush.task.task24.task2413;
import java.util.List;

public class Arkanoid {
    private int height;
    private int width;
    private Ball ball;
    private Stand stand;
    private List<Brick> bricks;
    static Arkanoid game;

    public Arkanoid (int width,int height) {
        this.height = height;
        this.width = width;
    }

    public static void main(String...args){
        game = new Arkanoid(20, 20);
        game.ball = new Ball(3,3,3);
    }

    public void run() {

    }
    public void move(){
        
    }
// Getters and setters
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Stand getStand() {
        return stand;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }

    public List<Brick> getBricks() {
        return bricks;
    }

    public void setBricks(List<Brick> bricks) {
        this.bricks = bricks;
    }

}
