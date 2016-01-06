package net;

import com.google.gson.Gson;

import com.bcgtgjyb.mylibrary.base.bean.AndroidData;
import com.bcgtgjyb.mylibrary.base.bean.MeiZi;

/**
 * Created by bigwen on 2015/12/8.
 */
public class DataToBean {

    public MeiZi MeiZiJsonToBean(String returnString){
        Gson gson=new Gson();
        MeiZi resultsEntity=gson.fromJson(returnString,MeiZi.class);
        return resultsEntity;
    }

    public AndroidData AndroidDataJsonToBean(String returnString){
        Gson g=new Gson();
        AndroidData androidData=g.fromJson(returnString,AndroidData.class);
        return androidData;

    }

}
