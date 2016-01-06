package io;

import android.content.Context;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by bigwen on 2016/1/4.
 */
public class FileIO {
    private static String TAG =FileIO.class.getName();

    public static boolean saveDate(Context context,String text,String fileName){
        if(text.isEmpty()){
            return false;
        }
        try {
            FileOutputStream fileOutputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE);
            fileOutputStream.write(text.getBytes());
            fileOutputStream.close();
            return true;
        }catch (Exception e){
            Log.e(TAG, "saveDate "+e.toString());
            return false;
        }
    }

    public static String loadDate(Context context,String fileName){
        try {
            FileInputStream fileInputStream = context.openFileInput(fileName);
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            return new String(buffer,"UTF-8");
        }catch (Exception e){
            Log.e(TAG, "loadDate "+e.toString());
            return null;
        }
    }
}
