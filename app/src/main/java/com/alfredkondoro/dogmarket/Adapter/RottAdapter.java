package com.alfredkondoro.dogmarket.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alfredkondoro.dogmarket.Interface.RottClickListener;
import com.alfredkondoro.dogmarket.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RottAdapter extends RecyclerView.Adapter<RottAdapter.MyviewHolder> {
    private Context nContex;
    private ArrayList<String> rottList;
    private RottClickListener clickListener;

    public RottAdapter(Context nContex, ArrayList<String> titleList, RottClickListener clickListener) {
        this.nContex = nContex;
        this.rottList = titleList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public RottAdapter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from (nContex).inflate (R.layout.rott_layout,parent,false);

        final MyviewHolder holder = new MyviewHolder (view);
        view.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View V) {
                clickListener.onItemClick (V, holder.getPosition ());
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RottAdapter.MyviewHolder holder, int i) {
        holder.rotttitle.setText(rottList.get (i).replace ("_"," "));
    }

    @Override
    public int getItemCount() {
        return rottList.size ();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        private TextView rotttitle;
        public MyviewHolder(@NonNull View itemView) {
            super (itemView);
            rotttitle = itemView.findViewById (R.id.rotttitle);
        }
    }
}
