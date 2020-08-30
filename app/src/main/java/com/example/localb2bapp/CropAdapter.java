package com.example.localb2bapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CropAdapter extends ArrayAdapter<Crops> {


    public CropAdapter(Activity context, ArrayList<Crops> cropsArrayList)
    {
        super(context,0,cropsArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Crops currentCrop= getItem(position);

        View listItemView = convertView;
        if(listItemView==null)
        {
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.croplistview,parent,false);

        }

        TextView writer = (TextView)listItemView.findViewById(R.id.quantityView);
                writer.setText("Quantity: "+ currentCrop.getQuantity());

        writer=(TextView)listItemView.findViewById(R.id.nameView);
                writer.setText("Crop Type: " +currentCrop.getCropType());

        writer=(TextView)listItemView.findViewById(R.id.rateView);
                writer.setText("Rate: "+ currentCrop.getRate());

        return listItemView;
    }
}
