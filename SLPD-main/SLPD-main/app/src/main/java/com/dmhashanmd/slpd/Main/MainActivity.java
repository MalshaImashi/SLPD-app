package com.dmhashanmd.slpd.Main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dmhashanmd.slpd.LoginOfficer.OfficerLoginActivity;
import com.dmhashanmd.slpd.R;
import com.dmhashanmd.slpd.SignUp.view.SignUpActivity;
import com.dmhashanmd.slpd.loginCivilian.view.LoginCivilianActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        findViewById(R.id.bCivilian).setOnClickListener(this);
        findViewById(R.id.bOfficer).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bCivilian) {
            Intent intent = new Intent(this, LoginCivilianActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        } else if (v.getId() == R.id.bOfficer) {
            Intent intent = new Intent(this, OfficerLoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}