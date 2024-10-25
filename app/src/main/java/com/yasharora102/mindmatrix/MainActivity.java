package com.yasharora102.mindmatrix;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Spinner categorySpinner;
    private Spinner difficultySpinner;
    private Button startQuizButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        categorySpinner = findViewById(R.id.category_spinner);
        difficultySpinner = findViewById(R.id.difficulty_spinner);
        startQuizButton = findViewById(R.id.start_quiz_button);

        // Populate the category spinner
        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, QuizData.categories);
        categorySpinner.setAdapter(categoryAdapter);

        // Populate the difficulty spinner
        String[] difficulties = {"Easy", "Medium", "Hard"};
        ArrayAdapter<String> difficultyAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, difficulties);
        difficultySpinner.setAdapter(difficultyAdapter);

        // Set click listener for the start quiz button
        startQuizButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, QuizActivity.class);
            int selectedCategory = categorySpinner.getSelectedItemPosition();
            int selectedDifficulty = difficultySpinner.getSelectedItemPosition();
            intent.putExtra("category", selectedCategory);
            intent.putExtra("difficulty", selectedDifficulty);
            startActivity(intent);
        });
    }
}
