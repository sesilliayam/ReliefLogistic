package com.delisar.relo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Profile2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_profile );
    }
    public void toMain(View view){
        Intent intent = new Intent ( Profile2.this, MainActivity.class );
        startActivity ( intent );
        finish ();
    }
}
