package com.delisar.relo.Event;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.delisar.relo.R;

import java.util.ArrayList;

public class adapterEvent extends RecyclerView.Adapter<adapterEvent.dataViewHolder> {

    ArrayList<dataAPI> dataHolderArrayList;
    Context context;

    //constructor
    public adapterEvent(ArrayList<dataAPI> dataHolderArrayList, Context context){
        this.dataHolderArrayList = dataHolderArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public adapterEvent.dataViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i){
        View view = LayoutInflater.from ( viewGroup.getContext ()).inflate ( R.layout.list_item_event, viewGroup, false );
        return new adapterEvent.dataViewHolder (view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapterEvent.dataViewHolder dataViewHolder, int i){
        dataViewHolder.dataText.setText(dataHolderArrayList.get ( i ).getTitle ());
    }

    @Override
    public int getItemCount() {return dataHolderArrayList.size();}

    public class dataViewHolder extends RecyclerView.ViewHolder{
        TextView dataText;

        public dataViewHolder(@NonNull View itemView){
            super(itemView);
            dataText = itemView.findViewById ( R.id.dataText );
        }
    }

}