package com.example.karunakar.pizzasapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 27/4/17.
 */
public class AdminLoginActivity extends AppCompatActivity {

    EditText adminUname,adminpass;
    Button admin_log;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);

        adminUname=(EditText)findViewById(R.id.adminUname);
        adminpass=(EditText) findViewById(R.id.adminpass);
        admin_log=(Button)findViewById(R.id.admin_log);
        admin_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=adminUname.getText().toString();
                String upass=adminpass.getText().toString();
                adminLogData(username,upass);
            }
        });


    }

    private void adminLogData(final String username, final String upass) {
        StringRequest stringReq=new StringRequest(Request.Method.POST, Config.logroot_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
               // Toast.makeText(getApplicationContext(),response.trim().toString(),Toast.LENGTH_SHORT).show();
                String admin="admin";
                if(admin.equals(response.trim().toString())){
                    //Toast.makeText(getApplicationContext(),response.trim().toString(),Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(AdminLoginActivity.this,AdminActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Invalid Admin details",Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params=new HashMap<String, String>();
                Config conf=new Config();
                params.put(conf.name,username);
                params.put(conf.pass,upass);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringReq);
    }
}
