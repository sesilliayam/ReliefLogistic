package com.delisar.relo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AdminRole extends AppCompatActivity {

    EditText inputJudul, inputBerita;
    Button tambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_role);

        inputJudul = (EditText)findViewById(R.id.inputJudul);
        inputBerita = (EditText) findViewById(R.id.inputBerita);
        tambah = (Button) findViewById(R.id.tambah);
    }
}
