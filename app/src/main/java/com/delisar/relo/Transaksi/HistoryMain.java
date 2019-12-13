package com.delisar.relo.Transaksi;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.delisar.relo.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class HistoryMain extends AppCompatActivity {

    //deklarasi komponen
    RecyclerView recyclerView;
    private ArrayList<Transaksi> arrayHistory;
    private HistoryAdapter historyAdapter;
//
    //deklarasi database
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setupSharedPreferences ();
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_event );

//        mDialog = new Dialog ( this );

        //menjalankan method addData pada pertama kali dijalankan
        addDataHistory ();

        //inisialisasi komponen
        recyclerView = findViewById ( R.id.recyclerHistory );

        historyAdapter = new HistoryAdapter (arrayHistory);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager ( HistoryMain.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(historyAdapter);

    }

    //mengisi arraylist dengan method addData
    public void addDataHistory(){
        arrayHistory = new ArrayList<>();
//        arrayHistory.add(new Transaksi ("Category 1", "Barang jangka panjang"));
//        arrayHistory.add(new Transaksi ("Category 2", "Barang jangka pendek"));
        DatabaseReference database = FirebaseDatabase.getInstance().getReference ();
        DatabaseReference reference = database.child ( "Transaksi" );

    }

    public void toDetail(View v) {
//        TextView txtclose, headDetail, txtDetail;
//        Button btnFollow;
//        mDialog.setContentView(R.layout.activity_category_detail_popup);
//        txtclose =(TextView) mDialog.findViewById(R.id.txt_close);
//        headDetail = (TextView) mDialog.findViewById ( R.id.head_detailCategory );
//        txtDetail = (TextView) mDialog.findViewById ( R.id.txt_detailCategory );
//
//        txtclose.setText("Close");
//        txtclose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mDialog.dismiss();
//            }
//        });
//        mDialog.getWindow().setBackgroundDrawable(new ColorDrawable ( Color.TRANSPARENT));
//        mDialog.show();
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