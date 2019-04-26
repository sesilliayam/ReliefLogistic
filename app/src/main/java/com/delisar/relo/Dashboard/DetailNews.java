package com.delisar.relo.Dashboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.delisar.relo.R;
import com.delisar.relo.Transaksi.TransaksiMain;

public class DetailNews extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_detail_news);
    }

    public void Submit(View view) {
        Intent intent = new Intent(this, TransaksiMain.class);
        startActivity(intent);
    }

    public void toMapsBencana(View view) {
        startActivity ( new Intent ( this, MapsBencana.class ) );
    }
}
