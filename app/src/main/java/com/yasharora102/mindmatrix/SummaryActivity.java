package com.yasharora102.mindmatrix;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    private TextView scoreView;
    private Button playAgainButton, exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        scoreView = findViewById(R.id.score_view);
        playAgainButton = findViewById(R.id.play_again_button);
        exitButton = findViewById(R.id.exit_button);

        // Get the score from the Intent
        int score = getIntent().getIntExtra("score", 0);
        scoreView.setText("Your Score: " + score);

        // Set up the Play Again button to restart the quiz
        playAgainButton.setOnClickListener(v -> {
            Intent intent = new Intent(SummaryActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();  // Close the summary activity
        });

        // Set up the Exit button to close the app
        exitButton.setOnClickListener(v -> {
            finishAffinity();  // Close all activities and exit the app
        });
    }
}
