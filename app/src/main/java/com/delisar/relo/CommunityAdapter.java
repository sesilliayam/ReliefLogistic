package com.delisar.relo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


class CommunityAdapter extends RecyclerView.Adapter<CommunityAdapter.ViewHolder> {


    private ArrayList<Community> mCommunityData;
    private Context mContext;


    CommunityAdapter(Context context, ArrayList<Community> communityData) {
        this.mCommunityData = communityData;
        this.mContext = context;
    }


    @Override
    public CommunityAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).
                inflate(R.layout.list_item, parent, false));
    }


    @Override
    public void onBindViewHolder(CommunityAdapter.ViewHolder holder,
                                 int position) {

        Community currentCommunity = mCommunityData.get(position);


        holder.bindTo(currentCommunity);
    }


    @Override
    public int getItemCount() {
        return mCommunityData.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {


        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mCommunityImage;


        ViewHolder(View itemView) {
            super(itemView);


            mTitleText = itemView.findViewById(R.id.title);
            mInfoText = itemView.findViewById(R.id.subTitle);
            mCommunityImage = itemView.findViewById(R.id.communityImage);


            itemView.setOnClickListener(this);
        }

        void bindTo(Community currentCommunity) {

            mTitleText.setText(currentCommunity.getTitle());
            mInfoText.setText(currentCommunity.getInfo());


            Glide.with(mContext).load(
                    currentCommunity.getImageResource()).into(mCommunityImage);
        }


        @Override
        public void onClick(View view) {
            Community currentCommunity = mCommunityData.get(getAdapterPosition());
            Intent detailIntent = new Intent(mContext, DetailActivity.class);
            detailIntent.putExtra("title", currentCommunity.getTitle());
            detailIntent.putExtra("image_resource",
                    currentCommunity.getImageResource());
            mContext.startActivity(detailIntent);
        }
    }
}
