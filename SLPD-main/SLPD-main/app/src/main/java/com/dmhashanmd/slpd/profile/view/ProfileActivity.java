package com.dmhashanmd.slpd.profile.view;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.dmhashanmd.slpd.R;
import com.dmhashanmd.slpd.profile.controller.ProfileController;

public class ProfileActivity extends AppCompatActivity {
    ProfileController controller;

    public TextView tvEmail, tvName, tvDob, tvGender, tvCompany, tvPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        controller = new ProfileController(this);

        tvEmail = findViewById(R.id.email);
        tvName = findViewById(R.id.tv_name);
        tvDob = findViewById(R.id.tv_dob);
        tvGender = findViewById(R.id.tv_gender);
        tvCompany = findViewById(R.id.tv_company);
        tvPosition = findViewById(R.id.tv_position);

        controller.viewProfile();
    }
}