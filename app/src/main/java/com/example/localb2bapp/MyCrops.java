package com.example.localb2bapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MyCrops extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_crops);
    }

    public void goToUnsoldCrops(View view)
    {
        Intent i = new Intent(this,CropsUnsold.class);
        startActivity(i);
    }

}