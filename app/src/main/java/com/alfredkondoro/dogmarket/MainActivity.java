package com.alfredkondoro.dogmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        //Create a new handler
        handler=new Handler ();

        //This handler will move the user to the login page after the delayed time is finished
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent=new Intent(MainActivity.this,Login.class);
                startActivity(intent);
                finish();
                //delayed time in milliseconds
            }
        },4000);
    }
}