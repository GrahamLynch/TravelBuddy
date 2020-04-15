package com.example.travelbuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Flights extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    String favAirline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flights);
        Button aerLingus = (Button) findViewById(R.id.aerLingus_btn);
        Button ryanair = (Button) findViewById(R.id.ryanair_btn);
        firebaseDatabase = firebaseDatabase.getInstance();
        Button back = (Button) findViewById(R.id.back_btn);
        final DatabaseReference databaseReference = firebaseDatabase.getReference(FirebaseAuth.getInstance().getCurrentUser().getUid());


        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Flights.this, MainActivity.class));

            }
        });

        aerLingus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                favAirline = "Aer Lingus";
                databaseReference.child("airline").setValue(favAirline);
                myWebLink.setData(Uri.parse("https://www.aerlingus.com/html/flightSearchResult.html#/fareType=RETURN&fareCategory=ECONOMY&sourceAirportCode_0=DUB&destinationAirportCode_0=CDG&departureDate_0=2019-12-12&sourceAirportCode_1=CDG&destinationAirportCode_1=DUB&departureDate_1=2019-12-19&numAdults=1&numYoungAdults=0&numChildren=0&numInfants=0&promoCode=&groupBooking=false"));
                startActivity(myWebLink);
            }
        });

        ryanair.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                favAirline = "Ryanair";
                databaseReference.child("airline").setValue(favAirline);
                myWebLink.setData(Uri.parse("https://www.ryanair.com/ie/en/trip/flights/select?ADT=1&CHD=0&DateIn=2019-12-19&DateOut=2019-12-12&Destination=BCN&FlexDaysIn=6&FlexDaysOut=6&INF=0&Origin=DUB&RoundTrip=true&TEEN=0&domestic=false&isConnectedFlight=false&isSpanishDiscount=false&promoCode=&tpAdults=1&tpChildren=0&tpDestinationIata=BCN&tpDiscount=0&tpEndDate=2019-12-19&tpInfants=0&tpIsConnectedFlight=false&tpIsReturn=true&tpOriginIata=DUB&tpPromoCode=&tpStartDate=2019-12-12&tpTeens=0"));
                startActivity(myWebLink);
            }
        });
    }
}
