package db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import db.bean.AndroidData;
import db.bean.AndroidDataEntityId;

/**
 * Created by bigwen on 2015/12/9.
 */
public class AndroidDB {
    private static AndroidDB androidDB;
    private PhotoSqliteHelper photoSqliteHelper;
    private String Tab_Name_Android = "Android";
    private String DB_Name = "Photo";
    private int DBVersion = 1;
    private SQLiteDatabase db;

    public static synchronized AndroidDB getInstence(Context context) {
        if (androidDB == null) {
            androidDB = new AndroidDB(context);
        }
        return androidDB;
    }

    private AndroidDB(Context context) {
        photoSqliteHelper = new PhotoSqliteHelper(context, DB_Name, null, DBVersion);
        db = photoSqliteHelper.getWritableDatabase();
    }

    public void saveResultsEntity(List<AndroidData.ResultsEntity> list, int i) {
        AndroidDataEntityId androidDataEntityId = new AndroidDataEntityId();
        for (AndroidData.ResultsEntity object : list) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(androidDataEntityId.who, object.getWho());
            contentValues.put(androidDataEntityId.publishedAt, object.getPublishedAt());
            contentValues.put(androidDataEntityId.desc, object.getDesc());
            contentValues.put(androidDataEntityId.type, object.getType());
            contentValues.put(androidDataEntityId.url, object.getUrl());
            contentValues.put(androidDataEntityId.objectId, object.getObjectId());
            contentValues.put(androidDataEntityId.createdAt, object.getCreatedAt());
            contentValues.put(androidDataEntityId.updatedAt, object.getUpdatedAt());

            contentValues.put("count", i);

            if(inURLDB(object.getUrl())){
                db.update(Tab_Name_Android,contentValues," url = ? ",new String[]{object.getUrl()});
            }else {
                db.insert(Tab_Name_Android, null, contentValues);
            }
        }
    }

    public List<String> loadAndroidDesc(int count) {
        List<String> list = new ArrayList<String>();
        Cursor cursor = db.query(Tab_Name_Android, new String[]{"desc"}, "count = ?", new String[]{count+""}, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(cursor.getColumnIndex("desc")));
            }
            while (cursor.moveToNext());
        }
        cursor = null;
        return list;
    }

    /**
     * 与数据库第一条数据对比，false,说明网络与本地同步
     * @param desc
     * @return
     */
    public boolean isAndroidDescDBFirst(String desc){
        boolean re=true;
        Cursor cursor=db.query(Tab_Name_Android,new String[]{"desc"},"count=?",new String[]{"1"},null,null,null);
        if(cursor.moveToFirst()){
            String firstDesc=cursor.getString(cursor.getColumnIndex("desc"));
            Log.i("AndroidDB", "isAndroidDescDBFirst firstDesc"+firstDesc+"  desc"+desc);
            if(desc.equals(firstDesc)){
                re=false;
            }
        }
        return re;
    }

    public boolean inURLDB(String url){
        Cursor cursor=db.query(Tab_Name_Android,new String[]{"url"},"url = ? ",new String[]{url},null,null,null);
        return cursor.moveToFirst();
    }
}
