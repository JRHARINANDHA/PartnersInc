package com.reality.escape.partnerapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.reality.escape.partnerapp.Adapter.MenuAdapter;

/**
 * Created by JR HARI NANDHA on 28-12-2016.
 */

public class Home extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();
    }

    private void init(){
        recyclerView = (RecyclerView) findViewById(R.id.menuList);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView.Adapter adapter = new MenuAdapter(getApplicationContext());
        recyclerView.setAdapter(adapter);


    }
}
