package com.delisar.relo.FAQ;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.delisar.relo.R;

import java.util.ArrayList;

public class FAQMain extends AppCompatActivity {
    RecyclerView recyclerView;
    FAQAdapter adapter;
    ArrayList<FAQModel> FAQArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_faq_main);
        addData();

        recyclerView = (RecyclerView) findViewById(R.id.recycleViewFAQ);

        adapter = new FAQAdapter(FAQArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(FAQMain.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }
    private void addData() {
        FAQArrayList = new ArrayList<>();
        FAQArrayList.add(new FAQModel ("Q : Bagaimana Berdonasi dengan RELO?", "A: Donasi dapat dilakukan dengan langsung mengirim Donasi kealamat yang telah di tentukan saat melakukan Check Out di Relo"));
        FAQArrayList.add(new FAQModel ("Q : Apakah bisa berdonasi dengan Uang di RELO?", "A: Saat ini donasi yang diterima RELO hanyalah barang"));
        FAQArrayList.add(new FAQModel ("Q : Bagaimana cara melakukan Donasi?", "Cari Komunitas yang membuka donasi, kemudian pilih kategori barang yang disumbangkan, lalu antar barang ke alamat komunitas tersebut"));
        FAQArrayList.add(new FAQModel ("Q : Bisakah Donasi di kirim lewat ekspedisi ke alamat komunitas?", "Saat ini Donasi hanya bisa dikirim dengan sistem drop off donasi atau Pick Up by Community"));
    }
}