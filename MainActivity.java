package com.example.runningcrew;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private GameController gameController;
    private TextView scoreTextView;
    private View playerView;
    private Button startButton, upButton, downButton, leftButton, rightButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GameModel gameModel = new GameModel();
        gameController = new GameController(gameModel, this);

        scoreTextView = findViewById(R.id.score_text);
        playerView = findViewById(R.id.player_view);
        startButton = findViewById(R.id.start_button);
        upButton = findViewById(R.id.up_button);
        downButton = findViewById(R.id.down_button);
        leftButton = findViewById(R.id.left_button);
        rightButton = findViewById(R.id.right_button);

        startButton.setOnClickListener(v -> gameController.startGame());
        upButton.setOnClickListener(v -> gameController.movePlayer(0, -10));
        downButton.setOnClickListener(v -> gameController.movePlayer(0, 10));
        leftButton.setOnClickListener(v -> gameController.movePlayer(-10, 0));
        rightButton.setOnClickListener(v -> gameController.movePlayer(10, 0));

        updateState(gameModel.getCurrentState());
    }

    public void updateState(GameState state) {
        switch (state) {
            case READY:
                scoreTextView.setText("Press Start to Begin");
                startButton.setVisibility(View.VISIBLE);
                enableControls(false);  // 이동 버튼 비활성화
                break;

            case RUNNING:
                scoreTextView.setText("Score: " + gameController.getModel().getScore());
                startButton.setVisibility(View.GONE);
                enableControls(true);  // 이동 버튼 활성화
                break;

            case GAME_OVER:
                scoreTextView.setText("Game Over! Final Score: " + gameController.getModel().getScore());
                startButton.setVisibility(View.VISIBLE);
                enableControls(false);  // 이동 버튼 비활성화
                break;
        }
    }

    public void enableControls(boolean enable) {
        upButton.setEnabled(enable);
        downButton.setEnabled(enable);
        leftButton.setEnabled(enable);
        rightButton.setEnabled(enable);
    }

    public void updatePlayerPosition(int x, int y) {
        playerView.setX(x);
        playerView.setY(y);
    }

    public void updateScore(int score) {
        scoreTextView.setText("Score: " + score);
    }

    public void showGameOver() {
        scoreTextView.setText("Game Over! Final Score: " + gameController.getModel().getScore());
    }
}
