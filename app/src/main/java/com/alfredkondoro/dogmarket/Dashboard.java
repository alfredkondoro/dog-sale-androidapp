package com.alfredkondoro.dogmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends AppCompatActivity {
    ImageButton imgRottweiler, imgGSD, imgLabrador, imgPitbull;
    Button buttonLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_dashboard);

        imgRottweiler = (ImageButton)findViewById (R.id.imgRottweiler);
        imgGSD = (ImageButton)findViewById (R.id.imgGSD);
        imgLabrador = (ImageButton)findViewById (R.id.imgLabrador);
        imgPitbull = (ImageButton)findViewById (R.id.imgPitbull);
        buttonLogout = (Button)findViewById (R.id.buttonLogout);

        imgRottweiler.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent rottIntent = new Intent (Dashboard.this, RottweilerActivity.class);
                startActivity (rottIntent);
            }
        });
        imgPitbull.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent pitIntent = new Intent (Dashboard.this, PitbullActivity.class);
                startActivity (pitIntent);
            }
        });
        imgGSD.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent gsdIntent = new Intent (Dashboard.this, GSDActivity.class);
                startActivity (gsdIntent);
            }
        });
        imgLabrador.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent labraIntent = new Intent (Dashboard.this, LabradorActivity.class);
                startActivity (labraIntent);
            }
        });
        buttonLogout.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance ().signOut ();
                Intent intentout = new Intent(Dashboard.this, Login.class);
                startActivity (intentout);
            }
        });
    }
}