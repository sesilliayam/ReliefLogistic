package com.delisar.relo.PreApps;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.delisar.relo.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    //UI component declaration
    TextView txtLogin;
    private Button btnRegist;
    private EditText edtFullname, edtUsername, edtPassword, edtConPass, edtEmail;
    private FirebaseAuth auth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_register);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        btnRegist = (Button) findViewById(R.id.btn_regist);
        edtEmail = (EditText) findViewById(R.id.edit_email);
        edtPassword = (EditText) findViewById(R.id.edit_password);
        edtConPass = (EditText) findViewById ( R.id.edit_conpass );
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        btnRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = edtEmail.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Email tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Password tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password terlalu pendek!", Toast.LENGTH_SHORT).show();
                    return;
                }

                String checkPass, checkConpass;
                checkConpass = edtConPass.getText ().toString ().trim ();
                checkPass = edtPassword.getText ().toString ().trim ();

                if (!checkPass.equals ( checkConpass )){
                    Toast.makeText ( getApplicationContext (), "Password tidak sama!", Toast.LENGTH_SHORT ).show ();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                //create user
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(Register.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(Register.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    startActivity(new Intent(Register.this, LoginActivity.class));
                                    finish();
                                }
                            }
                        });

            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume ();
        progressBar.setVisibility ( View.GONE );
    }

    public void toLogin (View view){
        Intent toLogin = new Intent (this, LoginActivity.class);
        startActivity ( toLogin );
    }

    public void toTerm (View view){
        Intent toTerm = new Intent ( this, TermOfUse.class );
        startActivity ( toTerm );
    }

}