package com.dmhashanmd.slpd.LoginOfficer;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dmhashanmd.slpd.R;
import com.dmhashanmd.slpd.utils.BehaviorUtil;
import com.dmhashanmd.slpd.utils.FileUtils;
import com.dmhashanmd.slpd.utils.LoggerUtils;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class OfficerLoginActivity extends AppCompatActivity {
    public EditText userName, password;
    TextInputEditText behavior_detect;
    TextView logIn;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_officer_loging);

        userName = findViewById(R.id.sign_in_username);
        password = findViewById(R.id.sign_in_password);
        behavior_detect = findViewById(R.id.behavior_detect);
        logIn = findViewById(R.id.tv_login);

        userName.addTextChangedListener(textWatcher);
        password.addTextChangedListener(textWatcher);
        behavior_detect.addTextChangedListener(textWatcher);
        behavior_detect.addTextChangedListener(textWatcherBehavior);

        context = this.getApplicationContext();
    }

    /**
     * detect text changes in text field
     */

    final TextWatcher textWatcherBehavior = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence text, int start, int before, int count) {
            try {
                if (count > 0 && before < count) {
                    long time = SystemClock.elapsedRealtime();
                    BehaviorUtil.saveKeyboard(context, time, text.charAt(text.length() - 1));
                }
            } catch (Exception e) {
                Log.e("Error --> ", Objects.requireNonNull(e.getMessage()));
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                String emailValue = userName.getText().toString().trim();
                String passwordValue = password.getText().toString().trim();
                String behaviorValue = Objects.requireNonNull(behavior_detect.getText()).toString().trim();

                logIn.setEnabled(!emailValue.isEmpty() && !passwordValue.isEmpty() && behaviorValue.length() > 100);
            } catch (Exception e) {
                Log.e("Error --> ", Objects.requireNonNull(e.getMessage()));
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}