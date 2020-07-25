package com.example.sportsin.PurchaseTicket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.sportsin.MainScreen.HomeScreen.HomeDataModel;
import com.example.sportsin.MainScreen.HomeScreen.HomeRecyclerAdapter;
import com.example.sportsin.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class ReserveSpotActivity extends AppCompatActivity implements OnMapReadyCallback {

    private RecyclerView recyclerView;
    private ArrayList<TicketDataModel> list;
    private TicketRecyclerModel recyclerAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve_spot);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTitle("Reserve a spot!");
        recyclerView = findViewById(R.id.ticket_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(ReserveSpotActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        list = new ArrayList<>();
        list.add(new TicketDataModel("$100+","Parking Lot - A"));
        list.add(new TicketDataModel("$75+","Parking Lot - B"));
        list.add(new TicketDataModel("$50+","Parking Lot - C"));
        recyclerAdapter = new TicketRecyclerModel(ReserveSpotActivity.this,list);
        recyclerView.setAdapter(recyclerAdapter);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapView);
        mapFragment.getMapAsync(this);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng parkingA = new LatLng(40.4331928, -86.9202231);
        mMap.addMarker(new MarkerOptions().position(parkingA).title("Parking Lot A"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(parkingA));
        LatLng parkingB = new LatLng(40.4344096, -86.9197939);
        mMap.addMarker(new MarkerOptions().position(parkingB).title("Parking Lot B"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(parkingB));
        LatLng parkingC = new LatLng(40.4342381, -86.92003);
        mMap.addMarker(new MarkerOptions().position(parkingC).title("Parking Lot C"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(parkingC));
        mMap.setMinZoomPreference(16f);
    }
}