package com.delisar.relo.Transaksi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.delisar.relo.Dashboard.DashboardMain;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import com.delisar.relo.R;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransaksiMain extends AppCompatActivity {

    //initialize the UI Component
    EditText edtName, edtPhone, edtEmail, edtAddress, edtToDonation, edtDesc;
    Button btnDonation;
    Spinner spItem;
    //array to Spinner
    String[] listSpCategory;
    //array value to Spinner
    String[] listCategory = {"Kategori 1 (Barang Jangka Panjang)",
            "Kategori 2 (Barang Pokok)", "Kategori 3 (Barang Habis Pakai)"};

    //ListView Transaksi
//    ListView listViewTransaksi;

    //a list to store Transaction's data
    List<Transaksi> Transaksis;

    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setupSharedPreferences ();
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_transaksi );

        //assign the component
        edtName = findViewById ( R.id.edt_nameTransaction );
        edtPhone = findViewById ( R.id.edt_phoneTransaction );
        edtEmail = findViewById ( R.id.edt_emailTransaction );
        edtAddress = findViewById ( R.id.edt_addressTransaction );
        edtToDonation = findViewById ( R.id.edt_toDonation );
        edtDesc = findViewById ( R.id.edt_description );
        btnDonation = findViewById ( R.id.btn_donation );

        spItem = findViewById ( R.id.sp_categoryDonation );
        listSpCategory = new String[listCategory.length];
        //assign the list
        for (int i = 0; i<listCategory.length; i++){
            listSpCategory[i] = listCategory[i];
        }

        databaseReference = FirebaseDatabase.getInstance().getReference("Transaksi");

        //adding spinner adapter
        final ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,listSpCategory);
        spItem.setAdapter(adapter);

        initListner ();

        Transaksis = new ArrayList<> (  );
    }

    private void initListner() {
        //adding an onclicklistener to button
        btnDonation.setOnClickListener(new View.OnClickListener()      {
            @Override
            public void onClick(View view) {
                //calling the method addUser()
                //the method is defined below
                //this method is actually performing the write operation
                addTransaction ();
            }
        });


//        // list item click listener
//        listViewTransaksi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Transaksi Transaksi = Transaksi.get(i);
//                CallUpdateAndDeleteDialog(Transaksi.getNameDonatur (), Transaksi.getPhoneDonatur (),
//                        Transaksi.getEmailDonatur (), Transaksi.getAddressDonatur (),
//                        Transaksi.getToDonationWho (), Transaksi.getItemCategory (),
//                        Transaksi.getDonationDescription ());
//            }
//        });
    }

    private void addTransaction() {

        //getting the values to save
        String name = edtName.getText().toString().trim();
        String phone  = edtPhone.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();
        String address = edtAddress.getText().toString().trim();
        String toDonation = edtToDonation.getText().toString().trim();
        String category = listCategory[spItem.getSelectedItemPosition ()];
        String desc = edtDesc.getText().toString().trim();

        //for date format
        SimpleDateFormat dateFormat = new SimpleDateFormat ( "dd-MM-yyyy 'at' HH:mm:ss z" );

        //mengisi tanggal
        String dateTransaction = dateFormat.format ( new Date () );

        //checking if the value is provided or not Here, you can Add More Validation as you required

        if (!TextUtils.isEmpty(name)) {
            if (!TextUtils.isEmpty(phone)) {
                if (!TextUtils.isEmpty(email)) {
                    if (!TextUtils.isEmpty ( address )){
                        if (!TextUtils.isEmpty ( toDonation )){
                            if (!TextUtils.isEmpty ( desc )){
                                //it will create a unique id and we will use it as the Primary Key for our User
                                String id = databaseReference.push().getKey();
                                //creating an User Object
                                Transaksi Transaksi = new Transaksi (name, phone, email, address, toDonation, category, desc, dateTransaction );
                                //Saving the User
                                databaseReference.child(id).setValue(Transaksi);
                                edtName.setText("");
                                edtPhone.setText("");
                                edtEmail.setText("");
                                edtAddress.setText("");
                                edtToDonation.setText("");
                                spItem.setSelection ( 0 );
                                edtDesc.setText("");

                                Toast.makeText(this, "Transaksi berhasil dibuat", Toast.LENGTH_LONG).show();
                                startActivity ( new Intent ( TransaksiMain.this, DashboardMain.class ) );
                                finish ();
                            }else{
                                //empty description validation
                                Toast.makeText(this, "Deskripsi tidak boleh kosong!", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            //validation for to Donation
                            Toast.makeText(this, "Tujuan Donasi tidak boleh kosong!", Toast.LENGTH_LONG).show();
                        }
                    }else {
                        //address is empty validation
                        Toast.makeText(this, "Alamat tidak boleh kosong!", Toast.LENGTH_LONG).show();
                    }
                } else {
                    //empty email validation
                    Toast.makeText(this, "Email tidak boleh kosong!", Toast.LENGTH_LONG).show();
                }
            } else {
                //empty phone validation
                Toast.makeText(this, "Nomor Telefon tidak boleh kosong!", Toast.LENGTH_LONG).show();
            }
        } else {
            //empty name validation
            Toast.makeText(this, "Nama tidak boleh kosong!", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.addValueEventListener(new ValueEventListener () {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //clearing the previous User list
                Transaksis.clear();
                //getting all nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting User from firebase console
                    Transaksi Transaksi = postSnapshot.getValue(Transaksi.class);
                    //adding User to the list
                    Transaksis.add(Transaksi);
                }
//                //creating Userlist adapter
//                UserList UserAdapter = new UserList(MainActivity.this, Users);
//                //attaching adapter to the listview
//                listViewUsers.setAdapter(UserAdapter);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void ToMaps(View view) {
        Intent intent = new Intent(this, TransaksiMaps.class);
        startActivity(intent);
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