package com.example.horsetrackbetting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SelectingActivity extends AppCompatActivity {
    ListView horseListView;

    static int selectionNumber=0;
    static String selectionName;
    static int selectionOdds;

    //new method for getting the selection
    public static int getSelectionNumber(){ return selectionNumber;}
    public static String getSelectionName(){ return selectionName;}
    public static int getSelectionOdds(){ return selectionOdds;}
    //setter for storing selection
    public void setSelectionNumber(int selection) { this.selectionNumber = selection;}
    public void setSelectionName(String selectionNam){selectionName = selectionNam;}
    public void setSelectionOdds(int selectionOdd){selectionOdds = selectionOdd;}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecting);

        horseListView = (ListView) findViewById(R.id.horseListView);
        final ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(Horse.Tenpenny.getAll());
        arrayList.add(Horse.WageOfConsent.getAll());
        arrayList.add(Horse.Beetlejuice.getAll());
        arrayList.add(Horse.MinimumWagers.getAll());
        arrayList.add(Horse.MaryJohn.getAll());
        arrayList.add(Horse.StepBro.getAll());

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        horseListView.setAdapter(arrayAdapter);
        horseListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SelectingActivity.this,"You chose "+(position +1)+" "+arrayList.get(position).toString(),Toast.LENGTH_SHORT).show();
                //store selection
                switch (position) {
                    case 0:
                        setSelectionNumber(1);
                        setSelectionName(Horse.Tenpenny.horseName);
                        setSelectionOdds(Horse.Tenpenny.horseOdds);
                        break;
                    case 1:
                        setSelectionNumber(2);
                        setSelectionName(Horse.WageOfConsent.horseName);
                        setSelectionOdds(Horse.WageOfConsent.horseOdds);
                        break;
                    case 2:
                        setSelectionNumber(3);
                        setSelectionName(Horse.Beetlejuice.horseName);
                        setSelectionOdds(Horse.Beetlejuice.horseOdds);
                        break;
                    case 3:
                        setSelectionNumber(4);
                        setSelectionName(Horse.MinimumWagers.horseName);
                        setSelectionOdds(Horse.MinimumWagers.horseOdds);

                        break;
                    case 4:
                        setSelectionNumber(5);
                        setSelectionName(Horse.MaryJohn.horseName);
                        setSelectionOdds(Horse.MaryJohn.horseOdds);
                        break;
                    case 5:
                        setSelectionNumber(6);
                        setSelectionName(Horse.StepBro.horseName);
                        setSelectionOdds(Horse.StepBro.horseOdds);
                        break;
                }
                //open betting activity on all item click
                Intent Betting = new Intent(SelectingActivity.this, BettingActivity.class);
                startActivity(Betting);
            }
        });
    }
}