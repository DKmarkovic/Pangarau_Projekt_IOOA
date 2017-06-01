package com.dms.pangarau;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
   //zbrajanje i odbrojavanje

    Operacija operacija;
    Button startsum;
    Button BackSum;
    ArrayList<Integer> odgovori = new ArrayList<Integer>();
    int lokacijaTocnog;
    int bodovi=0;
    TextView result;
    int brojPitanja=0;
    TextView bodoviScreen;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView sumTextView;
    TextView timerTextView;
    Button playAgainButton;
    RelativeLayout relativLayout;
    RelativeLayout relativeLayoutTopscore;
    Button backMode;
    Button ButtonEasy;
    Button ButtonMedium;
    Button ButtonHard;
   //varijable za utjecanje na vrijednostima
    int c=0;
    int d=0;
    int e=0;
    int f=0;
    int dijeljenjeF=0;
    int oduzimanjeA=0;
    int OduzimanjeB=0;
    int netocniZbroj=0;
    int netocnoOduzimanje=0;
    int netocanMnozenje=0;

    //varijable
//izbornik povratak
    public void BackMode (View view){
        starttopScore.setVisibility(View.INVISIBLE);
        startsub.setVisibility(View.INVISIBLE);
        startsum.setVisibility(View.INVISIBLE);
        startmulti.setVisibility(View.INVISIBLE);
        startdiv.setVisibility(View.INVISIBLE);
        backMode.setVisibility(View.INVISIBLE);
        ButtonEasy.setVisibility(View.VISIBLE);
        ButtonMedium.setVisibility(View.VISIBLE);
        ButtonHard.setVisibility(View.VISIBLE);
    }
//izbornik easy mode
    public void ButtonEasyMode (View view){
        starttopScore.setVisibility(View.VISIBLE);
        startsub.setVisibility(View.VISIBLE);
        startsum.setVisibility(View.VISIBLE);
        startmulti.setVisibility(View.VISIBLE);
        startdiv.setVisibility(View.VISIBLE);
        backMode.setVisibility(View.VISIBLE);
        ButtonEasy.setVisibility(View.INVISIBLE);
        ButtonMedium.setVisibility(View.INVISIBLE);
        ButtonHard.setVisibility(View.INVISIBLE);
//utjecaj na varijable nakon klika
        if(this.ButtonEasy.isPressed()){
            c=21;
            d=21;
            e=6;
            f=6;
            dijeljenjeF=5;
            oduzimanjeA=51;
            OduzimanjeB=51;
            netocniZbroj=41;
            netocnoOduzimanje=51;
            netocanMnozenje=25;
        }

    }
//izbornik medium mode
    public void ButtonMediumMode (View view){
        starttopScore.setVisibility(View.VISIBLE);
        startsub.setVisibility(View.VISIBLE);
        startsum.setVisibility(View.VISIBLE);
        startmulti.setVisibility(View.VISIBLE);
        startdiv.setVisibility(View.VISIBLE);
        backMode.setVisibility(View.VISIBLE);
        ButtonEasy.setVisibility(View.INVISIBLE);
        ButtonMedium.setVisibility(View.INVISIBLE);
        ButtonHard.setVisibility(View.INVISIBLE);
//utjecaj na varijable nakon klika
        if(this.ButtonMedium.isPressed()){
            c=51;
            d=51;
            e=11;
            f=11;
            dijeljenjeF=10;
            oduzimanjeA=101;
            OduzimanjeB=101;
            netocniZbroj=101;
            netocnoOduzimanje=101;
            netocanMnozenje=101;
        }
    }
//izbornik hard mode
    public void ButtonHardMode (View view){
        starttopScore.setVisibility(View.VISIBLE);
        startsub.setVisibility(View.VISIBLE);
        startsum.setVisibility(View.VISIBLE);
        startmulti.setVisibility(View.VISIBLE);
        startdiv.setVisibility(View.VISIBLE);
        backMode.setVisibility(View.VISIBLE);
        ButtonEasy.setVisibility(View.INVISIBLE);
        ButtonMedium.setVisibility(View.INVISIBLE);
        ButtonHard.setVisibility(View.INVISIBLE);
//utjecaj na varijable nakon klika
        if(this.ButtonHard.isPressed()){
            c=101;
            d=101;
            e=21;
            f=21;
            dijeljenjeF=20;
            oduzimanjeA=201;
            OduzimanjeB=201;
            netocniZbroj=201;
            netocnoOduzimanje=201;
            netocanMnozenje=401;
        }
    }

    public void Back (View view){

        starttopScore.setVisibility(View.VISIBLE);
        startsub.setVisibility(View.VISIBLE);
        startsum.setVisibility(View.VISIBLE);
        startmulti.setVisibility(View.VISIBLE);
        startdiv.setVisibility(View.VISIBLE);
        relativLayoutSub.setVisibility(RelativeLayout.INVISIBLE);
        relativLayout.setVisibility(RelativeLayout.INVISIBLE);
        relativLayoutMulti.setVisibility(RelativeLayout.INVISIBLE);
        relativLayoutDiv.setVisibility(RelativeLayout.INVISIBLE);
        relativeLayoutTopscore.setVisibility(RelativeLayout.INVISIBLE);
        backMode.setVisibility(View.VISIBLE);
    }







    public void playAgain(final View view){//playAgain metoda povezana sa gumbom za igranje ispocetka
//play again za zbrajanje
           bodovi = 0;
           brojPitanja = 0;
           timerTextView.setText("30s");
           bodoviScreen.setText("0/0");
           result.setText("");
           playAgainButton.setVisibility(View.INVISIBLE);
           pitanja();
           button0.setVisibility(View.VISIBLE);
           button1.setVisibility(View.VISIBLE);
           button2.setVisibility(View.VISIBLE);
           button3.setVisibility(View.VISIBLE);

        //playAgain za oduzimanje
           bodoviSub = 0;
           brojPitanjaSub = 0;
           timerTextViewSub.setText("30s");
           bodoviScreenSub.setText("0/0");
           resultSub.setText("");
           playAgainButtonSub.setVisibility(View.INVISIBLE);
           pitanjaSub();
           button0Sub.setVisibility(View.VISIBLE);
           button1Sub.setVisibility(View.VISIBLE);
           button2Sub.setVisibility(View.VISIBLE);
           button3Sub.setVisibility(View.VISIBLE);

        //playAgain za multi/mnozenje
           bodoviMulti = 0;
           brojPitanjaMulti = 0;
           timerTextViewMulti.setText("30s");
           bodoviScreenMulti.setText("0/0");
           resultMulti.setText("");
           playAgainButtonMulti.setVisibility(View.INVISIBLE);
           pitanjaMulti();
           button0Multi.setVisibility(View.VISIBLE);
           button1Multi.setVisibility(View.VISIBLE);
           button2Multi.setVisibility(View.VISIBLE);
           button3Multi.setVisibility(View.VISIBLE);


           //playAgain za dijeljenje
           bodoviDiv = 0;
           brojPitanjaDiv = 0;
           timerTextViewDiv.setText("30s");
           bodoviScreenDiv.setText("0/0");
           resultDiv.setText("");
           playAgainButtonDiv.setVisibility(View.INVISIBLE);
           pitanjaDiv();
           button0Div.setVisibility(View.VISIBLE);
           button1Div.setVisibility(View.VISIBLE);
           button2Div.setVisibility(View.VISIBLE);
           button3Div.setVisibility(View.VISIBLE);

        BackSum.setVisibility(View.INVISIBLE);
        BackSub.setVisibility(View.INVISIBLE);
        BackMulti.setVisibility(View.INVISIBLE);
        BackDiv.setVisibility(View.INVISIBLE);

        new CountDownTimer(30100, 1000) {//timer koji zavrsava igru u roku 30 sekundi
            @Override
            public void onTick(long millisUntilFinished) {

                timerTextView.setText(String.valueOf(millisUntilFinished / 1000) + "s");
                //oduzimanje
                timerTextViewSub.setText(String.valueOf(millisUntilFinished / 1000) + "s");
                //mnozenje
                timerTextViewMulti.setText(String.valueOf(millisUntilFinished / 1000) + "s");
                //dijeljenje
                timerTextViewDiv.setText(String.valueOf(millisUntilFinished / 1000) + "s");
            }

            @Override
            public void onFinish() {//izvedba nakon 30 sekundi tj. zavrestak igre
                timerTextView.setText("0s");
                result.setText("Score: " + Integer.toString(bodovi)+ " / "+ Integer.toString(brojPitanja));
                button0.setVisibility(View.INVISIBLE);
                button1.setVisibility(View.INVISIBLE);
                button2.setVisibility(View.INVISIBLE);
                button3.setVisibility(View.INVISIBLE);
                playAgainButton.setVisibility(View.VISIBLE);
                BackSum.setVisibility(View.VISIBLE);
                //oduzimanje
                timerTextViewSub.setText("0s");
                resultSub.setText("Score: " + Integer.toString(bodoviSub)+ " / "+ Integer.toString(brojPitanjaSub));
                button0Sub.setVisibility(View.INVISIBLE);
                button1Sub.setVisibility(View.INVISIBLE);
                button2Sub.setVisibility(View.INVISIBLE);
                button3Sub.setVisibility(View.INVISIBLE);
                playAgainButtonSub.setVisibility(View.VISIBLE);
                BackSub.setVisibility(View.VISIBLE);
                //mnozenje
                timerTextViewMulti.setText("0s");
                resultMulti.setText("Score: " + Integer.toString(bodoviMulti)+ " / "+ Integer.toString(brojPitanjaMulti));
                button0Multi.setVisibility(View.INVISIBLE);
                button1Multi.setVisibility(View.INVISIBLE);
                button2Multi.setVisibility(View.INVISIBLE);
                button3Multi.setVisibility(View.INVISIBLE);
                playAgainButtonMulti.setVisibility(View.VISIBLE);
                BackMulti.setVisibility(View.VISIBLE);
                //dijeljenje
                timerTextViewDiv.setText("0s");
                resultDiv.setText("Score: " + Integer.toString(bodoviDiv)+ " / "+ Integer.toString(brojPitanjaDiv));
                button0Div.setVisibility(View.INVISIBLE);
                button1Div.setVisibility(View.INVISIBLE);
                button2Div.setVisibility(View.INVISIBLE);
                button3Div.setVisibility(View.INVISIBLE);
                playAgainButtonDiv.setVisibility(View.VISIBLE);
                BackDiv.setVisibility(View.VISIBLE);
                TopScore();
            }
        }.start();

    }
    public void pitanja(){//metoda pitanja stvara nova pitanja korisniku
        Random rand = new Random();

            int a = rand.nextInt(c);
            int b = rand.nextInt(d);

        int netocanOdgovor;

        sumTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));
        odgovori.clear();

        lokacijaTocnog = rand.nextInt(4);
        for(int i=0; i<4; i++){

            if(i == lokacijaTocnog ){

                odgovori.add(a + b);
            }
            else{
                netocanOdgovor = rand.nextInt(netocniZbroj);
                while(netocanOdgovor == a+b){
                    netocanOdgovor = rand.nextInt(netocniZbroj);
                }
                odgovori.add(netocanOdgovor);
            }

        }

        button0.setText(Integer.toString(odgovori.get(0)));
        button1.setText(Integer.toString(odgovori.get(1)));
        button2.setText(Integer.toString(odgovori.get(2)));
        button3.setText(Integer.toString(odgovori.get(3)));
    }

    public void odgovor(View view){

        if(view.getTag().toString().equals(Integer.toString(lokacijaTocnog))){

            bodovi++;
            result.setText("Nice!!");
        }
        else{
            result.setText(":(");
        }
        brojPitanja++;
        bodoviScreen.setText(Integer.toString(bodovi)+ " / "+ Integer.toString(brojPitanja));
        pitanja();
    }

    public void StartSum (View view){
        playAgain(findViewById(R.id.StartsumButton));
        startsum.setVisibility(View.INVISIBLE);
        startsub.setVisibility(View.INVISIBLE);
        startdiv.setVisibility(View.INVISIBLE);
        startmulti.setVisibility(View.INVISIBLE);
        BackSum.setVisibility(View.INVISIBLE);
        BackSub.setVisibility(View.INVISIBLE);
        BackMulti.setVisibility(View.INVISIBLE);
        BackDiv.setVisibility(View.INVISIBLE);
        starttopScore.setVisibility(View.INVISIBLE);
        backMode.setVisibility(View.INVISIBLE);
        relativLayout.setVisibility(RelativeLayout.VISIBLE);
        playAgain(findViewById(R.id.playAgainButton));
    }
    //pocetak oduzimanja

    Button startsub;
    Button BackSub;
    ArrayList<Integer> odgovoriSub = new ArrayList<Integer>();
    int lokacijaTocnogSub;
    int bodoviSub=0;
    TextView resultSub;
    int brojPitanjaSub=0;
    TextView bodoviScreenSub;
    Button button0Sub;
    Button button1Sub;
    Button button2Sub;
    Button button3Sub;
    TextView SubTextView;
    TextView timerTextViewSub;
    Button playAgainButtonSub;
    RelativeLayout relativLayoutSub;
    //varijable


    public void pitanjaSub() {//metoda pitanja stvara nova pitanja korisniku

        Random rand = new Random();

        int a = rand.nextInt(oduzimanjeA);
        int b = rand.nextInt(OduzimanjeB);
        int netocanOdgovorSub;



        odgovoriSub.clear();


      while(a<b){

         b = rand.nextInt(OduzimanjeB);

      } SubTextView.setText(Integer.toString(a) + " - " + Integer.toString(b));
           lokacijaTocnogSub = rand.nextInt(4);
            for (int i = 0; i < 4; i++) {

                if (i == lokacijaTocnogSub) {

                    odgovoriSub.add(a - b);
                } else {
                    netocanOdgovorSub = rand.nextInt(netocnoOduzimanje);
                    while (netocanOdgovorSub == a - b) {
                        netocanOdgovorSub = rand.nextInt(netocnoOduzimanje);
                    }
                    odgovoriSub.add(netocanOdgovorSub);
                }

            }


            button0Sub.setText(Integer.toString(odgovoriSub.get(0)));
            button1Sub.setText(Integer.toString(odgovoriSub.get(1)));
            button2Sub.setText(Integer.toString(odgovoriSub.get(2)));
            button3Sub.setText(Integer.toString(odgovoriSub.get(3)));
        }


    public void odgovorSub(View view){

        if(view.getTag().toString().equals(Integer.toString(lokacijaTocnogSub))){

            bodoviSub++;
            resultSub.setText("Nice!!");
        }
        else{
            resultSub.setText(":(");
        }
        brojPitanjaSub++;
        bodoviScreenSub.setText(Integer.toString(bodoviSub)+ " / "+ Integer.toString(brojPitanjaSub));
        pitanjaSub();
    }

    public void StartSub (View view){

        playAgain(findViewById(R.id.StartSubButton));
        startsub.setVisibility(View.INVISIBLE);
        startsum.setVisibility(View.INVISIBLE);
        startdiv.setVisibility(View.INVISIBLE);
        startmulti.setVisibility(View.INVISIBLE);
        BackSum.setVisibility(View.INVISIBLE);
        BackSub.setVisibility(View.INVISIBLE);
        BackMulti.setVisibility(View.INVISIBLE);
        BackDiv.setVisibility(View.INVISIBLE);
        starttopScore.setVisibility(View.INVISIBLE);
        backMode.setVisibility(View.INVISIBLE);
        relativLayoutSub.setVisibility(RelativeLayout.VISIBLE);
        playAgain(findViewById(R.id.playAgainButtonSub));

    }
//mnozenje


    Button startmulti;
    Button BackMulti;
    ArrayList<Integer> odgovoriMulti = new ArrayList<Integer>();
    int lokacijaTocnogMulti;
    int bodoviMulti=0;
    TextView resultMulti;
    int brojPitanjaMulti=0;
    TextView bodoviScreenMulti;
    Button button0Multi;
    Button button1Multi;
    Button button2Multi;
    Button button3Multi;
    TextView MultiTextView;
    TextView timerTextViewMulti;
    Button playAgainButtonMulti;
    RelativeLayout relativLayoutMulti;

    public void pitanjaMulti(){//metoda pitanja stvara nova pitanja korisniku

        Random rand = new Random();

        int a= rand.nextInt(e);
        int b= rand.nextInt(f);
        int netocanOdgovorMulti;

        MultiTextView.setText(Integer.toString(a) + " * " + Integer.toString(b));
        odgovoriMulti.clear();

        lokacijaTocnogMulti = rand.nextInt(4);
        for(int i=0; i<4; i++){

            if(i == lokacijaTocnogMulti ){

                odgovoriMulti.add(a * b);
            }
            else{
                netocanOdgovorMulti = rand.nextInt(netocanMnozenje);
                while(netocanOdgovorMulti == a*b){
                    netocanOdgovorMulti = rand.nextInt(netocanMnozenje);
                }
                odgovoriMulti.add(netocanOdgovorMulti);
            }

        }

        button0Multi.setText(Integer.toString(odgovoriMulti.get(0)));
        button1Multi.setText(Integer.toString(odgovoriMulti.get(1)));
        button2Multi.setText(Integer.toString(odgovoriMulti.get(2)));
        button3Multi.setText(Integer.toString(odgovoriMulti.get(3)));
    }

    public void odgovorMulti(View view){

        if(view.getTag().toString().equals(Integer.toString(lokacijaTocnogMulti))){

            bodoviMulti++;
            resultMulti.setText("Nice!!");
        }
        else{
            resultMulti.setText(":(");
        }
        brojPitanjaMulti++;
        bodoviScreenMulti.setText(Integer.toString(bodoviMulti)+ " / "+ Integer.toString(brojPitanjaMulti));
        pitanjaMulti();
    }

    public void StartMulti (View view){

        playAgain(findViewById(R.id.StartMultiButton));
        startsum.setVisibility(View.INVISIBLE);
        startsub.setVisibility(View.INVISIBLE);
        startmulti.setVisibility(View.INVISIBLE);
        startdiv.setVisibility(View.INVISIBLE);
        BackSum.setVisibility(View.INVISIBLE);
        BackSub.setVisibility(View.INVISIBLE);
        BackMulti.setVisibility(View.INVISIBLE);
        BackDiv.setVisibility(View.INVISIBLE);
        starttopScore.setVisibility(View.INVISIBLE);
        backMode.setVisibility(View.INVISIBLE);
        relativLayoutMulti.setVisibility(RelativeLayout.VISIBLE);
        playAgain(findViewById(R.id.playAgainButtonMulti));
    }

    //dijeljenje

    Button startdiv;
    Button BackDiv;
    ArrayList<Integer> odgovoriDiv = new ArrayList<Integer>();
    int lokacijaTocnogDiv;
    int bodoviDiv=0;
    TextView resultDiv;
    int brojPitanjaDiv=0;
    TextView bodoviScreenDiv;
    Button button0Div;
    Button button1Div;
    Button button2Div;
    Button button3Div;
    TextView DivTextView;
    TextView timerTextViewDiv;
    Button playAgainButtonDiv;
    RelativeLayout relativLayoutDiv;

    public void pitanjaDiv(){//metoda pitanja stvara nova pitanja korisniku

        Random rand = new Random();

        int a= rand.nextInt(e);
        int b= (rand.nextInt(dijeljenjeF)+1);
        int netocanOdgovorDiv;
        int djeljenik;

        djeljenik = (a * b);
       if(a==0){
           DivTextView.setText(Integer.toString(b) + " : " + Integer.toString(djeljenik));
       }else{
           DivTextView.setText(Integer.toString(djeljenik) + " : " + Integer.toString(b));
       }
        odgovoriDiv.clear();

        lokacijaTocnogDiv = rand.nextInt(4);
        for(int i=0; i<4; i++){

            if(i == lokacijaTocnogDiv ){

                odgovoriDiv.add(a);
            }
            else{
                netocanOdgovorDiv = rand.nextInt(e);
                while(netocanOdgovorDiv == a){
                    netocanOdgovorDiv = rand.nextInt(e);
                }
                odgovoriDiv.add(netocanOdgovorDiv);
            }

        }

        button0Div.setText(Integer.toString(odgovoriDiv.get(0)));
        button1Div.setText(Integer.toString(odgovoriDiv.get(1)));
        button2Div.setText(Integer.toString(odgovoriDiv.get(2)));
        button3Div.setText(Integer.toString(odgovoriDiv.get(3)));
    }

    public void odgovorDiv(View view){

        if(view.getTag().toString().equals(Integer.toString(lokacijaTocnogDiv))){

            bodoviDiv++;
            resultDiv.setText("Nice!!");
        }
        else{
            resultDiv.setText(":(");
        }
        brojPitanjaDiv++;
        bodoviScreenDiv.setText(Integer.toString(bodoviDiv)+ " / "+ Integer.toString(brojPitanjaDiv));
        pitanjaDiv();
    }

    public void StartDiv (View view){

        playAgain(findViewById(R.id.StartDivButton));
        startsum.setVisibility(View.INVISIBLE);
        startsub.setVisibility(View.INVISIBLE);
        startmulti.setVisibility(View.INVISIBLE);
        startdiv.setVisibility(View.INVISIBLE);
        BackSum.setVisibility(View.INVISIBLE);
        BackSub.setVisibility(View.INVISIBLE);
        BackMulti.setVisibility(View.INVISIBLE);
        BackDiv.setVisibility(View.INVISIBLE);
        starttopScore.setVisibility(View.INVISIBLE);
        backMode.setVisibility(View.INVISIBLE);
        relativLayoutDiv.setVisibility(RelativeLayout.VISIBLE);
        playAgain(findViewById(R.id.playAgainButtonDiv));
    }
//storage

    private SharedPreferences preferencesSettings;
    private SharedPreferences.Editor preferenceEditor;
    private static final int PREFERENCE_MODE_PRIVATE = 0;


//top score
    Button starttopScore;
    int topScore=0;
    int topScoreDiv=0;
    int topScoreMulti=0;
    int topScoreSub=0;
    TextView TopScoreSum;
    TextView TopScoreSub;
    TextView TopScoreMulti;
    TextView TopScoreDiv;

    public void TopScore(){
        preferencesSettings = getPreferences(PREFERENCE_MODE_PRIVATE);
        preferenceEditor = preferencesSettings.edit();
        if(topScore<bodovi){
            topScore=bodovi;
        }else if(topScoreSub<bodoviSub){
            topScoreSub=bodoviSub;
        }else if(topScoreDiv<bodoviDiv){
            topScoreDiv=bodoviDiv;
        }else if(topScoreMulti<bodoviMulti){
            topScoreMulti=bodoviMulti;
        }
    preferenceEditor.putInt("topScoreSUM", topScore);
        preferenceEditor.putInt("topScoreSUB", topScoreSub);
        preferenceEditor.putInt("topScoreDIV", topScoreDiv);
        preferenceEditor.putInt("topScoreMULTI", topScoreMulti);
        preferenceEditor.commit();
    }
    public void StartTopScore(View view){
        starttopScore.setVisibility(View.INVISIBLE);
        startsum.setVisibility(View.INVISIBLE);
        startsub.setVisibility(View.INVISIBLE);
        startmulti.setVisibility(View.INVISIBLE);
        startdiv.setVisibility(View.INVISIBLE);
        BackSum.setVisibility(View.INVISIBLE);
        BackSub.setVisibility(View.INVISIBLE);
        BackMulti.setVisibility(View.INVISIBLE);
        BackDiv.setVisibility(View.INVISIBLE);
        backMode.setVisibility(View.INVISIBLE);
        relativeLayoutTopscore.setVisibility(RelativeLayout.VISIBLE);

        preferencesSettings = getPreferences(PREFERENCE_MODE_PRIVATE);

        int topScore = preferencesSettings.getInt("topScoreSUM",1);
        int topScoreSub = preferencesSettings.getInt("topScoreSUB",1);
        int topScoreMulti = preferencesSettings.getInt("topScoreMULTI",1);
        int topScoreDiv = preferencesSettings.getInt("topScoreDIV",1);

        TopScoreSum.setText(Integer.toString(topScore));
        TopScoreSub.setText(Integer.toString(topScoreSub));
        TopScoreMulti.setText(Integer.toString(topScoreMulti));
        TopScoreDiv.setText(Integer.toString(topScoreDiv));

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//zbrajanje
        startsum = (Button)findViewById(R.id.StartsumButton);
        sumTextView = (TextView)findViewById(R.id.sumScreen);
        button0 = (Button)findViewById(R.id.button0);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        result = (TextView)findViewById(R.id.result);
        bodoviScreen = (TextView)findViewById(R.id.scoreScreen);
        timerTextView = (TextView)findViewById(R.id.timerScreen);
        playAgainButton = (Button)findViewById(R.id.playAgainButton);
        relativLayout = (RelativeLayout)findViewById(R.id.relativLayout);
        BackSum = (Button)findViewById(R.id.BackSum);
//oduzimanje
        startsub = (Button)findViewById(R.id.StartSubButton);
        SubTextView = (TextView)findViewById(R.id.subScreen);
        button0Sub = (Button)findViewById(R.id.button0Sub);
        button1Sub = (Button)findViewById(R.id.button1Sub);
        button2Sub = (Button)findViewById(R.id.button2Sub);
        button3Sub = (Button)findViewById(R.id.button3Sub);
        resultSub = (TextView)findViewById(R.id.resultSub);
        bodoviScreenSub = (TextView)findViewById(R.id.scoreScreenSub);
        timerTextViewSub = (TextView)findViewById(R.id.timerScreenSub);
        playAgainButtonSub = (Button)findViewById(R.id.playAgainButtonSub);
        relativLayoutSub = (RelativeLayout)findViewById(R.id.relativLayoutSub);
        BackSub = (Button)findViewById(R.id.BackSub);
//mnozenje
        startmulti = (Button)findViewById(R.id.StartMultiButton);
        MultiTextView = (TextView)findViewById(R.id.MultiScreen);
        button0Multi = (Button)findViewById(R.id.button0Multi);
        button1Multi = (Button)findViewById(R.id.button1Multi);
        button2Multi = (Button)findViewById(R.id.button2Multi);
        button3Multi = (Button)findViewById(R.id.button3Multi);
        resultMulti = (TextView)findViewById(R.id.resultMulti);
        bodoviScreenMulti = (TextView)findViewById(R.id.scoreScreenMulti);
        timerTextViewMulti = (TextView)findViewById(R.id.timerScreenMulti);
        playAgainButtonMulti = (Button)findViewById(R.id.playAgainButtonMulti);
        relativLayoutMulti = (RelativeLayout)findViewById(R.id.relativLayoutMulti);
        BackMulti = (Button)findViewById(R.id.BackMulti);

//dijeljenje
        startdiv = (Button)findViewById(R.id.StartDivButton);
        DivTextView = (TextView)findViewById(R.id.DivScreen);
        button0Div = (Button)findViewById(R.id.button0Div);
        button1Div = (Button)findViewById(R.id.button1Div);
        button2Div = (Button)findViewById(R.id.button2Div);
        button3Div = (Button)findViewById(R.id.button3Div);
        resultDiv = (TextView)findViewById(R.id.resultDiv);
        bodoviScreenDiv = (TextView)findViewById(R.id.scoreScreenDiv);
        timerTextViewDiv = (TextView)findViewById(R.id.timerScreenDiv);
        playAgainButtonDiv = (Button)findViewById(R.id.playAgainButtonDiv);
        relativLayoutDiv = (RelativeLayout)findViewById(R.id.relativLayoutDiv);
        BackDiv = (Button)findViewById(R.id.BackDiv);
        //topScore
        starttopScore = (Button)findViewById(R.id.StarttopScore);
        relativeLayoutTopscore=(RelativeLayout)findViewById(R.id.relativLayoutTopScore);
        TopScoreSum = (TextView)findViewById(R.id.TopScoreSum);
        TopScoreSub = (TextView)findViewById(R.id.TopScoreSub);
        TopScoreMulti = (TextView)findViewById(R.id.TopScoreMulti);
        TopScoreDiv = (TextView)findViewById(R.id.TopScoreDiv);
        //glavni izbornik
        backMode=(Button)findViewById(R.id.ButtonBackMode);
        ButtonEasy=(Button)findViewById(R.id.ButtonEasy);
        ButtonMedium=(Button)findViewById(R.id.ButtonMedium);
        ButtonHard=(Button)findViewById(R.id.ButtonHard);

    }
}
