package com.bcgtgjyb.mylibrary.base;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.List;

/**
 * Created by bigwen on 2015/12/26.
 */
public class MyDataBase {
    private String TAG = MyDataBase.class.getName();
    private final static String DB_NAME = "Bigwen";
    private final static int DB_VERSION = 1;
    public Context context;
    private static MyDataBase myDataBase;
    private SQLiteDatabase db;
    private SqliteBaseHelper sqliteBaseHelper;

    public static MyDataBase getInstence(Context context) {
        if (null == myDataBase) {
            myDataBase = new MyDataBase(context);
        }
        return myDataBase;
    }

    private MyDataBase(Context context) {
        this.context = context;
        sqliteBaseHelper = new SqliteBaseHelper(context, DB_NAME, null, DB_VERSION);
        db = sqliteBaseHelper.getWritableDatabase();
        sqliteBaseHelper.setSqliteUpgrade(new SqliteBaseHelper.SqliteUpgrade() {
            @Override
            public void Upgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
                Log.i(TAG, "Upgrade 1");

            }

            @Override
            public void Create(SQLiteDatabase db) {

            }
        });
    }

    public void saveBean(List<MyModel> myModels) {
        for(MyModel myModel:myModels) {
            ContentValues contentValues = myModel.toContentValues();
            db.replace(myModel.getTableName(), null, contentValues);
        }
    }

    public void saveBean(MyModel myModel) {
        ContentValues contentValues = myModel.toContentValues();
        db.replace(myModel.getTableName(), null, contentValues);
    }

    public List<BaseModel> loadAllFromDB(MyModel myModel){
        try {
            Cursor cursor = db.rawQuery(" select  *  from  "+myModel.getTableName(), null);
            return myModel.fromCursor(cursor);
        }catch (Exception e){
            Log.e(TAG, "loadAllFromDB "+e.toString());
            e.printStackTrace();
        }
        return  null;
    }

    public List<BaseModel> loadFromDB(String sql,String[] param,MyModel myModel) {
        /**
         * rawQuery()方法的第一个参数为select语句；
         * 第二个参数为select语句中占位符参数的值，
         * 如果select语句没有使用占位符，该参数可以设置为null。
         * 带占位符参数的select语句使用例子如下：
         * Cursor cursor = db.rawQuery("select * from person where name like ? and age=?",
         * new String[]{"%传智%", "4"});
         */
        try {
            Cursor cursor = db.rawQuery(sql, param);
            return myModel.fromCursor(cursor);
        }catch (Exception e){
            Log.e(TAG, "loadFromDB "+e.toString());
            e.printStackTrace();
        }
        return  null;
    }



}
