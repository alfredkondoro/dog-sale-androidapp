package com.alfredkondoro.dogmarket.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alfredkondoro.dogmarket.Interface.GSDClickListener;
import com.alfredkondoro.dogmarket.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GSDAdapter extends RecyclerView.Adapter<GSDAdapter.MyviewHolder>{
    private Context nContex;
    private ArrayList<String> gsdList;
    private GSDClickListener clickListener;

    public GSDAdapter(Context nContex, ArrayList<String> titleList, GSDClickListener clickListener) {
        this.nContex = nContex;
        this.gsdList = titleList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public GSDAdapter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from (nContex).inflate (R.layout.gsd_layout,parent,false);

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
    public void onBindViewHolder(@NonNull GSDAdapter.MyviewHolder holder, int i) {
        holder.gsdtitle.setText(gsdList.get (i).replace ("_"," "));
    }

    @Override
    public int getItemCount() {
        return gsdList.size ();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        private TextView gsdtitle;
        public MyviewHolder(@NonNull View itemView) {
            super (itemView);
            gsdtitle = itemView.findViewById (R.id.gsdtitle);
        }
    }
}
