package handler;

import android.util.Log;

import com.bcgtgjyb.mylibrary.base.BaseModel;
import com.bcgtgjyb.mylibrary.base.MyDataBase;
import com.bcgtgjyb.mylibrary.base.MyModel;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.framed.Header;

import net.HttpCallBack;
import net.HttpRequest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import tool.MyApplication;

/**
 * Created by bigwen on 2016/1/4.
 */
public class WeatherHandler {
    private String TAG = WeatherHandler.class.getName();
    private OkHttpClient client;
    public WeatherHandler() {
        client=new OkHttpClient();
        //设置超时
        client.setConnectTimeout(10, TimeUnit.SECONDS);
        client.setWriteTimeout(10,TimeUnit.SECONDS);
        client.setReadTimeout(10,TimeUnit.SECONDS);
    }



    public void httpGetWeatnerInfo(String url,String urlParam, HttpCallBack httpCallBack){
        Header header = new Header("apikey","effbe9a153507135f408b1da1476aaaf");
        try {
            Response response = new HttpRequest().httpGet(url, urlParam, header);
            if (response.isSuccessful()) {
                httpCallBack.onSuccess(response.body().string());
            }
        }catch (Exception e){
            Log.e(TAG, "httpGetWeatnerInfo "+e.toString());
            httpCallBack.onError(e);
        }

    }

    public void saveDB(MyModel myModel){
        MyDataBase.getInstence(MyApplication.getContext()).saveBean(myModel);
    }

    public List<BaseModel> loadAllFromDB(MyModel myModel){
        return MyDataBase.getInstence(MyApplication.getContext()).loadAllFromDB(myModel);
    }

    public List<BaseModel> loadFromDB(MyModel myModel,String sql,String[] param){
        return MyDataBase.getInstence(MyApplication.getContext())
                .loadFromDB(sql, param, myModel);
    }

    public void deleteAll(MyModel myModel){
        MyDataBase.getInstence(MyApplication.getContext()).deleteAll(myModel);
    }

}
