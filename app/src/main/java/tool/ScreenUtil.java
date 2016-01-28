package tool;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;

import java.lang.reflect.Field;

public class ScreenUtil {
    private static String TAG = ScreenUtil.class.getName();
  
    /** 
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素) 
     */  
    public static int dip2px(Context context, float dpValue) {  
        final float scale = context.getResources().getDisplayMetrics().density;  
        return (int) (dpValue * scale + 0.5f);  
    }  
  
    /** 
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp 
     */  
    public static int px2dip(Context context, float pxValue) {  
        final float scale = context.getResources().getDisplayMetrics().density;  
        return (int) (pxValue / scale + 0.5f);  
    }

    /**
     * 获取屏幕宽度
     * @param context
     * @return
     */
    public static int getScreenWidth(Context context){
        DisplayMetrics dm = new DisplayMetrics();
                ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }

    /**
     * 获取屏幕高度
     * @param context
     * @return
     */
    public static int getScreenHeight(Context context){
        DisplayMetrics dm = new DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.heightPixels;
    }

    public static int getStatusBerHeight(Context context){
        Class<?> c = null;
        Object o = null;
        Field field = null;
        int x= 0;
        int statusHeight = 0;
        try{
            c = Class.forName("com.android.internal.R$dimen");
            o = c.newInstance();
            field = c.getField("status_ber_height");
            x = Integer.parseInt(field.get(o).toString());
            statusHeight = context.getResources().getDimensionPixelSize(x);
        }catch (Exception e){
            Log.e(TAG, "getStatusBerHeight "+e.toString());
        }
        return statusHeight;
    }


} 