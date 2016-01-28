package net;

import com.squareup.okhttp.internal.framed.Header;

/**
 * Created by bigwen on 2015/12/8.
 */
public class MyURL {

    public static Header header = new Header("apikey","effbe9a153507135f408b1da1476aaaf");
    //妹子
    //http://gank.avosapps.com/api/data/%E7%A6%8F%E5%88%A9/10/1 最后一个参数代表请求第几页
    public static String MeiZiURL="http://gank.avosapps.com/api/data/%E7%A6%8F%E5%88%A9/10/";
    //android资讯
    //http://gank.avosapps.com/api/data/Android/10/1 最后一个参数代表请求第几页
    public static String AndroidData="http://gank.avosapps.com/api/data/Android/10/";
    //天气，带历史两天天气
    public static String Weather = "http://apis.baidu.com/apistore/weatherservice/recentweathers?cityid=";
    //笑话 url参数，第n页   http://apis.baidu.com/showapi_open_bus/showapi_joke/joke_text?page=1
    public static String Joke = "http://apis.baidu.com/showapi_open_bus/showapi_joke/joke_text";
    //猜谜语
    public static String Guase = "http://apis.baidu.com/myml/c1c/c1c";
}
