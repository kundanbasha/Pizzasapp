package com.example.karunakar.pizzasapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Ice extends AppCompatActivity {
    public TextView TextViewI,TextViewIc,TextViewIce,TextViewp,TextViewpr,TextViewpri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ice);
        addLIstenerOnTextView();
    }

    private void addLIstenerOnTextView() {
        final Context context = this;

        TextViewI = (TextView) findViewById(R.id.textView24);
        TextViewIc = (TextView) findViewById(R.id.textView25);
        TextViewIce = (TextView) findViewById(R.id.textView26);
        TextViewp = (TextView) findViewById(R.id.textView27);
        TextViewpr = (TextView) findViewById(R.id.textView28);
        TextViewpri = (TextView) findViewById(R.id.textView29);


        TextViewI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ic = TextViewI.getText().toString();
                String pr = TextViewp.getText().toString();
                Intent intent= new Intent(context, ItemOrder.class);
                intent.putExtra("type",ic);
                intent.putExtra("price",pr);
                startActivity(intent);
            }
        });

        TextViewIc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ic = TextViewIc.getText().toString();
                String pr = TextViewpr.getText().toString();
                Intent intent =new Intent(context, ItemOrder.class);
                intent.putExtra("type",ic);
                intent.putExtra("price",pr);
                startActivity(intent);
            }
        });

        TextViewIce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ic = TextViewIce.getText().toString();
                String pr = TextViewpr.getText().toString();
                Intent intent =new Intent(context, ItemOrder.class);
                intent.putExtra("type",ic);
                intent.putExtra("price",pr);
                startActivity(intent);
            }
        });
    }
}
