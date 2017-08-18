package com.example.karunakar.pizzasapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.Normalizer;

public class ItemsActivity extends AppCompatActivity {

    GridView gridView;
    String itemnames[]={"veg","non-veg","cool drinks","ice creams"};
    int itemids[]={R.drawable.vegetable,R.drawable.nonveg,R.drawable.cd,R.drawable.ice};
    public boolean x=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        gridView=(GridView)findViewById(R.id.restitems);
        Items adapter=new Items(ItemsActivity.this,itemids,itemnames);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(ItemsActivity.this, "You Clicked at " +itemnames[position], Toast.LENGTH_SHORT).show();

                if(itemnames[position]=="veg"){

                    Intent intent=new Intent(ItemsActivity.this,ItemOrder.class);
                    intent.putExtra("type","veg");
                    intent.putExtra("price","100");
                    startActivity(intent);
                }
                else if(itemnames[position]=="non-veg"){

                    Intent intent=new Intent(ItemsActivity.this,ItemOrder.class);
                    intent.putExtra("type","non-veg");
                    intent.putExtra("price","150");
                    startActivity(intent);
                }
                else if(itemnames[position]=="cool drinks"){

                    Intent intent=new Intent(ItemsActivity.this,ItemOrder.class);
                    intent.putExtra("type","cool drinks");
                    intent.putExtra("price","35");
                    startActivity(intent);
                }
                else{

                    Intent intent=new Intent(ItemsActivity.this,ItemOrder.class);
                    intent.putExtra("type","ice creams");
                    intent.putExtra("price","25");
                    startActivity(intent);
                }

            }
        });
    }
    @Override
    public void onBackPressed() {

        if(x==true)
            super.onBackPressed();

        if (x == false) {
            Toast.makeText(getApplicationContext(), "Press Back again to quit", Toast.LENGTH_SHORT).show();
            x = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    x = false;
                }
            }, 3000);
        }


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Boolean islog = LoginActivity.sharedpreferences.getBoolean(LoginActivity.Islog,false);
        if (islog == false) {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.signout,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.signout:
                SharedPreferences.Editor editor = LoginActivity.sharedpreferences.edit();
                editor.putBoolean(LoginActivity.Islog, false);
                editor.commit();
                Boolean islog = LoginActivity.sharedpreferences.getBoolean(LoginActivity.Islog, false);
                if (islog == false) {
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                }
                break;
        }
        return true;
    }
}
