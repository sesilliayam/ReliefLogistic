package com.delisar.relo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Register extends AppCompatActivity {

    //UI component declaration
    TextView txtLogin;

    EditText edtFullname, edtUsername, edtPassword, edtConPass, edtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //UI component assignment
        txtLogin = findViewById ( R.id.txt_to_login );//set onClick to be intent
        edtFullname = findViewById ( R.id.edit_fullname );
        edtUsername = findViewById ( R.id.edit_username );
        edtPassword = findViewById ( R.id.edit_password );
        edtConPass = findViewById ( R.id.edit_conpass );
        edtEmail = findViewById ( R.id.edit_email );

        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_register );
    }

    public void toLogin (View view){
        Intent toLogin = new Intent (this, LoginActivity.class);
        startActivity ( toLogin );
    }

}