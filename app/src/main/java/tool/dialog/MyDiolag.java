package tool.dialog;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by bigwen on 2016/1/5.
 */
public class MyDiolag {
    private String TAG = MyDiolag.class.getName();
    private BaseDialog baseDialog;
    private MyView view;
    private TextView title;
    private TextView text;
    private TextView defaultBt;
    private TextView button_1;
    private TextView button_2;
    private LinearLayout linearLayout;
    private View.OnClickListener onClickListener;

    /**
     * 普通dialog，
     *
     * @param context
     * @param title           标题 null则隐藏标题
     * @param text            内容
     * @param params          按钮文字 null则隐藏
     * @param onClickListener 按钮监听
     */
    public void showDialog(Context context, String title, String text, String[] params, final View.OnClickListener onClickListener) {
        baseDialog = new BaseDialog(context);
        view = new MyView(context, params, onClickListener);
        this.onClickListener = onClickListener;
        this.title = view.getTitle();
        this.text = view.getText();
        this.defaultBt = view.getDefaultBt();
        this.button_1 = view.getButton_1();
        this.button_2 = view.getButton_2();
        this.linearLayout = view.getLinearLayout();
        baseDialog.showView(view);
        view.initButton(params);
        initOnListener();
        if (title == null) {
            this.title.setVisibility(View.GONE);
        } else {
            this.title.setText(title);
        }
        if (text == null) {
            this.text.setVisibility(View.GONE);
        } else {
            this.text.setText(text);
        }
        view.setKeyBack(new MyView.KeyBack() {
            @Override
            public void back() {
                hideView();
            }
        });
//        view.setOnKeyListener(new View.OnKeyListener() {
//
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                Log.i(TAG, "onKey ");
//                switch (keyCode) {
//                    case KeyEvent.KEYCODE_BACK:
//                        hideView();
//                        return true;
//                    default:
//                        return false;
//                }
//            }
//        });
    }

    private void initOnListener() {
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        defaultBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener != null) {
                    onClickListener.onClick(v);
                }
                hideView();
            }
        });
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener != null) {
                    onClickListener.onClick(v);
                }
                hideView();
            }
        });
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener != null) {
                    onClickListener.onClick(v);
                }
                hideView();
            }
        });
    }

    public void hideView() {
        baseDialog.cancel();
    }


}
