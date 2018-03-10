package com.example.android.scorekeeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.scorekeeper.R.string.winner;

public class MainActivity extends AppCompatActivity {

 int scoreTeamA=0;
    int scoreTeamB=0;
    int wicketA=0;
    int wicketB=0;
    String winner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void displayForTeamA(int score) {

        TextView scoreView = (TextView) findViewById(R.id.textView3);

        scoreView.setText(String.valueOf(score)+"/");



    }
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.textView5);
        scoreView.setText(String.valueOf(score)+"/");
    }
    public void addSixForTeamA(View v){
        scoreTeamA=scoreTeamA+6;
        displayForTeamA(scoreTeamA);
    }
    public void displayForTeamAout(int wicket){
        TextView scoreout=(TextView)findViewById(R.id.textView4);
        scoreout.setText(String.valueOf(wicket));
    }
    public void displayForTeamBout(int wicket){
        TextView scoreout=(TextView)findViewById(R.id.textView6);
        scoreout.setText(String.valueOf(wicket));
    }
    public void addFourForTeamA(View v){
        scoreTeamA=scoreTeamA+4;
        displayForTeamA(scoreTeamA);

    }
    public void addOneForTeamA(View v){
        if(wicketA>=10){
            Toast.makeText(getApplicationContext(),"All are out!",Toast.LENGTH_SHORT).show();
        }
        else{
            wicketA=wicketA+1;
            displayForTeamAout(wicketA);
        }



    }
    public void addSixForTeamB(View v){
        scoreTeamB=scoreTeamB+6;
        displayForTeamB(scoreTeamB);
    }
    public void addFourForTeamB(View v){
        scoreTeamB=scoreTeamB+4;
        displayForTeamB(scoreTeamB);

    }
    public void addOneForTeamB(View v){
        if(wicketB>=10){
            Toast.makeText(getApplicationContext(),"All are out!",Toast.LENGTH_SHORT).show();
        }
        else
        {
            wicketB=wicketB+1;
            displayForTeamBout(wicketB);
        }


    }

    public void reset(View v){
        scoreTeamA=-0;
        scoreTeamB=0;
        wicketB=0;
        wicketA=0;

        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayForTeamAout(wicketA);
        displayForTeamBout(wicketB);

        TextView winner=(TextView)findViewById(R.id.textView7);
        winner.setText(""+"");

    }

    public void share(View v){
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = winner+" is the winner!";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Winner of the game");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

    public void winner(View v){
        if(scoreTeamA>scoreTeamB){
            winner="INDIA";
            TextView winner=(TextView)findViewById(R.id.textView7);
            winner.setText(""+"INDIA won the match.");


        }
        else if(scoreTeamB>scoreTeamA){
            winner="SA";
            TextView winner=(TextView)findViewById(R.id.textView7);
            winner.setText(""+"SA won the match.");

        }
        else{
            winner="No team";
            TextView winner=(TextView)findViewById(R.id.textView7);
            winner.setText(""+"It's a tie!");

        }
    }

}
