package com.example.runningcrew;

public class GameController {
    private GameModel gameModel;
    private MainActivity view;

    public GameController(GameModel gameModel, MainActivity view) {
        this.gameModel = gameModel;
        this.view = view;
    }

    // GameModel 객체를 반환하는 메서드 추가
    public GameModel getModel() {
        return gameModel;
    }

    public void startGame() {
        gameModel.startGame();
        view.updateState(gameModel.getCurrentState());
    }

    public void movePlayer(int dx, int dy) {
        gameModel.movePlayer(dx, dy);
        view.updatePlayerPosition(gameModel.getPlayerX(), gameModel.getPlayerY());
    }

    public void increaseScore(int points) {
        gameModel.increaseScore(points);
        view.updateScore(gameModel.getScore());
    }

    public void endGame() {
        gameModel.gameOver();
        view.updateState(gameModel.getCurrentState());
        view.showGameOver();
    }
}

