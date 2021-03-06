package com.delisar.relo.Dashboard;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.delisar.relo.Category.CategoryMain;
import com.delisar.relo.Community.CommunityMain;
import com.delisar.relo.ContactUs.ContactUsMain;
import com.delisar.relo.ContactUsNew.ContactUsNew;
import com.delisar.relo.Event.EventMain;
import com.delisar.relo.FAQ.FAQMain;
import com.delisar.relo.Transaksi.HistoryMain;
import com.delisar.relo.PreApps.LogoutActivity;
import com.delisar.relo.Profile.ImageActivity;
import com.delisar.relo.R;
import com.delisar.relo.Setting.SettingsMain;
import com.delisar.relo.Transaksi.TransaksiMain;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class DashboardMain extends AppCompatActivity implements View.OnClickListener{

    List<News> newsList;
    RecyclerView recyclerView;
    private Boolean isFabOpen = false;
    private FloatingActionButton fab,fab1,fab2, fab3, fab4, fab5, fab6,fab7;
    private Animation fab_open,fab_close,rotate_forward,rotate_backward;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setupSharedPreferences ();
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_dashboard );

        Toolbar toolbar = findViewById ( R.id.toolbar );
        setSupportActionBar ( toolbar ); //WHY KAMU BUAT ERROR:(
        //Remove Default Title
        getSupportActionBar ().setDisplayShowTitleEnabled ( false );


        //Untuk Floating Button Menu
        fab = (FloatingActionButton)findViewById(R.id.fab);
        fab1 = (FloatingActionButton)findViewById(R.id.fab1);
        fab2 = (FloatingActionButton)findViewById(R.id.fab2);
        fab3 = (FloatingActionButton) findViewById(R.id.fab3);
        fab4 = (FloatingActionButton) findViewById(R.id.fab4);
        fab5 = (FloatingActionButton) findViewById(R.id.fab5);
        fab7 = (FloatingActionButton) findViewById(R.id.fab7);

        fab6 = (FloatingActionButton) findViewById(R.id.fab6);


        //Floating Button TransaksiMain
        fab6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardMain.this, TransaksiMain.class);
                startActivity(intent);
            }
        });

        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        rotate_forward = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_forward);
        rotate_backward = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_backward);
        fab.setOnClickListener(this);
        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);
        fab3.setOnClickListener(this);
        fab4.setOnClickListener(this);
        fab5.setOnClickListener(this);
        fab7.setOnClickListener(this);

        recyclerView = (RecyclerView) findViewById ( R.id.recyclerView );
        recyclerView.setHasFixedSize ( true );
        recyclerView.setLayoutManager ( new LinearLayoutManager ( this ) );

        newsList = new ArrayList<> ();

        newsList.add ( new News ( 1, R.drawable.list1, "Bencana Tanah Longsor",
                "If you'd like to create a list with cards, as shown in figure 2, also use the CardView widget as described in Create a Card-based Layout."
        ) );

        newsList.add ( new News ( 1, R.drawable.list1, "Bencana Tanah Longsor",
                "If you'd like to create a list with cards, as shown in figure 2, also use the CardView widget as described in Create a Card-based Layout."
        ) );

        newsList.add ( new News ( 1, R.drawable.list1, "Banjir",
                "If you'd like to create a list with cards, as shown in figure 2, also use the " +
                        "CardView widget as described in Create a Card-based" ) );

        newsList.add ( new News ( 1, R.drawable.list1, "Bencana X",
                "khaskjdhakjshdahdkhadkjhaksdhkadhkajdh" ) );

        DashboardAdapter adapter = new DashboardAdapter ( this, newsList );
        recyclerView.setAdapter ( adapter );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater ().inflate ( R.menu.menu_main, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId ();

        if (id == R.id.notif) {
            Intent inten = new Intent ( this, ImageActivity.class );
            this.startActivity ( inten );
            return true;
        } else if (id == R.id.action_settings){
            this.startActivity ( new Intent ( this, SettingsMain.class ) );
            return true;
        } else if (id == R.id.action_logout){
//            mAuth.signOut ();
            this.startActivity ( new Intent ( this, LogoutActivity.class ) );
            finish ();
            return true;
        }

        return super.onOptionsItemSelected ( item );
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.fab:
                animateFAB();
                break;
            case R.id.fab1:
                //community
                Intent intentCommunity = new Intent (DashboardMain.this, CommunityMain.class);
                startActivity(intentCommunity);
                Log.d("FAB1", "Fab 1");
                break;
            case R.id.fab2:
                //category
                startActivity ( new Intent ( DashboardMain.this, CategoryMain.class ) );
                Log.d("FAB2", "Fab 2");
                break;
            case R.id.fab3:
                //history
                startActivity ( new Intent ( DashboardMain.this, EventMain.class ) );
                Log.d("FAB3", "Fab 3");
                break;
            case R.id.fab4:
                //faq
                Intent intentFAQ = new Intent (DashboardMain.this, FAQMain.class);
                startActivity(intentFAQ);
                Log.d("FAB4", "Fab 4");
                break;
            case R.id.fab5:
                //contact us
                startActivity ( new Intent ( DashboardMain.this, ContactUsNew.class ) );
                Log.d("FAB5", "Fab 5");
                break;
            case R.id.fab7:
                //event
                startActivity ( new Intent ( DashboardMain.this, ContactUsNew.class ) );
                Log.d("FAB5", "Fab 5");
                break;
        }
    }

    public void animateFAB(){
        if(isFabOpen){
            fab.startAnimation(rotate_backward);
            fab1.startAnimation(fab_close);
            fab2.startAnimation(fab_close);
            fab3.startAnimation(fab_close);
            fab4.startAnimation(fab_close);
            fab5.startAnimation(fab_close);
            fab7.startAnimation(fab_close);
            fab1.setClickable(false);
            fab2.setClickable(false);
            fab3.setClickable(false);
            fab4.setClickable(false);
            fab5.setClickable(false);
            fab7.setClickable(false);

            isFabOpen = false;
            Log.d("FAB", "close");
        } else {
            fab.startAnimation(rotate_forward);
            fab1.startAnimation(fab_open);
            fab2.startAnimation(fab_open);
            fab3.startAnimation(fab_open);
            fab4.startAnimation(fab_open);
            fab5.startAnimation(fab_open);
            fab7.startAnimation(fab_open);
            fab1.setClickable(true);
            fab2.setClickable(true);
            fab3.setClickable(true);
            fab4.setClickable(true);
            fab5.setClickable(true);
            fab7.setClickable(true);

            isFabOpen = true;
            Log.d("FAB","open");
        }
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
