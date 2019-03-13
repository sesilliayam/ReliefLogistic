package com.delisar.relo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FAQAdapter adapter;
    private ArrayList<QnA> FAQArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addData();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        adapter = new FAQAdapter(FAQArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }

    private void addData() {
        FAQArrayList = new ArrayList<>();
        FAQArrayList.add(new QnA("Q : Bagaimana Berdonasi dengan RELO", "A: Donasi dapat dilakukan dengan langsung mengirim Donasi kealamat yang telah di tentukan saat melakukan Check Out di Relo"));
        FAQArrayList.add(new QnA("Q : Apakah bisa berdonasi dengan Uang di RELO", "A: Saat ini donasi yang diterima RELo hanyalah barang"));
    }
}
