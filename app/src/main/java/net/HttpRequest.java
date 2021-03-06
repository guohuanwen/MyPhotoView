package net;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.framed.Header;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by huanwen on 2015/9/5.
 */
public class HttpRequest {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private final String TAG="HttpRequest";
    private OkHttpClient client;

    public HttpRequest() {
        client=new OkHttpClient();
        //设置超时
        client.setConnectTimeout(10, TimeUnit.SECONDS);
        client.setWriteTimeout(10,TimeUnit.SECONDS);
        client.setReadTimeout(10,TimeUnit.SECONDS);
    }

    public String httpGet(String url) throws IOException {
        return httpGetResponse(url).body().string();
    }

    public Response httpGetResponse(String url) throws IOException{
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        return response;
    }

    public Response httpPostResponse(String url,String json) throws IOException{
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response;
    }

    public String httpPost(String url,String json) throws IOException{
        return httpPostResponse(url,json).body().string();
    }

    public Response httpGet(String url, Header header) throws Exception{
        Request request  = new Request.Builder()
                .header(header.name.utf8(),header.value.utf8())
                .url(url)
                .build();
        return client.newCall(request).execute();
    }

    public Response httpGet(String url, String urlParam, Header header) throws Exception{
        Request request  = new Request.Builder()
                .header(header.name.utf8(),header.value.utf8())
                .url(url+urlParam)
                .build();
        return client.newCall(request).execute();
    }

    public Response httpGet(String url,String urlParams) throws IOException{
        Request request = new Request.Builder()
                .url(url+urlParams)
                .build();
        return  client.newCall(request).execute();
    }




}
