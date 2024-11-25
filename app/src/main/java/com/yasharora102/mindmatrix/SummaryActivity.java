    package com.yasharora102.mindmatrix;
    
    import android.content.Intent;
    import android.os.Bundle;
    import android.widget.Button;
    import android.widget.TextView;
    import androidx.appcompat.app.AppCompatActivity;
    
    public class SummaryActivity extends AppCompatActivity {
        TextView scoreView;
        Button restartButton;
        Button exitButton;
    
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_summary);
    
            scoreView = findViewById(R.id.score_view);
            restartButton = findViewById(R.id.play_again_button);
            exitButton = findViewById(R.id.exit_button);
    
            int score = getIntent().getIntExtra("score", 0);
            scoreView.setText("Your Score: " + score);
    
            restartButton.setOnClickListener(v -> {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();  // Close summary screen
            });
    
            exitButton.setOnClickListener(v -> {
                finishAffinity();  // Close all activities
            });
    
        }
    }
