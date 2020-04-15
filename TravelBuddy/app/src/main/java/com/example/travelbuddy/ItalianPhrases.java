package com.example.travelbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ItalianPhrases extends AppCompatActivity {
    MediaPlayer mp;
    Button hello, howAreYou, yes, back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_italian_phrases);
        hello = (Button)findViewById(R.id.hello_btn);
        howAreYou = (Button)findViewById(R.id.howareyou_btn);
        yes = (Button)findViewById(R.id.yes_btn);
        back = (Button)findViewById(R.id.back_btn);

        hello.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mp!=null){
                    mp.reset();
                    mp.release();
                }
                mp = MediaPlayer.create(getApplicationContext(),R.raw.hello2_it);
                mp.start();
            }
        });

        howAreYou.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mp!=null){
                    mp.reset();
                    mp.release();
                }
                mp = MediaPlayer.create(getApplicationContext(),R.raw.howareyou1_it);
                mp.start();
            }
        });

        yes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (mp!=null){
                    mp.reset();
                    mp.release();
                }
                mp = MediaPlayer.create(getApplicationContext(),R.raw.yes_it);
                mp.start();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(ItalianPhrases.this, Translate.class));
            }
        });
    }
}
