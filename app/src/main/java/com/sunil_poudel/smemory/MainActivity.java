package com.sunil_poudel.smemory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button twoPlayerButton;
    private Button threePlayerButton;
    private Button fourPlayerButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        twoPlayerButton = findViewById(R.id.two_players_button);
        threePlayerButton = findViewById(R.id.three_players_button);
        fourPlayerButton = findViewById(R.id.four_players_button);

        twoPlayerButton.setOnClickListener(this);
        twoPlayerButton.setText("Enter game now!");
        threePlayerButton.setOnClickListener(this);
        threePlayerButton.setVisibility(View.INVISIBLE);
        fourPlayerButton.setOnClickListener(this);
        fourPlayerButton.setVisibility(View.INVISIBLE);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, GameActivity.class);

        Random random = new Random();
        int randomKey = random.nextInt(2);
        intent.putExtra("random_key", String.valueOf(randomKey));

        if (v.getId() == R.id.two_players_button) {
            intent.putExtra("player_count", "2");
        } else if(v.getId() == R.id.three_players_button){
            intent.putExtra("player_count", "3");
        } else if (v.getId() == R.id.four_players_button) {
            intent.putExtra("player_count", "4");
        }

        startActivity(intent);
    }
}