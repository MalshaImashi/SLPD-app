package com.dmhashanmd.slpd.SignUp.model;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.util.Log;

import com.dmhashanmd.slpd.SignUp.controller.SignUpController;
import com.dmhashanmd.slpd.utils.LoggerUtils;
import com.dmhashanmd.slpd.utils.db.model.User;
import com.dmhashanmd.slpd.utils.interfaces.CallBack;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SignUpModel {
    private SignUpController controller;
    private static final FirebaseAuth auth = FirebaseAuth.getInstance();
    @SuppressLint("StaticFieldLeak")
    private static final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String usersPath = "users";

    public SignUpModel(SignUpController signUpController) {
        this.controller = signUpController;
    }

    public void createUser(User user, CallBack callBack) {
        class Class_createUser implements Runnable {
            @Override
            public void run() {
                auth.createUserWithEmailAndPassword(user.getEmail(), user.getPassword()).addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        user.setId(Objects.requireNonNull(auth.getCurrentUser()).getUid());
                        callBack.onSuccess();
                    } else {
                        if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                            Log.d(TAG, "Already registered");
                            callBack.onFail("Already registered");
                        } else {
                            callBack.onFail(Objects.requireNonNull(task.getException()).getMessage());
                        }

                    }
                });
            }
        }
        Class_createUser class_createUser = new Class_createUser();
        new Thread(class_createUser).start();
    }

    public void saveUserData(User user) {
        class Class_saveUserData implements Runnable {
            @Override
            public void run() {
                Map<String, Object> userData = new HashMap<>();
                userData.put("id", user.getId());
                userData.put("name", user.getFullName());
                userData.put("email", user.getEmail());
                userData.put("nameWithInitial", user.getNameWithInitials());
//                userData.put("appVersion", user.appVersion);
//                userData.put("deviceType", user.deviceType);
//                userData.put("created", user.created);
//                userData.put("modified", user.modified);
//                userData.put("isCreator", user.isCreator);
                db.collection(usersPath)
                        .document(user.getId())
                        .set(userData)
                        .addOnSuccessListener(unused -> {
                            controller.onSuccess();
                        })
                        .addOnFailureListener(e -> {
                            controller.onError(e.getMessage());
                            LoggerUtils.e("Error --> " + e);
                            e.printStackTrace();  // TODO remove
                        });


            }
        }
        Class_saveUserData class_saveUserData = new Class_saveUserData();
        new Thread(class_saveUserData).start();
    }


}
