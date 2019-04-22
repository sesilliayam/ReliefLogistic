package com.delisar.relo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.CountDownTimer;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    private TextView mTitle;
    private AlphaAnimation fadeOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

//        getSupportActionBar().hide();

        //Setting SplashScreen
        fadeOut = new AlphaAnimation(0.0f, 1.0f);
        mTitle = (TextView)findViewById(R.id.title);

        mTitle.startAnimation(fadeOut);
        fadeOut.setDuration(2000);
        fadeOut.setFillAfter(true);

        //              duration, interval
        new CountDownTimer(5000, 1000) {
            @Override
            public void onTick( long millisUntilFinished ) {

            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish ();
            }
        }.start();
    }
}