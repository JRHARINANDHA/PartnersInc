package com.reality.escape.partnerapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.reality.escape.partnerapp.Adapter.Adapter;

/**
 * Created by JR HARI NANDHA on 28-12-2016.
 */

public class Delivery extends AppCompatActivity {
    private FloatingActionButton fab;
    private RecyclerView recyclerView;
    private ImageView imageView;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                recyclerView = (RecyclerView) findViewById(R.id.menuList);
                recyclerView.setHasFixedSize(true);
                RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(linearLayoutManager);
                RecyclerView.Adapter adapter = new Adapter(getApplicationContext());
                recyclerView.setAdapter(adapter);



                imageView = (ImageView) findViewById(R.id.menu);
                textView = (TextView) findViewById(R.id.tmenu);
                imageView.setVisibility(View.GONE);
                textView.setVisibility(View.GONE);
            }
        });
    }
    @Override
    public void onBackPressed(){
        Adapter.i = 0;
        super.onBackPressed();
    }
    }
