package io;

import android.content.Context;
import android.content.SharedPreferences;

import tool.MyApplication;

/**
 * Created by bigwen on 2016/1/4.
 */
public class SharePrefenceIO {

    public static void saveSharePreference(String key,String value,String fileName){
        SharedPreferences sharedPreferences = MyApplication.getContext().getSharedPreferences(fileName, Context.MODE_PRIVATE);
        sharedPreferences.edit().putString(key,value).commit();
    }

    public static String loadSharePreference(String key,String fileName){
        return MyApplication.getContext().getSharedPreferences(fileName, Context.MODE_PRIVATE).getString(key,"");
    }
}
