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

public class GameActivity extends AppCompatActivity {

    private TextView numberOfPlayers;
    private Button playerOneButton;
    private Button playerTwoButton;
    private Button playerThreeButton;
    private Button playerFourButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        numberOfPlayers = findViewById(R.id.number_of_players);

        playerOneButton = findViewById(R.id.button_player_1);
        playerTwoButton = findViewById(R.id.button_player_2);
        playerThreeButton = findViewById(R.id.button_player_3);
        playerFourButton = findViewById(R.id.button_player_4);

        playerOneButton.setVisibility(View.INVISIBLE);
        playerTwoButton.setVisibility(View.INVISIBLE);
        playerThreeButton.setVisibility(View.INVISIBLE);
        playerFourButton.setVisibility(View.INVISIBLE);

        Intent intent = getIntent();
        String playersCount = intent.getStringExtra("player_count");
        int playersCountInt = Integer.parseInt(playersCount);

        numberOfPlayers.setText("Number of players: "+playersCount);

        switch (playersCountInt){
            case 2:
                playerOneButton.setVisibility(View.VISIBLE);
                playerTwoButton.setVisibility(View.VISIBLE);
                break;
            case 3:
                playerOneButton.setVisibility(View.VISIBLE);
                playerTwoButton.setVisibility(View.VISIBLE);
                playerThreeButton.setVisibility(View.VISIBLE);
                break;
            case 4:
                playerOneButton.setVisibility(View.VISIBLE);
                playerTwoButton.setVisibility(View.VISIBLE);
                playerThreeButton.setVisibility(View.VISIBLE);
                playerFourButton.setVisibility(View.VISIBLE);
                break;
        }


    }
}