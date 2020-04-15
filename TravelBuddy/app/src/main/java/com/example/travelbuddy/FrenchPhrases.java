package com.example.travelbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FrenchPhrases extends AppCompatActivity {
    MediaPlayer mp;
    Button hello, goodBye, howAreYou, back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_french_phrases);
        hello = (Button)findViewById(R.id.hello_btn);
        goodBye = (Button)findViewById(R.id.goodbye_btn);
        howAreYou = (Button)findViewById(R.id.howareyou_btn);
        back = (Button)findViewById(R.id.back_btn);

        hello.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mp!=null){
                    mp.reset();
                    mp.release();
                }
                mp = MediaPlayer.create(getApplicationContext(),R.raw.hello1_fr);
                mp.start();
            }
        });

        howAreYou.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mp!=null){
                    mp.reset();
                    mp.release();
                }
                mp = MediaPlayer.create(getApplicationContext(),R.raw.howareyou1_fr);
                mp.start();
            }
        });

        goodBye.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mp!=null){
                    mp.reset();
                    mp.release();
                }
                mp = MediaPlayer.create(getApplicationContext(),R.raw.goodbye_fr);
                mp.start();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(FrenchPhrases.this, Translate.class));
            }
        });
    }
}
