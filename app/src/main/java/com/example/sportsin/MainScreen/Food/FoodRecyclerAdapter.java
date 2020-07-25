package com.example.sportsin.MainScreen.Food;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sportsin.MainScreen.Merchandise.MerchandiseDataModel;
import com.example.sportsin.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FoodRecyclerAdapter extends RecyclerView.Adapter<FoodRecyclerAdapter.ViewHolder> {


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView merch_name;
        public TextView merch_size;
        public TextView merch_price;
        public ImageView merch_image;
        public RelativeLayout merchandise;
        public Button add_to_cart;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            merch_name = itemView.findViewById(R.id.merch_name);
            merch_size = itemView.findViewById(R.id.merch_size);
            merch_price = itemView.findViewById(R.id.merch_price);
            merch_image = itemView.findViewById(R.id.merch_image);
            merchandise = itemView.findViewById(R.id.merchandise);
            add_to_cart = itemView.findViewById(R.id.add_to_cart);
        }
    }

    public int cart_count = 0;
    public double total_cost = 0;
    private ArrayList<MerchandiseDataModel> list;
    private Context context;
    private ArrayList<MerchandiseDataModel> intent_list = new ArrayList<MerchandiseDataModel>();
    public FoodRecyclerAdapter(Context context, ArrayList<MerchandiseDataModel> list){
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.merch_layout, parent, false);
        return new ViewHolder(v);
    }

    private MerchandiseDataModel model;
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final MerchandiseDataModel event = list.get(position);
        model = new MerchandiseDataModel(event.getMerch_name(),"Size: ",event.getMerch_price(),event.getMerch_image());
        holder.merch_name.setText(event.getMerch_name());
        holder.merch_size.setText(event.getMerch_size());
        holder.merch_price.setText(event.getMerch_price());
        Picasso.get().load(event.getMerch_image()).error(R.drawable.football).into(holder.merch_image);
        holder.add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.add_to_cart.getText().equals("ADD TO CART")) {
                    holder.add_to_cart.setText("REMOVE");
                    cart_count = cart_count + 1;
                    total_cost = total_cost + Double.parseDouble(event.getMerch_price().substring(8));
                    intent_list.add(model);
                } else if (holder.add_to_cart.getText().equals("REMOVE")){
                    holder.add_to_cart.setText("ADD TO CART");
                    cart_count = cart_count - 1;
                    total_cost = total_cost - Double.parseDouble(event.getMerch_price().substring(8));
                    intent_list.remove(model);
                }
            }
        });
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

    public ArrayList<MerchandiseDataModel> getList(){
        return intent_list;
    }

    public double total(){
        return total_cost;
    }
}
