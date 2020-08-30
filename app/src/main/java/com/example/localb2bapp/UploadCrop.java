package com.example.localb2bapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UploadCrop extends AppCompatActivity {
    private FirebaseDatabase mDatabase;
    private DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_crop);

        mDatabase=FirebaseDatabase.getInstance();
        ref= mDatabase.getReference("crops");


    }

    public void submitCrop(View view)
    {
    Crops cropToBePushed= createCropToPush();
    ref.push().setValue(cropToBePushed);


    }
    public Crops createCropToPush()
    {

        String cropType,phoneNo,quantity,rate;

        Spinner spinnerReader= (Spinner)findViewById(R.id.uploadCropType);
        cropType= spinnerReader.getSelectedItem().toString();

        TextView textViewReader= (TextView)findViewById(R.id.uploadRate);
        rate = textViewReader.getText().toString();

        textViewReader=(TextView)findViewById(R.id.uploadQuantity);
        quantity=textViewReader.getText().toString();

        phoneNo=CurrentFarmer.CURRENT_PHONE;
        Crops result= new Crops(cropType,rate,quantity,phoneNo);

        return result;
    }

}