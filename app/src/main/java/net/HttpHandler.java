package net;



import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by bigwen on 2015/12/8.
 */
public class HttpHandler {
    private HttpRequest httpRequest=new HttpRequest();
    public String getMeiZiUrl(int count,HttpFinish httpFinish){
        String url= MyURL.MeiZiURL+count;
        String r="";

        try {
            Response httpResponse=httpRequest.httpGetResponse(url);
            if(httpResponse.isSuccessful()){
                httpFinish.onSuccess(httpResponse.body().string());
            }else {

            }
        } catch (IOException e) {
            httpFinish.onError(e);
        }
        return r;
    }

    public void getAndroidDataUrl(int count,HttpFinish httpFinish){
        String url= MyURL.AndroidData+count;
        String r="";
        try {
            Response response=httpRequest.httpGetResponse(url);
            if(response.isSuccessful()){
                httpFinish.onSuccess(response.body().string());
            }
        } catch (IOException e) {
            httpFinish.onError(e);
            e.printStackTrace();
        }

    }
}
