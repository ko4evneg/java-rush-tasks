package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private int countFlags = 0;
    private int score = 0;
    private int countClosedTiles = SIDE * SIDE;
    private boolean isGameStopped;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(10) < 1;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.ORANGE);
                setCellValue(x, y, "");
            }
        }
        countMineNeighbors();
        countFlags = countMinesOnField;
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.RED, "la finish!", Color.GREEN, 30);

    }

    private void win() {
        showMessageDialog(Color.RED, "la WINNAR!", Color.GREEN, 30);
        isGameStopped = true;
    }

    private void markTile(int x, int y) {
        if (gameField[y][x].isOpen || countFlags == 0)
            return;
        if (gameField[y][x].isFlag) {
            gameField[y][x].isFlag = false;
            setCellValue(x, y, "");
            setCellColor(x, y, Color.ORANGE);
            countFlags++;
        } else {
            gameField[y][x].isFlag = true;
            setCellValue(x, y, FLAG);
            setCellColor(x, y, Color.YELLOW);
            countFlags--;
        }

    }

    private void openTile(int x, int y) {
        if (isGameStopped || gameField[y][x].isFlag || gameField[y][x].isOpen)
            return;
        gameField[y][x].isOpen = true;
        countClosedTiles--;
        if (countMinesOnField == countClosedTiles && !gameField[y][x].isMine)
            win();
        setCellColor(x, y, Color.GREEN);
        if (gameField[y][x].isMine) {
            setCellValue(x, y, MINE);
            setCellValueEx(x, y, Color.RED, MINE);
            gameOver();
        } else {
            if (gameField[y][x].countMineNeighbors == 0) {
                setCellValue(x, y, "");
                for (GameObject go : getNeighbors(gameField[y][x])) {
                    if (!go.isOpen)
                        openTile(go.x, go.y);
                }
            } else {
                setCellNumber(x, y, gameField[y][x].countMineNeighbors);
                setScore(score += 5);
            }
        }

    }

    private void restart() {
        isGameStopped = false;
        countClosedTiles = SIDE * SIDE;
        score = 0;
        countMinesOnField = 0;
        setScore(0);
        createGame();

    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        if (isGameStopped) {
            restart();
            return;
        }
        openTile(x, y);
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }

    private void countMineNeighbors() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                if (gameField[x][y].isMine != false)
                    continue;
                for (GameObject go : getNeighbors(gameField[x][y])) {
                    if (go.isMine)
                        gameField[x][y].countMineNeighbors++;
                }
            }
        }
    }


    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }
}