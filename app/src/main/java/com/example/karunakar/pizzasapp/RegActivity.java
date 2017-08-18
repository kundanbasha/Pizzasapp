package com.example.karunakar.pizzasapp;

        import android.content.Intent;
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

        import java.util.HashMap;
        import java.util.Map;

public class RegActivity extends AppCompatActivity {

    EditText name,pass,conform,email,city,phone;
    Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        name=(EditText)findViewById(R.id.name);
        pass=(EditText)findViewById(R.id.password);
        conform=(EditText)findViewById(R.id.address);
        email=(EditText)findViewById(R.id.area);
        city=(EditText)findViewById(R.id.city);
        phone=(EditText)findViewById(R.id.pincode);
        signup=(Button)findViewById(R.id.reg);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  cuname=name.getText().toString().trim();
                String pwd=pass.getText().toString().trim();
                String con=conform.getText().toString().trim();
                String ema=email.getText().toString().trim();
                String citi=city.getText().toString().trim();
                String phn=phone.getText().toString().trim();
                regData(cuname,pwd,con,ema,citi,phn);
            }
        });

    }

    private void regData(final String cuname, final String pwd, final String con, final String ema, final String citi, final String phn) {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, Config.regroot_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String res="success";

                if(res.equals(response.trim().toString())){
                    Toast.makeText(getApplicationContext(),response.trim().toString(),Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(RegActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"please fill correct details...",Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params=new HashMap<String, String>();
                Config conf=new Config();
                params.put(conf.name,cuname);
                params.put(conf.pass,pwd);
                params.put(conf.conform,con);
                params.put(conf.email,ema);
                params.put(conf.city,citi);
                params.put(conf.phone,phn);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

}

