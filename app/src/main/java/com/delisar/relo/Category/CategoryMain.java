package com.delisar.relo.Category;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.delisar.relo.R;

import java.util.ArrayList;

public class CategoryMain extends AppCompatActivity {

    //deklarasi komponen
    RecyclerView recyclerViewCategory;
    private ArrayList<Category> arrayCategory;
    private CategoryAdapter categoryAdapter;
    Dialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setupSharedPreferences ();
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_category_main );

        mDialog = new Dialog ( this );

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

    public void toDetail(View v) {
        TextView txtclose, headDetail, txtDetail;
        Button btnFollow;
        mDialog.setContentView(R.layout.activity_category_detail_popup);
        txtclose =(TextView) mDialog.findViewById(R.id.txt_close);
        headDetail = (TextView) mDialog.findViewById ( R.id.head_detailCategory );
        txtDetail = (TextView) mDialog.findViewById ( R.id.txt_detailCategory );

        txtclose.setText("Close");
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.dismiss();
            }
        });
        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable ( Color.TRANSPARENT));
        mDialog.show();
    }

    private void setupSharedPreferences() {
        SharedPreferences prefs = getSharedPreferences(getPackageName(), MODE_PRIVATE);
        toggleTheme(prefs.getBoolean("nightMode",false));

    }

    //memanggil tema
    public void toggleTheme(Boolean bo){
        if (bo){
            setTheme(R.style.dark);
        }else{
            setTheme(R.style.light);
        }

    }
}
