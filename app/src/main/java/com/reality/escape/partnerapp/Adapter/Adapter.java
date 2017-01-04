package com.reality.escape.partnerapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.reality.escape.partnerapp.R;

/**
 * Created by JR HARI NANDHA on 18-12-2016.
 */
public class Adapter extends RecyclerView.Adapter<com.reality.escape.partnerapp.Adapter.Adapter.ViewHolder>{
    Context context;
    public static int i;

    public Adapter(Context context) {
        this.context = context;
        i++;

    }
    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list,parent,false);
        return new ViewHolder(view);

    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText("Test Data"+position);
        holder.description.setText("Test Sub Data"+position);
    }

    @Override
    public int getItemCount() {
        return i;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView description;



        public ViewHolder(View view){
            super(view);

            name = (TextView) view.findViewById(R.id.list_title);
            description = (TextView) view.findViewById(R.id.list_desc);



        }
    }
}



