package com.example.runningcrew;


public class GameModel {
    private int playerX, playerY;
    private int score;
    private GameState currentState;

    public GameModel() {
        playerX = 0;
        playerY = 0;
        score = 0;
        currentState = GameState.READY;  // 초기 상태는 READY
    }

    public void startGame() {
        if (currentState == GameState.READY) {
            currentState = GameState.RUNNING;
            score = 0;
            playerX = 0;
            playerY = 0;
        }
    }

    public void movePlayer(int dx, int dy) {
        if (currentState == GameState.RUNNING) {
            playerX += dx;
            playerY += dy;
        }
    }

    public void increaseScore(int points) {
        if (currentState == GameState.RUNNING) {
            score += points;
        }
    }

    public void gameOver() {
        if (currentState == GameState.RUNNING) {
            currentState = GameState.GAME_OVER;
        }
    }

    public GameState getCurrentState() { return currentState; }
    public int getPlayerX() { return playerX; }
    public int getPlayerY() { return playerY; }
    public int getScore() { return score; }
}
