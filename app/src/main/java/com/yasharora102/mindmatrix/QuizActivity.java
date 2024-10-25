package com.yasharora102.mindmatrix;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {
    TextView questionView, scoreView, timerView;
    Button optionA, optionB, optionC, optionD, nextButton;
    int score = 0, currentQuestion = 0, category, difficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        category = getIntent().getIntExtra("category", 0);
        difficulty = getIntent().getIntExtra("difficulty", 0);

        questionView = findViewById(R.id.question_view);
        scoreView = findViewById(R.id.score_view);
        timerView = findViewById(R.id.timer_view);
        optionA = findViewById(R.id.option_a);
        optionB = findViewById(R.id.option_b);
        optionC = findViewById(R.id.option_c);
        optionD = findViewById(R.id.option_d);
        nextButton = findViewById(R.id.next_button);

        loadQuestion();

        // Set click listeners for options
        optionA.setOnClickListener(v -> selectOption(0));
        optionB.setOnClickListener(v -> selectOption(1));
        optionC.setOnClickListener(v -> selectOption(2));
        optionD.setOnClickListener(v -> selectOption(3));

        nextButton.setOnClickListener(v -> skipQuestion());
    }

    private void loadQuestion() {
        String question = QuizData.questions[category][difficulty][currentQuestion];
        String[] options = QuizData.answers[category][difficulty][currentQuestion];
        questionView.setText(question);
        scoreView.setText("Score: " + score);
        optionA.setText(options[0]);
        optionB.setText(options[1]);
        optionC.setText(options[2]);
        optionD.setText(options[3]);
    }

    private void selectOption(int selectedIndex) {
        // Check if the selected answer is correct
        if (selectedIndex == QuizData.correctAnswers[category][difficulty][currentQuestion]) {
            score++;  // Increment score if correct
        }

        // Load the next question
        currentQuestion++;
        if (currentQuestion < QuizData.questions[category][difficulty].length) {
            loadQuestion();
        } else {
            endQuiz();  // End the quiz if there are no more questions
        }
    }

    private void skipQuestion() {
        currentQuestion++;
        if (currentQuestion < QuizData.questions[category][difficulty].length) {
            loadQuestion();
        } else {
            endQuiz();
        }
    }

    private void startTimer() {
        // Timer implementation here if needed
    }

    private void endQuiz() {
        Intent intent = new Intent(this, SummaryActivity.class);
        intent.putExtra("score", score);
        startActivity(intent);
        finish();  // Close the current activity
    }
}
