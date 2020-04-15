package com.example.travelbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Translate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);
        Button SpanishButton = findViewById(R.id.spanishPhrases_btn);
        Button ItalianButton = findViewById(R.id.italianPhrases_btn);
        Button FrenchButton = findViewById(R.id.frenchPhrases_btn);
        Button back = (Button) findViewById(R.id.back_btn);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Translate.this, MainActivity.class));
            }
        });

        SpanishButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Translate.this, SpanishPhrases.class));
            }
        });

        ItalianButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Translate.this, ItalianPhrases.class));
            }
        });
        FrenchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Translate.this, FrenchPhrases.class));
            }
        });
    }
}
