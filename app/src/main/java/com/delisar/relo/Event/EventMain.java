package com.delisar.relo.Event;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.delisar.relo.R;
import com.delisar.relo.Event.interfaceAPI;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EventMain extends AppCompatActivity {
    private RecyclerView.LayoutManager layoutManager;
    private adapterEvent adapterAPI;
    private RecyclerView rv_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setupSharedPreferences ();
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_event_main );

        rv_data = findViewById ( R.id.rv_event );

        layoutManager = new LinearLayoutManager ( getApplicationContext () );
        setDataFromAPI();
    }

    public void setDataFromAPI(){
        interfaceAPI interfaceAPI = serviceAPI.getAPIdata ().create ( interfaceAPI.class);
        Call<responseAPI> call = interfaceAPI.getMovieData ();
        call.enqueue ( new Callback<responseAPI> () {
            @Override
            public void onResponse(Call<responseAPI> call, Response<responseAPI> response) {
                ArrayList<dataAPI> dataAPIArrayList = response.body().getResults();
                adapterAPI = new adapterEvent ( dataAPIArrayList, getApplicationContext () );

                rv_data.setLayoutManager ( layoutManager );
                rv_data.setHasFixedSize ( true );
                rv_data.setAdapter ( adapterAPI );
            }

            @Override
            public void onFailure(Call<responseAPI> call, Throwable t) {
                Toast.makeText ( getApplicationContext (), "Network error", Toast.LENGTH_LONG ).show ();
            }
        } );
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
