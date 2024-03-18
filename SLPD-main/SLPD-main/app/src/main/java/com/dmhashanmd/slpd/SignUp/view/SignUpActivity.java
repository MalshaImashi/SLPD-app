package com.dmhashanmd.slpd.SignUp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dmhashanmd.slpd.R;
import com.dmhashanmd.slpd.SignUp.controller.SignUpController;
import com.google.android.material.textfield.TextInputEditText;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    public TextView btnCansel, btnCreate;
    public TextInputEditText tvFullName, tvEmail, tvPassword, tvNameWithInitial;
    private SignUpController controller;
    public ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        controller = new SignUpController(this);

        tvEmail = findViewById(R.id.tiet_email);
        tvFullName = findViewById(R.id.tiet_full_name);
        tvPassword = findViewById(R.id.tiet_password);
        tvNameWithInitial = findViewById(R.id.tiet_name_with_initial);

        btnCansel = findViewById(R.id.cansel_button);
        btnCreate = findViewById(R.id.create_button);
        progressBar = findViewById(R.id.progressbar_sign_in);
        tvEmail.addTextChangedListener(controller.textWatcher);
        tvPassword.addTextChangedListener(controller.textWatcher);
        btnCansel.setOnClickListener(this);
        btnCreate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.cansel_button) {
            onBackPressed();
        } else if (v.getId() == R.id.create_button) {
            controller.createAccount();
        }
    }
}