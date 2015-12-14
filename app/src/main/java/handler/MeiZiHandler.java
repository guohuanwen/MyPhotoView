package handler;

import android.os.Handler;
import android.os.Looper;

import net.DataToBean;
import net.HttpFinish;
import net.HttpHandler;

import java.util.ArrayList;
import java.util.List;

import db.MeiZiDB;
import db.bean.MeiZi;
import tool.MyApplication;

/**
 * Created by bigwen on 2015/12/8.
 */
public class MeiZiHandler {
    private HttpHandler httpHandler = new HttpHandler();
    private DataToBean dataToBean = new DataToBean();
    private MeiZiDB meiZiDB;
    private Handler handler=new Handler(Looper.getMainLooper());

    /**
     * 发出请求并保存数据库
     *
     * @param d 请求第几页
     */
    public void requestUrl(final int d,final UpdateUI updateUI ) {
        //新建线程，发出请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                httpHandler.getMeiZiUrl(d, new HttpFinish() {
                    @Override
                    public void onSuccess(String text) {
                        MeiZi meiZi = dataToBean.MeiZiJsonToBean(text);
                        final List<MeiZi.ResultsEntity> list = meiZi.getResults();
                        meiZiDB = MeiZiDB.getInstance(MyApplication.getContext());
                        final List l = analyseURLFromBean(list);
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                updateUI.updateList(l);
                            }
                        });
                        //保存数据库
                        meiZiDB.saveResultsEntity(list, d);
                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });
            }
        }).start();


    }

    /**
     * 从bean获取URL,并返回url
     *
     * @param list
     * @return
     */
    public List analyseURLFromBean(List<MeiZi.ResultsEntity> list) {
        List<String> l = new ArrayList<String>();
        for (MeiZi.ResultsEntity resultsEntity : list) {
            l.add(resultsEntity.getUrl());
        }
        return l;
    }





    public static interface UpdateUI{
        void  updateList(List<String> url);
    }
}
