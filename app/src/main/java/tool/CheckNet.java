package tool;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by bigwen on 2015/12/10.
 */
public class CheckNet  {
    public static boolean isNetWork(Context context){
        ConnectivityManager connectivityManager=(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager==null){
            return false;
        }else {
            NetworkInfo[] networkInfos=connectivityManager.getAllNetworkInfo();
            if(networkInfos!=null&&networkInfos.length>0){
                for (int i=0;i<networkInfos.length;i++){
                    //判断网络是否连接
                    if(networkInfos[i].getState()==NetworkInfo.State.CONNECTED){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
