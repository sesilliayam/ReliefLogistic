package com.delisar.relo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

//import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by User on 1/1/2018.
 */

public class ContactUsAdapter extends RecyclerView.Adapter<ContactUsAdapter.ViewHolder>{

    private static final String TAG = "ContactUsAdapter";

    private ArrayList<String> mDetail = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private Context mContext;

    public ContactUsAdapter(Context context, ArrayList<String> detail, ArrayList<String> images ) {
        mDetail = detail;
        mImages = images;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_contact_us, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        Glide.with(mContext)
//                .asBitmap()
                .load(mImages.get(position))
                .into(holder.image);

        holder.imageName.setText(mDetail.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + mDetail.get(position));

                Toast.makeText(mContext, mDetail.get(position), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, ContactUsDetail.class);
                intent.putExtra("image_url", mImages.get(position));
                intent.putExtra("image_name", mDetail.get(position));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDetail.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView imageName;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.detailcontact);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}