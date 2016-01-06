package handler;

import android.os.Handler;
import android.os.Looper;

import com.bcgtgjyb.mylibrary.base.MyDataBase;
import com.bcgtgjyb.mylibrary.base.bean.AndroidData;

import net.DataToBean;
import net.HttpCallBack;
import net.HttpHandler;

import java.util.List;

import tool.MyApplication;

/**
 * Created by bigwen on 2015/12/8.
 */
public class AndroidDataHandle {
    private HttpHandler httpHandler = new HttpHandler();
    private DataToBean dataToBean = new DataToBean();
    private Handler handler = new Handler(Looper.getMainLooper());
    private MyDataBase myDataBase;
    /**
     * 发出请求并保存数据库
     *
     * @param d 请求第几页
     */
    public void requestUrl(final int d, final UpdateUI updateUI) {
        //新建线程，发出请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                httpHandler.getAndroidDataUrl(d, new HttpCallBack() {
                    @Override
                    public void onSuccess(String text) {
                        AndroidData androidData1 = dataToBean.AndroidDataJsonToBean(text);
                        final List<AndroidData.ResultsEntity> list = androidData1.getResults();
                        myDataBase = MyDataBase.getInstence(MyApplication.getContext());
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                updateUI.updateList(list);
                            }
                        });
                        //保存数据库
                        for(AndroidData.ResultsEntity myModel:list) {
                            myModel.setCount(d+"");
                            myDataBase.saveBean(myModel);
                        }
                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });
            }
        }).start();
    }

    public interface UpdateUI {
        void updateList(List<AndroidData.ResultsEntity> url);
    }
}

