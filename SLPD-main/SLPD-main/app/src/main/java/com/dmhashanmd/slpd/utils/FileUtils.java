package com.dmhashanmd.slpd.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.util.Log;


import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.File;
import java.io.FileOutputStream;

public class FileUtils {
    /**
     * 3/16/2024
     * save given data line in to csv file line by line
     * @param context context of android
     * @param filename file name of saving
     * @param content single line
     */
    public static void saveToCSV(Context context, String filename, String content) {
        FileOutputStream outputStream = null;
        try {
            // Get app-specific storage directory
            File file = new File(context.getExternalFilesDir(null), filename);

            // Create file if it doesn't exist
            if (!file.exists()) {
                file.createNewFile();
            }

            // Append content to existing file
            outputStream = new FileOutputStream(file, true);
            outputStream.write(content.getBytes());
        } catch (Exception e) {
            // Handle any potential errors gracefully
            // Log the error or inform the user
          LoggerUtils.e("Error --> " + e);
          e.printStackTrace();  // TODO remove
        } finally {
            // Ensure resources are closed properly
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e) {
               LoggerUtils.e("Error --> " + e);
               e.printStackTrace();  // TODO remove
                }
            }
        }
    }

}
