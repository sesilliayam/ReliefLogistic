package com.delisar.relo;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.delisar.relo.Dashboard.DashboardMain;
import com.delisar.relo.Profile.DisplayProfile;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    //DEKLARASI REFERENSI UI
    private EditText loginEmail, loginPassword;
    private FirebaseAuth auth;
    private ProgressBar progressBar;
    private Button btnLogin, btnLoginGoogle;
    private GoogleSignInClient googleSignInClient;
    private static final String TAG = "AndroidClarified";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_login );

        //get firebase auth instance
        auth = FirebaseAuth.getInstance ();

        //kalo ada yang login
        if (auth.getCurrentUser () != null){
            startActivity ( new Intent ( LoginActivity.this, DashboardMain.class ) );
            finish ();
        }

        //ASSIGN KOMPONEN
        loginEmail = findViewById ( R.id.login_email );
        loginPassword = findViewById ( R.id.login_password );//BUTTON
        btnLogin = findViewById ( R.id.btn_login );
        btnLoginGoogle = findViewById ( R.id.btn_loginGoogle );
        progressBar = findViewById ( R.id.progressBar );

        //LOGIN WITH GOOGLE
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        googleSignInClient = GoogleSignIn.getClient(this, gso);
        btnLoginGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInIntent = googleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, 101);
            }
        });

        //membuat listener button Login
        btnLogin.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                String email = loginEmail.getText ().toString ();
                final String password = loginPassword.getText ().toString ();

                //validasi
                if (TextUtils.isEmpty ( email )){
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                //progressbar muncul
                progressBar.setVisibility ( View.VISIBLE );

                //autentikasi user
                auth.signInWithEmailAndPassword ( email,password )
                        .addOnCompleteListener ( LoginActivity.this, new OnCompleteListener<AuthResult> () {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                progressBar.setVisibility ( View.GONE );
                                if (!task.isSuccessful ()){
                                    //kalo ada error
                                    if (password.length () < 6){
                                        loginPassword.setError ( getString ( R.string.minimum_password) );
                                    } else {
                                        Toast.makeText ( LoginActivity.this, getString ( R.string.auth_failed ), Toast.LENGTH_LONG ).show ();
                                    }
                                } else {
                                    Intent intent = new Intent ( LoginActivity.this, DashboardMain.class );
                                    startActivity ( intent );
                                    finish ();
                                }
                            }
                        } );
            }
        } );
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK)
            switch (requestCode) {
                case 101:
                    try {
                        // The Task returned from this call is always completed, no need to attach
                        // a listener.
                        Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
                        GoogleSignInAccount account = task.getResult( ApiException.class);
                        onLoggedIn(account);
                    } catch (ApiException e) {
                        // The ApiException status code indicates the detailed failure reason.
                        Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
                    }
                    break;
            }
    }

    private void onLoggedIn(GoogleSignInAccount googleSignInAccount) {
        Intent intent = new Intent(this, DashboardMain.class);
//        intent.putExtra(DisplayProfile.GOOGLE_ACCOUNT, googleSignInAccount);

        startActivity(intent);
        finish();
    }

    @Override
    public void onStart() {
        super.onStart();
        GoogleSignInAccount alreadyloggedAccount = GoogleSignIn.getLastSignedInAccount(this);
        if (alreadyloggedAccount != null) {
            Toast.makeText(this, "Already Logged In", Toast.LENGTH_SHORT).show();
            onLoggedIn(alreadyloggedAccount);
        } else {
            Log.d(TAG, "Not logged in");
        }
    }


    public void toSignUp(View view){
        startActivity ( new Intent ( LoginActivity.this, Register.class ) );
        finish ();
    }

    public void toForgot(View view){
        startActivity ( new Intent ( LoginActivity.this, ForgotPassword.class ) );
        finish ();
    }
}