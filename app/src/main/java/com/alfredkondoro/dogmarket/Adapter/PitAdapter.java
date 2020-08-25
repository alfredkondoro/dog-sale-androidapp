package com.alfredkondoro.dogmarket.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alfredkondoro.dogmarket.Interface.PitClickListener;
import com.alfredkondoro.dogmarket.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PitAdapter extends RecyclerView.Adapter<PitAdapter.MyviewHolder> {
    private Context nContex;
    private ArrayList<String> pitList;
    private PitClickListener clickListener;

    public PitAdapter(Context nContex, ArrayList<String> titleList, PitClickListener clickListener) {
        this.nContex = nContex;
        this.pitList = titleList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public PitAdapter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from (nContex).inflate (R.layout.pit_layout,parent,false);

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
    public void onBindViewHolder(@NonNull PitAdapter.MyviewHolder holder, int i) {
        holder.pittitle.setText(pitList.get (i).replace ("_"," "));
    }

    @Override
    public int getItemCount() {
        return pitList.size ();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        private TextView pittitle;
        public MyviewHolder(@NonNull View itemView) {
            super (itemView);
            pittitle = itemView.findViewById (R.id.pittitle);
        }
    }
}
