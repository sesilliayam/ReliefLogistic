package com.delisar.relo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    //DEKLARASI REFERENSI UI
    private EditText edtEmailLogin, edtPasswordLogin;
    private View mProgressView, mLoginFormView;
    private Button btnRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_login );

        //ASSIGN KOMPONEN
        edtEmailLogin = findViewById ( R.id.email );
        edtPasswordLogin = findViewById ( R.id.password );//BUTTON
        btnRegister = findViewById ( R.id.btn_regist );

        //VIEW
        mLoginFormView = findViewById ( R.id.login_form );
        mProgressView = findViewById ( R.id.login_progress );
    }

    public void signUp(View view){
        Intent toSignUp = new Intent ( this, Register.class );
        startActivity ( toSignUp );
    }

    public void registerUser(){

    }

    @Override
    public void onClick(View view) {
        switch (view.getId ()){
            case R.id.btn_regist:
                registerUser();
                break;
        }
    }
}

