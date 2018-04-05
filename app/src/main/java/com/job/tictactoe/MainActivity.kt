package com.job.tictactoe

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick

class MainActivity : AppCompatActivity() {


    @BindView(R.id.main_player1) val btnPlayer1 : Button? = null
    @BindView(R.id.main_player2) val btnPlayer2 : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ButterKnife.bind(this)

    }

    @OnClick(R.id.main_player1)
    public fun player1Click(){
        val longGameIntent = Intent(this@MainActivity, LongGameActivity::class.java)
        longGameIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(longGameIntent)
        finish()
    }

    @OnClick(R.id.main_player2)
    public fun player2Click(){
        val shortGameIntent = Intent(this@MainActivity, GameActivity::class.java)
        shortGameIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(shortGameIntent)
        finish()
    }
}
