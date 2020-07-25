package com.example.sportsin.TeamView;

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

import java.util.ArrayList;

public class TeamViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<TeamDataModel> list;
    private TeamRecyclerAdapter recyclerAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        recyclerView = findViewById(R.id.team_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(TeamViewActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        list = new ArrayList<>();
        list.add(new TeamDataModel("qwerty",null));
        list.add(new TeamDataModel("qwerty",null));
        list.add(new TeamDataModel("qwerty",null));
        list.add(new TeamDataModel("qwerty",null));
        list.add(new TeamDataModel("qwerty",null));
        list.add(new TeamDataModel("qwerty",null));
        list.add(new TeamDataModel("qwerty",null));
        list.add(new TeamDataModel("qwerty",null));
        list.add(new TeamDataModel("qwerty",null));
        list.add(new TeamDataModel("qwerty",null));
        recyclerAdapter = new TeamRecyclerAdapter(TeamViewActivity.this,list);
        recyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}