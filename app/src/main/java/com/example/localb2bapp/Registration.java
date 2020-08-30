package com.example.localb2bapp;

import androidx.annotation.RequiresPermission;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class Registration extends AppCompatActivity {
    private FirebaseDatabase mDatabase;
    private DatabaseReference mDatabaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mDatabase=FirebaseDatabase.getInstance();
        mDatabaseReference= mDatabase.getReference("farmer");
    }
    public void registerNew(View view) {
        String gName, gPhone, gEKrishi;
        TextView Reader = (TextView) findViewById(R.id.registerNameText);
        gName = Reader.getText().toString();
        Reader = (TextView) findViewById(R.id.registerPhoneText);
        gPhone = Reader.getText().toString();
        Reader = (TextView) findViewById(R.id.registerEKrishi);
        gEKrishi = Reader.getText().toString();
        Farmer newFarmer= new Farmer(gName,gPhone,gEKrishi);
        mDatabaseReference.child(gPhone).setValue(newFarmer);

        Intent i = new Intent(this,Login.class);
        startActivity(i);


    }

}