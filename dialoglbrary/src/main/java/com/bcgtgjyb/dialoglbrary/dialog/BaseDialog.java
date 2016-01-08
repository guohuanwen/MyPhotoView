package com.bcgtgjyb.dialoglbrary.dialog;

import android.content.Context;
import android.graphics.PixelFormat;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

/**
 * Created by bigwen on 2016/1/5.
 */
public class BaseDialog{
    private Context mContext;
    private WindowManager windowManager;
    private View view;

    public BaseDialog(Context mContext) {
        this.mContext = mContext;
        init();
    }

    public void init() {
        windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
    }

    public void showView(View view) {
        this.view = view;
        this.view.setFocusable(true);
        this.view.setFocusableInTouchMode(true);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_SUB_PANEL ,
                WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM,
                PixelFormat.TRANSLUCENT);
        lp.softInputMode |=
                WindowManager.LayoutParams.SOFT_INPUT_IS_FORWARD_NAVIGATION;
        windowManager.addView(view,lp);
//        SharePrefenceIO.saveSharePreference("Dialog","1","MYDIALOG");
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });
    }


    public void cancel() {
        if (view != null) {
            windowManager.removeView(view);
        }
    }

}
