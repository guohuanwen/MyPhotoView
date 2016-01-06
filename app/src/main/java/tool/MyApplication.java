package tool;

import android.app.Application;
import android.content.Context;

import com.bcgtgjyb.mylibrary.base.MyDataBase;

/**
 * Created by bigwen on 2015/12/8.
 */
public class MyApplication extends Application {
    public static Context context;
    public static boolean inNet=false;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
        MyDataBase.getInstence(context);
        inNet=CheckNet.isNetWork(context);
    }
}
