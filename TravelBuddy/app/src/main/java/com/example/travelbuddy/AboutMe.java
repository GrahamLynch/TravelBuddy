package com.example.travelbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import static com.example.travelbuddy.PointsOfInterest.REQUEST_IMAGE_GET;

public class AboutMe extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    TextView recent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = firebaseDatabase.getInstance();
        recent = (TextView) findViewById(R.id.recentAirline);
        Button location = findViewById(R.id.locations_btn);
        Button pointOfInterest = (Button) findViewById(R.id.interest_btn);
        Button back = (Button) findViewById(R.id.back_btn);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(AboutMe.this, MainActivity.class));
            }
        });

        location.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(AboutMe.this, MapsActivity.class));
            }
        });

        pointOfInterest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                galleryIntentCode();
            }
        });

        DatabaseReference databaseReference = firebaseDatabase.getReference(FirebaseAuth.getInstance().getCurrentUser().getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                UserProfile userProfile = dataSnapshot.getValue(UserProfile.class);
                recent.setText("Most Recent Airline!" +userProfile.getAirline());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(AboutMe.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void galleryIntentCode() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_GET);
        }
    }
}
