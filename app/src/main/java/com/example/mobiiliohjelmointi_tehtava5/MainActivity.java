package com.example.mobiiliohjelmointi_tehtava5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

public class MainActivity extends AppCompatActivity {

    RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        queue= Volley.newRequestQueue(this);

        ConnectivityManager cm= (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);

        //ONCLICK METODISSA
        //GOOGLEN LUOKKAKIRJASTO GSON serialisointiin ja deserialisointiin

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JsonArrayRequest request = new JsonArrayRequest(
                        "https://webd.savonia.fi/home/ktkoiju/j2me/test_json.php?dates&delay=1",
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }
                );
                queue.add(request);
            }
        });




    }
}
