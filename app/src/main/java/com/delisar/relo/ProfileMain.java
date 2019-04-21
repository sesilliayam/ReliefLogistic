package com.delisar.relo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ProfileMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_profile );
    }
    public void toMain(View view){
        Intent intent = new Intent ( ProfileMain.this, DashboardMain.class );
        startActivity ( intent );
        finish ();
    }
}
