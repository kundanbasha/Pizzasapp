package com.example.karunakar.pizzasapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.HashMap;
import java.util.Map;

public class ItemOrder extends AppCompatActivity {

    public Button ButtonS;
    EditText hno, city, area, phone;
    TextView type, price;
    Bundle bundle;
    String person;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_order);
        bundle = getIntent().getExtras();
        type = (TextView) findViewById(R.id.item);
        price = (TextView) findViewById(R.id.price);
        type.setText(bundle.getString("type").toString());
        price.setText(bundle.getString("price").toString());
        addListenerOnButton();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
    }

    private void addListenerOnButton() {
        final Context context = this;

        hno = (EditText) findViewById(R.id.hno);
        city = (EditText) findViewById(R.id.citi);
        area = (EditText) findViewById(R.id.arrea);
        phone = (EditText) findViewById(R.id.phn);


        final String personOrder = LoginActivity.refUser;

        ButtonS = (Button) findViewById(R.id.order);

        ButtonS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOrder(personOrder, bundle.getString("type").toString(), bundle.getString("price").toString(), hno.getText().toString(), city.getText().toString(), area.getText().toString(), phone.getText().toString());
            }
        });
    }

    private void sendOrder(final String per,final String type, final String price, final String s, final String s1, final String s2, final String s3) {
        Toast.makeText(ItemOrder.this,per,Toast.LENGTH_SHORT).show();
        StringRequest stringReq = new StringRequest(Request.Method.POST, Config.orderroot_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), response.trim().toString()+" hello", Toast.LENGTH_SHORT).show();
                String res = "success";
                if (res.equals(response.trim().toString())) {
                    Toast.makeText(getApplicationContext(), response.trim().toString(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "please register...", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                Config conf = new Config();
                params.put(conf.name, per);
                params.put(conf.item, type);
                params.put(conf.price, price);
                params.put(conf.hno, s);
                params.put(conf.city, s1);
                params.put(conf.area, s2);
                params.put(conf.phone, s3);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringReq);
    }


}
