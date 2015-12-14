package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by bigwen on 2015/12/8.
 */
public class PhotoSqliteHelper extends SQLiteOpenHelper {

    private String MeiZiTable="create table MEIZI" +
            "( who text , publishedAt text , desc text , " +
            " type text , url text , used text , objectId text , createdAt text," +
            " updatedAt text , count text )";

    private String AndroidTable="create table Android" +
            "( who text,publishedAt text,desc text," +
            "type text,url text,used text,objectId text, createdAt text," +
            "updatedAt text,count text)";


    public PhotoSqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MeiZiTable);
        db.execSQL(AndroidTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
