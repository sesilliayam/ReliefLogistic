package com.delisar.relo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class ContactUsMain extends AppCompatActivity {

    private static final String TAG = "ContactUsMain";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us_main);
        Log.d(TAG, "onCreate: started.");

        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://png2.kisspng.com/sh/da0b280ce7dfb06cd3119a06d2b9bdb7/L0KzQYm3VMIyN6l7iZH0aYP2gLBuTfVuaZpxRd54Z3Awc7F0kQV1baMygdV4boOwd8H6Tf1ieF46edZrNEa6RrPqUfY2Ol8ATasBOUG5SIK8UsQ0OWo9TqQCN0C5PsH1h5==/kisspng-email-logo-computer-icons-gps-map-5adb4676bc1f52.9596916815243198627706.png");
        mNames.add("cs@relieflogistic.com");

        mImageUrls.add("https://banner2.kisspng.com/20180412/sxw/kisspng-computer-icons-mobile-phones-telephone-font-awesom-phone-icon-5acfccbd676a13.7082166215235678054236.jpg");
        mNames.add("(021) 637928");

        mImageUrls.add("http://pngimg.com/uploads/facebook_logos/facebook_logos_PNG19759.png");
        mNames.add("Relief Logistic");


        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        ContactUsAdapter adapter = new ContactUsAdapter(this, mNames, mImageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}






















