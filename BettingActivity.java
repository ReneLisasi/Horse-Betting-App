package com.example.horsetrackbetting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
/*author: RLisasi
* this is where the action takes place
*/
public class BettingActivity extends AppCompatActivity implements View.OnClickListener {
//properties
    TextView txtHorseNumber;
    TextView txtHorseName;
    TextView txtHorseOdds;
    TextView txtBalance;
    Button btnLess;
    TextView txtBetAmount;
    Button btnMore;
    TextView txtPayout;
    TextView txtGoal;
    Button btnBet2;
    Button btnCancel;
    Horse selectedHorse;
    Account selectedAccount;
    int displayHorseNumber = 0;
    String displayHorseName=null;
    int displayHorseOdds=0;
    int displayAccountBalance;
    int displayAccountBetAmount=100;
    int displayAccountPayout;
    int displayAccountGoal;
    Random rnd;
    int noob;
    static int winner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_betting);
        //bala = (bala - displayAccountBetAmount);
      doAll();
    }
    //get values from other activities
    public void getSelection(){
        //get horse selection from selecting activity
        displayHorseNumber = SelectingActivity.getSelectionNumber();
        displayHorseName = SelectingActivity.getSelectionName();
        displayHorseOdds = SelectingActivity.getSelectionOdds();
        //get account values
        displayAccountBalance = Account.defaultAccount.getBalance();
        displayAccountBetAmount = Account.defaultAccount.getBetAmount();
        displayAccountPayout = Account.defaultAccount.getPayout() * displayHorseOdds;
        displayAccountGoal = Account.defaultAccount.getGoal();
    }
    //instantiate new objects here
    public void CreateHorse(){
        //new horse
        selectedHorse = new Horse(displayHorseName, displayHorseNumber , displayHorseOdds);
        //create default account
        selectedAccount = new Account(displayAccountBalance,displayAccountBetAmount, displayAccountPayout, displayAccountGoal);
    }

    //attach variables to xml
    public void findViews(){
        txtHorseNumber = (TextView) findViewById(R.id.txtHorseNumber);
        txtHorseName = (TextView) findViewById(R.id.txtHorseName);
        txtHorseOdds = (TextView) findViewById(R.id.txtHorseOdds);
        txtBalance = (TextView) findViewById(R.id.txtBalance);
        txtBetAmount = (TextView) findViewById(R.id.txtBetAmount);
        txtPayout = (TextView) findViewById(R.id.txtPayout);
        txtGoal = (TextView) findViewById(R.id.txtGoal);
        btnLess = (Button) findViewById(R.id.btnBetLess);
        btnMore = (Button) findViewById(R.id.btnBetMore);
        btnBet2 = (Button) findViewById(R.id.btnBet2);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        //set listeners for all buttons
        btnLess.setOnClickListener(this);
        btnMore.setOnClickListener(this);
        btnBet2.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }
    //set text values to new horse
    public void setTxt(){
        txtHorseNumber.setText(Integer.toString(selectedHorse.horseNumber));
        txtHorseName.setText(selectedHorse.horseName);
        txtHorseOdds.setText(Integer.toString(selectedHorse.horseOdds)+"/1");
        txtBalance.setText(Integer.toString(displayAccountBalance-displayAccountBetAmount));
        txtBetAmount.setText(Integer.toString(displayAccountBetAmount));
        txtPayout.setText(Integer.toString(displayAccountPayout));
        txtGoal.setText(Integer.toString(displayAccountGoal));
    }

    public int calculateLess(){
        //when you click the bet amount and payout decrease
        int bala2 = displayAccountBalance;
        //if statement here
        if (displayAccountBalance > 0 && displayAccountBetAmount >50) {
            displayAccountBetAmount -= 100;
            displayAccountPayout = displayAccountBetAmount * displayHorseOdds;
            bala2 = (bala2 - displayAccountBetAmount);
            txtBalance.setText(Integer.toString(bala2));
        }else{
            Toast.makeText(this, "You can't go lower than 0", Toast.LENGTH_SHORT).show();
        }
        setTxt();
        txtBalance.setText(Integer.toString(bala2));
        //try to return bala2 to
        return bala2;
    }


    private void calculateMore() {
        //when you click the bet amount and payout increase
        int bala = displayAccountBalance;
        //if statement here
        if (displayAccountBalance > displayAccountBetAmount && bala >0) {
            displayAccountBetAmount += 100;
            displayAccountPayout = displayAccountBetAmount * displayHorseOdds;
            bala = (bala - displayAccountBetAmount);
        }else{
            Toast.makeText(this, "You can't go higher", Toast.LENGTH_SHORT).show();
        }
        setTxt();
        txtBalance.setText(Integer.toString(bala));
    }

    //do everything
    private void doAll(){
        getSelection();
        CreateHorse();
        findViews();
        setTxt();

    }
    //default method for handling all Onclick events
    @Override
    public void onClick(View v) {
        //find buttons by id and implement code
        switch (v.getId()){
            case R.id.btnBetLess:
            //handle less
                noob = calculateLess();
                break;
            case R.id.btnBetMore:
                //handle more
                calculateMore();
                break;
            case R.id.btnBet2:
                //handle bet
                //Add if statement for must bet > 0
                    winner = getRandom();
                if (winner == displayHorseNumber){
                    displayAccountBalance = displayAccountBalance + displayAccountPayout;
                    Account.defaultAccount.setBalance(displayAccountBalance);
                    Toast.makeText(this, "You won "+ displayAccountPayout + "Your bal is"+ displayAccountBalance, Toast.LENGTH_SHORT).show();
                }else{
                    displayAccountBalance = displayAccountBalance - displayAccountBetAmount;
                    Account.defaultAccount.setBalance(displayAccountBalance);
                    Toast.makeText(this, "You lost "+ displayAccountBetAmount+ "Your bal is"+ displayAccountBalance, Toast.LENGTH_SHORT).show();
                }
                setTxt();
                Intent Racing = new Intent(BettingActivity.this, RacingActivity.class);
                startActivity(Racing);
                break;
            case R.id.btnCancel:
                //handle cancel
                super.onBackPressed();
                break;
        }
    }

    public static int getWinner(){
        return winner;
    }
//generate a random number
    public int getRandom(){
        /*because this is a horse betting app odds should play a factor in the outcome of the winning horse
        I did not have time to add this and didn't want to risk any last minute breakdowns but this is where it would go*/
        rnd = new Random();
        int rand = (rnd.nextInt(6)+1);
        return rand;
    }
}