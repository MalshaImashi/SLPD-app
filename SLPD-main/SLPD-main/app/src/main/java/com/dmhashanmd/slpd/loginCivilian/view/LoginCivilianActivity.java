package com.dmhashanmd.slpd.loginCivilian.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dmhashanmd.slpd.R;
import com.dmhashanmd.slpd.loginCivilian.controller.LoginController;

public class LoginCivilianActivity extends AppCompatActivity implements View.OnClickListener {
    LoginController controller;
    public TextView signInPasswordError;
    public EditText userName, password;
    public Button signInButton, signUpButton;
    public ProgressBar progressBarSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        controller = new LoginController(this);

        userName = findViewById(R.id.sign_in_username);
        password = findViewById(R.id.sign_in_password);
        progressBarSignIn = findViewById(R.id.progressbar_sign_in);
        signInButton = findViewById(R.id.sign_in_button);
        signUpButton = findViewById(R.id.sign_up_button);
        signInPasswordError = findViewById(R.id.signInPasswordError);
        userName.addTextChangedListener(controller.signInAccountTextWatcher);
        password.addTextChangedListener(controller.signInAccountTextWatcher);

        signInButton.setOnClickListener(this);
        signUpButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.sign_in_button) {
            controller.login(userName.getText().toString().trim(), password.getText().toString().trim());
        } else if (v.getId() == R.id.sign_up_button) {
            controller.viewSignUp();
        }
    }

}