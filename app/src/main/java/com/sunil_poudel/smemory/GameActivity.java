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

import com.sunil_poudel.smemory.ImageAssets.Images;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    int turn = -1;
    boolean clickedTwice = false;
    Stack<Integer> turnCountStack = new Stack<>();
    Stack<Integer> resourceTempStack = new Stack<>();
    Stack<Integer> resourceStack = new Stack<>();
    private TextView numberOfPlayers;
    private Button playerOneButton;
    private Button playerTwoButton;
    private Button playerThreeButton;
    private Button playerFourButton;

    private TextView scorePlayerOne;
    private TextView scorePlayerTwo;
    private TextView scorePlayerThree;
    private TextView scorePlayerFour;

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
    private int[] imageResources = new int[24];


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

        scorePlayerOne = findViewById(R.id.score_player_1);
        scorePlayerTwo = findViewById(R.id.score_player_2);
        scorePlayerThree = findViewById(R.id.score_player_3);
        scorePlayerFour = findViewById(R.id.score_player_4);

        playerOneButton.setVisibility(View.INVISIBLE);
        playerTwoButton.setVisibility(View.INVISIBLE);
        playerThreeButton.setVisibility(View.INVISIBLE);
        playerFourButton.setVisibility(View.INVISIBLE);

        scorePlayerOne.setVisibility(View.INVISIBLE);
        scorePlayerTwo.setVisibility(View.INVISIBLE);
        scorePlayerThree.setVisibility(View.INVISIBLE);
        scorePlayerFour.setVisibility(View.INVISIBLE);

        Intent intent = getIntent();
        String playersCount = intent.getStringExtra("player_count");
        int playersCountInt = Integer.parseInt(playersCount);
        int randomKey = Integer.parseInt(intent.getStringExtra("random_key"));

        numberOfPlayers.setText("Number of players: "+playersCount);

        switch (playersCountInt){
            case 2:
                playerOneButton.setVisibility(View.VISIBLE);
                playerTwoButton.setVisibility(View.VISIBLE);
                scorePlayerOne.setVisibility(View.VISIBLE);
                scorePlayerTwo.setVisibility(View.VISIBLE);
                break;
            case 3:
                playerOneButton.setVisibility(View.VISIBLE);
                playerTwoButton.setVisibility(View.VISIBLE);
                playerThreeButton.setVisibility(View.VISIBLE);
                scorePlayerOne.setVisibility(View.VISIBLE);
                scorePlayerTwo.setVisibility(View.VISIBLE);
                scorePlayerThree.setVisibility(View.VISIBLE);
                break;
            case 4:
                playerOneButton.setVisibility(View.VISIBLE);
                playerTwoButton.setVisibility(View.VISIBLE);
                playerThreeButton.setVisibility(View.VISIBLE);
                playerFourButton.setVisibility(View.VISIBLE);
                scorePlayerOne.setVisibility(View.VISIBLE);
                scorePlayerTwo.setVisibility(View.VISIBLE);
                scorePlayerThree.setVisibility(View.VISIBLE);
                scorePlayerFour.setVisibility(View.VISIBLE);
                break;
        }

        if(randomKey==0){
            for(int i=0;i <24; i++) {
                imageResources[i] = Images.FLAG[randomFlagsFinal[i]];
            }
        } else if(randomKey==1) {
            for(int i=0;i <24; i++) {
                imageResources[i] = Images.FRUIT_OR_VEG[randomFruitsAndVegetablesFinal[i]];
            }
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
        turn=(turn+1)%2;

        if(turnCountStack.size()<=1) {
            if (turn == 0 && !clickedTwice) {
                setImage(v.getId());
                resourceTempStack.push(v.getId());
                resourceStack.push(v.getId());
                turnCountStack.push(0);
                Log.d("SUNIL SAYS", "id: "+v.getId());
            } else if (turn == 1 && !clickedTwice) {
                setImage(v.getId());
                resourceTempStack.push(v.getId());
                resourceStack.push(v.getId());
                turnCountStack.push(1);
                Log.d("SUNIL SAYS", "id: "+v.getId());

            }
            if (resourceTempStack.size() == 2) {
                int tempResourceOne = resourceStack.pop();
                int tempResourceTwo = resourceStack.pop();

                v.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if(tempResourceOne == tempResourceTwo){
                                Log.d("SUNIL SAYS", "clicked two same images");
                            }
                            else {
                                resetImage(resourceTempStack.pop());
                                resetImage(resourceTempStack.pop());
                                turnCountStack.clear();
                            }
                        }
                    }, 2000);


            }

        }

    }

    public int[] generateUniqueRandomNumbers(int count, int min, int max) {

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

    public void setImage(int resource){
        if (resource == R.id.image_01) {
            image01.setImageResource(imageResources[0]);
        } else if (resource == R.id.image_02) {
            image02.setImageResource(imageResources[1]);
        } else if (resource == R.id.image_03) {
            image03.setImageResource(imageResources[2]);
        } else if (resource == R.id.image_04) {
            image04.setImageResource(imageResources[3]);
        } else if (resource == R.id.image_05) {
            image05.setImageResource(imageResources[4]);
        } else if (resource == R.id.image_06) {
            image06.setImageResource(imageResources[5]);
        } else if (resource == R.id.image_07) {
            image07.setImageResource(imageResources[6]);
        } else if (resource == R.id.image_08) {
            image08.setImageResource(imageResources[7]);
        } else if (resource == R.id.image_09) {
            image09.setImageResource(imageResources[8]);
        } else if (resource == R.id.image_10) {
            image10.setImageResource(imageResources[9]);
        } else if (resource == R.id.image_11) {
            image11.setImageResource(imageResources[10]);
        } else if (resource == R.id.image_12) {
            image12.setImageResource(imageResources[11]);
        } else if (resource == R.id.image_13) {
            image13.setImageResource(imageResources[12]);
        } else if (resource == R.id.image_14) {
            image14.setImageResource(imageResources[13]);
        } else if (resource == R.id.image_15) {
            image15.setImageResource(imageResources[14]);
        } else if (resource == R.id.image_16) {
            image16.setImageResource(imageResources[15]);
        } else if (resource == R.id.image_17) {
            image17.setImageResource(imageResources[16]);
        } else if (resource == R.id.image_18) {
            image18.setImageResource(imageResources[17]);
        } else if (resource == R.id.image_19) {
            image19.setImageResource(imageResources[18]);
        } else if (resource == R.id.image_20) {
            image20.setImageResource(imageResources[19]);
        } else if (resource == R.id.image_21) {
            image21.setImageResource(imageResources[20]);
        } else if (resource == R.id.image_22) {
            image22.setImageResource(imageResources[21]);
        } else if (resource == R.id.image_23) {
            image23.setImageResource(imageResources[22]);
        } else if (resource == R.id.image_24) {
            image24.setImageResource(imageResources[23]);
        }
    }

    public void resetImage(int resource){
        if (resource == R.id.image_01) {
            image01.setImageResource(R.drawable.smemory_logo);
        } else if (resource == R.id.image_02) {
            image02.setImageResource(R.drawable.smemory_logo);
        } else if (resource == R.id.image_03) {
            image03.setImageResource(R.drawable.smemory_logo);
        } else if (resource == R.id.image_04) {
            image04.setImageResource(R.drawable.smemory_logo);
        } else if (resource == R.id.image_05) {
            image05.setImageResource(R.drawable.smemory_logo);
        } else if (resource == R.id.image_06) {
            image06.setImageResource(R.drawable.smemory_logo);
        } else if (resource == R.id.image_07) {
            image07.setImageResource(R.drawable.smemory_logo);
        } else if (resource == R.id.image_08) {
            image08.setImageResource(R.drawable.smemory_logo);
        } else if (resource == R.id.image_09) {
            image09.setImageResource(R.drawable.smemory_logo);
        } else if (resource == R.id.image_10) {
            image10.setImageResource(R.drawable.smemory_logo);
        } else if (resource == R.id.image_11) {
            image11.setImageResource(R.drawable.smemory_logo);
        } else if (resource == R.id.image_12) {
            image12.setImageResource(R.drawable.smemory_logo);
        } else if (resource == R.id.image_13) {
            image13.setImageResource(R.drawable.smemory_logo);
        } else if (resource == R.id.image_14) {
            image14.setImageResource(R.drawable.smemory_logo);
        } else if (resource == R.id.image_15) {
            image15.setImageResource(R.drawable.smemory_logo);
        } else if (resource == R.id.image_16) {
            image16.setImageResource(R.drawable.smemory_logo);
        } else if (resource == R.id.image_17) {
            image17.setImageResource(R.drawable.smemory_logo);
        } else if (resource == R.id.image_18) {
            image18.setImageResource(R.drawable.smemory_logo);
        } else if (resource == R.id.image_19) {
            image19.setImageResource(R.drawable.smemory_logo);
        } else if (resource == R.id.image_20) {
            image20.setImageResource(R.drawable.smemory_logo);
        } else if (resource == R.id.image_21) {
            image21.setImageResource(R.drawable.smemory_logo);
        } else if (resource == R.id.image_22) {
            image22.setImageResource(R.drawable.smemory_logo);
        } else if (resource == R.id.image_23) {
            image23.setImageResource(R.drawable.smemory_logo);
        } else if (resource == R.id.image_24) {
            image24.setImageResource(R.drawable.smemory_logo);
        }
    }

    public void vanishImage(int resource){
        if (resource == R.id.image_01) {
            image01.setVisibility(View.INVISIBLE);
        } else if (resource == R.id.image_02) {
            image02.setVisibility(View.INVISIBLE);
        } else if (resource == R.id.image_03) {
            image03.setVisibility(View.INVISIBLE);
        } else if (resource == R.id.image_04) {
            image04.setVisibility(View.INVISIBLE);
        } else if (resource == R.id.image_05) {
            image05.setVisibility(View.INVISIBLE);
        } else if (resource == R.id.image_06) {
            image06.setVisibility(View.INVISIBLE);
        } else if (resource == R.id.image_07) {
            image07.setVisibility(View.INVISIBLE);
        } else if (resource == R.id.image_08) {
            image08.setVisibility(View.INVISIBLE);
        } else if (resource == R.id.image_09) {
            image09.setVisibility(View.INVISIBLE);
        } else if (resource == R.id.image_10) {
            image10.setVisibility(View.INVISIBLE);
        } else if (resource == R.id.image_11) {
            image11.setVisibility(View.INVISIBLE);
        } else if (resource == R.id.image_12) {
            image12.setVisibility(View.INVISIBLE);
        } else if (resource == R.id.image_13) {
            image13.setVisibility(View.INVISIBLE);
        } else if (resource == R.id.image_14) {
            image14.setVisibility(View.INVISIBLE);
        } else if (resource == R.id.image_15) {
            image15.setVisibility(View.INVISIBLE);
        } else if (resource == R.id.image_16) {
            image16.setVisibility(View.INVISIBLE);
        } else if (resource == R.id.image_17) {
            image17.setVisibility(View.INVISIBLE);
        } else if (resource == R.id.image_18) {
            image18.setVisibility(View.INVISIBLE);
        } else if (resource == R.id.image_19) {
            image19.setVisibility(View.INVISIBLE);
        } else if (resource == R.id.image_20) {
            image20.setVisibility(View.INVISIBLE);
        } else if (resource == R.id.image_21) {
            image21.setVisibility(View.INVISIBLE);
        } else if (resource == R.id.image_22) {
            image22.setVisibility(View.INVISIBLE);
        } else if (resource == R.id.image_23) {
            image23.setVisibility(View.INVISIBLE);
        } else if (resource == R.id.image_24) {
            image24.setVisibility(View.INVISIBLE);
        }

    }


}