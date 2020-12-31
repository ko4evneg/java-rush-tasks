package com.javarush.task.task23.task2312;

import java.util.*;

public class Snake {
    private List<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

    public Snake(int x, int y) {
        sections = new ArrayList<>();
        sections.add(new SnakeSection(x, y));
        isAlive = true;
    }

    public List<SnakeSection> getSections() {
        return sections;
    }

    public void move() {
        if (!isAlive)
            return;
        switch (direction) {
            case UP:
                move(0, -1);
                break;
            case DOWN:
                move(0, 1);
                break;
            case RIGHT:
                move(1, 0);
                break;
            case LEFT:
                move(-1, 0);
                break;
        }
    }

    public void move(int dx, int dy) {
        SnakeSection newSection = new SnakeSection(dx + getX(), dy + getY());
        checkBorders(newSection);
        checkBody(newSection);
        if (isAlive) {
            sections.add(0, newSection);

            if (this.getX() == Room.game.getMouse().getX() && this.getY() == Room.game.getMouse().getY())
                Room.game.eatMouse();
            else
                sections.remove(sections.size() - 1);
        }
    }

    public void checkBody(SnakeSection head) {
        if (sections.contains(head))
            isAlive = false;
    }

    public void checkBorders(SnakeSection head) {
        if (head.getX() >= Room.game.getWidth() || head.getY() >= Room.game.getHeight() || head.getX() < 0 || head.getY() < 0)
            isAlive = false;
    }

    public int getX() {
        return sections.get(0).getX();
    }

    public int getY() {
        return sections.get(0).getY();
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }
}
