package com.delisar.relo;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import java.util.Locale;

public class Profile extends AppCompatActivity {
    private TextInputEditText txtDisplayName, txtUsername, txtEmail, txtPhone, txtAddress;
    private String DisplayName, Username, Email, Phone, Address;
    private ProgressDialog loading;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // initialize input form view
        txtDisplayName = (TextInputEditText) findViewById(R.id.edDisplayName);
        txtUsername = (TextInputEditText) findViewById(R.id.edUsername);
        txtEmail = (TextInputEditText) findViewById(R.id.edEmail);
        txtPhone = (TextInputEditText) findViewById(R.id.edPhone);
        txtAddress = (TextInputEditText) findViewById(R.id.edAddress);

        loading = new ProgressDialog(this);
        loading.setIndeterminate(true);
        loading.setCancelable(false);
        loading.setCanceledOnTouchOutside(false);

        this.fecthUser();
    }

    private void fecthUser() {
        // showing a progress dialog loading
        loading.setMessage("Fetching user profile...");
        loading.show();

        final Rello user = Rello.getCurrentUser();
        if (user != null) {
            user.fecthAsync(new GetCallBack<Rello>() {
                @Override
                public void done (Rello rello, RelloException e) {
                    //hide progress dialog loading
                    loading.dismiss();

                    //check if there is an exception happen
                    if(e != null) {
                        // setup alert dialog builder
                        AlertDialog.Builder builder = new AlertDialog.Builder(profile.this);
                        builder.setNegativeButton(android.R.string.ok, null);
                        builder.setTitle("Error Happen");
                        builder.setMessage(
                                String.format(Locale.getDefault(), "Error code: %d\nDescription: %s",
                                        e.getCode(), e.getMessage())
                        );
                        dialog = builder.show();
                        return;
                    }
                    Toast.makeText(ContactsContract.Profile.this, "Profile Fetched", Toast.LENGTH_SHORT).show();
                    updateView(user);
                }
            });
        }
    }
    private void updateView(Rello user) {
        if (user != null) {
            txtDisplayName.setText(user.getDisplayName());
            txtUsername.setText(user.getUsername());
            txtEmail.setText(user.getEmail());
            txtPhone.setText(user.getPhone());
            txtAddress.setText(user.getAddress());

            RelloObject data = user.getData();
            if (data != null) {

                String displayname = data.optString("Display Name");
                txtDisplayName.setText(String.valueOf(displayname));

                String username = data.optString("Username");
                txtUsername.setText(String.valueOf(username));

                String email = data.optString("Email");
                txtEmail.setText(String.valueOf(email));

                String phone = data.optString("Phone");
                txtPhone.setText(String.valueOf(phone));

                String address = data.optString("Address");
                txtAddress.setText(String.valueOf(address));

            }
        }
    }

    public void handleUpdateProfile(View view) {
        // get all value from input
        DisplayName = txtDisplayName.getText().toString();
        Username = txtUsername.getText().toString();
        Email = txtEmail.getText().toString();
        Phone = txtPhone.getText().toString();
        Address = txtAddress.getText().toString();

        // validating input values
        if (!isInputProfileValid()) {
            // return if there is an invalid input
            return;
        }

        // execute update profile
        updateProfile();
    }

    private boolean isInputProfileValid() {
        // validating all input values if it is empty
        if (TextUtils.isEmpty(DisplayName)) {
            Toast.makeText(this, "Display Name is empty", Toast.LENGTH_LONG).show();
            return false;
        }
        if (TextUtils.isEmpty(Username)) {
            Toast.makeText(this, "Username is empty", Toast.LENGTH_LONG).show();
            return false;
        }
        if (TextUtils.isEmpty(Email)) {
            Toast.makeText(this, "Email is empty", Toast.LENGTH_LONG).show();
            return false;
        }
        if (TextUtils.isEmpty(Phone)) {
            Toast.makeText(this, "Email is empty", Toast.LENGTH_LONG).show();
            return false;
        }
        else (TextUtils.isEmpty(Address)) {
            Toast.makeText(this, "Email is empty", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    private void updateProfile() {
        // showing a progress dialog loading
        loading.setMessage("Updating user profile...");
        loading.show();

        Rello user = Rello.getCurrentUser();
        if (user != null) {
            user.setDisplayName(DisplayName);
            user.setUsername(Username);
            user.setEmail(Email);
            user.setPhone(Phone);
            user.setAddress(Address);

            // execute update user
            user.updateDataAsync(new SaveCallback() {
                @Override
                public void done(RelloException e) {
                    // hide progress dialog loading
                    loading.dismiss();

                    // setup alert dialog builder
                    AlertDialog.Builder builder = new AlertDialog.Builder(ContactsContract.Profile.this);
                    builder.setNegativeButton(android.R.string.ok, null);

                    // check if there is an exception happen
                    if (e != null) {
                        builder.setTitle("Error Happen");
                        builder.setMessage(
                                String.format(Locale.getDefault(), "Error code: %d\nDescription: %s",
                                        e.getCode(), e.getMessage())
                        );
                        dialog = builder.show();
                        return;
                    }

                    builder.setMessage("Update Profile Succeeded");
                    dialog = builder.show();
                }
            });
        }
    }

    public void handleProfile(View view) {
        Intent intent = new Intent(this, ContactsContract.Profile.class);
        startActivity(intent);
    }

}
