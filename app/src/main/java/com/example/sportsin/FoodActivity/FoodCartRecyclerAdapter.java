package com.example.sportsin.MerchandiseCart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sportsin.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MerchandiseCartRecyclerAdapter extends RecyclerView.Adapter<MerchandiseCartRecyclerAdapter.ViewHolder> {


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView merch_name;
        public TextView merch_size;
        public TextView merch_price;
        public ImageView merch_image;
        public RelativeLayout merchandise;
        public Button add_to_cart;
        public Spinner merch_size_spinner;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            merch_name = itemView.findViewById(R.id.merch_name);
            merch_size = itemView.findViewById(R.id.merch_size);
            merch_price = itemView.findViewById(R.id.merch_price);
            merch_image = itemView.findViewById(R.id.merch_image);
            merchandise = itemView.findViewById(R.id.merchandise);
            add_to_cart = itemView.findViewById(R.id.add_to_cart);
            merch_size_spinner = itemView.findViewById(R.id.merch_size_spinner);
        }
    }

    public int cart_count = 0;
    private ArrayList<MerchandiseCartDataModel> list;
    private Context context;
    private ArrayList<MerchandiseCartDataModel> intent_list = new ArrayList<MerchandiseCartDataModel>();
    public MerchandiseCartRecyclerAdapter(Context context, ArrayList<MerchandiseCartDataModel> list){
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.merch_cart_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final MerchandiseCartDataModel event = list.get(position);
        final MerchandiseCartDataModel model = new MerchandiseCartDataModel(event.getMerch_name(),"",event.getMerch_price(),event.getMerch_name());
        holder.merch_name.setText(event.getMerch_name());
        holder.merch_size.setText(event.getMerch_size());
        holder.merch_price.setText(event.getMerch_price());
        Picasso.get().load(event.getMerch_image()).error(R.drawable.football).into(holder.merch_image);
        holder.add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context,R.array.size,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.merch_size_spinner.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public int getCartCount(){
        return cart_count;
    }

    public int getIntentListCount(){
        return intent_list.size();
    }

}
