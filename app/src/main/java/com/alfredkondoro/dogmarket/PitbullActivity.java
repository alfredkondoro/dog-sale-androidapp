package com.alfredkondoro.dogmarket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.alfredkondoro.dogmarket.Adapter.PitAdapter;
import com.alfredkondoro.dogmarket.Interface.PitClickListener;
import com.alfredkondoro.dogmarket.Model.PitConstants;


import java.util.ArrayList;


public class PitbullActivity extends AppCompatActivity {

    private static final String TAG = "PitbullActivity";
    private Context nContext;
    private ArrayList<String> pitList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_pitbull);

        nContext = PitbullActivity.this;

        pitList= new ArrayList<> ();
        pitList.add(PitConstants.PITA);
        pitList.add(PitConstants.PITB);
        pitList.add(PitConstants.PITC);
        pitList.add(PitConstants.PITD);

        recyclerView = findViewById(R.id.recyviewPit);
        recyclerView.setHasFixedSize (true);
        LinearLayoutManager layoutManager = new LinearLayoutManager (nContext, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager (layoutManager);

        PitAdapter titleAdapter = new PitAdapter (nContext, pitList, new PitClickListener () {
            @Override
            public void onItemClick(View itemView, int position) {
                Intent detailIntent = new Intent (PitbullActivity.this, PitDetailActivity.class);
                detailIntent.putExtra("titles", pitList.get (position));
                startActivity(detailIntent);
            }
        });
        recyclerView.setAdapter (titleAdapter);

    }
}
