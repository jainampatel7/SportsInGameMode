package com.example.sportsin.MainScreen.Merchandise;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sportsin.EventView.EventViewActivity;
import com.example.sportsin.MainScreen.HomeScreen.HomeDataModel;
import com.example.sportsin.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MerchandiseRecyclerAdapter extends RecyclerView.Adapter<MerchandiseRecyclerAdapter.ViewHolder> {


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView event_title;
        public TextView event_address;
        public TextView event_date;
        public ImageView event_image;
        public RelativeLayout event_view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            event_title = itemView.findViewById(R.id.event_title);
            event_address = itemView.findViewById(R.id.event_address);
            event_date = itemView.findViewById(R.id.event_date);
            event_image = itemView.findViewById(R.id.event_image);
            event_view = itemView.findViewById(R.id.event_view);
        }
    }


    private ArrayList<HomeDataModel> list;
    private Context context;
    public MerchandiseRecyclerAdapter(Context context, ArrayList<HomeDataModel> list){
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final HomeDataModel event = list.get(position);
        holder.event_title.setText(event.getEvent_title());
        holder.event_address.setText(event.getEvent_address());
        holder.event_date.setText(event.getEvent_date());
        holder.event_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EventViewActivity.class);
                intent.putExtra("event_name",event.getEvent_title());
                context.startActivity(intent);
            }
        });
        Picasso.get().load(event.getEvent_image()).resize(300,300).centerCrop().error(R.drawable.football).into(holder.event_image);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
