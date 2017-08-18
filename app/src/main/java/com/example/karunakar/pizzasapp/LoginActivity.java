package com.example.karunakar.pizzasapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.example.karunakar.pizzasapp.R;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String name = "username";
    public static final String pass = "pass";
    public static final String Islog = "islog";
    public static SharedPreferences sharedpreferences;

    EditText user,pwd;
    Button signin,signup,admin;
    public static String refUser="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user=(EditText)findViewById(R.id.uname);
        pwd=(EditText)findViewById(R.id.pass);
        signin=(Button)findViewById(R.id.signin);
        signup=(Button)findViewById(R.id.reg);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=user.getText().toString();
                String upass=pwd.getText().toString();
                logData(username,upass);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegActivity.class);
                startActivity(intent);
            }
        });
        admin = (Button)findViewById(R.id.btnAdmin);
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this,AdminLoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void logData(final String username, final String upass) {
        StringRequest stringReq=new StringRequest(Request.Method.POST, Config.logroot_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                String res="success";
                String admin="admin";
                if(admin.equals(response.trim().toString())){
                    Toast.makeText(getApplicationContext(),"Invalid details",Toast.LENGTH_SHORT).show();
                }
                else if(res.equals(response.trim().toString())){
                    //Toast.makeText(getApplicationContext(),response.trim().toString(),Toast.LENGTH_SHORT).show();
                    refUser=username.toString();
                    SharedPreferences.Editor editor = sharedpreferences.edit();

                    editor.putString(name, username);
                    editor.putString(pass, upass);
                    editor.putString(Islog, "true");
                    editor.commit();
                    Intent intent=new Intent(LoginActivity.this,ItemsActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"please register...",Toast.LENGTH_SHORT).show();
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
