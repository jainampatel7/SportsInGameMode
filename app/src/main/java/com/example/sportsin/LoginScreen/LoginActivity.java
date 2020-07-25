package com.example.sportsin.LoginScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sportsin.ForgotPassword.ForgotPasswordActivity;
import com.example.sportsin.MainScreen.MainScreenManager;
import com.example.sportsin.R;
import com.example.sportsin.RegistrationScreen.RegistrationActivity;

public class LoginActivity extends AppCompatActivity {

    private Button login_button;
    private TextView forgot_password;
    private TextView register_here;
    private EditText login_email;
    private EditText login_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login_email = findViewById(R.id.login_email);
        login_password = findViewById(R.id.login_password);
        login_button = findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainScreenManager.class);
                startActivity(intent);
                finish();
            }
        });

        forgot_password = findViewById(R.id.forgot_password);
        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
                finish();
            }
        });

        register_here = findViewById(R.id.register_here);
        register_here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}