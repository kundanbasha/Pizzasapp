package com.example.karunakar.pizzasapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.Normalizer;

public class Cool extends AppCompatActivity {
    public TextView TextViews,TextViewc,TextViewp,TextViewf,TextViewpr,TextViewpri,TextViewpric,TextViewprice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cool);
        addListenerOnTextView();
    }

    private void addListenerOnTextView() {
        final Context context = this;

        TextViews = (TextView) findViewById(R.id.textView20);
        TextViewc = (TextView) findViewById(R.id.textView21);
        TextViewp = (TextView) findViewById(R.id.textView22);
        TextViewf = (TextView) findViewById(R.id.textView23);
        TextViewpr = (TextView) findViewById(R.id.textView33);
        TextViewpri = (TextView) findViewById(R.id.textView34);
        TextViewpric = (TextView) findViewById(R.id.textView32);
        TextViewprice = (TextView) findViewById(R.id.textView35);

        TextViews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cd= TextViews.getText().toString();
                String pr= TextViewpr.getText().toString();
                Intent intent =new Intent(context, ItemOrder.class);
                intent.putExtra("type",cd);
                intent.putExtra("price",pr);
                startActivity(intent);
            }
        });

        TextViewc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cd= TextViewc.getText().toString();
                String pr= TextViewpri.getText().toString();
                Intent intent = new Intent(context,ItemOrder.class);
                intent.putExtra("type ", cd);
                intent.putExtra("price",pr);
                startActivity(intent);
            }
        });

        TextViewp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cd= TextViewp.getText().toString();
                String pr= TextViewpric.getText().toString();
                Intent intent = new Intent(context,ItemOrder.class);
                intent.putExtra("type", cd);
                intent.putExtra("price",pr);
                startActivity(intent);
            }
        });


        TextViewf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cd= TextViewf.getText().toString();
                String pr= TextViewprice.getText().toString();
                Intent intent = new Intent(context,ItemOrder.class);
                intent.putExtra("type", cd);
                intent.putExtra("price",pr);
                startActivity(intent);
            }
        });
    }
}
