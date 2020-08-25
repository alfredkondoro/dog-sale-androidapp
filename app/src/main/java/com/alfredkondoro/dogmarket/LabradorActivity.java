package com.alfredkondoro.dogmarket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;

import com.alfredkondoro.dogmarket.Adapter.LabraAdapter;
import com.alfredkondoro.dogmarket.Interface.LabraClickListener;
import com.alfredkondoro.dogmarket.Model.LabraConstants;

import java.util.ArrayList;

public class LabradorActivity extends AppCompatActivity {
    private static final String TAG = "LabradorActivity";
    private Context nContext;
    private ArrayList<String> labraList;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_labrador);

        nContext = LabradorActivity.this;

        labraList= new ArrayList<> ();
        labraList.add(LabraConstants.LABRAA);
        labraList.add(LabraConstants.LABRAB);
        labraList.add(LabraConstants.LABRAC);
        labraList.add(LabraConstants.LABRAD);

        recyclerView = findViewById(R.id.recyviewLabra);
        recyclerView.setHasFixedSize (true);
        LinearLayoutManager layoutManager = new LinearLayoutManager (nContext, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager (layoutManager);

        LabraAdapter titleAdapter = new LabraAdapter (nContext, labraList, new LabraClickListener () {
            @Override
            public void onItemClick(View itemView, int position) {
                Intent detailIntent = new Intent (LabradorActivity.this, LabraDetailActivity.class);
                detailIntent.putExtra("titles", labraList.get (position));
                startActivity(detailIntent);
            }
        });
        recyclerView.setAdapter (titleAdapter);

    }
}