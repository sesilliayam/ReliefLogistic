package com.delisar.relo.Community;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.delisar.relo.R;

public class CommunityDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_detail_community);

        TextView ommunityTitle = findViewById(R.id.titleDetail);
        ImageView communityImage = findViewById(R.id.communityImageDetail);

        ommunityTitle.setText(getIntent().getStringExtra("title"));

        Glide.with(this).load(getIntent().getIntExtra("image_resource",0))
                .into(communityImage);
    }
}
