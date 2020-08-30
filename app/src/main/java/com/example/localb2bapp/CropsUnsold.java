package com.example.localb2bapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CropsUnsold extends AppCompatActivity {

    public static ArrayList<Crops> cropList= new ArrayList<Crops>();
    private static FirebaseDatabase mDatabase;
    private static DatabaseReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        cropList=new ArrayList<Crops>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crops_unsold);
        getCropList();
    }

    public void getCropList() {
        mDatabase = FirebaseDatabase.getInstance();
        ref = mDatabase.getReference("crops");


        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Crops cropReader;


                for (DataSnapshot child : snapshot.getChildren()) {


                    cropReader = child.getValue(Crops.class);
                    boolean a;
                    String b= cropReader.getPhoneNo();
                    if (cropReader.getPhoneNo().equalsIgnoreCase(CurrentFarmer.CURRENT_PHONE))
                           a =true;
                    else
                           a=false;

                    if(a)
                    CropsUnsold.cropList.add(cropReader);


                }
                    inflate();

            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void inflate()
    {  ListView listView=(ListView)findViewById(R.id.unsoldCropsList);
        CropAdapter cropAdapter= new CropAdapter(this,CropsUnsold.cropList);
        listView.setAdapter(cropAdapter);

    }

}