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


    public SqliteBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "onCreate 1");
        Log.i(TAG, "onCreate " + new CityWeather.RetDataEntity().getCreatTableSql() +
                new CityWeather.RetDataEntity.TodayEntity().getCreatTableSql() +
                new AndroidData.ResultsEntity().getCreatTableSql() +
                new MeiZi.ResultsEntity().getCreatTableSql() + "  " +
                new CityWeather.RetDataEntity.ForecastEntity().getCreatTableSql());


        db.execSQL(new AndroidData.ResultsEntity().getCreatTableSql());
        db.execSQL(new MeiZi.ResultsEntity().getCreatTableSql());
        db.execSQL(new CityWeather.RetDataEntity().getCreatTableSql());
        db.execSQL(new CityWeather.RetDataEntity.TodayEntity().getCreatTableSql());
        
        db.execSQL(new CityWeather.RetDataEntity.ForecastEntity().getCreatTableSql());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG, "onUpgrade " + oldVersion + "  " + newVersion);
        if (oldVersion == 1) {
            db.execSQL(new CityWeather.RetDataEntity.ForecastEntity().getCreatTableSql());
        }
//        if (sqliteUpgrade != null) {
//            sqliteUpgrade.Upgrade(db, oldVersion, newVersion);
//        }
    }


    public void setSqliteUpgrade(SqliteUpgrade sqliteUpgrade) {
        this.sqliteUpgrade = sqliteUpgrade;
    }

    public interface SqliteUpgrade {
        void Upgrade(SQLiteDatabase db, int oldVersion, int newVersion);

        void Create(SQLiteDatabase db);
    }
}
