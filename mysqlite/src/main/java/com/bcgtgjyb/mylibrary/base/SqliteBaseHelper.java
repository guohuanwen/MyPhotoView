package com.bcgtgjyb.mylibrary.base;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.bcgtgjyb.mylibrary.base.bean.AndroidData;
import com.bcgtgjyb.mylibrary.base.bean.CityWeather;
import com.bcgtgjyb.mylibrary.base.bean.MeiZi;


/**
 * Created by bigwen on 2015/12/26.
 */
public class SqliteBaseHelper extends SQLiteOpenHelper {
    private String TAG = SqliteBaseHelper.class.getName();
    private SqliteUpgrade sqliteUpgrade;
    private String CityName = "create table city_name ( " +
            " province text , " +
            " city text , " +
            " city_code text primary key )";

    public SqliteBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "onCreate 1");
        Log.i(TAG, "onCreate "+new CityWeather.RetDataEntity().getCreatTableSql() +
                new CityWeather.RetDataEntity.TodayEntity().getCreatTableSql() +
                new AndroidData.ResultsEntity().getCreatTableSql()+
                new MeiZi.ResultsEntity().getCreatTableSql() +
                "");
        try {
            db.execSQL(CityName);
            db.execSQL(new AndroidData.ResultsEntity().getCreatTableSql());
            db.execSQL(new MeiZi.ResultsEntity().getCreatTableSql());
            db.execSQL(new CityWeather.RetDataEntity().getCreatTableSql());
            db.execSQL(new CityWeather.RetDataEntity.TodayEntity().getCreatTableSql());

    }catch (Exception e){
        Log.e(TAG, "onCreate " + e.toString());
    }
        if(sqliteUpgrade!=null){
            sqliteUpgrade.Create(db);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG, "onUpgrade "+oldVersion+"  "+newVersion);
        if(newVersion>=2) {
            db.execSQL(new CityWeather.RetDataEntity.ForecastEntity().getCreatTableSql());
        }
        if(sqliteUpgrade!=null){
            sqliteUpgrade.Upgrade(db, oldVersion, newVersion);
        }
    }



    public void setSqliteUpgrade(SqliteUpgrade sqliteUpgrade) {
        this.sqliteUpgrade = sqliteUpgrade;
    }

    public interface SqliteUpgrade{
        void Upgrade(SQLiteDatabase db,int oldVersion,int newVersion);
        void Create(SQLiteDatabase db);
    }
}
