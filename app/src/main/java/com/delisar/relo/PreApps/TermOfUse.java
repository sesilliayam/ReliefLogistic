package com.delisar.relo.PreApps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.delisar.relo.R;

public class TermOfUse extends AppCompatActivity {

    Button termOfUse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_term_of_use );

        termOfUse = findViewById ( R.id.btnKonfirmTerm );
    }

    public void haveRead(View view){
        startActivity ( new Intent ( TermOfUse.this, Register.class ) );
        finish ();
    }
}
