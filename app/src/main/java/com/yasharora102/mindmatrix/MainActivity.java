package com.yasharora102.mindmatrix;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner categorySpinner;
    private Spinner difficultySpinner;
    private ListView recentScoresListView;
    private ArrayAdapter<String> scoresAdapter;
    private List<String> recentScores;

    private boolean isQuizStarted = false;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categorySpinner = findViewById(R.id.category_spinner);
        difficultySpinner = findViewById(R.id.difficulty_spinner);
        recentScoresListView = findViewById(R.id.recent_scores_list_view);
        Button startQuizButton = findViewById(R.id.start_quiz_button);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("MindMatrixPrefs", MODE_PRIVATE);

        // Initialize recent scores list and adapter
        recentScores = new ArrayList<>();
        scoresAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, recentScores);
        recentScoresListView.setAdapter(scoresAdapter);

        // Load categories and difficulties
        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, QuizData.categories);
        categorySpinner.setAdapter(categoryAdapter);

        ArrayAdapter<String> difficultyAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, QuizData.difficulties);
        difficultySpinner.setAdapter(difficultyAdapter);

        // Load recent scores from storage
        loadRecentScores();

        startQuizButton.setOnClickListener(v -> {
            if (!isQuizStarted) {

            isQuizStarted = true;

            Intent intent = new Intent(MainActivity.this, QuizActivity.class);
            int selectedCategory = categorySpinner.getSelectedItemPosition();
            int selectedDifficulty = difficultySpinner.getSelectedItemPosition();
            intent.putExtra("category", selectedCategory);
            intent.putExtra("difficulty", selectedDifficulty);
            startActivity(intent);
        }});
    }

    private void loadRecentScores() {
        recentScores.clear();
        for (int i = 0; i < 5; i++) {
            String score = sharedPreferences.getString("score_" + i, null);
            if (score != null) {
                recentScores.add(score);
            }
        }
        scoresAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        isQuizStarted = false;
        loadRecentScores(); // Reload scores every time MainActivity is resumed
    }

    public void saveScore(String newScore, String category, String difficulty) {
        List<String> scores = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String score = sharedPreferences.getString("score_" + i, null);
            if (score != null) scores.add(score);
        }
        scores.add(0, category + " - " + difficulty + ": " + newScore);
        while (scores.size() > 5) scores.remove(scores.size() - 1);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        for (int i = 0; i < scores.size(); i++) {
            editor.putString("score_" + i, scores.get(i));
        }
        editor.apply();
        loadRecentScores();
    }

}
