package com.delisar.relo.Category;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import com.delisar.relo.R;

import java.util.ArrayList;

public class CategoryMain extends AppCompatActivity {

    //deklarasi komponen
    RecyclerView recyclerViewCategory;
    private ArrayList<Category> arrayCategory;
    private CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_category_main );

        //menjalankan method addData pada pertama kali dijalankan
        addDataCategory ();

        //inisialisasi komponen
        recyclerViewCategory = findViewById ( R.id.recyclerCategory );

        categoryAdapter = new CategoryAdapter (arrayCategory);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager (CategoryMain.this);
        recyclerViewCategory.setLayoutManager(layoutManager);
        recyclerViewCategory.setAdapter(categoryAdapter);

    }

    //mengisi arraylist dengan method addData
    public void addDataCategory(){
        arrayCategory = new ArrayList<>();
        arrayCategory.add(new Category ("Category 1", "Barang jangka panjang"));
        arrayCategory.add(new Category ("Category 2", "Barang jangka pendek"));
        arrayCategory.add(new Category ("Category 3", "Barang-barang pokok"));
    }
}
