package com.bcgtgjyb.mylibrary.base;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.bcgtgjyb.mylibrary.base.bean.CityName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bigwen on 2016/1/12.
 */
public class CityNameHelper extends SQLiteOpenHelper {
    private String TAG = CityNameHelper.class.getName();
    private static final String DBName ="CityName";
    private static final int Version = 2;
    private static CityNameHelper cityNameHelper;
    private static SQLiteDatabase db;
    private String CityName = "create table city_name ( " +
            " province text , " +
            " city text , " +
            " city_code text primary key )";

    public static CityNameHelper getInstence(Context context){
        if(cityNameHelper == null){
            cityNameHelper = new CityNameHelper(context);
            db = cityNameHelper.getWritableDatabase();
        }
        return cityNameHelper;
    }

    private CityNameHelper(Context context){
        this(context,DBName,null,Version);
    }
    private CityNameHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "onCreate "+CityName);
//        db.execSQL(CityName);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void saveCityName(String province, String city, String city_code) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("province", province);
        contentValues.put("city", city);
        contentValues.put("city_code", city_code);
        db.replace("city_name", null, contentValues);
    }

    public List<com.bcgtgjyb.mylibrary.base.bean.CityName.CityCodeEntity.CityEntity> loadCity(String province) {
        Cursor cursor = db.rawQuery("select * from city_name where province = ?", new String[]{province});
        List<CityName.CityCodeEntity.CityEntity> cityEntities = new ArrayList<CityName.CityCodeEntity.CityEntity>();
        if (cursor.moveToFirst()) {
            do {
                CityName.CityCodeEntity.CityEntity cityEntity = new CityName.CityCodeEntity.CityEntity();
                cityEntity.setCityName(cursor.getString(cursor.getColumnIndex("city")));
                cityEntity.setCityCode(cursor.getString(cursor.getColumnIndex("city_code")));
                cityEntities.add(cityEntity);
            } while (cursor.moveToNext());
        }
        return cityEntities;
    }
}
