package com.example.sportsin.ForgotPassword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sportsin.LoginScreen.LoginActivity;
import com.example.sportsin.MainScreen.MainScreenManager;
import com.example.sportsin.R;

public class ForgotPasswordActivity extends AppCompatActivity {

    private TextView login;
    private EditText reset_email;
    private Button reset_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        reset_email = findViewById(R.id.reset_email);
        reset_button = findViewById(R.id.reset_button);
    }
}