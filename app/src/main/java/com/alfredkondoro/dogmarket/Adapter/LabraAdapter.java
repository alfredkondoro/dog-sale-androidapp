package com.alfredkondoro.dogmarket.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alfredkondoro.dogmarket.Interface.LabraClickListener;
import com.alfredkondoro.dogmarket.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LabraAdapter extends RecyclerView.Adapter<LabraAdapter.MyviewHolder> {
    private Context nContex;
    private ArrayList<String> labraList;
    private LabraClickListener clickListener;

    public LabraAdapter(Context nContex, ArrayList<String> titleList, LabraClickListener clickListener) {
        this.nContex = nContex;
        this.labraList = titleList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public LabraAdapter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from (nContex).inflate (R.layout.labra_layout,parent,false);

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
    public void onBindViewHolder(@NonNull LabraAdapter.MyviewHolder holder, int i) {
        holder.labratitle.setText(labraList.get (i).replace ("_"," "));
    }

    @Override
    public int getItemCount() {
        return labraList.size ();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        private TextView labratitle;
        public MyviewHolder(@NonNull View itemView) {
            super (itemView);
            labratitle = itemView.findViewById (R.id.labratitle);
        }
    }
}

