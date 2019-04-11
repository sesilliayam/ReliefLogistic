package com.delisar.relo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<News> newsList;
    RecyclerView recyclerView;
    FloatingActionButton faba, fabb, fabc, fabd;
    private boolean isFABOpen = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_dashboard );

        Toolbar toolbar = findViewById ( R.id.toolbar );
        setSupportActionBar ( toolbar ); //WHY KAMU BUAT ERROR:(
        //Remove Default Title
        getSupportActionBar ().setDisplayShowTitleEnabled ( false );

        //Get Custom Title
        TextView mTitle = (TextView) toolbar.findViewById ( R.id.toolbar_title );

        //Floating Button Transaksi
        FloatingActionButton fab2 = findViewById ( R.id.fab2 );
        FloatingActionButton faba = findViewById ( R.id.faba );
        FloatingActionButton fabb = findViewById ( R.id.fabb );
        FloatingActionButton fabc = findViewById ( R.id.fabc );
        FloatingActionButton fabd = findViewById ( R.id.fabd );

        fab2.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                if (!isFABOpen) {
                    showFABMenu ();
                } else {
                    closeFABMenu ();
                }
            }
        } );


        //Floating Button Menu
        FloatingActionButton fab1 = findViewById ( R.id.fab1 );
        fab1.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                startActivity ( new Intent(MainActivity.this, LoginActivity.class) );
        }
        } );

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
                "If you'd like to create a list with cards, as shown in figure 2, also use the CardView widget as described in Create a Card-based" ) );

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
            Intent inten = new Intent ( this, Profile.class );
            this.startActivity ( inten );
            return true;
        }
        return super.onOptionsItemSelected ( item );
    }

    private void showFABMenu() {
        boolean isFABOpen = true;
        faba.animate ().translationY ( -getResources ().getDimension ( R.dimen.standard_55 ) );
        fabb.animate ().translationY ( -getResources ().getDimension ( R.dimen.standard_105 ) );
        fabc.animate ().translationY ( -getResources ().getDimension ( R.dimen.standard_155 ) );
        fabd.animate ().translationY ( -getResources ().getDimension ( R.dimen.standard_205 ) );

    }

    private void closeFABMenu() {
        boolean isFABOpen = false;
        faba.animate ().translationY ( 0 );
        fabb.animate ().translationY ( 0 );
        fabc.animate ().translationY ( 0 );
        fabd.animate ().translationY ( 0 );
    }
}



