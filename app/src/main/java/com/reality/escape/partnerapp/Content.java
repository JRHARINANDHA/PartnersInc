package com.reality.escape.partnerapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by JR HARI NANDHA on 17-12-2016.
 */
public class Content extends AppCompatActivity {


    private EditText tname,temail;
    private String name,email;
    private Button done;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        done = (Button) findViewById(R.id.done);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Content.this,Home.class);
                startActivity(intent);
                finish();
            }
        });

    }


    /*private void init(){
        recyclerView = (RecyclerView) findViewById(R.id.cardList);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        details = new ArrayList<>();
        MenuDetails profileDetails = new MenuDetails(name,gender,email,birthday,id);
        details.add(profileDetails);

        RecyclerView.Adapter adapter = new MenuAdapter(details);
        recyclerView.setAdapter(adapter);
        System.out.println("count"+adapter.getItemCount());


    }*/


}
