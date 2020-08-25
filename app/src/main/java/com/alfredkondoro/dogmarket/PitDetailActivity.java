package com.alfredkondoro.dogmarket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.util.Objects;

public class PitDetailActivity extends AppCompatActivity {
    private static final String TAG = "PitDescription;";
    private Context context;
    private WebView webView;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_pit_detail);

        context = PitDetailActivity.this;
        webView = findViewById (R.id.webviewPit);

        extras = getIntent ().getExtras ();
        if(extras != null){
            String data = extras.getString ("titles");
            Log.d(TAG, "onCreate: the coming data is "+data);
            String url = "file:///android_asset/"+data+".html";
            webView.loadUrl (url);
            WebSettings webSettings = webView.getSettings ();
            webSettings.setBuiltInZoomControls (true);
            webSettings.setDisplayZoomControls (false);

            Objects.requireNonNull (getSupportActionBar ()).setTitle (data.replace ("_", " "));
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId () == android.R.id.home){
            finish ();
        }
        return super.onOptionsItemSelected (item);
    }
}