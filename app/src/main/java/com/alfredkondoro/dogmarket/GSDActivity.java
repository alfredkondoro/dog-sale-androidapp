package com.alfredkondoro.dogmarket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;

import com.alfredkondoro.dogmarket.Adapter.GSDAdapter;

import com.alfredkondoro.dogmarket.Interface.GSDClickListener;
import com.alfredkondoro.dogmarket.Model.GSDConstants;

import java.util.ArrayList;

public class GSDActivity extends AppCompatActivity {
    private static final String TAG = "GSDActivity";
    private Context nContext;
    private ArrayList<String> gsdList;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_g_s_d);

        nContext = GSDActivity.this;

        gsdList= new ArrayList<> ();
        gsdList.add(GSDConstants.GSDA);
        gsdList.add(GSDConstants.GSDB);
        gsdList.add(GSDConstants.GSDC);
        gsdList.add(GSDConstants.GSDD);

        recyclerView = findViewById(R.id.recyviewGSD);
        recyclerView.setHasFixedSize (true);
        LinearLayoutManager layoutManager = new LinearLayoutManager (nContext, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager (layoutManager);

        GSDAdapter titleAdapter = new GSDAdapter (nContext, gsdList, new GSDClickListener () {
            @Override
            public void onItemClick(View itemView, int position) {
                Intent detailIntent = new Intent (GSDActivity.this, GSDDetailActivity.class);
                detailIntent.putExtra("titles", gsdList.get (position));
                startActivity(detailIntent);
            }
        });
        recyclerView.setAdapter (titleAdapter);

    }
}