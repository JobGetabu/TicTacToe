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

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

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

    @BindViews({R.id.b00,R.id.b01,R.id.b02, R.id.b10,R.id.b11,R.id.b12, R.id.b20,R.id.b21,R.id.b22})
    List<Button> playButtonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //binding views
        ButterKnife.bind(this);

        initializeBoardStatus();
    }


    private void initializeBoardStatus() {
        // -1 means, No one has played on that box yet
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                boardStatus[i][j] = -1;
            }
        }
    }

    static final ButterKnife.Action<View> DISABLE = new ButterKnife.Action<View>() {
        @Override public void apply(View view, int index) {
            view.setEnabled(false);
        }
    };

    static final ButterKnife.Action<View> ENABLE = new ButterKnife.Action<View>() {
        @Override public void apply(View view, int index) {
            view.setEnabled(true);
        }
    };

    static final ButterKnife.Action<View> NULLTEXT = new ButterKnife.Action<View>() {
        @Override public void apply(View view, int index) {
            Button button = (Button)view;
            button.setText("");
        }
    };

    private  void enableAllBoxes(Boolean enable){
        ButterKnife.apply(playButtonList, enable ? ENABLE : DISABLE);
    }

    private void resetBoard(){
        Log.d(TAG, "Inside resetBoard");
        ButterKnife.apply(playButtonList,NULLTEXT);

        enableAllBoxes(true);

        PLAYER_X = true;
        TURN_COUNT = 0;

        initializeBoardStatus();

        setInfo("Start Again!!!");

        Toast.makeText(this,"Board Reset",Toast.LENGTH_SHORT).show();
    }

    private void setInfo(String text){
        tvInfo.setText(text);
    }

    private void result(String winner){
        Log.d(TAG, "Inside result");

        setInfo(winner);
        enableAllBoxes(false);
    }

    private void checkWinner(){

        Log.d(TAG, "Inside checkWinner");

        //Horizontal --- rows
        for(int i=0; i<3; i++){
            if(boardStatus[i][0] == boardStatus[i][1] && boardStatus[i][0] == boardStatus[i][2]){
                if (boardStatus[i][0]==1){
                    result("Player X winner\n" + (i+1)+" row");
                    break;
                }
                else if (boardStatus[i][0]==0) {
                    result("Player 0 winner\n" + (i+1)+" row");
                    break;
                }
            }
        }

        //Vertical --- columns
        for(int i=0; i<3; i++){
            if(boardStatus[0][i] == boardStatus[1][i] && boardStatus[0][i] == boardStatus[2][i]){
                if (boardStatus[0][i]==1){
                    result("Player X winner\n" + (i+1)+" column");
                    break;
                }
                else if (boardStatus[0][i]==0) {
                    result("Player 0 winner\n" + (i+1)+" column");
                    break;
                }
            }
        }

        //First diagonal
        if(boardStatus[0][0] == boardStatus[1][1] && boardStatus[0][0] == boardStatus[2][2]){
            if (boardStatus[0][0]==1){
                result("Player X winner\nFirst Diagonal");
            }
            else if (boardStatus[0][0]==0) {
                result("Player 0 winner\nFirst Diagonal");
            }
        }

        //Second diagonal
        if(boardStatus[0][2] == boardStatus[1][1] && boardStatus[0][2] == boardStatus[2][0]){
            if (boardStatus[0][2]==1){
                result("Player X winner\nSecond Diagonal");
            }
            else if (boardStatus[0][2]==0) {
                result("Player 0 winner\nSecond Diagonal");
            }
        }
    }

    @OnClick({R.id.b00,R.id.b01,R.id.b02, R.id.b10,R.id.b11,R.id.b12, R.id.b20,R.id.b21,R.id.b22, R.id.bReset})
    public void playButtonClick(View view) {
        Log.d(TAG, "Inside onClick");

        boolean resetButtonPressed = false;

        switch (view.getId()){
            case R.id.b00:
                if(PLAYER_X){
                    b00.setText("X");
                    boardStatus[0][0] = 1;
                }
                else{
                    b00.setText("0");
                    boardStatus[0][0] = 0;
                }
                b00.setEnabled(false);
                break;

            case R.id.b01:
                if(PLAYER_X){
                    b01.setText("X");
                    boardStatus[0][1] = 1;
                }
                else{
                    b01.setText("0");
                    boardStatus[0][1] = 0;
                }
                b01.setEnabled(false);
                break;

            case R.id.b02:
                if(PLAYER_X){
                    b02.setText("X");
                    boardStatus[0][2] = 1;
                }
                else{
                    b02.setText("0");
                    boardStatus[0][2] = 0;
                }
                b02.setEnabled(false);
                break;

            case R.id.b10:
                if(PLAYER_X){
                    b10.setText("X");
                    boardStatus[1][0] = 1;
                }
                else{
                    b10.setText("0");
                    boardStatus[1][0] = 0;
                }
                b10.setEnabled(false);
                break;

            case R.id.b11:
                if(PLAYER_X){
                    b11.setText("X");
                    boardStatus[1][1] = 1;
                }
                else{
                    b11.setText("0");
                    boardStatus[1][1] = 0;
                }
                b11.setEnabled(false);
                break;

            case R.id.b12:
                if(PLAYER_X){
                    b12.setText("X");
                    boardStatus[1][2] = 1;
                }
                else{
                    b12.setText("0");
                    boardStatus[1][2] = 0;
                }
                b12.setEnabled(false);
                break;

            case R.id.b20:
                if(PLAYER_X){
                    b20.setText("X");
                    boardStatus[2][0] = 1;
                }
                else{
                    b20.setText("0");
                    boardStatus[2][0] = 0;
                }
                b20.setEnabled(false);
                break;

            case R.id.b21:
                if(PLAYER_X){
                    b21.setText("X");
                    boardStatus[2][1] = 1;
                }
                else{
                    b21.setText("0");
                    boardStatus[2][1] = 0;
                }
                b21.setEnabled(false);
                break;

            case R.id.b22:
                if(PLAYER_X){
                    b22.setText("X");
                    boardStatus[2][2] = 1;
                }
                else{
                    b22.setText("0");
                    boardStatus[2][2] = 0;
                }
                b22.setEnabled(false);
                break;

            case R.id.bReset:
                resetButtonPressed = true;
                break;

            default:
                break;

        }

        if(resetButtonPressed){
            resetBoard();
        }
        else{
            TURN_COUNT ++;
            PLAYER_X = !PLAYER_X;

            if(PLAYER_X){
                setInfo("Player X turn");
            }
            else {
                setInfo("Player 0 turn");
            }

            if(TURN_COUNT==9){
                result("Game Draw");
            }

            checkWinner();
        }
    }
}
