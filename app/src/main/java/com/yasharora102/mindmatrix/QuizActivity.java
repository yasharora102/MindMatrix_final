package com.yasharora102.mindmatrix;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {
    TextView questionView, scoreView, timerView, loadingIndicator;
    Button optionA, optionB, optionC, optionD, nextButton;
    ProgressBar progressBar;
    int score = 0, currentQuestion = 0, category, difficulty;
    private boolean isQuizStarted = true;
    private final Handler handler = new Handler(); // Handler for UI updates

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        category = getIntent().getIntExtra("category", 0);
        difficulty = getIntent().getIntExtra("difficulty", 0);

        questionView = findViewById(R.id.question_view);
        scoreView = findViewById(R.id.score_view);
        timerView = findViewById(R.id.timer_view);
        loadingIndicator = findViewById(R.id.loading_indicator);
        progressBar = findViewById(R.id.progress_bar);

        optionA = findViewById(R.id.option_a);
        optionB = findViewById(R.id.option_b);
        optionC = findViewById(R.id.option_c);
        optionD = findViewById(R.id.option_d);
        nextButton = findViewById(R.id.next_button);

        optionA.setOnClickListener(v -> selectOption(0));
        optionB.setOnClickListener(v -> selectOption(1));
        optionC.setOnClickListener(v -> selectOption(2));
        optionD.setOnClickListener(v -> selectOption(3));
        nextButton.setOnClickListener(v -> skipQuestion());

        // Start loading the first question
        loadQuestionInBackground();

        // Start the quiz timer
        startTimer();
    }

    private void loadQuestionInBackground() {
        showLoading(true); // Show progress indicator
        new Thread(() -> {
            try {
                // Simulate a delay for loading (e.g., fetching from database)
                Thread.sleep(200);

                // Load question data
                String question = QuizData.questions[category][difficulty][currentQuestion];
                String[] options = QuizData.answers[category][difficulty][currentQuestion];

                // Update UI on the main thread
                handler.post(() -> {
                    questionView.setText(question);
                    optionA.setText(options[0]);
                    optionB.setText(options[1]);
                    optionC.setText(options[2]);
                    optionD.setText(options[3]);
                    scoreView.setText("Score: " + score);
                    showLoading(false); // Hide progress indicator
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void selectOption(int selectedIndex) {
        // Validate the selected option
        if (selectedIndex == QuizData.correctAnswers[category][difficulty][currentQuestion]) {
            score++; // Increment score if correct
        }

        currentQuestion++;
        if (currentQuestion < QuizData.questions[category][difficulty].length) {
            loadQuestionInBackground();
        } else {
            endQuiz();
        }
    }

    private void skipQuestion() {
        currentQuestion++;
        if (currentQuestion < QuizData.questions[category][difficulty].length) {
            loadQuestionInBackground();
        } else {
            endQuiz();
        }
    }

    private void startTimer() {
        new CountDownTimer(45000, 1000) { // 45-second timer
            public void onTick(long millisUntilFinished) {
                handler.post(() -> timerView.setText("Time: " + millisUntilFinished / 1000 + "s"));
            }

            public void onFinish() {
                handler.post(() -> {
                    timerView.setText("Time's up!");
                    if (isQuizStarted) {
                        endQuiz(); // End quiz when time runs out
                    }
                });
            }
        }.start();
    }

    private void endQuiz() {
        if (isQuizStarted) {
        isQuizStarted = false; // Prevent multiple endings
        Intent intent = new Intent(this, SummaryActivity.class);
        intent.putExtra("score", score);

        // Save the score
        SharedPreferences sharedPreferences = getSharedPreferences("MindMatrixPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        List<String> scores = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String prevScore = sharedPreferences.getString("score_" + i, null);
            if (prevScore != null) scores.add(prevScore);
        }
        scores.add(0, "Score: " + score); // Add new score at the top
        while (scores.size() > 5) scores.remove(scores.size() - 1); // Retain last 5
        for (int i = 0; i < scores.size(); i++) {
            editor.putString("score_" + i, scores.get(i));
        }
        editor.apply();
        intent.putExtra("category", category);
        intent.putExtra("difficulty", difficulty);
        startActivity(intent);
        finish();
    }}

    private void showLoading(boolean isLoading) {
        if (isLoading) {
            loadingIndicator.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.VISIBLE);
        } else {
            loadingIndicator.setVisibility(View.GONE);
            progressBar.setVisibility(View.GONE);
        }
    }
}
