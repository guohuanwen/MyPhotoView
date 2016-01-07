package handler;

import android.content.Context;
import android.util.Log;

import com.bcgtgjyb.mylibrary.base.bean.CityName;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * Created by bigwen on 2016/1/6.
 */
public class CityNameManager {
    private static String TAG = CityNameManager.class.getName();

    public static CityName getBean(Context context){
        try {
            InputStream inputStream = context.getClass().getClassLoader().getResourceAsStream("assets/" + "city_code");
            ByteArrayOutputStream btye = new ByteArrayOutputStream();
            int i=-1;
            while ((i=inputStream.read())!=-1){
                btye.write(i);
            }
            String text = btye.toString();
            Log.i(TAG, "getBean "+text);
            Gson gson = new Gson();
            return gson.fromJson(text, CityName.class);
        }catch (Exception e){
            Log.e(TAG, "getBean "+e.toString());
            return null;
        }
    }
}
