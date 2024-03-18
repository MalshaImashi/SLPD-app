package com.dmhashanmd.slpd.utils;

import android.util.Log;

public class LoggerUtils {

    static final String TAG = "logSLPD";
    public static void w(String s) {
        Log.w(TAG, s);
    }

    public static void e(String s) {
        Log.e(TAG, s);
    }
}
