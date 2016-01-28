package handler;

import android.util.Log;

import com.squareup.okhttp.Response;

import net.HttpCallBack;
import net.HttpRequest;
import net.MyURL;

/**
 * Created by bigwen on 2016/1/26.
 */
public class GuaseHandler {
    private String TAG = GuaseHandler.class.getName();
    private HttpRequest httpRequest;
    public static GuaseHandler guaseHandler;

    public static GuaseHandler getInstence() {
        if (guaseHandler == null) {
            guaseHandler = new GuaseHandler();
        }
        return guaseHandler;
    }

    private GuaseHandler() {
        this.httpRequest = new HttpRequest();
    }

    public void httpGetJoke(HttpCallBack httpCallBack) {
        try {
            Response response = httpRequest.httpGet(MyURL.Guase,MyURL.header);
            httpCallBack.onSuccess(response.body().string());
        } catch (Exception e) {
            httpCallBack.onError(e);
            Log.e(TAG, "httpGetJoke " + e.toString());
        }
    }
}
