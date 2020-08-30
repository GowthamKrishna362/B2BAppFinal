package com.example.localb2bapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity {
    private FirebaseDatabase mDatabase;
    private DatabaseReference ref ;
    private ChildEventListener mChildEventListener;
    public Farmer localFarmer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        TextView write= (TextView)findViewById(R.id.displayName);
        mDatabase=FirebaseDatabase.getInstance();
        ref= mDatabase.getReference("farmer");
        ref.addListenerForSingleValueEvent( new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
               //Log.e("Farmer", localFarmer.getName());
                for(DataSnapshot child:snapshot.getChildren()) {

                    localFarmer = child.getValue(Farmer.class);
                    if (localFarmer.getPhoneNo().equals(CurrentFarmer.CURRENT_PHONE)) {
                        TextView textView = (TextView) findViewById(R.id.displayName);
                        textView.setText(localFarmer.getName());
                        textView = (TextView) findViewById(R.id.phoneNoDsiplay);
                        textView.setText(localFarmer.getPhoneNo());

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }







    public void myCrops(View view)
    {
        Intent i = new Intent (this,MyCrops.class);
        startActivity(i);
    }

    public void uploadCrop(View view)
    {
        Intent i = new Intent(this,UploadCrop.class);
        startActivity(i);
    }

}