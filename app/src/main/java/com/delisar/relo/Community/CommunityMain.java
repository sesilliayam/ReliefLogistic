package com.delisar.relo.Community;

import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.delisar.relo.R;

import java.util.ArrayList;
import java.util.Collections;


public class CommunityMain extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private ArrayList<Community> mCommunityData;
    private CommunityAdapter mAdapter;
    boolean theme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences preferences = getSharedPreferences("prefs", MODE_PRIVATE);
        theme = preferences.getBoolean("dark_theme", false);
        boolean font = preferences.getBoolean("font_large", false);
        if (theme && font) {
            setTheme(R.style.AppTheme_Dark_FontLarge);
        } else if (theme) {
            setTheme(R.style.AppTheme_Dark_FontNormal);
        } else if (font) {
            setTheme(R.style.AppTheme_FontLarge);
        }
        setContentView( R.layout.activity_community_main );
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mCommunityData = new ArrayList<> ();
        mAdapter = new CommunityAdapter(this, mCommunityData);
        mRecyclerView.setAdapter(mAdapter);


        initializeData();


        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper
                .SimpleCallback(
                    ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT |
                    ItemTouchHelper.DOWN | ItemTouchHelper.UP,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView,
                                  RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder target) {

                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();


                Collections.swap(mCommunityData, from, to);
                mAdapter.notifyItemMoved(from, to);
                return true;
            }


            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder,
                                 int direction) {

                mCommunityData.remove(viewHolder.getAdapterPosition());

                mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });


        helper.attachToRecyclerView(mRecyclerView);
    }


    private void initializeData() {

        String[] communityList = getResources()
                .getStringArray(R.array.community_titles);
        String[] communityInfo = getResources()
                .getStringArray(R.array.community_info);
        TypedArray communityImageResource = getResources()
                .obtainTypedArray(R.array.community_images);


        mCommunityData.clear();


        for (int i = 0; i < communityList.length; i++) {
            mCommunityData.add(new Community(communityList[i], communityInfo[i],
                    communityImageResource.getResourceId(i, 0)));
        }


        communityImageResource.recycle();


        mAdapter.notifyDataSetChanged();
    }


}
