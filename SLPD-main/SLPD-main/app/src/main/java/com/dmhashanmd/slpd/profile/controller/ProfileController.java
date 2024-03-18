package com.dmhashanmd.slpd.profile.controller;

import com.dmhashanmd.slpd.profile.model.ProfileModel;
import com.dmhashanmd.slpd.profile.view.ProfileActivity;
import com.dmhashanmd.slpd.utils.SharedPreferencesConst;
import com.dmhashanmd.slpd.utils.SharedPreferencesUtil;

public class ProfileController {
    private ProfileActivity view; // view
    private ProfileModel model;
    SharedPreferencesUtil sharedPreferencesUtil;

    public ProfileController(ProfileActivity view) {
        this.view = view;
        model = new ProfileModel(this);
        sharedPreferencesUtil = new SharedPreferencesUtil(view);
    }

    public void viewProfile() {
     view.tvEmail.setText(sharedPreferencesUtil.sharedPreferencesRead(SharedPreferencesConst.EMAIL));
     view.tvName.setText(sharedPreferencesUtil.sharedPreferencesRead(SharedPreferencesConst.NAME));
     view.tvDob.setText(sharedPreferencesUtil.sharedPreferencesRead(SharedPreferencesConst.DOB));
     view.tvGender.setText(sharedPreferencesUtil.sharedPreferencesRead(SharedPreferencesConst.GENDER));
     view.tvCompany.setText(sharedPreferencesUtil.sharedPreferencesRead(SharedPreferencesConst.COMPANY));
     view.tvPosition.setText(sharedPreferencesUtil.sharedPreferencesRead(SharedPreferencesConst.POSITION));
    }
}
