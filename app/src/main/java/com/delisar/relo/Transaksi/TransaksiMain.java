package com.delisar.relo.Transaksi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.delisar.relo.R;

public class TransaksiMain extends AppCompatActivity {

    //initialize the UI Component
    EditText edtName, edtPhone, edtEmail, edtAddress, edtToDonation;
    Spinner spItem;
    //array to Spinner
    String[] listSpCategory;
    //array value to Spinner
    String[] listCategory = {"Kategori 1 (Barang Jangka Panjang)",
            "Kategori 2 (Barang Pokok)", "Kategori 3 (Barang Habis Pakai)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setupSharedPreferences ();
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_transaksi );

        //assign the component
        edtName = findViewById ( R.id.edt_nameTransaction );
        edtPhone = findViewById ( R.id.edt_phoneTransaction );
        edtEmail = findViewById ( R.id.edt_emailTransaction );
        edtAddress = findViewById ( R.id.edt_addressTransaction );
        edtToDonation = findViewById ( R.id.edt_toDonation );

        spItem = findViewById ( R.id.sp_categoryDonation );
        listSpCategory = new String[listCategory.length];
        //assign the list
        for (int i = 0; i<listCategory.length; i++){
            listSpCategory[i] = listCategory[i];
        }

        //adding spinner adapter
        final ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,listSpCategory);
        spItem.setAdapter(adapter);
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