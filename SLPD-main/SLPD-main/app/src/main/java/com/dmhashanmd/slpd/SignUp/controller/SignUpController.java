package com.dmhashanmd.slpd.SignUp.controller;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import com.dmhashanmd.slpd.CivilianDashBord.CivilianDashBordActivity;
import com.dmhashanmd.slpd.SignUp.model.SignUpModel;
import com.dmhashanmd.slpd.SignUp.view.SignUpActivity;
import com.dmhashanmd.slpd.utils.db.model.User;
import com.dmhashanmd.slpd.utils.interfaces.CallBack;

import java.util.Objects;

public class SignUpController {
    private SignUpActivity view;
    private SignUpModel model;

    private final Handler handler = new Handler(Looper.getMainLooper());

    public SignUpController(SignUpActivity signUpActivity) {
        this.view = signUpActivity;
        this.model = new SignUpModel(this);
    }


    public void createAccount() {
        view.btnCreate.setEnabled(false);
        view.progressBar.setVisibility(View.VISIBLE);

        User user = new User();
        if (view.tvEmail.getText() != null)
            user.setEmail(view.tvEmail.getText().toString().trim());
        if (view.tvPassword.getText() != null)
            user.setPassword(view.tvPassword.getText().toString().trim());
        if (view.tvFullName.getText() != null)
            user.setFullName(view.tvFullName.getText().toString().trim());
        if (view.tvNameWithInitial.getText() != null)
            user.setNameWithInitials(view.tvNameWithInitial.getText().toString().trim());

        model.createUser(user, new CallBack() {
            @Override
            public void onSuccess() {
                model.saveUserData(user);
            }

            @Override
            public void onFail(String message) {
                onError(message);
            }
        });

    }

    public final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try {
                if(view.tvEmail.getText()!=null && view.tvPassword.getText()!=null) {
                    String emailValue = view.tvEmail.getText().toString().trim();
                    String passwordValue = view.tvPassword.getText().toString().trim();

                    view.btnCreate.setEnabled(!emailValue.isEmpty() && !passwordValue.isEmpty());
                }
            } catch (Exception e) {
                Log.e("Error --> ", Objects.requireNonNull(e.getMessage()));
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    public void onError(String message) {
        handler.post(() -> {
            try {
                new AlertDialog.Builder(view)
                        .setTitle("Error")
                        .setMessage(message)
                        .setPositiveButton("OK", (dialogInterface, i) -> {

                        })
                        .show();

                view.btnCreate.setEnabled(true);
                view.progressBar.setVisibility(View.INVISIBLE);
            } catch (Exception e) {
                Log.e("Error --> ", Objects.requireNonNull(e.getMessage()));
            }
        });
    }

    public void onSuccess() {
        handler.post(() -> {
            try {
                view.btnCreate.setEnabled(true);
                view.progressBar.setVisibility(View.INVISIBLE);

                Intent intent = new Intent(view, CivilianDashBordActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                view.startActivity(intent);
                view.finish();
            } catch (Exception e) {
                Log.e("Error --> ", Objects.requireNonNull(e.getMessage()));
            }
        });
    }
}
