package com.sunil_poudel.smemory;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView numberOfPlayers;
    private Button playerOneButton;
    private Button playerTwoButton;
    private Button playerThreeButton;
    private Button playerFourButton;

    private ImageButton image01;
    private ImageButton image02;
    private ImageButton image03;
    private ImageButton image04;
    private ImageButton image05;
    private ImageButton image06;
    private ImageButton image07;
    private ImageButton image08;
    private ImageButton image09;
    private ImageButton image10;
    private ImageButton image11;
    private ImageButton image12;
    private ImageButton image13;
    private ImageButton image14;
    private ImageButton image15;
    private ImageButton image16;
    private ImageButton image17;
    private ImageButton image18;
    private ImageButton image19;
    private ImageButton image20;
    private ImageButton image21;
    private ImageButton image22;
    private ImageButton image23;
    private ImageButton image24;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Random random = new Random();

        int[] randomFlagsTemp = generateUniqueRandomNumbers(12, 0, 253);
        int[] randomFruitsAndVegetablesTemp = generateUniqueRandomNumbers(12, 0, 73);

//        Log.d("SUNIL SAYS", Arrays.toString(randomFlagsTemp));
//        Log.d("SUNIL SAYS", Arrays.toString(randomFruitsAndVegetablesTemp));

        List<Integer> flagsList = new ArrayList<>();
        List<Integer> fruitsAndVegetablesList = new ArrayList<>();
        for(int i=0; i<24; i++){
            flagsList.add(randomFlagsTemp[(i%12)]);
            fruitsAndVegetablesList.add(randomFruitsAndVegetablesTemp[(i%12)]);
        }
        Collections.shuffle(flagsList, random);
        Collections.shuffle(fruitsAndVegetablesList, random);

        int[] randomFlagsFinal = flagsList.stream().mapToInt(Integer::intValue).toArray();
        int[] randomFruitsAndVegetablesFinal = fruitsAndVegetablesList.stream().mapToInt(Integer::intValue).toArray();


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
        int randomKey = Integer.parseInt(intent.getStringExtra("random_key"));

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



        image01 = findViewById(R.id.image_01);
        image02 = findViewById(R.id.image_02);
        image03 = findViewById(R.id.image_03);
        image04 = findViewById(R.id.image_04);
        image05 = findViewById(R.id.image_05);
        image06 = findViewById(R.id.image_06);
        image07 = findViewById(R.id.image_07);
        image08 = findViewById(R.id.image_08);
        image09 = findViewById(R.id.image_09);
        image10 = findViewById(R.id.image_10);
        image11 = findViewById(R.id.image_11);
        image12 = findViewById(R.id.image_12);
        image13 = findViewById(R.id.image_13);
        image14 = findViewById(R.id.image_14);
        image15 = findViewById(R.id.image_15);
        image16 = findViewById(R.id.image_16);
        image17 = findViewById(R.id.image_17);
        image18 = findViewById(R.id.image_18);
        image19 = findViewById(R.id.image_19);
        image20 = findViewById(R.id.image_20);
        image21 = findViewById(R.id.image_21);
        image22 = findViewById(R.id.image_22);
        image23 = findViewById(R.id.image_23);
        image24 = findViewById(R.id.image_24);

        image01.setOnClickListener(this);
        image02.setOnClickListener(this);
        image03.setOnClickListener(this);
        image04.setOnClickListener(this);
        image05.setOnClickListener(this);
        image06.setOnClickListener(this);
        image07.setOnClickListener(this);
        image08.setOnClickListener(this);
        image09.setOnClickListener(this);
        image10.setOnClickListener(this);
        image11.setOnClickListener(this);
        image12.setOnClickListener(this);
        image13.setOnClickListener(this);
        image14.setOnClickListener(this);
        image15.setOnClickListener(this);
        image16.setOnClickListener(this);
        image17.setOnClickListener(this);
        image18.setOnClickListener(this);
        image19.setOnClickListener(this);
        image20.setOnClickListener(this);
        image21.setOnClickListener(this);
        image22.setOnClickListener(this);
        image23.setOnClickListener(this);
        image24.setOnClickListener(this);




    }

    //fruits and vegetables image link: https://www.squaremeals.org/Portals/8/files/FFVP/100%20fruits%20and%20veggies.pdf
    //flags image link: https://www.worldflags101.com/all-country-flags/
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.image_01) {
            // Handle image_01 click
        } else if (v.getId() == R.id.image_02) {
            // Handle image_02 click
        } else if (v.getId() == R.id.image_03) {
            // Handle image_03 click
        } else if (v.getId() == R.id.image_04) {
            // Handle image_04 click
        } else if (v.getId() == R.id.image_05) {
            // Handle image_05 click
        } else if (v.getId() == R.id.image_06) {
            // Handle image_06 click
        } else if (v.getId() == R.id.image_07) {
            // Handle image_07 click
        } else if (v.getId() == R.id.image_08) {
            // Handle image_08 click
        } else if (v.getId() == R.id.image_09) {
            // Handle image_09 click
        } else if (v.getId() == R.id.image_10) {
            // Handle image_10 click
        } else if (v.getId() == R.id.image_11) {
            // Handle image_11 click
        } else if (v.getId() == R.id.image_12) {
            // Handle image_12 click
        } else if (v.getId() == R.id.image_13) {
            // Handle image_13 click
        } else if (v.getId() == R.id.image_14) {
            // Handle image_14 click
        } else if (v.getId() == R.id.image_15) {
            // Handle image_15 click
        } else if (v.getId() == R.id.image_16) {
            // Handle image_16 click
        } else if (v.getId() == R.id.image_17) {
            // Handle image_17 click
        } else if (v.getId() == R.id.image_18) {
            // Handle image_18 click
        } else if (v.getId() == R.id.image_19) {
            // Handle image_19 click
        } else if (v.getId() == R.id.image_20) {
            // Handle image_20 click
        } else if (v.getId() == R.id.image_21) {
            // Handle image_21 click
        } else if (v.getId() == R.id.image_22) {
            // Handle image_22 click
        } else if (v.getId() == R.id.image_23) {
            // Handle image_23 click
        } else if (v.getId() == R.id.image_24) {
            // Handle image_24 click
        }
    }

    public static int[] generateUniqueRandomNumbers(int count, int min, int max) {

        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        // generate all numbers
        for (int i = min; i <= max; i++) {
            numbers.add(i);
        }

        // Shuffle the list to make it random
        Collections.shuffle(numbers, random);

        // Select the first number of numbers needed
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = numbers.get(i);
        }

        return result;
    }
}