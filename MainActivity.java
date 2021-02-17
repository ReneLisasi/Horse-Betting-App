package com.example.horsetrackbetting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
/*author: RLisasi
* link to video: https://youtu.be/HYWVc_sEhdY
* or channel: RL7_slimkat video name: android project cist2381 horsetrack betting game*/
public class MainActivity extends AppCompatActivity {
    Button btnBet1;
    Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   //properties
    btnBet1 = (Button) findViewById(R.id.btnBet1);
    btnExit = (Button) findViewById(R.id.btnExit);
        //send user to listView
        btnBet1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vBet) {
                startActivity(new Intent(MainActivity.this, SelectingActivity.class));
            }
        });

        //exit button listener
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }
}