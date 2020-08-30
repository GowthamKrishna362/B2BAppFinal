package com.example.localb2bapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToLogin (View view)
    {
        Intent i= new Intent (this,Login.class);
        startActivity(i);
    }

    public void goToRegistration(View view)
    {
        Intent i= new Intent(this,Registration.class);
        startActivity(i);
    }



}