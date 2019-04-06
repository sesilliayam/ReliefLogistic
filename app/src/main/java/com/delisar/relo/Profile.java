package com.delisar.relo;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.provider.ContactsContract;
import android.service.autofill.SaveCallback;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.delisar.relo.R;

import java.util.Locale;

public class Profile extends AppCompatActivity {

    Button btnCancelProfile;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_profile );

        btnCancelProfile = findViewById ( R.id.btnCancelProfile );
    }

    public void toMain(View view) {
        startActivity ( new Intent ( Profile.this, MainActivity.class) );
    }
}