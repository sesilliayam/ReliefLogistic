package com.delisar.relo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ForgotPassword extends AppCompatActivity {

    //this is a test comments
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_forgot_password );
    }

    public void toLoginfromForgot(View view){
        startActivity ( new Intent ( ForgotPassword.this, LoginActivity.class ) );
        finish ();
    }
}
