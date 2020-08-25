package com.alfredkondoro.dogmarket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;

import com.alfredkondoro.dogmarket.Adapter.RottAdapter;
import com.alfredkondoro.dogmarket.Interface.RottClickListener;
import com.alfredkondoro.dogmarket.Model.RottConstants;

import java.util.ArrayList;

public class RottweilerActivity extends AppCompatActivity {
    private static final String TAG = "RottweilerActivity";
    private Context nContext;
    private ArrayList<String> rottweilerList;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_rottweiler);

        nContext = RottweilerActivity.this;

        rottweilerList= new ArrayList<> ();
        rottweilerList.add(RottConstants.ROTTA);
        rottweilerList.add(RottConstants.ROTTB);
        rottweilerList.add(RottConstants.ROTTC);
        rottweilerList.add(RottConstants.ROTTD);

        recyclerView = findViewById(R.id.recyviewRott);
        recyclerView.setHasFixedSize (true);
        LinearLayoutManager layoutManager = new LinearLayoutManager (nContext, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager (layoutManager);

        RottAdapter titleAdapter = new RottAdapter (nContext, rottweilerList, new RottClickListener () {
            @Override
            public void onItemClick(View itemView, int position) {
                Intent detailIntent = new Intent (RottweilerActivity.this, RottweilerDetailActivity.class);
                detailIntent.putExtra("titles", rottweilerList.get (position));
                startActivity(detailIntent);
            }
        });
        recyclerView.setAdapter (titleAdapter);

    }
}