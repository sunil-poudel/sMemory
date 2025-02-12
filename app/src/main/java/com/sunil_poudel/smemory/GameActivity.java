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
    int playersCountInt = 0;
    int playerPointer = 1;
    int playerOnePoints = 0;
    int playerTwoPoints = 0;
    int playerThreePoints = 0;
    int playerFourPoints = 0;

    int turn = -1;
    Stack<Integer> turnCountStack = new Stack<>();
    Stack<Integer> resourceTempStack = new Stack<>();
    Stack<Integer> resourceStack = new Stack<>();
    int resourceOne = 0;
    int resourceTwo = 1;

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

        int[] randomFlagsTemp = generateUniqueRandomNumbers(12, 0, 251);
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
        numberOfPlayers.setVisibility(View.INVISIBLE);

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
        playersCountInt = Integer.parseInt(playersCount);
        int randomKey = Integer.parseInt(intent.getStringExtra("random_key"));

//        numberOfPlayers.setText("Number of players: "+playersCount);

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
            if (turn == 0) {
                resourceOne = setImage(v.getId());
                resourceTempStack.push(v.getId());
                resourceStack.push(v.getId());
                turnCountStack.push(0);
//                Log.d("SUNIL SAYS", "id: "+v.getId());
            } else if (turn == 1 && v.getId()!=resourceStack.peek()) {
                resourceTwo = setImage(v.getId());
                resourceTempStack.push(v.getId());
                resourceStack.push(v.getId());
                turnCountStack.push(1);
//                Log.d("SUNIL SAYS", "id: "+v.getId());

            } else if(v.getId() == resourceStack.peek()){
                turn=0;
            }
            if (resourceTempStack.size() == 2) {

                v.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if(resourceOne == resourceTwo){
                                vanishImage(resourceTempStack.pop());
                                vanishImage(resourceTempStack.pop());
                                turnCountStack.clear();
                                updateScoreAndTurnColor(2, playerPointer, playersCountInt);
//                                playerOnePoints=20; playerTwoPoints=4; playerThreePoints=0; playerFourPoints=0;
                                if(playerOnePoints!=0 || playerTwoPoints!=0 || playerThreePoints!=0 || playerFourPoints!=0){
                                    if(playerOnePoints+playerTwoPoints+playerThreePoints+playerFourPoints == 24){

                                        Intent gameOverIntent = new Intent(v.getContext(), GameOverActivity.class);
                                        Log.d("SUNIL SAYS", "PASSES GAME OVER INTENT");
                                        if(!equalPoints(playerOnePoints,playerTwoPoints,playerThreePoints,playerFourPoints)) {
                                            int[] scorers = highestScorePlusScorer(playerOnePoints, playerTwoPoints, playerThreePoints, playerFourPoints);
                                            Log.d("SUNIL SAYS", Arrays.toString(scorers));
                                            gameOverIntent.putExtra("highestScore", String.valueOf(scorers[0]));
                                            gameOverIntent.putExtra("highestScorer", String.valueOf(scorers[1]));
                                            Log.d("SUNIL SAYS", "GAME OVER, points:"+scorers[1]+" scorer: "+scorers[0]);

                                        } else{
                                            gameOverIntent.putExtra("highestScore", "1000");
                                            gameOverIntent.putExtra("highestScorer", "1000");
//                                            Log.d("SUNIL SAYS", "GAME OVER, DRAW ");
                                        }
                                        gameOverIntent.putExtra("numberOfPlayers", String.valueOf(playersCountInt));
//                                        Log.d("SUNIL SAYS", "WENT UPTO HERE");
                                        startActivity(gameOverIntent);
//                                        finish();

                                    }
                                }

                            }
                            else {
                                resetImage(resourceTempStack.pop());
                                resetImage(resourceTempStack.pop());
                                turnCountStack.clear();
                                updateScoreAndTurnColor(0, playerPointer, playersCountInt);
                                playerPointer=((playerPointer)%playersCountInt)+1;

                            }
                        }
                    }, 1000);


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

    public int setImage(int resource) {
        if (resource == R.id.image_01) {
            image01.setImageResource(imageResources[0]);
            return imageResources[0];
        } else if (resource == R.id.image_02) {
            image02.setImageResource(imageResources[1]);
            return imageResources[1];
        } else if (resource == R.id.image_03) {
            image03.setImageResource(imageResources[2]);
            return imageResources[2];
        } else if (resource == R.id.image_04) {
            image04.setImageResource(imageResources[3]);
            return imageResources[3];
        } else if (resource == R.id.image_05) {
            image05.setImageResource(imageResources[4]);
            return imageResources[4];
        } else if (resource == R.id.image_06) {
            image06.setImageResource(imageResources[5]);
            return imageResources[5];
        } else if (resource == R.id.image_07) {
            image07.setImageResource(imageResources[6]);
            return imageResources[6];
        } else if (resource == R.id.image_08) {
            image08.setImageResource(imageResources[7]);
            return imageResources[7];
        } else if (resource == R.id.image_09) {
            image09.setImageResource(imageResources[8]);
            return imageResources[8];
        } else if (resource == R.id.image_10) {
            image10.setImageResource(imageResources[9]);
            return imageResources[9];
        } else if (resource == R.id.image_11) {
            image11.setImageResource(imageResources[10]);
            return imageResources[10];
        } else if (resource == R.id.image_12) {
            image12.setImageResource(imageResources[11]);
            return imageResources[11];
        } else if (resource == R.id.image_13) {
            image13.setImageResource(imageResources[12]);
            return imageResources[12];
        } else if (resource == R.id.image_14) {
            image14.setImageResource(imageResources[13]);
            return imageResources[13];
        } else if (resource == R.id.image_15) {
            image15.setImageResource(imageResources[14]);
            return imageResources[14];
        } else if (resource == R.id.image_16) {
            image16.setImageResource(imageResources[15]);
            return imageResources[15];
        } else if (resource == R.id.image_17) {
            image17.setImageResource(imageResources[16]);
            return imageResources[16];
        } else if (resource == R.id.image_18) {
            image18.setImageResource(imageResources[17]);
            return imageResources[17];
        } else if (resource == R.id.image_19) {
            image19.setImageResource(imageResources[18]);
            return imageResources[18];
        } else if (resource == R.id.image_20) {
            image20.setImageResource(imageResources[19]);
            return imageResources[19];
        } else if (resource == R.id.image_21) {
            image21.setImageResource(imageResources[20]);
            return imageResources[20];
        } else if (resource == R.id.image_22) {
            image22.setImageResource(imageResources[21]);
            return imageResources[21];
        } else if (resource == R.id.image_23) {
            image23.setImageResource(imageResources[22]);
            return imageResources[22];
        } else if (resource == R.id.image_24) {
            image24.setImageResource(imageResources[23]);
            return imageResources[23];
        }
        return -1; // Default return if no match found
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

    public void vanishImage(int resource) {
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

    public void updateScoreAndTurnColor(int score, int currentPlayer, int playersCountInt){
        if(score==0){
            switch (playersCountInt){
                case 2:
                 switch (currentPlayer){
                     case 1:
                         playerOneButton.setBackgroundColor(getColor(R.color.blue));
                         playerTwoButton.setBackgroundColor(getColor(R.color.green));
                         break;
                     case 2:
                         playerTwoButton.setBackgroundColor(getColor(R.color.blue));
                         playerOneButton.setBackgroundColor(getColor(R.color.green));
                         break;
                 }
                 break;
                case 3:
                case 4:
                    break;
            }
        } else{
            switch (playersCountInt){
                case 2:
                    switch (currentPlayer){
                        case 1:
                            playerOnePoints+=score;
                            scorePlayerOne.setText(String.valueOf(playerOnePoints));
                            break;
                        case 2:
                            playerTwoPoints+=score;
                            scorePlayerTwo.setText(String.valueOf(playerTwoPoints));
                            break;
                    }
                    break;
                case 3:
                case 4:
                    break;
            }
        }
    }

    public int[] highestScorePlusScorer(int playerOnePoints, int playerTwoPoints, int playerThreePoints, int playerFourPoints){
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(playerOnePoints);
        arrayList.add(playerTwoPoints);
        arrayList.add(playerThreePoints);
        arrayList.add(playerFourPoints);
        arrayList.sort(Collections.reverseOrder());

        int highestScorer = 0;
        int highestScore = arrayList.get(0);

        if(highestScore == playerOnePoints){
            highestScorer = 1;
        } else if (highestScore == playerTwoPoints) {
            highestScorer = 2;
        } else if (highestScore == playerThreePoints) {
            highestScorer = 3;
        } else if (highestScore == playerFourPoints) {
            highestScorer = 4;
        }

        Log.d("SUNIL SAYS", "HIGHEST SCORER->"+highestScorer+" "+"highestScore->"+ highestScore);
        return new int[]{highestScore, highestScorer};
    }

    public boolean equalPoints(int playerOnePoints, int playerTwoPoints, int playerThreePoints, int playerFourPoints){
        boolean flag = false;
        int[] points = new int[]{playerOnePoints, playerTwoPoints};
        for(int i=0; i<points.length; i++){
            for(int j=i+1; j<points.length; j++){
                if (points[i] == points[j]) {
                    flag = true;
                    i = points.length;
                    break;
                }
            }
        }
        return flag;
    }

}
