package com.dmhashanmd.slpd.loginCivilian.model;


import android.os.Handler;
import android.os.Looper;


import com.dmhashanmd.slpd.loginCivilian.controller.LoginController;
import com.dmhashanmd.slpd.utils.interfaces.CallBack;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;


public class LoginModel {
    private LoginController controller;
    private final Handler handler = new Handler(Looper.getMainLooper());

    private static final FirebaseAuth auth = FirebaseAuth.getInstance();

    public LoginModel(LoginController loginController) {
        this.controller = loginController;
    }

    public void login(String email, String password, CallBack callBack) {
        class Class_login implements Runnable {
            @Override
            public void run() {
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        callBack.onSuccess();
                    } else {
                        callBack.onFail(Objects.requireNonNull(task.getException()).getMessage());
                    }
                });
            }
        }
        Class_login class_login = new Class_login();
        new Thread(class_login).start();
    }

}
