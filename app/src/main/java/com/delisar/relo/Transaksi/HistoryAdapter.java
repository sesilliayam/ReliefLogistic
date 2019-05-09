package com.delisar.relo.Transaksi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.delisar.relo.R;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {

    //array list kategori
    private ArrayList<Transaksi> listHistory;


    //konstruktor HistoryAdapter
    public HistoryAdapter (ArrayList<Transaksi> listHistory){
        this.listHistory = listHistory;
    }

    @Override
    public HistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate( R.layout.list_item_history, parent, false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HistoryViewHolder holder, int position) {
        holder.txtTitleHistory.setText(listHistory.get(position).getToDonationWho ());
        holder.txtDateTransaction.setText(listHistory.get(position).getDateTransaction ());
    }

    @Override
    public int getItemCount() {
        return (listHistory != null) ? listHistory.size() : 0;
    }

    public class HistoryViewHolder extends RecyclerView.ViewHolder{
        private TextView txtTitleHistory, txtDateTransaction;

        public HistoryViewHolder(View itemView) {
            super(itemView);
            txtTitleHistory = (TextView) itemView.findViewById(R.id.head_detailHistory);
            txtDateTransaction = (TextView) itemView.findViewById(R.id.txt_dateTransaction);
        }
    }

}
