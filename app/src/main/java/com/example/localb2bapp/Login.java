package com.example.localb2bapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.DragAndDropPermissions;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }
    public void profile(View view)
    {
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        ref= mFirebaseDatabase.getReference("farmer");
        String name,phone,ekrishi;
        TextView reader = (TextView)findViewById(R.id.phoneLogin);
        CurrentFarmer.CURRENT_PHONE=reader.getText().toString();
        Log.e("lol",CurrentFarmer.CURRENT_PHONE);
        Intent i = new Intent(this,Profile.class);
        startActivity(i);
    }
}