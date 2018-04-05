//
//    DESCRIPTION OF VARIABLES
//
//    TAG ---------> Used for log debugging
//    PLAYER_X ----> Variable to identify player turn
//    TURN_COUNT --> Variable to keep count of number of turns
//    b00 - b22 ---> Button for each 3x3 box
//    tvInfo ------> Information regarding game status
//    boardStatus -> 2-d array to identify board status
//        -1 means, No one has played on that box yet
//        0 means, Player 0 has played on that box
//        1 means, Player X has played on that box
//
//    /*


package com.job.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GameActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();
    boolean PLAYER_X = true;
    int TURN_COUNT = 0;
    int[][] boardStatus = new int[3][3];

    @BindView(R.id.b00)Button b00;
    @BindView(R.id.b01)Button b01;
    @BindView(R.id.b02)Button b02;

    @BindView(R.id.b10)Button b10;
    @BindView(R.id.b11)Button b11;
    @BindView(R.id.b12)Button b12;

    @BindView(R.id.b20)Button b20;
    @BindView(R.id.b21)Button b21;
    @BindView(R.id.b22)Button b22;

    @BindView(R.id.bReset)Button btnReset;
    @BindView(R.id.tvInfo)TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //binding views
        ButterKnife.bind(this);
    }
}
