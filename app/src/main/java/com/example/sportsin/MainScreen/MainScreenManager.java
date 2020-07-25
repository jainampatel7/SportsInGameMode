package com.example.sportsin.MainScreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.sportsin.LoginScreen.LoginActivity;
import com.example.sportsin.R;
import com.google.android.material.navigation.NavigationView;

public class MainScreenManager extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        Toolbar toolbar =  findViewById(R.id.navigation_toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_navigation_drawer,R.string.close_navigation_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportFragmentManager().beginTransaction().replace(
                R.id.fragment_container,
                new HomeFragment()
        ).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.my_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                break;

            case R.id.merchandise:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MerchandiseFragment()).commit();
                break;

            case R.id.purchases:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PurchasesFragment()).commit();
                break;

            case R.id.favorites:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FavoritesFragment()).commit();
                break;

            case R.id.faq:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FAQFragment()).commit();
                break;

            case R.id.help:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HelpFragment()).commit();
                break;

            case R.id.log_out:
                new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Confirmation")
                        .setMessage("Are you sure you want to logout?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(MainScreenManager.this, LoginActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No",null)
                        .create()
                        .show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}