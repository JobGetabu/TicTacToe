package com.job.tictactoe

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {


     private var btnPlayer1 : Button? = null
     private var btnPlayer2 : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPlayer1 = findViewById(R.id.main_player1);
        btnPlayer2 = findViewById(R.id.main_player2);

        btnPlayer1?.setOnClickListener { view -> player1Click(view) }
        btnPlayer2?.setOnClickListener { view -> player2Click(view) }

    }


    private fun player1Click(view : View){

        //TODO carry boolean is 1 player
        val shortGameIntent = Intent(this@MainActivity, GameActivity::class.java)
        shortGameIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(shortGameIntent)
       /* val longGameIntent = Intent(this@MainActivity, LongGameActivity::class.java)
        longGameIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(longGameIntent)*/
    }


    private fun player2Click(view : View){
        //TODO carry boolean is 1 player
        val shortGameIntent = Intent(this@MainActivity, GameActivity::class.java)
        shortGameIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(shortGameIntent)
    }
}
