package com.example.horsetrackbetting;
/*author: RLisasi*/
public class Account {
    //properties
    public int balance=0;
    public int betAmount=0;
    public int payout=0;
    public int goal=0;

    //empty constructor
    public Account(){
        balance= 0;
        betAmount = 1;
        payout =0;
        goal =0;
    }

    //constructor that passes 4
    public Account(int bal, int bet, int pay, int gol){
        balance= bal;
        betAmount = bet;
        payout = pay;
        goal= gol;
    }
    //create default account
    static Account defaultAccount = new Account(50000, 1000, 1359, 320000);

    //getters
    public int getBalance() { return balance; }
    public int getBetAmount() { return betAmount; }
    public int getPayout() { return payout; }
    public int getGoal() { return goal; }

    //setters
    public void setBalance(int balance) { this.balance = balance; }
    public void setBetAmount(int betAmount) { this.betAmount = betAmount; }
    public void setPayout(int payout) { this.payout = payout; }
    public void setGoal(int goal) { this.goal = goal; }
}
