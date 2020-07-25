package com.example.sportsin.PurchaseTicket;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sportsin.R;

import java.util.ArrayList;

public class SeatMapRecyclerModel extends RecyclerView.Adapter<SeatMapRecyclerModel.ViewHolder> {


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public Button ticket_price;
        public TextView ticket_spot;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ticket_price = itemView.findViewById(R.id.ticket_price);
            ticket_spot = itemView.findViewById(R.id.ticket_spot);
        }
    }


    private ArrayList<TicketDataModel> list;
    private Context context;

    public SeatMapRecyclerModel(Context context, ArrayList<TicketDataModel> list){
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tickets_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final TicketDataModel event = list.get(position);
        holder.ticket_price.setText(event.getTicket_price());
        holder.ticket_spot.setText(event.getTicket_spot());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
