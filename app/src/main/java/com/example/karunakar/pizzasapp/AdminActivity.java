package com.example.karunakar.pizzasapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AdminActivity extends AppCompatActivity {

    ListView order_list;
    //TextView items;
    ArrayList<Order> orders=new ArrayList<Order>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        //items=(TextView)findViewById(R.id.items);
        order_list=(ListView)findViewById(R.id.order_list);
        //items.setText("");
        RequestQueue requestQueue = Volley.newRequestQueue(AdminActivity.this);

        JsonArrayRequest reg=new JsonArrayRequest(Config.orderlist_url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try {
                    // Parsing json array response
                    // loop through each json object
                    for (int i = 0; i < response.length(); i++) {

                        Order order=new Order();

                        JSONObject person = (JSONObject) response
                                .get(i);

                        String name = person.getString("name");
                        String item=person.getString("item");
                        String price=person.getString("price");
                        String hno=person.getString("hno");
                        String area=person.getString("area");
                        String city=person.getString("city");
                        String phone=person.getString("phone");

                        order.setItemname(item);
                        order.setNumofitems(3+"");
                        order.setCustname(name);
                        order.setCustphn(phone);

                        //items.append("Name:\t"+name+"\n"+"item:\t"+item+"\t"+"\t"+price+"\naddress:\t"+"H-no: "+hno+"\t"+"\t"+area+"\t"+"\t"+city+"\nphone:\t"+phone);
                        //items.append("\n"+"\n");
                        orders.add(order);


                    }
                   OrderAdapter arrayAdapter=new OrderAdapter(getApplicationContext(),orders);
                    order_list.setAdapter(arrayAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),
                            "Error: " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(reg);
    }
}
