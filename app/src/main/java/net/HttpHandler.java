package net;


import android.util.Log;

import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by bigwen on 2015/12/8.
 */
public class HttpHandler {

    private HttpRequest httpRequest = new HttpRequest();
    private String TAG = HttpHandler.class.getSimpleName();

    public String getMeiZiUrl(int count, HttpCallBack httpFinish) {
        String url = MyURL.MeiZiURL + count;
        String r = "";
        try {
            Response httpResponse = httpRequest.httpGetResponse(url);
            if (httpResponse.isSuccessful()) {
                String text = httpResponse.body().string();
                Log.i(TAG, "getMeiZiUrl: " + text);
                httpFinish.onSuccess(text);
            } else {

            }
        } catch (IOException e) {
            Log.i(TAG, "getMeiZiUrl: " + e.toString());
            httpFinish.onError(e);
        }
        return r;
    }

    public void getAndroidDataUrl(int count, HttpCallBack httpFinish) {
        String url = MyURL.AndroidData + count;
        String r = "";
        try {
            Response response = httpRequest.httpGetResponse(url);
            if (response.isSuccessful()) {
                httpFinish.onSuccess(response.body().string());
            }
        } catch (IOException e) {
            httpFinish.onError(e);
            e.printStackTrace();
        }

    }
}
