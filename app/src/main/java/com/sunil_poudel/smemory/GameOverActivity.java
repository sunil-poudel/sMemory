package com.sunil_poudel.smemory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class GameOverActivity extends AppCompatActivity {
    private int highestScorer;
    private int highestScore;
    private int numberOfPlayers;
    private TextView highestScorerView;
    private TextView highestScoreView;
    private TextView numberOfPlayersView;
    private TextView playerXWinsView;
    private Button returnHomeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        Intent intent = getIntent();
        highestScore = Integer.parseInt(intent.getStringExtra("highestScore"));
        highestScorer = Integer.parseInt(intent.getStringExtra("highestScorer"));
        numberOfPlayers = Integer.parseInt(intent.getStringExtra("numberOfPlayers"));

        playerXWinsView = findViewById(R.id.player_x_wins_game_over);

        highestScorerView = findViewById(R.id.winner_game_over);
        highestScoreView = findViewById(R.id.highest_score_game_over);
        numberOfPlayersView = findViewById(R.id.number_of_players_game_over);

        returnHomeButton = findViewById(R.id.return_back_game_over);

        if(highestScore!=1000) {
            highestScorerView.setText(String.valueOf(highestScorer));
            highestScoreView.setText(String.valueOf(highestScore));
            numberOfPlayersView.setText(String.valueOf(numberOfPlayers));

            playerXWinsView.setText(String.format(Locale.US, "Player %d wins!", highestScorer));
        } else{
            highestScorerView.setText("None");
            highestScoreView.setText("Draw");
            numberOfPlayersView.setText(numberOfPlayers);

            playerXWinsView.setText("DRAW");
        }

        returnHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnHomeIntent = new Intent(v.getContext(), MainActivity.class);
                startActivity(returnHomeIntent);
                finish();
            }
        });

    }
}