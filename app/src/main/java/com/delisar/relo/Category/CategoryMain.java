package com.delisar.relo.Category;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import com.delisar.relo.R;

import java.util.ArrayList;

public class CategoryMain extends AppCompatActivity {

    //deklarasi komponen
    RecyclerView recyclerViewCategory;
    private ArrayList<Category> listCategory;
    private ListAdapter listAdapter;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_category_main );

        //inisialisasi komponen
        recyclerViewCategory = findViewById ( R.id.recyclerCategory );

        //mengisi list kategori
        listCategory = new ArrayList<> (  );

    }
}
