package com.dmhashanmd.slpd.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesUtil {

    SharedPreferences sp;

    public SharedPreferencesUtil(Context context) {
        sp = context.getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
    }

    public void sharedPreferencesSave(String key, String value) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String sharedPreferencesRead(String key) {
        return sp.getString(key, "empty");
    }


}
