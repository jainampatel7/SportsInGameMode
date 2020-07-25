package com.example.sportsin.LaunchScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.example.sportsin.LoginScreen.LoginActivity;
import com.example.sportsin.R;

public class LaunchScreen extends AppCompatActivity {

    private ImageView logo_image;
    private ConstraintLayout logo_background;
    private ImageView logo_invert_image;
    private ImageView logo_invert_background;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_screen);
        logo_image = findViewById(R.id.logo_image);
        logo_background = findViewById(R.id.logo_background);
        logo_invert_image = findViewById(R.id.logo_invert_image);
        logo_invert_background = findViewById(R.id.logo_invert_background);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                logo_invert_background.animate().alpha(0).setDuration(1000);
                logo_image.animate().alpha(1).setDuration(1000);
                logo_invert_image.animate().alpha(0).setDuration(1000);
            }
        } ,2000);

        final Intent intent = new Intent(this, LoginActivity.class);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
            }
        }, 4000);


    }
}