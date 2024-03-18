package com.dmhashanmd.slpd.loginCivilian.controller;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import com.dmhashanmd.slpd.CivilianDashBord.CivilianDashBordActivity;
import com.dmhashanmd.slpd.SignUp.view.SignUpActivity;
import com.dmhashanmd.slpd.loginCivilian.model.LoginModel;
import com.dmhashanmd.slpd.loginCivilian.view.LoginCivilianActivity;
import com.dmhashanmd.slpd.profile.view.ProfileActivity;
import com.dmhashanmd.slpd.utils.SharedPreferencesConst;
import com.dmhashanmd.slpd.utils.SharedPreferencesUtil;
import com.dmhashanmd.slpd.utils.interfaces.CallBack;

import java.util.Objects;

public class LoginController {
    private LoginCivilianActivity view; // view
    private LoginModel model;
    private final Handler handler = new Handler(Looper.getMainLooper());
    SharedPreferencesUtil sharedPreferencesUtil;

    public LoginController(LoginCivilianActivity mainActivity) {
        this.view = mainActivity;
        model = new LoginModel(this);
        sharedPreferencesUtil = new SharedPreferencesUtil(mainActivity);
    }


    public void login(String username, String password) {
        // view prorgress
        view.progressBarSignIn.setVisibility(View.VISIBLE);
        model.login(username, password, new CallBack() {
            @Override
            public void onSuccess() {
                Intent intent = new Intent(view, CivilianDashBordActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                view.startActivity(intent);
                view.progressBarSignIn.setVisibility(View.INVISIBLE);
                view.password.setText("");
                view.userName.setText("");
            }

            @Override
            public void onFail(String massage) {
                view.progressBarSignIn.setVisibility(View.INVISIBLE);
                onError(massage);
            }
        });

    }

    public void onSuccess(String id, String email, String name, String dob, String gender, String company, String position) {
        handler.post(() -> {
            try {
                sharedPreferencesUtil.sharedPreferencesSave(SharedPreferencesConst.ID, id);
                sharedPreferencesUtil.sharedPreferencesSave(SharedPreferencesConst.EMAIL, email);
                sharedPreferencesUtil.sharedPreferencesSave(SharedPreferencesConst.NAME, name);
                sharedPreferencesUtil.sharedPreferencesSave(SharedPreferencesConst.DOB, dob);
                sharedPreferencesUtil.sharedPreferencesSave(SharedPreferencesConst.GENDER, gender);
                sharedPreferencesUtil.sharedPreferencesSave(SharedPreferencesConst.COMPANY, company);
                sharedPreferencesUtil.sharedPreferencesSave(SharedPreferencesConst.POSITION, position);

                view.signInButton.setEnabled(true);
                view.progressBarSignIn.setVisibility(View.INVISIBLE);

                Intent intent = new Intent(view, ProfileActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                view.finish();
                view.startActivity(intent);
            } catch (Exception e) {
                Log.e("Error --> ", e.getMessage());
                e.printStackTrace();
            }
        });
    }

    public void onError(String message) {
        handler.post(() -> {
            try {
                new AlertDialog.Builder(view)
                        .setTitle("Error")
                        .setMessage(message)
                        .setPositiveButton("OK", (dialogInterface, i) -> {

                        })
                        .show();

                view.signInButton.setEnabled(true);
                view.progressBarSignIn.setVisibility(View.INVISIBLE);
            } catch (Exception e) {
                Log.e("Error --> ", e.getMessage());
            }
        });
    }

    public void onCountReceived(int i) {
        //  this.mainActivity.textView.setText(String.valueOf(i));
        // hide progress
    }

    public final TextWatcher signInAccountTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                String emailValue = view.userName.getText().toString().trim();
                String passwordValue = view.password.getText().toString().trim();

                view.signInButton.setEnabled(!emailValue.isEmpty() && !passwordValue.isEmpty());
            } catch (Exception e) {
                Log.e("Error --> ", Objects.requireNonNull(e.getMessage()));
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    public void viewSignUp() {
        Intent intent = new Intent(view, SignUpActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        view.startActivity(intent);
    }
}
