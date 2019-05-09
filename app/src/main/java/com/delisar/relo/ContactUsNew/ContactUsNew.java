package com.delisar.relo.ContactUsNew;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.delisar.relo.R;

public class ContactUsNew extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setupSharedPreferences ();
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_contact_us_new );
    }

    private void setupSharedPreferences() {
        SharedPreferences prefs = getSharedPreferences(getPackageName(), MODE_PRIVATE);
        toggleTheme(prefs.getBoolean("nightMode",false));

    }

    //memanggil tema
    public void toggleTheme(Boolean bo){
        if (bo){
            setTheme(R.style.dark);
        }else{
            setTheme(R.style.light);
        }

    }
}
