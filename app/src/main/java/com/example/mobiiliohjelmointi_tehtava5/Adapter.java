package com.example.mobiiliohjelmointi_tehtava5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

class Adapter extends ArrayAdapter<JSONObject>{

    Context context;
    ArrayList<JSONObject> data;
    int resource;

    public Adapter(@NonNull Context context, int resource, @NonNull ArrayList<JSONObject> objects) {
        super(context, resource, objects);
        this.data = objects;
        this.resource = resource;
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater i = LayoutInflater.from(context);
        convertView = i.inflate(resource, parent, false);

        TextView nameText = (TextView) convertView.findViewById(R.id.NameText);
        TextView dateText = (TextView) convertView.findViewById(R.id.DateText);

        try {
            nameText.setText(data.get(position).getString("nimi"));
            dateText.setText(date(data.get(position).getString("pvm")));
        } catch(Exception e) {
            System.out.println("Jotain meni nyt pieleen " + e.getMessage());
        }


        return convertView;

    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    public String date(String date) {

        String[] parts = date.split(" ");
        return parts[0];
    }
}