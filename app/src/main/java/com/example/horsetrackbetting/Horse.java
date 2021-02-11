package com.example.horsetrackbetting;

public class Horse {
    //properties
    public String horseName;
    private String horseColor;
    public int horseNumber;
    public int horseOdds;

    //empty constructor
    public Horse(){
        horseName = null;
        horseNumber = 0;
        horseOdds =0;
    }

    //constructor that passes 3
    public Horse(String name, int number, int odds){
        horseName= name;
        horseNumber = number;
        horseOdds= odds;
    }

    //display
    //display horseName + horseNumber + horseOdds
    //create 6 horses
    static Horse Tenpenny = new Horse("Tenpenny", 1, 10);
    static Horse WageOfConsent = new Horse("Wage of Consent", 2, 18);
    static Horse Beetlejuice = new Horse("Beetlejuice", 3, 36);
    static Horse MinimumWagers = new Horse("Minimum Wagers", 4, 3);
    static Horse MaryJohn = new Horse("Mary John", 5, 42);
    static Horse StepBro = new Horse("Step Bro", 6, 6);

    //getters
    public String getHorseName(){
        return horseName;
    }
    public int getHorseNumber(){
        return horseNumber;
    }
    public int getHorseOdds(){
        return horseOdds;
    }
    public String getAll(){return horseNumber+ ". " + horseName + "\n"+ horseOdds + "/1 \n";}

    //setters
    public void setHorseName(String name){
        horseName = name;
    }
    public void setHorseNumber(int number){
        horseNumber= number;
    }
    public void setHorseOdds(int odds){
        horseOdds= odds;
    }
}
