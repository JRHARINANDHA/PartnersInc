package com.reality.escape.partnerapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.reality.escape.partnerapp.Delivery;
import com.reality.escape.partnerapp.ManageMenu;
import com.reality.escape.partnerapp.Payment;
import com.reality.escape.partnerapp.R;
import com.reality.escape.partnerapp.Team;

/**
 * Created by JR HARI NANDHA on 18-12-2016.
 */
public class MenuAdapter extends RecyclerView.Adapter<com.reality.escape.partnerapp.Adapter.MenuAdapter.ViewHolder>{
    private final String[] names;
    private final String[] names_desc;
    private final Drawable[] nameAvators;
    Context context;

    public MenuAdapter(Context context) {
        System.out.println("create");
        this.context = context;
        Resources resources = context.getResources();
        names = resources.getStringArray(R.array.names);
        names_desc = resources.getStringArray(R.array.name_desc);
        TypedArray a = resources.obtainTypedArray(R.array.name_avatar);
        nameAvators = new Drawable[a.length()];
        for (int i = 0; i < nameAvators.length; i++) {
            nameAvators[i] = a.getDrawable(i);
        }
        a.recycle();
    }
    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_list,parent,false);
        return new ViewHolder(view);

    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.dp.setImageDrawable(nameAvators[position]);
        holder.name.setText(names[position]);
        holder.description.setText(names_desc[position]);
    }

    @Override
    public int getItemCount() {
        return names.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
       private ImageView dp;
       private TextView name;
       private TextView description;



        public ViewHolder(View view){
            super(view);
            view.setOnClickListener(this);


            dp = (ImageView) view.findViewById(R.id.list_avatar);
            name = (TextView) view.findViewById(R.id.list_title);
            description = (TextView) view.findViewById(R.id.list_desc);



        }

        @Override
        public void onClick(View view) {
           int i = getPosition();

            switch (i){
                case 0:
                    context.startActivity(new Intent(context,ManageMenu.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                    break;
                case 1:
                    context.startActivity(new Intent(context,Payment.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                    break;
                case 2:
                    context.startActivity(new Intent(context,Delivery.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                    break;
                case 3:
                    context.startActivity(new Intent(context,Team.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                    break;
            }
        }
    }
}



