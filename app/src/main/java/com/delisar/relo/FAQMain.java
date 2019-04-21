package com.delisar.relo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class FAQMain extends AppCompatActivity {
    RecyclerView recyclerView;
    FAQAdapter adapter;
    ArrayList<FAQ> FAQArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq_main);
        addData();

        recyclerView = (RecyclerView) findViewById(R.id.recycleViewFAQ);

        adapter = new FAQAdapter(FAQArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(FAQMain.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }
    private void addData() {
        FAQArrayList = new ArrayList<>();
        FAQArrayList.add(new FAQ("Q : Bagaimana Berdonasi dengan RELO", "A: Donasi dapat dilakukan dengan langsung mengirim Donasi kealamat yang telah di tentukan saat melakukan Check Out di Relo"));
        FAQArrayList.add(new FAQ("Q : Apakah bisa berdonasi dengan Uang di RELO", "A: Saat ini donasi yang diterima RELo hanyalah barang"));
    }
}