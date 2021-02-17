package com.example.horsetrackbetting;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;
/*author: RLisasi*/
public class RacingActivity extends AppCompatActivity {
//properties
    int choice=0;
    int rWinner=0;
    ImageView imgRace;
    Button btnBet3;
    Button btnExit;
    int newGoal;
    int newBalance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_racing);
        //declare all images
        int images[] = {R.drawable.win1, R.drawable.win2, R.drawable.win3, R.drawable.win4, R.drawable.win5, R.drawable.win6};
        imgRace = (ImageView) findViewById(R.id.imgRace);
        //get horse values from betting activity to be used here
        choice = SelectingActivity.getSelectionNumber();
        rWinner = BettingActivity.getWinner();
        //set views
        TextView txtResult = (TextView) findViewById(R.id.txtResult);
        TextView txtRes = (TextView) findViewById(R.id.txtRes) ;
        txtRes.setText( "Winning Horse: "+Integer.toString(rWinner));
        //get account values
        newBalance = Account.defaultAccount.getBalance();
        newGoal = Account.defaultAccount.getGoal();
        //set a new goal until 2M or else show balance
        if (newBalance >= newGoal && newGoal < 5000000) {
            newGoal = newGoal + 100000;
            txtResult.setText("Good job, you reached the goal, new goal set to:"+ newGoal);
            Account.defaultAccount.setGoal(newGoal);
            //new difficulty if you reach 2M
            if ( newBalance > 5000000){
                txtResult.setText("Fantastic, you made over 2M , you beat the game!");
                Account.defaultAccount.setGoal(5000000);
                Account.defaultAccount.setBalance(10000);
            }
        }else {
            txtResult.setText("Balance: " + Account.defaultAccount.getBalance());
        }
        //display the image for the winning horse
        switch (rWinner){
            case 1:
                imgRace.setImageResource(images[0]);
                break;
            case 2:
                imgRace.setImageResource(images[1]);
                break;
            case 3:
                imgRace.setImageResource(images[2]);
                break;
            case 4:
                imgRace.setImageResource(images[3]);
                break;
            case 5:
                imgRace.setImageResource(images[4]);
                break;
            case 6:
                imgRace.setImageResource(images[5]);
                break;
        }
        //properties
        btnBet3 = (Button) findViewById(R.id.btnBet3);
        btnExit = (Button) findViewById(R.id.btnExit);
        //send user to listView
        btnBet3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vBet) {
                startActivity(new Intent(RacingActivity.this, SelectingActivity.class));
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