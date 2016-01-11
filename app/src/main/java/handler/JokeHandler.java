package handler;

import android.util.Log;

import com.bcgtgjyb.mylibrary.base.MyDataBase;
import com.bcgtgjyb.mylibrary.base.bean.Joke;
import com.squareup.okhttp.Response;

import net.HttpCallBack;
import net.HttpRequest;
import net.MyURL;

import tool.MyApplication;

/**
 * Created by bigwen on 2016/1/11.
 */
public class JokeHandler {
    private HttpRequest httpRequest;
    private MyDataBase myDataBase;
    private String TAG = Joke.class.getName();

    public JokeHandler() {
        this.myDataBase = MyDataBase.getInstence(MyApplication.getContext());
        this.httpRequest = new HttpRequest();
    }

    public void httpGetJoke(int conut, HttpCallBack httpCallBack){
        try {
            Response response = httpRequest.httpGet(MyURL.Joke, "?page=" + conut,MyURL.header);
            httpCallBack.onSuccess(response.body().string());
        }catch (Exception e){
            httpCallBack.onError(e);
            Log.e(TAG, "httpGetJoke "+e.toString());
        }
    }
}
