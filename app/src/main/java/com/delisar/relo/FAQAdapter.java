package com.delisar.relo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView
import java.util.ArrayList;

public class FAQAdapter extends RecyclerView.Adapter<FAQAdapter.FAQAdapterViewHolder> {
    private ArrayList<FAQAdapter> dataList;

    @Override
    public FAQAdapterViewHolder(View view){
        super(view)
        TextView txt_tanya = (TextView) view.findViewById(R.id.txt_tanya);
        TextView txt_jawab = (TextView) view.findViewById(R.id.txt_jawab);
    }

    public FAQAdapter(ArrayList<FAQAdapter> dataList){
        this.dataList = dataList;
    }
    @Override
    public FAQAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new FAQAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FAQAdapterViewHolder holder, int position) {
        holder.txt_tanya.setText(dataList.get(position).getTanya());
        holder.txt_jawab.setText(dataList.get(position).getJawab());
    }
    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class FAQAdapterViewHolder extends RecyclerView.ViewHolder{
        private TextView txt_tanya, txt_jawab;

        public FAQAdapterViewHolder(View itemView) {
            super(itemView);
            txt_tanya = (TextView) itemView.findViewById(R.id.txt_tanya);
            txt_jawab = (TextView) itemView.findViewById(R.id.txt_jawab);
        }
    }

}
