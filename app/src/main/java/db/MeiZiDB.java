package db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import db.bean.MeiZi;
import db.bean.MeiZiEntityId;

/**
 * Created by bigwen on 2015/12/8.
 */
public class MeiZiDB {
    private static MeiZiDB meiZiDB;
    private PhotoSqliteHelper photoSqliteHelper;
    private String Tab_Name_MEIZI = "MEIZI";
    private String DB_Name = "Photo";
    private int DBVersion = 1;
    private SQLiteDatabase db;
    private MeiZiEntityId meiZiEntityId = new MeiZiEntityId();


    public static synchronized MeiZiDB getInstance(Context context) {
        if (meiZiDB == null) {
            meiZiDB = new MeiZiDB(context);
        }
        return meiZiDB;
    }

    private MeiZiDB(Context context) {
        photoSqliteHelper = new PhotoSqliteHelper(context, DB_Name, null, DBVersion);
        db = photoSqliteHelper.getWritableDatabase();
    }

    public void saveResultsEntity(List<MeiZi.ResultsEntity> list, int i) {
        for (MeiZi.ResultsEntity object : list) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(meiZiEntityId.who, object.getWho());
            contentValues.put(meiZiEntityId.publishedAt, object.getPublishedAt());
            contentValues.put(meiZiEntityId.desc, object.getDesc());
            contentValues.put(meiZiEntityId.type, object.getType());
            contentValues.put(meiZiEntityId.url, object.getUrl());
            contentValues.put(meiZiEntityId.objectId, object.getObjectId());
            contentValues.put(meiZiEntityId.createdAt, object.getCreatedAt());
            contentValues.put(meiZiEntityId.updatedAt, object.getUpdatedAt());

            contentValues.put("count", i);

            //查询数据库，存在则更新
            if (queryInDB(object.getUrl())) {
                db.update(Tab_Name_MEIZI,contentValues,"url = ? ",new String[]{object.getUrl()});
            }
            //不存在就添加
            else {
                db.insert(Tab_Name_MEIZI, null, contentValues);
            }
        }
    }

    public List<String> loadMeiZiUrl(int count) {
        List<String> list = new ArrayList<String>();
        Cursor cursor = db.query(Tab_Name_MEIZI, new String[]{"url"}, "count = ?", new String[]{count + ""}, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(cursor.getColumnIndex("url")));
            }
            while (cursor.moveToNext());
        }
        cursor = null;
        return list;
    }

    public boolean queryInDB(String url) {
        boolean re = false;
        Cursor cursor = db.query(Tab_Name_MEIZI, new String[]{"url"}, "url = ? ", new String[]{url}, null, null, null);
        re = cursor.moveToFirst();
        return re;
    }
}
