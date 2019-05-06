package com.delisar.relo.Transaksi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.delisar.relo.MapsActivity;
import com.delisar.relo.R;

public class TransaksiMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setupSharedPreferences ();
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_transaksi );
    }

    public void ToMaps(View view) {
        Intent intent = new Intent(this, TransaksiMaps.class);
        startActivity(intent);
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