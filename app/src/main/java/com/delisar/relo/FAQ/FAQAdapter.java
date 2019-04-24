package com.delisar.relo.FAQ;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.delisar.relo.R;

import java.util.ArrayList;

public class FAQAdapter extends RecyclerView.Adapter<FAQAdapter.FAQAdapterViewHolder> {

    ArrayList<FAQ> FAQList;

    public FAQAdapter(ArrayList<FAQ> FAQList){

        this.FAQList = FAQList;
    }

    @Override
    public FAQAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate( R.layout.layout_faq, parent, false);
        return new FAQAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FAQAdapterViewHolder holder, final int i) {
        holder.bind(FAQList.get(i));
    }
    @Override
    public int getItemCount() {
        return FAQList.size();
    }

    public class FAQAdapterViewHolder extends RecyclerView.ViewHolder{
        TextView txt_tanya, txt_jawab;

        public FAQAdapterViewHolder(View itemView) {
            super(itemView);
            txt_tanya = itemView.findViewById(R.id.txt_tanya);
            txt_jawab = itemView.findViewById(R.id.txt_jawab);
        }
        void bind(FAQ faq){
            txt_tanya.setText(faq.getTanya());
            txt_jawab.setText(faq.getJawab());
        }
    }

}

