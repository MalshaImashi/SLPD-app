package com.dmhashanmd.slpd.utils;

import android.content.Context;

public class BehaviorUtil {

    static long timeBefore = 0;
    static long maxTimeGap = 60000;

    /**
     * 3/16/2024
     * calculate time gap of kye bord button press
     * saving those data in to csv file
     * @param context context of android
     * @param time button press time in keyboard
     * @param c key of press
     */
    public static void saveKeyboard(Context context, long time, char c) {
        long timeGap = time - timeBefore;
        if (timeGap > maxTimeGap) {
            timeGap = maxTimeGap;
        }
        timeBefore = time;
        String csvLine = c + "," + timeGap + "\n";

        FileUtils.saveToCSV(context, "behavior.csv", csvLine);
        LoggerUtils.w("csvLine  --> " + csvLine); // TODO delete after test
    }
}
