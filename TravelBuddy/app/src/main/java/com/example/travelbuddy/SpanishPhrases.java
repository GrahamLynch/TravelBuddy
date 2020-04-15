package com.example.travelbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SpanishPhrases extends AppCompatActivity {
    MediaPlayer mp;
    Button hello, howAreYou, goodMorning, back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spanish_phrases);
        hello = (Button)findViewById(R.id.hello_btn);
        howAreYou = (Button)findViewById(R.id.howareyou_btn);
        goodMorning = (Button)findViewById(R.id.goodmorning_btn);
        back = (Button)findViewById(R.id.back_btn);
        hello.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mp!=null){
                    mp.reset();
                    mp.release();
                }
                mp = MediaPlayer.create(getApplicationContext(),R.raw.hello6_es);
                mp.start();
            }
        });

        howAreYou.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mp!=null){
                    mp.reset();
                    mp.release();
                }
                mp = MediaPlayer.create(getApplicationContext(),R.raw.howareyou2_es);
                mp.start();
            }
        });

        goodMorning.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mp!=null){
                    mp.reset();
                    mp.release();
                }
                mp = MediaPlayer.create(getApplicationContext(),R.raw.goodmorning_es);
                mp.start();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(SpanishPhrases.this, Translate.class));
            }
        });
    }
}
